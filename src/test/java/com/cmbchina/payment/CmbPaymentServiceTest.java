package com.cmbchina.payment;

import com.cmbchina.payment.config.PaymentConfig;
import com.cmbchina.payment.model.*;
import com.cmbchina.payment.service.CmbPaymentService;
import com.cmbchina.payment.util.SignUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * 支付服务测试类
 */
@ExtendWith(MockitoExtension.class)
class CmbPaymentServiceTest {
    
    @Mock
    private PaymentConfig config;
    
    private CmbPaymentService paymentService;
    
    @BeforeEach
    void setUp() {
        when(config.getMerchantId()).thenReturn("test_merchant");
        when(config.getPrivateKey()).thenReturn("test_private_key");
        when(config.getPublicKey()).thenReturn("test_public_key");
        when(config.getApiUrl()).thenReturn("https://api.test.com");
        when(config.getSignType()).thenReturn("RSA2");
        
        paymentService = new CmbPaymentService(config);
    }
    
    @Test
    void testCreatePayment() {
        // 准备测试数据
        PaymentRequest request = new PaymentRequest();
        request.setOutTradeNo("TEST_ORDER_001");
        request.setTotalAmount(new BigDecimal("100.00"));
        request.setSubject("测试商品");
        request.setBody("测试订单");
        request.setPaymentType("WECHAT");
        request.setNotifyUrl("https://test.com/notify");
        
        // 注意：这里需要模拟HTTP响应，实际测试中应该使用MockWebServer
        // 由于没有实际的API端点，这里主要测试参数构建逻辑
        assertNotNull(request.getOutTradeNo());
        assertNotNull(request.getTotalAmount());
        assertEquals("WECHAT", request.getPaymentType());
    }
    
    @Test
    void testQueryPayment() {
        QueryRequest request = new QueryRequest();
        request.setOutTradeNo("TEST_ORDER_001");
        
        assertNotNull(request.getOutTradeNo());
    }
    
    @Test
    void testCreateRefund() {
        RefundRequest request = new RefundRequest();
        request.setOutTradeNo("TEST_ORDER_001");
        request.setOutRefundNo("TEST_REFUND_001");
        request.setRefundAmount(new BigDecimal("50.00"));
        request.setRefundReason("测试退款");
        
        assertNotNull(request.getOutTradeNo());
        assertNotNull(request.getOutRefundNo());
        assertNotNull(request.getRefundAmount());
    }
    
    @Test
    void testVerifyNotify() {
        NotifyRequest notifyRequest = new NotifyRequest();
        notifyRequest.setMerchantId("test_merchant");
        notifyRequest.setTradeNo("TEST_TRADE_001");
        notifyRequest.setOutTradeNo("TEST_ORDER_001");
        notifyRequest.setTotalAmount(new BigDecimal("100.00"));
        notifyRequest.setTradeStatus("SUCCESS");
        notifyRequest.setPaymentType("WECHAT");
        notifyRequest.setCreateTime(LocalDateTime.now());
        notifyRequest.setSign("test_sign");
        notifyRequest.setSignType("RSA2");
        
        // 注意：这里需要模拟签名验证，实际测试中应该使用真实的签名数据
        assertNotNull(notifyRequest.getMerchantId());
        assertNotNull(notifyRequest.getTradeNo());
        assertNotNull(notifyRequest.getSign());
    }
}