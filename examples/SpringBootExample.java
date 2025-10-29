package examples;

import com.cmbchina.payment.CmbPaymentClient;
import com.cmbchina.payment.callback.NotifyProcessor;
import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.exception.CmbPaymentException;
import com.cmbchina.payment.model.request.OrderQueryRequest;
import com.cmbchina.payment.model.request.PaymentRequest;
import com.cmbchina.payment.model.request.QrCodeApplyRequest;
import com.cmbchina.payment.model.response.NotifyResponse;
import com.cmbchina.payment.model.response.OrderQueryResponse;
import com.cmbchina.payment.model.response.PaymentResponse;
import com.cmbchina.payment.model.response.QrCodeApplyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * Spring Boot 集成示例
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
@SpringBootApplication
public class SpringBootExample {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootExample.class, args);
    }
    
    /**
     * 支付配置
     */
    @Configuration
    public static class PaymentConfig {
        
        @Bean
        public CmbPaymentConfig cmbPaymentConfig() {
            return new CmbPaymentConfig.Builder()
                .merchantId("your_merchant_id")
                .appId("your_app_id")
                .appSecret("your_app_secret")
                .privateKey("your_sm2_private_key")
                .publicKey("cmb_sm2_public_key")
                .apiUrl("https://api.cmburl.cn:8065")
                .notifyUrl("https://your-domain.com/cmb/payment/notify")
                .sandbox(false)
                .build();
        }
        
        @Bean
        public CmbPaymentClient cmbPaymentClient(CmbPaymentConfig config) {
            return new CmbPaymentClient(config);
        }
    }
    
    /**
     * 支付服务
     */
    @Service
    public static class PaymentService {
        
        private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
        
        @Autowired
        private CmbPaymentClient paymentClient;
        
        /**
         * 创建收款码
         */
        public String createQrCode(String orderId, Long amount, String goodsDesc) {
            try {
                QrCodeApplyRequest request = new QrCodeApplyRequest();
                request.setMerId("your_merchant_id");
                request.setOrderId(orderId);
                request.setOrderAmt(amount);
                request.setGoodsDes(goodsDesc);
                request.setExpireTime(30); // 30分钟有效期
                
                QrCodeApplyResponse response = paymentClient.qrCodeApply(request);
                
                if (response.isSuccess()) {
                    logger.info("收款码创建成功: orderId={}, qrCode={}", orderId, response.getQrCode());
                    return response.getQrCode();
                } else {
                    logger.error("收款码创建失败: orderId={}, error={}", orderId, response.getResultMsg());
                    throw new RuntimeException("收款码创建失败: " + response.getResultMsg());
                }
                
            } catch (CmbPaymentException e) {
                logger.error("收款码创建异常: orderId={}", orderId, e);
                throw new RuntimeException("收款码创建异常", e);
            }
        }
        
        /**
         * 付款码收款
         */
        public boolean processPayment(String orderId, Long amount, String goodsDesc, String payCode) {
            try {
                PaymentRequest request = new PaymentRequest();
                request.setMerId("your_merchant_id");
                request.setOrderId(orderId);
                request.setOrderAmt(amount);
                request.setGoodsDes(goodsDesc);
                request.setPayCode(payCode);
                
                PaymentResponse response = paymentClient.pay(request);
                
                if (response.isSuccess()) {
                    logger.info("付款码收款成功: orderId={}, payAmt={}", orderId, response.getPayAmt());
                    return true;
                } else {
                    logger.error("付款码收款失败: orderId={}, error={}", orderId, response.getResultMsg());
                    return false;
                }
                
            } catch (CmbPaymentException e) {
                logger.error("付款码收款异常: orderId={}", orderId, e);
                return false;
            }
        }
        
        /**
         * 查询订单状态
         */
        public String queryOrderStatus(String orderId) {
            try {
                OrderQueryRequest request = new OrderQueryRequest();
                request.setMerId("your_merchant_id");
                request.setOrderId(orderId);
                
                OrderQueryResponse response = paymentClient.orderQuery(request);
                
                if (response.isSuccess()) {
                    logger.info("订单查询成功: orderId={}, status={}", orderId, response.getOrderStat());
                    return response.getOrderStat();
                } else {
                    logger.error("订单查询失败: orderId={}, error={}", orderId, response.getResultMsg());
                    return "UNKNOWN";
                }
                
            } catch (CmbPaymentException e) {
                logger.error("订单查询异常: orderId={}", orderId, e);
                return "ERROR";
            }
        }
    }
    
    /**
     * 支付控制器
     */
    @RestController
    @RequestMapping("/api/payment")
    public static class PaymentController {
        
        @Autowired
        private PaymentService paymentService;
        
        /**
         * 创建收款码
         */
        @PostMapping("/qrcode")
        public ApiResponse<String> createQrCode(@RequestBody QrCodeRequest request) {
            try {
                String orderId = "ORDER_" + System.currentTimeMillis();
                String qrCode = paymentService.createQrCode(orderId, request.getAmount(), request.getGoodsDesc());
                
                return ApiResponse.success(qrCode);
                
            } catch (Exception e) {
                return ApiResponse.error("创建收款码失败: " + e.getMessage());
            }
        }
        
        /**
         * 付款码收款
         */
        @PostMapping("/pay")
        public ApiResponse<String> pay(@RequestBody PayRequest request) {
            try {
                String orderId = "ORDER_" + System.currentTimeMillis();
                boolean success = paymentService.processPayment(
                    orderId, 
                    request.getAmount(), 
                    request.getGoodsDesc(), 
                    request.getPayCode()
                );
                
                if (success) {
                    return ApiResponse.success("支付成功");
                } else {
                    return ApiResponse.error("支付失败");
                }
                
            } catch (Exception e) {
                return ApiResponse.error("支付异常: " + e.getMessage());
            }
        }
        
        /**
         * 查询订单状态
         */
        @GetMapping("/status/{orderId}")
        public ApiResponse<String> queryStatus(@PathVariable String orderId) {
            try {
                String status = paymentService.queryOrderStatus(orderId);
                return ApiResponse.success(status);
                
            } catch (Exception e) {
                return ApiResponse.error("查询失败: " + e.getMessage());
            }
        }
    }
    
    /**
     * 自定义回调处理器
     */
    @Component
    public static class CustomNotifyProcessor implements NotifyProcessor {
        
        private static final Logger logger = LoggerFactory.getLogger(CustomNotifyProcessor.class);
        
        @Override
        public boolean processNotify(NotifyResponse notifyResponse) {
            logger.info("处理支付回调: orderId={}, status={}, amount={}", 
                notifyResponse.getOrderId(), 
                notifyResponse.getOrderStat(), 
                notifyResponse.getPayAmt());
            
            try {
                if (notifyResponse.isPaymentSuccess()) {
                    // 支付成功处理逻辑
                    handlePaymentSuccess(notifyResponse);
                } else {
                    // 支付失败处理逻辑
                    handlePaymentFail(notifyResponse);
                }
                
                return true;
                
            } catch (Exception e) {
                logger.error("处理支付回调异常: orderId={}", notifyResponse.getOrderId(), e);
                return false;
            }
        }
        
        @Override
        public boolean processRefundNotify(NotifyResponse notifyResponse) {
            logger.info("处理退款回调: orderId={}, refundId={}, amount={}", 
                notifyResponse.getOrderId(), 
                notifyResponse.getRefundId(), 
                notifyResponse.getRefundAmt());
            
            try {
                // 退款处理逻辑
                handleRefundSuccess(notifyResponse);
                return true;
                
            } catch (Exception e) {
                logger.error("处理退款回调异常: orderId={}, refundId={}", 
                    notifyResponse.getOrderId(), notifyResponse.getRefundId(), e);
                return false;
            }
        }
        
        private void handlePaymentSuccess(NotifyResponse notifyResponse) {
            // TODO: 实现支付成功处理逻辑
            // 1. 更新订单状态
            // 2. 发送支付成功通知
            // 3. 触发发货流程等
            logger.info("支付成功处理完成: orderId={}", notifyResponse.getOrderId());
        }
        
        private void handlePaymentFail(NotifyResponse notifyResponse) {
            // TODO: 实现支付失败处理逻辑
            // 1. 更新订单状态
            // 2. 发送支付失败通知
            logger.info("支付失败处理完成: orderId={}", notifyResponse.getOrderId());
        }
        
        private void handleRefundSuccess(NotifyResponse notifyResponse) {
            // TODO: 实现退款成功处理逻辑
            // 1. 更新退款状态
            // 2. 发送退款成功通知
            logger.info("退款成功处理完成: orderId={}, refundId={}", 
                notifyResponse.getOrderId(), notifyResponse.getRefundId());
        }
    }
    
    // 请求响应模型类
    public static class QrCodeRequest {
        private Long amount;
        private String goodsDesc;
        
        // getters and setters
        public Long getAmount() { return amount; }
        public void setAmount(Long amount) { this.amount = amount; }
        public String getGoodsDesc() { return goodsDesc; }
        public void setGoodsDesc(String goodsDesc) { this.goodsDesc = goodsDesc; }
    }
    
    public static class PayRequest {
        private Long amount;
        private String goodsDesc;
        private String payCode;
        
        // getters and setters
        public Long getAmount() { return amount; }
        public void setAmount(Long amount) { this.amount = amount; }
        public String getGoodsDesc() { return goodsDesc; }
        public void setGoodsDesc(String goodsDesc) { this.goodsDesc = goodsDesc; }
        public String getPayCode() { return payCode; }
        public void setPayCode(String payCode) { this.payCode = payCode; }
    }
    
    public static class ApiResponse<T> {
        private boolean success;
        private String message;
        private T data;
        
        public static <T> ApiResponse<T> success(T data) {
            ApiResponse<T> response = new ApiResponse<>();
            response.success = true;
            response.data = data;
            return response;
        }
        
        public static <T> ApiResponse<T> error(String message) {
            ApiResponse<T> response = new ApiResponse<>();
            response.success = false;
            response.message = message;
            return response;
        }
        
        // getters and setters
        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public T getData() { return data; }
        public void setData(T data) { this.data = data; }
    }
}