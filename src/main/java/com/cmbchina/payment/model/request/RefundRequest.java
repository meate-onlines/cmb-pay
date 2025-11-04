package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.HashMap;
import java.util.Map;

/**
 * 退款申请请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class RefundRequest extends BaseRequest {
    
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
     * 退款订单号
     */
    @NotBlank(message = "退款订单号不能为空")
    @JsonIgnore
    private String refundOrderId;
    
    /**
     * 退款金额（分）
     */
    @NotNull(message = "退款金额不能为空")
    @Positive(message = "退款金额必须大于0")
    @JsonIgnore
    private Long refundAmt;
    
    /**
     * 退款原因
     */
    @JsonIgnore
    private String refundReason;
    
    /**
     * 异步通知地址
     */
    @JsonIgnore
    private String notifyUrl;
    
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
        if (refundOrderId != null) {
            bizContent.put("refundOrderId", refundOrderId);
        }
        if (refundAmt != null) {
            bizContent.put("refundAmt", refundAmt);
        }
        if (refundReason != null) {
            bizContent.put("refundReason", refundReason);
        }
        if (notifyUrl != null) {
            bizContent.put("notifyUrl", notifyUrl);
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
    
    public String getRefundOrderId() {
        return refundOrderId;
    }
    
    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }
    
    public Long getRefundAmt() {
        return refundAmt;
    }
    
    public void setRefundAmt(Long refundAmt) {
        this.refundAmt = refundAmt;
    }
    
    public String getRefundReason() {
        return refundReason;
    }
    
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }
    
    public String getNotifyUrl() {
        return notifyUrl;
    }
    
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    
    public String getAttach() {
        return attach;
    }
    
    public void setAttach(String attach) {
        this.attach = attach;
    }
}
