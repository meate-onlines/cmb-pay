package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 退款查询响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class RefundQueryResponse extends BaseResponse {
    
    /**
     * 商户号
     */
    @JsonProperty("mer_id")
    private String merId;
    
    /**
     * 原商户订单号
     */
    @JsonProperty("order_id")
    private String orderId;
    
    /**
     * 退款单号
     */
    @JsonProperty("refund_id")
    private String refundId;
    
    /**
     * 平台退款单号
     */
    @JsonProperty("tn_refund_id")
    private String tnRefundId;
    
    /**
     * 退款金额（分）
     */
    @JsonProperty("refund_amt")
    private Long refundAmt;
    
    /**
     * 退款状态
     */
    @JsonProperty("refund_status")
    private String refundStatus;
    
    /**
     * 退款时间
     */
    @JsonProperty("refund_time")
    private String refundTime;
    
    /**
     * 第三方退款单号
     */
    @JsonProperty("third_refund_id")
    private String thirdRefundId;
    
    /**
     * 退款原因
     */
    @JsonProperty("refund_reason")
    private String refundReason;
    
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
    
    public Long getRefundAmt() {
        return refundAmt;
    }
    
    public void setRefundAmt(Long refundAmt) {
        this.refundAmt = refundAmt;
    }
    
    public String getRefundStatus() {
        return refundStatus;
    }
    
    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }
    
    public String getRefundTime() {
        return refundTime;
    }
    
    public void setRefundTime(String refundTime) {
        this.refundTime = refundTime;
    }
    
    public String getThirdRefundId() {
        return thirdRefundId;
    }
    
    public void setThirdRefundId(String thirdRefundId) {
        this.thirdRefundId = thirdRefundId;
    }
    
    public String getRefundReason() {
        return refundReason;
    }
    
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }
}