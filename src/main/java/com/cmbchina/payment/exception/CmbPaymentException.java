package com.cmbchina.payment.exception;

/**
 * 招商银行支付异常类
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class CmbPaymentException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 错误码
     */
    private String errorCode;
    
    /**
     * 错误消息
     */
    private String errorMessage;
    
    /**
     * 构造函数
     * 
     * @param message 异常消息
     */
    public CmbPaymentException(String message) {
        super(message);
        this.errorMessage = message;
    }
    
    /**
     * 构造函数
     * 
     * @param message 异常消息
     * @param cause 原因
     */
    public CmbPaymentException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
    }
    
    /**
     * 构造函数
     * 
     * @param errorCode 错误码
     * @param errorMessage 错误消息
     */
    public CmbPaymentException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
    /**
     * 构造函数
     * 
     * @param errorCode 错误码
     * @param errorMessage 错误消息
     * @param cause 原因
     */
    public CmbPaymentException(String errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    @Override
    public String toString() {
        return "CmbPaymentException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
