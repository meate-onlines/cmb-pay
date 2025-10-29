package com.cmbchina.payment.test;

import com.cmbchina.payment.CmbPaymentClient;
import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.crypto.SignatureUtil;
import com.cmbchina.payment.model.request.QrCodeApplyRequest;
import com.cmbchina.payment.model.response.QrCodeApplyResponse;
import com.cmbchina.payment.exception.CmbPaymentException;

/**
 * SDK功能测试
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class SdkTest {
    
    public static void main(String[] args) {
        System.out.println("=== 招商银行支付SDK测试 ===");
        
        // 测试签名功能
        testSignature();
        
        // 测试配置
        testConfig();
        
        System.out.println("SDK test completed!");
    }
    
    /**
     * 测试签名功能
     */
    private static void testSignature() {
        System.out.println("\n--- 测试签名功能 ---");
        
        try {
            // 测试参数排序
            java.util.Map<String, String> params = new java.util.HashMap<>();
            params.put("c", "3");
            params.put("a", "1");
            params.put("b", "2");
            
            String content = SignatureUtil.getSignContent(params);
            System.out.println("参数排序结果: " + content);
            
            // 测试MD5
            String md5Result = SignatureUtil.md5("test content");
            System.out.println("MD5结果: " + md5Result);
            
            // Test random string generation
            String nonce = SignatureUtil.generateNonce(16);
            System.out.println("Random string: " + nonce);
            
            System.out.println("Signature test passed!");
        } catch (Exception e) {
            System.err.println("签名功能测试失败: " + e.getMessage());
        }
    }
    
    /**
     * 测试配置
     */
    private static void testConfig() {
        System.out.println("\n--- 测试配置功能 ---");
        
        try {
            CmbPaymentConfig config = new CmbPaymentConfig.Builder()
                .merchantId("test_merchant")
                .appId("test_app")
                .appSecret("test_secret")
                .privateKey("test_private_key")
                .publicKey("test_public_key")
                .sandbox(true)
                .build();
            
            System.out.println("商户ID: " + config.getMerchantId());
            System.out.println("应用ID: " + config.getAppId());
            System.out.println("沙箱模式: " + config.isSandbox());
            System.out.println("API地址: " + config.getApiUrl());
            
            // Test client creation
            CmbPaymentClient client = new CmbPaymentClient(config);
            System.out.println("支付客户端创建成功！");
            
            System.out.println("Configuration test passed!");
        } catch (Exception e) {
            System.err.println("配置功能测试失败: " + e.getMessage());
        }
    }
}
