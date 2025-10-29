package com.cmbchina.payment.service;

import com.cmbchina.payment.client.HttpClient;
import com.cmbchina.payment.config.PaymentConfig;
import com.cmbchina.payment.model.*;
import com.cmbchina.payment.util.SignUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 招商银行聚合支付服务
 */
public class CmbPaymentService {
    
    private static final Logger logger = LoggerFactory.getLogger(CmbPaymentService.class);
    
    private final PaymentConfig config;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    
    // API端点
    private static final String PAYMENT_URL = "/api/v1/payment/create";
    private static final String QUERY_URL = "/api/v1/payment/query";
    private static final String REFUND_URL = "/api/v1/payment/refund";
    private static final String REFUND_QUERY_URL = "/api/v1/payment/refund/query";
    
    public CmbPaymentService(PaymentConfig config) {
        this.config = config;
        this.httpClient = new HttpClient(config);
        this.objectMapper = new ObjectMapper();
    }
    
    /**
     * 创建支付订单
     */
    public PaymentResponse createPayment(PaymentRequest request) {
        try {
            // 设置商户ID
            if (request.getMerchantId() == null) {
                request.setMerchantId(config.getMerchantId());
            }
            
            // 构建签名参数
            Map<String, Object> signParams = buildSignParams(request);
            String sign = SignUtil.rsaSign(SignUtil.buildSignString(signParams), config.getPrivateKey());
            signParams.put("sign", sign);
            signParams.put("sign_type", config.getSignType());
            
            // 发送请求
            String url = config.getApiUrl() + PAYMENT_URL;
            PaymentResponse response = httpClient.post(url, signParams, PaymentResponse.class);
            
            logger.info("创建支付订单成功，商户订单号: {}, 交易号: {}", 
                       request.getOutTradeNo(), response.getTradeNo());
            
            return response;
            
        } catch (Exception e) {
            logger.error("创建支付订单失败", e);
            throw new RuntimeException("创建支付订单失败", e);
        }
    }
    
    /**
     * 查询支付订单
     */
    public PaymentResponse queryPayment(QueryRequest request) {
        try {
            // 设置商户ID
            if (request.getMerchantId() == null) {
                request.setMerchantId(config.getMerchantId());
            }
            
            // 构建签名参数
            Map<String, Object> signParams = buildSignParams(request);
            String sign = SignUtil.rsaSign(SignUtil.buildSignString(signParams), config.getPrivateKey());
            signParams.put("sign", sign);
            signParams.put("sign_type", config.getSignType());
            
            // 发送请求
            String url = config.getApiUrl() + QUERY_URL;
            PaymentResponse response = httpClient.post(url, signParams, PaymentResponse.class);
            
            logger.info("查询支付订单成功，商户订单号: {}, 交易状态: {}", 
                       request.getOutTradeNo(), response.getTradeStatus());
            
            return response;
            
        } catch (Exception e) {
            logger.error("查询支付订单失败", e);
            throw new RuntimeException("查询支付订单失败", e);
        }
    }
    
    /**
     * 申请退款
     */
    public RefundResponse createRefund(RefundRequest request) {
        try {
            // 设置商户ID
            if (request.getMerchantId() == null) {
                request.setMerchantId(config.getMerchantId());
            }
            
            // 构建签名参数
            Map<String, Object> signParams = buildSignParams(request);
            String sign = SignUtil.rsaSign(SignUtil.buildSignString(signParams), config.getPrivateKey());
            signParams.put("sign", sign);
            signParams.put("sign_type", config.getSignType());
            
            // 发送请求
            String url = config.getApiUrl() + REFUND_URL;
            RefundResponse response = httpClient.post(url, signParams, RefundResponse.class);
            
            logger.info("申请退款成功，商户退款单号: {}, 退款状态: {}", 
                       request.getOutRefundNo(), response.getRefundStatus());
            
            return response;
            
        } catch (Exception e) {
            logger.error("申请退款失败", e);
            throw new RuntimeException("申请退款失败", e);
        }
    }
    
    /**
     * 查询退款订单
     */
    public RefundResponse queryRefund(QueryRequest request) {
        try {
            // 设置商户ID
            if (request.getMerchantId() == null) {
                request.setMerchantId(config.getMerchantId());
            }
            
            // 构建签名参数
            Map<String, Object> signParams = buildSignParams(request);
            String sign = SignUtil.rsaSign(SignUtil.buildSignString(signParams), config.getPrivateKey());
            signParams.put("sign", sign);
            signParams.put("sign_type", config.getSignType());
            
            // 发送请求
            String url = config.getApiUrl() + REFUND_QUERY_URL;
            RefundResponse response = httpClient.post(url, signParams, RefundResponse.class);
            
            logger.info("查询退款订单成功，商户订单号: {}", request.getOutTradeNo());
            
            return response;
            
        } catch (Exception e) {
            logger.error("查询退款订单失败", e);
            throw new RuntimeException("查询退款订单失败", e);
        }
    }
    
    /**
     * 验证异步通知签名
     */
    public boolean verifyNotify(NotifyRequest notifyRequest) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("merchant_id", notifyRequest.getMerchantId());
            params.put("trade_no", notifyRequest.getTradeNo());
            params.put("out_trade_no", notifyRequest.getOutTradeNo());
            params.put("total_amount", notifyRequest.getTotalAmount());
            params.put("trade_status", notifyRequest.getTradeStatus());
            params.put("payment_type", notifyRequest.getPaymentType());
            params.put("create_time", notifyRequest.getCreateTime());
            params.put("pay_time", notifyRequest.getPayTime());
            
            String signContent = SignUtil.buildSignString(params);
            return SignUtil.rsaVerify(signContent, notifyRequest.getSign(), config.getPublicKey());
            
        } catch (Exception e) {
            logger.error("验证异步通知签名失败", e);
            return false;
        }
    }
    
    /**
     * 构建签名参数
     */
    private Map<String, Object> buildSignParams(Object request) {
        return objectMapper.convertValue(request, Map.class);
    }
    
    /**
     * 关闭服务
     */
    public void close() {
        if (httpClient != null) {
            httpClient.close();
        }
    }
}