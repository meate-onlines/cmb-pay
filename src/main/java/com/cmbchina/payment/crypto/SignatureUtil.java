package com.cmbchina.payment.crypto;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 签名工具类 - 适配Java17+
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class SignatureUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(SignatureUtil.class);
    
    /**
     * 获取待签名内容（参数按字典序排序并拼接）
     * 
     * @param params 参数Map
     * @return 待签名内容
     */
    public static String getSignContent(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }
        
        // 过滤空值并按key排序
        return params.entrySet().stream()
            .filter(entry -> entry.getKey() != null && entry.getValue() != null && !entry.getValue().trim().isEmpty())
            .sorted(Map.Entry.comparingByKey())
            .map(entry -> entry.getKey() + "=" + entry.getValue())
            .collect(Collectors.joining("&"));
    }
    
    /**
     * SM2签名
     * 
     * @param content 待签名内容
     * @param privateKey 私钥
     * @return 签名结果
     */
    public static String sm2Sign(String content, String privateKey) {
        return SM2Util.sm2Sign(content, privateKey);
    }
    
    /**
     * SM2验签
     * 
     * @param content 原始内容
     * @param signature 签名
     * @param publicKey 公钥
     * @return 验签结果
     */
    public static boolean sm2Verify(String content, String signature, String publicKey) {
        return SM2Util.sm2Verify(content, signature, publicKey);
    }
    
    /**
     * MD5加密
     * 
     * @param content 待加密内容
     * @return MD5加密结果
     */
    public static String md5(String content) {
        return DigestUtils.md5Hex(content);
    }
    
    /**
     * URL编码
     * 
     * @param value 待编码值
     * @return 编码后的值
     */
    public static String encode(String value) {
        if (value == null) {
            return null;
        }
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            logger.error("URL编码失败: value={}", value, ex);
            return value;
        }
    }
    
    /**
     * URL解码
     * 
     * @param value 待解码值
     * @return 解码后的值
     */
    public static String decode(String value) {
        if (value == null) {
            return null;
        }
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            logger.error("URL解码失败: value={}", value, ex);
            return value;
        }
    }
    
    /**
     * 将查询字符串转换为Map
     * 
     * @param queryString 查询字符串（如：key1=value1&key2=value2）
     * @return 参数Map
     */
    public static Map<String, String> parseQueryString(String queryString) {
        Map<String, String> result = new HashMap<>();
        
        if (queryString == null || queryString.trim().isEmpty()) {
            return result;
        }
        
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=", 2);
            if (keyValue.length == 2) {
                String key = decode(keyValue[0]);
                String value = decode(keyValue[1]);
                result.put(key, value);
            }
        }
        
        return result;
    }
    
    /**
     * 将Map转换为查询字符串
     * 
     * @param params 参数Map
     * @param needEncode 是否需要URL编码
     * @return 查询字符串
     */
    public static String buildQueryString(Map<String, String> params, boolean needEncode) {
        if (params == null || params.isEmpty()) {
            return "";
        }
        
        return params.entrySet().stream()
            .filter(entry -> entry.getKey() != null && entry.getValue() != null)
            .sorted(Map.Entry.comparingByKey())
            .map(entry -> {
                String key = entry.getKey();
                String value = entry.getValue();
                if (needEncode) {
                    key = encode(key);
                    value = encode(value);
                }
                return key + "=" + value;
            })
            .collect(Collectors.joining("&"));
    }
    
    /**
     * 生成API签名（用于请求头）
     * 
     * @param appId 应用ID
     * @param appSecret 应用密钥
     * @param sign 业务签名
     * @param timestamp 时间戳
     * @return API签名
     */
    public static String generateApiSign(String appId, String appSecret, String sign, long timestamp) {
        Map<String, String> apiParams = new HashMap<>();
        apiParams.put("appid", appId);
        apiParams.put("secret", appSecret);
        apiParams.put("sign", sign);
        apiParams.put("timestamp", String.valueOf(timestamp));
        
        String content = getSignContent(apiParams);
        return md5(content).toLowerCase();
    }
    
    /**
     * 验证时间戳是否有效（防重放攻击）
     * 
     * @param timestamp 时间戳（秒）
     * @param toleranceSeconds 容忍的时间差（秒）
     * @return 是否有效
     */
    public static boolean isTimestampValid(long timestamp, long toleranceSeconds) {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        long diff = Math.abs(currentTimestamp - timestamp);
        return diff <= toleranceSeconds;
    }
    
    /**
     * 生成随机字符串
     * 
     * @param length 长度
     * @return 随机字符串
     */
    public static String generateNonce(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        
        return sb.toString();
    }
}