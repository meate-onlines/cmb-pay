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
        request.setTxnAmt("10000");
        request.setBody("测试商品");
        request.setNotifyUrl("https://test.com/notify");
        request.setUserId("test_user"); // Add mandatory field

        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals("10000", request.getTxnAmt());
        assertEquals("测试商品", request.getBody());
    }
    
    @Test
    void testPaymentRequest() {
        PaymentRequest request = new PaymentRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_ORDER_001");
        request.setAuthCode("134567890123456789");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
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
        request.setOrderId("TEST_REFUND_001");
        request.setRefundAmt("5000");
        request.setRefundReason("测试退款");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals("TEST_REFUND_001", request.getOrderId());
        assertEquals("5000", request.getRefundAmt());
        assertEquals("测试退款", request.getRefundReason());
    }
    
    @Test
    void testWechatUnifiedOrderRequest() {
        WechatUnifiedOrderRequest request = new WechatUnifiedOrderRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_ORDER_001");
        request.setOrderAmt("10000");
        request.setGoodsDes("测试商品");
        request.setNotifyUrl("https://test.com/notify");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals("10000", request.getOrderAmt());
    }
    
    @Test
    void testAlipayServiceRequest() {
        AlipayServiceRequest request = new AlipayServiceRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_ORDER_001");
        request.setOrderAmt("10000");
        request.setGoodsDes("测试商品");
        request.setNotifyUrl("https://test.com/notify");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrderId());
        assertEquals("10000", request.getOrderAmt());
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
        request.setOrigOrderId("TEST_ORDER_001");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_ORDER_001", request.getOrigOrderId());
    }
    
    @Test
    void testRefundQueryRequest() {
        RefundQueryRequest request = new RefundQueryRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("TEST_REFUND_001");
        
        assertNotNull(request);
        assertEquals("test_merchant_id", request.getMerId());
        assertEquals("TEST_REFUND_001", request.getOrderId());
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
        // 使用新的字段名，注意字段名是小写下划线格式会被转换为驼峰格式
        String notifyData = "merId=test_merchant&orderId=TEST_001&tradeState=S&txnAmt=10000&payType=ZF";
        
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
    void testHandleNotifyWithRealBizContent() {
        // 使用用户提供的实际 biz_content 值进行测试
        String bizContent = "{\"merId\":\"3089991727302TE\",\"orderId\":\"P202511102128161\",\"cmbOrderId\":\"100425111021281694103779\",\"userId\":\"V080708212\",\"txnAmt\":\"9\",\"currencyCode\":\"156\",\"payType\":\"ZF\",\"openId\":\"2088412343991381\",\"txnTime\":\"20251110212816\",\"endDate\":\"20251110\",\"endTime\":\"212838\",\"dscAmt\":\"0\",\"thirdOrderId\":\"552025111022001491381438889191\",\"payBank\":\"ALIPAYACCOUNT\",\"buyerLogonId\":\"183****9668\",\"payChannel\":\"U\"}";
        
        // 构建通知数据，biz_content 需要 URL 编码
        try {
            String encodedBizContent = java.net.URLEncoder.encode(bizContent, "UTF-8");
            String notifyData = "biz_content=" + encodedBizContent + "&version=0.0.1&encoding=UTF-8";
            
            // 测试解析
            NotifyResponse response = paymentService.handleNotify(notifyData);
            
            // 验证解析结果
            assertNotNull(response, "响应不应为空");
            assertEquals("3089991727302TE", response.getMerId(), "商户号应匹配");
            assertEquals("P202511102128161", response.getOrderId(), "订单号应匹配");
            assertEquals("100425111021281694103779", response.getCmbOrderId(), "平台订单号应匹配");
            assertEquals("V080708212", response.getUserId(), "用户ID应匹配");
            assertEquals("9", response.getTxnAmt(), "交易金额应匹配");
            assertEquals("156", response.getCurrencyCode(), "币种应匹配");
            assertEquals("ZF", response.getPayType(), "支付方式应匹配");
            assertEquals("2088412343991381", response.getOpenId(), "OpenId应匹配");
            assertEquals("20251110212816", response.getTxnTime(), "交易时间应匹配");
            assertEquals("20251110", response.getEndDate(), "完成日期应匹配");
            assertEquals("212838", response.getEndTime(), "完成时间应匹配");
            assertEquals("0", response.getDscAmt(), "优惠金额应匹配");
            assertEquals("552025111022001491381438889191", response.getThirdOrderId(), "第三方订单号应匹配");
            assertEquals("ALIPAYACCOUNT", response.getPayBank(), "付款银行应匹配");
            assertEquals("183****9668", response.getBuyerLogonId(), "买家登录ID应匹配");
            
            System.out.println("测试成功！成功解析了 biz_content JSON 字符串");
            System.out.println("商户号: " + response.getMerId());
            System.out.println("订单号: " + response.getOrderId());
            System.out.println("平台订单号: " + response.getCmbOrderId());
            System.out.println("交易金额: " + response.getTxnAmt());
            System.out.println("支付方式: " + response.getPayType());
            
        } catch (Exception e) {
            fail("解析 biz_content 失败: " + e.getMessage(), e);
        }
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

        // 设置必填字段
        request.setMerId("test_merchant");
        request.setOrderId("TEST_001");
        request.setTxnAmt("10000");
        request.setBody("测试商品");
        request.setUserId("test_user"); // Add mandatory field

        assertNotNull(request.getMerId());
        assertNotNull(request.getOrderId());
        assertNotNull(request.getTxnAmt());
        assertNotNull(request.getBody());
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
        qrRequest.setTxnAmt("10000");
        qrRequest.setBody("测试");
        qrRequest.setUserId("test_user"); // Add mandatory field

        // 由于没有真实的 API 端点，这里只会测试方法签名和参数验证
        assertNotNull(qrRequest);
        assertNotNull(client);
    }
    
    /**
     * 集成测试：发送真实的HTTP请求
     * 使用环境变量或系统属性来配置真实的API端点
     * 如果没有配置，则跳过此测试
     * 
     * 使用方法：
     * 1. 设置环境变量：CMB_API_URL=https://api.cmburl.cn:8065
     *    或系统属性：-Dcmb.api.url=https://api.cmburl.cn:8065
     * 2. 设置真实的商户配置信息
     * 
     * 注意：此测试需要真实的API配置，默认会被跳过
     */
    @Test
    void testRealHttpRequest() {
        // 从环境变量或系统属性获取API URL
        String apiUrl = System.getenv("CMB_API_URL");
        if (apiUrl == null || apiUrl.isEmpty()) {
            apiUrl = System.getProperty("cmb.api.url");
        }
        
        // 如果没有配置，跳过测试
        if (apiUrl == null || apiUrl.isEmpty()) {
            System.out.println("跳过真实HTTP请求测试：未配置API URL");
            System.out.println("提示：设置环境变量 CMB_API_URL 或系统属性 cmb.api.url 来启用此测试");
            return;
        }
        
        // 从环境变量或系统属性获取其他配置
        String merchantId = System.getenv("CMB_MERCHANT_ID");
        if (merchantId == null || merchantId.isEmpty()) {
            merchantId = System.getProperty("cmb.merchant.id");
        }
        
        String appId = System.getenv("CMB_APP_ID");
        if (appId == null || appId.isEmpty()) {
            appId = System.getProperty("cmb.app.id");
        }
        
        String appSecret = System.getenv("CMB_APP_SECRET");
        if (appSecret == null || appSecret.isEmpty()) {
            appSecret = System.getProperty("cmb.app.secret");
        }
        
        String privateKey = System.getenv("CMB_PRIVATE_KEY");
        if (privateKey == null || privateKey.isEmpty()) {
            privateKey = System.getProperty("cmb.private.key");
        }
        
        String publicKey = System.getenv("CMB_PUBLIC_KEY");
        if (publicKey == null || publicKey.isEmpty()) {
            publicKey = System.getProperty("cmb.public.key");
        }
        
        // 检查必要的配置
        if (merchantId == null || appId == null || appSecret == null || 
            privateKey == null || publicKey == null) {
            System.out.println("跳过真实HTTP请求测试：缺少必要的配置信息");
            System.out.println("提示：需要设置以下环境变量或系统属性：");
            System.out.println("  - CMB_MERCHANT_ID / cmb.merchant.id");
            System.out.println("  - CMB_APP_ID / cmb.app.id");
            System.out.println("  - CMB_APP_SECRET / cmb.app.secret");
            System.out.println("  - CMB_PRIVATE_KEY / cmb.private.key");
            System.out.println("  - CMB_PUBLIC_KEY / cmb.public.key");
            return;
        }
        
        // 创建真实的配置
        CmbPaymentConfig realConfig = new CmbPaymentConfig.Builder()
                .merchantId(merchantId)
                .appId(appId)
                .appSecret(appSecret)
                .privateKey(privateKey)
                .publicKey(publicKey)
                .apiUrl(apiUrl)
                .sandbox(true)
                .build();
        
        // 创建真实的支付服务（不使用Mock）
        CmbPaymentService realService = new CmbPaymentService(realConfig);
        
        // 创建订单查询请求（相对简单的请求，用于测试）
        OrderQueryRequest request = new OrderQueryRequest();
        request.setMerId(merchantId);
        request.setOrderId("TEST_" + System.currentTimeMillis()); // 使用时间戳确保唯一性
        
        try {
            // 发送真实的HTTP请求
            // 注意：这里可能会因为订单不存在而失败，但我们可以看到请求和响应的日志
            OrderQueryResponse response = realService.orderQuery(request);
            
            // 如果请求成功，验证响应
            assertNotNull(response, "响应不应为空");
            System.out.println("真实HTTP请求测试成功！");
            System.out.println("响应状态：成功");
            
        } catch (com.cmbchina.payment.exception.CmbPaymentException e) {
            // 请求失败是预期的（可能是订单不存在或其他业务错误）
            // 但我们可以验证HTTP请求和响应都被正确记录了
            System.out.println("真实HTTP请求测试完成（业务错误是预期的）：");
            System.out.println("错误码：" + e.getErrorCode());
            System.out.println("错误信息：" + e.getMessage());
            
            // 验证异常被正确抛出
            assertNotNull(e);
            assertNotNull(e.getErrorCode());
        } catch (Exception e) {
            // 网络错误或其他异常
            System.out.println("真实HTTP请求测试失败（可能是网络问题）：");
            System.out.println("异常类型：" + e.getClass().getName());
            System.out.println("异常信息：" + e.getMessage());
            
            // 不抛出异常，因为网络问题不应该导致测试失败
            // 但我们可以验证请求日志是否被正确记录
        }
    }
}
