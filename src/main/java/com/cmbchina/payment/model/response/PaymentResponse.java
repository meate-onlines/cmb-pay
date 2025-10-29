package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 付款码收款响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class PaymentResponse extends BaseResponse {
    
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
     * 实付金额（分）
     */
    @JsonProperty("pay_amt")
    private Long payAmt;
    
    /**
     * 优惠金额（分）
     */
    @JsonProperty("discount_amt")
    private Long discountAmt;
    
    /**
     * 支付方式
     */
    @JsonProperty("pay_type")
    private String payType;
    
    /**
     * 支付时间
     */
    @JsonProperty("pay_time")
    private String payTime;
    
    /**
     * 第三方订单号
     */
    @JsonProperty("third_order_id")
    private String thirdOrderId;
    
    /**
     * 第三方流水号
     */
    @JsonProperty("third_serial_no")
    private String thirdSerialNo;
    
    /**
     * 买家用户标识
     */
    @JsonProperty("buyer_user_id")
    private String buyerUserId;
    
    /**
     * 买家账号
     */
    @JsonProperty("buyer_logon_id")
    private String buyerLogonId;
    
    /**
     * 附加数据
     */
    @JsonProperty("attach")
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
    
    public Long getOrderAmt() {
        return orderAmt;
    }
    
    public void setOrderAmt(Long orderAmt) {
        this.orderAmt = orderAmt;
    }
    
    public Long getPayAmt() {
        return payAmt;
    }
    
    public void setPayAmt(Long payAmt) {
        this.payAmt = payAmt;
    }
    
    public Long getDiscountAmt() {
        return discountAmt;
    }
    
    public void setDiscountAmt(Long discountAmt) {
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
