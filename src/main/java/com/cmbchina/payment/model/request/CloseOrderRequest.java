package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.util.HashMap;
import java.util.Map;

/**
 * 关闭订单请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class CloseOrderRequest extends BaseRequest {
    
    /**
     * 商户号（必填）
     * 商户在招行完成商户进件后分配的招行商户号
     */
    @NotBlank(message = "商户号不能为空")
    @JsonIgnore
    private String merId;
    
    /**
     * 原交易商户订单号（可选）
     * 被关闭交易的商户订单号，此字段和被关闭交易平台订单号字段至少要上送一个，若两个都上送，则以被关闭交易平台订单号为准
     */
    @JsonIgnore
    private String origOrderId;
    
    /**
     * 外部商户订单号（可选）
     * 支付宝先享后付订单的交易必须上送。支付宝先享后付-订单创建请求参数中的outOrderId
     */
    @JsonIgnore
    private String origOutOrderId;
    
    /**
     * 原交易平台订单号（可选）
     * 被关闭交易招行订单号，此字段和被关闭交易商户订单号字段至少要上送一个，若两个都上送，则以此字段为准
     */
    @JsonIgnore
    private String origCmbOrderId;
    
    /**
     * 收银员（必填）
     * 招行系统生成的收银员，需和被关闭交易的收银员一致。
     */
    @NotBlank(message = "收银员不能为空")
    @JsonIgnore
    private String userId;
    
    /**
     * 获取业务参数Map（用于构建bizContent）
     */
    @JsonIgnore
    public Map<String, Object> getBizContentMap() {
        Map<String, Object> bizContent = new HashMap<>();
        if (merId != null) bizContent.put("merId", merId);
        if (origOrderId != null) bizContent.put("origOrderId", origOrderId);
        if (origOutOrderId != null) bizContent.put("origOutOrderId", origOutOrderId);
        if (origCmbOrderId != null) bizContent.put("origCmbOrderId", origCmbOrderId);
        if (userId != null) bizContent.put("userId", userId);
        return bizContent;
    }
    
    public String getMerId() {
        return merId;
    }
    
    public void setMerId(String merId) {
        this.merId = merId;
    }
    
    public String getOrigOrderId() {
        return origOrderId;
    }
    
    public void setOrigOrderId(String origOrderId) {
        this.origOrderId = origOrderId;
    }
    
    public String getOrigOutOrderId() {
        return origOutOrderId;
    }
    
    public void setOrigOutOrderId(String origOutOrderId) {
        this.origOutOrderId = origOutOrderId;
    }
    
    public String getOrigCmbOrderId() {
        return origCmbOrderId;
    }
    
    public void setOrigCmbOrderId(String origCmbOrderId) {
        this.origCmbOrderId = origCmbOrderId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
