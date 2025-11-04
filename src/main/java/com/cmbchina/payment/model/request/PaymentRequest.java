package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.HashMap;
import java.util.Map;

/**
 * 付款码收款请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class PaymentRequest extends BaseRequest {
    
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
    @NotNull(message = "订单金额不能为空")
    @Positive(message = "订单金额必须大于0")
    @JsonIgnore
    private String txnAmt;
    
    /**
     * 商品描述
     */
    @NotBlank(message = "商品描述不能为空")
    @JsonIgnore
    private String body;
    
    /**
     * 付款码
     */
    @NotBlank(message = "付款码不能为空")
    @JsonIgnore
    private String authCode;
    
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
     * 门店ID
     */
    @JsonIgnore
    private String storeId;
    
    /**
     * 操作员ID
     */
    @JsonIgnore
    private String operatorId;
    
    /**
     * 终端号
     */
    @JsonIgnore
    private String terminalId;
    
    /**
     * 商品优惠金额
     */
    @JsonIgnore
    private String itemDiscount;

    /**
     * 银联支付标识
     */
    @JsonIgnore
    private String ecnyPayment;

    /**
     * 加密终端信息
     */
    @JsonIgnore
    private String encryptTerminalInfo;

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
        if (txnAmt != null) bizContent.put("txnAmt", txnAmt);
        if (body != null) bizContent.put("body", body);
        if (authCode != null) bizContent.put("authCode", authCode);
        if (notifyUrl != null) bizContent.put("notifyUrl", notifyUrl);
        if (attach != null) bizContent.put("attach", attach);
        if (storeId != null) bizContent.put("storeId", storeId);
        if (operatorId != null) bizContent.put("operatorId", operatorId);
        if (terminalId != null) bizContent.put("terminalId", terminalId);
        if (itemDiscount != null) bizContent.put("itemDiscount", itemDiscount);
        if (ecnyPayment != null) bizContent.put("ecnyPayment", ecnyPayment);
        if (encryptTerminalInfo != null) bizContent.put("encryptTerminalInfo", encryptTerminalInfo);
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
    
    public String getAuthCode() {
        return authCode;
    }
    
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
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
    
    public String getStoreId() {
        return storeId;
    }
    
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    
    public String getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    
    public String getTerminalId() {
        return terminalId;
    }
    
    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(String itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public String getEcnyPayment() {
        return ecnyPayment;
    }

    public void setEcnyPayment(String ecnyPayment) {
        this.ecnyPayment = ecnyPayment;
    }

    public String getEncryptTerminalInfo() {
        return encryptTerminalInfo;
    }

    public void setEncryptTerminalInfo(String encryptTerminalInfo) {
        this.encryptTerminalInfo = encryptTerminalInfo;
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
