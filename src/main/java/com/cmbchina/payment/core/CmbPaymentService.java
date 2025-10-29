package com.cmbchina.payment.core;

import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.crypto.SignatureUtil;
import com.cmbchina.payment.exception.CmbPaymentException;
import com.cmbchina.payment.model.BaseRequest;
import com.cmbchina.payment.model.BaseResponse;
import com.cmbchina.payment.model.request.*;
import com.cmbchina.payment.model.response.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * 招商银行支付核心服务类
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class CmbPaymentService {
    
    private static final Logger logger = LoggerFactory.getLogger(CmbPaymentService.class);
    
    private final CmbPaymentConfig config;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    
    public CmbPaymentService(CmbPaymentConfig config) {
        this.config = config;
        this.restTemplate = createRestTemplate();
        this.objectMapper = new ObjectMapper();
    }
    
    /**
     * 收款码申请
     */
    public QrCodeApplyResponse qrCodeApply(QrCodeApplyRequest request) throws CmbPaymentException {
        return executeRequest("/polypay/v1.0/mchorders/qrcodeapply", request, QrCodeApplyResponse.class);
    }
    
    /**
     * 订单查询
     */
    public OrderQueryResponse orderQuery(OrderQueryRequest request) throws CmbPaymentException {
        return executeRequest("/polypay/v1.0/mchorders/orderquery", request, OrderQueryResponse.class);
    }
    
    /**
     * 付款码收款
     */
    public PaymentResponse pay(PaymentRequest request) throws CmbPaymentException {
        return executeRequest("/polypay/v1.0/mchorders/pay", request, PaymentResponse.class);
    }
    
    /**
     * 微信统一下单
     */
    public WechatUnifiedOrderResponse wechatUnifiedOrder(WechatUnifiedOrderRequest request) throws CmbPaymentException {
        return executeRequest("/polypay/v1.0/mchorders/onlinepay", request, WechatUnifiedOrderResponse.class);
    }
    
    /**
     * 支付宝服务窗支付
     */
    public AlipayServiceResponse alipayService(AlipayServiceRequest request) throws CmbPaymentException {
        return executeRequest("/polypay/v1.0/mchorders/servpay", request, AlipayServiceResponse.class);
    }
    
    /**
     * 退款申请
     */
    public RefundResponse refund(RefundRequest request) throws CmbPaymentException {
        return executeRequest("/polypay/v1.0/mchorders/refund", request, RefundResponse.class);
    }
    
    /**
     * 退款查询
     */
    public RefundQueryResponse refundQuery(RefundQueryRequest request) throws CmbPaymentException {
        return executeRequest("/polypay/v1.0/mchorders/refundquery", request, RefundQueryResponse.class);
    }
    
    /**
     * 关闭订单
     */
    public CloseOrderResponse closeOrder(CloseOrderRequest request) throws CmbPaymentException {
        return executeRequest("/polypay/v1.0/mchorders/close", request, CloseOrderResponse.class);
    }
    
    /**
     * 撤销订单
     */
    public CancelResponse cancel(CancelRequest request) throws CmbPaymentException {
        return executeRequest("/polypay/v1.0/mchorders/cancel", request, CancelResponse.class);
    }
    
    /**
     * 获取对账单下载地址
     */
    public StatementResponse getStatementUrl(StatementRequest request) throws CmbPaymentException {
        return executeRequest("/polypay/v1.0/mchorders/statementurl", request, StatementResponse.class);
    }
    
    /**
     * 验证回调通知签名
     */
    public boolean verifyNotify(String notifyData) {
        try {
            Map<String, String> notifyMap = SignatureUtil.parseQueryString(notifyData);
            String sign = notifyMap.remove("sign");
            
            if (sign == null) {
                logger.error("回调通知缺少签名");
                return false;
            }
            
            String content = SignatureUtil.getSignContent(notifyMap);
            return SignatureUtil.sm2Verify(content, sign, config.getPublicKey());
        } catch (Exception e) {
            logger.error("验证回调通知签名失败", e);
            return false;
        }
    }
    
    /**
     * 处理回调通知
     */
    public NotifyResponse handleNotify(String notifyData) throws CmbPaymentException {
        try {
            Map<String, String> notifyMap = SignatureUtil.parseQueryString(notifyData);
            return objectMapper.convertValue(notifyMap, NotifyResponse.class);
        } catch (Exception e) {
            logger.error("处理回调通知失败", e);
            throw new CmbPaymentException("NOTIFY_PARSE_ERROR", "处理回调通知失败", e);
        }
    }
    
    /**
     * 执行请求
     */
    private <T extends BaseResponse> T executeRequest(String endpoint, BaseRequest request, Class<T> responseClass) 
            throws CmbPaymentException {
        try {
            // 设置基础参数
            request.setVersion(config.getVersion());
            request.setEncoding(config.getEncoding());
            request.setSignMethod(config.getSignMethod());
            
            // 生成签名
            String requestJson = objectMapper.writeValueAsString(request);
            Map<String, String> requestMap = objectMapper.readValue(requestJson, Map.class);
            requestMap.remove("sign"); // 移除sign字段
            
            String signContent = SignatureUtil.getSignContent(requestMap);
            String sign = SignatureUtil.sm2Sign(signContent, config.getPrivateKey());
            request.setSign(sign);
            
            // 生成API签名
            long timestamp = System.currentTimeMillis() / 1000;
            String apiSign = SignatureUtil.generateApiSign(
                config.getAppId(), 
                config.getAppSecret(), 
                sign, 
                timestamp
            );
            
            // 构建请求头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("appid", config.getAppId());
            headers.set("timestamp", String.valueOf(timestamp));
            headers.set("apisign", apiSign);
            
            // 发送请求
            String finalRequestJson = objectMapper.writeValueAsString(request);
            HttpEntity<String> entity = new HttpEntity<>(finalRequestJson, headers);
            
            String url = config.getApiUrl() + endpoint;
            logger.info("发送请求到: {}", url);
            logger.debug("请求内容: {}", finalRequestJson);
            
            ResponseEntity<T> response = restTemplate.postForEntity(url, entity, responseClass);
            
            logger.info("响应状态: {}", response.getStatusCode());
            logger.debug("响应内容: {}", response.getBody());
            
            return response.getBody();
            
        } catch (Exception e) {
            logger.error("执行请求失败: endpoint={}", endpoint, e);
            throw new CmbPaymentException("REQUEST_ERROR", "执行请求失败: " + e.getMessage(), e);
        }
    }
    
    /**
     * 创建RestTemplate
     */
    private RestTemplate createRestTemplate() {
        RestTemplate template = new RestTemplate();
        
        // 设置超时时间
        template.getRequestFactory().setConnectTimeout(Duration.ofMillis(config.getConnectTimeout()));
        template.getRequestFactory().setReadTimeout(Duration.ofMillis(config.getReadTimeout()));
        
        return template;
    }
}
