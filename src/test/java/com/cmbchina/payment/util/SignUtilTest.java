package com.cmbchina.payment.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 签名工具测试类
 */
class SignUtilTest {
    
    @Test
    void testBuildSignString() {
        Map<String, Object> params = new HashMap<>();
        params.put("b", "2");
        params.put("a", "1");
        params.put("c", "3");
        params.put("", ""); // 空值应该被过滤
        params.put("d", null); // null值应该被过滤
        
        String signString = SignUtil.buildSignString(params);
        
        // 应该按key排序，过滤空值
        assertEquals("a=1&b=2&c=3", signString);
    }
    
    @Test
    void testMd5Sign() {
        String content = "test_content";
        String key = "test_key";
        
        String sign = SignUtil.md5Sign(content, key);
        
        assertNotNull(sign);
        assertTrue(sign.length() == 32); // MD5签名长度应该是32
    }
    
    @Test
    void testMd5Verify() {
        String content = "test_content";
        String key = "test_key";
        
        String sign = SignUtil.md5Sign(content, key);
        boolean isValid = SignUtil.md5Verify(content, sign, key);
        
        assertTrue(isValid);
    }
    
    @Test
    void testHmacSha256Sign() {
        String content = "test_content";
        String secretKey = "test_secret_key";
        
        String sign = SignUtil.hmacSha256Sign(content, secretKey);
        
        assertNotNull(sign);
        assertFalse(sign.isEmpty());
    }
}