package com.cmbchina.payment.core;

import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.crypto.SignatureUtil;
import com.cmbchina.payment.exception.CmbPaymentException;
import com.cmbchina.payment.model.BaseRequest;
import com.cmbchina.payment.model.BaseResponse;
import com.cmbchina.payment.model.request.*;
import com.cmbchina.payment.model.response.*;
import com.cmbchina.payment.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private final HttpClient httpClient;
    
    // API路径常量
    private static final String QR_CODE_APPLY_PATH = "/polypay/v1.0/mchorders/qrcodeapply";
    private static final String ORDER_QUERY_PATH = "/polypay/v1.0/mchorders/orderquery";
    private static final String PAYMENT_PATH = "/polypay/v1.0/mchorders/pay";
    private static final String WECHAT_UNIFIED_ORDER_PATH = "/polypay/v1.0/mchorders/onlinepay";
    private static final String ALIPAY_SERVICE_PATH = "/polypay/v1.0/mchorders/servpay";
    private static final String REFUND_PATH = "/polypay/v1.0/mchorders/refund";
    private static final String REFUND_QUERY_PATH = "/polypay/v1.0/mchorders/refundquery";
    private static final String CLOSE_ORDER_PATH = "/polypay/v1.0/mchorders/close";
    private static final String CANCEL_PATH = "/polypay/v1.0/mchorders/cancel";
    private static final String STATEMENT_PATH = "/polypay/v1.0/mchorders/statementurl";
    
    public CmbPaymentService(CmbPaymentConfig config) {
        this.config = config;
        this.httpClient = new HttpClient(config);
    }
    
    /**
     * 收款码申请
     */
    public QrCodeApplyResponse qrCodeApply(QrCodeApplyRequest request) throws CmbPaymentException {
        return executeRequest(QR_CODE_APPLY_PATH, request, QrCodeApplyResponse.class);
    }
    
    /**
     * 订单查询
     */
    public OrderQueryResponse orderQuery(OrderQueryRequest request) throws CmbPaymentException {
        return executeRequest(ORDER_QUERY_PATH, request, OrderQueryResponse.class);
    }
    
    /**
     * 付款码收款
     */
    public PaymentResponse pay(PaymentRequest request) throws CmbPaymentException {
        return executeRequest(PAYMENT_PATH, request, PaymentResponse.class);
    }
    
    /**
     * 微信统一下单
     */
    public WechatUnifiedOrderResponse wechatUnifiedOrder(WechatUnifiedOrderRequest request) throws CmbPaymentException {
        return executeRequest(WECHAT_UNIFIED_ORDER_PATH, request, WechatUnifiedOrderResponse.class);
    }
    
    /**
     * 支付宝服务窗支付
     */
    public AlipayServiceResponse alipayService(AlipayServiceRequest request) throws CmbPaymentException {
        return executeRequest(ALIPAY_SERVICE_PATH, request, AlipayServiceResponse.class);
    }
    
    /**
     * 退款申请
     */
    public RefundResponse refund(RefundRequest request) throws CmbPaymentException {
        return executeRequest(REFUND_PATH, request, RefundResponse.class);
    }
    
    /**
     * 退款查询
     */
    public RefundQueryResponse refundQuery(RefundQueryRequest request) throws CmbPaymentException {
        return executeRequest(REFUND_QUERY_PATH, request, RefundQueryResponse.class);
    }
    
    /**
     * 关闭订单
     */
    public CloseOrderResponse closeOrder(CloseOrderRequest request) throws CmbPaymentException {
        return executeRequest(CLOSE_ORDER_PATH, request, CloseOrderResponse.class);
    }
    
    /**
     * 付款码收款撤销
     */
    public CancelResponse cancel(CancelRequest request) throws CmbPaymentException {
        return executeRequest(CANCEL_PATH, request, CancelResponse.class);
    }
    
    /**
     * 对账单下载地址获取
     */
    public StatementResponse getStatementUrl(StatementRequest request) throws CmbPaymentException {
        return executeRequest(STATEMENT_PATH, request, StatementResponse.class);
    }
    
    /**
     * 验证回调通知签名
     */
    public boolean verifyNotify(String notifyData) {
        try {
            Map<String, String> params = SignatureUtil.parseQueryString(notifyData);
            String sign = params.remove("sign");
            
            if (sign == null || sign.trim().isEmpty()) {
                logger.error("回调通知签名为空");
                return false;
            }
            
            // 对参数进行URL解码
            Map<String, String> decodedParams = new HashMap<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                decodedParams.put(
                    SignatureUtil.decode(entry.getKey()), 
                    SignatureUtil.decode(entry.getValue())
                );
            }
            
            String content = SignatureUtil.getSignContent(decodedParams);
            return SignatureUtil.sm2Verify(content, sign, config.getPublicKey());
            
        } catch (Exception ex) {
            logger.error("验证回调通知签名失败", ex);
            return false;
        }
    }
    
    /**
     * 处理回调通知
     */
    public NotifyResponse handleNotify(String notifyData) throws CmbPaymentException {
        try {
            if (!verifyNotify(notifyData)) {
                throw new CmbPaymentException("VERIFY_FAIL", "回调通知验签失败");
            }
            
            Map<String, String> params = SignatureUtil.parseQueryString(notifyData);
            params.remove("sign"); // 移除签名字段
            
            // 对参数进行URL解码
            Map<String, String> decodedParams = new HashMap<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                decodedParams.put(
                    SignatureUtil.decode(entry.getKey()), 
                    SignatureUtil.decode(entry.getValue())
                );
            }
            
            // 转换为NotifyResponse对象
            String jsonStr = JsonUtil.toJson(decodedParams);
            return JsonUtil.fromJson(jsonStr, NotifyResponse.class);
            
        } catch (Exception ex) {
            logger.error("处理回调通知失败", ex);
            throw new CmbPaymentException("HANDLE_NOTIFY_FAIL", "处理回调通知失败", ex);
        }
    }
    
    /**
     * 执行请求的通用方法
     */
    private <T extends BaseResponse> T executeRequest(String path, BaseRequest request, Class<T> responseClass) throws CmbPaymentException {
        try {
            // 设置默认值
            if (request.getVersion() == null) {
                request.setVersion(config.getVersion());
            }
            if (request.getEncoding() == null) {
                request.setEncoding(config.getEncoding());
            }
            if (request.getSignMethod() == null) {
                request.setSignMethod(config.getSignMethod());
            }
            
            // 转换为Map进行签名
            String jsonStr = JsonUtil.toJson(request);
            Map<String, String> params = JsonUtil.fromJson(jsonStr, new TypeReference<Map<String, String>>() {});
            
            // 移除空值和sign字段
            params.entrySet().removeIf(entry -> entry.getValue() == null || entry.getValue().trim().isEmpty());
            params.remove("sign");
            
            // 生成签名
            String content = SignatureUtil.getSignContent(params);
            String sign = SignatureUtil.sm2Sign(content, config.getPrivateKey());
            request.setSign(sign);
            
            // 发送HTTP请求
            String url = config.getApiUrl() + path;
            String requestBody = JsonUtil.toJson(request);
            
            logger.info("发送请求: url={}, body={}", url, requestBody);
            
            String responseBody = httpClient.post(url, requestBody);
            
            logger.info("收到响应: body={}", responseBody);
            
            // 解析响应
            T response = JsonUtil.fromJson(responseBody, responseClass);
            
            // 验证响应签名
            if (!verifyResponseSign(response)) {
                throw new CmbPaymentException("VERIFY_FAIL", "响应签名验证失败");
            }
            
            return response;
            
        } catch (CmbPaymentException ex) {
            throw ex;
        } catch (Exception ex) {
            logger.error("执行请求失败: path={}", path, ex);
            throw new CmbPaymentException("REQUEST_FAIL", "请求执行失败", ex);
        }
    }
    
    /**
     * 验证响应签名
     */
    private boolean verifyResponseSign(BaseResponse response) {
        try {
            String sign = response.getSign();
            if (sign == null || sign.trim().isEmpty()) {
                logger.warn("响应签名为空，跳过验证");
                return true; // 某些接口可能不返回签名
            }
            
            // 转换为Map
            String jsonStr = JsonUtil.toJson(response);
            Map<String, String> params = JsonUtil.fromJson(jsonStr, new TypeReference<Map<String, String>>() {});
            
            // 移除空值和sign字段
            params.entrySet().removeIf(entry -> entry.getValue() == null || entry.getValue().trim().isEmpty());
            params.remove("sign");
            
            String content = SignatureUtil.getSignContent(params);
            return SignatureUtil.sm2Verify(content, sign, config.getPublicKey());
            
        } catch (Exception ex) {
            logger.error("验证响应签名失败", ex);
            return false;
        }
    }
}