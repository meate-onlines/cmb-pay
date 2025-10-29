package com.cmbchina.payment.crypto;

import org.bouncycastle.asn1.gm.GMNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.signers.SM2Signer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.Security;

/**
 * BouncyCastle SM2工具类 - 适配Java17+
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class BCUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(BCUtil.class);
    
    static {
        // 添加BouncyCastle提供者
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }
    
    /**
     * 从私钥D值获取私钥对象
     * 
     * @param d 私钥D值
     * @return BCECPrivateKey对象
     * @throws Exception 异常
     */
    public static BCECPrivateKey getPrivatekeyFromD(BigInteger d) throws Exception {
        X9ECParameters sm2ECParameters = GMNamedCurves.getByName("sm2p256v1");
        ECParameterSpec ecParameterSpec = new ECParameterSpec(
            sm2ECParameters.getCurve(), 
            sm2ECParameters.getG(), 
            sm2ECParameters.getN(), 
            sm2ECParameters.getH()
        );
        
        ECPrivateKeySpec ecPrivateKeySpec = new ECPrivateKeySpec(d, ecParameterSpec);
        KeyFactory keyFactory = KeyFactory.getInstance("EC", BouncyCastleProvider.PROVIDER_NAME);
        
        return (BCECPrivateKey) keyFactory.generatePrivate(ecPrivateKeySpec);
    }
    
    /**
     * 从公钥坐标获取公钥对象
     * 
     * @param x 公钥X坐标
     * @param y 公钥Y坐标
     * @return BCECPublicKey对象
     * @throws Exception 异常
     */
    public static BCECPublicKey getPublickeyFromXY(BigInteger x, BigInteger y) throws Exception {
        X9ECParameters sm2ECParameters = GMNamedCurves.getByName("sm2p256v1");
        ECParameterSpec ecParameterSpec = new ECParameterSpec(
            sm2ECParameters.getCurve(), 
            sm2ECParameters.getG(), 
            sm2ECParameters.getN(), 
            sm2ECParameters.getH()
        );
        
        ECPoint ecPoint = sm2ECParameters.getCurve().createPoint(x, y);
        ECPublicKeySpec ecPublicKeySpec = new ECPublicKeySpec(ecPoint, ecParameterSpec);
        KeyFactory keyFactory = KeyFactory.getInstance("EC", BouncyCastleProvider.PROVIDER_NAME);
        
        return (BCECPublicKey) keyFactory.generatePublic(ecPublicKeySpec);
    }
    
    /**
     * SM3withSM2签名
     * 
     * @param message 待签名消息
     * @param userId 用户ID
     * @param privateKey 私钥
     * @return 签名结果
     * @throws Exception 异常
     */
    public static byte[] signSm3WithSm2(byte[] message, byte[] userId, BCECPrivateKey privateKey) throws Exception {
        try {
            X9ECParameters sm2ECParameters = GMNamedCurves.getByName("sm2p256v1");
            ECDomainParameters domainParameters = new ECDomainParameters(
                sm2ECParameters.getCurve(), 
                sm2ECParameters.getG(), 
                sm2ECParameters.getN(), 
                sm2ECParameters.getH()
            );
            
            ECPrivateKeyParameters privateKeyParameters = new ECPrivateKeyParameters(
                privateKey.getD(), 
                domainParameters
            );
            
            SM2Signer signer = new SM2Signer();
            signer.init(true, privateKeyParameters);
            signer.update(message, 0, message.length);
            
            return signer.generateSignature();
        } catch (Exception ex) {
            logger.error("SM3withSM2签名失败", ex);
            throw ex;
        }
    }
    
    /**
     * SM3withSM2验签
     * 
     * @param message 原始消息
     * @param userId 用户ID
     * @param signature 签名
     * @param publicKey 公钥
     * @return 验签结果
     * @throws Exception 异常
     */
    public static boolean verifySm3WithSm2(byte[] message, byte[] userId, byte[] signature, BCECPublicKey publicKey) throws Exception {
        try {
            X9ECParameters sm2ECParameters = GMNamedCurves.getByName("sm2p256v1");
            ECDomainParameters domainParameters = new ECDomainParameters(
                sm2ECParameters.getCurve(), 
                sm2ECParameters.getG(), 
                sm2ECParameters.getN(), 
                sm2ECParameters.getH()
            );
            
            ECPublicKeyParameters publicKeyParameters = new ECPublicKeyParameters(
                publicKey.getQ(), 
                domainParameters
            );
            
            SM2Signer signer = new SM2Signer();
            signer.init(false, publicKeyParameters);
            signer.update(message, 0, message.length);
            
            return signer.verifySignature(signature);
        } catch (Exception ex) {
            logger.error("SM3withSM2验签失败", ex);
            throw ex;
        }
    }
    
    /**
     * 生成SM2密钥对
     * 
     * @return 密钥对
     * @throws Exception 异常
     */
    public static AsymmetricCipherKeyPair generateSM2KeyPair() throws Exception {
        X9ECParameters sm2ECParameters = GMNamedCurves.getByName("sm2p256v1");
        ECDomainParameters domainParameters = new ECDomainParameters(
            sm2ECParameters.getCurve(), 
            sm2ECParameters.getG(), 
            sm2ECParameters.getN(), 
            sm2ECParameters.getH()
        );
        
        ECKeyPairGenerator keyPairGenerator = new ECKeyPairGenerator();
        ECKeyGenerationParameters keyGenerationParams = new ECKeyGenerationParameters(
            domainParameters, 
            new SecureRandom()
        );
        keyPairGenerator.init(keyGenerationParams);
        
        return keyPairGenerator.generateKeyPair();
    }
}