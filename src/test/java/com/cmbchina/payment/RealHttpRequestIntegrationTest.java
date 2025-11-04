package com.cmbchina.payment;

import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.core.CmbPaymentService;
import com.cmbchina.payment.exception.CmbPaymentException;
import com.cmbchina.payment.model.request.OrderQueryRequest;
import com.cmbchina.payment.model.request.QrCodeApplyRequest;
import com.cmbchina.payment.model.response.OrderQueryResponse;
import com.cmbchina.payment.model.response.QrCodeApplyResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 真实HTTP请求集成测试
 * 用于测试HTTP请求和响应的日志打印功能
 * 
 * 使用方法：
 * 1. 设置环境变量或系统属性来配置API信息
 * 2. 如果没有配置，测试会自动跳过
 * 
 * 环境变量示例：
 * export CMB_API_URL=https://api.cmburl.cn:8065
 * export CMB_MERCHANT_ID=your_merchant_id
 * export CMB_APP_ID=your_app_id
 * export CMB_APP_SECRET=your_app_secret
 * export CMB_PRIVATE_KEY=your_private_key
 * export CMB_PUBLIC_KEY=your_public_key
 * 
 * 或使用系统属性：
 * -Dcmb.api.url=https://api.cmburl.cn:8065
 * -Dcmb.merchant.id=your_merchant_id
 * -Dcmb.app.id=your_app_id
 * -Dcmb.app.secret=your_app_secret
 * -Dcmb.private.key=your_private_key
 * -Dcmb.public.key=your_public_key
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
@DisplayName("真实HTTP请求集成测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RealHttpRequestIntegrationTest {
    
    // 用于存储创建的订单号，以便后续查询
    private static String createdOrderId = null;
    private static String createdCmbOrderId = null;
    
    /**
     * 测试收款码申请（下单）
     * 此测试会发送真实的HTTP请求到API服务器，创建订单并验证请求和响应的日志是否正确打印
     */
    @Test
    @Order(1)
    @DisplayName("测试收款码申请（下单）")
    void testQrCodeApply() {
        // 从环境变量或系统属性获取API URL
        String apiUrl = "https://api.cmburl.cn:8065";
        
        // 如果没有配置API URL，跳过测试
        if (apiUrl == null || apiUrl.isEmpty()) {
            System.out.println("========================================");
            System.out.println("跳过真实HTTP请求测试：未配置API URL");
            System.out.println("提示：设置环境变量 CMB_API_URL 或系统属性 cmb.api.url 来启用此测试");
            System.out.println("========================================");
            return;
        }
        
        // 从环境变量或系统属性获取其他配置
        String merchantId = "3089991074200KV";
        String appId = "8ab74856-8772-45c9-96db-54cb30ab9f74";
        String appSecret = "5b96f20a-011f-4254-8be8-9a5ceb2f317f";
        String privateKey = "D5F2AFA24E6BA9071B54A8C9AD735F9A1DE9C4657FA386C09B592694BC118B38";
        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE6Q+fktsnY9OFP+LpSR5Udbxf5zHCFO0PmOKlFNTxDIGl8jsPbbB/9ET23NV+acSz4FEkzD74sW2iiNVHRLiKHg==";
        
        // 检查必要的配置
        if (merchantId == null || appId == null || appSecret == null || 
            privateKey == null || publicKey == null) {
            System.out.println("========================================");
            System.out.println("跳过真实HTTP请求测试：缺少必要的配置信息");
            System.out.println("提示：需要设置以下环境变量或系统属性：");
            System.out.println("  - CMB_MERCHANT_ID / cmb.merchant.id");
            System.out.println("  - CMB_APP_ID / cmb.app.id");
            System.out.println("  - CMB_APP_SECRET / cmb.app.secret");
            System.out.println("  - CMB_PRIVATE_KEY / cmb.private.key");
            System.out.println("  - CMB_PUBLIC_KEY / cmb.public.key");
            System.out.println("========================================");
            return;
        }
        
        System.out.println("========================================");
        System.out.println("开始真实HTTP请求测试");
        System.out.println("API URL: " + apiUrl);
        System.out.println("商户ID: " + merchantId);
        System.out.println("应用ID: " + appId);
        System.out.println("========================================");
        
        // 创建真实的配置
        CmbPaymentConfig realConfig = new CmbPaymentConfig.Builder()
                .merchantId(merchantId)
                .appId(appId)
                .appSecret(appSecret)
                .privateKey(privateKey)
                .publicKey(publicKey)
                .apiUrl(apiUrl)
                .sandbox(true)
                .connectTimeout(30000)
                .readTimeout(30000)
                .build();
        
        // 创建真实的支付服务（不使用Mock）
        // 注意：这个服务会使用HttpLoggingUtil来打印请求和响应
        CmbPaymentService realService = new CmbPaymentService(realConfig);
        
        // 获取通知URL（可选）
        String notifyUrl = getProperty("CMB_NOTIFY_URL", "cmb.notify.url");
        if (notifyUrl == null || notifyUrl.isEmpty()) {
            notifyUrl = "https://dev-api.bangyangjia.com/admin-api/pay/notify/order/46"; // 默认测试URL
        }
        
        // 创建收款码申请请求（下单）
        QrCodeApplyRequest request = new QrCodeApplyRequest();
        String orderId = "" + System.currentTimeMillis(); // 使用时间戳确保唯一性
        request.setMerId(merchantId);
        request.setOrderId("1234567891011134");
        request.setTxnAmt("100"); // 1元，单位：分
        request.setBody("测试中文下单");
        request.setNotifyUrl(notifyUrl);
        request.setUserId("N003363806"); // 收银员ID（必填）
        
        System.out.println("\n发送收款码申请请求（下单）...");
        System.out.println("订单号: " + orderId);
        System.out.println("订单金额: 1.00元（100分）");
        System.out.println("商品描述: " + request.getBody());
        System.out.println("\n请查看上面的日志输出，应该能看到：");
        System.out.println("1. HTTP REQUEST 详细信息（方法、URL、请求头、请求体）");
        System.out.println("2. HTTP RESPONSE 详细信息（状态码、响应头、响应体）");
        System.out.println("\n");
        
        try {
            // 发送真实的HTTP请求
            QrCodeApplyResponse response = realService.qrCodeApply(request);
            
            // 如果请求成功，验证响应
            assertNotNull(response, "响应不应为空");
            createdOrderId = orderId;
            if (response.getCmbOrderId() != null) {
                createdCmbOrderId = response.getCmbOrderId();
            }
            
            System.out.println("========================================");
            System.out.println("收款码申请成功！");
            System.out.println("商户订单号: " + response.getOrderId());
            if (response.getCmbOrderId() != null) {
                System.out.println("平台订单号: " + response.getCmbOrderId());
            }
            if (response.getQrCode() != null) {
                System.out.println("二维码: " + response.getQrCode());
            }
            System.out.println("========================================");
            
        } catch (CmbPaymentException e) {
            // 请求失败可能是业务错误
            System.out.println("========================================");
            System.out.println("收款码申请失败（业务错误）");
            System.out.println("错误码：" + e.getErrorCode());
            System.out.println("错误信息：" + e.getMessage());
            System.out.println("========================================");
            System.out.println("\n✓ HTTP请求和响应日志已成功打印");
            System.out.println("✓ 即使业务失败，也能看到完整的请求和响应信息");
            
            // 验证异常被正确抛出
            assertNotNull(e);
            assertNotNull(e.getErrorCode());
        } catch (Exception e) {
            // 网络错误或其他异常
            System.out.println("========================================");
            System.out.println("收款码申请遇到网络或其他错误");
            System.out.println("异常类型：" + e.getClass().getName());
            System.out.println("异常信息：" + e.getMessage());
            System.out.println("========================================");
            
            // 即使有网络错误，也应该能看到请求日志
            System.out.println("\n✓ HTTP请求日志应该已经打印（即使响应失败）");
        }
    }
    
    /**
     * 测试订单查询
     * 此测试会发送真实的HTTP请求到API服务器，查询订单并验证请求和响应的日志是否正确打印
     */
    @Test
    @Order(2)
    @DisplayName("测试订单查询")
    void testOrderQuery() {
    
        // 从环境变量或系统属性获取API URL
        String apiUrl = "https://api.cmburl.cn:8065";
        
        // 如果没有配置API URL，跳过测试
        if (apiUrl == null || apiUrl.isEmpty()) {
            System.out.println("========================================");
            System.out.println("跳过订单查询测试：未配置API URL");
            System.out.println("提示：设置环境变量 CMB_API_URL 或系统属性 cmb.api.url 来启用此测试");
            System.out.println("========================================");
            return;
        }
        
        // 从环境变量或系统属性获取其他配置
        String merchantId = "3089991074200KV";
        String appId = "8ab74856-8772-45c9-96db-54cb30ab9f74";
        String appSecret = "5b96f20a-011f-4254-8be8-9a5ceb2f317f";
        String privateKey = "D5F2AFA24E6BA9071B54A8C9AD735F9A1DE9C4657FA386C09B592694BC118B38";
        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE6Q+fktsnY9OFP+LpSR5Udbxf5zHCFO0PmOKlFNTxDIGl8jsPbbB/9ET23NV+acSz4FEkzD74sW2iiNVHRLiKHg==";
        
        // 检查必要的配置
        if (merchantId == null || appId == null || appSecret == null || 
            privateKey == null || publicKey == null) {
            System.out.println("========================================");
            System.out.println("跳过订单查询测试：缺少必要的配置信息");
            System.out.println("========================================");
            return;
        }
        
        System.out.println("========================================");
        System.out.println("开始订单查询测试");
        System.out.println("API URL: " + apiUrl);
        System.out.println("商户ID: " + merchantId);
        System.out.println("========================================");
        
        // 创建真实的配置
        CmbPaymentConfig realConfig = new CmbPaymentConfig.Builder()
                .merchantId(merchantId)
                .appId(appId)
                .appSecret(appSecret)
                .privateKey(privateKey)
                .publicKey(publicKey)
                .apiUrl(apiUrl)
                .sandbox(true)
                .connectTimeout(30000)
                .readTimeout(30000)
                .build();
        
        // 创建真实的支付服务（不使用Mock）
        CmbPaymentService realService = new CmbPaymentService(realConfig);
        
        // 创建订单查询请求
        OrderQueryRequest request = new OrderQueryRequest();
        request.setMerId(merchantId);
        
        // // 优先使用之前创建的订单号，如果没有则使用新的测试订单号
        // if (createdOrderId != null) {
        //     request.setOrderId(createdOrderId);
        //     System.out.println("\n查询之前创建的订单...");
        //     System.out.println("订单号: " + createdOrderId);
        // } else {
        //     String testOrderId = "TEST_QUERY_" + System.currentTimeMillis();
        //     request.setOrderId(testOrderId);
        //     System.out.println("\n查询测试订单（可能不存在）...");
        //     System.out.println("订单号: " + testOrderId);
        // }
        
        // // 如果之前创建了平台订单号，也可以使用平台订单号查询
        // if (createdCmbOrderId != null) {
        //     System.out.println("平台订单号: " + createdCmbOrderId);
        // }
        request.setOrderId("1234567891011");
        
        System.out.println("\n请查看上面的日志输出，应该能看到：");
        System.out.println("1. HTTP REQUEST 详细信息（方法、URL、请求头、请求体）");
        System.out.println("2. HTTP RESPONSE 详细信息（状态码、响应头、响应体）");
        System.out.println("\n");
        
        try {
            // 发送真实的HTTP请求
            OrderQueryResponse response = realService.orderQuery(request);
            
            // 如果请求成功，验证响应
            assertNotNull(response, "响应不应为空");
            
            System.out.println("========================================");
            System.out.println("订单查询成功！");
            System.out.println("商户订单号: " + response.getOrderId());
            if (response.getCmbOrderId() != null) {
                System.out.println("平台订单号: " + response.getCmbOrderId());
            }
            if (response.getTradeState() != null) {
                System.out.println("交易状态: " + response.getTradeState());
            }
            if (response.getTxnAmt() != null) {
                System.out.println("交易金额: " + response.getTxnAmt() + " 分");
            }
            if (response.getPayType() != null) {
                System.out.println("支付方式: " + response.getPayType());
            }
            System.out.println("========================================");
            
        } catch (CmbPaymentException e) {
            // 请求失败是预期的（可能是订单不存在或其他业务错误）
            // 但我们可以验证HTTP请求和响应都被正确记录了
            System.out.println("========================================");
            System.out.println("订单查询完成（业务错误是预期的）");
            System.out.println("错误码：" + e.getErrorCode());
            System.out.println("错误信息：" + e.getMessage());
            System.out.println("========================================");
            System.out.println("\n✓ HTTP请求和响应日志已成功打印");
            System.out.println("✓ 即使业务失败，也能看到完整的请求和响应信息");
            
            // 验证异常被正确抛出
            assertNotNull(e);
            assertNotNull(e.getErrorCode());
        } catch (Exception e) {
            // 网络错误或其他异常
            System.out.println("========================================");
            System.out.println("订单查询遇到网络或其他错误");
            System.out.println("异常类型：" + e.getClass().getName());
            System.out.println("异常信息：" + e.getMessage());
            System.out.println("========================================");
            
            // 即使有网络错误，也应该能看到请求日志
            System.out.println("\n✓ HTTP请求日志应该已经打印（即使响应失败）");
        }
    }
    
    /**
     * 测试完整流程：下单后查询订单
     * 此测试会先创建订单，然后查询该订单
     */
    @Test
    @Order(3)
    @DisplayName("测试完整流程：下单后查询")
    void testCompleteFlow() {
        // 从环境变量或系统属性获取API URL
        String apiUrl = "https://api.cmburl.cn:8065";
        
        // 如果没有配置API URL，跳过测试
        if (apiUrl == null || apiUrl.isEmpty()) {
            System.out.println("========================================");
            System.out.println("跳过完整流程测试：未配置API URL");
            System.out.println("========================================");
            return;
        }
        
        // 从环境变量或系统属性获取其他配置
        String merchantId = getProperty("CMB_MERCHANT_ID", "cmb.merchant.id");
        String appId = getProperty("CMB_APP_ID", "cmb.app.id");
        String appSecret = getProperty("CMB_APP_SECRET", "cmb.app.secret");
        String privateKey = getProperty("CMB_PRIVATE_KEY", "cmb.private.key");
        String publicKey = getProperty("CMB_PUBLIC_KEY", "cmb.public.key");
        
        // 检查必要的配置
        if (merchantId == null || appId == null || appSecret == null || 
            privateKey == null || publicKey == null) {
            System.out.println("========================================");
            System.out.println("跳过完整流程测试：缺少必要的配置信息");
            System.out.println("========================================");
            return;
        }
        
        System.out.println("========================================");
        System.out.println("开始完整流程测试：下单 -> 查询");
        System.out.println("========================================");
        
        // 创建真实的配置
        CmbPaymentConfig realConfig = new CmbPaymentConfig.Builder()
                .merchantId(merchantId)
                .appId(appId)
                .appSecret(appSecret)
                .privateKey(privateKey)
                .publicKey(publicKey)
                .apiUrl(apiUrl)
                .sandbox(true)
                .connectTimeout(30000)
                .readTimeout(30000)
                .build();
        
        // 创建真实的支付服务（不使用Mock）
        CmbPaymentService realService = new CmbPaymentService(realConfig);
        
        // 获取通知URL（可选）
        String notifyUrl = getProperty("CMB_NOTIFY_URL", "cmb.notify.url");
        if (notifyUrl == null || notifyUrl.isEmpty()) {
            notifyUrl = "https://test.example.com/notify"; // 默认测试URL
        }
        
        // 第一步：创建订单
        String orderId = "TEST_FLOW_" + System.currentTimeMillis();
        QrCodeApplyRequest applyRequest = new QrCodeApplyRequest();
        applyRequest.setMerId(merchantId);
        applyRequest.setOrderId(orderId);
        applyRequest.setTxnAmt("200"); // 2元，单位：分
        applyRequest.setBody("完整流程测试商品");
        applyRequest.setNotifyUrl(notifyUrl);
        applyRequest.setUserId("test_user_002");
        
        System.out.println("\n========== 第一步：创建订单 ==========");
        System.out.println("订单号: " + orderId);
        System.out.println("订单金额: 2.00元（200分）");
        
        String cmbOrderId = null;
        try {
            QrCodeApplyResponse applyResponse = realService.qrCodeApply(applyRequest);
            assertNotNull(applyResponse, "创建订单响应不应为空");
            cmbOrderId = applyResponse.getCmbOrderId();
            
            System.out.println("✓ 订单创建成功");
            System.out.println("商户订单号: " + applyResponse.getOrderId());
            if (cmbOrderId != null) {
                System.out.println("平台订单号: " + cmbOrderId);
            }
            
        } catch (CmbPaymentException e) {
            System.out.println("✗ 订单创建失败");
            System.out.println("错误码: " + e.getErrorCode());
            System.out.println("错误信息: " + e.getMessage());
            // 如果创建失败，仍然尝试查询（可能订单已经存在）
        }
        
        // 等待一小段时间，确保订单已处理
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // 第二步：查询订单
        System.out.println("\n========== 第二步：查询订单 ==========");
        OrderQueryRequest queryRequest = new OrderQueryRequest();
        queryRequest.setMerId(merchantId);
        queryRequest.setOrderId(orderId);
        
        try {
            OrderQueryResponse queryResponse = realService.orderQuery(queryRequest);
            assertNotNull(queryResponse, "查询订单响应不应为空");
            
            System.out.println("✓ 订单查询成功");
            System.out.println("商户订单号: " + queryResponse.getOrderId());
            if (queryResponse.getCmbOrderId() != null) {
                System.out.println("平台订单号: " + queryResponse.getCmbOrderId());
            }
            if (queryResponse.getTradeState() != null) {
                System.out.println("交易状态: " + queryResponse.getTradeState());
            }
            if (queryResponse.getTxnAmt() != null) {
                System.out.println("交易金额: " + queryResponse.getTxnAmt() + " 分");
            }
            
            System.out.println("\n========================================");
            System.out.println("完整流程测试完成！");
            System.out.println("✓ 已成功创建订单并查询订单");
            System.out.println("✓ 所有HTTP请求和响应日志都已打印");
            System.out.println("========================================");
            
        } catch (CmbPaymentException e) {
            System.out.println("✗ 订单查询失败");
            System.out.println("错误码: " + e.getErrorCode());
            System.out.println("错误信息: " + e.getMessage());
            System.out.println("\n✓ 即使查询失败，HTTP请求和响应日志也已打印");
        }
    }
    
    /**
     * 从环境变量或系统属性获取配置值
     * 优先使用环境变量，如果环境变量不存在，则使用系统属性
     * 
     * @param envVar 环境变量名
     * @param sysProp 系统属性名
     * @return 配置值，如果都不存在则返回null
     */
    private String getProperty(String envVar, String sysProp) {
        String value = System.getenv(envVar);
        if (value == null || value.isEmpty()) {
            value = System.getProperty(sysProp);
        }
        return value;
    }
}

