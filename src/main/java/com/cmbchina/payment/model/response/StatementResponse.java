package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 对账单下载地址获取响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class StatementResponse extends BaseResponse {
    
    /**
     * 商户号
     */
    @JsonProperty("mer_id")
    private String merId;
    
    /**
     * 对账单日期
     */
    @JsonProperty("bill_date")
    private String billDate;
    
    /**
     * 账单类型
     */
    @JsonProperty("bill_type")
    private String billType;
    
    /**
     * 对账单下载地址
     */
    @JsonProperty("download_url")
    private String downloadUrl;
    
    /**
     * 地址有效期（秒）
     */
    @JsonProperty("expire_seconds")
    private Integer expireSeconds;
    
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
    
    public String getDownloadUrl() {
        return downloadUrl;
    }
    
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
    
    public Integer getExpireSeconds() {
        return expireSeconds;
    }
    
    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }
}