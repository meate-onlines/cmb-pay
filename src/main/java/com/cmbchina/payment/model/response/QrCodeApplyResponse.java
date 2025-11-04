package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;

/**
 * 收款码申请响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class QrCodeApplyResponse extends BaseResponse {
    
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
     * 二维码链接
     */
    private String qrCode;
    
    /**
     * 二维码图片Base64
     */
    private String qrCodeImg;
    
    /**
     * 订单状态
     */
    private String orderStat;
    
    /**
     * 订单金额（分）
     */
    private Long orderAmt;
    
    /**
     * 订单创建时间
     */
    private String orderDate;
    
    /**
     * 订单有效期至
     */
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
    
    public String getQrCode() {
        return qrCode;
    }
    
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
    
    public String getQrCodeImg() {
        return qrCodeImg;
    }
    
    public void setQrCodeImg(String qrCodeImg) {
        this.qrCodeImg = qrCodeImg;
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
