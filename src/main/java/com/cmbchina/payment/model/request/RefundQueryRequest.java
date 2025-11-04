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
     * 商户号
     */
    @NotBlank(message = "商户号不能为空")
    @JsonIgnore
    private String merId;
    
    /**
     * 退款订单号
     */
    @NotBlank(message = "退款订单号不能为空")
    @JsonIgnore
    private String refundOrderId;
    
    /**
     * 获取业务参数Map（用于构建bizContent）
     */
    @JsonIgnore
    public Map<String, Object> getBizContentMap() {
        Map<String, Object> bizContent = new HashMap<>();
        if (merId != null) bizContent.put("merId", merId);
        if (refundOrderId != null) bizContent.put("refundOrderId", refundOrderId);
        return bizContent;
    }
    
    public String getMerId() {
        return merId;
    }
    
    public void setMerId(String merId) {
        this.merId = merId;
    }
    
    public String getRefundOrderId() {
        return refundOrderId;
    }
    
    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }
}
