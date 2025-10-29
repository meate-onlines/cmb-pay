package com.cmbchina.payment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

/**
 * 基础请求类
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseRequest {
    
    /**
     * 版本号，固定为0.0.1
     */
    @NotBlank(message = "版本号不能为空")
    private String version = "0.0.1";
    
    /**
     * 编码方式，固定为UTF-8
     */
    @NotBlank(message = "编码方式不能为空")
    private String encoding = "UTF-8";
    
    /**
     * 签名方法，固定为02（国密SM2）
     */
    @NotBlank(message = "签名方法不能为空")
    private String signMethod = "02";
    
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
    
    public String getSign() {
        return sign;
    }
    
    public void setSign(String sign) {
        this.sign = sign;
    }
}
