package com.cmbchina.payment.model.response;

import com.cmbchina.payment.model.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * 退款申请响应
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class RefundResponse extends BaseResponse {
    
    /**
     * 商户号（returnCode为SUCCESS时返回）
     * 请求报文中的商户号
     */
    @JsonProperty("merId")
    private String merId;
    
    /**
     * 商户退款订单号（returnCode为SUCCESS时返回）
     * 请求报文中的商户退款订单号
     */
    @JsonProperty("orderId")
    private String orderId;
    
    /**
     * 第三方错误描述（returnCode为SUCCESS时返回，可选）
     * 退款交易在第三方处理失败时返回第三方的错误信息
     */
    @JsonProperty("errDescription")
    private String errDescription;
    
    /**
     * 平台退款订单号（returnCode和respCode为SUCCESS时返回）
     * 退款受理成功时返回，招行生成的退款订单号
     */
    @JsonProperty("cmbOrderId")
    private String cmbOrderId;
    
    /**
     * 退款金额（returnCode和respCode为SUCCESS时返回）
     * 单位为分
     */
    @JsonProperty("refundAmt")
    private String refundAmt;
    
    /**
     * 优惠金额（returnCode和respCode为SUCCESS时返回）
     * 单位为分
     */
    @JsonProperty("refundDscAmt")
    private String refundDscAmt;
    
    /**
     * 银联优惠信息（returnCode和respCode为SUCCESS时返回，可选）
     * 银联通道且有优惠活动时出现，字段说明详见2.6.3.银联优惠信息
     */
    @JsonProperty("couponInfo")
    private String couponInfo;
    
    /**
     * 银联付款方附加数据（returnCode和respCode为SUCCESS时返回，可选）
     * 银联通道且有商品优惠时出现，字段说明详见2.6.3.银联优惠信息
     */
    @JsonProperty("issAddnData")
    private String issAddnData;
    
    /**
     * 微信优惠退款详情（returnCode和respCode为SUCCESS时返回，可选）
     * 微信通道且有优惠时返回退款优惠详细信息，字段说明详见2.6.4.微信退款详情
     * 使用Map类型存储，序列化时会自动转换为JSON对象
     */
    @JsonProperty("refundDetail")
    private Map<String, Object> refundDetail;
    
    /**
     * 第三方订单号（returnCode和respCode为SUCCESS时返回，可选）
     * 支付宝、微信侧的订单号
     */
    @JsonProperty("thirdOrderId")
    private String thirdOrderId;
    
    /**
     * 退款处理状态（returnCode和respCode为SUCCESS时返回）
     * P - 退款正在处理（原交易为微信渠道）
     * S - 退款成功（原交易为支付宝、银联渠道）
     * F - 退款失败（原交易为微信、支付宝、银联渠道）
     * 仅当respCode为SUCCESS时出现
     */
    @JsonProperty("refundState")
    private String refundState;
    
    /**
     * 失败原因（returnCode和respCode为SUCCESS时返回，可选）
     * refundState退款状态为F时返回
     */
    @JsonProperty("failureReason")
    private String failureReason;
    
    /**
     * 订单发送时间（returnCode和respCode为SUCCESS时返回）
     * 退款订单生成时间，格式为yyyyMMddHHmmss
     */
    @JsonProperty("txnTime")
    private String txnTime;
    
    /**
     * 订单完成日期（returnCode和respCode为SUCCESS时返回，可选）
     * 第三方系统返回的交易完成日期，此日期仅在交易成功时返回，不保证是实际清算日期，格式为yyyyMMdd
     * 若原交易是支付宝和银联通道，则退款成功时返回此字段
     * 若原交易是微信通道，则不返回此字段
     */
    @JsonProperty("endDate")
    private String endDate;
    
    /**
     * 订单完成时间（returnCode和respCode为SUCCESS时返回，可选）
     * 第三方系统返回的交易完成时间，此时间仅在退款成功时返回，格式为HHmmss
     * 若原交易是支付宝通道，则退款成功时返回此字段
     * 若原交易是银联和微信通道，则不返回此字段
     */
    @JsonProperty("endTime")
    private String endTime;
    
    /**
     * 合约退款响应内容（returnCode和respCode为SUCCESS时返回，可选）
     * json格式字符串，字段内容详见2.7.2.4合约退款响应内容contractRefundResp
     */
    @JsonProperty("contractRefundResp")
    private String contractRefundResp;
    
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
    
    public String getErrDescription() {
        return errDescription;
    }
    
    public void setErrDescription(String errDescription) {
        this.errDescription = errDescription;
    }
    
    public String getCmbOrderId() {
        return cmbOrderId;
    }
    
    public void setCmbOrderId(String cmbOrderId) {
        this.cmbOrderId = cmbOrderId;
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
    
    public Map<String, Object> getRefundDetail() {
        return refundDetail;
    }
    
    public void setRefundDetail(Map<String, Object> refundDetail) {
        this.refundDetail = refundDetail;
    }
    
    public String getThirdOrderId() {
        return thirdOrderId;
    }
    
    public void setThirdOrderId(String thirdOrderId) {
        this.thirdOrderId = thirdOrderId;
    }
    
    public String getRefundState() {
        return refundState;
    }
    
    public void setRefundState(String refundState) {
        this.refundState = refundState;
    }
    
    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
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
    
    public String getContractRefundResp() {
        return contractRefundResp;
    }
    
    public void setContractRefundResp(String contractRefundResp) {
        this.contractRefundResp = contractRefundResp;
    }
}
