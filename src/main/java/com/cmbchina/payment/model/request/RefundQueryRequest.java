package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

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
    @JsonProperty("mer_id")
    private String merId;
    
    /**
     * 退款单号（与平台退款单号二选一）
     */
    @JsonProperty("refund_id")
    private String refundId;
    
    /**
     * 平台退款单号（与退款单号二选一）
     */
    @JsonProperty("tn_refund_id")
    private String tnRefundId;
    
    public String getMerId() {
        return merId;
    }
    
    public void setMerId(String merId) {
        this.merId = merId;
    }
    
    public String getRefundId() {
        return refundId;
    }
    
    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }
    
    public String getTnRefundId() {
        return tnRefundId;
    }
    
    public void setTnRefundId(String tnRefundId) {
        this.tnRefundId = tnRefundId;
    }
}