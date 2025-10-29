package com.cmbchina.payment.config;

import java.util.Properties;

/**
 * 支付配置类
 */
public class PaymentConfig {
    
    private String merchantId;
    private String privateKey;
    private String publicKey;
    private String apiUrl;
    private String notifyUrl;
    private String returnUrl;
    private String signType;
    private String charset;
    private int connectTimeout;
    private int readTimeout;
    private boolean debug;
    
    // 构造函数
    public PaymentConfig() {
        this.charset = "UTF-8";
        this.signType = "RSA2";
        this.connectTimeout = 30000;
        this.readTimeout = 60000;
        this.debug = false;
    }
    
    // 从Properties创建配置
    public static PaymentConfig fromProperties(Properties props) {
        PaymentConfig config = new PaymentConfig();
        config.setMerchantId(props.getProperty("cmb.merchant.id"));
        config.setPrivateKey(props.getProperty("cmb.private.key"));
        config.setPublicKey(props.getProperty("cmb.public.key"));
        config.setApiUrl(props.getProperty("cmb.api.url"));
        config.setNotifyUrl(props.getProperty("cmb.notify.url"));
        config.setReturnUrl(props.getProperty("cmb.return.url"));
        config.setSignType(props.getProperty("cmb.sign.type", "RSA2"));
        config.setCharset(props.getProperty("cmb.charset", "UTF-8"));
        config.setConnectTimeout(Integer.parseInt(props.getProperty("cmb.connect.timeout", "30000")));
        config.setReadTimeout(Integer.parseInt(props.getProperty("cmb.read.timeout", "60000")));
        config.setDebug(Boolean.parseBoolean(props.getProperty("cmb.debug", "false")));
        return config;
    }
    
    // Getter和Setter方法
    public String getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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
    
    public boolean isDebug() {
        return debug;
    }
    
    public void setDebug(boolean debug) {
        this.debug = debug;
    }
    
    /**
     * 验证配置是否完整
     */
    public boolean isValid() {
        return merchantId != null && !merchantId.trim().isEmpty()
            && privateKey != null && !privateKey.trim().isEmpty()
            && publicKey != null && !publicKey.trim().isEmpty()
            && apiUrl != null && !apiUrl.trim().isEmpty();
    }
}