package com.cmbchina.payment.util;

import com.cmbchina.payment.crypto.SignatureUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 签名工具测试类
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
@DisplayName("签名工具测试")
class SignUtilTest {
    
    @Test
    @DisplayName("测试参数排序和签名内容生成")
    void testGetSignContent() {
        Map<String, String> params = new HashMap<>();
        params.put("c", "3");
        params.put("a", "1");
        params.put("b", "2");
        
        String signContent = SignatureUtil.getSignContent(params);
        
        // 应该按key排序
        assertNotNull(signContent);
        assertTrue(signContent.contains("a=1"));
        assertTrue(signContent.contains("b=2"));
        assertTrue(signContent.contains("c=3"));
        // 验证顺序
        assertTrue(signContent.indexOf("a=1") < signContent.indexOf("b=2"));
        assertTrue(signContent.indexOf("b=2") < signContent.indexOf("c=3"));
    }
    
    @Test
    @DisplayName("测试MD5哈希")
    void testMd5() {
        String content = "test_content";
        String hash = SignatureUtil.md5(content);
        
        assertNotNull(hash);
        assertEquals(32, hash.length()); // MD5哈希值长度为32
        // 同一个内容应该产生相同的哈希值
        assertEquals(hash, SignatureUtil.md5(content));
    }
    
    @Test
    @DisplayName("测试随机字符串生成")
    void testGenerateNonce() {
        String nonce = SignatureUtil.generateNonce(16);
        
        assertNotNull(nonce);
        assertEquals(16, nonce.length());
        
        // 生成两次应该不同（极大概率）
        String nonce2 = SignatureUtil.generateNonce(16);
        assertNotEquals(nonce, nonce2);
        
        // 测试不同长度
        String nonce32 = SignatureUtil.generateNonce(32);
        assertEquals(32, nonce32.length());
    }
    
    @Test
    @DisplayName("测试API签名生成")
    void testGenerateApiSign() {
        String appId = "test_app_id";
        String appSecret = "test_app_secret";
        String sign = "test_sign";
        long timestamp = System.currentTimeMillis() / 1000;
        
        String apiSign = SignatureUtil.generateApiSign(appId, appSecret, sign, timestamp);
        
        assertNotNull(apiSign);
        assertFalse(apiSign.isEmpty());
    }
    
    @Test
    @DisplayName("测试查询字符串解析")
    void testParseQueryString() {
        String queryString = "a=1&b=2&c=3";
        Map<String, String> params = SignatureUtil.parseQueryString(queryString);
        
        assertNotNull(params);
        assertEquals(3, params.size());
        assertEquals("1", params.get("a"));
        assertEquals("2", params.get("b"));
        assertEquals("3", params.get("c"));
    }
    
    @Test
    @DisplayName("测试空查询字符串解析")
    void testParseEmptyQueryString() {
        String queryString = "";
        Map<String, String> params = SignatureUtil.parseQueryString(queryString);
        
        assertNotNull(params);
        assertTrue(params.isEmpty());
    }
    
    @Test
    @DisplayName("测试URL编码的查询字符串解析")
    void testParseQueryStringWithEncoding() {
        String queryString = "a=hello%20world&b=test";
        Map<String, String> params = SignatureUtil.parseQueryString(queryString);
        
        assertNotNull(params);
        assertEquals(2, params.size());
        assertTrue(params.containsKey("a"));
        assertTrue(params.containsKey("b"));
    }
}
