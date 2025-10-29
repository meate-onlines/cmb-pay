package com.cmbchina.payment.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 支付配置类测试
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
class CmbPaymentConfigTest {
    
    @Test
    void testDefaultValues() {
        CmbPaymentConfig config = new CmbPaymentConfig();
        
        assertEquals("https://api.cmburl.cn:8065", config.getApiUrl());
        assertEquals("SM2", config.getSignType());
        assertEquals("UTF-8", config.getCharset());
        assertEquals(30000, config.getConnectTimeout());
        assertEquals(30000, config.getReadTimeout());
        assertFalse(config.isSandbox());
        assertEquals("0.0.1", config.getVersion());
        assertEquals("UTF-8", config.getEncoding());
        assertEquals("02", config.getSignMethod());
    }
    
    @Test
    void testConstructorWithParameters() {
        String merchantId = "123456789";
        String appId = "test-app-id";
        String appSecret = "test-app-secret";
        String privateKey = "test-private-key";
        String publicKey = "test-public-key";
        
        CmbPaymentConfig config = new CmbPaymentConfig(
            merchantId, appId, appSecret, privateKey, publicKey
        );
        
        assertEquals(merchantId, config.getMerchantId());
        assertEquals(appId, config.getAppId());
        assertEquals(appSecret, config.getAppSecret());
        assertEquals(privateKey, config.getPrivateKey());
        assertEquals(publicKey, config.getPublicKey());
    }
    
    @Test
    void testBuilder() {
        CmbPaymentConfig config = new CmbPaymentConfig.Builder()
            .merchantId("123456789")
            .appId("test-app-id")
            .appSecret("test-app-secret")
            .privateKey("test-private-key")
            .publicKey("test-public-key")
            .apiUrl("https://test.api.com")
            .notifyUrl("https://test.com/notify")
            .returnUrl("https://test.com/return")
            .connectTimeout(60000)
            .readTimeout(60000)
            .sandbox(true)
            .build();
        
        assertEquals("123456789", config.getMerchantId());
        assertEquals("test-app-id", config.getAppId());
        assertEquals("test-app-secret", config.getAppSecret());
        assertEquals("test-private-key", config.getPrivateKey());
        assertEquals("test-public-key", config.getPublicKey());
        assertEquals("https://test.api.com", config.getApiUrl());
        assertEquals("https://test.com/notify", config.getNotifyUrl());
        assertEquals("https://test.com/return", config.getReturnUrl());
        assertEquals(60000, config.getConnectTimeout());
        assertEquals(60000, config.getReadTimeout());
        assertTrue(config.isSandbox());
    }
    
    @Test
    void testSettersAndGetters() {
        CmbPaymentConfig config = new CmbPaymentConfig();
        
        config.setMerchantId("123456789");
        config.setAppId("test-app-id");
        config.setAppSecret("test-app-secret");
        config.setPrivateKey("test-private-key");
        config.setPublicKey("test-public-key");
        config.setApiUrl("https://test.api.com");
        config.setNotifyUrl("https://test.com/notify");
        config.setReturnUrl("https://test.com/return");
        config.setSignType("RSA2");
        config.setCharset("GBK");
        config.setConnectTimeout(60000);
        config.setReadTimeout(60000);
        config.setSandbox(true);
        config.setVersion("1.0.0");
        config.setEncoding("GBK");
        config.setSignMethod("01");
        
        assertEquals("123456789", config.getMerchantId());
        assertEquals("test-app-id", config.getAppId());
        assertEquals("test-app-secret", config.getAppSecret());
        assertEquals("test-private-key", config.getPrivateKey());
        assertEquals("test-public-key", config.getPublicKey());
        assertEquals("https://test.api.com", config.getApiUrl());
        assertEquals("https://test.com/notify", config.getNotifyUrl());
        assertEquals("https://test.com/return", config.getReturnUrl());
        assertEquals("RSA2", config.getSignType());
        assertEquals("GBK", config.getCharset());
        assertEquals(60000, config.getConnectTimeout());
        assertEquals(60000, config.getReadTimeout());
        assertTrue(config.isSandbox());
        assertEquals("1.0.0", config.getVersion());
        assertEquals("GBK", config.getEncoding());
        assertEquals("01", config.getSignMethod());
    }
}