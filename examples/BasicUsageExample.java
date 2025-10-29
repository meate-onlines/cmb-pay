package examples;

import com.cmbchina.payment.CmbPaymentClient;
import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.exception.CmbPaymentException;
import com.cmbchina.payment.model.request.*;
import com.cmbchina.payment.model.response.*;

/**
 * 基础使用示例
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class BasicUsageExample {
    
    private static final String MERCHANT_ID = "your_merchant_id";
    private static final String APP_ID = "your_app_id";
    private static final String APP_SECRET = "your_app_secret";
    private static final String PRIVATE_KEY = "your_sm2_private_key";
    private static final String PUBLIC_KEY = "cmb_sm2_public_key";
    
    public static void main(String[] args) {
        // 1. 创建配置
        CmbPaymentConfig config = new CmbPaymentConfig.Builder()
            .merchantId(MERCHANT_ID)
            .appId(APP_ID)
            .appSecret(APP_SECRET)
            .privateKey(PRIVATE_KEY)
            .publicKey(PUBLIC_KEY)
            .apiUrl("https://api.cmburl.cn:8065")
            .notifyUrl("https://your-domain.com/notify")
            .sandbox(false) // 生产环境设为false，测试环境设为true
            .build();
        
        // 2. 创建客户端
        CmbPaymentClient client = new CmbPaymentClient(config);
        
        // 3. 执行各种支付操作
        BasicUsageExample example = new BasicUsageExample();
        
        try {
            // 收款码申请示例
            example.qrCodeApplyExample(client);
            
            // 付款码收款示例
            example.paymentExample(client);
            
            // 订单查询示例
            example.orderQueryExample(client);
            
            // 退款申请示例
            example.refundExample(client);
            
            // 退款查询示例
            example.refundQueryExample(client);
            
            // 关闭订单示例
            example.closeOrderExample(client);
            
            // 回调验证示例
            example.notifyVerifyExample(client);
            
        } catch (Exception e) {
            System.err.println("执行示例时发生异常: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * 收款码申请示例
     */
    public void qrCodeApplyExample(CmbPaymentClient client) {
        System.out.println("\n=== 收款码申请示例 ===");
        
        try {
            QrCodeApplyRequest request = new QrCodeApplyRequest();
            request.setMerId(MERCHANT_ID);
            request.setOrderId("ORDER_" + System.currentTimeMillis());
            request.setOrderAmt(10000L); // 100.00元
            request.setGoodsDes("测试商品-收款码支付");
            request.setNotifyUrl("https://your-domain.com/notify");
            request.setExpireTime(30); // 30分钟有效期
            request.setAttach("附加数据");
            
            QrCodeApplyResponse response = client.qrCodeApply(request);
            
            if (response.isSuccess()) {
                System.out.println("收款码申请成功:");
                System.out.println("  订单号: " + response.getOrderId());
                System.out.println("  平台订单号: " + response.getTnOrderId());
                System.out.println("  二维码链接: " + response.getQrCode());
                System.out.println("  订单状态: " + response.getOrderStat());
                System.out.println("  订单金额: " + response.getOrderAmt() + "分");
                System.out.println("  有效期至: " + response.getExpireTime());
            } else {
                System.out.println("收款码申请失败:");
                System.out.println("  返回码: " + response.getReturnCode());
                System.out.println("  返回信息: " + response.getReturnMsg());
                System.out.println("  结果码: " + response.getResultCode());
                System.out.println("  结果信息: " + response.getResultMsg());
            }
            
        } catch (CmbPaymentException e) {
            System.out.println("收款码申请异常:");
            System.out.println("  错误码: " + e.getErrorCode());
            System.out.println("  错误信息: " + e.getErrorMessage());
        }
    }
    
    /**
     * 付款码收款示例
     */
    public void paymentExample(CmbPaymentClient client) {
        System.out.println("\n=== 付款码收款示例 ===");
        
        try {
            PaymentRequest request = new PaymentRequest();
            request.setMerId(MERCHANT_ID);
            request.setOrderId("ORDER_" + System.currentTimeMillis());
            request.setOrderAmt(5000L); // 50.00元
            request.setGoodsDes("测试商品-付款码支付");
            request.setPayCode("134567890123456789"); // 模拟付款码
            request.setNotifyUrl("https://your-domain.com/notify");
            request.setStoreId("STORE001");
            request.setOperatorId("OP001");
            request.setTerminalId("T001");
            
            PaymentResponse response = client.pay(request);
            
            if (response.isSuccess()) {
                System.out.println("付款码收款成功:");
                System.out.println("  订单号: " + response.getOrderId());
                System.out.println("  平台订单号: " + response.getTnOrderId());
                System.out.println("  订单状态: " + response.getOrderStat());
                System.out.println("  订单金额: " + response.getOrderAmt() + "分");
                System.out.println("  实付金额: " + response.getPayAmt() + "分");
                System.out.println("  支付方式: " + response.getPayType());
                System.out.println("  支付时间: " + response.getPayTime());
                System.out.println("  第三方订单号: " + response.getThirdOrderId());
                System.out.println("  买家账号: " + response.getBuyerLogonId());
            } else {
                System.out.println("付款码收款失败:");
                System.out.println("  返回码: " + response.getReturnCode());
                System.out.println("  返回信息: " + response.getReturnMsg());
                System.out.println("  结果码: " + response.getResultCode());
                System.out.println("  结果信息: " + response.getResultMsg());
            }
            
        } catch (CmbPaymentException e) {
            System.out.println("付款码收款异常:");
            System.out.println("  错误码: " + e.getErrorCode());
            System.out.println("  错误信息: " + e.getErrorMessage());
        }
    }
    
    /**
     * 订单查询示例
     */
    public void orderQueryExample(CmbPaymentClient client) {
        System.out.println("\n=== 订单查询示例 ===");
        
        try {
            OrderQueryRequest request = new OrderQueryRequest();
            request.setMerId(MERCHANT_ID);
            request.setOrderId("ORDER_20241029001"); // 使用实际的订单号
            
            OrderQueryResponse response = client.orderQuery(request);
            
            if (response.isSuccess()) {
                System.out.println("订单查询成功:");
                System.out.println("  订单号: " + response.getOrderId());
                System.out.println("  平台订单号: " + response.getTnOrderId());
                System.out.println("  订单状态: " + response.getOrderStat());
                System.out.println("  订单金额: " + response.getOrderAmt() + "分");
                System.out.println("  实付金额: " + response.getPayAmt() + "分");
                System.out.println("  优惠金额: " + response.getDiscountAmt() + "分");
                System.out.println("  支付方式: " + response.getPayType());
                System.out.println("  支付时间: " + response.getPayTime());
                System.out.println("  买家账号: " + response.getBuyerLogonId());
            } else {
                System.out.println("订单查询失败:");
                System.out.println("  返回码: " + response.getReturnCode());
                System.out.println("  返回信息: " + response.getReturnMsg());
            }
            
        } catch (CmbPaymentException e) {
            System.out.println("订单查询异常:");
            System.out.println("  错误码: " + e.getErrorCode());
            System.out.println("  错误信息: " + e.getErrorMessage());
        }
    }
    
    /**
     * 退款申请示例
     */
    public void refundExample(CmbPaymentClient client) {
        System.out.println("\n=== 退款申请示例 ===");
        
        try {
            RefundRequest request = new RefundRequest();
            request.setMerId(MERCHANT_ID);
            request.setOrderId("ORDER_20241029001"); // 原订单号
            request.setRefundId("REFUND_" + System.currentTimeMillis());
            request.setRefundAmt(3000L); // 退款30.00元
            request.setRefundReason("用户申请退款");
            request.setNotifyUrl("https://your-domain.com/refund/notify");
            
            RefundResponse response = client.refund(request);
            
            if (response.isSuccess()) {
                System.out.println("退款申请成功:");
                System.out.println("  原订单号: " + response.getOrderId());
                System.out.println("  退款单号: " + response.getRefundId());
                System.out.println("  退款金额: " + response.getRefundAmt() + "分");
                System.out.println("  退款状态: " + response.getRefundStatus());
            } else {
                System.out.println("退款申请失败:");
                System.out.println("  返回码: " + response.getReturnCode());
                System.out.println("  返回信息: " + response.getReturnMsg());
            }
            
        } catch (CmbPaymentException e) {
            System.out.println("退款申请异常:");
            System.out.println("  错误码: " + e.getErrorCode());
            System.out.println("  错误信息: " + e.getErrorMessage());
        }
    }
    
    /**
     * 退款查询示例
     */
    public void refundQueryExample(CmbPaymentClient client) {
        System.out.println("\n=== 退款查询示例 ===");
        
        try {
            RefundQueryRequest request = new RefundQueryRequest();
            request.setMerId(MERCHANT_ID);
            request.setRefundId("REFUND_20241029001"); // 退款单号
            
            RefundQueryResponse response = client.refundQuery(request);
            
            if (response.isSuccess()) {
                System.out.println("退款查询成功:");
                System.out.println("  原订单号: " + response.getOrderId());
                System.out.println("  退款单号: " + response.getRefundId());
                System.out.println("  退款金额: " + response.getRefundAmt() + "分");
                System.out.println("  退款状态: " + response.getRefundStatus());
                System.out.println("  退款时间: " + response.getRefundTime());
            } else {
                System.out.println("退款查询失败:");
                System.out.println("  返回码: " + response.getReturnCode());
                System.out.println("  返回信息: " + response.getReturnMsg());
            }
            
        } catch (CmbPaymentException e) {
            System.out.println("退款查询异常:");
            System.out.println("  错误码: " + e.getErrorCode());
            System.out.println("  错误信息: " + e.getErrorMessage());
        }
    }
    
    /**
     * 关闭订单示例
     */
    public void closeOrderExample(CmbPaymentClient client) {
        System.out.println("\n=== 关闭订单示例 ===");
        
        try {
            CloseOrderRequest request = new CloseOrderRequest();
            request.setMerId(MERCHANT_ID);
            request.setOrderId("ORDER_20241029002"); // 要关闭的订单号
            
            CloseOrderResponse response = client.closeOrder(request);
            
            if (response.isSuccess()) {
                System.out.println("关闭订单成功:");
                System.out.println("  订单号: " + response.getOrderId());
                System.out.println("  订单状态: " + response.getOrderStat());
            } else {
                System.out.println("关闭订单失败:");
                System.out.println("  返回码: " + response.getReturnCode());
                System.out.println("  返回信息: " + response.getReturnMsg());
            }
            
        } catch (CmbPaymentException e) {
            System.out.println("关闭订单异常:");
            System.out.println("  错误码: " + e.getErrorCode());
            System.out.println("  错误信息: " + e.getErrorMessage());
        }
    }
    
    /**
     * 回调验证示例
     */
    public void notifyVerifyExample(CmbPaymentClient client) {
        System.out.println("\n=== 回调验证示例 ===");
        
        // 模拟回调数据（实际使用时从HTTP请求中获取）
        String notifyData = "version=0.0.1&encoding=UTF-8&signMethod=02&mer_id=" + MERCHANT_ID + 
            "&order_id=ORDER_20241029001&tn_order_id=TN123456789&order_stat=SUCCESS" +
            "&order_amt=10000&pay_amt=10000&pay_type=WECHAT&pay_time=20241029120000" +
            "&sign=mock_signature";
        
        try {
            // 验证签名
            boolean isValid = client.verifyNotify(notifyData);
            System.out.println("回调签名验证结果: " + (isValid ? "成功" : "失败"));
            
            if (isValid) {
                // 处理回调数据
                NotifyResponse notify = client.handleNotify(notifyData);
                
                System.out.println("回调数据解析成功:");
                System.out.println("  订单号: " + notify.getOrderId());
                System.out.println("  平台订单号: " + notify.getTnOrderId());
                System.out.println("  订单状态: " + notify.getOrderStat());
                System.out.println("  支付金额: " + notify.getPayAmt() + "分");
                System.out.println("  支付方式: " + notify.getPayType());
                System.out.println("  支付时间: " + notify.getPayTime());
                System.out.println("  是否支付成功: " + notify.isPaymentSuccess());
                System.out.println("  是否退款通知: " + notify.isRefundNotify());
            }
            
        } catch (CmbPaymentException e) {
            System.out.println("回调处理异常:");
            System.out.println("  错误码: " + e.getErrorCode());
            System.out.println("  错误信息: " + e.getErrorMessage());
        }
    }
}