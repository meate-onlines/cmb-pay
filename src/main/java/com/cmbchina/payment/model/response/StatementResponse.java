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
     * 商户号（returnCode为SUCCESS时返回）
     * 请求报文中的商户号
     */
    @JsonProperty("merId")
    private String merId;
    
    /**
     * 账单下载地址（returnCode或respCode为SUCCESS时返回）
     * 对账单下载URL
     */
    @JsonProperty("fileDownloadUrl")
    private String fileDownloadUrl;
    
    public String getMerId() {
        return merId;
    }
    
    public void setMerId(String merId) {
        this.merId = merId;
    }
    
    public String getFileDownloadUrl() {
        return fileDownloadUrl;
    }
    
    public void setFileDownloadUrl(String fileDownloadUrl) {
        this.fileDownloadUrl = fileDownloadUrl;
    }
}
