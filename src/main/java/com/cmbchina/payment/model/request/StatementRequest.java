package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

/**
 * 对账单请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class StatementRequest extends BaseRequest {
    
    /**
     * 商户号
     */
    @NotBlank(message = "商户号不能为空")
    @JsonProperty("mer_id")
    private String merId;
    
    /**
     * 账单日期（格式：yyyyMMdd）
     */
    @NotBlank(message = "账单日期不能为空")
    @JsonProperty("bill_date")
    private String billDate;
    
    /**
     * 账单类型（ALL-全部，SUCCESS-成功，REFUND-退款）
     */
    @JsonProperty("bill_type")
    private String billType = "ALL";
    
    public String getMerId() {
        return merId;
    }
    
    public void setMerId(String merId) {
        this.merId = merId;
    }
    
    public String getBillDate() {
        return billDate;
    }
    
    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }
    
    public String getBillType() {
        return billType;
    }
    
    public void setBillType(String billType) {
        this.billType = billType;
    }
}
