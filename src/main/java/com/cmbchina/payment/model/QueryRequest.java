package com.cmbchina.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 查询请求模型
 */
public class QueryRequest {
    
    @JsonProperty("merchant_id")
    private String merchantId;
    
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    
    @JsonProperty("trade_no")
    private String tradeNo;
    
    // 构造函数
    public QueryRequest() {}
    
    public QueryRequest(String merchantId, String outTradeNo) {
        this.merchantId = merchantId;
        this.outTradeNo = outTradeNo;
    }
    
    public QueryRequest(String merchantId, String outTradeNo, String tradeNo) {
        this.merchantId = merchantId;
        this.outTradeNo = outTradeNo;
        this.tradeNo = tradeNo;
    }
    
    // Getter和Setter方法
    public String getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
    
    public String getOutTradeNo() {
        return outTradeNo;
    }
    
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
    
    public String getTradeNo() {
        return tradeNo;
    }
    
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}