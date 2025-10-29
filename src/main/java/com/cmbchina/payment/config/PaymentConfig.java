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
    private String signType = "RSA2";
    private String charset = "UTF-8";
    private int connectTimeout = 30000;
    private int readTimeout = 30000;
    private boolean sandbox = false;
    
    // 构造函数
    public PaymentConfig() {}
    
    public PaymentConfig(String merchantId, String privateKey, String publicKey, String apiUrl) {
        this.merchantId = merchantId;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.apiUrl = apiUrl;
    }
    
    /**
     * 从Properties加载配置
     */
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
        config.setReadTimeout(Integer.parseInt(props.getProperty("cmb.read.timeout", "30000")));
        config.setSandbox(Boolean.parseBoolean(props.getProperty("cmb.sandbox", "false")));
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
    
    public boolean isSandbox() {
        return sandbox;
    }
    
    public void setSandbox(boolean sandbox) {
        this.sandbox = sandbox;
    }
}