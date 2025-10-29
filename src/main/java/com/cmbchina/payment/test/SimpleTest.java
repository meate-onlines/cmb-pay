package com.cmbchina.payment.test;

import com.cmbchina.payment.CmbPaymentClient;
import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.crypto.SignatureUtil;

/**
 * Simple SDK test
 */
public class SimpleTest {
    
    public static void main(String[] args) {
        System.out.println("=== CMB Payment SDK Test ===");
        
        // Test signature utility
        testSignature();
        
        // Test configuration
        testConfig();
        
        System.out.println("SDK test completed!");
    }
    
    private static void testSignature() {
        System.out.println("\n--- Testing Signature Functions ---");
        
        try {
            // Test parameter sorting
            java.util.Map<String, String> params = new java.util.HashMap<>();
            params.put("c", "3");
            params.put("a", "1");
            params.put("b", "2");
            
            String content = SignatureUtil.getSignContent(params);
            System.out.println("Sorted parameters: " + content);
            
            // Test MD5
            String md5Result = SignatureUtil.md5("test content");
            System.out.println("MD5 result: " + md5Result);
            
            // Test random string generation
            String nonce = SignatureUtil.generateNonce(16);
            System.out.println("Random string: " + nonce);
            
            System.out.println("Signature test passed!");
        } catch (Exception e) {
            System.err.println("Signature test failed: " + e.getMessage());
        }
    }
    
    private static void testConfig() {
        System.out.println("\n--- Testing Configuration ---");
        
        try {
            CmbPaymentConfig config = new CmbPaymentConfig.Builder()
                .merchantId("test_merchant")
                .appId("test_app")
                .appSecret("test_secret")
                .privateKey("test_private_key")
                .publicKey("test_public_key")
                .sandbox(true)
                .build();
            
            System.out.println("Merchant ID: " + config.getMerchantId());
            System.out.println("App ID: " + config.getAppId());
            System.out.println("Sandbox mode: " + config.isSandbox());
            System.out.println("API URL: " + config.getApiUrl());
            
            // Test client creation
            CmbPaymentClient client = new CmbPaymentClient(config);
            System.out.println("Payment client created successfully!");
            
            System.out.println("Configuration test passed!");
        } catch (Exception e) {
            System.err.println("Configuration test failed: " + e.getMessage());
        }
    }
}
