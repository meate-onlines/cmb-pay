package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 对账单响应
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
     * 账单日期
     */
    @JsonProperty("bill_date")
    private String billDate;
    
    /**
     * 账单类型
     */
    @JsonProperty("bill_type")
    private String billType;
    
    /**
     * 下载地址
     */
    @JsonProperty("download_url")
    private String downloadUrl;
    
    /**
     * 文件大小（字节）
     */
    @JsonProperty("file_size")
    private Long fileSize;
    
    /**
     * 记录总数
     */
    @JsonProperty("record_count")
    private Integer recordCount;
    
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
    
    public Long getFileSize() {
        return fileSize;
    }
    
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
    
    public Integer getRecordCount() {
        return recordCount;
    }
    
    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }
}
