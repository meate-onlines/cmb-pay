package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;

/**
 * 订单查询响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class OrderQueryResponse extends BaseResponse {
    
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
     * 实付金额（分）
     */
    private String payAmt;
    
    /**
     * 优惠金额（分）
     */
    private String discountAmt;
    
    /**
     * 支付方式
     */
    private String payType;
    
    /**
     * 支付时间
     */
    private String payTime;
    
    /**
     * 第三方订单号
     */
    private String thirdOrderId;
    
    /**
     * 第三方流水号
     */
    private String thirdSerialNo;
    
    /**
     * 买家用户标识
     */
    private String buyerUserId;
    
    /**
     * 买家账号
     */
    private String buyerLogonId;
    
    /**
     * 附加数据
     */
    private String attach;
    
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
    
    public String getPayAmt() {
        return payAmt;
    }
    
    public void setPayAmt(String payAmt) {
        this.payAmt = payAmt;
    }
    
    public String getDiscountAmt() {
        return discountAmt;
    }
    
    public void setDiscountAmt(String discountAmt) {
        this.discountAmt = discountAmt;
    }
    
    public String getPayType() {
        return payType;
    }
    
    public void setPayType(String payType) {
        this.payType = payType;
    }
    
    public String getPayTime() {
        return payTime;
    }
    
    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }
    
    public String getThirdOrderId() {
        return thirdOrderId;
    }
    
    public void setThirdOrderId(String thirdOrderId) {
        this.thirdOrderId = thirdOrderId;
    }
    
    public String getThirdSerialNo() {
        return thirdSerialNo;
    }
    
    public void setThirdSerialNo(String thirdSerialNo) {
        this.thirdSerialNo = thirdSerialNo;
    }
    
    public String getBuyerUserId() {
        return buyerUserId;
    }
    
    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }
    
    public String getBuyerLogonId() {
        return buyerLogonId;
    }
    
    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }
    
    public String getAttach() {
        return attach;
    }
    
    public void setAttach(String attach) {
        this.attach = attach;
    }
}
