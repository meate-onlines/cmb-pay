package com.cmbchina.payment.crypto;

import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Base64;

/**
 * SM2加密工具类 - 适配Java17+
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class SM2Util {
    
    private static final Logger logger = LoggerFactory.getLogger(SM2Util.class);
    
    private static final String SM2_KEY_TITLE = "3059301306072a8648ce3d020106082a811ccf5501822d03420004";
    
    public static final String USER_ID = "1234567812345678";
    
    /**
     * SM2签名
     * 
     * @param content 待签名内容
     * @param privateKey 私钥（16进制字符串）
     * @return 签名结果（Base64编码）
     */
    public static String sm2Sign(String content, String privateKey) {
        try {
            // 初始化私钥
            BCECPrivateKey bcecPrivateKey = BCUtil.getPrivatekeyFromD(new BigInteger(privateKey, 16));

            logger.info("bcecPrivateKey: {}", bcecPrivateKey);
            // 使用SM3withSM2进行签名
            byte[] sign = BCUtil.signSm3WithSm2(content.getBytes(), USER_ID.getBytes(), bcecPrivateKey);

            logger.info("sign: {}", sign);
            // 将原始签名转换为ASN1格式并进行Base64编码
            return encodeBase64(signRawToAsn1(sign));
        } catch (Exception ex) {
            logger.error("SM2签名失败: content={}, error={}", content, ex.getMessage(), ex);
            throw new RuntimeException("SM2签名失败", ex);
        }
    }
    
    /**
     * SM2验签
     * 
     * @param content 原始内容
     * @param signature 签名（Base64编码）
     * @param publicKey 公钥（Base64编码）
     * @return 验签结果
     */
    public static boolean sm2Verify(String content, String signature, String publicKey) {
        try {
            // 解析公钥
            Sm2KeyPair sm2KeyPair = parseBase64ToRawKey(publicKey);
            if (sm2KeyPair == null) {
                logger.error("公钥解析失败: publicKey={}", publicKey);
                return false;
            }
            
            // 初始化公钥
            BCECPublicKey bcecPublicKey = BCUtil.getPublickeyFromXY(
                new BigInteger(sm2KeyPair.getX(), 16), 
                new BigInteger(sm2KeyPair.getY(), 16)
            );
            
            // 将ASN1格式签名转换为原始格式
            byte[] sign = signAsn1ToRaw(decodeBase64(signature));
            
            // 验证签名
            return BCUtil.verifySm3WithSm2(content.getBytes(), USER_ID.getBytes(), sign, bcecPublicKey);
            
        } catch (Exception ex) {
            logger.error("SM2验签失败: content={}, signature={}, error={}", content, signature, ex.getMessage(), ex);
            return false;
        }
    }
    
    /**
     * BASE64格式公钥转换为裸公钥
     * 
     * @param sm2Key Base64编码的公钥
     * @return SM2密钥对象
     */
    private static Sm2KeyPair parseBase64ToRawKey(String sm2Key) {
        if (sm2Key == null || sm2Key.trim().isEmpty()) {
            return null;
        }
        
        try {
            String sm2Asn1 = Hex.toHexString(decodeBase64(sm2Key));
            if (!sm2Asn1.startsWith(SM2_KEY_TITLE)) {
                logger.error("公钥格式不正确: sm2Key={}", sm2Key);
                return null;
            }
            
            String sm2Xy = sm2Asn1.substring(SM2_KEY_TITLE.length());
            String sm2X = sm2Xy.substring(0, sm2Xy.length() / 2);
            String sm2Y = sm2Xy.substring(sm2Xy.length() / 2);
            
            return new Sm2KeyPair(SM2_KEY_TITLE, sm2X, sm2Y);
        } catch (Exception ex) {
            logger.error("公钥解析异常: sm2Key={}, error={}", sm2Key, ex.getMessage(), ex);
            return null;
        }
    }
    
    /**
     * 将字节数组转换为Base64格式字符串
     * 
     * @param data 字节数组
     * @return Base64编码字符串
     */
    public static String encodeBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
    
    /**
     * 将Base64格式字符串转为字节数组
     * 
     * @param data Base64编码字符串
     * @return 字节数组
     */
    public static byte[] decodeBase64(String data) {
        return Base64.getDecoder().decode(data);
    }
    
    /**
     * 将BC SM2 RAW签名值转化为ASN1格式签名值
     * 
     * @param bcCipTxt 原始签名
     * @return ASN1格式签名
     * @throws Exception 转换异常
     */
    private static byte[] signRawToAsn1(byte[] bcCipTxt) throws Exception {
        byte[] netSignCipTxt = new byte[73];
        
        byte[] signR = new byte[32];
        byte[] signS = new byte[32];
        
        System.arraycopy(bcCipTxt, 0, signR, 0, 32);
        System.arraycopy(bcCipTxt, 32, signS, 0, 32);
        
        // signR补位
        int wPos = 4;
        netSignCipTxt[0] = 0x30;
        netSignCipTxt[2] = 0x02;
        if ((signR[0] & 0xFF) >= 128) {
            netSignCipTxt[wPos - 1] = 0x21;
            netSignCipTxt[wPos] = 0x00;
            wPos += 1;
        } else {
            netSignCipTxt[wPos - 1] = 0x20;
        }
        System.arraycopy(signR, 0, netSignCipTxt, wPos, 32);
        wPos += 32;
        
        // signS补位
        netSignCipTxt[wPos] = 0x02;
        wPos += 1;
        if ((signS[0] & 0xFF) >= 128) {
            netSignCipTxt[wPos] = 0x21;
            wPos += 1;
            netSignCipTxt[wPos] = 0x00;
            wPos += 1;
        } else {
            netSignCipTxt[wPos] = 0x20;
            wPos += 1;
        }
        System.arraycopy(signS, 0, netSignCipTxt, wPos, 32);
        wPos += 32;
        
        if (70 == wPos) {
            netSignCipTxt[1] = 0x44;
        } else if (71 == wPos) {
            netSignCipTxt[1] = 0x45;
        } else if (72 == wPos) {
            netSignCipTxt[1] = 0x46;
        } else {
            throw new Exception("signRawToAsn1 Error!");
        }
        
        byte[] resultBytes = new byte[wPos];
        System.arraycopy(netSignCipTxt, 0, resultBytes, 0, wPos);
        
        return resultBytes;
    }
    
    /**
     * 将ASN1格式签名值转化为BC SM2 RAW 签名值
     * 
     * @param signature ASN1格式签名值
     * @return RAW签名值
     * @throws Exception 转换异常
     */
    private static byte[] signAsn1ToRaw(byte[] signature) throws Exception {
        byte[] resultBytes = new byte[64];
        
        // 截取signR
        int wPos = 3;
        if ((signature[wPos] & 0xFF) == 32) {
            wPos += 1;
        } else if ((signature[wPos] & 0xFF) == 33) {
            wPos += 2;
        } else {
            throw new Exception("signR length Error!");
        }
        System.arraycopy(signature, wPos, resultBytes, 0, 32);
        wPos += 32;
        
        // 截取signS
        wPos += 1;
        if ((signature[wPos] & 0xFF) == 32) {
            wPos += 1;
        } else if ((signature[wPos] & 0xFF) == 33) {
            wPos += 2;
        } else {
            throw new Exception("signS length Error!");
        }
        System.arraycopy(signature, wPos, resultBytes, 32, 32);
        
        return resultBytes;
    }
    
    /**
     * SM2密钥对内部类
     */
    private static class Sm2KeyPair {
        private final String title;
        private final String x;
        private final String y;
        
        public Sm2KeyPair(String title, String x, String y) {
            this.title = title;
            this.x = x;
            this.y = y;
        }
        
        public String getTitle() {
            return title;
        }
        
        public String getX() {
            return x;
        }
        
        public String getY() {
            return y;
        }
    }
}
