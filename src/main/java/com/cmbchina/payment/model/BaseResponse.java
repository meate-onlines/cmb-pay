package com.cmbchina.payment.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 基础响应类
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseResponse {
    
    /**
     * 版本号
     */
    private String version;
    
    /**
     * 编码方式
     */
    private String encoding;
    
    /**
     * 签名方法
     */
    private String signMethod;
    
    /**
     * 返回码
     */
    private String returnCode;
    
    /**
     * 返回消息
     */
    private String returnMsg;
    
    /**
     * 业务结果码
     */
    private String resultCode;
    
    /**
     * 业务结果描述
     */
    private String resultMsg;
    
    /**
     * 签名
     */
    private String sign;
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getEncoding() {
        return encoding;
    }
    
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    
    public String getSignMethod() {
        return signMethod;
    }
    
    public void setSignMethod(String signMethod) {
        this.signMethod = signMethod;
    }
    
    public String getReturnCode() {
        return returnCode;
    }
    
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    
    public String getReturnMsg() {
        return returnMsg;
    }
    
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
    
    public String getResultCode() {
        return resultCode;
    }
    
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    
    public String getResultMsg() {
        return resultMsg;
    }
    
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
    
    public String getSign() {
        return sign;
    }
    
    public void setSign(String sign) {
        this.sign = sign;
    }
    
    /**
     * 判断请求是否成功
     * 
     * @return 是否成功
     */
    public boolean isSuccess() {
        return "SUCCESS".equals(returnCode) && "SUCCESS".equals(resultCode);
    }
}