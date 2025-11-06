package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * 退款回调响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class RefundCallbackResponse extends BaseResponse {
    
    /**
     * 商户号（必填）
     * 商户在招行完成商户进件后分配的招行商户号
     */
    @JsonProperty("merId")
    private String merId;
    
    /**
     * 商户退款订单号（必填）
     * 退款申请时上送的商户订单号
     */
    @JsonProperty("orderId")
    private String orderId;
    
    /**
     * 平台退款订单号（必填）
     * 招行生成的退款订单号
     */
    @JsonProperty("cmbOrderId")
    private String cmbOrderId;
    
    /**
     * 收银员（可选）
     * 退款交易的收银员信息，若退款交易有上送则返回
     */
    @JsonProperty("userId")
    private String userId;
    
    /**
     * 退款金额（必填）
     * 单位为分
     */
    @JsonProperty("refundAmt")
    private String refundAmt;
    
    /**
     * 优惠金额（必填）
     * 单位为分
     */
    @JsonProperty("refundDscAmt")
    private String refundDscAmt;
    
    /**
     * 银联优惠信息（可选）
     * 银联通道且有优惠活动时出现，字段说明详见2.6.3.银联优惠信息
     */
    @JsonProperty("couponInfo")
    private String couponInfo;
    
    /**
     * 银联付款方附加数据（可选）
     * 银联通道且有商品优惠时出现，字段说明详见2.6.3.银联优惠信息
     */
    @JsonProperty("issAddnData")
    private String issAddnData;
    
    /**
     * 退单原始金额（可选）
     * 退单原始金额，单位为分，请求上送refundOrigAmt则返回该内容
     */
    @JsonProperty("refundOrigAmt")
    private String refundOrigAmt;
    
    /**
     * 退单优惠金额（可选）
     * 退单原始金额，单位为分，请求上送refundCouponAmt则返回该内容
     */
    @JsonProperty("refundCouponAmt")
    private String refundCouponAmt;
    
    /**
     * 第三方订单号（可选）
     * 支付宝、微信侧的订单号
     */
    @JsonProperty("thirdOrderId")
    private String thirdOrderId;
    
    /**
     * 交易币种（必填）
     * 目前只支持人民币（156）
     */
    @JsonProperty("currencyCode")
    private String currencyCode;
    
    /**
     * 支付方式（必填）
     * 目前支持：支付宝/微信/银联/数字人民币
     * ZF：支付宝
     * WX：微信
     * YL：银联
     * EC：数字人民币
     */
    @JsonProperty("payType")
    private String payType;
    
    /**
     * 订单发送时间（必填）
     * 退款订单生成的时间，格式为yyyyMMddHHmmss
     */
    @JsonProperty("txnTime")
    private String txnTime;
    
    /**
     * 订单完成日期（可选）
     * 第三方系统返回的交易完成日期，此日期仅在交易成功是返回，不保证是实际清算日期，格式为yyyyMMdd
     */
    @JsonProperty("endDate")
    private String endDate;
    
    /**
     * 订单完成时间（可选）
     * 第三方系统返回的交易完成时间，此时间仅在交易成功是返回，格式为HHmmss
     * 支付宝和微信通道的成功交易返回此字段
     * 银联通道的交易无论成功与否，均不返回此字段
     */
    @JsonProperty("endTime")
    private String endTime;
    
    /**
     * 商户保留域（可选）
     * 若退款交易有上送此字段，则返回此字段
     */
    @JsonProperty("mchReserved")
    private String mchReserved;
    
    /**
     * 微信优惠退款详情（可选）
     * 微信通道且有优惠时返回退款优惠详细信息，字段说明详见2.6.4.微信退款详情
     * 使用Map类型存储，序列化时会自动转换为JSON对象
     */
    @JsonProperty("refundDetail")
    private Map<String, Object> refundDetail;
    
    /**
     * 合约退款响应内容（可选）
     * Json格式字符串，字段说明详见2.7.2.4合约退款响应内容contractRefundResp
     */
    @JsonProperty("contractRefundResp")
    private String contractRefundResp;
    
    /**
     * 数字人民币优惠详情（可选）
     * 数字人民币优惠详情信息，字段说明详见2.6.6数字人民币优惠详情
     */
    @JsonProperty("ecnyPromotionDetail")
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
    
    public String getRefundAmt() {
        return refundAmt;
    }
    
    public void setRefundAmt(String refundAmt) {
        this.refundAmt = refundAmt;
    }
    
    public String getRefundDscAmt() {
        return refundDscAmt;
    }
    
    public void setRefundDscAmt(String refundDscAmt) {
        this.refundDscAmt = refundDscAmt;
    }
    
    public String getCouponInfo() {
        return couponInfo;
    }
    
    public void setCouponInfo(String couponInfo) {
        this.couponInfo = couponInfo;
    }
    
    public String getIssAddnData() {
        return issAddnData;
    }
    
    public void setIssAddnData(String issAddnData) {
        this.issAddnData = issAddnData;
    }
    
    public String getRefundOrigAmt() {
        return refundOrigAmt;
    }
    
    public void setRefundOrigAmt(String refundOrigAmt) {
        this.refundOrigAmt = refundOrigAmt;
    }
    
    public String getRefundCouponAmt() {
        return refundCouponAmt;
    }
    
    public void setRefundCouponAmt(String refundCouponAmt) {
        this.refundCouponAmt = refundCouponAmt;
    }
    
    public String getThirdOrderId() {
        return thirdOrderId;
    }
    
    public void setThirdOrderId(String thirdOrderId) {
        this.thirdOrderId = thirdOrderId;
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
    
    public Map<String, Object> getRefundDetail() {
        return refundDetail;
    }
    
    public void setRefundDetail(Map<String, Object> refundDetail) {
        this.refundDetail = refundDetail;
    }
    
    public String getContractRefundResp() {
        return contractRefundResp;
    }
    
    public void setContractRefundResp(String contractRefundResp) {
        this.contractRefundResp = contractRefundResp;
    }
    
    public String getEcnyPromotionDetail() {
        return ecnyPromotionDetail;
    }
    
    public void setEcnyPromotionDetail(String ecnyPromotionDetail) {
        this.ecnyPromotionDetail = ecnyPromotionDetail;
    }
}

