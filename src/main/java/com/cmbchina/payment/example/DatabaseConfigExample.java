package com.cmbchina.payment.example;

import com.cmbchina.payment.config.ConfigManager;
import com.cmbchina.payment.config.PaymentConfig;

/**
 * 数据库配置示例
 */
public class DatabaseConfigExample {
    
    public static void main(String[] args) {
        // 示例1: 从数据库加载配置
        loadFromDatabaseExample();
        
        // 示例2: 保存配置到数据库
        saveToDatabaseExample();
    }
    
    /**
     * 从数据库加载配置示例
     */
    private static void loadFromDatabaseExample() {
        System.out.println("=== 从数据库加载配置示例 ===");
        
        try {
            String merchantId = "your_merchant_id";
            PaymentConfig config = ConfigManager.loadFromDatabase(merchantId);
            
            System.out.println("从数据库加载配置成功:");
            System.out.println("商户ID: " + config.getMerchantId());
            System.out.println("API地址: " + config.getApiUrl());
            System.out.println("签名类型: " + config.getSignType());
            System.out.println("是否沙箱: " + config.isSandbox());
            
        } catch (Exception e) {
            System.err.println("从数据库加载配置失败: " + e.getMessage());
        }
    }
    
    /**
     * 保存配置到数据库示例
     */
    private static void saveToDatabaseExample() {
        System.out.println("\n=== 保存配置到数据库示例 ===");
        
        try {
            // 创建配置对象
            PaymentConfig config = new PaymentConfig();
            config.setMerchantId("test_merchant_001");
            config.setPrivateKey("your_private_key");
            config.setPublicKey("your_public_key");
            config.setApiUrl("https://api.cmbchina.com");
            config.setNotifyUrl("https://your-domain.com/notify");
            config.setReturnUrl("https://your-domain.com/return");
            config.setSignType("RSA2");
            config.setCharset("UTF-8");
            config.setConnectTimeout(30000);
            config.setReadTimeout(30000);
            config.setSandbox(false);
            
            // 保存到数据库
            ConfigManager.saveToDatabase(config);
            
            System.out.println("保存配置到数据库成功");
            
        } catch (Exception e) {
            System.err.println("保存配置到数据库失败: " + e.getMessage());
        }
    }
}