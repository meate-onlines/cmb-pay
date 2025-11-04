package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;

/**
 * 订单查询响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class OrderQueryResponse extends BaseResponse {
    
    /**
     * 商户号（returnCode为SUCCESS时返回）
     */
    private String merId;
    
    /**
     * 商户订单号（returnCode为SUCCESS时返回，可选）
     */
    private String orderId;
    
    /**
     * 外部商户订单号（returnCode为SUCCESS时返回，可选）
     */
    private String outOrderId;
    
    /**
     * 平台订单号（returnCode为SUCCESS时返回）
     */
    private String cmbOrderId;
    
    /**
     * 第三方错误描述（returnCode为SUCCESS时返回，可选）
     * 查询交易在第三方处理失败时返回第三方的错误信息
     */
    private String errDescription;
    
    /**
     * 交易金额（returnCode和respCode为SUCCESS时返回，单位：分）
     */
    private String txnAmt;
    
    /**
     * 优惠金额（returnCode和respCode为SUCCESS时返回，单位：分）
     */
    private String dscAmt;
    
    /**
     * 银联优惠信息（returnCode和respCode为SUCCESS时返回，可选）
     */
    private String couponInfo;
    
    /**
     * 优惠券信息（returnCode和respCode为SUCCESS时返回，可选）
     * 微信、支付宝优惠券信息
     */
    private String promotionDetail;
    
    /**
     * 银联付款方附加数据（returnCode和respCode为SUCCESS时返回，可选）
     */
    private String issAddnData;
    
    /**
     * 订单原始金额（returnCode和respCode为SUCCESS时返回，可选，单位：分）
     */
    private String orderOrigAmt;
    
    /**
     * 订单优惠金额（returnCode和respCode为SUCCESS时返回，可选，单位：分）
     */
    private String orderCouponAmt;
    
    /**
     * 支付宝商品优惠信息（returnCode和respCode为SUCCESS时返回，可选）
     */
    private String discountGoodsDetail;
    
    /**
     * 交易币种（returnCode和respCode为SUCCESS时返回）
     * 默认156，目前只支持人民币（156）
     */
    private String currencyCode;
    
    /**
     * 支付方式（returnCode和respCode为SUCCESS时返回）
     * ZF：支付宝，WX：微信，YL：银联，EC：数字人民币
     */
    private String payType;
    
    /**
     * 用户标识（returnCode和respCode为SUCCESS时返回，可选）
     * 支付宝支付：用户在支付宝系统的唯一标识
     * 微信支付：商户上送sub_appid时返回用户在sub_appid下的sub_openid
     */
    private String openId;
    
    /**
     * 用户标识（returnCode和respCode为SUCCESS时返回，可选）
     * 对应openId
     */
    private String oriOpenId;
    
    /**
     * 付款银行（returnCode和respCode为SUCCESS时返回，可选）
     */
    private String payBank;
    
    /**
     * 第三方订单号（returnCode和respCode为SUCCESS时返回，可选）
     * 支付宝、微信侧的订单号
     */
    private String thirdOrderId;
    
    /**
     * 支付宝账户（returnCode和respCode为SUCCESS时返回，可选）
     * 支付宝支付的交易返回，如：koh***@sandbox.com
     */
    private String buyerLogonId;
    
    /**
     * 交易状态（returnCode和respCode为SUCCESS时返回）
     * C - 订单已关闭，D - 交易已撤销，P - 交易在进行
     * F - 交易失败，S - 交易成功，R - 转入退款
     */
    private String tradeState;
    
    /**
     * 订单发送时间（returnCode和respCode为SUCCESS时返回）
     * 订单生成时间，格式为yyyyMMddHHmmss
     */
    private String txnTime;
    
    /**
     * 订单完成日期（returnCode和respCode为SUCCESS时返回，可选）
     * 第三方系统返回的交易完成日期，格式为yyyyMMdd
     */
    private String endDate;
    
    /**
     * 订单完成时间（returnCode和respCode为SUCCESS时返回，可选）
     * 第三方系统返回的交易完成时间，格式为HHmmss
     */
    private String endTime;
    
    /**
     * 商户保留域（returnCode和respCode为SUCCESS时返回，可选）
     * 若被查询交易有上送此字段，则返回此字段
     */
    private String mchReserved;
    
    /**
     * 合约响应内容（returnCode和respCode为SUCCESS时返回，可选）
     */
    private String contractResp;
    
    /**
     * 付款运营机构编码（returnCode和respCode为SUCCESS时返回，可选）
     */
    private String debtorAgentId;
    
    /**
     * 付款运营机构名称（returnCode和respCode为SUCCESS时返回，可选）
     */
    private String debtorAgentName;
    
    /**
     * 数字人民币优惠详情（returnCode和respCode为SUCCESS时返回，可选）
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
    
    public String getOutOrderId() {
        return outOrderId;
    }
    
    public void setOutOrderId(String outOrderId) {
        this.outOrderId = outOrderId;
    }
    
    public String getCmbOrderId() {
        return cmbOrderId;
    }
    
    public void setCmbOrderId(String cmbOrderId) {
        this.cmbOrderId = cmbOrderId;
    }
    
    public String getErrDescription() {
        return errDescription;
    }
    
    public void setErrDescription(String errDescription) {
        this.errDescription = errDescription;
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
    
    public String getPromotionDetail() {
        return promotionDetail;
    }
    
    public void setPromotionDetail(String promotionDetail) {
        this.promotionDetail = promotionDetail;
    }
    
    public String getIssAddnData() {
        return issAddnData;
    }
    
    public void setIssAddnData(String issAddnData) {
        this.issAddnData = issAddnData;
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
    
    public String getDiscountGoodsDetail() {
        return discountGoodsDetail;
    }
    
    public void setDiscountGoodsDetail(String discountGoodsDetail) {
        this.discountGoodsDetail = discountGoodsDetail;
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
    
    public String getTradeState() {
        return tradeState;
    }
    
    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
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
