package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信统一下单请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class WechatUnifiedOrderRequest extends BaseRequest {
    
    /**
     * 商户号，商户在招行完成商户进件后分配的招行商户号
     */
    @NotBlank(message = "商户号不能为空")
    @JsonIgnore
    private String merId;
    
    /**
     * 附加经营商户号，招行附加经营商户号。平台商户和附加经营商户联合支付场景使用
     */
    @JsonIgnore
    private String subMerId;
    
    /**
     * 经营商户门店号，招行附加经营商户号对应的门店号
     */
    @JsonIgnore
    private String subStoreId;
    
    /**
     * 设备号，PC网页或公众号内支付请传"WEB"
     */
    @JsonIgnore
    private String deviceInfo;
    
    /**
     * 子公众账号ID，商户微信公众号appid
     */
    @NotBlank(message = "子公众账号ID或小程序appid不能为空")
    @JsonIgnore
    private String subAppId;
    
    /**
     * 商户订单号，商户端生成，要求此订单号在整个商户下唯一
     */
    @NotBlank(message = "商户订单号不能为空")
    @JsonIgnore
    private String orderId;
    
    /**
     * 交易类型，APP支付：APP，公众号支付：JSAPI，小程序支付：JSAPI
     */
    @NotBlank(message = "交易类型不能为空")
    @JsonIgnore
    private String tradeType;
    
    /**
     * 收银员，招行系统生成的收银员
     */
    @NotBlank(message = "收银员不能为空")
    @JsonIgnore
    private String userId;
    
    /**
     * 商品描述
     */
    @NotBlank(message = "商品描述不能为空")
    @JsonIgnore
    private String body;
    
    /**
     * 商品详情，商品详细描述
     */
    @JsonIgnore
    private String goodsDetail;
    
    /**
     * 商品标记，代金券或立减优惠功能的参数
     */
    @JsonIgnore
    private String goodsTag;
    
    /**
     * 附加数据，如"深圳分店"
     */
    @JsonIgnore
    private String attach;
    
    /**
     * 商户保留域，用于传输商户自定义数据
     */
    @JsonIgnore
    private String mchReserved;
    
    /**
     * 支付有效时间，单位为秒，应不小于60
     */
    @JsonIgnore
    private String payValidTime;
    
    /**
     * 交易通知地址，支付结果将送到本通知
     */
    @NotBlank(message = "交易通知地址不能为空")
    @JsonIgnore
    private String notifyUrl;
    
    /**
     * 交易金额，单位为分，txnAmt=orderOrigAmt-orderCouponAmt
     */
    @NotBlank(message = "交易金额不能为空")
    @JsonIgnore
    private String txnAmt;
    
    /**
     * 订单原始金额，单位为分，和orderCouponAmt同时出现
     */
    @JsonIgnore
    private String orderOrigAmt;
    
    /**
     * 订单优惠金额，单位为分，和orderOrigAmt同时出现
     */
    @JsonIgnore
    private String orderCouponAmt;
    
    /**
     * 交易币种，默认156，目前只支持人民币（156）
     */
    @JsonIgnore
    private String currencyCode;
    
    /**
     * 终端IP，必须传正确的用户端IP
     */
    @NotBlank(message = "终端IP不能为空")
    @JsonIgnore
    private String spbillCreateIp;
    
    /**
     * 限定支付方式，no_credit--指定不能使用信用卡支付；为空表示无限制
     */
    @JsonIgnore
    private String limitPay;
    
    /**
     * 用户标识，用户在Appid下的唯一标识
     */
    @JsonIgnore
    private String openId;
    
    /**
     * 用户子标识，trade_type=JSAPI，此参数必传，用户在subAppId下的唯一标识
     */
    @JsonIgnore
    private String subOpenId;
    
    /**
     * 场景信息，H5支付必填，公众号、APP支付和小程序支付不填
     */
    @JsonIgnore
    private String sceneInfo;
    
    /**
     * 实名支付信息，需加密
     */
    @JsonIgnore
    private String encryptIdentity;
    
    /**
     * 保单单号，保险实名支付对接中保信使用
     */
    @JsonIgnore
    private String policyNo;
    
    /**
     * 地区码，缴税系统地区码
     */
    @JsonIgnore
    private String region;
    
    /**
     * 上海保险平台交易号
     */
    @JsonIgnore
    private String paymentNo;
    
    /**
     * 终端信息，商户侧受理终端信息，需加密
     */
    @JsonIgnore
    private String encryptTerminalInfo;
    
    /**
     * 指定支付者，ADULT：成年人
     */
    @JsonIgnore
    private String limitPayer;
    
    /**
     * 交易地址信息，需加密
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
        if (subAppId != null) bizContent.put("subAppId", subAppId);
        if (orderId != null) bizContent.put("orderId", orderId);
        if (tradeType != null) bizContent.put("tradeType", tradeType);
        if (userId != null) bizContent.put("userId", userId);
        if (body != null) bizContent.put("body", body);
        if (goodsDetail != null) bizContent.put("goodsDetail", goodsDetail);
        if (goodsTag != null) bizContent.put("goodsTag", goodsTag);
        if (attach != null) bizContent.put("attach", attach);
        if (mchReserved != null) bizContent.put("mchReserved", mchReserved);
        if (payValidTime != null) bizContent.put("payValidTime", payValidTime);
        if (notifyUrl != null) bizContent.put("notifyUrl", notifyUrl);
        if (txnAmt != null) bizContent.put("txnAmt", txnAmt);
        if (orderOrigAmt != null) bizContent.put("orderOrigAmt", orderOrigAmt);
        if (orderCouponAmt != null) bizContent.put("orderCouponAmt", orderCouponAmt);
        if (currencyCode != null) bizContent.put("currencyCode", currencyCode);
        if (spbillCreateIp != null) bizContent.put("spbillCreateIp", spbillCreateIp);
        if (limitPay != null) bizContent.put("limitPay", limitPay);
        if (openId != null) bizContent.put("openId", openId);
        if (subOpenId != null) bizContent.put("subOpenId", subOpenId);
        if (sceneInfo != null) bizContent.put("sceneInfo", sceneInfo);
        if (encryptIdentity != null) bizContent.put("encryptIdentity", encryptIdentity);
        if (policyNo != null) bizContent.put("policyNo", policyNo);
        if (region != null) bizContent.put("region", region);
        if (paymentNo != null) bizContent.put("paymentNo", paymentNo);
        if (encryptTerminalInfo != null) bizContent.put("encryptTerminalInfo", encryptTerminalInfo);
        if (limitPayer != null) bizContent.put("limitPayer", limitPayer);
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
    
    public String getSubAppId() {
        return subAppId;
    }
    
    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getTradeType() {
        return tradeType;
    }
    
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
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
    
    public String getGoodsTag() {
        return goodsTag;
    }
    
    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }
    
    public String getAttach() {
        return attach;
    }
    
    public void setAttach(String attach) {
        this.attach = attach;
    }
    
    public String getMchReserved() {
        return mchReserved;
    }
    
    public void setMchReserved(String mchReserved) {
        this.mchReserved = mchReserved;
    }
    
    public String getPayValidTime() {
        return payValidTime;
    }
    
    public void setPayValidTime(String payValidTime) {
        this.payValidTime = payValidTime;
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
    
    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }
    
    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }
    
    public String getLimitPay() {
        return limitPay;
    }
    
    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }
    
    public String getOpenId() {
        return openId;
    }
    
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    
    public String getSubOpenId() {
        return subOpenId;
    }
    
    public void setSubOpenId(String subOpenId) {
        this.subOpenId = subOpenId;
    }
    
    public String getSceneInfo() {
        return sceneInfo;
    }
    
    public void setSceneInfo(String sceneInfo) {
        this.sceneInfo = sceneInfo;
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
    
    public String getEncryptTerminalInfo() {
        return encryptTerminalInfo;
    }
    
    public void setEncryptTerminalInfo(String encryptTerminalInfo) {
        this.encryptTerminalInfo = encryptTerminalInfo;
    }
    
    public String getLimitPayer() {
        return limitPayer;
    }
    
    public void setLimitPayer(String limitPayer) {
        this.limitPayer = limitPayer;
    }
    
    public String getEncryptTradeAddressInfo() {
        return encryptTradeAddressInfo;
    }
    
    public void setEncryptTradeAddressInfo(String encryptTradeAddressInfo) {
        this.encryptTradeAddressInfo = encryptTradeAddressInfo;
    }
}
