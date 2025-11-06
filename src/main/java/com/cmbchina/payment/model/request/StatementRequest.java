package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.util.HashMap;
import java.util.Map;

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
    @JsonIgnore
    private String merId;
    
    /**
     * 账单日期（格式：yyyyMMdd）
     */
    @NotBlank(message = "账单日期不能为空")
    @JsonIgnore
    private String billDate;
    
    /**
     * 账单类型（ALL-全部，SUCCESS-成功，REFUND-退款）
     */
    @JsonIgnore
    private String billType = "ALL";
    /**
     * 行内业务网下载账单须上送：inner，不上送此字段默认通过互联网下载
     */
    @JsonIgnore
    private String urlType;
    
    /**
     * 获取业务参数Map（用于构建bizContent）
     */
    @JsonIgnore
    public Map<String, Object> getBizContentMap() {
        Map<String, Object> bizContent = new HashMap<>();
        if (merId != null) bizContent.put("merId", merId);
        if (billDate != null) bizContent.put("billDate", billDate);
        if (billType != null) bizContent.put("billType", billType);
        if (urlType != null) bizContent.put("urlType", urlType);
        return bizContent;
    }
    
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

    public String getUrlType() {
        return urlType;
    }
    
    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }
}
