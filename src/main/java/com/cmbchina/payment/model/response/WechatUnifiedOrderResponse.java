package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信统一下单响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class WechatUnifiedOrderResponse extends BaseResponse {
    
    /**
     * 商户号
     */
    @JsonProperty("mer_id")
    private String merId;
    
    /**
     * 商户订单号
     */
    @JsonProperty("order_id")
    private String orderId;
    
    /**
     * 平台订单号
     */
    @JsonProperty("tn_order_id")
    private String tnOrderId;
    
    /**
     * 预支付交易会话标识
     */
    @JsonProperty("prepay_id")
    private String prepayId;
    
    /**
     * 二维码链接（NATIVE支付时返回）
     */
    @JsonProperty("code_url")
    private String codeUrl;
    
    /**
     * 支付跳转链接（MWEB支付时返回）
     */
    @JsonProperty("mweb_url")
    private String mwebUrl;
    
    /**
     * 订单状态
     */
    @JsonProperty("order_stat")
    private String orderStat;
    
    /**
     * 订单金额（分）
     */
    @JsonProperty("order_amt")
    private Long orderAmt;
    
    /**
     * 订单创建时间
     */
    @JsonProperty("order_date")
    private String orderDate;
    
    /**
     * 订单有效期至
     */
    @JsonProperty("expire_time")
    private String expireTime;
    
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
    
    public String getTnOrderId() {
        return tnOrderId;
    }
    
    public void setTnOrderId(String tnOrderId) {
        this.tnOrderId = tnOrderId;
    }
    
    public String getPrepayId() {
        return prepayId;
    }
    
    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }
    
    public String getCodeUrl() {
        return codeUrl;
    }
    
    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }
    
    public String getMwebUrl() {
        return mwebUrl;
    }
    
    public void setMwebUrl(String mwebUrl) {
        this.mwebUrl = mwebUrl;
    }
    
    public String getOrderStat() {
        return orderStat;
    }
    
    public void setOrderStat(String orderStat) {
        this.orderStat = orderStat;
    }
    
    public Long getOrderAmt() {
        return orderAmt;
    }
    
    public void setOrderAmt(Long orderAmt) {
        this.orderAmt = orderAmt;
    }
    
    public String getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
    public String getExpireTime() {
        return expireTime;
    }
    
    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }
}