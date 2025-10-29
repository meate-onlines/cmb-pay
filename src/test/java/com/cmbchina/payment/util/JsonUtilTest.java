package com.cmbchina.payment.util;

import com.cmbchina.payment.model.request.QrCodeApplyRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * JSON工具类测试
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
class JsonUtilTest {
    
    @Test
    void testToJson() {
        QrCodeApplyRequest request = new QrCodeApplyRequest();
        request.setMerId("123456789");
        request.setOrderId("TEST20241029001");
        request.setOrderAmt(10000L);
        request.setGoodsDes("测试商品");
        
        String json = JsonUtil.toJson(request);
        
        assertNotNull(json);
        assertFalse(json.isEmpty());
        assertTrue(json.contains("mer_id"));
        assertTrue(json.contains("123456789"));
        assertTrue(json.contains("order_id"));
        assertTrue(json.contains("TEST20241029001"));
    }
    
    @Test
    void testFromJson() {
        String json = "{\"mer_id\":\"123456789\",\"order_id\":\"TEST20241029001\",\"order_amt\":10000,\"goods_des\":\"测试商品\"}";
        
        QrCodeApplyRequest request = JsonUtil.fromJson(json, QrCodeApplyRequest.class);
        
        assertNotNull(request);
        assertEquals("123456789", request.getMerId());
        assertEquals("TEST20241029001", request.getOrderId());
        assertEquals(10000L, request.getOrderAmt());
        assertEquals("测试商品", request.getGoodsDes());
    }
    
    @Test
    void testFromJsonWithTypeReference() {
        String json = "{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}";
        
        Map<String, String> map = JsonUtil.fromJson(json, new TypeReference<Map<String, String>>() {});
        
        assertNotNull(map);
        assertEquals(3, map.size());
        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
        assertEquals("value3", map.get("key3"));
    }
    
    @Test
    void testToJsonWithNull() {
        String json = JsonUtil.toJson(null);
        assertNull(json);
    }
    
    @Test
    void testFromJsonWithNull() {
        QrCodeApplyRequest request = JsonUtil.fromJson(null, QrCodeApplyRequest.class);
        assertNull(request);
    }
    
    @Test
    void testFromJsonWithEmptyString() {
        QrCodeApplyRequest request = JsonUtil.fromJson("", QrCodeApplyRequest.class);
        assertNull(request);
        
        request = JsonUtil.fromJson("   ", QrCodeApplyRequest.class);
        assertNull(request);
    }
    
    @Test
    void testPrettyJson() {
        String compactJson = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        String prettyJson = JsonUtil.prettyJson(compactJson);
        
        assertNotNull(prettyJson);
        assertTrue(prettyJson.contains("\n"));
        assertTrue(prettyJson.contains("  "));
    }
    
    @Test
    void testPrettyJsonWithInvalidJson() {
        String invalidJson = "invalid json";
        String result = JsonUtil.prettyJson(invalidJson);
        
        assertEquals(invalidJson, result);
    }
    
    @Test
    void testIsValidJson() {
        assertTrue(JsonUtil.isValidJson("{\"key\":\"value\"}"));
        assertTrue(JsonUtil.isValidJson("[1,2,3]"));
        assertTrue(JsonUtil.isValidJson("\"string\""));
        assertTrue(JsonUtil.isValidJson("123"));
        assertTrue(JsonUtil.isValidJson("true"));
        assertTrue(JsonUtil.isValidJson("null"));
        
        assertFalse(JsonUtil.isValidJson("invalid json"));
        assertFalse(JsonUtil.isValidJson("{key:value}"));
        assertFalse(JsonUtil.isValidJson(""));
        assertFalse(JsonUtil.isValidJson(null));
    }
    
    @Test
    void testRoundTrip() {
        Map<String, Object> originalMap = new HashMap<>();
        originalMap.put("string", "测试字符串");
        originalMap.put("number", 12345);
        originalMap.put("boolean", true);
        originalMap.put("null_value", null);
        
        String json = JsonUtil.toJson(originalMap);
        Map<String, Object> parsedMap = JsonUtil.fromJson(json, new TypeReference<Map<String, Object>>() {});
        
        assertNotNull(parsedMap);
        assertEquals("测试字符串", parsedMap.get("string"));
        assertEquals(12345, parsedMap.get("number"));
        assertEquals(true, parsedMap.get("boolean"));
        assertNull(parsedMap.get("null_value"));
    }
    
    @Test
    void testInvalidJsonThrowsException() {
        assertThrows(RuntimeException.class, () -> {
            JsonUtil.fromJson("invalid json", QrCodeApplyRequest.class);
        });
    }
}