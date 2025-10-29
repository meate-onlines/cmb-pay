package com.cmbchina.payment.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 招商银行支付配置类
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class CmbPaymentConfig {
    
    /**
     * 商户ID
     */
    @NotBlank(message = "商户ID不能为空")
    private String merchantId;
    
    /**
     * 应用ID
     */
    @NotBlank(message = "应用ID不能为空")
    private String appId;
    
    /**
     * 应用密钥
     */
    @NotBlank(message = "应用密钥不能为空")
    private String appSecret;
    
    /**
     * 商户私钥（SM2格式）
     */
    @NotBlank(message = "商户私钥不能为空")
    private String privateKey;
    
    /**
     * 招行公钥（SM2格式）
     */
    @NotBlank(message = "招行公钥不能为空")
    private String publicKey;
    
    /**
     * API基础URL
     */
    @NotBlank(message = "API基础URL不能为空")
    private String apiUrl = "https://api.cmburl.cn:8065";
    
    /**
     * 回调通知URL
     */
    private String notifyUrl;
    
    /**
     * 返回URL
     */
    private String returnUrl;
    
    /**
     * 签名类型（固定为SM2）
     */
    private String signType = "SM2";
    
    /**
     * 字符集
     */
    private String charset = "UTF-8";
    
    /**
     * 连接超时时间（毫秒）
     */
    @Positive(message = "连接超时时间必须大于0")
    private int connectTimeout = 30000;
    
    /**
     * 读取超时时间（毫秒）
     */
    @Positive(message = "读取超时时间必须大于0")
    private int readTimeout = 30000;
    
    /**
     * 是否为沙箱环境
     */
    private boolean sandbox = false;
    
    /**
     * 版本号
     */
    private String version = "0.0.1";
    
    /**
     * 编码方式
     */
    private String encoding = "UTF-8";
    
    /**
     * 签名方法（02表示国密SM2）
     */
    private String signMethod = "02";
    
    // 构造函数
    public CmbPaymentConfig() {}
    
    public CmbPaymentConfig(String merchantId, String appId, String appSecret, 
                           String privateKey, String publicKey) {
        this.merchantId = merchantId;
        this.appId = appId;
        this.appSecret = appSecret;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }
    
    // Getter and Setter methods
    public String getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
    
    public String getAppId() {
        return appId;
    }
    
    public void setAppId(String appId) {
        this.appId = appId;
    }
    
    public String getAppSecret() {
        return appSecret;
    }
    
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
    
    public String getPrivateKey() {
        return privateKey;
    }
    
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
    
    public String getPublicKey() {
        return publicKey;
    }
    
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
    
    public String getApiUrl() {
        return apiUrl;
    }
    
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    
    public String getNotifyUrl() {
        return notifyUrl;
    }
    
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    
    public String getReturnUrl() {
        return returnUrl;
    }
    
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
    
    public String getSignType() {
        return signType;
    }
    
    public void setSignType(String signType) {
        this.signType = signType;
    }
    
    public String getCharset() {
        return charset;
    }
    
    public void setCharset(String charset) {
        this.charset = charset;
    }
    
    public int getConnectTimeout() {
        return connectTimeout;
    }
    
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }
    
    public int getReadTimeout() {
        return readTimeout;
    }
    
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
    
    public boolean isSandbox() {
        return sandbox;
    }
    
    public void setSandbox(boolean sandbox) {
        this.sandbox = sandbox;
    }
    
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
    
    /**
     * 构建器模式
     */
    public static class Builder {
        private CmbPaymentConfig config = new CmbPaymentConfig();
        
        public Builder merchantId(String merchantId) {
            config.setMerchantId(merchantId);
            return this;
        }
        
        public Builder appId(String appId) {
            config.setAppId(appId);
            return this;
        }
        
        public Builder appSecret(String appSecret) {
            config.setAppSecret(appSecret);
            return this;
        }
        
        public Builder privateKey(String privateKey) {
            config.setPrivateKey(privateKey);
            return this;
        }
        
        public Builder publicKey(String publicKey) {
            config.setPublicKey(publicKey);
            return this;
        }
        
        public Builder apiUrl(String apiUrl) {
            config.setApiUrl(apiUrl);
            return this;
        }
        
        public Builder notifyUrl(String notifyUrl) {
            config.setNotifyUrl(notifyUrl);
            return this;
        }
        
        public Builder returnUrl(String returnUrl) {
            config.setReturnUrl(returnUrl);
            return this;
        }
        
        public Builder connectTimeout(int connectTimeout) {
            config.setConnectTimeout(connectTimeout);
            return this;
        }
        
        public Builder readTimeout(int readTimeout) {
            config.setReadTimeout(readTimeout);
            return this;
        }
        
        public Builder sandbox(boolean sandbox) {
            config.setSandbox(sandbox);
            return this;
        }
        
        public CmbPaymentConfig build() {
            return config;
        }
    }
}
