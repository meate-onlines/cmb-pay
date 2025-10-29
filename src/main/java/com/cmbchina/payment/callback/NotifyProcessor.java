package com.cmbchina.payment.callback;

import com.cmbchina.payment.model.response.NotifyResponse;

/**
 * 回调通知处理器接口
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public interface NotifyProcessor {
    
    /**
     * 处理支付回调通知
     * 
     * @param notifyResponse 回调通知数据
     * @return 处理结果，true表示成功，false表示失败
     */
    boolean processNotify(NotifyResponse notifyResponse);
    
    /**
     * 处理退款回调通知
     * 
     * @param notifyResponse 回调通知数据
     * @return 处理结果，true表示成功，false表示失败
     */
    boolean processRefundNotify(NotifyResponse notifyResponse);
}