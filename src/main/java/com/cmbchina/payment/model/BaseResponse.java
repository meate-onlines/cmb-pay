package com.cmbchina.payment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("version")
    private String version;
    
    /**
     * 编码方式
     */
    @JsonProperty("encoding")
    private String encoding;
    
    /**
     * 签名方法
     */
    @JsonProperty("signMethod")
    private String signMethod;
    
    /**
     * 返回码
     * SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。
     * SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等
     */
    @JsonProperty("returnCode")
    private String returnCode;
    
    /**
     * 响应码（returnCode为SUCCESS时返回）
     * 业务错误码，成功为SUCCESS，失败为FAIL
     */
    @JsonProperty("respCode")
    private String respCode;
    
    /**
     * 应答信息（returnCode或respCode为FAIL时返回）
     * 请求处理失败的详细描述信息
     */
    @JsonProperty("respMsg")
    private String respMsg;

    /**
     * 错误码（returnCode或respCode为FAIL时返回）
     * 请求处理失败的错误码信息
     */
    @JsonProperty("errCode")
    private String errCode;
    
    /**
     * 签名
     */
    @JsonProperty("sign")
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
    
    public String getRespCode() {
        return respCode;
    }
    
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
    
    public String getRespMsg() {
        return respMsg;
    }
    
    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
    
    public String getSign() {
        return sign;
    }
    
    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getErrCode() {
        return errCode;
    }
    
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
    
    /**
     * 判断请求是否成功
     * 
     * @return 是否成功
     */
    public boolean isSuccess() {
        return "SUCCESS".equals(returnCode) && "SUCCESS".equals(respCode);
    }
}
