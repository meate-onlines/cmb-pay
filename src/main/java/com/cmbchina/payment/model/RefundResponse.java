package com.cmbchina.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 退款响应模型
 */
public class RefundResponse {
    
    @JsonProperty("code")
    private String code;
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("refund_no")
    private String refundNo;
    
    @JsonProperty("out_refund_no")
    private String outRefundNo;
    
    @JsonProperty("trade_no")
    private String tradeNo;
    
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    
    @JsonProperty("refund_amount")
    private BigDecimal refundAmount;
    
    @JsonProperty("refund_status")
    private String refundStatus;
    
    @JsonProperty("create_time")
    private LocalDateTime createTime;
    
    @JsonProperty("refund_time")
    private LocalDateTime refundTime;
    
    // 构造函数
    public RefundResponse() {}
    
    // Getter和Setter方法
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getRefundNo() {
        return refundNo;
    }
    
    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }
    
    public String getOutRefundNo() {
        return outRefundNo;
    }
    
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }
    
    public String getTradeNo() {
        return tradeNo;
    }
    
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    
    public String getOutTradeNo() {
        return outTradeNo;
    }
    
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
    
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }
    
    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }
    
    public String getRefundStatus() {
        return refundStatus;
    }
    
    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    public LocalDateTime getRefundTime() {
        return refundTime;
    }
    
    public void setRefundTime(LocalDateTime refundTime) {
        this.refundTime = refundTime;
    }
    
    /**
     * 判断是否成功
     */
    public boolean isSuccess() {
        return "SUCCESS".equals(code);
    }
}