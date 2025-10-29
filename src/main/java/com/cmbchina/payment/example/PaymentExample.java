package com.cmbchina.payment.example;

import com.cmbchina.payment.CmbPaymentClient;
import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.exception.CmbPaymentException;
import com.cmbchina.payment.model.request.*;
import com.cmbchina.payment.model.response.*;

/**
 * 招商银行支付SDK使用示例
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class PaymentExample {
    
    public static void main(String[] args) {
        // 创建配置
        CmbPaymentConfig config = new CmbPaymentConfig.Builder()
            .merchantId("your_merchant_id")
            .appId("your_app_id")
            .appSecret("your_app_secret")
            .privateKey("your_sm2_private_key")
            .publicKey("your_sm2_public_key")
            .apiUrl("https://api.cmburl.cn:8065")
            .notifyUrl("https://your-domain.com/notify")
            .returnUrl("https://your-domain.com/return")
            .sandbox(true) // 测试环境
            .build();
        
        // 创建支付客户端
        CmbPaymentClient client = new CmbPaymentClient(config);
        
        // 示例1：收款码申请
        qrCodeApplyExample(client);
        
        // 示例2：订单查询
        orderQueryExample(client);
        
        // 示例3：退款申请
        refundExample(client);
        
        // 示例4：微信统一下单
        wechatUnifiedOrderExample(client);
        
        // 示例5：处理异步通知
        notifyExample(client);
    }
    
    /**
     * 收款码申请示例
     */
    private static void qrCodeApplyExample(CmbPaymentClient client) {
        System.out.println("=== 收款码申请示例 ===");
        
        QrCodeApplyRequest request = new QrCodeApplyRequest();
        request.setMerId("your_merchant_id");
        request.setOrderId("ORDER_" + System.currentTimeMillis());
        request.setOrderAmt(10000L); // 100.00元，单位：分
        request.setGoodsDes("测试商品");
        request.setNotifyUrl("https://your-domain.com/notify");
        request.setReturnUrl("https://your-domain.com/return");
        request.setExpireTime(30); // 30分钟过期
        
        try {
            QrCodeApplyResponse response = client.qrCodeApply(request);
            
            if (response.isSuccess()) {
                System.out.println("二维码链接: " + response.getQrCode());
                System.out.println("二维码图片: " + response.getQrCodeImg());
                System.out.println("平台订单号: " + response.getTnOrderId());
            } else {
                System.out.println("申请失败: " + response.getResultMsg());
            }
        } catch (CmbPaymentException e) {
            System.err.println("支付异常: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 订单查询示例
     */
    private static void orderQueryExample(CmbPaymentClient client) {
        System.out.println("=== 订单查询示例 ===");
        
        OrderQueryRequest queryRequest = new OrderQueryRequest();
        queryRequest.setMerId("your_merchant_id");
        queryRequest.setOrderId("ORDER_123456789");
        
        try {
            OrderQueryResponse response = client.orderQuery(queryRequest);
            
            if (response.isSuccess()) {
                System.out.println("订单状态: " + response.getOrderStat());
                System.out.println("订单金额: " + response.getOrderAmt());
                System.out.println("支付方式: " + response.getPayType());
                System.out.println("支付时间: " + response.getPayTime());
            }
        } catch (CmbPaymentException e) {
            System.err.println("查询异常: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 退款申请示例
     */
    private static void refundExample(CmbPaymentClient client) {
        System.out.println("=== 退款申请示例 ===");
        
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setMerId("your_merchant_id");
        refundRequest.setOrderId("ORDER_123456789");
        refundRequest.setRefundOrderId("REFUND_" + System.currentTimeMillis());
        refundRequest.setRefundAmt(5000L); // 退款50.00元
        refundRequest.setRefundReason("用户申请退款");
        
        try {
            RefundResponse response = client.refund(refundRequest);
            
            if (response.isSuccess()) {
                System.out.println("退款状态: " + response.getRefundStat());
                System.out.println("退款金额: " + response.getRefundAmt());
            }
        } catch (CmbPaymentException e) {
            System.err.println("退款异常: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 微信统一下单示例
     */
    private static void wechatUnifiedOrderExample(CmbPaymentClient client) {
        System.out.println("=== 微信统一下单示例 ===");
        
        WechatUnifiedOrderRequest request = new WechatUnifiedOrderRequest();
        request.setMerId("your_merchant_id");
        request.setOrderId("WECHAT_ORDER_" + System.currentTimeMillis());
        request.setOrderAmt(20000L); // 200.00元
        request.setGoodsDes("微信支付测试商品");
        request.setPayType("JSAPI"); // 公众号支付
        request.setOpenid("user_openid_here");
        request.setNotifyUrl("https://your-domain.com/notify");
        request.setReturnUrl("https://your-domain.com/return");
        
        try {
            WechatUnifiedOrderResponse response = client.wechatUnifiedOrder(request);
            
            if (response.isSuccess()) {
                System.out.println("预支付ID: " + response.getPrepayId());
                System.out.println("支付参数: " + response.getPayParams());
                System.out.println("平台订单号: " + response.getTnOrderId());
            }
        } catch (CmbPaymentException e) {
            System.err.println("微信支付异常: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 异步通知处理示例
     */
    private static void notifyExample(CmbPaymentClient client) {
        System.out.println("=== 异步通知处理示例 ===");
        
        // 模拟接收到的通知数据
        String notifyData = "mer_id=your_merchant_id&order_id=ORDER_123456789&order_stat=SUCCESS&order_amt=10000&sign=example_sign";
        
        try {
            // 验证通知签名
            boolean isValid = client.verifyNotify(notifyData);
            
            if (isValid) {
                System.out.println("通知签名验证成功");
                
                // 处理通知数据
                NotifyResponse notifyResponse = client.handleNotify(notifyData);
                
                System.out.println("订单号: " + notifyResponse.getOrderId());
                System.out.println("订单状态: " + notifyResponse.getOrderStat());
                System.out.println("订单金额: " + notifyResponse.getOrderAmt());
                
                // 处理业务逻辑
                if ("SUCCESS".equals(notifyResponse.getOrderStat())) {
                    System.out.println("支付成功，更新订单状态");
                    // 这里可以调用业务系统更新订单状态
                }
            } else {
                System.out.println("通知签名验证失败");
            }
        } catch (CmbPaymentException e) {
            System.err.println("处理通知异常: " + e.getMessage());
        }
        
        System.out.println();
    }
}