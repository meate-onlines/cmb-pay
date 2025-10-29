package com.cmbchina.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 支付响应模型
 */
public class PaymentResponse {
    
    @JsonProperty("code")
    private String code;
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("trade_no")
    private String tradeNo;
    
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    
    @JsonProperty("total_amount")
    private BigDecimal totalAmount;
    
    @JsonProperty("trade_status")
    private String tradeStatus;
    
    @JsonProperty("pay_url")
    private String payUrl;
    
    @JsonProperty("qr_code")
    private String qrCode;
    
    @JsonProperty("create_time")
    private LocalDateTime createTime;
    
    @JsonProperty("pay_time")
    private LocalDateTime payTime;
    
    @JsonProperty("extra_params")
    private String extraParams;
    
    // 构造函数
    public PaymentResponse() {}
    
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
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getTradeStatus() {
        return tradeStatus;
    }
    
    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }
    
    public String getPayUrl() {
        return payUrl;
    }
    
    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }
    
    public String getQrCode() {
        return qrCode;
    }
    
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    public LocalDateTime getPayTime() {
        return payTime;
    }
    
    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }
    
    public String getExtraParams() {
        return extraParams;
    }
    
    public void setExtraParams(String extraParams) {
        this.extraParams = extraParams;
    }
    
    /**
     * 判断是否成功
     */
    public boolean isSuccess() {
        return "SUCCESS".equals(code);
    }
}