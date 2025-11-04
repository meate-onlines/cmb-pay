package com.cmbchina.payment;

import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.core.CmbPaymentService;
import com.cmbchina.payment.model.request.OrderQueryRequest;
import com.cmbchina.payment.model.request.QrCodeApplyRequest;
import com.cmbchina.payment.model.response.OrderQueryResponse;
import com.cmbchina.payment.model.response.QrCodeApplyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * 收款码申请和订单查询功能测试类
 * 测试实际的API调用功能，而非请求构建
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("收款码申请和订单查询功能测试")
class QrCodeAndOrderQueryTest {
    
    private CmbPaymentConfig config;
    private CmbPaymentService paymentService;
    private CmbPaymentClient client;
    private ObjectMapper objectMapper;
    
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
                .notifyUrl("https://test.com/notify")
                .sandbox(true)
                .build();
        
        paymentService = new CmbPaymentService(config);
        client = new CmbPaymentClient(config);
        objectMapper = new ObjectMapper();
        
        // 注入 mock 的 RestTemplate
        ReflectionTestUtils.setField(paymentService, "restTemplate", restTemplate);
    }
    
    @Test
    @DisplayName("测试收款码申请 - 成功场景")
    void testQrCodeApplySuccess() throws Exception {
        // 准备测试数据
        QrCodeApplyRequest request = new QrCodeApplyRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("ORDER_" + System.currentTimeMillis());
        request.setUserId("test_user");
        request.setTxnAmt("10000");
        request.setBody("测试商品");
        request.setNotifyUrl("https://test.com/notify");
        
        // 模拟API响应
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("version", "0.0.1");
        responseMap.put("encoding", "UTF-8");
        responseMap.put("signMethod", "02");
        responseMap.put("returnCode", "SUCCESS");
        responseMap.put("respCode", "SUCCESS");
        responseMap.put("merId", "test_merchant_id");
        responseMap.put("orderId", request.getOrderId());
        responseMap.put("cmbOrderId", "CMB_ORDER_123456");
        responseMap.put("qrCode", "https://qr.test.com/123456");
        responseMap.put("txnTime", "20240101120000");
        responseMap.put("sign", "mock_sign_value");
        
        String responseJson = objectMapper.writeValueAsString(responseMap);
        ResponseEntity<String> responseEntity = new ResponseEntity<>(responseJson, HttpStatus.OK);
        
        // 设置mock行为
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(String.class)
        )).thenReturn(responseEntity);
        
        // 执行测试
        QrCodeApplyResponse response = client.qrCodeApply(request);
        
        // 验证结果
        assertNotNull(response);
        assertEquals("SUCCESS", response.getReturnCode());
        assertEquals("SUCCESS", response.getRespCode());
        assertEquals("test_merchant_id", response.getMerId());
        assertEquals(request.getOrderId(), response.getOrderId());
        assertEquals("CMB_ORDER_123456", response.getCmbOrderId());
        assertEquals("https://qr.test.com/123456", response.getQrCode());
        assertEquals("20240101120000", response.getTxnTime());
        assertTrue(response.isSuccess());
        
        // 验证调用了API
        verify(restTemplate, times(1)).exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(String.class)
        );
    }
    
    @Test
    @DisplayName("测试收款码申请 - 失败场景")
    void testQrCodeApplyFailure() throws Exception {
        // 准备测试数据
        QrCodeApplyRequest request = new QrCodeApplyRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("ORDER_FAIL");
        request.setUserId("test_user");
        request.setTxnAmt("10000");
        request.setBody("测试商品");
        request.setNotifyUrl("https://test.com/notify");
        
        // 模拟API失败响应
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("version", "0.0.1");
        responseMap.put("encoding", "UTF-8");
        responseMap.put("signMethod", "02");
        responseMap.put("returnCode", "SUCCESS");
        responseMap.put("respCode", "FAIL");
        responseMap.put("errCode", "ORDER_EXISTS");
        responseMap.put("respMsg", "订单号已存在");
        responseMap.put("sign", "mock_sign_value");
        
        String responseJson = objectMapper.writeValueAsString(responseMap);
        ResponseEntity<String> responseEntity = new ResponseEntity<>(responseJson, HttpStatus.OK);
        
        // 设置mock行为
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(String.class)
        )).thenReturn(responseEntity);
        
        // 执行测试
        QrCodeApplyResponse response = client.qrCodeApply(request);
        
        // 验证结果
        assertNotNull(response);
        assertEquals("SUCCESS", response.getReturnCode());
        assertEquals("FAIL", response.getRespCode());
        assertEquals("ORDER_EXISTS", response.getErrCode());
        assertEquals("订单号已存在", response.getRespMsg());
        assertFalse(response.isSuccess());
    }
    
    @Test
    @DisplayName("测试订单查询 - 支付成功场景")
    void testOrderQuerySuccess() throws Exception {
        // 准备测试数据
        OrderQueryRequest request = new OrderQueryRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("ORDER_123456");
        
        // 模拟API响应 - 订单已支付成功
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("version", "0.0.1");
        responseMap.put("encoding", "UTF-8");
        responseMap.put("signMethod", "02");
        responseMap.put("returnCode", "SUCCESS");
        responseMap.put("respCode", "SUCCESS");
        responseMap.put("merId", "test_merchant_id");
        responseMap.put("orderId", "ORDER_123456");
        responseMap.put("cmbOrderId", "CMB_ORDER_123456");
        responseMap.put("txnAmt", "10000");
        responseMap.put("dscAmt", "0");
        responseMap.put("currencyCode", "156");
        responseMap.put("payType", "ZF");
        responseMap.put("tradeState", "S");
        responseMap.put("txnTime", "20240101120000");
        responseMap.put("endDate", "20240101");
        responseMap.put("endTime", "120500");
        responseMap.put("thirdOrderId", "ALIPAY_123456");
        responseMap.put("openId", "test_openid");
        responseMap.put("buyerLogonId", "test@alipay.com");
        responseMap.put("sign", "mock_sign_value");
        
        String responseJson = objectMapper.writeValueAsString(responseMap);
        ResponseEntity<String> responseEntity = new ResponseEntity<>(responseJson, HttpStatus.OK);
        
        // 设置mock行为
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(String.class)
        )).thenReturn(responseEntity);
        
        // 执行测试
        OrderQueryResponse response = client.orderQuery(request);
        
        // 验证结果
        assertNotNull(response);
        assertEquals("SUCCESS", response.getReturnCode());
        assertEquals("SUCCESS", response.getRespCode());
        assertEquals("test_merchant_id", response.getMerId());
        assertEquals("ORDER_123456", response.getOrderId());
        assertEquals("CMB_ORDER_123456", response.getCmbOrderId());
        assertEquals("10000", response.getTxnAmt());
        assertEquals("0", response.getDscAmt());
        assertEquals("156", response.getCurrencyCode());
        assertEquals("ZF", response.getPayType());
        assertEquals("S", response.getTradeState());
        assertEquals("20240101120000", response.getTxnTime());
        assertEquals("20240101", response.getEndDate());
        assertEquals("120500", response.getEndTime());
        assertEquals("ALIPAY_123456", response.getThirdOrderId());
        assertEquals("test_openid", response.getOpenId());
        assertEquals("test@alipay.com", response.getBuyerLogonId());
        assertTrue(response.isSuccess());
        
        // 验证调用了API
        verify(restTemplate, times(1)).exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(String.class)
        );
    }
    
    @Test
    @DisplayName("测试订单查询 - 订单不存在场景")
    void testOrderQueryNotFound() throws Exception {
        // 准备测试数据
        OrderQueryRequest request = new OrderQueryRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("ORDER_NOT_EXIST");
        
        // 模拟API响应 - 订单不存在
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("version", "0.0.1");
        responseMap.put("encoding", "UTF-8");
        responseMap.put("signMethod", "02");
        responseMap.put("returnCode", "SUCCESS");
        responseMap.put("respCode", "FAIL");
        responseMap.put("merId", "test_merchant_id");
        responseMap.put("orderId", "ORDER_NOT_EXIST");
        responseMap.put("cmbOrderId", "");
        responseMap.put("errCode", "ORDER_NOT_FOUND");
        responseMap.put("respMsg", "订单不存在");
        responseMap.put("sign", "mock_sign_value");
        
        String responseJson = objectMapper.writeValueAsString(responseMap);
        ResponseEntity<String> responseEntity = new ResponseEntity<>(responseJson, HttpStatus.OK);
        
        // 设置mock行为
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(String.class)
        )).thenReturn(responseEntity);
        
        // 执行测试
        OrderQueryResponse response = client.orderQuery(request);
        
        // 验证结果
        assertNotNull(response);
        assertEquals("SUCCESS", response.getReturnCode());
        assertEquals("FAIL", response.getRespCode());
        assertEquals("ORDER_NOT_FOUND", response.getErrCode());
        assertEquals("订单不存在", response.getRespMsg());
        assertFalse(response.isSuccess());
    }
    
    @Test
    @DisplayName("测试订单查询 - 订单进行中场景")
    void testOrderQueryInProgress() throws Exception {
        // 准备测试数据
        OrderQueryRequest request = new OrderQueryRequest();
        request.setMerId("test_merchant_id");
        request.setOrderId("ORDER_123456");
        
        // 模拟API响应 - 订单进行中
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("version", "0.0.1");
        responseMap.put("encoding", "UTF-8");
        responseMap.put("signMethod", "02");
        responseMap.put("returnCode", "SUCCESS");
        responseMap.put("respCode", "SUCCESS");
        responseMap.put("merId", "test_merchant_id");
        responseMap.put("orderId", "ORDER_123456");
        responseMap.put("cmbOrderId", "CMB_ORDER_123456");
        responseMap.put("txnAmt", "10000");
        responseMap.put("dscAmt", "0");
        responseMap.put("currencyCode", "156");
        responseMap.put("payType", "WX");
        responseMap.put("tradeState", "P");
        responseMap.put("txnTime", "20240101120000");
        responseMap.put("sign", "mock_sign_value");
        
        String responseJson = objectMapper.writeValueAsString(responseMap);
        ResponseEntity<String> responseEntity = new ResponseEntity<>(responseJson, HttpStatus.OK);
        
        // 设置mock行为
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(String.class)
        )).thenReturn(responseEntity);
        
        // 执行测试
        OrderQueryResponse response = client.orderQuery(request);
        
        // 验证结果
        assertNotNull(response);
        assertEquals("SUCCESS", response.getReturnCode());
        assertEquals("SUCCESS", response.getRespCode());
        assertEquals("P", response.getTradeState());
        assertEquals("WX", response.getPayType());
        assertTrue(response.isSuccess());
        // 订单进行中，应该没有完成时间
        assertNull(response.getEndDate());
        assertNull(response.getEndTime());
    }
    
    @Test
    @DisplayName("测试完整流程 - 先申请收款码，再查询订单状态")
    void testCompleteFlow() throws Exception {
        String orderId = "ORDER_FLOW_" + System.currentTimeMillis();
        
        // 1. 先申请收款码
        QrCodeApplyRequest qrRequest = new QrCodeApplyRequest();
        qrRequest.setMerId("test_merchant_id");
        qrRequest.setOrderId(orderId);
        qrRequest.setUserId("test_user");
        qrRequest.setTxnAmt("10000");
        qrRequest.setBody("测试商品");
        qrRequest.setNotifyUrl("https://test.com/notify");
        
        // 模拟收款码申请成功响应
        Map<String, Object> qrResponseMap = new HashMap<>();
        qrResponseMap.put("version", "0.0.1");
        qrResponseMap.put("encoding", "UTF-8");
        qrResponseMap.put("signMethod", "02");
        qrResponseMap.put("returnCode", "SUCCESS");
        qrResponseMap.put("respCode", "SUCCESS");
        qrResponseMap.put("merId", "test_merchant_id");
        qrResponseMap.put("orderId", orderId);
        qrResponseMap.put("cmbOrderId", "CMB_ORDER_FLOW");
        qrResponseMap.put("qrCode", "https://qr.test.com/flow");
        qrResponseMap.put("txnTime", "20240101120000");
        qrResponseMap.put("sign", "mock_sign_value");
        
        String qrResponseJson = objectMapper.writeValueAsString(qrResponseMap);
        ResponseEntity<String> qrResponseEntity = new ResponseEntity<>(qrResponseJson, HttpStatus.OK);
        
        // 2. 模拟订单查询响应 - 订单进行中
        Map<String, Object> queryResponseMap = new HashMap<>();
        queryResponseMap.put("version", "0.0.1");
        queryResponseMap.put("encoding", "UTF-8");
        queryResponseMap.put("signMethod", "02");
        queryResponseMap.put("returnCode", "SUCCESS");
        queryResponseMap.put("respCode", "SUCCESS");
        queryResponseMap.put("merId", "test_merchant_id");
        queryResponseMap.put("orderId", orderId);
        queryResponseMap.put("cmbOrderId", "CMB_ORDER_FLOW");
        queryResponseMap.put("txnAmt", "10000");
        queryResponseMap.put("dscAmt", "0");
        queryResponseMap.put("currencyCode", "156");
        queryResponseMap.put("payType", "ZF");
        queryResponseMap.put("tradeState", "P");
        queryResponseMap.put("txnTime", "20240101120000");
        queryResponseMap.put("sign", "mock_sign_value");
        
        String queryResponseJson = objectMapper.writeValueAsString(queryResponseMap);
        ResponseEntity<String> queryResponseEntity = new ResponseEntity<>(queryResponseJson, HttpStatus.OK);
        
        // 设置mock行为 - 第一次调用返回收款码，第二次调用返回订单查询结果
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(String.class)
        )).thenReturn(qrResponseEntity).thenReturn(queryResponseEntity);
        
        // 执行收款码申请
        QrCodeApplyResponse qrResponse = client.qrCodeApply(qrRequest);
        
        // 验证收款码申请结果
        assertNotNull(qrResponse);
        assertTrue(qrResponse.isSuccess());
        assertNotNull(qrResponse.getQrCode());
        assertEquals("CMB_ORDER_FLOW", qrResponse.getCmbOrderId());
        
        // 执行订单查询
        OrderQueryRequest queryRequest = new OrderQueryRequest();
        queryRequest.setMerId("test_merchant_id");
        queryRequest.setOrderId(orderId);
        
        OrderQueryResponse queryResponse = client.orderQuery(queryRequest);
        
        // 验证订单查询结果
        assertNotNull(queryResponse);
        assertTrue(queryResponse.isSuccess());
        assertEquals("P", queryResponse.getTradeState());
        assertEquals("10000", queryResponse.getTxnAmt());
        assertEquals("CMB_ORDER_FLOW", queryResponse.getCmbOrderId());
        
        // 验证调用了两次API
        verify(restTemplate, times(2)).exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(String.class)
        );
    }
    
    @Test
    @DisplayName("测试收款码申请 - 参数验证失败")
    void testQrCodeApplyValidationFailure() throws Exception {
        // 创建缺少必填字段的请求
        QrCodeApplyRequest request = new QrCodeApplyRequest();
        request.setMerId("test_merchant_id");
        // 不设置其他必填字段 orderId, userId, txnAmt, notifyUrl
        
        // 模拟API返回参数错误
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("version", "0.0.1");
        responseMap.put("encoding", "UTF-8");
        responseMap.put("signMethod", "02");
        responseMap.put("returnCode", "FAIL");
        responseMap.put("errCode", "PARAM_ERROR");
        responseMap.put("respMsg", "参数错误：缺少必填字段");
        responseMap.put("sign", "mock_sign_value");
        
        String responseJson = objectMapper.writeValueAsString(responseMap);
        ResponseEntity<String> responseEntity = new ResponseEntity<>(responseJson, HttpStatus.OK);
        
        // 设置mock行为
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(String.class)
        )).thenReturn(responseEntity);
        
        // 执行测试
        QrCodeApplyResponse response = client.qrCodeApply(request);
        
        // 验证结果 - 应该返回失败
        assertNotNull(response);
        assertEquals("FAIL", response.getReturnCode());
        assertEquals("PARAM_ERROR", response.getErrCode());
        assertFalse(response.isSuccess());
    }
}

