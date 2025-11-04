package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;

/**
 * 异步通知响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class NotifyResponse extends BaseResponse {
    
    /**
     * 商户号
     */
    private String merId;
    
    /**
     * 商户订单号
     */
    private String orderId;
    
    /**
     * 平台订单号
     */
    private String cmbOrderId;
    
    /**
     * 收银员（可选）
     * 支付交易的收银员信息，若有，则返回
     */
    private String userId;
    
    /**
     * 交易金额（单位：分）
     */
    private String txnAmt;
    
    /**
     * 优惠金额（单位：分）
     */
    private String dscAmt;
    
    /**
     * 银联优惠信息（可选）
     * 银联通道且有优惠活动时出现
     */
    private String couponInfo;
    
    /**
     * 订单原始金额（可选，单位：分）
     * 请求上送orderOrigAmt则对应返回该内容
     */
    private String orderOrigAmt;
    
    /**
     * 订单优惠金额（可选，单位：分）
     * 请求上送orderCouponAmt则对应返回该内容
     */
    private String orderCouponAmt;
    
    /**
     * 优惠券信息（可选）
     * 微信、支付宝优惠券信息
     */
    private String promotionDetail;
    
    /**
     * 交易币种
     * 目前只支持人民币（156）
     */
    private String currencyCode;
    
    /**
     * 支付方式
     * ZF：支付宝，WX：微信，YL：银联，EC：数字人民币
     */
    private String payType;
    
    /**
     * 用户标识（可选）
     * 支付宝支付：用户在支付宝系统的唯一标识
     * 微信支付：商户上送sub_appid时返回用户在sub_appid下的sub_openid
     */
    private String openId;
    
    /**
     * 用户标识（可选）
     * 对应openId
     */
    private String oriOpenId;
    
    /**
     * 付款银行（可选）
     */
    private String payBank;
    
    /**
     * 第三方订单号（可选）
     * 支付宝、微信侧的订单号
     */
    private String thirdOrderId;
    
    /**
     * 支付宝账户（可选）
     * 支付宝支付的交易返回，如：koh***@sandbox.com
     */
    private String buyerLogonId;
    
    /**
     * 订单发送时间
     * 支付订单生成的时间，格式为yyyyMMddHHmmss
     */
    private String txnTime;
    
    /**
     * 订单完成日期（可选）
     * 第三方系统返回的交易完成日期，格式为yyyyMMdd
     */
    private String endDate;
    
    /**
     * 订单完成时间（可选）
     * 第三方系统返回的交易完成时间，格式为HHmmss
     */
    private String endTime;
    
    /**
     * 商户保留域（可选）
     * 若原交易有上送此字段，则返回此字段
     */
    private String mchReserved;
    
    /**
     * 合约响应内容（可选）
     */
    private String contractResp;
    
    /**
     * 付款运营机构编码（可选）
     */
    private String debtorAgentId;
    
    /**
     * 付款运营机构名称（可选）
     */
    private String debtorAgentName;
    
    /**
     * 数字人民币优惠详情（可选）
     */
    private String ecnyPromotionDetail;
    
    public String getMerId() {
        return merId;
    }
    
    public void setMerId(String merId) {
        this.merId = merId;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getCmbOrderId() {
        return cmbOrderId;
    }
    
    public void setCmbOrderId(String cmbOrderId) {
        this.cmbOrderId = cmbOrderId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getTxnAmt() {
        return txnAmt;
    }
    
    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt;
    }
    
    public String getDscAmt() {
        return dscAmt;
    }
    
    public void setDscAmt(String dscAmt) {
        this.dscAmt = dscAmt;
    }
    
    public String getCouponInfo() {
        return couponInfo;
    }
    
    public void setCouponInfo(String couponInfo) {
        this.couponInfo = couponInfo;
    }
    
    public String getOrderOrigAmt() {
        return orderOrigAmt;
    }
    
    public void setOrderOrigAmt(String orderOrigAmt) {
        this.orderOrigAmt = orderOrigAmt;
    }
    
    public String getOrderCouponAmt() {
        return orderCouponAmt;
    }
    
    public void setOrderCouponAmt(String orderCouponAmt) {
        this.orderCouponAmt = orderCouponAmt;
    }
    
    public String getPromotionDetail() {
        return promotionDetail;
    }
    
    public void setPromotionDetail(String promotionDetail) {
        this.promotionDetail = promotionDetail;
    }
    
    public String getCurrencyCode() {
        return currencyCode;
    }
    
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    public String getPayType() {
        return payType;
    }
    
    public void setPayType(String payType) {
        this.payType = payType;
    }
    
    public String getOpenId() {
        return openId;
    }
    
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    
    public String getOriOpenId() {
        return oriOpenId;
    }
    
    public void setOriOpenId(String oriOpenId) {
        this.oriOpenId = oriOpenId;
    }
    
    public String getPayBank() {
        return payBank;
    }
    
    public void setPayBank(String payBank) {
        this.payBank = payBank;
    }
    
    public String getThirdOrderId() {
        return thirdOrderId;
    }
    
    public void setThirdOrderId(String thirdOrderId) {
        this.thirdOrderId = thirdOrderId;
    }
    
    public String getBuyerLogonId() {
        return buyerLogonId;
    }
    
    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }
    
    public String getTxnTime() {
        return txnTime;
    }
    
    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }
    
    public String getEndDate() {
        return endDate;
    }
    
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    public String getEndTime() {
        return endTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public String getMchReserved() {
        return mchReserved;
    }
    
    public void setMchReserved(String mchReserved) {
        this.mchReserved = mchReserved;
    }
    
    public String getContractResp() {
        return contractResp;
    }
    
    public void setContractResp(String contractResp) {
        this.contractResp = contractResp;
    }
    
    public String getDebtorAgentId() {
        return debtorAgentId;
    }
    
    public void setDebtorAgentId(String debtorAgentId) {
        this.debtorAgentId = debtorAgentId;
    }
    
    public String getDebtorAgentName() {
        return debtorAgentName;
    }
    
    public void setDebtorAgentName(String debtorAgentName) {
        this.debtorAgentName = debtorAgentName;
    }
    
    public String getEcnyPromotionDetail() {
        return ecnyPromotionDetail;
    }
    
    public void setEcnyPromotionDetail(String ecnyPromotionDetail) {
        this.ecnyPromotionDetail = ecnyPromotionDetail;
    }
}
