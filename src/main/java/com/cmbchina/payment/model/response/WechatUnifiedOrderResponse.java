package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 微信统一下单响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class WechatUnifiedOrderResponse extends BaseResponse {
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    /**
     * 商户号（仅在returnCode为SUCCESS时返回）
     */
    private String merId;
    
    /**
     * 商户订单号（仅在returnCode为SUCCESS时返回）
     */
    private String orderId;
    
    /**
     * 交易类型（仅在returnCode为SUCCESS时返回）
     */
    private String tradeType;
    
    /**
     * 第三方错误描述（第三方处理失败时返回）
     */
    private String errDescription;
    
    /**
     * 平台订单号，招行生成的订单号（仅在returnCode和respCode都为SUCCESS时返回）
     */
    private String cmbOrderId;
    
    /**
     * 订单发送时间，格式为yyyyMMddHHmmss（仅在returnCode和respCode都为SUCCESS时返回）
     */
    private String txnTime;
    
    /**
     * 支付数据，JSON对象（仅在returnCode和respCode都为SUCCESS时返回）
     * trade_type为JSAPI或APP时返回，拉起支付时使用
     */
    private Object payData;
    
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
    
    public String getTradeType() {
        return tradeType;
    }
    
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
    
    public String getErrDescription() {
        return errDescription;
    }
    
    public void setErrDescription(String errDescription) {
        this.errDescription = errDescription;
    }
    
    public String getCmbOrderId() {
        return cmbOrderId;
    }
    
    public void setCmbOrderId(String cmbOrderId) {
        this.cmbOrderId = cmbOrderId;
    }
    
    public String getTxnTime() {
        return txnTime;
    }
    
    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }
    
    public Object getPayData() {
        return payData;
    }
    
    public void setPayData(Object payData) {
        this.payData = payData;
    }
    
    /**
     * 获取支付数据的 JSON 字符串格式
     * 
     * @return JSON 字符串，如果 payData 为 null 或转换失败则返回 null
     */
    public String getPayDataAsString() {
        if (payData == null) {
            return null;
        }
        
        if (payData instanceof String) {
            return (String) payData;
        }
        
        try {
            return objectMapper.writeValueAsString(payData);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
