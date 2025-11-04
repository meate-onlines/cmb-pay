package com.cmbchina.payment.example.spring;

import com.cmbchina.payment.CmbPaymentClient;
import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.exception.CmbPaymentException;
import com.cmbchina.payment.model.request.*;
import com.cmbchina.payment.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring Boot集成示例
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
@Configuration
class CmbPaymentConfig {
    
    @Value("${cmb.merchant.id}")
    private String merchantId;
    
    @Value("${cmb.app.id}")
    private String appId;
    
    @Value("${cmb.app.secret}")
    private String appSecret;
    
    @Value("${cmb.private.key}")
    private String privateKey;
    
    @Value("${cmb.public.key}")
    private String publicKey;
    
    @Value("${cmb.api.url:https://api.cmburl.cn:8065}")
    private String apiUrl;
    
    @Value("${cmb.notify.url}")
    private String notifyUrl;
    
    @Value("${cmb.return.url}")
    private String returnUrl;
    
    @Value("${cmb.sandbox:true}")
    private boolean sandbox;
    
    @Bean
    public CmbPaymentClient cmbPaymentClient() {
        com.cmbchina.payment.config.CmbPaymentConfig config = 
            new com.cmbchina.payment.config.CmbPaymentConfig.Builder()
                .merchantId(merchantId)
                .appId(appId)
                .appSecret(appSecret)
                .privateKey(privateKey)
                .publicKey(publicKey)
                .apiUrl(apiUrl)
                .notifyUrl(notifyUrl)
                .returnUrl(returnUrl)
                .sandbox(sandbox)
                .build();
                
        return new CmbPaymentClient(config);
    }
}

@RestController
@RequestMapping("/payment")
class PaymentController {
    
    @Autowired
    private CmbPaymentClient paymentClient;
    
    /**
     * 收款码申请
     */
    @PostMapping("/qrcode/apply")
    public Map<String, Object> qrCodeApply(@RequestBody QrCodeApplyRequest request) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            QrCodeApplyResponse response = paymentClient.qrCodeApply(request);
            
            if (response.isSuccess()) {
                result.put("success", true);
                result.put("data", response);
            } else {
                result.put("success", false);
                result.put("message", response.getResultMsg());
            }
        } catch (CmbPaymentException e) {
            result.put("success", false);
            result.put("message", e.getMessage());
            result.put("errorCode", e.getErrorCode());
        }
        
        return result;
    }
    
    /**
     * 订单查询
     */
    @GetMapping("/order/query")
    public Map<String, Object> orderQuery(@RequestParam String orderId) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            OrderQueryRequest request = new OrderQueryRequest();
            request.setMerId("your_merchant_id"); // 从配置或上下文获取
            request.setOrderId(orderId);
            
            OrderQueryResponse response = paymentClient.orderQuery(request);
            
            if (response.isSuccess()) {
                result.put("success", true);
                result.put("data", response);
            } else {
                result.put("success", false);
                result.put("message", response.getResultMsg());
            }
        } catch (CmbPaymentException e) {
            result.put("success", false);
            result.put("message", e.getMessage());
            result.put("errorCode", e.getErrorCode());
        }
        
        return result;
    }
    
    /**
     * 退款申请
     */
    @PostMapping("/refund")
    public Map<String, Object> refund(@RequestBody RefundRequest request) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            RefundResponse response = paymentClient.refund(request);
            
            if (response.isSuccess()) {
                result.put("success", true);
                result.put("data", response);
            } else {
                result.put("success", false);
                result.put("message", response.getResultMsg());
            }
        } catch (CmbPaymentException e) {
            result.put("success", false);
            result.put("message", e.getMessage());
            result.put("errorCode", e.getErrorCode());
        }
        
        return result;
    }
    
    /**
     * 微信统一下单
     */
    @PostMapping("/wechat/unified")
    public Map<String, Object> wechatUnifiedOrder(@RequestBody WechatUnifiedOrderRequest request) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            WechatUnifiedOrderResponse response = paymentClient.wechatUnifiedOrder(request);
            
            if (response.isSuccess()) {
                result.put("success", true);
                result.put("data", response);
            } else {
                result.put("success", false);
                result.put("message", response.getResultMsg());
            }
        } catch (CmbPaymentException e) {
            result.put("success", false);
            result.put("message", e.getMessage());
            result.put("errorCode", e.getErrorCode());
        }
        
        return result;
    }
    
    /**
     * 处理异步通知
     */
    @PostMapping("/notify")
    public Map<String, String> handleNotify(@RequestBody String notifyData) {
        Map<String, String> result = new HashMap<>();
        
        try {
            // 验证通知签名
            boolean isValid = paymentClient.verifyNotify(notifyData);
            
            if (isValid) {
                // 处理通知数据
                NotifyResponse notifyResponse = paymentClient.handleNotify(notifyData);
                
                // 处理业务逻辑
                if ("SUCCESS".equals(notifyResponse.getReturnCode()) && 
                    "SUCCESS".equals(notifyResponse.getResultCode())) {
                    // 支付成功，更新订单状态
                    updateOrderStatus(notifyResponse.getOrderId(), "PAID");
                }
                
                result.put("returnCode", "SUCCESS");
                result.put("respCode", "SUCCESS");
            } else {
                result.put("returnCode", "FAIL");
                result.put("respCode", "FAIL");
                result.put("respMsg", "签名验证失败");
            }
        } catch (Exception e) {
            result.put("returnCode", "FAIL");
            result.put("respCode", "FAIL");
            result.put("respMsg", "处理异常: " + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 更新订单状态（示例方法）
     */
    private void updateOrderStatus(String orderId, String status) {
        // 实现订单状态更新逻辑
        System.out.println("更新订单状态: " + orderId + " -> " + status);
    }
}
