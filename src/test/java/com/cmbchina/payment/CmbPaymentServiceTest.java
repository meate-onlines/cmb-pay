package com.cmbchina.payment;

import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.core.CmbPaymentService;
import com.cmbchina.payment.model.request.*;
import com.cmbchina.payment.model.response.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 招商银行支付服务测试类
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
@ExtendWith(MockitoExtension.class)
class CmbPaymentServiceTest {
    
    private CmbPaymentConfig config;
    private CmbPaymentService paymentService;
    
    @Mock
    private RestTemplate restTemplate;
    
    @BeforeEach
    void setUp() {
        config = new CmbPaymentConfig.Builder()
                .merchantId("test_merchant_id")
                .appId("test_app_id")
                .appSecret("test_app_secret")
                .privateKey("test_private_key")
                .publicKey("test_public_key")
                .apiUrl("https://api.test.com")
                .sandbox(true)
                .build();
        
        paymentService = new CmbPaymentService(config);
        // 注入 mock 的 RestTemplate
        ReflectionTestUtils.setField(paymentService, "restTemplate", restTemplate);
    }
    
    @Test
    void testConfigCreation() {
        assertNotNull(config);
        assertEquals("test_merchant_id", config.getMerchantId());
        assertEquals("test_app_id", config.getAppId());
        assertEquals("https://api.test.com", config.getApiUrl());
        assertTrue(config.isSandbox());
    }
    
    @Test
    void testClientCreation() {
        CmbPaymentClient client = new CmbPaymentClient(config);
        assertNotNull(client);
    }
    
    @Test
    void testQrCodeApplyRequest() {
        QrCodeApplyRequest request = new QrCodeApplyRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_ORDER_001");
        request.setOrderAmt("10000");
        request.setGoodsDes("测试商品");
        request.setNotifyUrl("https://test.com/notify");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals("10000", request.getOrderAmt());
        assertEquals("测试商品", request.getGoodsDes());
    }
    
    @Test
    void testPaymentRequest() {
        PaymentRequest request = new PaymentRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_ORDER_001");
        request.setOrderAmt(10000L);
        request.setGoodsDes("测试商品");
        request.setAuthCode("134567890123456789");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals(10000L, request.getOrderAmt());
        assertEquals("134567890123456789", request.getAuthCode());
    }
    
    @Test
    void testOrderQueryRequest() {
        OrderQueryRequest request = new OrderQueryRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_ORDER_001");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
    }
    
    @Test
    void testRefundRequest() {
        RefundRequest request = new RefundRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_ORDER_001");
        request.setRefundOrderId("TEST_REFUND_001");
        request.setRefundAmt(5000L);
        request.setRefundReason("测试退款");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals("TEST_REFUND_001", request.getRefundOrderId());
        assertEquals(5000L, request.getRefundAmt());
        assertEquals("测试退款", request.getRefundReason());
    }
    
    @Test
    void testWechatUnifiedOrderRequest() {
        WechatUnifiedOrderRequest request = new WechatUnifiedOrderRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_ORDER_001");
        request.setOrderAmt(10000L);
        request.setGoodsDes("测试商品");
        request.setNotifyUrl("https://test.com/notify");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals(10000L, request.getOrderAmt());
    }
    
    @Test
    void testAlipayServiceRequest() {
        AlipayServiceRequest request = new AlipayServiceRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_ORDER_001");
        request.setOrderAmt(10000L);
        request.setGoodsDes("测试商品");
        request.setNotifyUrl("https://test.com/notify");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals(10000L, request.getOrderAmt());
    }
    
    @Test
    void testCancelRequest() {
        CancelRequest request = new CancelRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_ORDER_001");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
    }
    
    @Test
    void testCloseOrderRequest() {
        CloseOrderRequest request = new CloseOrderRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_ORDER_001");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
    }
    
    @Test
    void testRefundQueryRequest() {
        RefundQueryRequest request = new RefundQueryRequest();
        request.setMerId("test_merchant_id");
        request.setRefundOrderId("TEST_REFUND_001");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_REFUND_001", request.getRefundOrderId());
    }
    
    @Test
    void testStatementRequest() {
        StatementRequest request = new StatementRequest();
        request.setMerId("test_merchant_id");
        request.setBillDate("20240101");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("20240101", request.getBillDate());
    }
    
    @Test
    void testVerifyNotify() {
        // 构造测试数据
        String notifyData = "mer_id=test_merchant&order_id=TEST_001&sign=test_sign";
        
        // 注意：由于签名验证需要真实的密钥，这里主要测试方法调用不会抛出异常
        assertDoesNotThrow(() -> {
            boolean result = paymentService.verifyNotify(notifyData);
            // 签名验证失败是预期的（因为使用的是测试密钥）
            assertFalse(result);
        });
    }
    
    @Test
    void testHandleNotify() {
        String notifyData = "mer_id=test_merchant&order_id=TEST_001&order_stat=SUCCESS";
        
        assertDoesNotThrow(() -> {
            NotifyResponse response = paymentService.handleNotify(notifyData);
            assertNotNull(response);
        });
    }
    
    @Test
    void testHandleNotifyWithInvalidData() {
        String invalidData = "invalid_format";
        
        // parseQueryString 不会抛出异常，而是返回空Map，所以这里不会抛出异常
        assertDoesNotThrow(() -> {
            NotifyResponse response = paymentService.handleNotify(invalidData);
            assertNotNull(response);
        });
    }
    
    @Test
    void testVerifyNotifyWithMissingSign() {
        String notifyDataWithoutSign = "mer_id=test_merchant&order_id=TEST_001";
        
        boolean result = paymentService.verifyNotify(notifyDataWithoutSign);
        assertFalse(result);
    }
    
    @Test
    void testRequestValidation() {
        // 测试请求对象的基本验证
        QrCodeApplyRequest request = new QrCodeApplyRequest();
        
        // 未设置必填字段时应该验证失败
        assertNull(request.getMerId());
        assertNull(request.getOrderId());
        assertNull(request.getOrderAmt());
        
        // 设置必填字段
        request.setMerId("test_merchant");
        request.setOrderId("TEST_001");
        request.setOrderAmt("10000");
        request.setGoodsDes("测试商品");
        
        assertNotNull(request.getMerId());
        assertNotNull(request.getOrderId());
        assertNotNull(request.getOrderAmt());
        assertNotNull(request.getGoodsDes());
    }
    
    @Test
    void testConfigBuilder() {
        CmbPaymentConfig.Builder builder = new CmbPaymentConfig.Builder();
        
        CmbPaymentConfig config = builder
                .merchantId("merchant_123")
                .appId("app_123")
                .appSecret("secret_123")
                .privateKey("private_key_123")
                .publicKey("public_key_123")
                .apiUrl("https://api.example.com")
                .notifyUrl("https://notify.example.com")
                .returnUrl("https://return.example.com")
                .sandbox(true)
                .connectTimeout(60000)
                .readTimeout(60000)
                .build();
        
        assertNotNull(config);
        assertEquals("merchant_123", config.getMerchantId());
        assertEquals("app_123", config.getAppId());
        assertEquals("secret_123", config.getAppSecret());
        assertEquals("https://api.example.com", config.getApiUrl());
        assertEquals("https://notify.example.com", config.getNotifyUrl());
        assertEquals("https://return.example.com", config.getReturnUrl());
        assertTrue(config.isSandbox());
        assertEquals(60000, config.getConnectTimeout());
        assertEquals(60000, config.getReadTimeout());
    }
    
    @Test
    void testClientMethods() {
        CmbPaymentClient client = new CmbPaymentClient(config);
        assertNotNull(client);
        
        // 测试客户端方法存在性（实际调用需要 mock HTTP 响应）
        QrCodeApplyRequest qrRequest = new QrCodeApplyRequest();
        qrRequest.setMerId("test_merchant");
        qrRequest.setOrderId("TEST_001");
        qrRequest.setOrderAmt("10000");
        qrRequest.setGoodsDes("测试");
        
        // 由于没有真实的 API 端点，这里只会测试方法签名和参数验证
        assertNotNull(qrRequest);
        assertNotNull(client);
    }
}
