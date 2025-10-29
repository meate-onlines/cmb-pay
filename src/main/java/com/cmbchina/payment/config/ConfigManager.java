package com.cmbchina.payment.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 配置管理器，支持从配置文件和数据库读取配置
 */
public class ConfigManager {
    
    private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);
    
    private static final String CONFIG_FILE = "cmb-payment.properties";
    private static final String DB_CONFIG_FILE = "cmb-payment-db.properties";
    
    /**
     * 从配置文件加载配置
     */
    public static PaymentConfig loadFromFile() {
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new RuntimeException("配置文件 " + CONFIG_FILE + " 未找到");
            }
            
            Properties props = new Properties();
            props.load(input);
            
            PaymentConfig config = PaymentConfig.fromProperties(props);
            logger.info("从配置文件加载支付配置成功");
            return config;
            
        } catch (IOException e) {
            logger.error("加载配置文件失败", e);
            throw new RuntimeException("加载配置文件失败", e);
        }
    }
    
    /**
     * 从数据库加载配置
     */
    public static PaymentConfig loadFromDatabase(String merchantId) {
        Properties dbProps = loadDatabaseProperties();
        
        String url = dbProps.getProperty("db.url");
        String username = dbProps.getProperty("db.username");
        String password = dbProps.getProperty("db.password");
        String tableName = dbProps.getProperty("db.table.name", "cmb_payment_config");
        
        String sql = "SELECT config_key, config_value FROM " + tableName + " WHERE merchant_id = ?";
        
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, merchantId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                Properties props = new Properties();
                while (rs.next()) {
                    String key = rs.getString("config_key");
                    String value = rs.getString("config_value");
                    props.setProperty(key, value);
                }
                
                PaymentConfig config = PaymentConfig.fromProperties(props);
                config.setMerchantId(merchantId);
                logger.info("从数据库加载支付配置成功，商户ID: {}", merchantId);
                return config;
            }
            
        } catch (SQLException e) {
            logger.error("从数据库加载配置失败", e);
            throw new RuntimeException("从数据库加载配置失败", e);
        }
    }
    
    /**
     * 加载数据库连接配置
     */
    private static Properties loadDatabaseProperties() {
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE)) {
            if (input == null) {
                throw new RuntimeException("数据库配置文件 " + DB_CONFIG_FILE + " 未找到");
            }
            
            Properties props = new Properties();
            props.load(input);
            return props;
            
        } catch (IOException e) {
            logger.error("加载数据库配置文件失败", e);
            throw new RuntimeException("加载数据库配置文件失败", e);
        }
    }
    
    /**
     * 保存配置到数据库
     */
    public static void saveToDatabase(PaymentConfig config) {
        Properties dbProps = loadDatabaseProperties();
        
        String url = dbProps.getProperty("db.url");
        String username = dbProps.getProperty("db.username");
        String password = dbProps.getProperty("db.password");
        String tableName = dbProps.getProperty("db.table.name", "cmb_payment_config");
        
        String insertSql = "INSERT INTO " + tableName + " (merchant_id, config_key, config_value) VALUES (?, ?, ?) " +
                          "ON DUPLICATE KEY UPDATE config_value = VALUES(config_value)";
        
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(insertSql)) {
            
            String merchantId = config.getMerchantId();
            
            // 保存各项配置
            saveConfigValue(stmt, merchantId, "cmb.merchant.id", config.getMerchantId());
            saveConfigValue(stmt, merchantId, "cmb.private.key", config.getPrivateKey());
            saveConfigValue(stmt, merchantId, "cmb.public.key", config.getPublicKey());
            saveConfigValue(stmt, merchantId, "cmb.api.url", config.getApiUrl());
            saveConfigValue(stmt, merchantId, "cmb.notify.url", config.getNotifyUrl());
            saveConfigValue(stmt, merchantId, "cmb.return.url", config.getReturnUrl());
            saveConfigValue(stmt, merchantId, "cmb.sign.type", config.getSignType());
            saveConfigValue(stmt, merchantId, "cmb.charset", config.getCharset());
            saveConfigValue(stmt, merchantId, "cmb.connect.timeout", String.valueOf(config.getConnectTimeout()));
            saveConfigValue(stmt, merchantId, "cmb.read.timeout", String.valueOf(config.getReadTimeout()));
            saveConfigValue(stmt, merchantId, "cmb.sandbox", String.valueOf(config.isSandbox()));
            
            logger.info("保存支付配置到数据库成功，商户ID: {}", merchantId);
            
        } catch (SQLException e) {
            logger.error("保存配置到数据库失败", e);
            throw new RuntimeException("保存配置到数据库失败", e);
        }
    }
    
    private static void saveConfigValue(PreparedStatement stmt, String merchantId, String key, String value) throws SQLException {
        if (value != null) {
            stmt.setString(1, merchantId);
            stmt.setString(2, key);
            stmt.setString(3, value);
            stmt.addBatch();
        }
    }
}