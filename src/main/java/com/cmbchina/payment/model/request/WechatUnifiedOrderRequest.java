package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
    @JsonIgnore
    private String orderAmt;
    
    /**
     * 商品描述
     */
    @NotBlank(message = "商品描述不能为空")
    @JsonIgnore
    private String goodsDes;
    
    /**
     * 支付类型（JSAPI-公众号支付，APP-APP支付，MINIAPP-小程序支付）
     */
    @NotBlank(message = "支付类型不能为空")
    @JsonIgnore
    private String payType;
    
    /**
     * 用户openid（JSAPI和MINIAPP必填）
     */
    @JsonIgnore
    private String openid;
    
    /**
     * 异步通知地址
     */
    @JsonIgnore
    private String notifyUrl;
    
    /**
     * 同步跳转地址
     */
    @JsonIgnore
    private String returnUrl;
    
    /**
     * 订单有效时间（分钟）
     */
    @JsonIgnore
    private Integer expireTime;
    
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
     * 获取业务参数Map（用于构建bizContent）
     */
    @JsonIgnore
    public Map<String, Object> getBizContentMap() {
        Map<String, Object> bizContent = new HashMap<>();
        if (merId != null) bizContent.put("merId", merId);
        if (orderId != null) bizContent.put("orderId", orderId);
        if (orderAmt != null) bizContent.put("orderAmt", orderAmt);
        if (goodsDes != null) bizContent.put("goodsDes", goodsDes);
        if (payType != null) bizContent.put("payType", payType);
        if (openid != null) bizContent.put("openid", openid);
        if (notifyUrl != null) bizContent.put("notifyUrl", notifyUrl);
        if (returnUrl != null) bizContent.put("returnUrl", returnUrl);
        if (expireTime != null) bizContent.put("expireTime", expireTime);
        if (attach != null) bizContent.put("attach", attach);
        if (storeId != null) bizContent.put("storeId", storeId);
        if (operatorId != null) bizContent.put("operatorId", operatorId);
        if (terminalId != null) bizContent.put("terminalId", terminalId);
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
    
    public String getOrderAmt() {
        return orderAmt;
    }
    
    public void setOrderAmt(String orderAmt) {
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
