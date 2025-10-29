package com.cmbchina.payment.example;

import com.cmbchina.payment.config.ConfigManager;
import com.cmbchina.payment.config.PaymentConfig;
import com.cmbchina.payment.model.*;
import com.cmbchina.payment.service.CmbPaymentService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 支付示例
 */
public class PaymentExample {
    
    public static void main(String[] args) {
        // 从配置文件加载配置
        PaymentConfig config = ConfigManager.loadFromFile();
        
        // 创建支付服务
        CmbPaymentService paymentService = new CmbPaymentService(config);
        
        try {
            // 示例1: 创建支付订单
            createPaymentExample(paymentService);
            
            // 示例2: 查询支付订单
            queryPaymentExample(paymentService);
            
            // 示例3: 申请退款
            refundExample(paymentService);
            
        } finally {
            // 关闭服务
            paymentService.close();
        }
    }
    
    /**
     * 创建支付订单示例
     */
    private static void createPaymentExample(CmbPaymentService paymentService) {
        System.out.println("=== 创建支付订单示例 ===");
        
        PaymentRequest request = new PaymentRequest();
        request.setOutTradeNo("ORDER_" + System.currentTimeMillis());
        request.setTotalAmount(new BigDecimal("100.00"));
        request.setSubject("测试商品");
        request.setBody("这是一个测试订单");
        request.setNotifyUrl("https://your-domain.com/notify");
        request.setReturnUrl("https://your-domain.com/return");
        request.setPaymentType("WECHAT");
        request.setExpireTime(LocalDateTime.now().plusMinutes(30));
        
        PaymentResponse response = paymentService.createPayment(request);
        
        if (response.isSuccess()) {
            System.out.println("支付订单创建成功:");
            System.out.println("交易号: " + response.getTradeNo());
            System.out.println("支付链接: " + response.getPayUrl());
            System.out.println("二维码: " + response.getQrCode());
        } else {
            System.out.println("支付订单创建失败: " + response.getMessage());
        }
    }
    
    /**
     * 查询支付订单示例
     */
    private static void queryPaymentExample(CmbPaymentService paymentService) {
        System.out.println("\n=== 查询支付订单示例 ===");
        
        QueryRequest request = new QueryRequest();
        request.setOutTradeNo("ORDER_" + System.currentTimeMillis());
        
        PaymentResponse response = paymentService.queryPayment(request);
        
        if (response.isSuccess()) {
            System.out.println("查询支付订单成功:");
            System.out.println("交易号: " + response.getTradeNo());
            System.out.println("交易状态: " + response.getTradeStatus());
            System.out.println("支付金额: " + response.getTotalAmount());
        } else {
            System.out.println("查询支付订单失败: " + response.getMessage());
        }
    }
    
    /**
     * 退款示例
     */
    private static void refundExample(CmbPaymentService paymentService) {
        System.out.println("\n=== 申请退款示例 ===");
        
        RefundRequest request = new RefundRequest();
        request.setOutTradeNo("ORDER_" + System.currentTimeMillis());
        request.setOutRefundNo("REFUND_" + System.currentTimeMillis());
        request.setRefundAmount(new BigDecimal("50.00"));
        request.setRefundReason("用户申请退款");
        
        RefundResponse response = paymentService.createRefund(request);
        
        if (response.isSuccess()) {
            System.out.println("退款申请成功:");
            System.out.println("退款号: " + response.getRefundNo());
            System.out.println("退款状态: " + response.getRefundStatus());
            System.out.println("退款金额: " + response.getRefundAmount());
        } else {
            System.out.println("退款申请失败: " + response.getMessage());
        }
    }
}