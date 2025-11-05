package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.util.HashMap;
import java.util.Map;

/**
 * 退款查询请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class RefundQueryRequest extends BaseRequest {
    
    /**
     * 商户号（必填）
     * 商户在招行完成商户进件后分配的招行商户号
     */
    @NotBlank(message = "商户号不能为空")
    @JsonIgnore
    private String merId;
    
    /**
     * 原外部商户订单号（可选）
     * 支付宝先享后付订单的交易必须上送。支付宝先享后付-订单创建请求参数中的outOrderId
     */
    @JsonIgnore
    private String origOutOrderId;
    
    /**
     * 商户退款订单号（可选）
     * 被查询交易的商户退款订单号，此字段和平台退款订单号字段至少要上送一个，若两个都上送，则以平台退款订单号为准
     */
    @JsonIgnore
    private String orderId;
    
    /**
     * 平台退款订单号（可选）
     * 被查询交易招行退款订单号，此字段和商户退款订单号字段至少要上送一个，若两个都上送，则以此字段为准
     */
    @JsonIgnore
    private String cmbOrderId;
    
    /**
     * 收银员（必填）
     * 招行系统生成的收银员，需和被查询交易的收银员一致。
     */
    @NotBlank(message = "收银员不能为空")
    @JsonIgnore
    private String userId;
    
    /**
     * 查询选项（可选）
     * 商户通过上送该参数来定制同步需要额外返回的信息字段（支付宝），数组形式的字符串
     * 示例："[\"refund_detail_item_list\"]"
     * 参考：https://opendocs.alipay.com/apis/api_1/alipay.trade.fastpay.refund.query
     */
    @JsonIgnore
    private String queryOptions;
    
    /**
     * 获取业务参数Map（用于构建bizContent）
     */
    @JsonIgnore
    public Map<String, Object> getBizContentMap() {
        Map<String, Object> bizContent = new HashMap<>();
        // 必填字段
        if (merId != null) bizContent.put("merId", merId);
        if (userId != null) bizContent.put("userId", userId);
        
        // 可选字段
        if (origOutOrderId != null) bizContent.put("origOutOrderId", origOutOrderId);
        if (orderId != null) bizContent.put("orderId", orderId);
        if (cmbOrderId != null) bizContent.put("cmbOrderId", cmbOrderId);
        if (queryOptions != null) bizContent.put("queryOptions", queryOptions);
        
        return bizContent;
    }
    
    public String getMerId() {
        return merId;
    }
    
    public void setMerId(String merId) {
        this.merId = merId;
    }
    
    public String getOrigOutOrderId() {
        return origOutOrderId;
    }
    
    public void setOrigOutOrderId(String origOutOrderId) {
        this.origOutOrderId = origOutOrderId;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getCmbOrderId() {
        return cmbOrderId;
    }
    
    public void setCmbOrderId(String cmbOrderId) {
        this.cmbOrderId = cmbOrderId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getQueryOptions() {
        return queryOptions;
    }
    
    public void setQueryOptions(String queryOptions) {
        this.queryOptions = queryOptions;
    }
}
