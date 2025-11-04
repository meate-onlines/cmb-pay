package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;

/**
 * 关闭订单响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class CloseOrderResponse extends BaseResponse {
    
    /**
     * 商户号
     */
    private String merId;
    
    /**
     * 商户订单号
     */
    private String orderId;
    
    /**
     * 订单状态
     */
    private String orderStat;
    
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
    
    public String getOrderStat() {
        return orderStat;
    }
    
    public void setOrderStat(String orderStat) {
        this.orderStat = orderStat;
    }
}
