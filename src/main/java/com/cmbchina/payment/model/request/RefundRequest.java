package com.cmbchina.payment.model.request;

import com.cmbchina.payment.model.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.util.HashMap;
import java.util.Map;

/**
 * 退款申请请求
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class RefundRequest extends BaseRequest {
    
    /**
     * 商户号（必填）
     */
    @NotBlank(message = "商户号不能为空")
    @JsonIgnore
    private String merId;
    
    /**
     * 附加经营商户号（可选）
     * 招行附加经营商户号。平台商户和附加经营商户联合支付退款场景使用
     */
    @JsonIgnore
    private String subMerId;

    /**
     * 经营商户门店号（可选）
     * 招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付退款场景，附加经营商户号和经营商户门店号需同时上送
     */
    @JsonIgnore
    private String subStoreId;
    
    /**
     * 商户退款订单号（必填）
     * 商户端生成退款订单号，要求此订单号整个商户下唯一
     */
    @NotBlank(message = "商户退款订单号不能为空")
    @JsonIgnore
    private String orderId;
    
    /**
     * 收银员（必填）
     * 招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。
     */
    @NotBlank(message = "收银员不能为空")
    @JsonIgnore
    private String userId;
    
    /**
     * 原交易商户订单号（可选）
     * 原交易的商户订单号，此字段和原交易平台订单号字段至少要上送一个，若两个都上送，则以原交易平台订单号为准
     */
    @JsonIgnore
    private String origOrderId;
    
    /**
     * 原外部商户订单号（可选）
     * 支付宝先享后付订单的交易必须上送。支付宝先享后付-订单创建请求参数中的outOrderId
     */
    @JsonIgnore
    private String origOutOrderId;
    
    /**
     * 原交易平台订单号（可选）
     * 原交易招行订单号，此字段和原交易商户订单号字段至少要上送一个，若两个都上送，则以此字段为准
     */
    @JsonIgnore
    private String origCmbOrderId;
    
    /**
     * 交易通知地址（可选）
     * 若为空则通知到原交易的通知地址
     */
    @JsonIgnore
    private String notifyUrl;
    
    /**
     * 交易金额（必填）
     * 原交易金额，单位为分
     */
    @NotBlank(message = "交易金额不能为空")
    @JsonIgnore
    private String txnAmt;
    
    /**
     * 退款金额（必填）
     * 退款金额，单位为分，refundAmt=refundOrigAmt-refundCouponAmt
     */
    @NotBlank(message = "退款金额不能为空")
    @JsonIgnore
    private String refundAmt;
    
    /**
     * 退单原始金额（可选）
     * 退单原始金额，单位为分，与refundCouponAmt同时出现
     */
    @JsonIgnore
    private String refundOrigAmt;
    
    /**
     * 退单优惠金额（可选）
     * 退单优惠金额，单位为分，与refundOrigAmt同时出现
     */
    @JsonIgnore
    private String refundCouponAmt;
    
    /**
     * 交易币种（可选）
     * 默认156，目前只支持人民币（156）
     */
    @JsonIgnore
    private String currencyCode;
    
    /**
     * 退款原因（可选）
     */
    @JsonIgnore
    private String refundReason;
    
    /**
     * 商户保留域（可选）
     * 用于传输商户自定义数据，在退款结果查询和退款结果通知时原样返回
     */
    @JsonIgnore
    private String mchReserved;
    
    /**
     * 银联收款方附加数据（可选）
     * 银联通道且有商品优惠时出现，字段说明详见2.6.3.银联优惠信息
     */
    @JsonIgnore
    private String acqAddnData;
    
    /**
     * 支付宝商品列表（可选）
     * 支付宝通道且有商品优惠时出现，字段说明详见2.6.5 支付宝商品列表
     * 使用Map类型存储，序列化时会自动转换为JSON对象
     */
    @JsonIgnore
    private Map<String, Object> goodsDetail;
    
    /**
     * 查询选项（可选）
     * 商户通过上送该参数来定制同步需要额外返回的信息字段（支付宝），数组形式的字符串
     * 示例："[\"refund_detail_item_list\"]"
     */
    @JsonIgnore
    private String queryOptions;
    
    /**
     * 合约退款请求内容（可选）
     * json格式字符串，字段说明详见2.7.2.3合约退款请求内容contractRefundReq
     */
    @JsonIgnore
    private String contractRefundReq;
    
    /**
     * 交易地址信息（可选）
     * 交易地址信息，字段说明详见交易地址信息tradeAddressInfo。需加密详见敏感信息加密
     */
    @JsonIgnore
    private String encryptTradeAddressInfo;
    
    /**
     * 获取业务参数Map（用于构建bizContent）
     */
    @JsonIgnore
    public Map<String, Object> getBizContentMap() {
        Map<String, Object> bizContent = new HashMap<>();
        // 必填字段
        if (merId != null) bizContent.put("merId", merId);
        if (orderId != null) bizContent.put("orderId", orderId);
        if (userId != null) bizContent.put("userId", userId);
        if (txnAmt != null) bizContent.put("txnAmt", txnAmt);
        if (refundAmt != null) bizContent.put("refundAmt", refundAmt);
        
        // 可选字段
        if (subMerId != null) bizContent.put("subMerId", subMerId);
        if (subStoreId != null) bizContent.put("subStoreId", subStoreId);
        if (origOrderId != null) bizContent.put("origOrderId", origOrderId);
        if (origOutOrderId != null) bizContent.put("origOutOrderId", origOutOrderId);
        if (origCmbOrderId != null) bizContent.put("origCmbOrderId", origCmbOrderId);
        if (notifyUrl != null) bizContent.put("notifyUrl", notifyUrl);
        if (refundOrigAmt != null) bizContent.put("refundOrigAmt", refundOrigAmt);
        if (refundCouponAmt != null) bizContent.put("refundCouponAmt", refundCouponAmt);
        if (currencyCode != null) bizContent.put("currencyCode", currencyCode);
        if (refundReason != null) bizContent.put("refundReason", refundReason);
        if (mchReserved != null) bizContent.put("mchReserved", mchReserved);
        if (acqAddnData != null) bizContent.put("acqAddnData", acqAddnData);
        if (goodsDetail != null) bizContent.put("goodsDetail", goodsDetail);
        if (queryOptions != null) bizContent.put("queryOptions", queryOptions);
        if (contractRefundReq != null) bizContent.put("contractRefundReq", contractRefundReq);
        if (encryptTradeAddressInfo != null) bizContent.put("encryptTradeAddressInfo", encryptTradeAddressInfo);
        
        return bizContent;
    }
    
    public String getMerId() {
        return merId;
    }
    
    public void setMerId(String merId) {
        this.merId = merId;
    }
    
    public String getSubMerId() {
        return subMerId;
    }

    public void setSubMerId(String subMerId) {
        this.subMerId = subMerId;
    }

    public String getSubStoreId() {
        return subStoreId;
    }

    public void setSubStoreId(String subStoreId) {
        this.subStoreId = subStoreId;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getOrigOrderId() {
        return origOrderId;
    }
    
    public void setOrigOrderId(String origOrderId) {
        this.origOrderId = origOrderId;
    }
    
    public String getOrigOutOrderId() {
        return origOutOrderId;
    }

    public void setOrigOutOrderId(String origOutOrderId) {
        this.origOutOrderId = origOutOrderId;
    }
    
    public String getOrigCmbOrderId() {
        return origCmbOrderId;
    }
    
    public void setOrigCmbOrderId(String origCmbOrderId) {
        this.origCmbOrderId = origCmbOrderId;
    }
    
    public String getNotifyUrl() {
        return notifyUrl;
    }
    
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    
    public String getTxnAmt() {
        return txnAmt;
    }
    
    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt;
    }
    
    public String getRefundAmt() {
        return refundAmt;
    }
    
    public void setRefundAmt(String refundAmt) {
        this.refundAmt = refundAmt;
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
    
    public String getCurrencyCode() {
        return currencyCode;
    }
    
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    public String getRefundReason() {
        return refundReason;
    }
    
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }
    
    public String getMchReserved() {
        return mchReserved;
    }
    
    public void setMchReserved(String mchReserved) {
        this.mchReserved = mchReserved;
    }

    public String getAcqAddnData() {
        return acqAddnData;
    }

    public void setAcqAddnData(String acqAddnData) {
        this.acqAddnData = acqAddnData;
    }
    
    public Map<String, Object> getGoodsDetail() {
        return goodsDetail;
    }
    
    public void setGoodsDetail(Map<String, Object> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
    
    public String getQueryOptions() {
        return queryOptions;
    }
    
    public void setQueryOptions(String queryOptions) {
        this.queryOptions = queryOptions;
    }
    
    public String getContractRefundReq() {
        return contractRefundReq;
    }
    
    public void setContractRefundReq(String contractRefundReq) {
        this.contractRefundReq = contractRefundReq;
    }

    public String getEncryptTradeAddressInfo() {
        return encryptTradeAddressInfo;
    }

    public void setEncryptTradeAddressInfo(String encryptTradeAddressInfo) {
        this.encryptTradeAddressInfo = encryptTradeAddressInfo;
    }
}
