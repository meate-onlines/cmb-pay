package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.HashMap;
import java.util.Map;

/**
 * 收款码申请请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class QrCodeApplyRequest extends BaseRequest {
    
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
     * 订单金额（分）
     */
    @NotBlank(message = "交易金额不能为空")
    @JsonIgnore
    private String txnAmt;
    
    /**
     * 商品描述
     */
    @NotBlank(message = "商品描述不能为空")
    @JsonIgnore
    private String body;
    
    /**
     * 异步通知地址
     */
    @NotBlank(message = "通知地址不能为空")
    @JsonIgnore
    private String notifyUrl;
    
    /**
     * 订单有效时间（分钟）
     */
    @JsonIgnore
    private String payValidTime;
    
    /**
     * 附加数据
     */
    @JsonIgnore
    private String mchReserved;

    @JsonIgnore
    private String subMerId;

    @JsonIgnore
    private String subStoreId;

    @NotBlank(message = "收银员不能为空")
    @JsonIgnore
    private String userId;

    @JsonIgnore
    private String termId;

    @JsonIgnore
    private String currencyCode;

    @JsonIgnore
    private String encryptIdentity;

    @JsonIgnore
    private String policyNo;

    @JsonIgnore
    private String region;

    @JsonIgnore
    private String encryptTerminalInfo;

    @JsonIgnore
    private String businessParams;

    @JsonIgnore
    private String encryptTradeAddressInfo;
    
    /**
     * 获取业务参数Map（用于构建bizContent）
     */
    @JsonIgnore
    public Map<String, Object> getBizContentMap() {
        Map<String, Object> bizContent = new HashMap<>();
        if (merId != null) bizContent.put("merId", merId);
        if (subMerId != null) bizContent.put("subMerId", subMerId);
        if (subStoreId != null) bizContent.put("subStoreId", subStoreId);
        if (orderId != null) bizContent.put("orderId", orderId);
        if (userId != null) bizContent.put("userId", userId);
        if (termId != null) bizContent.put("termId", termId);
        if (payValidTime != null) bizContent.put("payValidTime", payValidTime);
        if (notifyUrl != null) bizContent.put("notifyUrl", notifyUrl);
        if (txnAmt != null) bizContent.put("txnAmt", txnAmt);
        if (currencyCode != null) bizContent.put("currencyCode", currencyCode);
        if (body != null) bizContent.put("body", body);
        if (mchReserved != null) bizContent.put("mchReserved", mchReserved);
        if (encryptIdentity != null) bizContent.put("encryptIdentity", encryptIdentity);
        if (policyNo != null) bizContent.put("policyNo", policyNo);
        if (region != null) bizContent.put("region", region);
        if (encryptTerminalInfo != null) bizContent.put("encryptTerminalInfo", encryptTerminalInfo);
        if (businessParams != null) bizContent.put("businessParams", businessParams);
        if (encryptTradeAddressInfo != null) bizContent.put("encryptTradeAddressInfo", encryptTradeAddressInfo);
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
    
    public String getTxnAmt() {
        return txnAmt;
    }
    
    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt;
    }
    
    public String getBody() {
        return body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    
    public String getNotifyUrl() {
        return notifyUrl;
    }
    
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    
    public String getPayValidTime() {
        return payValidTime;
    }
    
    public void setPayValidTime(String payValidTime) {
        this.payValidTime = payValidTime;
    }
    
    public String getMchReserved() {
        return mchReserved;
    }
    
    public void setMchReserved(String mchReserved) {
        this.mchReserved = mchReserved;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getEncryptIdentity() {
        return encryptIdentity;
    }

    public void setEncryptIdentity(String encryptIdentity) {
        this.encryptIdentity = encryptIdentity;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEncryptTerminalInfo() {
        return encryptTerminalInfo;
    }

    public void setEncryptTerminalInfo(String encryptTerminalInfo) {
        this.encryptTerminalInfo = encryptTerminalInfo;
    }

    public String getBusinessParams() {
        return businessParams;
    }

    public void setBusinessParams(String businessParams) {
        this.businessParams = businessParams;
    }

    public String getEncryptTradeAddressInfo() {
        return encryptTradeAddressInfo;
    }

    public void setEncryptTradeAddressInfo(String encryptTradeAddressInfo) {
        this.encryptTradeAddressInfo = encryptTradeAddressInfo;
    }
}
