package com.cmbchina.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 支付请求模型
 */
public class PaymentRequest {
    
    @JsonProperty("merchant_id")
    private String merchantId;
    
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    
    @JsonProperty("total_amount")
    private BigDecimal totalAmount;
    
    @JsonProperty("subject")
    private String subject;
    
    @JsonProperty("body")
    private String body;
    
    @JsonProperty("notify_url")
    private String notifyUrl;
    
    @JsonProperty("return_url")
    private String returnUrl;
    
    @JsonProperty("payment_type")
    private String paymentType; // WECHAT, ALIPAY, UNIONPAY
    
    @JsonProperty("expire_time")
    private LocalDateTime expireTime;
    
    @JsonProperty("extra_params")
    private String extraParams;
    
    // 构造函数
    public PaymentRequest() {}
    
    public PaymentRequest(String merchantId, String outTradeNo, BigDecimal totalAmount, 
                         String subject, String body, String notifyUrl, String paymentType) {
        this.merchantId = merchantId;
        this.outTradeNo = outTradeNo;
        this.totalAmount = totalAmount;
        this.subject = subject;
        this.body = body;
        this.notifyUrl = notifyUrl;
        this.paymentType = paymentType;
    }
    
    // Getter和Setter方法
    public String getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
    
    public String getOutTradeNo() {
        return outTradeNo;
    }
    
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getBody() {
        return body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    
    public String getNotifyUrl() {
        return notifyUrl;
    }
    
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    
    public String getReturnUrl() {
        return returnUrl;
    }
    
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
    
    public String getPaymentType() {
        return paymentType;
    }
    
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    public LocalDateTime getExpireTime() {
        return expireTime;
    }
    
    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
    
    public String getExtraParams() {
        return extraParams;
    }
    
    public void setExtraParams(String extraParams) {
        this.extraParams = extraParams;
    }
}