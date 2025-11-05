package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 关闭订单响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class CloseOrderResponse extends BaseResponse {
    
    /**
     * 商户号（returnCode为SUCCESS时返回）
     * 请求报文中的商户号
     */
    @JsonProperty("merId")
    private String merId;
    
    /**
     * 商户订单号（returnCode为SUCCESS时返回，可选）
     * 请求报文中的商户订单号，若有则返回
     */
    @JsonProperty("origOrderId")
    private String origOrderId;
    
    /**
     * 外部商户订单号（returnCode为SUCCESS时返回，可选）
     * 请求报文中的外部商户订单号，若有则返回
     */
    @JsonProperty("origOutOrderId")
    private String origOutOrderId;
    
    /**
     * 第三方错误描述（returnCode为SUCCESS时返回，可选）
     * 关单交易在第三方处理失败时返回第三方的错误信息
     */
    @JsonProperty("errDescription")
    private String errDescription;
    
    /**
     * 关单处理状态（returnCode和respCode为SUCCESS时返回）
     * C - 订单关闭成功
     * F - 被关闭交易为失败状态，关单失败
     */
    @JsonProperty("closeState")
    private String closeState;
    
    /**
     * 订单发送时间（returnCode和respCode为SUCCESS时返回）
     * 关闭订单申请处理时间，格式为yyyyMMddHHmmss
     */
    @JsonProperty("txnTime")
    private String txnTime;
    
    public String getMerId() {
        return merId;
    }
    
    public void setMerId(String merId) {
        this.merId = merId;
    }
    
    public String getOrigOrderId() {
        return origOrderId;
    }
    
    public void setOrigOrderId(String origOrderId) {
        this.origOrderId = origOrderId;
    }
    
    public String getOrigOutOrderId() {
        return origOutOrderId;
    }
    
    public void setOrigOutOrderId(String origOutOrderId) {
        this.origOutOrderId = origOutOrderId;
    }
    
    public String getErrDescription() {
        return errDescription;
    }
    
    public void setErrDescription(String errDescription) {
        this.errDescription = errDescription;
    }
    
    public String getCloseState() {
        return closeState;
    }
    
    public void setCloseState(String closeState) {
        this.closeState = closeState;
    }
    
    public String getTxnTime() {
        return txnTime;
    }
    
    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }
}
