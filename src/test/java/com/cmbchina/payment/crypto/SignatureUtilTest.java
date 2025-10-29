package com.cmbchina.payment.crypto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 签名工具类测试
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
class SignatureUtilTest {
    
    private Map<String, String> testParams;
    
    @BeforeEach
    void setUp() {
        testParams = new HashMap<>();
        testParams.put("mer_id", "123456789");
        testParams.put("order_id", "TEST20241029001");
        testParams.put("order_amt", "10000");
        testParams.put("goods_des", "测试商品");
        testParams.put("version", "0.0.1");
        testParams.put("encoding", "UTF-8");
        testParams.put("signMethod", "02");
    }
    
    @Test
    void testGetSignContent() {
        String content = SignatureUtil.getSignContent(testParams);
        
        assertNotNull(content);
        assertFalse(content.isEmpty());
        
        // 验证参数按字典序排序
        String expected = "encoding=UTF-8&goods_des=测试商品&mer_id=123456789&order_amt=10000&order_id=TEST20241029001&signMethod=02&version=0.0.1";
        assertEquals(expected, content);
    }
    
    @Test
    void testGetSignContentWithNullValues() {
        testParams.put("empty_field", "");
        testParams.put("null_field", null);
        
        String content = SignatureUtil.getSignContent(testParams);
        
        // 空值和null值应该被过滤掉
        assertFalse(content.contains("empty_field"));
        assertFalse(content.contains("null_field"));
    }
    
    @Test
    void testMd5() {
        String input = "hello world";
        String md5Hash = SignatureUtil.md5(input);
        
        assertNotNull(md5Hash);
        assertEquals(32, md5Hash.length());
        assertEquals("5eb63bbbe01eeed093cb22bb8f5acdc3", md5Hash);
    }
    
    @Test
    void testUrlEncodeDecode() {
        String original = "测试中文+特殊字符&=";
        String encoded = SignatureUtil.encode(original);
        String decoded = SignatureUtil.decode(encoded);
        
        assertNotNull(encoded);
        assertNotNull(decoded);
        assertEquals(original, decoded);
    }
    
    @Test
    void testParseQueryString() {
        String queryString = "key1=value1&key2=value2&key3=%E6%B5%8B%E8%AF%95";
        Map<String, String> params = SignatureUtil.parseQueryString(queryString);
        
        assertNotNull(params);
        assertEquals(3, params.size());
        assertEquals("value1", params.get("key1"));
        assertEquals("value2", params.get("key2"));
        assertEquals("测试", params.get("key3"));
    }
    
    @Test
    void testBuildQueryString() {
        String queryString = SignatureUtil.buildQueryString(testParams, false);
        
        assertNotNull(queryString);
        assertFalse(queryString.isEmpty());
        assertTrue(queryString.contains("mer_id=123456789"));
        assertTrue(queryString.contains("order_id=TEST20241029001"));
    }
    
    @Test
    void testGenerateApiSign() {
        String appId = "test-app-id";
        String appSecret = "test-app-secret";
        String sign = "test-business-sign";
        long timestamp = 1698566400; // 固定时间戳用于测试
        
        String apiSign = SignatureUtil.generateApiSign(appId, appSecret, sign, timestamp);
        
        assertNotNull(apiSign);
        assertEquals(32, apiSign.length());
        
        // 验证结果的一致性
        String apiSign2 = SignatureUtil.generateApiSign(appId, appSecret, sign, timestamp);
        assertEquals(apiSign, apiSign2);
    }
    
    @Test
    void testIsTimestampValid() {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        
        // 当前时间戳应该有效
        assertTrue(SignatureUtil.isTimestampValid(currentTimestamp, 300));
        
        // 5分钟前的时间戳应该有效
        assertTrue(SignatureUtil.isTimestampValid(currentTimestamp - 300, 300));
        
        // 10分钟前的时间戳应该无效
        assertFalse(SignatureUtil.isTimestampValid(currentTimestamp - 600, 300));
        
        // 未来5分钟的时间戳应该有效
        assertTrue(SignatureUtil.isTimestampValid(currentTimestamp + 300, 300));
        
        // 未来10分钟的时间戳应该无效
        assertFalse(SignatureUtil.isTimestampValid(currentTimestamp + 600, 300));
    }
    
    @Test
    void testGenerateNonce() {
        String nonce1 = SignatureUtil.generateNonce(16);
        String nonce2 = SignatureUtil.generateNonce(16);
        
        assertNotNull(nonce1);
        assertNotNull(nonce2);
        assertEquals(16, nonce1.length());
        assertEquals(16, nonce2.length());
        
        // 两次生成的随机字符串应该不同
        assertNotEquals(nonce1, nonce2);
        
        // 验证只包含字母和数字
        assertTrue(nonce1.matches("[a-zA-Z0-9]+"));
        assertTrue(nonce2.matches("[a-zA-Z0-9]+"));
    }
}