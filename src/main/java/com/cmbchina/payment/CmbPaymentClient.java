package com.cmbchina.payment;

import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.core.CmbPaymentService;
import com.cmbchina.payment.model.request.*;
import com.cmbchina.payment.model.response.*;
import com.cmbchina.payment.exception.CmbPaymentException;

/**
 * 招商银行支付客户端 - 主要入口类
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class CmbPaymentClient {
    
    private final CmbPaymentService paymentService;
    
    /**
     * 构造函数
     * 
     * @param config 支付配置
     */
    public CmbPaymentClient(CmbPaymentConfig config) {
        this.paymentService = new CmbPaymentService(config);
    }
    
    /**
     * 收款码申请 - 生成动态聚合银标码
     * 
     * @param request 收款码申请请求
     * @return 收款码申请响应
     * @throws CmbPaymentException 支付异常
     */
    public QrCodeApplyResponse qrCodeApply(QrCodeApplyRequest request) throws CmbPaymentException {
        return paymentService.qrCodeApply(request);
    }
    
    /**
     * 支付结果查询
     * 
     * @param request 订单查询请求
     * @return 订单查询响应
     * @throws CmbPaymentException 支付异常
     */
    public OrderQueryResponse orderQuery(OrderQueryRequest request) throws CmbPaymentException {
        return paymentService.orderQuery(request);
    }
    
    /**
     * 付款码收款 - 被扫支付
     * 
     * @param request 付款码收款请求
     * @return 付款码收款响应
     * @throws CmbPaymentException 支付异常
     */
    public PaymentResponse pay(PaymentRequest request) throws CmbPaymentException {
        return paymentService.pay(request);
    }
    
    /**
     * 微信统一下单
     * 
     * @param request 微信统一下单请求
     * @return 微信统一下单响应
     * @throws CmbPaymentException 支付异常
     */
    public WechatUnifiedOrderResponse wechatUnifiedOrder(WechatUnifiedOrderRequest request) throws CmbPaymentException {
        return paymentService.wechatUnifiedOrder(request);
    }
    
    /**
     * 支付宝服务窗支付
     * 
     * @param request 支付宝服务窗支付请求
     * @return 支付宝服务窗支付响应
     * @throws CmbPaymentException 支付异常
     */
    public AlipayServiceResponse alipayService(AlipayServiceRequest request) throws CmbPaymentException {
        return paymentService.alipayService(request);
    }
    
    /**
     * 退款申请
     * 
     * @param request 退款申请请求
     * @return 退款申请响应
     * @throws CmbPaymentException 支付异常
     */
    public RefundResponse refund(RefundRequest request) throws CmbPaymentException {
        return paymentService.refund(request);
    }
    
    /**
     * 退款结果查询
     * 
     * @param request 退款查询请求
     * @return 退款查询响应
     * @throws CmbPaymentException 支付异常
     */
    public RefundQueryResponse refundQuery(RefundQueryRequest request) throws CmbPaymentException {
        return paymentService.refundQuery(request);
    }
    
    /**
     * 关闭订单
     * 
     * @param request 关闭订单请求
     * @return 关闭订单响应
     * @throws CmbPaymentException 支付异常
     */
    public CloseOrderResponse closeOrder(CloseOrderRequest request) throws CmbPaymentException {
        return paymentService.closeOrder(request);
    }
    
    /**
     * 付款码收款撤销
     * 
     * @param request 撤销请求
     * @return 撤销响应
     * @throws CmbPaymentException 支付异常
     */
    public CancelResponse cancel(CancelRequest request) throws CmbPaymentException {
        return paymentService.cancel(request);
    }
    
    /**
     * 对账单下载地址获取
     * 
     * @param request 对账单请求
     * @return 对账单响应
     * @throws CmbPaymentException 支付异常
     */
    public StatementResponse getStatementUrl(StatementRequest request) throws CmbPaymentException {
        return paymentService.getStatementUrl(request);
    }
    
    /**
     * 验证回调通知签名
     * 
     * @param notifyData 回调通知数据
     * @return 验证结果
     */
    public boolean verifyNotify(String notifyData) {
        return paymentService.verifyNotify(notifyData);
    }
    
    /**
     * 处理回调通知
     * 
     * @param notifyData 回调通知数据
     * @return 处理后的通知对象
     * @throws CmbPaymentException 支付异常
     */
    public NotifyResponse handleNotify(String notifyData) throws CmbPaymentException {
        return paymentService.handleNotify(notifyData);
    }
}