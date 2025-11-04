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
     * 商户号（returnCode为SUCCESS时返回）
     */
    private String merId;
    
    /**
     * 商户订单号（returnCode为SUCCESS时返回）
     */
    private String orderId;
    
    /**
     * 二维码（returnCode和respCode为SUCCESS时返回）
     */
    private String qrCode;
    
    /**
     * 平台订单号（returnCode和respCode为SUCCESS时返回）
     */
    private String cmbOrderId;
    
    /**
     * 订单发送时间（returnCode和respCode为SUCCESS时返回）
     * 格式：yyyyMMddHHmmss
     */
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
