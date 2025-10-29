package com.cmbchina.payment.callback;

import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.crypto.SignatureUtil;
import com.cmbchina.payment.model.response.NotifyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 回调通知处理器 - Spring Boot Controller
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
@RestController
public class NotifyHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(NotifyHandler.class);
    
    private final CmbPaymentConfig config;
    private final NotifyProcessor notifyProcessor;
    
    public NotifyHandler(CmbPaymentConfig config, NotifyProcessor notifyProcessor) {
        this.config = config;
        this.notifyProcessor = notifyProcessor;
    }
    
    /**
     * 处理支付回调通知
     * 
     * @param requestBody 回调请求体
     * @return 响应结果
     */
    @PostMapping("/cmb/payment/notify")
    public ResponseEntity<String> handlePaymentNotify(@RequestBody String requestBody) {
        logger.info("收到支付回调通知: {}", requestBody);
        
        try {
            // 解析回调数据
            Map<String, String> params = SignatureUtil.parseQueryString(requestBody);
            String sign = params.remove("sign");
            
            if (sign == null || sign.trim().isEmpty()) {
                logger.error("回调通知签名为空");
                return buildFailResponse("签名为空");
            }
            
            // 对参数进行URL解码
            Map<String, String> decodedParams = new HashMap<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                decodedParams.put(
                    SignatureUtil.decode(entry.getKey()), 
                    SignatureUtil.decode(entry.getValue())
                );
            }
            
            // 验证签名
            String content = SignatureUtil.getSignContent(decodedParams);
            boolean verifyResult = SignatureUtil.sm2Verify(content, sign, config.getPublicKey());
            
            if (!verifyResult) {
                logger.error("回调通知验签失败");
                return buildFailResponse("验签失败");
            }
            
            logger.info("回调通知验签成功");
            
            // 处理业务逻辑
            NotifyResponse notifyResponse = convertToNotifyResponse(decodedParams);
            boolean processResult = notifyProcessor.processNotify(notifyResponse);
            
            if (processResult) {
                logger.info("回调通知处理成功: orderId={}", notifyResponse.getOrderId());
                return buildSuccessResponse();
            } else {
                logger.error("回调通知处理失败: orderId={}", notifyResponse.getOrderId());
                return buildFailResponse("业务处理失败");
            }
            
        } catch (Exception ex) {
            logger.error("处理回调通知异常", ex);
            return buildFailResponse("处理异常");
        }
    }
    
    /**
     * 处理退款回调通知
     * 
     * @param requestBody 回调请求体
     * @return 响应结果
     */
    @PostMapping("/cmb/payment/refund/notify")
    public ResponseEntity<String> handleRefundNotify(@RequestBody String requestBody) {
        logger.info("收到退款回调通知: {}", requestBody);
        
        try {
            // 解析回调数据
            Map<String, String> params = SignatureUtil.parseQueryString(requestBody);
            String sign = params.remove("sign");
            
            if (sign == null || sign.trim().isEmpty()) {
                logger.error("退款回调通知签名为空");
                return buildFailResponse("签名为空");
            }
            
            // 对参数进行URL解码
            Map<String, String> decodedParams = new HashMap<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                decodedParams.put(
                    SignatureUtil.decode(entry.getKey()), 
                    SignatureUtil.decode(entry.getValue())
                );
            }
            
            // 验证签名
            String content = SignatureUtil.getSignContent(decodedParams);
            boolean verifyResult = SignatureUtil.sm2Verify(content, sign, config.getPublicKey());
            
            if (!verifyResult) {
                logger.error("退款回调通知验签失败");
                return buildFailResponse("验签失败");
            }
            
            logger.info("退款回调通知验签成功");
            
            // 处理业务逻辑
            NotifyResponse notifyResponse = convertToNotifyResponse(decodedParams);
            boolean processResult = notifyProcessor.processRefundNotify(notifyResponse);
            
            if (processResult) {
                logger.info("退款回调通知处理成功: orderId={}, refundId={}", 
                    notifyResponse.getOrderId(), notifyResponse.getRefundId());
                return buildSuccessResponse();
            } else {
                logger.error("退款回调通知处理失败: orderId={}, refundId={}", 
                    notifyResponse.getOrderId(), notifyResponse.getRefundId());
                return buildFailResponse("业务处理失败");
            }
            
        } catch (Exception ex) {
            logger.error("处理退款回调通知异常", ex);
            return buildFailResponse("处理异常");
        }
    }
    
    /**
     * 构建成功响应
     */
    private ResponseEntity<String> buildSuccessResponse() {
        Map<String, String> response = new HashMap<>();
        response.put("version", config.getVersion());
        response.put("encoding", config.getEncoding());
        response.put("signMethod", config.getSignMethod());
        response.put("returnCode", "SUCCESS");
        response.put("respCode", "SUCCESS");
        
        // 对响应进行签名
        String content = SignatureUtil.getSignContent(response);
        String sign = SignatureUtil.sm2Sign(content, config.getPrivateKey());
        response.put("sign", sign);
        
        String responseBody = SignatureUtil.buildQueryString(response, false);
        return ResponseEntity.ok(responseBody);
    }
    
    /**
     * 构建失败响应
     */
    private ResponseEntity<String> buildFailResponse(String errorMsg) {
        Map<String, String> response = new HashMap<>();
        response.put("version", config.getVersion());
        response.put("encoding", config.getEncoding());
        response.put("signMethod", config.getSignMethod());
        response.put("returnCode", "FAIL");
        response.put("respCode", "FAIL");
        response.put("respMsg", errorMsg);
        
        String responseBody = SignatureUtil.buildQueryString(response, false);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
    
    /**
     * 将参数Map转换为NotifyResponse对象
     */
    private NotifyResponse convertToNotifyResponse(Map<String, String> params) {
        NotifyResponse response = new NotifyResponse();
        
        response.setVersion(params.get("version"));
        response.setEncoding(params.get("encoding"));
        response.setSignMethod(params.get("signMethod"));
        response.setMerId(params.get("mer_id"));
        response.setOrderId(params.get("order_id"));
        response.setTnOrderId(params.get("tn_order_id"));
        response.setOrderStat(params.get("order_stat"));
        response.setPayType(params.get("pay_type"));
        response.setPayTime(params.get("pay_time"));
        response.setThirdOrderId(params.get("third_order_id"));
        response.setThirdSerialNo(params.get("third_serial_no"));
        response.setBuyerUserId(params.get("buyer_user_id"));
        response.setBuyerLogonId(params.get("buyer_logon_id"));
        response.setAttach(params.get("attach"));
        response.setNotifyType(params.get("notify_type"));
        response.setNotifyTime(params.get("notify_time"));
        response.setRefundId(params.get("refund_id"));
        response.setRefundTime(params.get("refund_time"));
        
        // 处理金额字段
        String orderAmt = params.get("order_amt");
        if (orderAmt != null && !orderAmt.trim().isEmpty()) {
            response.setOrderAmt(Long.parseLong(orderAmt));
        }
        
        String payAmt = params.get("pay_amt");
        if (payAmt != null && !payAmt.trim().isEmpty()) {
            response.setPayAmt(Long.parseLong(payAmt));
        }
        
        String discountAmt = params.get("discount_amt");
        if (discountAmt != null && !discountAmt.trim().isEmpty()) {
            response.setDiscountAmt(Long.parseLong(discountAmt));
        }
        
        String refundAmt = params.get("refund_amt");
        if (refundAmt != null && !refundAmt.trim().isEmpty()) {
            response.setRefundAmt(Long.parseLong(refundAmt));
        }
        
        return response;
    }
}