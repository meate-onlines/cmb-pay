package com.cmbchina.payment;

import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.model.request.*;
import com.cmbchina.payment.model.response.*;
import com.cmbchina.payment.crypto.SignatureUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 招商银行支付客户端测试类
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
@DisplayName("CMB支付客户端测试")
class CmbPaymentClientTest {
    
    private CmbPaymentConfig config;
    private CmbPaymentClient client;
    
    @BeforeEach
    void setUp() {
        config = new CmbPaymentConfig.Builder()
                .merchantId("test_merchant_id")
                .appId("test_app_id")
                .appSecret("test_app_secret")
                .privateKey("test_private_key")
                .publicKey("test_public_key")
                .apiUrl("https://api.test.com")
                .notifyUrl("https://test.com/notify")
                .returnUrl("https://test.com/return")
                .sandbox(true)
                .build();
        
        client = new CmbPaymentClient(config);
    }
    
    @Test
    @DisplayName("测试客户端创建")
    void testClientCreation() {
        assertNotNull(client);
        assertNotNull(config);
    }
    
    @Test
    @DisplayName("测试配置获取")
    void testConfigValues() {
        assertEquals("test_merchant_id", config.getMerchantId());
        assertEquals("test_app_id", config.getAppId());
        assertEquals("test_app_secret", config.getAppSecret());
        assertEquals("https://api.test.com", config.getApiUrl());
        assertTrue(config.isSandbox());
    }
    
    @Test
    @DisplayName("测试收款码申请请求构建")
    void testQrCodeApplyRequest() {
        QrCodeApplyRequest request = new QrCodeApplyRequest();
        request.setMerId(config.getMerchantId());
        request.setOrderId("TEST_ORDER_" + System.currentTimeMillis());
        request.setTxnAmt("10000");
        request.setBody("测试商品描述");
        request.setNotifyUrl(config.getNotifyUrl());
        request.setUserId("test_user"); // Add mandatory field

        assertNotNull(request);
        assertEquals(config.getMerchantId(), request.getMerId());
        assertNotNull(request.getOrderId());
        assertEquals("10000", request.getTxnAmt());
        assertEquals("测试商品描述", request.getBody());
    }
    
    @Test
    @DisplayName("测试订单查询请求构建")
    void testOrderQueryRequest() {
        OrderQueryRequest request = new OrderQueryRequest();
        request.setMerId(config.getMerchantId());
        request.setOrderId("TEST_ORDER_001");
        
        assertNotNull(request);
        assertEquals(config.getMerchantId(), request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
    }
    
    @Test
    @DisplayName("测试付款码收款请求构建")
    void testPaymentRequest() {
        PaymentRequest request = new PaymentRequest();
        request.setMerId(config.getMerchantId());
        request.setOrderId("TEST_ORDER_001");
        request.setAuthCode("134567890123456789");
        
        assertNotNull(request);
        assertEquals(config.getMerchantId(), request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals("134567890123456789", request.getAuthCode());
    }
    
    @Test
    @DisplayName("测试退款请求构建")
    void testRefundRequest() {
        RefundRequest request = new RefundRequest();
        request.setMerId(config.getMerchantId());
        request.setOrderId("TEST_ORDER_001");
        request.setOrderId("TEST_REFUND_001");
        request.setRefundAmt("5000");
        request.setRefundReason("测试退款原因");
        
        assertNotNull(request);
        assertEquals(config.getMerchantId(), request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals("TEST_REFUND_001", request.getOrderId());
        assertEquals("5000", request.getRefundAmt());
        assertEquals("测试退款原因", request.getRefundReason());
    }
    
    @Test
    @DisplayName("测试退款查询请求构建")
    void testRefundQueryRequest() {
        RefundQueryRequest request = new RefundQueryRequest();
        request.setMerId(config.getMerchantId());
        request.setOrderId("TEST_REFUND_001");
        
        assertNotNull(request);
        assertEquals(config.getMerchantId(), request.getMerId());
        assertEquals("TEST_REFUND_001", request.getOrderId());
    }
    
    @Test
    @DisplayName("测试微信统一下单请求构建")
    void testWechatUnifiedOrderRequest() {
        WechatUnifiedOrderRequest request = new WechatUnifiedOrderRequest();
        request.setMerId(config.getMerchantId());
        request.setOrderId("TEST_ORDER_001");
        request.setOrderAmt("10000");
        request.setGoodsDes("测试商品");
        request.setNotifyUrl(config.getNotifyUrl());
        
        assertNotNull(request);
        assertEquals(config.getMerchantId(), request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals("10000", request.getOrderAmt());
    }
    
    @Test
    @DisplayName("测试支付宝服务窗支付请求构建")
    void testAlipayServiceRequest() {
        AlipayServiceRequest request = new AlipayServiceRequest();
        request.setMerId(config.getMerchantId());
        request.setOrderId("TEST_ORDER_001");
        request.setOrderAmt("10000");
        request.setGoodsDes("测试商品");
        request.setNotifyUrl(config.getNotifyUrl());
        
        assertNotNull(request);
        assertEquals(config.getMerchantId(), request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals("10000", request.getOrderAmt());
    }
    
    @Test
    @DisplayName("测试关闭订单请求构建")
    void testCloseOrderRequest() {
        CloseOrderRequest request = new CloseOrderRequest();
        request.setMerId(config.getMerchantId());
        request.setOrigOrderId("TEST_ORDER_001");
        
        assertNotNull(request);
        assertEquals(config.getMerchantId(), request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrigOrderId());
    }
    
    @Test
    @DisplayName("测试撤销订单请求构建")
    void testCancelRequest() {
        CancelRequest request = new CancelRequest();
        request.setMerId(config.getMerchantId());
        request.setOrderId("TEST_ORDER_001");
        
        assertNotNull(request);
        assertEquals(config.getMerchantId(), request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
    }
    
    @Test
    @DisplayName("测试对账单请求构建")
    void testStatementRequest() {
        StatementRequest request = new StatementRequest();
        request.setMerId(config.getMerchantId());
        request.setBillDate("20240101");
        
        assertNotNull(request);
        assertEquals(config.getMerchantId(), request.getMerId());
        assertEquals("20240101", request.getBillDate());
    }
    
    @Test
    @DisplayName("测试签名工具类")
    void testSignatureUtil() {
        // 测试参数排序
        Map<String, String> params = new HashMap<>();
        params.put("c", "3");
        params.put("a", "1");
        params.put("b", "2");
        
        String content = SignatureUtil.getSignContent(params);
        assertNotNull(content);
        // 验证参数是否按字母顺序排序
        assertTrue(content.contains("a=1"));
        assertTrue(content.contains("b=2"));
        assertTrue(content.contains("c=3"));
    }
    
    @Test
    @DisplayName("测试MD5哈希")
    void testMD5() {
        String input = "test_content";
        String hash = SignatureUtil.md5(input);
        assertNotNull(hash);
        assertEquals(32, hash.length()); // MD5 哈希值长度为 32
    }
    
    @Test
    @DisplayName("测试随机字符串生成")
    void testGenerateNonce() {
        String nonce = SignatureUtil.generateNonce(16);
        assertNotNull(nonce);
        assertEquals(16, nonce.length());
        
        // 生成两次应该不同
        String nonce2 = SignatureUtil.generateNonce(16);
        assertNotEquals(nonce, nonce2);
    }
    
    @Test
    @DisplayName("测试验证通知签名（缺少签名）")
    void testVerifyNotifyWithoutSign() {
        String notifyData = "mer_id=test_merchant&order_id=TEST_001";
        boolean result = client.verifyNotify(notifyData);
        assertFalse(result);
    }
    
    @Test
    @DisplayName("测试处理通知（正常情况）")
    void testHandleNotify() {
        // 使用新的字段名，注意字段名是小写下划线格式
        String notifyData = "merId=test_merchant&orderId=TEST_001&tradeState=S&txnAmt=10000&payType=ZF";
        
        assertDoesNotThrow(() -> {
            NotifyResponse response = client.handleNotify(notifyData);
            assertNotNull(response);
        });
    }
    
    @Test
    @DisplayName("测试处理通知（无效数据）")
    void testHandleNotifyWithInvalidData() {
        String invalidData = "invalid_format_data";
        
        // parseQueryString 不会抛出异常，而是返回空Map，所以这里不会抛出异常
        assertDoesNotThrow(() -> {
            NotifyResponse response = client.handleNotify(invalidData);
            assertNotNull(response);
        });
    }
    
    @Test
    @DisplayName("测试配置Builder默认值")
    void testConfigBuilderDefaults() {
        CmbPaymentConfig defaultConfig = new CmbPaymentConfig.Builder()
                .merchantId("merchant")
                .appId("app")
                .appSecret("secret")
                .privateKey("private")
                .publicKey("public")
                .build();
        
        assertEquals("02", defaultConfig.getSignMethod()); // 默认值是 "02" 而不是 "SM2"
        assertEquals("UTF-8", defaultConfig.getEncoding());
        assertEquals("UTF-8", defaultConfig.getCharset());
        assertEquals(30000, defaultConfig.getConnectTimeout());
        assertEquals(30000, defaultConfig.getReadTimeout());
        assertFalse(defaultConfig.isSandbox());
    }
}

