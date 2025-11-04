package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;

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
    private String merId;
    
    /**
     * 商户订单号
     */
    private String orderId;
    
    /**
     * 平台订单号
     */
    private String tnOrderId;
    
    /**
     * 订单状态
     */
    private String orderStat;
    
    /**
     * 订单金额（分）
     */
    private String orderAmt;
    
    /**
     * 支付参数（用于调起支付）
     */
    private String payParams;
    
    /**
     * 预支付交易会话标识
     */
    private String prepayId;
    
    /**
     * 二维码链接（APP支付时返回）
     */
    private String qrCode;
    
    /**
     * 订单创建时间
     */
    private String orderDate;
    
    /**
     * 订单有效期至
     */
    private String expireTime;
    
    /**
     * 附加数据
     */
    private String attach;
    
    /**
     * 限制支付者
     */
    private String limitPayer;
    
    /**
     * 优惠详情
     */
    private String promotionDetail;
    
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
    
    public String getOrderStat() {
        return orderStat;
    }
    
    public void setOrderStat(String orderStat) {
        this.orderStat = orderStat;
    }
    
    public String getOrderAmt() {
        return orderAmt;
    }
    
    public void setOrderAmt(String orderAmt) {
        this.orderAmt = orderAmt;
    }
    
    public String getPayParams() {
        return payParams;
    }
    
    public void setPayParams(String payParams) {
        this.payParams = payParams;
    }
    
    public String getPrepayId() {
        return prepayId;
    }
    
    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }
    
    public String getQrCode() {
        return qrCode;
    }
    
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
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
    
    public String getAttach() {
        return attach;
    }
    
    public void setAttach(String attach) {
        this.attach = attach;
    }
    
    public String getLimitPayer() {
        return limitPayer;
    }
    
    public void setLimitPayer(String limitPayer) {
        this.limitPayer = limitPayer;
    }
    
    public String getPromotionDetail() {
        return promotionDetail;
    }
    
    public void setPromotionDetail(String promotionDetail) {
        this.promotionDetail = promotionDetail;
    }
}
