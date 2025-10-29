package com.cmbchina.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * 退款请求模型
 */
public class RefundRequest {
    
    @JsonProperty("merchant_id")
    private String merchantId;
    
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    
    @JsonProperty("trade_no")
    private String tradeNo;
    
    @JsonProperty("out_refund_no")
    private String outRefundNo;
    
    @JsonProperty("refund_amount")
    private BigDecimal refundAmount;
    
    @JsonProperty("refund_reason")
    private String refundReason;
    
    @JsonProperty("notify_url")
    private String notifyUrl;
    
    // 构造函数
    public RefundRequest() {}
    
    public RefundRequest(String merchantId, String outTradeNo, String outRefundNo, 
                        BigDecimal refundAmount, String refundReason) {
        this.merchantId = merchantId;
        this.outTradeNo = outTradeNo;
        this.outRefundNo = outRefundNo;
        this.refundAmount = refundAmount;
        this.refundReason = refundReason;
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
    
    public String getTradeNo() {
        return tradeNo;
    }
    
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    
    public String getOutRefundNo() {
        return outRefundNo;
    }
    
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }
    
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }
    
    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }
    
    public String getRefundReason() {
        return refundReason;
    }
    
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }
    
    public String getNotifyUrl() {
        return notifyUrl;
    }
    
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}