package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝服务窗支付请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class AlipayServiceRequest extends BaseRequest {
    
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
    @JsonIgnore
    private Long orderAmt;
    
    /**
     * 商品描述
     */
    @JsonIgnore
    private String goodsDes;
    
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
     * 获取业务参数Map（用于构建bizContent）
     */
    @JsonIgnore
    public Map<String, Object> getBizContentMap() {
        Map<String, Object> bizContent = new HashMap<>();
        if (merId != null) {
            bizContent.put("merId", merId);
        }
        if (orderId != null) {
            bizContent.put("orderId", orderId);
        }
        if (orderAmt != null) {
            bizContent.put("orderAmt", orderAmt);
        }
        if (goodsDes != null) {
            bizContent.put("goodsDes", goodsDes);
        }
        if (notifyUrl != null) {
            bizContent.put("notifyUrl", notifyUrl);
        }
        if (returnUrl != null) {
            bizContent.put("returnUrl", returnUrl);
        }
        if (expireTime != null) {
            bizContent.put("expireTime", expireTime);
        }
        if (attach != null) {
            bizContent.put("attach", attach);
        }
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
}
