package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 微信统一下单请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class WechatUnifiedOrderRequest extends BaseRequest {
    
    /**
     * 商户号
     */
    @NotBlank(message = "商户号不能为空")
    @JsonProperty("mer_id")
    private String merId;
    
    /**
     * 商户订单号
     */
    @NotBlank(message = "商户订单号不能为空")
    @JsonProperty("order_id")
    private String orderId;
    
    /**
     * 订单金额（分）
     */
    @NotNull(message = "订单金额不能为空")
    @Positive(message = "订单金额必须大于0")
    @JsonProperty("order_amt")
    private Long orderAmt;
    
    /**
     * 商品描述
     */
    @NotBlank(message = "商品描述不能为空")
    @JsonProperty("goods_des")
    private String goodsDes;
    
    /**
     * 支付类型（JSAPI-公众号支付，APP-APP支付，MINIAPP-小程序支付）
     */
    @NotBlank(message = "支付类型不能为空")
    @JsonProperty("pay_type")
    private String payType;
    
    /**
     * 用户openid（JSAPI和MINIAPP必填）
     */
    @JsonProperty("openid")
    private String openid;
    
    /**
     * 异步通知地址
     */
    @JsonProperty("notify_url")
    private String notifyUrl;
    
    /**
     * 同步跳转地址
     */
    @JsonProperty("return_url")
    private String returnUrl;
    
    /**
     * 订单有效时间（分钟）
     */
    @JsonProperty("expire_time")
    private Integer expireTime;
    
    /**
     * 附加数据
     */
    @JsonProperty("attach")
    private String attach;
    
    /**
     * 门店ID
     */
    @JsonProperty("store_id")
    private String storeId;
    
    /**
     * 操作员ID
     */
    @JsonProperty("operator_id")
    private String operatorId;
    
    /**
     * 终端号
     */
    @JsonProperty("terminal_id")
    private String terminalId;
    
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
    
    public Long getOrderAmt() {
        return orderAmt;
    }
    
    public void setOrderAmt(Long orderAmt) {
        this.orderAmt = orderAmt;
    }
    
    public String getGoodsDes() {
        return goodsDes;
    }
    
    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes;
    }
    
    public String getPayType() {
        return payType;
    }
    
    public void setPayType(String payType) {
        this.payType = payType;
    }
    
    public String getOpenid() {
        return openid;
    }
    
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    
    public String getNotifyUrl() {
        return notifyUrl;
    }
    
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    
    public String getReturnUrl() {
        return returnUrl;
    }
    
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
    
    public Integer getExpireTime() {
        return expireTime;
    }
    
    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
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
}
