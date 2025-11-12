package com.cmbchina.payment.core;

import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.crypto.SignatureUtil;
import com.cmbchina.payment.exception.CmbPaymentException;
import com.cmbchina.payment.util.HttpLoggingUtil;
import com.cmbchina.payment.model.BaseRequest;
import com.cmbchina.payment.model.BaseResponse;
import com.cmbchina.payment.model.request.*;
import com.cmbchina.payment.model.response.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

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
        // 配置忽略未知属性，用于处理通知数据
        this.objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * 构建回调通知返回
     * @param returnCode 返回码
     * @return 回调通知返回
     */
    public Map<String, String> buildNotifyResponse(String returnCode) {
        Map<String, String> response = new HashMap<>();
        //设置响应数据
        response.put("version", config.getVersion());//版本号，固定为0.0.1(必传)
        response.put("encoding", config.getEncoding());//编码方式，固定为UTF-8(必传)
        response.put("signMethod", config.getSignMethod());//签名方法，固定为02，国密
        response.put("returnCode", returnCode);//返回码，SUCCESS/FAIL
        response.put("respCode", returnCode.equals("SUCCESS") ? "SUCCESS" : "FAIL");//响应码，成功为SUCCESS，失败为FAIL
        response.put("respMsg", returnCode.equals("SUCCESS") ? "SUCCESS" : "FAIL");//应答信息，成功为SUCCESS，失败为FAIL
        response.put("sign", SignatureUtil.sm2Sign(SignatureUtil.getSignContent(response), config.getPrivateKey()));//签名
        return response;
    }
    
    /**
     * 处理回调通知
     */
    public NotifyResponse handleNotify(String notifyData) throws CmbPaymentException {
        try {
            Map<String, String> notifyMap = SignatureUtil.parseQueryString(notifyData);
            String bizContent = notifyMap.get("biz_content");
            if (bizContent == null) {
                throw new CmbPaymentException("NOTIFY_PARSE_ERROR", "回调通知缺少biz_content字段");
            }
            // biz_content是JSON字符串，需要使用readValue解析
            return objectMapper.readValue(bizContent, NotifyResponse.class);
        } catch (Exception e) {
            logger.error("处理回调通知失败", e);
            throw new CmbPaymentException("NOTIFY_PARSE_ERROR", "处理回调通知失败", e);
        }
    }

    /**
     * 处理退款回调通知
     */
    public RefundCallbackResponse handleRefundNotify(String notifyData) throws CmbPaymentException {
        try {
            Map<String, String> notifyMap = SignatureUtil.parseQueryString(notifyData);
            String bizContent = notifyMap.get("biz_content");
            if (bizContent == null) {
                throw new CmbPaymentException("REFUND_NOTIFY_PARSE_ERROR", "退款回调通知缺少biz_content字段");
            }
            // biz_content是JSON字符串，需要使用readValue解析
            return objectMapper.readValue(bizContent, RefundCallbackResponse.class);
        } catch (Exception e) {
            logger.error("处理退款回调通知失败", e);
            throw new CmbPaymentException("REFUND_NOTIFY_PARSE_ERROR", "处理退款回调通知失败", e);
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
            
            // 提取业务参数并序列化为JSON字符串
            Map<String, Object> bizContentMap = extractBizContent(request);
            String bizContentJson = objectMapper.writeValueAsString(bizContentMap);
            logger.debug("bizContentJson: {}", bizContentJson);
            request.setBizContent(bizContentJson);
            
            // 构建签名参数Map（使用小驼峰命名）
            Map<String, String> signMap = buildSignMap(request);
            
            // 生成签名
            String signContent = SignatureUtil.getSignContent(signMap);
            logger.debug("签名内容: {}", signContent);
            String sign = SignatureUtil.sm2Sign(signContent, config.getPrivateKey());
            logger.debug("签名: {}", sign);
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
            
            // 构建最终请求体（使用小驼峰命名）
            Map<String, Object> requestBody = buildRequestBody(request);
            String finalRequestJson = objectMapper.writeValueAsString(requestBody);
            HttpEntity<String> entity = new HttpEntity<>(finalRequestJson, headers);
            
            String url = config.getApiUrl() + endpoint;
            logger.info("发送请求到: {}", url);
            logger.debug("请求内容: {}", finalRequestJson);
            
            // 先接收原始响应字符串，用于验签
            ResponseEntity<String> stringResponse = restTemplate.postForEntity(url, entity, String.class);
            
            logger.info("响应状态: {}", stringResponse.getStatusCode());
            String responseBodyStr = stringResponse.getBody();
            logger.debug("响应内容: {}", responseBodyStr);

            // 验证响应签名（使用原始响应体字符串）
            boolean isValid = cheackResponseSign(responseBodyStr);
            if (!isValid) {
                logger.error("响应签名验证失败");
                throw new CmbPaymentException("RESPONSE_SIGN_ERROR", "响应签名验证失败");
            }
            
            // 验签通过后，将响应体反序列化为目标类型
            // 先解析响应JSON，提取biz_content并合并到顶层
            String flattenedJson = flattenBizContent(responseBodyStr);
            T response = objectMapper.readValue(flattenedJson, responseClass);
            logger.info("平铺后的响应: {}", objectMapper.writeValueAsString(response));
            return response;
            
        } catch (Exception e) {
            logger.error("执行请求失败: endpoint={}", endpoint, e);
            throw new CmbPaymentException("REQUEST_ERROR", "执行请求失败: " + e.getMessage(), e);
        }
    }
    
    /**
     * 创建RestTemplate
     */
    private RestTemplate createRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout((int) config.getConnectTimeout());
        factory.setReadTimeout((int) config.getReadTimeout());
        
        RestTemplate restTemplate = new RestTemplate(factory);
        // 添加HTTP日志拦截器，用于打印请求和响应的原始数据流
        restTemplate.getInterceptors().add(HttpLoggingUtil.createLoggingInterceptor());
        
        return restTemplate;
    }

    private Map<String, Object> extractBizContent(BaseRequest request) {
        try {
            java.lang.reflect.Method method = request.getClass().getMethod("getBizContentMap");
            @SuppressWarnings("unchecked")
            Map<String, Object> bizContent = (Map<String, Object>) method.invoke(request);
            return bizContent != null ? bizContent : new HashMap<>();
        } catch (Exception e) {
            logger.error("提取业务参数失败", e);
            return new HashMap<>();
        }
    }

    private Map<String, String> buildSignMap(BaseRequest request) {
        Map<String, String> signMap = new HashMap<>();
        signMap.put("version", request.getVersion());
        signMap.put("encoding", request.getEncoding());
        signMap.put("signMethod", request.getSignMethod());
        signMap.put("biz_content", request.getBizContent());
        return signMap;
    }

    private Map<String, Object> buildRequestBody(BaseRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("version", request.getVersion());
        body.put("encoding", request.getEncoding());
        body.put("signMethod", request.getSignMethod());
        body.put("biz_content", request.getBizContent());
        body.put("sign", request.getSign());
        return body;
    }

    private boolean cheackResponseSign(String responseJson) {
        try {
            // 直接使用原始响应JSON字符串解析，避免序列化时添加额外字段
            @SuppressWarnings("unchecked")
            Map<String, String> responseBodyMap = objectMapper.readValue(responseJson, Map.class);
            String sign = responseBodyMap.remove("sign");
            logger.info("待验签的内容: {}", responseBodyMap);
            String content = SignatureUtil.getSignContent(responseBodyMap);
            return SignatureUtil.sm2Verify(content, sign, config.getPublicKey());
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            logger.error("验证响应签名失败", e);
            return false;
        }
    }
    
    /**
     * 将响应JSON中的biz_content字段展开到顶层
     * 例如：{"version":"0.0.1","biz_content":"{\"merId\":\"123\"}"} 
     *      转换为：{"version":"0.0.1","merId":"123"}
     * 
     * @param responseJson 原始响应JSON字符串
     * @return 展开后的JSON字符串
     */
    private String flattenBizContent(String responseJson) {
        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> responseMap = objectMapper.readValue(responseJson, Map.class);
            
            // 提取biz_content字段
            Object bizContentObj = responseMap.remove("biz_content");
            
            if (bizContentObj != null) {
                // biz_content是JSON字符串，需要解析
                String bizContentStr = bizContentObj.toString();
                if (bizContentStr.startsWith("{") && bizContentStr.endsWith("}")) {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> bizContentMap = objectMapper.readValue(bizContentStr, Map.class);
                    
                    // 将biz_content中的字段合并到顶层
                    responseMap.putAll(bizContentMap);
                }
            }
            
            // 将合并后的Map转换回JSON字符串
            return objectMapper.writeValueAsString(responseMap);
        } catch (Exception e) {
            logger.warn("展开biz_content失败，使用原始响应: {}", e.getMessage());
            // 如果解析失败，返回原始JSON
            return responseJson;
        }
    }

}
