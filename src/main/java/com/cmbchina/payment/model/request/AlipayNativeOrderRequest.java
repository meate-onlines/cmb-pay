package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝Native支付请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class AlipayNativeOrderRequest extends BaseRequest {
    
    /**
     * 商户号
     */
    @NotBlank(message = "商户号不能为空")
    @JsonIgnore
    private String merId;
    
    /**
     * 附加经营商户号
     */
    @JsonIgnore
    private String subMerId;
    
    /**
     * 经营商户门店号
     */
    @JsonIgnore
    private String subStoreId;
    
    /**
     * 设备号
     */
    @JsonIgnore
    private String deviceInfo;
    
    /**
     * 商户订单号
     */
    @NotBlank(message = "商户订单号不能为空")
    @JsonIgnore
    private String orderId;
    
    /**
     * 收银员
     */
    @JsonIgnore
    private String userId;
    
    /**
     * 商品描述
     */
    @JsonIgnore
    private String body;
    
    /**
     * 商品优惠信息
     */
    @JsonIgnore
    private String goodsDetail;
    
    /**
     * 商户保留域
     */
    @JsonIgnore
    private String mchReserved;
    
    /**
     * 支付有效时间
     */
    @JsonIgnore
    private String timeoutExpress;
    
    /**
     * 二维码有效时间
     */
    @JsonIgnore
    private String qrCodeTimeoutExpress;
    
    /**
     * 交易通知地址
     */
    @NotBlank(message = "交易通知地址不能为空")
    @JsonIgnore
    private String notifyUrl;
    
    /**
     * 交易金额（分）
     */
    @NotBlank(message = "交易金额不能为空")
    @JsonIgnore
    private String txnAmt;
    
    /**
     * 订单原始金额（分）
     */
    @JsonIgnore
    private String orderOrigAmt;
    
    /**
     * 订单优惠金额（分）
     */
    @JsonIgnore
    private String orderCouponAmt;
    
    /**
     * 交易币种
     */
    @JsonIgnore
    private String currencyCode;
    
    /**
     * 限制支付渠道
     */
    @JsonIgnore
    private String disablePayChannels;
    
    /**
     * 买家支付宝账号
     */
    @JsonIgnore
    private String buyerLogonId;
    
    /**
     * 实名支付信息（需加密）
     */
    @JsonIgnore
    private String encryptIdentity;
    
    /**
     * 保单单号
     */
    @JsonIgnore
    private String policyNo;
    
    /**
     * 地区码
     */
    @JsonIgnore
    private String region;
    
    /**
     * 上海保险平台交易号
     */
    @JsonIgnore
    private String paymentNo;
    
    /**
     * 业务扩展参数
     */
    @JsonIgnore
    private String alipayExtendParams;
    
    /**
     * 终端信息（需加密）
     */
    @JsonIgnore
    private String encryptTerminalInfo;
    
    /**
     * 商户传入业务信息
     */
    @JsonIgnore
    private String businessParams;
    
    /**
     * 交易地址信息（需加密）
     */
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
        if (deviceInfo != null) bizContent.put("deviceInfo", deviceInfo);
        if (orderId != null) bizContent.put("orderId", orderId);
        if (userId != null) bizContent.put("userId", userId);
        if (body != null) bizContent.put("body", body);
        if (goodsDetail != null) bizContent.put("goodsDetail", goodsDetail);
        if (mchReserved != null) bizContent.put("mchReserved", mchReserved);
        if (timeoutExpress != null) bizContent.put("timeoutExpress", timeoutExpress);
        if (qrCodeTimeoutExpress != null) bizContent.put("qrCodeTimeoutExpress", qrCodeTimeoutExpress);
        if (notifyUrl != null) bizContent.put("notifyUrl", notifyUrl);
        if (txnAmt != null) bizContent.put("txnAmt", txnAmt);
        if (orderOrigAmt != null) bizContent.put("orderOrigAmt", orderOrigAmt);
        if (orderCouponAmt != null) bizContent.put("orderCouponAmt", orderCouponAmt);
        if (currencyCode != null) bizContent.put("currencyCode", currencyCode);
        if (disablePayChannels != null) bizContent.put("disablePayChannels", disablePayChannels);
        if (buyerLogonId != null) bizContent.put("buyerLogonId", buyerLogonId);
        if (encryptIdentity != null) bizContent.put("encryptIdentity", encryptIdentity);
        if (policyNo != null) bizContent.put("policyNo", policyNo);
        if (region != null) bizContent.put("region", region);
        if (paymentNo != null) bizContent.put("paymentNo", paymentNo);
        if (alipayExtendParams != null) bizContent.put("alipayExtendParams", alipayExtendParams);
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
    
    public String getDeviceInfo() {
        return deviceInfo;
    }
    
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getBody() {
        return body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    
    public String getGoodsDetail() {
        return goodsDetail;
    }
    
    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
    
    public String getMchReserved() {
        return mchReserved;
    }
    
    public void setMchReserved(String mchReserved) {
        this.mchReserved = mchReserved;
    }
    
    public String getTimeoutExpress() {
        return timeoutExpress;
    }
    
    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }
    
    public String getQrCodeTimeoutExpress() {
        return qrCodeTimeoutExpress;
    }
    
    public void setQrCodeTimeoutExpress(String qrCodeTimeoutExpress) {
        this.qrCodeTimeoutExpress = qrCodeTimeoutExpress;
    }
    
    public String getNotifyUrl() {
        return notifyUrl;
    }
    
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    
    public String getTxnAmt() {
        return txnAmt;
    }
    
    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt;
    }
    
    public String getOrderOrigAmt() {
        return orderOrigAmt;
    }
    
    public void setOrderOrigAmt(String orderOrigAmt) {
        this.orderOrigAmt = orderOrigAmt;
    }
    
    public String getOrderCouponAmt() {
        return orderCouponAmt;
    }
    
    public void setOrderCouponAmt(String orderCouponAmt) {
        this.orderCouponAmt = orderCouponAmt;
    }
    
    public String getCurrencyCode() {
        return currencyCode;
    }
    
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    public String getDisablePayChannels() {
        return disablePayChannels;
    }
    
    public void setDisablePayChannels(String disablePayChannels) {
        this.disablePayChannels = disablePayChannels;
    }
    
    public String getBuyerLogonId() {
        return buyerLogonId;
    }
    
    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
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
    
    public String getPaymentNo() {
        return paymentNo;
    }
    
    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }
    
    public String getAlipayExtendParams() {
        return alipayExtendParams;
    }
    
    public void setAlipayExtendParams(String alipayExtendParams) {
        this.alipayExtendParams = alipayExtendParams;
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

