package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 支付宝Native支付响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class AlipayNativeOrderResponse extends BaseResponse {
    
    /**
     * 商户号（returnCode为SUCCESS时返回）
     */
    @JsonProperty("merId")
    private String merId;
    
    /**
     * 商户订单号（returnCode为SUCCESS时返回）
     */
    @JsonProperty("orderId")
    private String orderId;
    
    /**
     * 第三方错误描述（returnCode为SUCCESS时返回）
     */
    @JsonProperty("errDescription")
    private String errDescription;
    
    /**
     * 二维码（returnCode和respCode为SUCCESS时返回）
     * 唤起支付宝支付使用(当前下单请求生成的二维码码串，可以用二维码生成工具根据该码串值生成对应的二维码)
     */
    @JsonProperty("qrCode")
    private String qrCode;
    
    /**
     * 平台订单号（returnCode和respCode为SUCCESS时返回）
     * 招行生成的订单号
     */
    @JsonProperty("cmbOrderId")
    private String cmbOrderId;
    
    /**
     * 订单发送时间（returnCode和respCode为SUCCESS时返回）
     * 订单生成时间，格式为yyyyMMddHHmmss
     */
    @JsonProperty("txnTime")
    private String txnTime;
    
    public String getMerId() {
        return merId;
    }
    
    public void setMerId(String merId) {
        this.merId = merId;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getErrDescription() {
        return errDescription;
    }
    
    public void setErrDescription(String errDescription) {
        this.errDescription = errDescription;
    }
    
    public String getQrCode() {
        return qrCode;
    }
    
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
    
    public String getCmbOrderId() {
        return cmbOrderId;
    }
    
    public void setCmbOrderId(String cmbOrderId) {
        this.cmbOrderId = cmbOrderId;
    }
    
    public String getTxnTime() {
        return txnTime;
    }
    
    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }
}

