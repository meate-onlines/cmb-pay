package com.cmbchina.payment.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;

/**
 * 签名工具类
 */
public class SignUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(SignUtil.class);
    
    private static final String RSA_ALGORITHM = "RSA";
    private static final String RSA_SIGN_ALGORITHM = "SHA256withRSA";
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    
    /**
     * RSA签名
     */
    public static String rsaSign(String content, String privateKey) {
        try {
            PrivateKey priKey = getPrivateKey(privateKey);
            Signature signature = Signature.getInstance(RSA_SIGN_ALGORITHM);
            signature.initSign(priKey);
            signature.update(content.getBytes(StandardCharsets.UTF_8));
            byte[] signed = signature.sign();
            return Base64.getEncoder().encodeToString(signed);
        } catch (Exception e) {
            logger.error("RSA签名失败", e);
            throw new RuntimeException("RSA签名失败", e);
        }
    }
    
    /**
     * RSA验签
     */
    public static boolean rsaVerify(String content, String sign, String publicKey) {
        try {
            PublicKey pubKey = getPublicKey(publicKey);
            Signature signature = Signature.getInstance(RSA_SIGN_ALGORITHM);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(StandardCharsets.UTF_8));
            return signature.verify(Base64.getDecoder().decode(sign));
        } catch (Exception e) {
            logger.error("RSA验签失败", e);
            return false;
        }
    }
    
    /**
     * HMAC-SHA256签名
     */
    public static String hmacSha256Sign(String content, String secretKey) {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA256_ALGORITHM);
            mac.init(secretKeySpec);
            byte[] signed = mac.doFinal(content.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(signed);
        } catch (Exception e) {
            logger.error("HMAC-SHA256签名失败", e);
            throw new RuntimeException("HMAC-SHA256签名失败", e);
        }
    }
    
    /**
     * 生成待签名字符串
     */
    public static String buildSignString(Map<String, Object> params) {
        // 过滤空值并排序
        TreeMap<String, Object> sortedParams = new TreeMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().toString().isEmpty()) {
                sortedParams.put(entry.getKey(), entry.getValue());
            }
        }
        
        // 拼接字符串
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : sortedParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        
        return sb.toString();
    }
    
    /**
     * 生成MD5签名
     */
    public static String md5Sign(String content, String key) {
        try {
            String signContent = content + "&key=" + key;
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(signContent.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(digest).toUpperCase();
        } catch (Exception e) {
            logger.error("MD5签名失败", e);
            throw new RuntimeException("MD5签名失败", e);
        }
    }
    
    /**
     * 验证MD5签名
     */
    public static boolean md5Verify(String content, String sign, String key) {
        String expectedSign = md5Sign(content, key);
        return expectedSign.equals(sign);
    }
    
    /**
     * 获取私钥
     */
    private static PrivateKey getPrivateKey(String privateKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        return keyFactory.generatePrivate(keySpec);
    }
    
    /**
     * 获取公钥
     */
    private static PublicKey getPublicKey(String publicKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        return keyFactory.generatePublic(keySpec);
    }
    
    /**
     * 字节数组转十六进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}