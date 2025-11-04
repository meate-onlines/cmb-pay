package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;

/**
 * 支付宝服务窗支付响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class AlipayServiceResponse extends BaseResponse {
    
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
     * 支付链接
     */
    private String payUrl;
    
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
    
    private String payType;

    private String thirdOrderId;

    private String buyerUserId;

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
    
    public String getPayUrl() {
        return payUrl;
    }
    
    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
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
}
