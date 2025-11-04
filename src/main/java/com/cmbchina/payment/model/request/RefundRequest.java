package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * 退款申请请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class RefundRequest extends BaseRequest {
    
    /**
     * 商户号
     */
    @NotBlank(message = "商户号不能为空")
    @JsonIgnore
    private String merId;
    
    /**
     * 商户订单号
     */
    @NotBlank(message = "商户订单号不能为空")
    @JsonIgnore
    private String orderId;
    
    /**
     * 退款订单号
     */
    @NotBlank(message = "退款订单号不能为空")
    @JsonIgnore
    private String refundOrderId;
    
    /**
     * 退款金额（分）
     */
    @NotNull(message = "退款金额不能为空")
    @JsonIgnore
    private String refundAmt;
    
    /**
     * 退款原因
     */
    @JsonIgnore
    private String refundReason;
    
    /**
     * 异步通知地址
     */
    @JsonIgnore
    private String notifyUrl;
    
    /**
     * 附加数据
     */
    @JsonIgnore
    private String attach;
    
    /**
     * 原商户订单号
     */
    @JsonIgnore
    private String origOutOrderId;

    /**
     * 附加数据
     */
    @JsonIgnore
    private String acqAddnData;

    /**
     * 加密交易地址信息
     */
    @JsonIgnore
    private String encryptTradeAddressInfo;

    /**
     * 子商户号
     */
    @JsonIgnore
    private String subMerId;

    /**
     * 子门店号
     */
    @JsonIgnore
    private String subStoreId;
    
    /**
     * 获取业务参数Map（用于构建bizContent）
     */
    @JsonIgnore
    public Map<String, Object> getBizContentMap() {
        Map<String, Object> bizContent = new HashMap<>();
        if (merId != null) bizContent.put("merId", merId);
        if (orderId != null) bizContent.put("orderId", orderId);
        if (refundOrderId != null) bizContent.put("refundOrderId", refundOrderId);
        if (refundAmt != null) bizContent.put("refundAmt", refundAmt);
        if (refundReason != null) bizContent.put("refundReason", refundReason);
        if (notifyUrl != null) bizContent.put("notifyUrl", notifyUrl);
        if (attach != null) bizContent.put("attach", attach);
        if (origOutOrderId != null) bizContent.put("origOutOrderId", origOutOrderId);
        if (acqAddnData != null) bizContent.put("acqAddnData", acqAddnData);
        if (encryptTradeAddressInfo != null) bizContent.put("encryptTradeAddressInfo", encryptTradeAddressInfo);
        if (subMerId != null) bizContent.put("subMerId", subMerId);
        if (subStoreId != null) bizContent.put("subStoreId", subStoreId);
        return bizContent;
    }
    
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
    
    public String getRefundOrderId() {
        return refundOrderId;
    }
    
    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }
    
    public String getRefundAmt() {
        return refundAmt;
    }
    
    public void setRefundAmt(String refundAmt) {
        this.refundAmt = refundAmt;
    }
    
    public String getRefundReason() {
        return refundReason;
    }
    
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }
    
    public String getNotifyUrl() {
        return notifyUrl;
    }
    
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    
    public String getAttach() {
        return attach;
    }
    
    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOrigOutOrderId() {
        return origOutOrderId;
    }

    public void setOrigOutOrderId(String origOutOrderId) {
        this.origOutOrderId = origOutOrderId;
    }

    public String getAcqAddnData() {
        return acqAddnData;
    }

    public void setAcqAddnData(String acqAddnData) {
        this.acqAddnData = acqAddnData;
    }

    public String getEncryptTradeAddressInfo() {
        return encryptTradeAddressInfo;
    }

    public void setEncryptTradeAddressInfo(String encryptTradeAddressInfo) {
        this.encryptTradeAddressInfo = encryptTradeAddressInfo;
    }

    public String getSubMerId() {
        return subMerId;
    }

    public void setSubMerId(String subMerId) {
        this.subMerId = subMerId;
    }

    public String getSubStoreId() {
        return subStoreId;
    }

    public void setSubStoreId(String subStoreId) {
        this.subStoreId = subStoreId;
    }
}
