# <a name="_toc21148"></a><a name="_toc364700599"></a><a name="_toc19156"></a>**文档变更记录**

|序号|变更内容|影响分析|版本号|变更人|变更时间|
| - | - | - | - | - | - |
|1|<p>1、 收款码申请字段增加tradeScene字段；</p><p>2、 所有接口里的tradeScene字段改为必填</p>|所有商户需要确认是否有按要求上送此字段，若无则需改造。|V2.1||2019\.10|
|2|<p>1、 删除附录1中的测试商户账号信息；</p><p>2、 修改4.1章节关于聚合码的描述，聚合码支持扫多次；</p><p>3、 支付宝native支付支持实名支付</p><p>4、 微信统一下单返回的prepayId字段长度调整为36</p><p>5、 微信统一下单、支付宝native支付、退款请求接口增加订单原始金额和订单优惠金额字段</p>|<p>1、 用户扫聚合码失败后可以使用相同支付方式再次扫码支付；</p><p>2、 支付宝native支付请求接口增加实名支付字段</p><p>3、 商户可通过微信统一下单和支付宝native接口上送自己的优惠信息。</p>|V2.2||2019\.11|
|3|<p>1、 支持支付宝免充值优惠券</p><p>2、 联机报文增加返回付款银行、第三方订单号、支付宝账户</p><p>3、 微信统一下单增加返回用户唯一标识</p><p>4、 报文签名支持SM2算法</p><p>5、 支持行内业务网下载对账单，支持下载集团账单</p>|<p>1、 商户需评估招行增加返回字段是否有影响。</p><p>2、 增量商户需采用SM2进行报文签名处理</p>|V2.3||2020\.02|
|4|<p>1、 微信统一下单接口subOpenId字段改为必填</p><p>2、 付款码收款增加itemDiscount和promotionDetail支持微信支付宝单品优惠</p>|微信、支付宝单品优惠功能|V2.4||2020\.07|
|5|<p>1、 新增订单二维码申请接口</p><p>&emsp;</p>|<p>1、商户申请订单二维码，在用户未扫码支付前，允许商户再次调用API修改订单码的收款金额。</p><p>2、用户扫描订单码未支付请款下，用户可以选择再次使用相同或更换其它支付方式进行扫码支付</p>|V2.5||2020\.09|
|6|<p>1、 新增微信小程序下单接口</p><p>2、 删除微信Native支付接口</p>|1、用户通过在商户APP完成下单，然后商户跳转到招行微信小程序，用户在微信小程序中完成支付|V2.6||2020\.10|
|7|1、新增银联云闪付下单接口|银联云闪付功能|V2.7|||
|8|1、新增商品优惠信息字段|<p>1、付款码收款新增上送itemDiscount</p><p>2、支付结果查询返回issAddnData</p><p>3、退款申请新增上送acqAddnData，增加返回</p><p>issAddnData,goodsDetail,refundDetail</p><p>4、 退款结果查询新增返回issAddnData,refundDetai</p><p>5、 退款结果通知新增返回</p><p>&emsp;issAddnData,refundDetai</p>|V2.7.1||2020\.12|
|9|1、修改签名方式|修改支持国密签名|V2.8||2020\.04|
|10|<p>1、 去除文档中关于RSA签名算法相关描述</p><p>2、 删除附录中秘钥设置相关报文</p>|无|V2.8.1||2020\.07|
|11|<p>1、 修改附录1测试环境主扫支付地址</p><p>2、 tradeScene增加枚举值</p>|无|V2.8.2||2021\.08|
|12|1、 服务窗支付和支付宝native码支付新增alipayExtendParams|无|V2.8.3||<p>2021\.10</p><p></p>|
|13|<p>1、 收款码申请、付款码收款、微信统一下单、服务窗支付、支付宝native码支付、订单二维码申请、微信小程序下单等接口请求参数新增终端信息terminalInfo</p><p>2、 付款码收款增加微信设备号deviceInfo</p>|无|V2.9.0||2021\.12|
|14|<p>1、新增数字人民币统一下单接口</p><p>2、新增数字人民币统一支付接口</p><p>3、4.2支付结果查询返回参数payType增加枚举值EC数字人民币</p><p>4、4.3支付结果通知请求参数payType增加枚举值EC数字人民币</p><p>5、4.6退款结果通知请求参数payType增加枚举值EC数字人民币</p>|无|V2.9.1||2022\.01|
|15|1、	新增数字人民币子钱包支付接口|无|V2.9.2||2022\.02|
|16|收款码申请、付款码收款、微信统一下单、服务窗支付、支付宝native支付、订单二维码申请、微信小程序下单接口删除请求参数中的tradeScene |支持已上送tradeScene字段继续上送|V2.9.3||2022\.03|
|17|<p>1、 新增带合约的数字人民币子钱包支付接口4.20</p><p>2、 4.2支付结果查询</p><p>&emsp;响应参数增加：合约收款响应内容字段</p><p>3、 4.4退款申请</p><p>&emsp;请求参数增加：合约退款请求内容字段</p><p>&emsp;响应参数增加：合约退款响应内容字段</p><p>4、 4.5退款结果查询</p><p>&emsp;响应参数增加：合约退款响应内容字段</p><p>5、 4.6退款通知</p><p>&emsp;请求参数增加：合约退款请求内容字段</p>|无|V2.9.4||2022\.09|
|18|<p>4\.8付款码收款</p><p>请求参数：增加数币支付参数ecnyPayment</p><p>响应参数：支付方式payType枚举值增加EC：数字人民币</p>||V2.9.5||2022\.09|
|19|4\.1收款码申请、4.8付款码收款、4.11服务窗支付、4.12支付宝native码支付请求参数增加businessParams支付宝-商户传入业务信息||V2.9.6||2022\.11|
|20|<p>①新增4.21 数字人民币统一下单-带合约接口；</p><p>②4.3 支付结果通知接口-请求参数增加：合约响应内容 contractResp</p><p>③4.19 数字人民币子钱包支付-响应参数增加：备注remark</p>||V2.9.7||2023\.01|
|21|<p>①4.10微信统一下单请求参数增加指定支付者limitPayer；</p><p>②4.15微信小程序下单请求参数增加指定支付者limitPayer；</p><p>③新增4.22微信委托代扣接口；④4.23微信委托代扣查询接口</p>||V2.9.8|||
|22|4\.1收款码申请、4.4退款申请、4.8付款码收款、4.10微信统一下单、4.11服务窗支付、4.12支付宝native码支付、4.14订单二维码申请、4.15微信小程序下单、4.16银联云闪付、4.17数字人民币统一下单、4.18数字人民币统一支付、4.19数字人民币子钱包支付、4.20数币人民币子钱包支付-带合约、4.21数字人民币统一下单-带合约、4.22微信委托代扣请求参数增加交易地址信息||V2.9.9|||
|23|<p>①新增微信委托代扣-支付分接口；</p><p>②4.17 数字人民币统一下单接口请求参数新增policyNo和region；支持APP或小程序拉起数币支付</p><p>③4.5退款查询接口增加返回失败原因failureReason</p>||V3.0.0|||
|24|<p>① 4.2支付结果查询-响应参数、</p><p>② 4.3支付结果通知-请求参数、</p><p>③4.19 数字人民币子钱包支付-响应参数：增加付款运营机构编码debtorAgentId，付款运营机构名称debtorAgentName</p>||V3.0.1|||
|25|①4.17 响应参数context里面增加加密证书序列号ncrptnSN||V3.0.2|||
|26|<p>①4.11服务窗支付请求参数buyerId字段长度改成28</p><p>②4.4退款申请响应参数增加失败原因failureReason</p>||V3.0.3|||
|27|<p>①新增4.24支付宝APP支付</p><p>②新增4.25支付宝手机网站支付接口</p>||V3.1.0|||
|28|4\.24支付宝APP支付、4.25支付宝手机网站支付接口请求参数新增实名信息identity，收银员userId改成10位||V3.1.1|||
|29|4\.19 数字人民币子钱包支付、4.20 数字人民币子钱包支付 – 带合约接口请求参数新增订单失效时间orderTimeExpire||V3.1.2|||
|30|<p>①4.2、4.5响应参数增加返回：数字人民币优惠详情ecnyPromotionDetail</p><p>②4.3、4.6请求参数新增：数字人民币优惠详情ecnyPromotionDetail</p><p>③4.19、4.20响应参数增加返回：优惠金额dscAmt，数字人民币优惠详情ecnyPromotionDetail</p>||V3.1.3|||
|31|4\.11 服务窗支付、4.12 支付宝native支付、4.24支付宝APP支付、4.25支付宝手机网页支付新增同步跳转地址returnUrl||V3.1.4|||
|32|4\.11服务窗支付、4.12支付宝native码支付、4.25 支付宝手机网站支付、4.24 支付宝APP支付请求参数实名支付信息identity字段中的type支持身份证：IDCARD、护照：PASSPORT、军官证：OFFICER\_CARD、士兵证：SOLDIER\_CARD、户口本：HOKOU||V3.1.5|||
|33|<p>2\.7.1终端信息支持上送终端位置国家编码和终端位置地区编码，并且随device\_type和device\_id描述进行调整</p><p>4\.8付款码收款接口termId字段描述调整</p>||V3.1.6|||
|34|<p>新增4.26微信支付分预授权</p><p>新增4.27微信支付分预授权查询</p><p>新增4.28微信支付分解除授权</p><p>新增4.29微信支付分预授权通知</p><p>新增4.30微信支付分创建订单</p><p>新增4.31微信支付分完结订单</p><p>新增4.32微信支付分查询订单</p><p>新增4.33微信支付分取消订单</p><p>新增4.34微信支付分修改订单金额</p><p>新增4.35微信支付分确认订单通知</p>||V3.1.7||2024\.02|
|35|新增4.36智能合约交易分账接口||V3.1.8||2024\.04|
|36|<p>①新增4.37微信授权码查询openid</p><p>②4.14订单码申请接口请求参数删除mchStoreId</p>||V3.1.9||2024\.05|
|37|<p>4\.1 收款码申请</p><p>4\.4 退款申请</p><p>4\.8 付款码收款</p><p>4\.10 微信统一下单</p><p>4\.11 服务窗支付</p><p>4\.12 支付宝native码支付</p><p>4\.14 订单二维码申请</p><p>4\.15 微信小程序下单</p><p>4\.16 银联云闪付</p><p>4\.22 微信委托代扣</p><p>4\.24 支付宝APP支付</p><p>4\.25 支付宝手机网站支付</p><p>4\.30 微信支付分创建订单</p><p>4\.31 微信支付分完结订单</p><p>新增附加经营商户subMerId和经营商户门店号subStoreId</p><p></p>||V3.1.10||2024\.05|
|38|<p>新增4.38 支付宝先享后付-统一收单交易支付</p><p>4\.2支付结果查询：请求参数和响应参数增加外部商户订单号outOrderId</p><p>4\.4退款申请：请求参数增加原外部商户订单号origOutOrderId</p><p>4\.5退款结果查询：请求参数增加原外部商户订单号origOutOrderId</p><p>4\.7 关闭订单：请求参数和响应参数增加外部商户订单号origOutOrderId</p>||V3.2.0||2024\.05|
|39|<p>4\.1 收款码申请</p><p>4\.4 退款申请</p><p>4\.8 付款码收款</p><p>4\.10 微信统一下单</p><p>4\.11 服务窗支付</p><p>4\.12 支付宝native码支付</p><p>4\.14 订单二维码申请</p><p>4\.15 微信小程序下单</p><p>4\.16 银联云闪付</p><p>4\.17 数字人民币统一下单</p><p>4\.18 数字人民币统一支付</p><p>4\.19 数字人民币子钱包支付</p><p>4\.20 数字人民币子钱包支付 - 带合约</p><p>4\.20 数字人民币统一下单 - 带合约</p><p>4\.22 微信委托代扣</p><p>4\.24 支付宝APP支付</p><p>4\.25 支付宝手机网站支付</p><p>修改涉及敏感信息字段encryptIdentity，encryptTerminalInfo，</p><p>encryptTradeAddressInfo</p>||V3.2.1||2024\.07|
|40|<p>4\.30 微信支付订单创建通知地址描述修改</p><p>4\.35 微信支付分订单确认通知新增字段notifyType</p><p>银联二维码仿真测试地址更新</p>||V3.3.0||2024\.08|
|41|新增4.39 微信刷脸获取调用凭证接口||V3.3.1||2024\.08|
|42|增加2.4.5安全防护要求||V3.3.2||2024\.09|
|43|<p>新增4.40 支付宝商户前置内容咨询接口</p><p>新增4.41 支付宝吱口令获取接口</p>||V3.3.4||2024\.11|
|44|4\.38 支付宝先享后付-统一收单交易支付 请求参数timeoutExpress要求必填||V3.3.5||2024\.12|

文档概述
1. ## <a name="_toc19379"></a>文档说明
本文阅读对象：商户平台服务方涉及的技术架构师，研发工程师，测试工程师，系统运维工程师。

版本说明：持续更新，详见文档更新日志

注意：JSON格式的报文需兼容多返回字段的情况
1. ## <a name="_toc29080"></a>术语
### <a name="_toc13725"></a>*1.2.1支付模式*
1、收款码主扫支付

收款码主扫支付是商户系统通过HTTPS请求报文调用聚合收单平台提供的API生成动态聚合银标码，用户再用微信、支付宝、银联钱包等第三方APP“扫一扫”完成支付的模式。该模式适用于PC网站支付、实体店单品或订单支付、媒体广告支付等场景。

2、被扫用户付款码支付

被扫用户付款码支付是用户展示微信，支付宝或银联钱包内的“刷卡条码/二维码”给商户系统扫描后直接完成支付的模式。主要应用线下面对面收银的场景。

3、微信统一下单

微信统一下单目前支持微信公众号支付、小程序支付和APP支付三种模式，公众号支付和小程序支付是指用户在微信公众账号内进入商家公众号、用户打开好友在朋友圈和聊天窗口等分享商家页面链接或在商家小程序中进入商家页面，商户在H5页面通过调用微信支付提供的JSAPI接口调起微信支付模块完成支付，APP支付又称移动端支付，是用户登录商家APP进行下单，商户通过在移动端应用APP中集成开放SDK调起支付模块完成支付的模式。

4、支付宝服务窗支付

支付宝服务窗支付是指用户使用支付宝通过扫码或打开好友分享的商家页面链接而进入商家页面，商户在H5页面通过调用支付宝提供的JSAPI接口调起支付宝支付模块完成支付。
### <a name="_toc19676"></a>*1.2.2名词解释*
1、聚合收单平台

提供聚合收单服务，为我行商户提供了融合多个支付渠道，一站式资金结算和对账的技术解决方案，降低了我行商户系统投入和运营成本，提供了资金结算和财务对账效率的实际需求。主要支付媒体包括: ERP系统、收银台、聚合收款APP、公众号、固定二维码。支付通道：支付宝、微信、银联二维码。

2、商户收银系统

商户收银系统即商户的POS收银系统，是录入商品信息、生成订单、客户支付、打印小票等功能的系统。接入微信支付功能主要涉及到POS软件系统的开发和测试，所以在下文中提到的商户收银系统特指POS收银软件系统。

3、商户后台系统

商户后台系统是商户后台处理业务系统的总称，例如：商户网站、收银系统、进销存系统、发货系统、客服系统等。

4、扫码设备

一种输入设备，主要用于商户系统快速读取媒介上的图形编码信息。按读取码的类型不同，可分为条码扫码设备和二维码扫码设备。按读取物理原理可分为红外扫码设备、激光扫码设备。

5、商户证书（暂未启用）

商户证书是聚合收单平台提供的二进制文件，商户系统发起与平台支付后台服务器通信请求的时候，作为平台支付后台识别商户真实身份的凭据。

6、签名

聚合收单平台需要验证商户上送的签名是否正确；商户收到应答，也需要验证签名是否正确，如果商户未正确验证签名，存在潜在的风险，商户自行承担因此而产生的所有损失。

商户后台和聚合收单平台后台根据非对称的密钥对和SM2算法校验双方身份合法性。签名的算法由聚合收单平台制定并公开，目前仅支持SM2算法，测试环境签名所使用的SM2公私钥对信息请参见[附录1](#_附录1)。

7、支付密码

支付密码是用户开通微信、支付宝、银联钱包等支付时单独设置的密码，用于确认支付完成交易授权。

8、Openid

用户在聚合收单平台内的身份标识，不同商户号拥有不同的openid。商户后台系统通过登录授权、支付通知、查询订单等API可获取到用户的openid。主要用途是判断同一个用户，对用户发送客服消息、模版消息等。

# <a name="_toc26820"></a><a name="_toc19"></a><a name="_toc4073"></a>**2.接口规则**
## <a name="_toc5928"></a><a name="_toc6254"></a><a name="_toc21591"></a><a name="_toc32594"></a>2.1服务器地址
**测试环境地址：**

收款码申请：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/qrcodeapply

支付结果查询：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/orderquery

退款申请：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/refund

退款结果查询：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/refundquery

付款码收款：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/pay

微信统一下单：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/onlinepay

付款码收款撤销：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/cancel

关闭订单：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/close

支付宝服务窗支付：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/servpay

支付宝native支付：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/zfbqrcode

对账单下载地址获取：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/statementurl

秘钥设置：

<https://api.cmburl.cn:8065/polypay/v1.0/mchkey/keyset>

订单二维码申请

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/orderqrcodeapply

微信小程序下单：

<https://api.cmburl.cn:8065/polypay/v1.0/mchorders/MiniAppOrderApply>

银联云闪付：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/cloudpay

数字人民币统一下单

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/ecny/unifiedOrder

数字人民币统一支付

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/ecny/unifiedPayment

数字人民币子钱包支付

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/ecny/subwalletpay

数字人民币子钱包支付-带合约

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/ecny/contractsubwalletpay

数字人民币统一下单-带合约

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/ecny/contractUnifiedOrder

委托代扣：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/pap

委托代扣结果查询：

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/paporderquery

微信委托代扣-支付分：

https:// api.cmburl.cn:8065/polypay/v1.0/mchorders/pap2

支付宝APP支付：

https:// api.cmburl.cn:8065/polypay/v1.0/mchorders/zfbapp

支付宝手机网站支付：

https:// api.cmburl.cn:8065/polypay/v1.0/mchorders/zfbwap

微信支付分预授权:

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/payscore/permissions

微信支付分预授权查询:

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/payscore/querypermissions

微信支付分解除授权:

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/payscore/terminatepermissions

微信支付分创建订单:

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/payscore/order

微信支付分完结订单:

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/payscore/completeorder

微信支付分查询订单:

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/payscore/queryorder

微信支付分取消订单:

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/payscore/cancelorder

微信支付分修改订单金额:

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/payscore/modifyorder

智能合约-分润

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/ecny/contractBenefit

微信授权码查询openid

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/openidqrybyac

支付宝先享后付-统一收单交易支付:

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/payafteruser/pay

支付宝-商户前置内容咨询:

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/alipay/marketing/consult

支付宝-吱口令获取:

https://api.cmburl.cn:8065/polypay/v1.0/mchorders/alipay/sharetoken/create




因交易结果通知是银行主动通知给商户的，故不提供商户主动调用的URL。

**生产接入地址：**

收款码申请：

https://api.cmbchina.com/polypay/v1.0/mchorders/qrcodeapply

支付结果查询：

https://api.cmbchina.com/polypay/v1.0/mchorders/orderquery

退款申请：

https://api.cmbchina.com/polypay/v1.0/mchorders/refund

退款结果查询：

https://api.cmbchina.com/polypay/v1.0/mchorders/refundquery

付款码收款：

https://api.cmbchina.com/polypay/v1.0/mchorders/pay

微信统一下单：

https://api.cmbchina.com/polypay/v1.0/mchorders/onlinepay

付款码收款撤销：

https://api.cmbchina.com/polypay/v1.0/mchorders/cancel

关闭订单：

https://api.cmbchina.com/polypay/v1.0/mchorders/close

支付宝服务窗支付：

https://api.cmbchina.com/polypay/v1.0/mchorders/servpay

支付宝native支付：

https://api.cmbchina.com/polypay/v1.0/mchorders/zfbqrcode

对账单下载地址获取：

https://api.cmbchina.com/polypay/v1.0/mchorders/statementurl

订单二维码申请：

<https://api.cmbchina.com/polypay/v1.0/mchorders/orderqrcodeapply>

微信小程序下单：

[https://api.cmbchina.com/polypay/v1.0/mchorders/MiniAppOrderApply](https://api.cmbchina.com/polypay/v1.0/mchorders/orderqrcodeapply)

银联云闪付：

[https://api.cmbchina.com/polypay/v1.0/mchorders/cloudpay](https://api.cmbchina.com/polypay/v1.0/mchorders/orderqrcodeapply)

数字人民币统一下单

https://api.cmbchina.com/polypay/v1.0/mchorders/ecny/unifiedOrder

数字人民币统一支付

https://api.cmbchina.com/polypay/v1.0/mchorders/ecny/unifiedPayment

数字人民币子钱包支付

https://api.cmbchina.com/polypay/v1.0/mchorders/ecny/subwalletpay

数字人民币子钱包支付-带合约

https://api.cmbchina.com/polypay/v1.0/mchorders/ecny/contractsubwalletpay

数字人民币统一下单-带合约

https://api.cmbchina.com/polypay/v1.0/mchorders/ecny/contractUnifiedOrder

微信委托代扣：

https://api.cmbchina.com/polypay/v1.0/mchorders/pap

微信委托代扣结果查询：

https://api.cmbchina.com/polypay/v1.0/mchorders/paporderquery

微信委托代扣-支付分：

https://api.cmbchina.com/polypay/v1.0/mchorders/pap2

支付宝APP支付：

https://api.cmbchina.com/polypay/v1.0/mchorders/zfbapp

支付宝手机网站支付：

https://api.cmbchina.com/polypay/v1.0/mchorders/zfbwap

微信支付分预授权:

https://api.cmbchina.com/polypay/v1.0/mchorders/payscore/permissions

微信支付分预授权查询:

https://api.cmbchina.com/polypay/v1.0/mchorders/payscore/querypermissions

微信支付分解除授权:

https://api.cmbchina.com/polypay/v1.0/mchorders/payscore/terminatepermissions

微信支付分创建订单:

https://api.cmbchina.com/polypay/v1.0/mchorders/payscore/order

微信支付分完结订单:

https://api.cmbchina.com/polypay/v1.0/mchorders/payscore/completeorder

微信支付分查询订单:

https://api.cmbchina.com/polypay/v1.0/mchorders/payscore/queryorder

微信支付分取消订单:

https://api.cmbchina.com/polypay/v1.0/mchorders/payscore/cancelorder

微信支付分修改订单金额:

https://api.cmbchina.com/polypay/v1.0/mchorders/payscore/modifyorder

智能合约-分润：

https://api.cmbchina.com/polypay/v1.0/mchorders/ecny/contractBenefit

微信授权码查询openid：

https://api.cmbchina.com/polypay/v1.0/mchorders/openidqrybyac

支付宝先享后付-统一收单交易支付:

https://api.cmbchina.com/polypay/v1.0/mchorders/payafteruser/pay

支付宝-商户前置内容咨询:

https://api.cmbchina.com/polypay/v1.0/mchorders/alipay/marketing/consult

支付宝-吱口令获取:

https://api.cmbchina.com/polypay/v1.0/mchorders/alipay/sharetoken/create



## <a name="_toc23056"></a><a name="_toc9253"></a><a name="_toc2956"></a><a name="_toc9857"></a>2.2协议规定
商户接入聚合收单平台，调用API遵循以下规则：

<a name="_toc3759"></a><a name="_toc19309"></a><a name="_toc7034"></a>1、 传输方式：	为保证交易安全性，建议采用HTTPS传输

2、 提交方式：	采用POST方法提交

3、 数据格式：	提交和返回数据都为JSON格式的字符串，报文头中需将Content-Type设置为application/json，报文样例详见[附录2](#_附录2)，所有业务字段（除版本号、编码方式、签名、签名方法、返回码、应答码、错误码、应答信息字段外的其他字段）都须放在biz\_content总传输。

4、 字符编码：	统一采用UTF-8字符编码

5、 签名算法：	SM2 国密算法

6、 签名要求：	请求和接收数据均需要校验签名，详细方法请参考[*安全规范-签名算法*](#_2.4.1签名算法)

7、 APP ID校验：	商户在接入聚合收单平台时，平台会为其分配一堆APP ID和APP SECRET，聚合收单平台将根据此APP ID校验商户身份，详细使用方法请参考[安全规范-APP ID校验](#_2.4.3 app id校验)

8、 判断逻辑：	先判断协议字段返回，再判断业务返回

9、支付和退款交易若聚合收单平台返回的returnCode为FAIL且errCode为SYSTERM\_ERROR，则表示聚合首单平台内部发生未知错误，交易是否成功尚不明确，需要商户系统对支付和退款结果发起查询，直到交易结果明确。

10、 支付结果查询和退款结果查询若聚合收单平台返回的returnCode为FAIL且errCode为SYSTERM\_ERROR，则表示聚合首单平台内部发生未知错误，并非一定是交易失败，交易是否成功需要商户系统继续发起查询，直到查回明确的交易结果。

**11、 商户必须实现查询机制，以防当网络抖动等异常情况下招行未及时将支付/退款结果通知给商户时商户可以依靠查询得到准确的支付/退款结果，若商户未实现查询机制，则相应风险由商户自行承担。**

**12、 因扩展需要，招行返回的报文参数（key） 可能会超过接口中定义的范围，商户需要对增加的报文参数进行验签处理， 在业务处理阶段进行忽略处理，对部分字段长度也可能会因业务扩展需要而扩充字段长度。**

## <a name="_toc14617"></a><a name="_2.3参数规定"></a>2.3参数规定
1、交易金额

交易金额默认为人民币交易，接口中参数支付金额单位为【分】，参数值不能带小数。对账单中的交易金额单位为【分】。 

外币交易的支付金额精确到币种的最小单位，参数值不能带小数点。 

2、货币类型

货币类型的取值列表： 

156：人民币 

3、回调通知地址

回调通知地址notifyUrl是聚合收单平台从后台直接发送请求到商户后台系统，商户后台系统处理时不能检查用户的cookie或session；商户后台系统更新本地数据库发货流程等数据，需要在notifyUrl完成后，以确保发生掉单时，聚合收单平台的补单功能可以将掉单的订单成功补上。

notifyUrl有可能重复通知，商户后台系统需要做幂等处理，避免重复发货。

notifyUrl收到通知，商户后台系统处理成功或检查订单已经处理，需要返回处理成功的标志“SUCCESS”，以告知聚合收单平台不再发起通知到notifyUrl。

联调测试及生产接入前，请商户提前提供notifyUrl给聚合收单平台，以便开通聚合收单平台到商户后台系统的网络，网络开通预计需要2-3个工作日。

4、时间

标准北京时间，时区为东八区；如果商户的系统时间为非标准北京时间。参数值必须根据商户系统所在时区先换算成标准北京时间， 例如商户所在地为0时区的伦敦，当地时间为2014年11月11日0时0分0秒，换算成北京时间为2014年11月11日8时0分0秒。

5、时间戳

标准北京时间，时区为东八区，自1970年1月1日 0点0分0秒以来的秒数。注意：部分系统取到的值为毫秒级，需要转换成秒(10位数字)。

6、商户订单号

商户支付的订单号由商户自定义生成，聚合收单平台要求商户订单号保持唯一性（建议根据当前系统时间加随机序列来生成订单号）。重新发起一笔支付要使用原订单号，避免重复支付；已支付过或已调用关单、撤销（请见后文的API列表）的订单号不能重新发起支付。

7、非必填字段填写说明

所有接口中非必填字段如果商户有上送则须上送有意义的数据内容，不可填写空格、null或空字符串等无实际含义的内容。

8、商品描述

商品描述（body）字段若商户有上送，则会在用户支付完成后展示在用户支付宝账单中的商品描述字段、微信账单中的商品字段，若商户不上送，则会默认展示商户简称字段。

## <a name="_toc28604"></a>2.4安全规范
### <a name="_toc9087"></a><a name="_2.4.1签名算法"></a>*2.4.1签名算法*
<a name="_toc31944"></a><a name="_toc15948"></a><a name="_数据请求签名生成规则"></a><a name="_签名规则"></a><a name="_toc7102"></a>2.4.1.1报文的签名机制

对于报文的签名处理机制如下：

1\. 筛选并排序

获取所有请求参数，剔除 sign 字段，并按照第一个字符的键值 ASCII 码递增排序（字母升序排序），如果遇到相同字符则按照第二个字符的键值 ASCII 码递增排序，以此类推。

2\. 拼接

将排序后的参数与其对应值，组合成“参数=参数值”的格式，并且把这些参数用&字符连接起来，此时生成的字符串为待签名字符串。

3\. 生成签名值

数字签名采用SM2withSM3签名算法，签名方式为PKCS#1裸签名，签名USER\_ID使用国密局推荐ID，即“1234567812345678”，使用国密私钥对签名字符串进行加签，生成签名值。

4\. 组装报文

把生成的签名赋值给 sign 参数，和其他请求参数一起通过HTTPS Post的方式传输给招行聚合支付系统。

2\.4.1.2 报文的验签机制

同步返回和异步通知报文格式及验签方法有所区别。

①、 同步返回报文验签机制（如收款码申请接口同步返回二维码信息）：

1\. 筛选并排序

获取所有响应参数，剔除 sign 字段，并按照第一个字符的键值 ASCII 码递增排序（字母升序排序），如果遇到相同字符则按照第二个字符的键值 ASCII 码递增排序，以此类推。

2\. 拼接

将排序后的参数与其对应值，组合成“参数=参数值”的格式，并且把这些参数用&字符连接起来，此时生成的字符串为待签名字符串，如果字符串中包含“http://”的正斜杠，需要先将正斜杠做转义，默认打印出来的字符串是已经做过转义的。

3\. 验签

接收方使用发起方国密公钥，使用SM2withSM3签名算法对发起方的签名值进行验签处理。

②异步通知验签

某些情况下(比如扫码支付成功时)，会给商户发送异步通知，验签流程如下：

1\. 在通知返回参数列表中，除去sign，凡是通知返回回来的参数皆是待验签的参数。

2\. 将剩下参数进行url\_decode, 然后进行字典排序，组成字符串，得到待验签字符串：

3\. 使用国密的验签方法，通过签名字符串、签名参数（经过base64解码）及招行公钥验证签名，根据返回结果判定是否验签通过。

聚合收单提供java和C#版本的商户端demo，可联系分行业务同事获取

2\.4.1.3 国密秘钥标准规范

1\. 国密非对称秘钥采用SM2标准秘钥格式，私钥为32字节字节流，转换为HEX格式为64字节。

2\. 国密非对称公钥采用base64格式，并且符合ANS1标准，base64编码后总长度为124字节

3\. 秘钥案例：

私钥：D5F2AFA24E6BA9071B54A8C9AD735F9A1DE9C4657FA386C09B592694BC118B38

SM2标准公钥头：3059301306072A8648CE3D020106082A811CCF5501822D03420004

SM2裸公钥：

X：E90F9F92DB2763D3853FE2E9491E5475BC5FE731C214ED0F98E2A514D4F10C81

Y：A5F23B0F6DB07FF444F6DCD57E69C4B3E05124CC3EF8B16DA288D54744B88A1E

SM2 ASN1格式标准公钥：

3059301306072A8648CE3D020106082A811CCF5501822D03420004E90F9F92DB2763D3853FE2E9491E5475BC5FE731C214ED0F98E2A514D4F10C81A5F23B0F6DB07FF444F6DCD57E69C4B3E05124CC3EF8B16DA288D54744B88A1E

BASE64公钥：

MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE6Q+fktsnY9OFP+LpSR5Udbxf5zHCFO0PmOKlFNTxDIGl8jsPbbB/9ET23NV+acSz4FEkzD74sW2iiNVHRLiKHg==

### <a name="_toc22626"></a>*2.4.2商户回调API安全*
在普通的网络环境下，HTTP请求存在DNS劫持、运营商插入广告、数据被窃取，正常数据被修改等安全风险。商户回调接口使用HTTPS协议可以保证数据传输的安全性。所以建议商户提供的各种回调采用HTTPS协议。
### <a name="_toc934"></a><a name="_2.4.3 app id校验"></a>*2.4.3 APP ID校验*
商户在接入聚合收单平台前，行内其他系统会为商户分配一对APP ID和APP SECRET（测试环境的APP ID数据参见[附录1](#_附录1)），其中商户和APP ID是一一对应的，APP ID作为商户在调用聚合收单API时的身份标识。商户在上送请求报文时需将此APP ID放在报文头中上送过来，且需对APP ID、APP SECRET、报文体中的sign值（见个接口规范）、Linux格式时间戳按KEY值的首字母排序并用&连接，然后用MD5算法进行加签，加签结果为小写字母，并将时间戳和加签结果和APP ID一起放在请求报文的报文头中（APP SECRET无需上送）。具体可参考如下示例：

appid：e315a8b5-45f6-4f96-b20a-0b586a2a96c6

secret：6adca97f-c411-43cd-93ed-7f1aee829832

sign：ceo20AoYZegzjt4cn+kSGqFBDWIL/ykLTan5mQW8teofYaGdiMJeg5Xkp9ZZp3PlJkSf1+MLv2xbamDsiLmPP9vFLbnyttgYYtrHaCbcExZgRwbSgu9XQ6wIVrlUOyYCWT33QfiXyxyZv5o9B0VNgUN6CEmFJfGlFJVQky7Oui2JMmPg3xtGDVh/Vr6EfT6ZGA5vJnrSIWeDMu/8AUG4XJ24Bj/Txdys34dV4WCk8zh8O1NcHEYbbcneJ9A/BTvswsUbJtX45oIPn9vn1Gfhp81SxinU8SfrOi3jY9auYYOnokRbA6ihR2kCjwpiVRSK9xeF8iQIEjDlY+poy3m6bg==

timestamp：1528882455

排序并拼接后的字符串为：appid=e315a8b5-45f6-4f96-b20a-0b586a2a96c6&secret=6adca97f-c411-43cd-93ed-7f1aee829832&sign=ceo20AoYZegzjt4cn+kSGqFBDWIL/ykLTan5mQW8teofYaGdiMJeg5Xkp9ZZp3PlJkSf1+MLv2xbamDsiLmPP9vFLbnyttgYYtrHaCbcExZgRwbSgu9XQ6wIVrlUOyYCWT33QfiXyxyZv5o9B0VNgUN6CEmFJfGlFJVQky7Oui2JMmPg3xtGDVh/Vr6EfT6ZGA5vJnrSIWeDMu/8AUG4XJ24Bj/Txdys34dV4WCk8zh8O1NcHEYbbcneJ9A/BTvswsUbJtX45oIPn9vn1Gfhp81SxinU8SfrOi3jY9auYYOnokRbA6ihR2kCjwpiVRSK9xeF8iQIEjDlY+poy3m6bg==&timestamp=1528882455

MD5加签结果：5353272fd8a5b9a7d997ff9719246f49

报文头中需填充以下内容（key-value）：

appid：e315a8b5-45f6-4f96-b20a-0b586a2a96c6

timestamp：1528882455

apisign：5353272fd8a5b9a7d997ff9719246f49
### <a name="_2.4.4_敏感信息加密"></a><a name="_toc13509"></a><a name="_2.4.4 敏感信息加密"></a>*2.4.4 敏感信息加密*
注意：前提需完成国密加验签改造，并在交易过程中使用国密加验签。

**如一次请求中有多个字段需加密，对称密钥使用同一个。这里以terminalInfo字段为例：**

商户接入使用terminalInfo字段时，需要使用国密加密方式对字段进行加密传输，具体步骤如下：

1. **组装terminalInfo对象并将其转换为JSON字符串格式。实例如下：**

{"location":"+37.12/-121.213","mobile\_country\_cd":"460","lbs\_signal1":"34D6A"}"

1. **商户自行生成对称秘钥，如1234567890123456**

1. **使用对称秘钥对terminalInfo进行SM4加密，进行Base64编码，生成密文如下：**

ZeUBCWhERVgl7iyPZaIfGAqvo160MVexVqY1DoQDIb+j9A98Doqt4/lDVYaqmsEiYKuPJf8s1CNIzHvxQgNPn+nYJZ3CFHuP6dORZvtrAHY=

1. **使用招行公钥对该对称秘钥进行SM2加密，进行Base64编码，得到数字信封如下：**

MHkCIQC5yvHxfNAaqE0kQg88RlmAYwjTS86d2ED/E88FAYciigIgE85jFoZLTDbOY2bntruWoE3bqBUCqggqy3+gfJHUu9UEIFhQ2sJlCc1pASdqGuiCr2Qsmnr0UJK5GNApr47Ksaz4BBCn6KvL9nuFkflP3r5z0q6B

1. **组装报文**

将terminalInfo的密文放入biz\_content下的terminalInfo字段；将数字信封放入encryptKey字段，得到如下商户请求报文：

{

`    `"biz\_content": "{\"orderId\":\"123456\",\"notifyUrl\":\"http://test/hh\",\"merId\":\"308111111111111\",\"payValidTime\":\"100\",\"body\":\"body\",\"mchReserved\":\"mchReserved\",\"tradeType\":\"JSAPI\",\"userId\":\"\",\"txnAmt\":\"1\",\"terminalInfo\":\"ZeUBCWhERVgl7iyPZaIfGAqvo160MVexVqY1DoQDIb+j9A98Doqt4/lDVYaqmsEiYKuPJf8s1CNIzHvxQgNPn+nYJZ3CFHuP6dORZvtrAHY=\"}",

`    `"encoding": "UTF-8",

`    `"signMethod": "02",

`    `"version": "0.0.1",

"encryptKey":"MHkCIQC5yvHxfNAaqE0kQg88RlmAYwjTS86d2ED/E88FAYciigIgE85jFoZLTDbOY2bntruWoE3bqBUCqggqy3+gfJHUu9UEIFhQ2sJlCc1pASdqGuiCr2Qsmnr0UJK5GNApr47Ksaz4BBCn6KvL9nuFkflP3r5z0q6B",

"sign":"MEUCIHC8GYMrjevlA4IKLZEmZ1PS2HwQn84xMypIS+cpUNoyAiEAveXClDQHqLl4WsSe0U03MJxZgHde3VJmUbLMcE5zjgU="

}
### <a name="_toc5783"></a>*2.4.5 安全防护要求*
商户接入聚合收单平台时不仅要遵循测试环境接入流程，未经测试禁止直接接入生产环境；还应严格遵循平台相关技术规范要求，发送合法报文、传输合法文件，严禁发送任何异常流量。异常流量包括但不限于：探测（如伪造正常报文心跳探测）、端口扫描、账户/口令暴力破解、漏洞扫描、拒绝服务攻击、缓冲区溢出攻击、SQL注入、性能测试或大量无效请求等。一经发现系统有权对请求TPS做限制，严重者可直接拒绝所有请求。

## <a name="_toc10176"></a>2.5未知交易通知机制
当聚合收单平台通过notifyUrl发送通知到商户后台系统时，如果平台收到商户的应答中returnCode和respCode不是“SUCCESS”（如报文样例）或验签失败，平台认为通知失败，此时平台会通过如下策略按周期重新发起通知：（通知频率为0/15/15/30/180/1800/1800/1800/1800/3600，单位：秒）。如此，尽可能提高通知的成功率，但平台并不保证通知最终能成功。

由于存在重新通过notifyUrl发送通知的情况，因此同样的通知可能会多次发送给商户后台系统。商户后台系统必须能够正确处理重复的通知。建议采用幂等处理：

即，当商户后台系统收到通知后，首先检查对应业务数据的状态，判断该通知是否已经处理过，如果没有处理过再进行处理，如果处理过直接返回“SUCCESS”。在对业务数据进行状态检查和处理之前，要采用同步锁进行并发控制，以避免通知重入造成的数据混乱。
## <a name="_2.6优惠信息字段说明_1"></a><a name="_toc19924"></a><a name="_2.6优惠信息字段说明"></a>2.6优惠信息字段说明
### <a name="_toc5790"></a><a name="_2.6.1.商品优惠信息"></a>*2.6.1.商品优惠信息*
商品优惠信息（itemDiscount）为微信、支付宝或银联单品优惠功能字段，需使用单品优惠时必传，字段类型为object类型。商品优惠活动 itemDiscount 字段列表说明如下：

|名称|变量名|必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|订单原价|cost\_price|否|int|608800|<p>【微信优惠使用】</p><p>1\.商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的交易金额。<br>2\.当订单原价与支付金额不相等，则不享受优惠。<br>3\.该字段主要用于防止同一张小票分多次支付，以享受多次优惠的情况，正常支付订单不必上传此参数。</p>|
|商品小票 ID|receipt\_id|否|String(32)|wx123|【微信优惠使用】商家小票 ID|
|订单信息|order\_info|否|object|示例见下文|【银联优惠使用】|
|单品列表|goods\_detail|是|object|示例见下文|单品信息，使用 Json 数组格式提交|






银联订单信息 order\_info 字段说明：

|名称|变量名|必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|订单标题|title|是|String(100)|日用品||
|订单描述|description|否|String(200)|||
|可优惠金额|dct\_amount|否|String（12）|10000|当前订单可以参与优惠计算的金额|
|附加信息|addn\_info|否|String（288）||内容自定义|

单品优惠活动 goods\_detail 字段说明：

|名称|变量名|必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|商品编码|goods\_id|是|String(32)|商品编码|由半角的大小写字母、数字、中划线、下划线中的一种或几种组成|
|第三方侧商品编码|third\_goods\_id|否|String(32)|1001|微信或支付宝定义的统一商品编号（没有可不传）|
|商品名称|goods\_name|否|String(256)|iPhone6s 16G|商品的实际名称【支付宝单品优惠一定要上送，微信单品优惠可不上送】|
|商品数量|quantity|是|int|1|用户购买的数量|
|商品单价|price|是|int|528800|单位为：分。如果商户有优惠，需传输商户优惠后的单价(例如：用户对一笔 100 元的订单使用了商场发的优惠券 100-50，则活动商品的单价应为原单价-50)|
|商品类目|goods\_category|否|String(24)|34543238|【支付宝优惠使用】商品类目|
|商品类目树|categories\_tree|否|String(128)||【支付宝优惠使用】商品类目树，从商品类目根节点到叶子节点的类目id组成，类目id值使用|分割|
|商品描述信息|body|否|String(1000)|特价手机|【支付宝优惠使用】商品描述信息|
|商品的展示地址|show\_url|否|String(400)|http://www.alipay.com/xxx.jpg|【支付宝优惠使用】商品的展示地址|
|附加信息|addn\_info|否|String(100)||【银联优惠使用】内容自定义|

itemDiscount示例报文如下：

{

`  `"receipt\_id": "wx123",

`  `"goods\_detail": [

`    `{

`      `"goods\_name": "iphone 12 pro",

`      `"quantity": 1,

`      `"price": 52800,

`      `"goods\_id": "dsngjl9999",

`      `"goods\_category": "051051749871",

`      `"categories\_tree": "302598|3820518",

`      `"body": "特价手机",

`      `"third\_goods\_id": "1001",

`      `"show\_url": "http://www.123.com/xxx",

`      `"addn\_info": "【银联优惠使用】内容自定义"

`    `},

`    `{

`      `"goods\_name": "iphone 12 pro",

`      `"quantity": 1,

`      `"price": 52800,

`      `"goods\_id": "dsngjl9999",

`      `"goods\_category": "051051749871",

`      `"categories\_tree": "302598|3820518",

`      `"body": "特价手机",

`      `"third\_goods\_id": "1001",

`      `"show\_url": "http://www.123.com/xxx",

`      `"addn\_info": "【银联优惠使用】内容自定义"

`    `}

`  `],

`  `"cost\_price": 608000,

`  `"orderInfo": {

`    `"title": "日用品",

`    `"dctAmount": "10000",

`    `"addnInfo": "屈臣氏(人民广场)店"

`  `}

}

### <a name="_toc29726"></a><a name="_2.6.2.优惠券信息"></a>*2.6.2.优惠券信息*
优惠券信息（promotionDetail）为微信、支付宝通道交易使用了优惠券支付成功之后微信、支付宝返回的优惠券使用信息包，该字段为json对象，且支付宝和微信的字段格式不同，商户需根据不同的支付方式按不同格式解析。

微信优惠券信息：

|字段名|变量名|是否必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|券 ID|promotion\_id|是|String(32)|109519|券或者立减优惠 id。|
|优惠名称|name|否|String(64)|单品惠-6|优惠名称|
|优惠范围|scope|否|String(32)|SINGLE|GLOBAL-全场代金券。<br>SINGLE-单品优惠|
|优惠类型|type|否|String(32)|DISCOUNT|COUPON-代金券，需要走结算资金的充值型代金券,（境外商户券币种与支付币种一致）。DISCOUNT-优惠券，不走结算资金的免充值型优惠券，境外商户券币种与标价币种一致。|
|优 惠 券 面<br>额|amount|否|Int|5|用户享受优惠的金额（优惠券面额=微信出资金额 +商家出资金额+其他出资方金额）。|
|活动 ID|activity\_id|是|String(32)|931386|在微信商户后台配置的批次ID。|
|微信出资|wxpay\_contribute|否|String(32)|0|特指由微信支付商户平台创建的优惠，出资金额等于本项优惠总金额，单位为分。|
|商户出资|merchant\_contribute|否|String(32)|0|其他出资方出资金额， 单位为分。|
|其他出资|other\_contribute|否|String(32)|5|其他出资方出资金额， 单位为分。|
|单品列表|goods\_detail|是|String|示例见下文|单品信息， 使用 Json 数组格式。|

goods\_detail字段说明：

|字段名|变量名|是否必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|商品编码|goods\_id|是|String(32)|商品编码|由半角的大小写字母、数字、中划线、下划线中的一种或几种组成。|
|商品备注|goods\_remark|否|String(128<br>)|1001|goods\_remark 为备注字段， 按照配置原样返回，字<br>段内容在微信后台配置券时进行设置。|
|商 品 优 惠<br>金额|discount\_amount|是|Int|100|单品的总优惠金额， 单位为：分。|
|商品数量|quantity|是|Int|1|用户购买的数量。|
|商品价格|price|是|Int|528800|单位为： 分。 如果商户有优惠， 需传输商户优惠后的单价(例如： 用户对一笔 100元的订单使用了商场发的优惠券 100-50， 则活动商品的单价应为原单价-50)。|

支付宝优惠券信息：

|字段名|变量名|是否必填|类型|示例值|字段名|
| :- | :- | :- | :- | :- | :- |
|券 id|id|是|String(32)|20151026000730000090<br>00002D5O|优惠券 id|
|券名称|name|是|String(64)|XX 超市 5 折优惠|优惠券名称|
|全类型|type|是|String(32)|ALIPAY\_FIX\_VOUCHER|当 前 有 三 种 类<br>型 ：<br>ALIPAY\_FIX\_VOUCHER- 全<br>场代金券<br>ALIPAY\_DISCOUNT\_VOUCH<br>ER-折扣券<br>ALIPAY\_ITEM\_VOUCHER- 单<br>品优惠<br>注： 不排除将来新增其他类<br>型的可能， 商家接入时注意兼<br>容性避免硬编码|
|优惠券面额|amount|是|Price|10|优惠券面额， 它应该会等于商<br>家出资加上其他出资方出资|
|商家出资|merchant\_contribute|否|Price|9|商家出资（特指发起交易的商<br>家出资金额）|
|其他出资方出资|other\_contribute|否|Price|1|其他出资方出资金额， 可能是<br>支付宝， 可能是品牌商， 或者<br>其他方， 也可能是他们的一起<br>出资|
|优惠券备注信息|memo|否|String(256)|学生专用优惠|优惠券备注信息|
|券模板 id|template\_id|否|String(64)|20171030000730000059<br>000EMZP0|券模板 id|
|优惠券的其他出资方明细|other\_contribute\_detail|否|Contribut<br>eDetail[]|-|优惠券的其他出资方明细， 详<br>见下文说明。|
|券用户实际付款的<br>金额|purchase\_buyer\_contribute|否|Price|2\.01|如果使用的这张券是用户购<br>买的， 则该字段代表用户在购<br>买这张券时用户实际付款的<br>金额|
|券商户优惠的金额|purchase\_<br>merchant\_contribute|否|Price|1\.03|如果使用的这张券是用户购<br>买的， 则该字段代表用户在购<br>买这张券时商户优惠的金额|
|券平台优惠的金额|purchase\_ant\_contribute|否|Price|0\.82|如果使用的这张券是用户购<br>买的， 则该字段代表用户在购<br>买这张券时平台优惠的金额|

ContributeDetail字段说明：

|字段名|变量名|是否必填|类型|示例值|字段名|
| :- | :- | :- | :- | :- | :- |
|出资方类型|contribute\_type|是|String(32)|BRAND|出资方类型， 如品牌商出资、<br>支付宝平台出资等|
|出资方金额|contribute\_amount|是|Price|8|出资方金额|

微信优惠券信息示例如下：

[

`	`{

`		`"promotion\_id":"121502",

`		`"name":"单品&优惠-2",

`		`"scope":"SINGLE",

`		`"type":"DISCOUNT",

`		`"amount":511,

`		`"activity\_id":"931386",

`		`"wxpay\_contribute":200,

`		`"merchant\_contribute":0,

`		`"other\_contribute":0,

`		`"goods\_detail":[

`			`{

`				`"goods\_id":"a\_goods1",

`				`"goods\_remark":"商品备注",

`				`"quantity":7,

`				`"price":1,

`				`"discount\_amount":4

`			`}

`		`]

`	`}

]

支付宝优惠券信息示例如下：

[

`    `{

`        `"id": "2015102600073002039000002D5O",

`        `"name": "XX 超市 5 折优惠",

`        `"type": "ALIPAY\_ITEM\_VOUCHER",

`        `"amount": "0.15"

`    `}

]
### <a name="_toc14639"></a><a name="_2.6.3.银联优惠信息"></a>*2.6.3.银联优惠信息*
**银联优惠信息（couponInfo）**为银联优惠信息包，该字段为json对象，仅银联通道交易有优惠活动时出现，商户需自行按照以下规则进行解析优惠信息：

|名称|变量名|必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|项目类型|type|是|String(4)|DD01|详见type定义|
|出资方|spnsrId|是|String(20)|00010000|银联出资固定填写00010000，付款行作为出资方则填写8位付款方机构代码，商户作为出资方则填写15位商户代码|
|抵消交易金额|offstAmt|是|String(12)|500|单位为分，不能全为0|
|项目编号|id|是|String(40)||票券号码、活动编号等|
|项目简称|desc|否|String(60)||优惠活动简称|
|附加信息|addnInfo|否|String(100)||自定义内容|

type定义如下：

|项目类型|描述|
| :- | :- |
|DD01|随机立减|
|CP01|抵金券1：无需领取，交易时直接适配并承兑的优惠券|
|CP02|抵金券2：事前领取，交易时直接适配并承兑的优惠券|

未来银联可能根据业务发展拓展新的项目类型。

一笔交易只会适配最多一个优惠活动，一个活动可以包含多个出资方，出资方可以为银联/商户/付款行中的一个或多个。对于多方出资的优惠活动，couponInfo将包含多个json对象，每个json对象体现各出资方及出资金额等信息。其中，银联或付款行出资的营销金额不影响商户的清算金额。

couponInfo示例如下：

[

`	`{

`		`"type":"DD01",

`		`"spnsrId":"00010000",

`		`"offstAmt":"500",

`		`"id":"cupcp01000023",

`		`"desc":"银联优惠 随机立减"

`	`},

`	`{

`		`"type":"DD01",

`		`"spnsrId":"848120048712365",

`		`"offstAmt":"500",

`		`"id":"cupcp01000023",

`		`"desc":"银联优惠 随机立减"

`	`}

]



**银联收款方附加数据（acqAddnData）**，该字段为JSON对象，仅在商户银联通道有商品优惠时由商户上送，商户需按照以下规则上送该信息域：

|字段名|变量名|是否必填|类型|示例值|字段名|
| :- | :- | :- | :- | :- | :- |
|订单信息|orderInfo|否|Object|示例见下文|订单明细内容|
|商品信息|goodsInfo|否|Object|示例见下文|自定义数据，具体内容及格式由付款方自行定义|
|自定义数据|customData|否|String（500）||自定义数据，具体内容及格式自定义|


orderInfo采用嵌套JSON格式，全部内容采用“{}”，内容可包含多个字段，字段定义如下表：

|名称|变量名|必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|订单标题|title|是|string(100)||订单标题|
|订单描述|description|否|string(200)||订单描述|
|可优惠金额|dctAmount|否|int||当前订单可以参与优惠计算的金额|
|附加信息|addnInfo|否|string(288)||内容自定义|


goodsInfo子域采用嵌套JSON格式，全部内容用“[]”包含，内部可含多个对象，每个对象用“{}”包含，对象之间以“,”分隔，对象内可包含多个字段，字段间以“，”分隔。字段定义如下表：

|名称|变量名|必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|商品编号|id|是|string(32)||商品编号|
|商品名称|name|是|String(256)|||
|商品数量|quantity|是|int|||
|商品单价|price|是|int|||
|商品类目|category|否|String(24)|||
|附加信息|addInfo|否|string(100)||内容自定义|

acqAddnData示例如下：

{

`  `"orderInfo" : {

`    `"title" :"日用品",

`    `"dctAmount" :"10000",

`    `"addnInfo" :"屈臣氏(人民广场)店"

`  `},

`  `"goodsInfo" : [

`    `{

`      `"id": "1234567890",

`      `"name": "商品 1",

`      `"price": "500",

`      `"quantity": "1 "

`    `},

`    `{

`      `"id": "1234567891",

`      `"name": "商品 2",

`      `"price": "1000",

`      `"quantity": "2",

`      `"category": "类目 1",

`      `"addnInfo": "商品图片 http://www.95516.com/xxx.jpg"

`    `}

`  `]

}

**银联付款方附加数据（issAddnData）**包含银联单品优惠信息，该字段为JSON对象，仅在银联通道有商品优惠时返回，商户需自行按照以下规则进行解析优惠信息：

|字段名|变量名|是否必填|类型|示例值|字段名|
| :- | :- | :- | :- | :- | :- |
|商品优惠信息|dctDetail|否|Object|示例见下文|商品优惠明细内容|
|自定义数据|customData|否|String（500）||自定义数据，具体内容及格式由付款方自行定义|

商品优惠信息dctDetail子域采用嵌套JSON格式，全部内容用“[ ]”包含，内部可含多个对象，每个对象用“{ }”包含，对象之间以“,”分隔；对象内可含多个字段，字段间以“,”分隔。

|名称|变量名|必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|商品编号|Id|是|string(32)||参与优惠的商品编号|
|优惠活动编号|dctId|是|String(40)||优惠活动的编号|
|商品优惠数量|dctQuantity|是|String(12)||参与优惠的商品数量，示例：本商品数量为10，其中2件参与了优惠，则本字段值为2|
|商品优惠金额|dctPrice|是|String(10)||商品的优惠金额，以分为单位，示例：商品单价10元，共5件，其中2件参与优惠，每件优惠3元，则本字段值为600|
|附加信息|addInfo|否|string(100)||内容自定义|

issAddnData示例如下：

{

`	`"dctDetail":[

`	`{

`		`"id": "1234567890",

`		`"dctId": "app012345",

`		`"dctQuantity": "1",

`		`"dctPrice": "500"

`	`},

`	`{

`		`"id": "1234567891",

`		`"dctId": "app012345",

`		`"dctQuantity": "2",

`		`"dctPrice": "1000",

`		`"addnInfo": "商品优惠详情http://www.95516.com/xxx"

`	`}

`	`],

`	`"customData" :"this is custom data filled by issCode"

}
### <a name="_toc440"></a><a name="_2.6.4.微信退款详情"></a>*2.6.4.微信退款详情*
微信退款详情refundDetail，本字段为Object对象，详见下文说明

|名称|变量名|必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|券 ID|promotion\_id|是|string(32)|109519|券或者立减优惠 id|
|优惠范围|scope|否|String(32)|SINGLE|<p>GLOBAL- 全场代金券 </p><p>SINGLE- 单品优惠</p>|
|优惠类型|Type|否|String(32)|DISCOUNT|COUPON- 代金券，需要走结算资 金的充值 型代金券,（境外商户券币种与支 付币种一 致） DISCOUNT- 优惠券，不走结算资 金的免充 值型优惠券，（境外商 户券币种与标价币种 一致|
|优惠券面额|Amount|否|Int|5|用户享受优惠的金额|
|优惠券退款 额|refund\_amount|否|Int|5|按比例退款的优惠券金额|

` `示例报文如下：

{

`  	`"promotion\_id":"109519",

`  	`"scope":"SINGLE",

` 	 `"type":"DISCOUNT",

`  	`"amount":5,

`  	`"refund\_amount":5

}


### <a name="_2.6.5.支付宝商品列表"></a><a name="_toc3994"></a><a name="_2.6.5 支付宝商品列表"></a>*2.6.5.支付宝商品列表*
支付宝商品列表goodsDetail，本字段为JSON格式，字段说明如下：

|名称|变量名|必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|商品的编号|goods\_id|是|string(32)|apple-01|商品编号|
|支付宝统一商品编号|alipay\_goods\_id|否|String(32)|20010001|支付宝定义的统一商品编号|
|商品名称|goods\_name|是|String(256)|Ipad|商品名称|
|商品数量|quantity|是|Int|10|商品数量|
|商品单价|price|是|Int|5|商品单价，单位为元|
|商品类目|goods\_category|否|String（24）|34543238|商品类目|
|商品类目数|categories\_tree|否|String(128)|124868003|126 232002|126252 004|商品类目树，从商品类目根节点到叶子 节点的类目 id 组成，类目 id 值使用|分 割|
|商品描述|body|否|String(1000)|特价手机|商品描述信息|
|展示地址|show\_url|否|String(400)|http://www.alipay.co m/xxx.jpg|商品的展示地址|

示例报文如下：

{

`  `"receipt\_id": "wx123",

`  `"goods\_detail": [

`    `{

`      `"goods\_name": "iphone 12 pro",

`      `"quantity": 1,

`      `"price": 52800,

`      `"goods\_id": "dsngjl9999",

`      `"goods\_category": "051051749871",

`      `"categories\_tree": "302598|3820518",

`      `"body": "特价手机",

`      `"third\_goods\_id": "1001",

`      `"show\_url": "http://www.123.com/xxx",

`      `"addn\_info": "【银联优惠使用】内容自定义"

`    `},

`    `{

`      `"goods\_name": "iphone 12 pro",

`      `"quantity": 1,

`      `"price": 52800,

`      `"goods\_id": "dsngjl9999",

`      `"goods\_category": "051051749871",

`      `"categories\_tree": "302598|3820518",

`      `"body": "特价手机",

`      `"third\_goods\_id": "1001",

`      `"show\_url": "http://www.123.com/xxx",

`      `"addn\_info": "【银联优惠使用】内容自定义"

`    `}

`  `],

`  `"cost\_price": 608000,

`  `"orderInfo": {

`    `"title": "日用品",

`    `"dctAmount": "10000",

`    `"addnInfo": "屈臣氏(人民广场)店"

`  `}

}

### <a name="_toc25456"></a><a name="_2.6.6.数字人民币优惠详情"></a>*2.6.6.数字人民币优惠详情*
数字人民币优惠详情ecnyPromotionDetail。**注意此字段返回的是Array格式的字符串**

|名称|变量名|必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|营销活动运营机构|promotionGenInstId|是|String(14)|C1030844001362||
|营销活动编码|promotionId|是|String(32)|010Y8S001D||
|营销活动名称|promotionNm|是|String(60)|元初到家支付立减||
|营销活动描述信息|promotionDescInfo|否|String(256)|立减6元，每个钱包1次||
|营销活动类型|promotionType|是|String(4)|PT03|取值如下：<br>PT01:红包<br>PT02:消费券<br>PT03:满减<br>PT04:立减<br>PT05:满折<br>PT06:随机减<br>PT07:积分消费<br>PT99:其他|
|权益id|couponId|是|String(64)|Y8S001||
|权益有效期|couponExpiry|是|String(19)|2023-11-30T23:59:59|格式：yyyy-mm-ddTHH:MM:SS，其中的T为日期和时间的分割符|
|权益金额币种|couponAmountCcy|是|String(3)|CNY||
|权益金额|couponAmount|是|String(18)|0\.96||
|权益退款属性|couponRefundProperty|是|String(5)|CRP04|取值如下：<br>CRP01:优先退权益<br>CRP02:等比例退权益<br>CRP03:仅整单退权益<br>CRP04:不可退权益|
|权益描述信息|couponDescInfo|否|String(256)|立减6元，每个钱包1次||
|备注信息|remarkInfomation|否|String(128)|||

## <a name="_toc5036"></a>2.7 字段说明
### <a name="_2.7.1_终端信息terminalinfo"></a><a name="_toc21295"></a><a name="_2.7.1 终端信息terminalinfo"></a>*2.7.1 终端信息terminalInfo*

|名称|变量名|必填|类型|示例值|描述|
| :- | :- | :- | :- | :- | :- |
|终端实时经纬度信息|location|否|String(32)|+37.12/-121.213|受理终端设备实时经纬度信息，格式为纬度/经度，+表示北纬、东经，-表示南纬、西经。终端类型（device\_type）填写为04、09或10时需上送|
|终端入网认证编号|network\_license|否|String(5)|-|银行卡受理终端产品 应用 认证编号。该编号由“中国银联标识产品企业资质认证办公室”为通过入网认证的终端进行分配。格式： 5 位字符，例如 P3100|
|设备类型|device\_type|是|String(2)|01|招行为商户每个终端设备配置的终端类型，由招行业务人员单独提供，取值如下：<br>04：智能POS<br>09：刷脸付终端；<br>10：条码支付受理终端；<br>11：条码支付辅助受理终端；|
|终端序列号|serial\_num|否|String(50)|-|出现要求：终端类型（device\_type）填写为04、09或10时，必须填写终端序列号。|
|终端编号|device\_id|是|String(8)|Sxxxxxxx|终端编号，招行为商户每个终端设备提供的唯一编号，由招行业务人员单独提供。|
|加密随机因子|encrypt\_rand\_num|否|String(10)|-|仅在被扫支付类交易报文中出现：若付款码为19位数字，则取后6位；若付款码为EMV二维码，则取其tag57的卡号/token号的后6位|
|密文数据|secret\_text|否|String(16)|-|仅在被扫支付类交易报文中出现：64bit的密文数据，对终端硬件序列号和加密随机因子加密后的结果。本子域取值为：64bit密文数据进行base64 编码后的结果。|
|应用程序版本号|app\_version|否|String(8)|-|终端应用程序的版本号。应用程序变更应保证版本号不重复。 当长度不足时，右补空格。|
|商户端设备IP|device\_ip|否|String(40)|-|商户端终端设备 IP 地址。终端类型（device\_type）填写为04、09或10时，且经、纬度信息未上送，该字段必送。|
|移动国家代码|mobile\_country\_cd|否|String(3)|460|中国为460|
|移动网络号码|mobile\_net\_num|否|String(2)|||
|ICCID|icc\_id|否|String(20)|-|基站信息，由国际电联(ITU)统一分配的移动网络号码（MNC）。|
|位置区域码1|location\_cd1|否|String(4)|-|移动：00、02、04、07；联通：01、06、09；电信：03、05、11|
|基站编号1|lbs\_num1|否|String(12)|-|SIM卡卡号|
|基站信号1|lbs\_signal1|否|String(4)|-|LAC(移动、联通)， 16进制|
|位置区域码2|location\_cd2|否|String(4)|-|CID(移动、联通)， 16进制|
|基站编号2|lbs\_num2|否|String(12)|-|SIG(移动、联通)， 16进制|
|基站信号2|lbs\_signal2|否|String(4)|-|LAC(移动、联通)， 16进制|
|位置区域码3|location\_cd3|否|String(4)|-|CID(移动、联通)， 16进制|
|基站编号3|lbs\_num3|否|String(12)|-|SIG(移动、联通)， 16进制|
|基站信号3|lbs\_signal3|否|String(4)|-|LAC(移动、联通)， 16进制|
|电信系统识别码|telecom\_sys\_id|否|String(4)|-|CID(移动、联通)，16进制|
|电信网络识别码|telecom\_net\_id|否|String(4)|-|SIG(移动、联通)，16进制|
|电信基站|telecom\_lbs|否|String(4)|-|SID（电信），电信系统识别码,每个地级市只有一个SID|
|电信基站信号|telecom\_lbs\_signal|否|String(4)|-|NID（电信），电信网络识别码,由电信各由地级分公司分配。每个地级市可能有1到3个NID|
|终端位置国家编码|country\_no|否|String(2)|CN|所属国家（或地区），参照《GB/T 2659世界各国和地区名称代码》，终端类型为04、09或10时且可获取时填写|
|终端位置地区编码|area\_no|否|String(6)|440106|境内所属省市地区，参照《GB/T 2260中华人民共和国行政区划代码》，终端类型为04、09或10时且可获取时填写|
### <a name="_2.7.2_合约请求内容contractreq"></a><a name="_toc27059"></a>*2.7.2 智能合约请求信息*
#### <a name="_2.7.2.1合约收款请求内容contractreq"></a>2.7.2.1合约收款请求内容contractReq

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|客户ID|customId|String(64)|是|客户ID|
|订单号|goodsOrderId|String(128)|是|订单号|
|商品信息|goodsInfos|List<Goods>|是|商品信息|
|订单总金额|goodsOrderAmounts|BigDecimal(18,2)|是|合约订单总金额|
|延迟清算时间|delayTime|Integer|是|延迟清算时间|
|延迟时间单位|timeUnit|String(8)|是|day，hour，minute|
|分润清单|benefitList|List<Benefit>|是|分润清单|
|商品信息Goods：|||||
|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
|商品描述|goodsInfo|String(128)|是||
|商品金额|goodsAmounts|BigDecimal(18,2)|是||
|分润信息 Benefit：|||||
|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
|分润钱包|benefitWalletId|String（16）|是|分润钱包ID|
|分润比例|percent|BigDecimal(18,2)|是|分润比例,例如10%要填写为0.1，并且所有分润比例之和要为1|

#### <a name="_2.7.2.2_合约收款响应内容contractresp"></a><a name="_2.7.3_合约响应内容contractresp"></a>2.7.2.2 合约收款响应内容contractResp

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|客户ID|customId|String（64）|是|　|
|合约ID|contractId|String（64）|是|　|
|订单号|goodsOrderId|String（128）|是|　|
|商品信息|goodsInfos|List<Goods>|是|请求时上送的商品信息|
|合约控制金额|contractAmounts|BigDecimal(18,2)|是|　|
|延迟清算时间|delayTime|Integer|是|　|
|延迟时间单位|timeUnit|String（8）|是|day，hour，minute|
|分润清单|benefitList|List<Benefit>|是|请求时上送的分润信息|
|合约生效时间|startTime|DateTime|是|yyyy-MM-dd HH:mm:ss|
|合约分润执行时间|executeTime|DateTime|是|yyyy-MM-dd HH:mm:ss|
#### <a name="_2.7.2.3_合约退款请求内容contractrefundreq"></a>2.7.2.3 合约退款请求内容contractRefundReq

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|原订单号|goodsOrderId|String（128）|是|　|
|原始订单合约ID|orginalContractId|String（64）|是|　|
|商品信息|goodsInfos|List<Goods>|是|　|
|退款总金额|refundAmounts|BigDecimal(18,2)|是|　|

#### <a name="_2.7.2.4_合约退款响应内容contractrefundresp"></a>2.7.2.4 合约退款响应内容contractRefundResp

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|原始合约ID|orginalContractId|String（64）|是|　|
|原订单号|goodsOrderId|String（128）|是|　|
|商品信息|goodsInfos|List<Goods>|是|　|
|退款总金额|refundAmounts|BigDecimal(18,2)|是|　|
|合约控制金额|contractAmounts|BigDecimal(18,2)|是|　|
### <a name="_2.7.3数币支付参数ecnypayment"></a><a name="_toc5610"></a>*2.7.3 数币支付参数ecnyPayment*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|交易类型|transactionType|String(4)|是|TT01:扫码支付<br>注：目前仅支持TT01扫码支付，后续可能支持其他类型的支付|
|受理终端编号|terminalNo|String(32)|是|禁止中文|
|受理终端IP|terminalIp|String(64)|是|禁止中文|
|商品名称|goodsName|String(40)|是|例如：xxx赛事-购票。如北京2022冬奥会-购票。注意：不可使用特殊字符，如/，=，&等|
|订单详情|orderDetails|String(1024)|否|商品详细描述|
|网络交易平台名称|platformName|String(40)|否|当商户类型为网络特约商户时必填|
|交易地点|tradePlace|String(128)|是|实体特约商户填写商户受理终端布放地址，网络特约商户填写网络交易平台网络地址|
|订单失效时间|orderTimeExpire|String(19)|是|订单失效时间时针对订单号（收款运营机构生成的订单号）而言的。格式：yyyy-mm-ddTHH:MM:SS，其中的T为日期和时间的分割符，是必需的。禁止中文|

### <a name="_2.7.4_交易地址信息tradeaddressinfo"></a><a name="_toc13613"></a><a name="_2.7.4 交易地址信息tradeaddressinfo"></a>*2.7.4 交易地址信息tradeAddressInfo*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|手机号|phone|String(11)|否||
|IP地址|ip|String(40)|否|<p>IPV４：点分十进</p><p>IPV6：冒号分十六进制</p>|
|MAC地址|mac|String(17)|否|MAC：冒号分十六进制|
|设备信息|device|String(128)|否|<p>Json格式字符串。</p><p>{</p><p>"type": "Android", // 类型。如:Android、Apple</p><p>"deviceId": ""//设备号。如：Apple设备的特殊识别码IDFV、Android设备唯一标识AndroidID</p><p>}</p><p>AndroidID：16进制的16位字符串</p><p>UDID：16进制数的40位字母和数字</p>|
|终端号|terminal|String(64)|否||
|经纬度|location|String(32)|否||

### <a name="_2.7.5 商户营销信息paychannelpromoinfo"></a><a name="_2.7.5 商户营销信息channnelinfo"></a><a name="_4.4.8 运营展示数据viewdata"></a><a name="_2.7.5 运营展示数据viewdata"></a><a name="_toc21024"></a>*2.7.5 商户营销信息PayChannelPromoInfo*

|**变量描述**|**变量名**|**类型**|<p>**是否**</p><p>**必填**</p>|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|渠道名称|channel\_name|String(512)|否||
|渠道可用性标识|channel\_enable|Boolean|否||
|渠道信息|channel\_operation\_info|String(1024)|否|<p>支付时需要带回的渠道信息，在调用预创建交易接口时通过支付宝接口“businessParams”字段的二级字段“channel\_operation\_info”传递商户前置内容咨询接口返回的channel\_operation\_info内容。传递内</p><p>容示例如下：</p><p>"businessParams":{"channel\_operation\_info":"#{UCBJeS6DV4wrBfYWZf32QQr0JBQLvm}#"</p>|
|营销模型|operation\_list|viewData[]|否|[2.7.6 运营展示数据viewData](#_2.7.6 运营展示数据viewdata)|

### <a name="_2.7.6 运营展示数据viewdata"></a>*2.7.6 运营展示数据viewData*

|**变量描述**|**变量名**|**类型**|<p>**是否**</p><p>**必填**</p>|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|运营文案描述|operation\_tip|String(65535)|否|示例：花呗立付|
|运营主体|operation\_desc|String(65535)|否|示例：花呗立付立减优惠|
|营销类型|promo\_type|String(128)|否||
|渠道或者优惠的图像表达url|logo|String(256)|否|http://xxx.xx|
|运营活动定价|promo\_price|String(11)|否||
# **3.业务流程**
## <a name="_toc6084"></a>3.1场景介绍
**1、收款码-主扫支付使用场景：**

步骤（1） ：如下图，商户根据聚合收单平台的规则，在POS终端或PC端向平台申请商户动态二维码。

![](data:image/png;base64,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)

步骤（2） ：如下图，用户使用第三方APP(微信、支付宝、银联钱包等)扫描二维码后，跳转到商户信息确认页面，用户确认商户信息无误后，点击确认付款。

![](data:image/png;base64,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X301AwMD3HzzzWzZsoXBwUGSySRKKTo7O9m0aROu65aEIJ1Ol8aCmzZtore3l9WrV7NgwQI2btzI7bffjjGGtWvXcuWVV5Zc5p111lksWbIEYwyO43Ddddfx1FNPsXfvXi677LJQyM4IBFJbIDR5YehwHL7wn78j52u++oF3MN81RIQu9OZO7nmflLDltWHDaz2MmigdfUM82TdI1BpkyK7FwyGuh7GNR13MnTJhA3Ach2uuuYZ77rmH9evXs3///nHWtkUT9G9+85vce++91NfXc/311/PQQw+xfPly4Khjlq6uLp577rlxvjl832fVqlUlPxV33nknPT09NDc38+1vf5uFCxdy9tlnY1lWyTNufX09l19+eUnrxWIxtNbs37+fe++9l7KysmN8U4SchhgQRiKEQQODGvYOjmC0YMjX+EgcGWwlOdmnfVLCVmEZ/tcti8mu6edg+xCfvGEJF9TFKbMtDCBN0I2MO5E3V7FJKHqX6ujoYNOmTeMcaI5NI6XkrrvuYuvWrXiex9q1a7n44otL/kaEEAwPD3P11Vdzyy234DhOSdg8z8NxHKSU3H333axZs4a+vj6i0Sif/exnWbNmDcuWLRt3veeee47Ozk6efvpprrnmGmpqapg9ezatra0lp0ghZwDCoC0fLWwiSrJYK755y3koH5bZgjgWPgIjfCTypLTbSU39C0syLwJfubyc+TWa//htB60DGWzXpioCiViceLwMx56aN3pxrDhv3jxqa2tZv349g4ODrFixomQGX0xTV1dHS0sLlmURj8dxHIc5c+aUHPoAvPLKK5xzzjlEIhFc1y19iult2x7nv8QYQ0NDA3fccce434rjsNraWhKJBNFolJaWFh566CE+9rGP8Y1vfKPkWzNctD/9ESbYCGnQ2LbPWc3lnDWnHNfVaBTSCGytp2adreRcUthI12Feucvf37gMK+HypV900T3iIdQQCB9QWMI/5YmBYqO3bZv58+fzhS98gc997nPcfffdPPvsszz88MOUlwdd1eKYadmyZSxfvhzP8zjnnHPYvXs3W7duRQhBd3c3jz/+OM3NzbiuO86pZtGXJBwN5lD8DA8P86Mf/Yh//ud/LrmQU0qxceNGampqyOfzvO997+M73/kOF1xwAddeey1XXXUV3//+90vuzEJOZwRCSYQ2+FJzRFh8fd1m/u6pl2nT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lZVIcbQMSikcx3nzjyhk5mBOAa210cYzvp81npczW7a/Zm6/42Pm6hv/wGzcutdkcznj+57J+XnTmeoxf/KJz5nLr7nLPPnbZ81oNmd87RutldFaT5p/Nps1z6572Vx+5XvN//z0l83h7gGT9fMmp3Im62VNT1+/+V9f/mdzydV3mF/9dq3Jq7wxShvfy5me3n7zJ5/4a3PZte81v35yvUmPjJislzU5zzcjozmzecsec93v3WNuuu1/mB179hmtPWN03hhzbFmUUkbprOnpTZmP/tFnzdXX3GGe/O2zJj08arL5nBnJpk1rR5f5+Oe/Ys675Abz04efNNlMxqh81mjfNyP5rPmXb//QXHL1e81XvvYNc6QnZUYyQVkGh0fMfz70mLnsmtvMJ//ib83IaM54nmd83ze+75vR0dFTeUQhM4hT6qsIIRDYSOliWQ5LF83hLz75pyhP8o1v/X8MpjNkM6NkRnM88MAvefXVHdx++3W8+10XEnHsQrfteF03g5CCbNbjA3e8n0/86YeprYzgSAtbWNhSUpGMcstN14IS7Ni2B2MkyKBrtnvvQbbu3Mcdd97G5RevIu5EcYWLIyQx12HFskX81efvZdnihezZ9RrBDM3kZVFGozQ8/pvn2L23jRt+7zouvfh8YlEX13aIuWU01dfyxb/6OE3NDTzy6JOMjGQDh7PaZzST57GfPUVTXQMf/fAHqapIEnUdXNuivCzOLddfyTvOXc2mzbs42HYEI4rj4dcPoh5y+jClAwMhNWevXMRHPnInmze9yje++T1GMj6//vU6fvLA47zrnZfwwT+8BduxAkF9nYakjc/lV17ER//oTubNbwYUEh9JMCMosZACLNvgugVhMYK8Z1i79gWyI0NcfeUlWK4G4WOMF3y0hxCKCy9ZwVe++pfceNPVwQXNxJnIQr2MID2a5bFfPk48HuWuO99DJOKOWwuTQuLYFhdffAEHDh6gf2AYg8TzFevWrqcv1cf1111JeXkSy7LGnGuIRB3e9773oJTi33/8ACbcNHJGMiXux7XWaK2RtkUiYfP+269l/97X+PWTa6koT/L008/S2FzPpz/1p5QnoiilEBiEECf09ei6DmAw2iCMQRgLXZjOz+c98nnFumdfQJs8K1edjRAmOKY0W7ZsZ86sZubOno0xhiO9AwwODJH38sTjcRobG3BiEqMV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)

步骤（3） ：如下图，确认订单信息和付款方式后，点击立即付款。![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAANwAAAGHCAYAAADbZDwBAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAOxAAADsQBlSsOGwAAIABJREFUeJzsnXmQHFd9+D/vdffcO7O39pa0klayLdmWJctYIkgQ8EHMFQIYhzNAAXaKJI5DJcCvDEUIsQEHCpIqjgJCgoOJOSrGB8aWbSz5kCzJlmRJ1rGS9pD2PmZm5+ru935/9MxoV7uy13i9lkR/qqa0mul+/V73+/b3ve/7vu9XCCE0Pj4+84IAfIHz8ZknTCHEq3oBIQSlayilXnF5UkqEECil0PqP510hpZzx/s30/LTWCCHOmfsjpZxW19J3k9sspQQot630MQyjfNxct1kIgWma2LY9q7INw0BKieM4M/5uvtoPJRAIAOC67pzcDMuyMAyDfD5/xkadywghpnRArTWmaQLM+JIpvdBKQialLD/wUoc8mxFCkEgkCAaDJJNJXNctf5dKpchms2VhMk2TUChEc3Mzvb29BAIB6uvrmZiYoLe3F6Dc7rkiFAqVhW42CqN0nJSSfD4//fdXS8NZloXjOHzuc5/j+eef5xe/+MWMb+PZIqUsv8nuuecebrzxRg4fPlz+vfRmAU+4SzdHCIFhGOVO6boupmmWH2zp+FJnfa01p2EYRCIRQqEQQ0NDGIZBfX09S5cuZceOHdM6YE1NDblcjnQ6jRCCjo4OAoEABw4cmPGBn21IKfnYxz5Ge3s727Zto7m5mUOHDnH11VezZ88e/v3f/x3btgHv5fOud72Lm2++mT/7sz/jS1/6Es8++yyrVq3ijjvu4PDhw5imWX4RW5ZVPq/0TCf3kckvq9ILa/LzF0LwkY98hNraWpRSU/qvYRiYpjmtT5eE7YknnuD++++f1t5pGk4IURYWy7KmXEhr/aJvkFKnF0Lwb//2b3z2s59l8eLFjIyMTGl0SQAmN3Cmt0cwGCw3YunSpbzjHe/gtttuY8WKFUSj0fJNCgQCXHnllVxzzTUEAgHuvPNOduzYgRCCuro6/u7v/g7HcTAMg6985Svceuut/Mu//Avve9/7GBsb49e//jVtbW3ccMMN3Hbbbdi2jZSy/FDmSju/FFJKNm3axGc+8xn27t3LV77yFVavXs1NN93Evn37uPHGG7n55psZGBhASskHP/hBPvGJT/C1r32N++67j5tuuoklS5aQTCbp6+vjP/7jP8jlcq96vV8pK1asoK2tjfe85z387Gc/43Of+xz3338/7e3txGIxRkZGkFLS1NTEypUriUQivPGNb+TRRx/l5z//OfX19RiGwaJFi6ivr2fr1q1YlsUdd9zBwMAAtm3z05/+lA9+8INEo1GklHzrW9/iqquuora2ls7OTg4fPsx1113Hd77znfKLSkqJZVncfvvtFAqFcn8zDINly5bx/e9/n0gkMqUtSimef/55LrjgAu67775pbZWnf1HqWF/84he56aabaGtr45vf/Cb33HMPN998c/mtMRPXXXcdH/jABzBNk/Xr12MYxowddfXq1fz4xz/m7rvv5pprrikL1kx1+cY3vsGaNWtIJBKsXbt22hulJKxve9vb+MY3vsFdd93Fpz/9aQzDACCTyfDd736XO++8kyuuuIJYLEZdXR1vf/vbicfj/OY3v8EwDDZu3MjTTz/Npk2buOOOO7jxxhsJh8PzOhfSWnPs2DFuu+228lvadV1uvfVWvv3tbxMIBLjkkkv4/ve/T21tLU8//TS//OUvcRwHIQSXXXYZDz74IPfccw8rVqyYlzrPBU899RTr1q3Dtm22bNmCaZpcc801PPbYY6TTacB7+f7TP/0TDz/8MKZploecGzdu5K677uI973kPX/jCF3jd615XLjcUCnHvvffys5/9jFQqxT333MP3vvc9MpkMiUSC6upqnnrqKVauXMlf/MVf8MMf/pBCoQB4wnbTTTfhuu6UupaEzjRNVq5cyapVq6Z92tvbzzj8lCVNU/qYpsm6detob2/Htm2uvfZavvvd7/LBD36Q5557Djg1TAsGgxiGwf/+7//S1NTEsmXLuOCCC1BKlbXjZAzDoLKyks985jPceuutfOpTn6KqqgqlFKZpYllWeZz+ne98B601GzdupK6ubppKL9WjVJfq6moKhQJHjx5lwYIFBINBTNMkm81imiaf+MQnOHjwILZt09HRwXvf+17Gx8fRWiOlpKOjg8cff5x3vetd7N69my1btpS17+n36NX6ABw9epRCoYBSCsdxeOaZZ+jq6mLt2rX09vbyzDPP8NWvfpXh4WEOHDgwZUh077338uEPf5i/+Zu/Yfv27VNGEmfzp6Ojo9zJe3t7+da3vkVfXx/t7e1TnnNfXx8bNmzANE1GR0e5+uqr6ezs5Kc//Smp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)

步骤（4） ：如下图，用户输入密码（非免密交易）授权第三方动账。

![](data:image/png;base64,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6OzsRGvNpk2bWL16NVJK2tra8Pv9NDY28swzzyCl5Itf/CKJRIJHHnmEhx56aFRgIKUUv/rVr1i6dCmPPfYY9957b7EOhbHeU089xbe+9a3id67rsn79eoQQLFu2jAcffBDTNDl8+DDf+973uOiii7jooot46aWX+MhHPkJFRQWtra10dnbyiU98AsvKJTRZv349K1asYGBgACkloVCI5557jve///1s3rwZv9+PZVkkk0nuu+8+enp6+N3vfsePfvSjYnRo13WJRCLYto2U8rzviM+UUz6dkY6DyspKqqqq8mHoxpdi6lSerJED8sJ1Rn7G+u74QfybiWEYzJ8/n3vvvZdsNsvKlSuLZlMwGCQajeK6LjNmzOCGG24oarqXXnqJBx54gG3btvHRj36U2bNnc/ToUdatW8fg4GDRVC08g76+Pl555RU+8YlPsHHjRo4cOYLr5hJECiGwLItbb72Ve++9l1WrVrF27Vo2bdrE888/z9VXX82KFSvQWmPbNlu3buVrX/sa0WiUQCDA7NmzeeSRR4rPq+BEEUKQzWb58Ic/TDweZ/v27dx///1ccskl3HPPPaxbt46VK1diWRYdHR089dRTtLW1cffddzNjxgyy2SxlZWXcf//9fPnLXyYej/O5z32ORCLxpr+Xc5031HBCCGbMmEFHRwf79u1j7ty5b0ovdrwQj5xyGPnbW+WgEUKwb98+li5dSiyWSyXV399PU1MTkEs1dd999/Hoo49y44038uCDD/Laa6/R3t5+0jIzmQzf+ta3uPHGG1myZAmf/vSneeSRR/inf/onTPP1VyOl5KqrruI3v/kNzzzzDGvWrGHt2rUkEgk+8IEP4PP5UEpx0003kclkeP755wG48cYb2bp1K6+++ip1dXWjrr1161YeeeQRLr30UlatWsWmTZvYunUrlmVRXl7OwoULWbFiBVJKstksN9xwA7W1tUQiEaSUfOELXyjWTUrJRz/60WJH4XFyTilwhYZuWRYrV65k69atHD58mBkzZhQ9lMdzJgJxts3rFaYBHMdh586dxbFPOBweZRIqpdi/fz8///nPef7559mwYQOO42DbNv39/cDoeyu49//7v/+b/v5+rr32Wvx+P9dddx3PP/88P/nJT/jQhz5UvEYhuO6dd97JXXfdxWOPPUZlZSV33313UVsWxoOO4xSdWYZhcMcd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i8W45557Slpw+as5MpkMW7Zs4dFHHyWVSlFdXU1nZyfRaJTLLruMc889l0gk4tXopYLrIyklmUyGl156iWeeeYZUKkVVVRUdHR1Eo1G+/OUvc8EFFxAOh30Xna+Cc5cF7dq1i/Xr19PS0kJVVRVtbW2DClwpY9s27e3t/PSnP2Xx4sVcffXV1NbW0tfXx89+9jPWr1/PKaecQm1trd+m+objOHz66af87Gc/49RTT+XKK68kkUjQ09PDQw89xM9//nNOO+20QPjI176IlBLHcdi8eTOapnH33Xdz+umnK7Hl4TgOTz/9NFVVVdxyyy3MmjWLeDzOtGnT+Na3voXjOLzxxhsl77Pdu3dz8cUX87WvfY1p06YRi8Wor6/nhhtuoKenh23bthGEnTG+tnBCCIQQXHzxxdTW1qqFwnm4K/GllKxcuZKzzjqLWCzmBU0cx0HXderr60kmkyUpOLecGIbBn//5nw96zR2quEGUysrKQJQr30fbmqZRV1eHruuBcEjQMAyDFStWsGDBAi84omkaQggOHjzIJ598wsKFC0tu/DYWUkra29t5+OGHqa+vZ/ny5YEoX763cIZhHPY7RQ4hBLque2JyWzzbtunt7eWBBx5g5syZLFmyREUqB2htbeWuu+6io6ODrq4uZs6cye23304oFPJ6DeBfOVNP6RjCFVwymeQXv/gFn3zyCV/96lfRNC0Q45MgEA6HOfXUUznnnHM455xz0DSNDRs20NvbGwgf+T4toBib/EndTCbDL37xC1555RVuuukmTjjhBK+LWepIKUkkElx22WVeQO7gwYPceeed3H///dx2223E43FfbVQtXMBxWzXHcUilUjz44INs2rSJm2++mZNOOoloNEo4HC7pLqVbEZmmia7rhMNhIpEIsViMhoYGvvSlL/HOO+/Q2trqt6lKcMcKpmmyYcMGtm7dynXXXccXvvCFkhZZPt3d3bzwwgsjzt/G43GklKTTaR+sG4x6YgHFbdmklPT39/PTn/6U119/nZtvvpnTTjvNC6bYto1lWTiO472/VHC/byqVYuPGjWzcuJF0Oo1lWZimSTabJZVK8cc//pFwOExVVRXgb2BOjeECTiqV4uGHH+b555/nz/7szzh48CBbtmzxCo2UknA4zMqVK4lGoz5b6w81NTVcc801/Pu//zumaXLVVVdRXl5OMpnkscce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)

步骤（5） ：如下图，第三方支付完成后，通知用户APP显示支付成功。

![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAANwAAAGGCAYAAAAQOO+kAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAOxAAADsQBlSsOGwAAIABJREFUeJzsvXlwXcWZv/90n3P3TbtkWfK+YjbbGMwSsyYBJvPLMkkMKVIhYSkIGWAokmEy8y1CBsgybEWGkBAKKKZIXBDiCpNJMkOAEIOxMbbxCt7wLtnar+7V1V3O6f79cXUuki0bGcuybPqpurake5Y+5/TnvN1vd7+vEEJoDAbDMUdrLQRgBGcwjAzCFkIc2zMIgXcOpdRRH09KiRAC13WP+lijFSEEWutD/n6offrzUdsfbyzLGrQ+aK1L1yKEKG3j/c373rsn3v/9fx7ucgI4jjOk7X0+H1rrQeun1hr7WD+YQCBQKsBwnMvn82HbNr29vSel6PoLp3/l6l+xvO/gwxdQ/31s28ZxnAHbjzaUUliWhWVZVFRU0NXVhVIKIQTRaJRcLkdPT8+A8tu2jRCCQCBARUUFfr+fVCpFd3c3juPguu6wvNQ9LMsiEAgghBiy4DyBZrPZQevnMbFwQgh8Ph+FQoEf//jHvPrqq/zP//zPQW/hI0FKWbqY559/nm984xu0tbWVvrcsCyll6SK9bZVSKKVKldeyrFI5vG29ymxZVunGDqdVHirefauurqa1tZV8Pl8qc0NDA62trWQymQGVMBwOU19fz+7du1FK0dDQQGVlJevWrSOfz49o+Y8E73l+7Wtf46KLLuKVV15h0qRJbNu2jdmzZ5NKpbj33ntL5ZdS4vf7+dSnPsUNN9zA1KlTSy/eV199lccee4zm5ubSS6Z/fTnw+WutcRyn9H1/C9lfJLW1tdxwww24rnvYuusZAe9Y+XyeRx99lK6urgHbDWrhvIfuui62bZfeOt4O3ptzMLw3kJSShx56iO9+97tMnDiRmpqaAW9bb7v+N+PAiuG9yTzrOH/+fObNm8ejjz7KtGnTSt9521144YV8/etf5wc/+AEAt99+O+3t7ezZs4fnnnuOfD5PNBrltttuw7IsotEoDz30EJ///Of57W9/S2NjI5/73Od48MEH0Vpz/fXX89xzz5FMJkvncRznmFZgn8/HnXfeyRe+8AUWLlzI9u3bsSyLiy++mCeeeIIbbriBN954A9d1kVKilOLWW2/lxhtv5Morr6S+vp5rrrmGzZs3c+edd3LTTTfR0dFxzMp7NGitS88tGAzy2GOP8dOf/pRHH32U1atXs2PHDiorK9m3bx9aa2pra/m3f/s3LMti0aJFA+plOBzmZz/7GS+99BLPPPMMhUKB8ePHc+utt5JKpejs7OTpp5/m6quvpra2loqKCh577DG++c1v4jgOv/3tb5k6dSpNTU2sWLECKNbL8vJynn32WXbu3HnY537fffdxxRVXlPZ79dVXCYVCdHZ2HrStHOxGCCG49957ufnmm5k4cSKPPPIIixcv5vbbby8peTC+8pWvsHDhQnw+H+eccw5SHnR4AM455xyeeeYZfv3rX3PxxRfj9/sHfSCu6/KrX/2KGTNmUFNTwxlnnHHQdt5bqaOjgz179hAKhWhoaGDv3r0sWrSI888/HyklWmtqamooLy/n/vvv57XXXuPss8+murqaSZMm8d3vfpcnn3ySTCbD2LFjaWhowLIs7r33Xn70ox9RUVFxVBZ6KDiOw/PPP8/f/va30pu2oqKCO+64g9///vc4jsMFF1zADTfcgJSSefPmMWXKFAqFAlJKGhoaePnll1m8eDHxeJxAIHBMy3s0uK5LLpdj0aJFXHnlldi2zV/+8hdc12Xu3LksX76c9vb20ks6nU7z8ssvs3LlSm699VY+85nPMHPmTK655hquuuoqHnjgAbZs2VK6b+3t7fznf/4nixYt4rzzzsPv97Np0yYeeeQRenp6WLBgAZ2dnWzfvp1LL72UK6+8ktWrVwPF5zBnzhyuuuqqIT3zhoYGTj31VE499VRmzZpFZWXlIbeV/fsIQghs22b+/Pk0NDTgOA5XXnklP//5z7n22mtZt24dQMk0BwIBbNvmd7/7HdXV1UyfPp2pU6eWrOOBltCyLCorK7njjjv4/ve/z+233059fX2p3+GZ5vr6eh555BGUUlx66aUkEokBnWkPrynoui6rV68ubdPW1sYll1zCTTfdxO7duxFClNr7U6dO5fLLL+fqq69mypQp+Hw+HnjgAQC6uroQQnDJJZewZMkSamtrsW2bZ599ttQHPfB+DedHa8327dtLzyEajXL11Vfz+OOP09raihCCNWvW8NJLL2FZFrfccgv33XdfqT+0fv16brnlFv7f//t/7Nmzh97e3mNa3qP5ePVjxowZpWZeZ2cnP//5z9m2bRszZ87EcZzS9r29vbz22msAPPDAAwSDQS655BLWrl3LfffdR6FQYOvWrdi2jZSSnp4ebNvm29/+Ntu3byebzbJs2TIaGxtJJBIsXryYZcuW0draSjQa5YUXXmDhwoWEQiGklEyZMoV4PD7kZy6lLL3YvX71gR8A6TX1+rd9v/KVr/D000+jlCIQCNDW1sbFF1/MggULShVjzpw5fOtb38KyLE4//XQCgUDppB6DddrD4TBNTU2k02muuuoq5s2bVxLPXXfdxdlnn00wGGTatGnFAvY73oGC846vlCo197zm5w9+8APuu+8+ysvL8fv9JUv485//nEgkwpIlS2hqagLgrrvu4q233uL6668nEokwefJkVqxYQTKZZMWKFXz9619n3LhxpRt6LD9eExtg+vTpfO1rX2P69OmceeaZXHbZZfj9ftLpNJdffjnBYJDPfvazBAIB5s2bx5e//GX+6Z/+idtuuw0pJWPGjDnm5T2a61RKsWbNGnK5HFJKHnvsMS644AIikQgrV64ccL9d1yWTyfDcc88xfvx4li5dygsvvEBvby/xeJxMJsONN95YqoPjxo0jk8lwzz33EIlEqKioYPbs2dxwww089NBDpFIpli9fjpSSXC7HwoULcV2XL33pS9i2zRtvvMGyZcsGOKsO9XFdl0KhUOozey/nAz+DWjghBJMmTWLhwoV8+tOfJhaLMWHCBJYvX05XV1dJvfX19Zx99tmDngA+dDYcKLq2tjamTZtGdXU1L730EvPmzStVsosuuohx48aVLkIIMeA4Xru9fye4/6enpwelFFu3buWmm27iqquuIhgMIoTgn//5nwG4+uqrqaioYMGCBSxbtoz29nY2btzIE088wZQpUygvL2fbtm10dXUxc+ZM5s6di1KKWCxWEv2x/ECxueW6Ltu3b+eWW27hb3/7G7t372bTpk1ceOGF3HbbbSxbtowf/ehHrFixAiEEO3fupFAoUFlZSTweJxaLDbAQo+3j+QPWrFnDa6+9Rk9PD/PmzePMM8/kvffe47//+78HPGMpJY7jkMvl+NWvfsXEiRO55ZZbWLt2LX/9618JhULkcrnSsaurq/n3f/93vvGNb1BeXk5PTw/f//736enp4ctf/jITJ07E7/czZ84cnn32WSzL4rTTTqOpqQnXddm7dy+rV68mHA5TUVFBZWXlIT+rVq3iN7/5DYsWLWLRokVs3rx50PoJcNDA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b775JgCnnHIKjz/+OIFAgF27dvHLX/6SqVOncvrpp7N06VK++tWvUlNTw759+9i6dSs33ngjgUCA7u5uli5dyo033kgymURKWXoh/MM//AObN28mnU7j9/vp7e3l7rvvprm5maVLl/LUU0+VLLDjOASDQQqFApZlDcuL+GTmsHfH69zv2rWLqqoqqqurkVIOSXAHerEO1fQcbLsD9zmaY32cc2qtkVIydepU7rvvPnK5HPPmzWP8+PEAJWvlOA5jx47lC1/4Aj6fj1wuxyuvvMJjjz3GqlWruO6665g2bRq7du3i9ddfJ5lMloTmNcfT6TTLli3jxhtvZN26dWzduhXXdUv3WErJV7/6VR588EHmzp3Lq6++yooVK3j11Ve54oorOOecc5BSUigUWLduHXfeeSfl5eUEAgEmT57MY489Vrqm/g6TQqHANddcg+u6rF+/nocffpgZM2bw8MMPs3r1ambOnEl5eTk7duzglVdeYevWrdx9992ccsopZLNZEokEDz30EHfffTepVIqbb76Ztra2j6wXn3Q+8nUkhGD8+PFks1k2bdr0ifJECSFKLxghBJs3b2bmzJnMmTOHM888k1mzZrFjxw6gGAj3Jz/5CZdffjnXXnstNTU1rF27ti8V8kA80eVyOX72s59x8cUXc8YZZ3DrrbfyxBNPHDSMIITg3HPPpaysjN///vek02mWLFlCU1MT3/zmN/H7/di2zeWXX86nP/3p0n6XX345oVCIpUuXHlSG9evX8/jjj7NkyRIuuugitmzZwiOPPMLChQtZv349Z555Jt/4xjeYOHEiqVSKL33pS9TV1ZFIJAC47bbbuPPOO/mXf/kXHn74YTo6Oj5RdePjctgmpfeW9fl8zJ8/n9WrV7N9+3bGjx9f8lAeyLHyWH6c/p5nqbyfjxSvAiml2LhxI5lMhqqqKmKxGFLKAV7CHTt2sGjRIl555RVefvllLMuiurq61FxTSpWsmuduX7RoEXv37uUf//EfsW2byy67jD//+c88/fTTXHvttSVvoc/nA+C73/0uP/zhD1m8eDGRSIQf//jH2LZdOraUspRQRWuNbdt85zvfKQ0L9H95zJs3jwcffJAlS5bw+c9/nm9961s8+eSTXHfddfj9fp5//nm++c1vYts2X/rSl/jZz35WspAPP/ww27ZtK13HZz/7WXp6eoacSvqT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)![](data:image/png;base64,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)

步骤（6） ：聚合收单平台后台通知商户后台系统，支付结果，商户APP播报语音支付成功。

步骤（8） ：如下图，商户根据订单号查询订单结果。

![](data:image/png;base64,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72fmzJmZ/u/y5cu54447KCkpoaenh1/+8pf09PRw/fXXD3JNO3dcEIbn9XozAwDZAybZHfHseS17e/aQ+HXXXcdFF13EwoUL+fGPf/y+ObSVK1fyzW9+k9zcXFatWkV/f/9xxmFfO5lMous6v/vd74hGo9x///18+ctfzoxK2mUxDIMlS5Zw5513ZprGzc3NjBo1KjNQY5omubm5fPOb32TChAmYpsm///u/U1FRkRl0sPtMQggeeughrr/+empra3nttdd49913yc3NZfjw4QwfPjwzQltZWcm9997LmDFj6Ovr44EHHmDMmDEoisKaNWvYtGkTd999N5s3bz5utNIuU3d3N7/+9a+pqalh9erVbNy48bjBEPs+NU1j8+bNPPjggwgh+N73vsfNN9+cmcOzB6cURUFVVRKJBH/+85+55JJLKCsrQ5Ik8vLyuOWWW9i8eTNLly7lxhtv/P/bu7fgJq40geP/7pZasgFhg7nIF64ycYDEQELIDWqKSuUlsPDAzOQhqbzlKS/Ja17yDLU7byRVqTxNJtlka6s2qUwwtUXYLWYB2zDGyGbjicGXgVgyvtvIlvpy5sFqIYMQGsBuDN+vylVYPi13t/h8vv7O6T65MdfFbPEny3m8YFq9ejWdnZ2kUiksy6KlpYX169fT0NDA8PAwlmUxNjZGKBTi+vXrJBIJqquraWxspLu7e877wWwVbnR0lBdeeIGGhgZisRiDg4MEAoFckeD69ets376dTZs2UVFRkRtgXrFiBatXr2ZoaCiXBvf29hIOhxkdHWXPnj3U19fT0NBAS0vLnKqrV7msrKzM/ec0DIPly5fT2dlJOp0mk8nwyy+/UF1dzbfffsu+ffuIxWK8+eabXL16lR9//JH+/n4+++wzxsfHOXv2LK7rUlVVlRvAdxyHTCbDlStXuHjxIu+//z6mabJq1Sri8TiWZTEzM0NbWxsrV65k27ZtlJeX54owrusSiURyxaPh4WHq6+uJRqNEIhFCoRBlZWUsW7aMyspKEokEU1NTWJbFxYsXiUQiTExM8MUXX1BbW8u+ffvQNI14PI5t22zevJnnnnuOy5cvFxySWYyeiOJKJpPBdV0uXbpENBqlurqaVatW8d1335FMJmlvb+e9996jrq6O48eP47oux44d491338U0TY4dO4amaZw5c4Y1a9bw0ksvoWkabW1t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)
## <a name="_toc2894"></a>3.2案例介绍
目前已上线支付案例，商户可进行实际体验。

集装箱码头线下收款码收款。

## <a name="_toc21884"></a>3.3业务流程
1、收款码-主扫支付时序图

![](data:image/png;base64,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)

<a name="ole_link1"></a>2、付款码-被扫支付时序图

![](data:image/png;base64,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)

2、线上支付（APP支付或公众号支付）时序图

![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAioAAAIwCAYAAACofUBOAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAOxAAADsQBlSsOGwAAIABJREFUeJzt3T+P48i+3vFH1wc2DAfDAQzbuMlwfWADjpr7CsSTOVtu5HDoV7C6r2B5XsHhSZweTubscF7BlHLDyzbgxIC91YFh3wvYWxMYuLiGIQe9vxqSkrrVPf2nKH0/QGNaEkWpVSPx0a+KVRIAAECiVr/+u3vVZwEAAPCF5RP9xn7Z7cgqAADgda1Wq8nlv3il5wEAAHAvggoAAEgWQQUAACSLoAIAAJL1bEFlPBhmPjDmOR7jKbc/tN1zPNbXvi7P9boCAJCKe4OKHQwPBY+7DpTjs4h2u92jDqrndiCe/z3zM63mt79E2AMAIGX3BpW7Tls+dtuhg+p92z7kPs/t1Md96vDwmNcaAIBzdlLXz2q1Ovrt/2u6RMb7fYoD8VMEh9eoXDzkMamsAAAuyUldP4dCxEOqKffd76m6PI7t234OXb7reTzUY7u3HlLBobICALgkv7lvg4eGlIeMR7Ftn7PL41h4OfZ3Hav4nPpY993nvoB01/O126iqAAAuxVed9TM/KJ9yUH9IteQpD8jjisqp4eMxg4Dv27cFjnHwmF++b593bQsAwDl5VFB5qgBx3wH3KQ/Gp1Q7HvMcjnUjPWZf93nIYwEAcA5ODirz7omHdvMc2+eh8Snj/T7V/CXj/T7lwf4lqxtUUgAAl+bkoHKo++HQ9Q9x6MD7kP2eMn7GQsm8m2V822M9RYWE4AEAwHF2pN5xwAQAAK/t1yJCrCSw1g8AAEgWQQUAACSLoAIAAJJFUAEAAMkiqAAAgGQRVAAAQLIIKgAAIFkEFQAAkCyCCgAASBZBBQAAJIugAgAAkkVQAQAAySKoAACAZP3mOXf+6wqIi3PuK0kvsV1okzTRLumhTdJ07u3ynJ4tqKxWq0U2zFLfBKdacrss8Xk/xNL+Pt4raVrq836IJf59l9Auz4WuH+xxzj3ZNiGEg7d57yeX+74/4ZkBr28YBm232/hz3//du94H0pf/+23b3vmYpuu6hz3hC+a9n3zWnPK5dZdhGO5sSzyPZ+36wXLYGziEIO99fDN671WWpYqiiLdnWaYQQvx9GIZ4u72R7cd7ryzL4r91XUu6/bBtmiY+/jAMGoZhch2QojzP1TSNvv/+e/38888qy1LOufg+KMsybuu9V9u2apomvkfmhmFQVVV74X2+zfi9Zu893K1t28lnl73GIYT4mt/c3OzdzzmnH374Ye81tra3UOm9V57nz/o3gKCCX9mHa9u22mw2MXDUdT15szZNo6qq4oemdPumtg+DPM+VZZmaplHTNPLeyzm3tx/p9ptkCEF5nst7r6qqJqEHSNH8/7EFd++9NptNvD6EoKZp1Pd9/L8+DjFN08Tth2FQnudyzsUqgIX2pmlUlqW6roshpe/7GPpxmHMuvv5VVU2+QFVVJen28+pQ0Fiv1/H3cRXFOaeqquIXO+ecNpsNofGZ0fUDSbdvOPuW0Pd9DCHjD17p9kO5LMvJz9gwDGrbVnmeq+s6OeeUZZk2m038kLAPYwspWZYpz/N4GUhZCEGfP3/WbrdTCCG+V4qiiN043nv1fR/fUxY06rqedD/YAW5cjRmHFHs826dtz/vkfvZa5nkeq7UhhAd3nVm72P7Gn3tN0xBSXgAVFUTjyoaVrOcfiBY05vebXx6GIX7T2Gw2MZBIiqVy+zbT9318bN70SJ33Xu/fv9dqtYqVRaueSF+6R63yKN0Gkq7rjnbZ2Hvi2O2r1Sr+SMscTPoaxtVeM788H3cyDMOku3ts/FnXdd3eFzU8j7MIKvTXPi3rbx+XOI1VVE5h407KspwMBpQUy9dt28ayOV0+x53yf/yh7wP7cB7fh/fS/az7pW3bGDA2m03s7rTXbzw+QtKkwjK+Tro9AJZlGfczVlWV1uu1Pn36FLsk7OBKW93NPlfG43+Koohd3HZ57Njn23g8CtXfl5Vs10/TNHLOxX5G65o4NGrbe89I+Cdgfe3jb25j1td7yn6kL98Cxx+mVta2wYXjaoqVVnHLex/PLLm+vtb3338fL3/48OHgfe4ajGzjhex91Lbt5PWev4/GFQJ84b2PY0osiDdNszdmxMak2M88VNR1PXk/2fvv0D7mDm2LffZFSPoSBqX9cHLI/PW1rjvpS9UFLyPpior9R3DOHfxPYWMdrFvBOXfwWwtOV5al1uu1rq6uJmf/SLdv3FOrHrafd+/eTUbb26h565O3drOzgIqiYJDgr2zsjlWj/vznP6vruvgN24zfB0VRxPfBvP/c9jWuis2/8dd1rb7vY5eGVdfmY5Uu2bgL0/5ft22rrutil48Zf7GaH/jG38htAK21gb1PjlVM+DZ/PwvmRVGoKIo4uL/ruhhg5pVeY21lg3D7vo/j7Lqu08ePH/WnP/3pJf+ci2Zfm3dP3ef5tZPbbDab+Ia3JDs//c8+BOYj6b/mFNdzn5Tn2N93qBtA0oNPh7RxJsf2M348+1Zo297VBXSp7dJ1XQwYVsK2CpQFulPfB1VVqSzLeP/xe8nOSrEzV+zLwThQnvqcz8Upf9+x9420f+rqsfeQHUznlcd5GDn1VFja5db89XrsGYXzdrOTAh4aFs+9XZ7SrxX9WNZPtqIy/tZ3rKJi32bu+taC0xwLIfbGPrUv/Nibd/4BMR5kOL6OcSpTNrjZvtGN528Ym38zPNSFZmdhSbdfBMaDO+0x7BRxGzsxHkuEfXe9L+bvhWPbHvpsO/Q+ooryMPPX67GfLYdOR2ds0MtKNqiMzy6xEt48Ec9P45Me/58RSJV9M7SzQg4dsOYTjc3fBzZ3hM2RY9tbYLFwYlUXK5dbmRwAXkuyQWU88OlYReVQqiXpPp9hGPT58+e9620WxxDCwVke7b7r9Zog+Qg26Hh8WveYDTgfO/QtsG3bWHnJsmxSKbFQMp65k2/wjxdC0PX19d713nt99913e10JNnstntexz7Bffvll70QBG6vFoNnXl+RZPzb739gwDJM3/rHwgudTFIXW67XW67X+/Oc/x99//PHHOPDTrtvtdtrtdvHyDz/8QEj5ClZhnAeQUwOFnSo+7soryzK+z+bdO+PH+dr1US5RlmV68+bN5L1wdXWld+/e7bVh13VxoCaeV57nurq6mpzuvdvt9o4lVsUvy5J2SUCSQcUOeqaqKuV5PvkPxXiG12Gnitu3+7quJ29kO/XVxjj0fX/wGz9OY+8Dm7OjrmttNpvJaZKnnCWV53k8m2R8nZ2ObN1CdraPneVjZ2XxYf1w81lQ7Rv6WNu2cXkJq3oRDJ+PLe8xHsM1/wIwH5dlk1/yHng9yZ7181qW+rxP9bV/n51NUte12rbdK1nb7fZjoYazse62xL9vic/5IZ7i7xsv9jk+Hb+qKnVdp77v98YX2fvmNZ93yr7277OQYjPL2in9NtdNURTxy7EFe5s752vGa517uzylxZz1g7TdN/Lduir4FoJLNA4a43FB43+twjWeXNHmUsHTm8+bYoHF5hYarwbf973evn0bt7WKJF4HQQWPxoBL4LBD4+eOTVo5rjR++vSJEwKeyXxg7F3jHG0RQ2MrWON1JDlGBelqmibOjmoDNA/N7mgfCnzoAgC+BhUVnGwYhjinx3gKdpt2XfrS5TOe98OmeAcu1bHAPl+NnK7Sl3PXlyg76wdpYDDtzFKf96mW+vct9Xmfaol/3xKf80Ms9e9b6vM+1VL/vqU+79cwH0xL1w8AAEjWs3b9jEezIx20S5pol/TQJmmiXS7Ls3X9PCdKaGmiXdJDm6SJdkkT7ZIGun4AAMBiEFQAAECyCCoAACBZBBUAAJCsRQ6mBQAA54nBtAAAYDEWGVQ4hz5NtEt6aJM00S5pol3StMigAgAALgNBBQAAJIugAgAAkkVQAQAAySKoAACAZDGPCgAASMZ8HpXfvN5TeZj7ThsjaL2Ou9qFNgEAfK1FBJX7lt7m3PfXcUq7EFZeF22QJtolTbRLmhijAgAAkkVQAQAAySKoAACAZBFUAABAsggqAAAgWQQV4IxxBkOaaJc00S5pIqgAAIBkLWIelRQ1TaO6rpXnebwuhCDvvYqikHNOkuS9V57n8t4ryzINw6CmaSb3ybLs0c/j7/7u7/Tv//2/1z//5/9c//Sf/lP9i3/xLx69L5wf5oVIE+2SJtolTVRUHsE5p5ubG11fX6vrOjnnVNe1hmGI25RlqbIs5b2P/2ZZNgkpklTXdfy96zq1bSvnnJqmUdd1qus6Xpak//N//o/+y3/5L/Hn559/1t/8zd/on/yTf6L/+B//o/7mb/7mBV4BAABeBhWVRyjLUs45fffdd/E655zKsrz3vuMKyjAMKooiVl2sOmP7t+vssiT9w3/4D/W3f/u3+kf/6B/pf//v/61/9a/+lf7xP/7H+pf/8l/q3bt3+gf/4B889Z8LAMCroaLySN57OefkvT96m91u/w7DoL7vY+XFex8rJub6+lrb7TaGmZubG22323j7X/zFX+g//af/pN/+9rf6X//rf+n//b//p9VqpRCC/t2/+3fP+jcDAPDSqKg8gnXDHKugWCXEun2sIlIUxeQ+NqZl3GV0dXWl9Xqt9Xot55zevXsXL5v/+3//r/7rf/2v+uu//ut4nXNO/+bf/Jsn/TulL+so0W8LAHgNVFQeoWmaySDaY/q+V1VVR2/Psuyk7qK5oij029/+Vv/6X/9r/b2/9/f0l3/5l/of/+N/6C//8i/1d3/3dw/e3ylWqxWLPwIAXhwVlUcYhmHS5TMMg0IIe9vkeX70jJ5xFcXOBgohTPYz36ck/bf/9t/0n//zf9Z//+//Xf/sn/0z/f2///f1t3/7t/qLv/gL/c//+T/113/917q6uvrKv/A4KizLQjuliXZJE+2SJvuKvEu5ge47ZYxv+q/nvnZJ+f8VACA9vx7T44H9bCoqHBCfx6EQaK81AREA8NwYo4KT7XY7AuHCECbTRLukiXZJE0HlK4xPK56z05KPmY8/OXSa87H9PsU2D0FAAQC8lrPp+nlJVVWp67o7A0Hf93dOjd+27eSMn67r1HWdpNsQ45xTlmUx8NgMtrbPcQjquk5VVU0e75Szkk5BQAEAvCYqKg/knNNms1GWZTFIzNkZPVVVqe/7o/uyOVbKspwEiyzL4mnNRVHEUBNCUFEU8b4hBK1WK33zzTd6+/atVquVPn/+/FVrBwEAkBKCygOEEDQMg8qy1DAMqqpKbdtOunGGYZiEGek2sHz8+HGy3Xz+FFsraLyNTRJnlZbxKc12eb1ex66Z3W6nN2/eHDytGQCAJSKoPMAwDNpsNgohxPBgqyh77+PCg+Mqi3XpvHnzZq/bpqqqyVT783lUzH3BYz67LWDouksT7ZIm2iVNjFF5AKuCdF2npmniAoPj7p152MjzXCGESQXFum2qqorXt22rqqr2xpZY+LkPo9UBAOeIisoD2SrJVjmxyorp+15N02iz2cRtD41TybIsDpCVbgPOPKTUda2+71WWpbquu3NtoeecjRYAgNdCUHkA7736vo9dPyEE9X0fu3qsmpLnuTabTRzHUpal6ro+2IXjnNPHjx/3rrczf/I8V1EUcZVlWxDRno91I1nXE11AGKPSlibaJU20S5rOZgr913r+1jVj6/XYWTnj36UvlZhDrGpiXTzjQbtz1t106DHmz+e5pdwuuEUbpIl2SRPtkob5FPoEFTwa7ZI+2iBNtEuaaJc0zIMKXT8AACBZBBUAAJCsRZyevNvtGOS0UF/bbpRhvw6vX5polzTRLmlaRFCR+A+0VF/TboRTAABdPwAAIFmLDCp808Z4vphDE++Zpmnkvdd2u9V2u9XHjx+PzjUzn6NmrO/7uNyB/X4fm2fn2HV93z/7vDe8V9JEu6SJdknTYrp+gLEsy+KyAx8+fJD3Xm/fvtW7d+/25paRpDdv3qgoCjVNo/V6Ha93zk3mrbHwYPPajOessSAzDyk22Z5tJyk+h/l8Ns45bbdbvX37Vjc3N1qtVsqybG9WYgDArUVWVIDx7L8//vij3r17p++++y4GBJu110JEURTxZx4e3r59q9VqpdVqpevra3377be6ubk5edK8PM9VlqXKsoyPYZfnk/YNw6A//OEP+vTpk3744YfJYpUAgH0EFSyOLS/QdZ2yLJssZ2CLRVp4CCHEpQ9sleu2beNyBiEErddrvXv3TldXV1qv13rz5o1+/vnnyWPmeT5Z6fquCogtdXBK95C0380EAPiCoILFybJMZVlOwkhVVcqyTE3TKMsyOefUtm2sboyXOMjzPFYxbNsQgq6vr/X58+e9NZnatlWe53FhSKvSjMe0jJVlqc1mo7Zt924bV3qccxqG4eAaUACAW4sMKpyqDDM/yFsVw8KC9KVrxv6dd7XYbVZNqapq7zFsm/F97pJl2WQgbQhB2+1Wv/vd72I302q10rfffqvr6+tnG1TLeyVNtEuaaJc0MZgWi2OrV+d5rr7vYyCxla3nXTPzy8cWe7zr8bbbbdzGziJ6SCUkyzKt1+s4kPfTp0/x9/HgXgDAFEEFi+O9V13XsWox74LJskwhBDVNs1cJmbNVra2KUpZl7AoyRVFovV7Hb1tVVU0uz50yOJYBtABwmkWsnjzHCpdpeO7Vk2nnr8drmCbaJU20SxpYPRmvjkmVAACnousHL4aAAgB4KIIKnh0BBQDwWAQVPKtjIYXwAgA4xSKDCoOdlmO32x0MJbThy+B1ThPtkibaJU0MpsWz2+12fAAAAB6FoIIXQ2ABADzUIoMK4xuWjbDycnivpIl2SRPtkqZFBhUAAHAZCCoAACBZBBUAAJAsggoAAEjWIoMKgzGB0/BeSRPtkibaJU2LDCoAAOAyEFQAAECyFhlUONcdOA3vlTTRLmmiXdK0yKACAAAuA0EFAAAka5GrJyMdlEoBAM+JoIJHm5/Kt1qtOL0PAPCk7OvwjgMMAAB4bb9W6mO5njEqAAAgWQQVAACQrEUGFQZwpol2SQ9tkibaJU20S5oWGVQAAMBlIKgAAIBkEVQAAECyCCoAACBZzKMCAACSwTwqAABgMQgqAAAgWYsMKpzrnibaJT20SZpolzTRLmlaZFABAACXgdWT8WiHvn3Mr2OQ9subtwFtAmDJCCr4Kncd9Cijvp5j7UKbAFgaun4AAECyFhlUKF0jhDC53HXdnds75+S9v3eb+zjnFELY29d9+zYhBA3DIEkahiH+jsvCZ1iaaJc0LTKoAM45Oec0DEMMD845dV23F2Js+yzLVNf13m1N08T738fCRdu2e9f3fR+fV9d18d+xLMvU9328T5ZlJ//NAHCJGKOCRaqqKgaSeVUiyzINwzAJLN57DcOguq7V972qqppsPw8MXdfFUNO2rYqiiLcNw6Cqqibb2POx/TRNczQUNU2jrutUVVUMR3meP+ZlAICzt8iKCgMCL5v3Xm3bxoqKpBgQrGulKIp4XVmW8t6rLEuFECahoO/7g4FifF0IQWVZqigKVVWlLMsmwWX8fE557uNq0KldRjgvfIaliXZJ0yKDCi5bnucxiFj4qOtaZVlKUgwRRVHEbpY8z9W27V7IyPN8r5pi1Zcx55w2m42k24pK13Xx8cbP5xSr1WryQ1gBgOPo+sGihRDU9/2kojJm3St5niuEMAkp0m2YsW4iq3ZImoSOPM9VlmXcT5Zl8t4f7K5xzsUAc0hd11qv1/r06ZPW67Wurq7i4zNeBQD2UVHBYs0HtI5ZBcSqLpK02WxU17U+fPgw2bYoCpVlGQOJdfOM9X1/sPIx7u6Zj2UZGw/WtTOQxl1XhwYAAwCoqGCh8jyPQcS6Xrqui1UJCx8hBDVNEyshXdep7/sYDOxsIGNhwsay2P4t7HRdp81mE8fBWFjKsiw+HxuDMjYOTPY4d1VeAAC3bOTQbknnj69WK853T8B97fBS7WTdMMe6Y45df4pxl8xDumfue8yveU73uet1572TBtohTbRLGn4d1BxHNi8yqCANqQSVS/TYMEKbAEjdPKgwRgVYKDtrCADO2SKDCh/OwBcEluWhvdJEu6SJwbR4VrzxXw7dOgDOEUEFz4oD5/MgAAK4FAQV4AwQCAGcK4IKsGAEFADnjqACLBABBcClWORZP3xIA1gyPsPSRLukaZFBBQAAXIZFBhXOeACwZHyGpYl2SdMigwoAALgMBBUAAJAsggoAAEgWpycDF+Zr++E5MwLASyKoABfma4IGgw0BvLRFdv3wjQ5ITwjhRR/jJR7vufAZlibaJU2LDCoA0tF1nSSpaZp7t62qSsMwxPsY7/3edZI0DMMkkIy3a5pm0WEFwGkW2fXDcvZAGrz38t5LkrIsk3Rb6fDeqygKSZJzLnYZff78Of78/ve/148//ihJyvNceZ7H/Q3DIEkqikIhBGVZpq7rlGWZsixT27Yqy1J936uqqvjYS8FnWJpolzQtMqgASEPf9yrLUs45ee/lnJOkSXBwzsVqy3q91nq91tXVVbw9hKAQgoZhUFmWyvM83laWZfw9z3NdX1+rKAp9/PhR3377bQwxAM4XQQXAo4QQVBRFDBPOuUmwGG/nnJNzTkVRxK6fuq5VFEWskpzSjXN1daX1eq1Pnz5pvV7z7Re4AIxRAfAoWZapKAr1fT+pqHRdNwkd4zBj29vvc1ZdOWQYhvgY9i9jVIDzR1AB8GhZlqmqqthlU5al6rqedMeMw0Se5+r7XpvNJo5DGW9n41DmbMzLuFvIHr+uawILcMbo+gHw5KwbyDmnqqrUtm2sprRtq6ZptFqt9Kc//WlyH6uWXF9fT8ax2GDb+f4lHexuAnA+FhlU6JcGXt/4jB9JMZiYEEIMGJvNRt77OB6lKIq905GtwpJlmX755ZeDXUPmrtuWgM+wNNEuabJpJnc0EB7qvlP5ONXvddz1un9tm9CmAJ7br9MZxGmwFzlGhWm8gae1Wq14X70gXus00S5pWmTXD4CnwQczgNQRVIALREABsBQEFeDC3BVSCDAAUkNQAS6MDYY9FEoYKAsgNYscTAvg6+12O4IJgOQtMqjw4Qo8HQLLy+P1ThPtkqZFBhUAT48PaQApWmRQYcAfgCXjMyxNtEuaFhlUAADAZSCoAACAZBFUAABAsggqAAAgWQQVAACQrEUGFU6jBLBkfIaliXZJ0yKDCgAAuAyLDCqc6w68PuecJMl7r+12G3+GYZhsM75tu93qw4cP8t5P9tV13eT38T7G+r4/etv4/vP9z28PIcTLbdtOLj+H1Wp17w9eH+2QpkUGFQCvrygK9X2vruu0Xq+12+20Xq8nocM5p/V6Pbn93bt3kyDhnFOe5zEseO8VQohBaGwYhoOhYhiGSRj6+PFj/Hf8fGzbLMvi5RDC5PI4DIUQ1DSNnHPx+QzDoM1mc/D53cWWKjj0A+A4Vk8G8GhlWWoYhvjjvd8LAdvtVpJ0fX2t1Wql6+trXV1dxW289yrLUm3bqixLee9jCLrLOGAURRGvtwP/er3eu88wDMrzfBJ4vPfquk5VVSnLshiSiqKI+7e/s21bbTYbZVmmsiwf8YoBeCiCCoAH896r73vleR6vs4P6uOKRZVkMDFZRGVcQLDA0TRMrH865o5UTu4/9W9d1fFzv/eR+TdPEUGEs/OR5Hq93zqmu68lzPtR15L2f/L0AXgZdPwAeLM/zScXBrsuy7GBFZbvd6vr6Ov5rbB9t26rveznnlGWZiqI4WrGw2+YhxEJEXdfxvuPbrcvGrm+aZm/fwzDo8+fPk+doFZY8z1VV1cmvEYCnQUUFwKNZ9SKEoLIsD47buKuiMu5msRDgnNNms4mDXMdh4z7WhTQMw97YlHH3kG07573X+/fvtdvtNAxDDFJ08wCvZ5EVFQafAa8vhBDHfGRZFqshxrpm7tvH999/H7ttbJxLURR7412O3X/O7nfXmT/S8aAiKY5jecjjYvk4tqSJigqARynLMoYU63YZnxrsvZ90lViwsbNozNXVlfI8j9d1Xaeu61TXtZxz8SwgSfHsoPkZOBZ0pC+nG9tpzmVZHg1Mfd/H5xtCiFUX+3usUjSu7AzDoKqq5Jyj0gK8ADtpfEeSxEOtVqs7v4Hcdzuex12v+7m2yUO7iJ7qvqfivQKc7tf5bOKkNosMKryp08CHb5ouMaikjvfKMtAOaZgHlUWOUQGAFDHLLPD0CCoA8MQILMDTYTAtcGE4gL4cXmvg6xFUgAtDH/zzORRMdrsdgQX4CosMKnzQAkgdn1PLQ5ulaZFBBQBSxcEOeFoMpgWAJ0JIAZ7eIoMK/b0AgKfGsSVNiwwqAADgMhBUAABAshhMCwC4SIe6esbXMeYoDQQVAMDFumtdLKRhkV0/pFwAAC7DIoMKAOC4EIKcc5Kkruu03W613W718eNHDcMgSRqGQX3fyzkX/3XOqW3byb76vo/3CSGo67one56H9tW2rUIICiHsPRdcJrp+AODMZFmmYRhUlqW896rrWn3fK8syhRAk3YaOLMtUlqWccyrL8uC+vPcqy1LDMMh7L++9+r5XCEF1XZ/0fCw0SbfhxO6X53l8Hrbd27dv9fHjR4UQ9O233+49t7quY8Cx55HnuSSpKAoNwyDnnOq6jtdj2RYZVFarFd0/AHCEc05FUcTL83Birq+vtVqt4r/jbaXbUPHNN9+obVttNpsYeiQ9KASMg8Zdocg5p6Zp4o8kNU0Tt7fKjsmyLIatqqrU930MXoSU87HIoAIAOK4sy3iADyHEA7xzTlVVxe2urq60Xq+12+20Xq/jNuP9DMMQQ8BqtZL3Xl3XqaoqVVU12X7MKjrjwCTdVmiaptE333yj9+/fT26zLivv/cH9hhBUVZWGYdgLYgST80VQAYAzZt091oUzdl9FZRgGbbfbWLVo21bv3r2bdKscq44cuz7PczVNo7qutV6vHxwwyrJU13UxqFgIYzzL+SKoAMCZsi6QEIJWq9Wk28e6WSQdragURaGyLOP9xvf/2goUyLOzAAAgAElEQVTGfCCtc06/+93vtFqt4o8kffvtt5NxLeNxNuPniPNFUAGAMzQMg/I8j90/WZbJex9vPxY05hWV8aDbcVCZd798rXHY+PTpUwxOpuu6+Pjjgb3z5359fa2bmxt57+kOOhOLDCoMpAWAu9kpx3awDiGo73ttNhuFEPaqECGEycBVSTGc2JgRG1Br3SyP6W4Zh52HbDM+w6jv+73r7H7r9Xov5GDZbOq9HQd/PNR9Z19xdtbruOt1p01eB++VNPFeSdOv3X5xamAmfAMAnD2mxF+uRQYV/sMBAB5qPEgXy7HIMSoAADwWYWVZCCoAkAgOoMA+ggoAJILBm8+HELhcixyjAgDAY+12O0LhgiyyosJ/MADAQ3HsWCYqKgCAs0dIWS6CCgAASNYigwqDogAAuAyLDCoAAOAyEFQAAECyCCoAACBZizw9GQCA5/a14yE50+hpLDKo0PgAgOf2tcea1WrF8eoJ0PUDAACSRVABAADJWmRQYR4VAMC5CSFIkrqui78f472X917Oucn1wzBou93q48eP8Xf76bpubz9N0xx9LO+9hmGQJPV9f+9zei6LDCoAAJybpmliAMmy7M5tbbt5WCmKQldXV/rll1+U57nW67U+ffqk9Xqtuq4lSc65GF4+fvyo6+trbbdbffjwIYaREILyPI/7DiG8WlBZ5GBaAADOTQhhL3w457TZbJRlmZqmUZ7nyvNcIQQ551RVlYZhUFEUMdx0XRcvbzYblWUp55xCCKqqSmVZxsd88+aN1uu1JMV/pdvKjO23rmvVda2madS27b0h6qkRVAAAeGV938cQ4JyLYWIcKiSpqqr4uwWJYRhieLDfLWhkWRYDyrjyYsHFqibe+1hxuctLhxSJoAIAwKvLskzee33+/Fk3NzfabrcKIeiXX36ZBAgLIHmeS7oNOEVRxNuLoojdNFVVxe6kubIsNQyDuq5T13Vxf2Or1Wrv5zUsMqhwXjoA4JyMKyc2puTYdiEEFUURu4hs8O242nHo9/kYkxCC+r7XMAx71ZQ8z2P3kT2fq6sr9X2vsixftLLCYFoAABYgz3N57/cqICGEeHbOnAWQtm33upGyLItnAo1DjI2VGYYhdgs55yZdSS9pkRUVAADOyfw04/nZNmVZxoG0bduq7/sYQjabTRy7YkGmbdvYTbTZbBRCiINhLXhkWRYrKtZFZINvx6FmPGbmNViH025J3SlMS5yG+9qBdnodd73utMnr4L2Spud+r7x2u867g+w66WGDYg/t5zn9OhYmDoghqODR+PBNE0ElPbxX0vSY94oNKD2lvWjXx5kHFbp+AAC4BzOivx6CCgAARxwLKASXl0NQAQDggejSeTmLPD2Z/yAAgJew2+045ryyRQYVAABeEoHl9dD1AwDAiQgrL2+RFRUGMQEAcBkWGVQAAMBlIKgAAIBkEVQAAECyCCoAcEbmq+iGEPThw4e4xostcjc3vj6EoO12q+12K+ecnHPx8nhf0u2qvGPzy5LU93383VbrnRuv4ntsJeD5/V96FV+8jkWe9cOoawA4zHsv6XbF26qq5L3Xer2Oi8rZirpFUUzuZ9eVZaksy3R1dSXvfVy51zmnPM+1Xq/jfQ6FHnv88TZZlmkYBoUQ4nPK83yyzTAM2m63km7Dzmazkfde79+/j3/PMAzK81zOuXifpmme4FVDyqioAMAZqapKRVEohKCbmxutVitdX19PAkVRFMqyTKvVSqvVSlmW7QUX6bYSUpaluq5TCEHee202m8ntVVWp7/tYeQkhTCooFiSs0jIMw8EqzGaz0Xq91nq91p///GddXV3pu+++23tOFrhecjVfvC6CCgCcCeec2rbVMAzKsiwe+H/66ae9bfu+j7ePg4V0WxWxfdR1rWEYVFVVrI6M92EVF/vJ81xVVd35PMf7sGCT57m89zHwWAVmzCo+9oPLsMiuH5bOBnAJbM6oUz/v7OBtXTLe+xgCHlKByPM8ds1UVaWu6+S93wspdV3HxxtfPvR32M+c9/5gsDnUrXTX2BWcLyoqAJAYO6g/dtr2EELs3pG+VEjGbKyHc+5gt894O9vHWFVVcf/j8SZzdV1rvV7r3bt3sYJjVRpJk8d2zk3+hnFQyfM8/k3ee5VlOemGwvlaZEUFAM7RQysoh9gBvixLDcOgzWajEMJeIJlXP8YhYW6z2ajrOhVFcTTUHKqm2D6dc7Fbxxyq8Hjv437mocW6mWzMiw3ubZrm4JlGOB9Wh9stqSuFrp803NcOtNPruOt1p01exynvFTPe7lBXyX23//TTT8qyTM45/dt/+2/3bv/06VM8w+d3v/vd0f23bau/+qu/2rv9D3/4g8qyVFEUR5czsX089nZ7joceX7odoPvLL7/oj3/841c/Pu+V9PzabrHxCCp4NIJKmvjwTc9jg0oK5qcSj80H11pXzaFqyXzbUx/jOfFeSRNBBU+GoJImPnzT85D3ylN0/+A0vFfSNA8qixyjwn8eAOeKwAJMcdYPACTIzvg5Ns7isey05SWYz++Cy7TIoPLUb1wASNVTV1Tatn2V8SCHHDq9eHxmj7R/WjQuzyKDCgDg4Q6t8fOaDp1WPB5wa5PN4bIRVADgQtjaPPZ727ZyzsUuFuecNptNnIo/hKCu6yZT2tvttv5PCCFua2v9jNf3ObbC8aEZae2xWBUZYwQVALhAWZYpz/O4MrJ0OwW/TRa32WzUtq3qulZZlmrbVlmWKcsylWU5qXaUZRmn67dtJE1mx52zmWaNrS1kqzeb5w4t4+n951P9M8wgDQQVALgQttKxObQS8bHxK4e6YKyiYl1Ktp+qqrTZbB7UzXRsnpXnXCXZBiyPlyo4dB1eF0EFAC5EURSTNX+GYdB2u41hwDmnm5ubOIC1rmu1bauPHz/G+9lU+F3Xxen5x90+wzDERQ3vChnee93c3Gi73UpSrOzYY9k+jy10iMuxyAnfkAYmfEsTk1ilJ6X3ynhlZenLisunappmclbOIfetC3Sq8ZgaXI6zmPANAPA4NoZkvjrxKWz8yl3T4UvaCyn/4T/8h8ntv/3tb/X27dt7H4+QAmmhFRW+FaYhpW+J+IKKSnp4rywD7ZCGeUWFMSoAACBZBBUAAJAsggoAAEgWQQUAACSLoAIAAJK1yKDCqGwAwFPj2JKmRQYVAMD9xtPlH9N1XZz8bc5miLVZacez2kq3s8uOr7vr8e57Lrbe0H3bzh8T52+RQYWFogDgMFvhWNoPFod475Vlmdq2nexju93qj3/8o66vr/XHP/5R2+1W2+1WHz58iNt1XRdvd87FbX7/+99PHsO2O7QPc2rg8d7HierGIeopcGxJ0yKDCgDgsL7vY1AxwzBMDuibzUbOOTnnYoWiKIoYELIs03q91rt37yb/vnnzRu/fv5d0GxiKotDPP/+sq6srhRD0hz/8QX/+85/1448/xseyUPHjjz9qvV7r06dPurq6mjy/qqpUFIXqulbXdaqqarLOzzAM8fna32K/4/wRVAAgAavV6qt+xuYrIM+ntM+yTGVZqizL+Lv3frLuj63X45xTnufxX1uIUPqySrIFnBDCZB0gW1gwz3P1fa+u65Tn+d4aQEVRqCzLuJBhVVXxst2e5/nk7725uXmS9YSQPoIKACRgt9s9+sd47w+ujzMe/2HbOee02WyU53m8bOv32ArI0m2A2m63Wq1W+vz5s6qqUpZl8X5d16lpmhhauq7TdruN6wFZ6LAuprqu99YYsse3sGRhZzx2Js9zvXnzRj/88IPev3+vn3766c71hnA+CCoAcCYsXIy7dSykjMNBnuexmlJVlaqqit0s0pcKh6RJ189PP/0Ur7eBtlVVxX1b8NntdjFEOOdUVVWsljjn9lZftudj29hjzCtDVplp23avewvni9WTAeCMjA/0zrlJd450GzDKspwEGFtR2caqnMK222w2qutabdvGgbzzykxRFA9aCXn+nMd/m3Pu3tWbcV4WGVQ41x0A9nnvJ1WI8e9d18Vul7IsNQyDqqqKVZemaWJXziGHuo9ubm709u1bff78WW/fvtXbt291fX0t55x+/PHHSegZ3/9QgJI0CTh930+ev1WIrJJi/5ZlOakGfQ2OLWmyEVg7GggPxdL1abrrdadNXsdzv1cecv9xNWJemThWqZgHoIe6rwJy6PbxYx6r9FiXE9WV8/Lr4PA4QnyRQYUP2zQQVNJEUElPSkEFx/E6pmEeVBhMCwAAkkVQAQAcNJ6tVtJk/Ip1u/R9H88Amm8vfZlsznsfZ6bdbrcnTe8PSAQVAMABIYSD852YLMvUNE08W+iucSQhBHnvtdvttF6vtV6vmVUWJyOoAAD29H0fZ6Ydz8vSNE1cY2e8RpBVW8Yz1dr0/OPp7i24MKMsTrXI05MBAM/L1topimIyeZtN1pZlWZza3qopFmxszhSbQ8UqMTc3N7q+vlZRFCwAiJMtsqLCqGwAl+DQOj4voe/7ydwkh+ZWCSEoz3OFEFTXdVzocMw5p7ZtlWWZvPd6//69rq6utF6v9d133z3vH/EIHFvStMigAuByzMdJ3HXboW3H1913eypeK6CY8Syytq7PIW3bKs/zWGWZj1OxRQxtH7YooXQ4/ACHLDKoUDIE0mQHHxuT0HXd5EwQm3F0PO5hPCvqIfPVeMfm672ML9sAz6Zp4mMeOji2bSvvvdq2nTyn1zgr5bUDyjGHZpEtikJ1XcfwYQNm52sKSV+qL+NJ3I6192tK8bUHY1QAPCEbj2DhYz5g0mYgnR/4nHOTWUjnVRDrUhiGIYaRefeEpMnBMISg7Xarm5sb3dzcyDmn77//XtvtVm/evFFRFBqGIU777r3Xt99+G/f10rOd3nWQfO0DaAhBXddN2sVOOR4HvK7r4mrKFjD7vldZlirLMgZG4CEIKgCexDAMurm5iSHBDkhWVRkf+MddAPNv1vNw45yL140Dju237/u4b+99DCoWRN68eaP1eh1PjR0fRIuiiGvf/PTTT1qv15M1cV6SjY84FEpeY+zE+LXOsmyvemWDZ21ba4N5eBxX1Ma/H1t4EJhbZNcPgPQURaGffvoprsQrfTnr49A6LvYt+xD7Bm+L19V1PQk0tqBenufxMcqyVJ7nk5WDq6qKC/BZMDr0XMbdPPY4rzXPx263W9ygTtbawXMiqAB4chYY6rq+9yB2aKxClmWxqmHf3MeVlvEAz/Fgzvk+xt0VZVnuVXZsbExVVfHMFPPa83wsMbAAz4GgAuBJWRXEumUk7Q1MHXcPzLsUxkIIqqpqbxsbiyJ9mSF1zrojLNRkWaa+7ydntDRNEyswtp+yLOOYixQQVnDpFjlGhTcukB4bS+K91/X1daymVFWl6+vrWNmwLpVx9eJQVcU5pxCCNpuNNpuNvv/+e2VZpvV6vXefY1UbG6di+6rrWk3TaLPZxLCz3W5jIHLOxTEidGdcHo4taVpkUAGQnvFYFDsN2cKE3WZjSubzcoxDwXhArFU7qqpS3/dxwKvt084ikm4Hao6rJRacrEJiz8HOVrHn8e7du3hbWZYHgxCA12PDy3dLSpKr1Yrkm4D72oF2eh13ve7HbrMqAu31PHivLAPtkIZfP4/i6W9UVIALRkABkDqCCnCBCCgAloKgAlyYQxOKHZv59K5JyMa3H9vm0m+fbwPg4QgqwIXZ7XZ7B9X7DqanHGy/dh/nfjuAxyGoABdoXinhIAsgVYuc8I0PVYyFEPYWsfv48eNkkrFj06Efu36+ANv8PuPJwPq+n+xnvICbc05t2x7c13il4e12q+12qw8fPrzoGjM2+2mqq/YCL4ljS5oWGVSAsfHMpHVdaxgGrdfryZwa85lRD10/DEMMDNvtVtfX19put/r48eMkiPR9vzed+zhcWEgZhiFOy35o8jCbp8M5p/V6rfV6rZ9//vlVJhpjunYAqVpk1w/numNuvCrrarXS9fW1fvnllxhWbOKwvu/19u1bee/13XffTfYxDh+fPn2KE3/Nee9jEJFuA45NPGYL5DVNE2c+DSHE5e2bplGWZXLOyXsfqyrSdJVgAC+PY0uaqKhg8Zxzce2YPM+1Xq/17t27g10oVm05VrmwGVVtv5vNZrKfvu8ngaQsy8m/Vl2x+3nvtdls4lTy9pi20q/N0GoVnLdv377aqr0AkCKCChbPDvq2GF7f92qaZrLwnbG1XW5ubg7uqyiKuBqvBQkLF1Y1scuHxrF471WWpbz3qutadV1PpoS3/bRtq2EYYqVnvV7r6upK6/WaqgoAjBBUcDYsJIQQVJblwVV5bS2XebfPWJ7nats2Ll5nbC0YU1XVXlCxbp1xVUW6rc5YULHqii2Yl+d5/HfcFQQAIKjgDNig1DzP1fe9qqqK1Qxj3Sl23Xig7Zx12dhA2GOOLa5XluXeANv5mUl2PwsoIYQ4pgUA8MUiB9MCY8MwqGmaOEC1bVt573Vzc6MffvhBVVXJez85pdgcWrXXumbsX6vUHOpKstOPbTCv7aMoCtV1Hc8Q6rpOm80mdilZ1cW6iSxIEVQAYGqRqycjDV+zImyKo+ttDMpL7++pH3dpr/slYPVk4HTz1ZMJKni0x3z4MhPq8yOopIegApxuHlTo+sGLIKAAAB5jkUGFbx/Lce4BJdVVhwE8HMeWNC0yqGB5xgfTUw6ypx7oX/v2FFcdJrgAOCcEFTwrW/DOfj90+333T/l2AMDzIqjg2c2rExz8AQCnIqjgxRBYAAAPtcigwgFu2Wg/ACnisylNTKEPAACSRVABAADJWmRQ4fRLAMBT49iSpkWOUUE6eGOniXZJD20CPA5BBY92aKIxBqO9vvmEerTJ6+O9AjzeIrt+AADAZSCoAACAZFmn6Y4yJAAAeG2/jueKg7qoqAAAgGQRVAAAQLIWGVQ4zS9NtEt6aJM00S5pol3StMigAgAALgNBBQAAJIugAgAAkkVQAQAAyWIeFQAAkAzmUQEAAItBUAEAAMlaZFDhXPc00S7poU3SRLukiXZJ029e+wmc4tB/nvl1jLEBAOD8LCKoSHcHEVLw6yBAAgCe2yK7flLXdZ1CCHvXj69zzt25j2EYNAzDwdtCCOq6Ll723h/d9rntdrujPwAAfC2CyhMYhkHOOQ3DEEPDMAxqmmay3fjy/La5EEIMNiEE9X0fb3POKc/zeNl7fzAYAQCwdASVJ1AUhZxzKopCfd/r+++/13a71bfffjupdNR1fed+vPcHr8+yTFVVxcv2WONwMg8zgETXW6polzTRLmkiqDyBYRhiSMnzPHZ9fPfdd+r7XiEEOecm3T3zoCFJeZ7Ley/nnLz38t6raZq9LqNhGJRlmbIsi9fPwwwAAOeAoPIEuq5TlmUxQFgXkAWTLMtUluUkcOR5fnCcinXp1HWtqqoUQpgEkhCCyrKUJPV9f7QKAwDAOVjMWT8ps+AgaS9YzPV9ryzLlOf50XElZVnGSsp4LEsIQVVVxe6ksizlnLvz8XDZVqsV5ewE0S5pol3SREXlCVgVRbodZ1LXtfI8nwQY6UtIcc6pqirleT45e2fMBtOOw8w8kNDdAwA4d1RUnkCe58rzfBJYsixT13WTs3PmVZKyLLXZbOScm3TnjLdp21bee+V5Hq8bd/fYIFoCCwDgHC1i9eT7ynGplOvu6/a573YLJPeZb3fffr/GXa/tUtrlktEGaaJd0kS7pGG+ejJBBXcazzQ7f41pl/TRBmmiXdJEu6RhHlQYo4KTrVYrlitYGD5000S7pIl2SdPZjFHhAPpyeK0BAC/lbIIKSfh5HAslu92OwAIAeHZ0/eBBWHBwWQiTaaJd0kS7pOlsKip4XoQTAMBrIKjgTgQUAMBrousHAAAki6ACAACSRVABzhhdd2miXdJEu6SJoAIAAJJFUAEAAMkiqABnjHkh0kS7pIl2SRNBBQAAJIugAgAAkkVQAQAAySKoAACAZBFUgDPGvBBpol3SRLukiaCCxQohPHqbU+77tY8tSd57DcNw0r689/HyfP/e+3i7/QsAl4BFCbFoTdOoLMt4IC+KQn3fq21bZVmmtm1VlqUkqes61XWtYRiU57mqqpKkSZAoikLOOa1WK7179055nss5pzzPY3goikJZlqlpGjVNo67r4nZZlk32PQ4XIQR9/vxZ3nu9f/9e0m0o6fteeZ7Hy/Zj+5Ckvu/jZfs9yzJJiv8CwDmiooJntVqtHv1znyzLtNlsJN0e4L33MSiMD95lWaosS+V5rrIsY9CQFMOFBRy7br1eaxgGOediUPHex0AhKT52lmXx8e2y9CUADcOgEIKKotB6vda7d+/iPkIIyvM8PnYIQcMw6O3bt/rw4cNkuxCCnHMqiiJWau6r7DAvRJpolzTRLmkiqOBZ7Xa7R//c9aFhB207wEu3HzKfP39+ULfOuEulaZrJbVVVqeu6uN084Iy3f/v2rVar1aRbJsuyGIws9NhzN3meq23bSeDKskxv3ryJgabv+xh05s99HJwA4BwRVLBIFgLsQJ1lmeq6jr+fqq5ree9jl9Cc7b/rusntZVlOul52u52qqordTNKXKkjf96rrOgaV8TbW7WPhxaozVmmx4EL3DoBLRVDB4tmBfbfb6aeffnrwfeu6Vtu2att27/ZxtcWCxpxVS968eTMJFOPunHH1JcuyuC+r0liXj3NOdV3HAGOBbPx8Tu0aA4BzQFDBYlm1wrplDlVE7qtEWLeKjVMZG4ZhEhJsoK3x3seBtBY05s/PKiNN0yjLMv3+97/XX/3VX8UKyngQrVVdDu1r/Jjr9Vrr9ZqzfwBcBIIKFs26YIqi0GazUVmWurm5kXQbNMZnzkhfwsX4/lbJsFBiZ/BIt11DNpDWzi4ytu+qqtS2raqq0vX19WTf9pgfP37Ut99+q7IsVVXVXiiSvgwOHoYh7m/Oex8H+J4yFod5IdJEu6SJdkmT1Y93KTfQarW68z/QfbfjeTx3u5xyf6uGjFnomA82tW3HoeRrzR/fzjyStHf9+EydzWYzOTuoKIpJBWa+70N/E4NpAZyjX7u2Y/82QQWPlkJQAQCcl3lQoesHOGMMuk0T7ZIm2iVNBBWcpbumrg8hTMap3DfN/TAMGoZhMmfLeIK38ViRQ9PfAwAej6CCs2RT1ktfgobp+37vlN+7woWFj/FpxVmWxeDS9308rbjrur3TmA+d9vxQdnYTAFwaggrOxrGwURTF5CwbmzZ/XgmxMHNsPzYVvxlPMDe+z3xw76Gzdx6qKAoGzgK4SAQVnI0sy2IXjZ1l0zTNJESMKyLz+1qYsVlurUpi2raNYcY5F6e9t/vYacxj3vtJRcXO+hlXY8bdSM45dV03qaDMT6kGgEtCUMGLeu5ZVW2m17quYyVjHEosUEi6cy4SW8DQ/nXOxYnlJO1N32+nCs9Pe54vkNj3fQxF41OZx2Emy7LJOkNUUgBcMoLKM2Aw5b6XnPa9KIo4Jf646jFf2G8+0+yYLXpoIeHQ5HHSlwnYLKjcNxNuXddxOn6rAM3nYrHfn+L/Ead3p4l2SRPtkiaCyhMZr+XS9/3kDJGxruvuHbgpKc4+euj6ruviInm23Xzl31QcCyh2/V0/X8MG0N41diTP84PhYxgGffvtt3sTxM3P/LHHqKoqVlXu0/d97I6yIDReiFCaTr0PAJeOoPIE7IAz/nZcFMXBcQX2jfrYfuwMEgspTdPEYCLddjnYujDWfTBeyXcpdrvdST8PYQf/vu/Vtq26rlPbtnHRwUO897E7Zryf9XqtqqpikNhsNnHNHtO2bazS2PT987WApGnXjVVxrGvKxrXMKz/DMMTrrI2PVX/uwrwQaaJd0kS7pImZaZ/AOESM59aw0v74IGTbtW27t96L3ddWzh2GIYYeG/vQ970+f/6sq6ur+C3e9jd/nOf2kHaZfwA8R3sdmk7/kGNT6z/1Y1oAyvP85OqIhZGnmuL/td8bOIx2SRPtkob5zLS/eb2ncj7GZ5LYt+G6rieDL8fbbjYb9X2/d1uWZfGb/7xSYkHEOae2beO4iJubG61WK11fXye99suxwPKUTg0b89foa6pRd933MaclP1VAAYBzQdfPE+i6bjLeYTxB2JxzLm43H9MQQojhZHxminUtzAeDlmWpH374Qev1Wn/6058WcQrrY7p0AACXi6DyBGw20vvGEHRdF0PKZrOJ4cNYOKnrOlZnNptNDCAWYLbbbazc2JiM+WyrAACcA4LKE6jrOs5aauMR5uMSrDIynlSsaZqDgyStEmP/zisv6/U6jlsZdw8tbUAtAAD3Iag8EQsl424f6xKyLpv5mJSiKA5WQsbBZTyXh91n/Hh2nQUhYIxutjTRLmmiXdLEWT+4kw1+PfT60i4AgKc2P+uHigpO8pIzy+Lp0GZpol3SRLukiaCCByGwAABe0tnMo8LB82XxegMAXsLZBBXGQjyPY4Fkt9sRVgAAz+5sggpeBoEQAPCSCCo4CQEFAPAaCCq4EwFl2Wi/NNEuaTjUfT2+jnZKA0EFAHCxjoURxuClYzFBhf80wMMx6V6aaBfgdIsIKvM3NG9yAAAuAxO+AQCAZBFUAABAshbR9YM0MekbAOC5EVTwVcZjhRg7BAB4aovs+uFgmCbaJT20STpsQU+rQs4vP6cQgkIIJ213jPf+5G1Puf1rPOe+kZ5FBhUAWBKrNh77eUxYcc6p6zo55+JP0zSTbYZhkPdewzDIOSfp7oP8/P533bbZbO68/dC+xs+5aRo55yb78d6r7/v4uz33tm0n+5lfxnlbZNcPXQxpol3SQ5uct0OhI4SgLMvi77aNXee9V1EUkm6DzHgfIYQYaLz3quta0m3AsN9Nnufy3ivPc4UQVBRFDBfjfWVZFh9v/JznFRrbp3NO3nvd3Nyo6zoVRaFvvvlGwzDEx5Ckvu+VZVn8e+25lGV58uuHZVhkUAEASEVRTA7MRVHIOaeqquSc0/X19WT71WqlEIKGYTw1S3AAAArMSURBVFBd15MAId0GErtuvN++71XXdQwx0peKR57nattWv/vd79S2bax2OOcOhgZ7znb7eJ/OOb19+zaGkffv38fbLOAMwxCrMWVZqmmaeBnniaACAAtUFIXatlXXdbESUVWVqqqSdBs0yrKMwSSEoPV6Pam4SLcBwKoTduAfhxjnXKyaZFmmPM+VZdkkiJRlqZ9//llN00wCTNd1qqoqPp5VPqxqMt+3PX5ZlhqGYe/vtX1st1tdX19ru90yXuUCMEYFABbIDux1XceDe13XkwO8cy6O+bBuks1mM9kmyzLVdR27byRNKi15nk+uPzT2xLpqxl0/FkCMdUNZyBlv13XdyX93WZba7XZ69+6dfvzxx0nownkiqADAwthB3sZtmCzLYkXFgsF4bMlms1HbtntdPnZfCz1jeZ5PLh8KKkVR6IcfflBRFAohTKo542qKXVdVlcqyjONlxgNqLdwURaGiKJTn+d5g42EYlOd5DGE4bwQVAFiYcbXiWEXBAoF1/QzDoK7rDm5vZwdZUPn48aO22+3Jz8cqN8MwxK6Z7Xarm5ubyXZ9308qNFVVqWka/fGPf5R0G6Q2m42cc/r8+bNWq5Xevn07CTwWzsYDa51ze11FOB8WU3ecGQAAz+O+s6/uuv3QbdbFMh/watUUSZMD96EKiqQYYvI8n1RO7HRmq3RYALFtrCpjjz8OEuOxK+PfbdzKoec7v80eM4Qw+VvHg3DHf8P47J+HeOjrjpfxawUtltEIKgDwzB4TVKy7g8/m50NQSdM8qCyy64f1ZdJEu6SHNlkem63WJoMDLh2nJwNAAqigAIcRVAAgUYcqYvOFQA+xbZZ++7FtnvJ2pI+gAgAJsDV/xmMj7jugnvvtL/UYSBtBBQASMa80cJAFCCrA2ZmXuueXOfilj8ACfLHIoMKbNk20SzruOuUSy8F7Cljo6ckAAOAyLDKo8K0wTbQLAOCpLTKoAHhZbdveeVn6slDeoUXr5pqmmaysO9+3c25yebytTe9u+r4/uC9bsM62PXS/8fU2Zfx46vmu6+LfBeB1LHKMCoCX5b2fLFJ3qHrWtm0MFc45hRAmC9CNQ4L3PgaCYRhUlmXczlbfNfM1XIZhUF3X8t7r5uZGNzc3ur6+lvde79+/j9s55/T27Vt9+PBBq9VKwzDo6upq8pztOXrvJ89//Dxvbm603W51dXWlm5sbZVmmn3/+ebIqMYDnQ1ABcK8sy7Rer+Pld+/e7S2CZ2Eiy7LJonRmHD7GC8uNr/fex4XyLDB47+OquxZ8uq5Tnucqy1K73U7r9Xry/MbP+dOnT1qv13sDU+1xbd/SdBVhC0yfPn1S0zTxudk+AbwMggqAe+V5HsOBVTisS2S8uq1zTt77SUAZV0QsCOR5Luec2raNXTDSbWjIskxFUUy2s0Bk+5c0eTzr/hlXObIsmzwf732s2th9Dq0qbM/VgopzbtIdBOBlMUYFwL3GFQY7kFt4sMqGc05FUcTLIQR57yfdNkVRKMsy1XUdg4qxSoZp23ZvfIgFmG+++Sbu/5tvvtHbt28njxNC0GazUVEUCiGoKIrYXTTvkrLna/+O9zN+3EOhBsDzW2RFhbkF0kS7nB/rhpG+DDodVxeyLFOWZeq6TnVdx4N813UxLMwVRaHNZhO7csz4d0nabDZ7ocFChnXzjMPNuIqTZZlCCGqaRkVRxK6mcVfVXX+zPR/73f4+AC+PigqAo2y8ifdeTdPEQa9FUUyqD1ZJsQpKnucHQ4r0ZUxICEEfP348evZPnucHqxs2WPeus3Gsa8fOQKqqSm3bxrEmFrrG+7Aqz7hbq+/7GKpOOZsJwNNbZEUFwMuw7hULIpIOVjkkxTN9DgUU208IQVVVxX1YEKjrOg5uHe+/7/u9Cs64cjOvwoyfj1VAbJumaWIQscvSbaVoHELG4cyeq3UNzbu9ADw/O8dwt6Sy/Xh1UaSDdknDXe3w2Nvwde57bXntXwfvhzT9Ov1BnAOBigpw4Vj4DkDKCCrAhSKgAFgCggpwYZ4ioByamXa8vyXePt7mOW6nKyFNrFGWPsao4MnQLmm4r9/9mIcc6PEwjFFZBtohDWcxRoX/SGmiXZZh/q3/ULvRlrhE/L9P0yKDCoCvd0pgAYDXxoRvwIXb7Xba7Xb01QNI0iKDCh+oaaJdlo2KCi4dn2FpWmRQAQAAl4GgAgAAkkVQAQAAySKoAACAZC0yqDDoL020C4Al4zMsTYsMKgAA4DIQVAAAQLIWGVQ41z1NtAuAJeMzLE2LDCoAAOAyEFQAAECyCCoAACBZBBUAAJCs37z2E3gMznVPE+0CHMdAzfTxGZamRQYVAFgSDoDA49H1AwAAkrXIoEIJNU20C3Aa3itpol3StMigAgAALgNBBQAAJIugAgAAkkVQAQAAyVpkUOFUvzTRLsBpeK+kiXZJ0yKDCgAAuAwEFQAAkKxFBhXOdU8T7QKchvdKmmiXNC0yqAAAgMvAWj/Ahfnab40MOATwkggqwIX5mqBBaRzAS6PrBwAAJGuRQYXSc5poFxwSQlAIQV3XKYQg55xCCHvb2fVd18X7nSveK2miXdK0yKACYDmappEkee+VZZnKsozXmWEYNAyDsixTlmVq21Zt2778kwWQHMaoAHhWIQQNwyDvvZxzkqSqqtQ0jTabTQwwRVHE7TabjaTbAFMUxSs+ewCvbZFBZbVaUaJLEO2CQ6wrxzmnsizj71ZVsSDS9702m41CCGqaRiEE5Xl+lkGF90qaaJc02RD+3ZIah/9MaaJd0nBXO3xtGz32/n3fx8pJnudq21Z938fbrdIyDiVt2+51EZ0L3itpol3S8OvZhfEUQ8aoAHh2wzDEaskwDEfHnwzDIOecsix74WcIIFUEFQDPyjmnqqokSVmWaRiGvW1sEK2FFO997CYCcNkIKgCejfdeeZ5Luu3+KcsyntFT17W893FbCzRlWcbTlA+FGgCXZZFjVAAcl9oYlRDCnV05Nnbl0Db33RfA+ZmPUSGoAGfmMUHFpsa/73OAwYYAnts8qCzy9GQAT4O1ewCkbpFjVPhwTRPtshyr1Yr2ekW89mmiXdJERQW4MHd9GPNBDSA1BBXgwtgYk0OhhPEnAFKzyK4fAF9vt9sRTAAkj6ACXDgCC4CULTKo8KGaJtpl2Wi/l8NrnSbaJU2LDCoAAOAyEFQAAECyFhlUOIUyTbQLcBreK2miXdK0yKACAAAuA0EFAAAki6ACAACSRVABAADJWmRQ4Vz3NNEuwGl4r6SJdknTIoMKAAC4DAQVAACQrEUGFc51TxPtApyG90qaaJc0LTKoAACAy0BQAQAAySKoAACAZBFUAABAsggqAAAgWTbEecdEN8B5uO/MBd7rAFL262dY/CD7zes9FQDPgSAC4JwssuuHc93TRLukhzZJE+2SJtolTYsMKgAA4DIQVAAAQLIIKgAAIFkEFQAAkCyCCgAASBbzqAAAgGTM51GhogIAAJK1yKDCue5pol3SQ5ukiXZJE+2SpkUGFQAAcBkWGVQYTwOchvcKcDreL2laZFABAACXgaACAACSRVABAADJIqjgydC/C5yG9wpwOoIKAABIFkEFAAAki6ACAACSRVABAADJIqgAAIBkEVQAAECyCCoAACBZtlQkJ/UDAIBUsJQ1AAAAAAAAAAAAAAAAAAAAAAAAAAAAgIf6/181zO/89f3LAAAAAElFTkSuQmCC)
## <a name="_toc29185"></a>3.4状态机
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAaUAAAGCCAYAAABAe9wgAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAOxAAADsQBlSsOGwAAIABJREFUeJzt3XFwE2d+PvBHv7ler7EdlmYcJxnuspBMJkeMkXM0JoGMlPE1yTmXoDDTpMWARZMMCS1BEELaKWmVkunEhNoap4Q4N52K1HjmCKWym4JpYViOwtm5JF1sSGkP7PWFI+U8cywXKw38cfr94XuXXWklS7LsXUnPZ4bBklarVyvtPvt999UuQERE5BIe098Jx1pBRETlyJPujkQiwUwiIqKZ4/F4gKRg+n/ONIWIiCgVQ4mIiFyDoURERK7BUCIiItdgKBERkWswlIiIyDVyDqXfDOFLezuX5+b6/OmSTxvybbfH45nSMsz1OW5YvkRE2ZpypTTdv2+aiY1qIpGY0Y138jITt2eiDSIUzf+IiNzia1N5ssfjmVIo5fv8qb5uoV/HbjrzfdnOR4SjedpMoZHuscleK9v5ExHNtIIeU5pql5LdnrvdBnaqG9Vsn5Nt8GUTAvm+ZiKRSPlnni7d4wwbIipGeVdK+VQrdhtUsfE0b1DNr2H3/Kkq5lMqmZd7pvdRzO+RiMpX3pVSLhs9u+MYuVQObq0AcmlLuuVViEovm3m4abkREaUzpWNKQHZ77nb3T7aRzPZ4Sa7HbbKV7jhRprYU+vXsHrd7v8ndg3YBzsqJiIpBTpWSXVDkUsGk20hOdtzICenaZNfNmI2pVirJx9EyHXsiIipWWYdSpj35bPbyJ6t8ptoF5eaNcablk67aycRuWrvbuYQ9u/eIyA2yDqXJNvqTbdTsRszluiF0c/BkkksQZHufXaU0WXcdg4eI3K4gQ8JFt1G6sxWk24Amd+HlutHMN9xynf9Up0n3vGx+RJtLG3L5fRIRkRvlfOXZbA/IT2UeuZipH9Lm+prppsk2QDLNN9lUPw8iIifYXXmWl0MnIiJH8HLoRETkagwlIiJyDYYSERG5BkOJiIhcg6FERESuwVAiIiLXYCgREZFrMJSIiMg1GEpEROQaDCUiInINhhIREbkGQ4mIiFyDoURERK7BUCIiItdgKBERkWswlIiIyDUYSkRE5Bpfc7oBU2F3aXA7vKouEVFxKLpQMgdRtmGTz3OIiGjmFU0oiWDJJ1TMz/F4PAwmIiKXKopQKmSQJBKJKQUcERFNH1eH0nSFh5gfqyYiIndx7eg7ERjTGRrmqomIiJznylCayQqGwURE5B6uDKWZxmAiInIH14WSU8d5GExERM5zVShx4AERUXlzVSg5jdUSEZGzXBNKrJKIiMg1oeQWrJaIiJzjilBilURERIBLQomIiAhgKNliFx4RkTMYSkRE5BoMJSIicg2GEhERuQZDiYiIXIOhRERErsFQIiIi12AoERGRazCUbPAME0REzmAoERGRa7gilHgGBSIiAlwSSm7CrjsiIue4JpRYLRERkWtCyQ1YJREROctVocRqiYiovLkqlJzEKomIyHmuCyUnqiUGEhGRO7gulICZDSYGEhGRe7gylIDrwTSd4cRAIiJyl6853YBMRGAUOjxE0DGQiIjcxdWhJJi786YaJKyOiIjcqyhCCbBWTcn3TSaf5xAR0cwrmlASzKGS7fEmBhERUXEoulAySw4bds0RERU3146+IyKi8sNQIiIi12AoERGRazCUiIjINRhKRETkGgwlIiJyDYYSERG5BkOJiIhcg6FERESuwVAiIiLXYCgREZFrMJSIiMg1GEpEROQaDCUiInINhhIREblGSYWS+VpKuq5bHku+TURE7lMUF/nTNA2jo6NpH1dVFT6fD16v13J/KBRCJBIBAASDQUSjUUiSNK1tJSKi/InriSfcfMVWUeWIQAmHw/D7/fD7/bbTq6oKWZahqir8fj8URYHX64WqqvB6vQwmIiIX8Hg8wPUcAlAk3XeSJOUUJLFYDNFoFMBEhQRMBJW4j4iI3KkoQsmOoijo6enJ+XmskoiI3KtoQ8nv9yORSBjdcsm8Xi/8fj9kWTa6+mRZnvmGEhFR1opioEM6gUDAOHaUPMhBBJWmaVAUxYHWERFRroo6lICJisgcSIqioL6+3uim83g84mAaHnroIaxZswY+n8841kRERO5R9KGULHlE3tGjR+Hz+Yzb5r+JiMhdivaYEhERlZ6iDCW/359yDCmdQCAwza0hIqJCKYofzxIRUekp2h/PEhFReSipUBKj7IiIqDiVVCgREVFxYygREZFrMJSIiMg1GEpEROQaRX9Gh+TBDebbHOZORFRcir5SYvAQEZWOog+ldBhWRETFp2RDiYiIik9JhBKrIiKi0lASoZSMIUVEVJxKMpSIiKg4lUwosToiIip+JRNKAsOJiKh4lVwoERFR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ZTzzzDP46U9/6nSziBxnXjfEv2g06nSziDIq+lBqb28HAHz11Vf4r//6Lzz88MN49dVXHW4VkfPEunH16lX8+te/xtmzZzEyMuJwq4gyK4nrKZnb9NVXX+Hee+/Fp59+6nCrrNy43Kiw3PgZm9t0/vx5JBIJ3HnnnQ63ysqNy41mht31lPI6o4NbXb16FbFYDI899pjTTSFylf/93//FnXfeyY0/uV7Rd98JHo8H3/jGN/Dpp5/iz//8z51uDpFreDwe3HrrrU43gygrJRNKiUQC+/btw+23347f/d3fdbo5RK6RSCTw2WefOd0MoqyUTCgBwLJly3DgwAF88sknTjeFyFXmzJmDgwcPOt0MokkV/UCHa9eu4bd/+7dx9epVfP3rX8dHH32EDRs2IBaLobq62unmGdy23Kjw3PYZi3Xj2rVr+K3f+i2nm5OW25YbzRy7gQ5FXymFQiHL/4sWLcKDDz6Im2++2clmETnu2WefBQA888wzDreEKHtFXykVCy630sfPOD9cbuWrIJWSuJgZEdFUMZAoWdF33xERUenIK5RYLeWGe4PlgetFbrhekB1WStOMK155YTARTU3eocSVb3IMpPLEdWNyXDconSlVSmLl4wqYiitdeWMw2RPbC64blM6UT8gqvlzJK2A5funMy6Ac3z9Z2QVTOX4vuF5QLgp2lvDkL1s57iVyhaNkXC+4XlBupu3SFfwiEqXiekGUGUffERGRazCUiIjINRhKRETkGgwlIiJyDYYSERG5BkOJiIhcg6FERESuwVAiIiLXYCgREZFrMJSIiMg1GEpEROQaDCUiInINhhIREbkGQ4mIiFyDoURERK7BUCIiItdgKBERkWswlIiIyDUYSkRE5BoMJSIicg2GEhERuYbnN/8nHG0FERGVI8/kkxARERERERERERERERFZ/X/9MB2K45D3IgAAAABJRU5ErkJggg==)

![](data:image/png;base64,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dXZ2as+ePXr44YdHnX9oaEg9PT3q7u7WZz7zGUnS7373u1xWESXKsizt3r1bktTT06PGxkbt3btXmzZt0owZMzRz5kzdd9999vQLFy7UgQMH7H2ppaVF119/vaZOnaqpU6dq3bp1uuuuuySNtAiYf7QITFymEDDRG5lluoNsIcJAWXcNGPPnz9fcuXM1Z84cbdiwIW2zuxnFn+zee+/N+n1CoZAuX76sOXOe/4HAAAAb60lEQVTm6Atf+IICgYAOHTqUtn/25Zdf1kMPPaTOzk59+tOfljTSwtDc3Gw/RmnJ534Ui8Xss/iBgQH7+QULFujGG2/U8uXL7ZHfw8PDqq+v19DQkE6fPi1JCgQCWrBggWbMmKG+vr6UMILyNjw8rN/85jf230uWLNHcuXPt1//whz8kNPHPmDFDy5cvt7uEqqqqNHv2bL322muSRu4bYMYuOQe7vvnmm3rjjTfyvj6VarQQMFnSdQnku5ugIloEenp67EutDh06ZN+EIx0z0Mrw+XxZnZ1blqVly5Zp165dqqqq0tKlSzV37lw98sgjKU3Czz77rN566y21tLRo06ZN2rhxo2KxmDZv3qyrrrpKGzduHNcNiZBf+dyPXnvtNc2YMUMLFy5UIBDQ8uXL7feRpFdeeUWWZen48eMaHBxUV1eXrr76av3zP/+z9u/fr2PHjumrX/2qfvSjH2nz5s12BTA8PKyampqJrDZKQCwWU39/v2KxmObPn69169YlvP7hD384oULv6enRD37wg7Q3vnrxxRd1991322MEnK2W1157bX5XxGXyVTkX+oZfZR0EhoaGtGXLFq1atUoPPfSQhoeHdd9992nx4sXyeDxau3attmzZkvBluXjxoi5cuJCwnN27d6uzszPl4G50dXXpzjvv1LPPPptwlvhP//RPisfjmjZtmrZs2SLLshSLxbR37147MNTX1+uxxx7Tpk2b9MYbb2jXrl3at2+fbrvtNq1du5a7fJWAfO9HsVhM3d3damlp0YEDB+yR31u2bNHp06f1P//zP5o5c6amTZumbdu2qa6uTosWLdL+/ft14MABLVq0SJcuXdLq1at1//33q66uTmvXrtXu3bv17//+73Y3AUpXc3Ozbrzxxox3l5szZ47OnTtnd/8k70e///3v7RaBn/zkJ6qpqdG+ffvsriyju7tbzz33nHbs2JEwMNGy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)
# <a name="_toc3386"></a><a name="_toc12025"></a><a name="_toc19479"></a>**4.订单接口**
## <a name="_toc32760"></a><a name="_toc3656"></a><a name="_toc30057"></a>4.1收款码申请 
### <a name="_toc19268"></a>*4.1.1业务功能*
商户后台系统调用该API获取符合聚合收单平台规则的动态银标码。用户后续可使用第三方APP扫一扫功能发起“收款码主扫支付”。用户扫码支付失败后可在二维码有效期内且不更换支付方式的前提下再次扫码支付，如用户首次用微信扫码支付，支付失败后再用微信扫码则可以继续支付，但是若更换成支付宝扫码则不能继续支付。
### <a name="_toc10909"></a>*4.1.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|终端号|termId|String(8)|否|上送分行登记的终端号|
|支付有效时间|payValidTime|String(10)|否|二维码的有效时长，单位为秒，若商户上送，则以商户上送值为准，否则使用默认有效时长900秒|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知|
|交易金额|txnAmt|String(13)|是|单位为分|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|商品描述|body|String(128)|否|用于展示支付宝账单详情中的“商品说明”和微信账单详情中的“商品”字段，若不上送则默认显示商户简称。|
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在支付结果查询和支付结果通知时原样返回（不上送则不返回此字段）|
|实名支付信息|encryptIdentity|String(256)|否|<p>实名支付信息<br>` `{"need\_check": "T", //是否校验身份，T是F否<br>`   `"name": "",  //名字  <br>`    `"number": "",  //证件号<br>`    `"mobile": "",  //手机号      <br>`   `"type": "IDCARD" //证件类型，只支持身份证<br>`  `}</p><p>需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)</p>|
|保单单号|policyNo|String(100)|否|<p>保险实名支付对接中保信使用，由保险公司生成，须与实名认证上送中保信的“支付单号”一致。</p><p>如果交易有上送此字段则交易成功后会通知中保信做见费出单操作。</p><p>该字段和region需同时出现或同时不出现。</p>|
|地区码|region|String(64)|否|<p>缴税系统地区码按指引填写</p><p>全国： 000000<br>上海地区： 310000<br>深圳地区： 440300</p><p>该字段和policyNo需同时出现或同时不出现。</p>|
|终端信息|encryptTerminalInfo|String(6000)|否|商户侧受理终端信息，字段说明详见[终端信息terminalInfo](#_2.7.1_终端信息terminalinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|商户传入业务信息|businessParams|String(512)|否|支付宝支付专用字段。商户传入业务信息，应用于安全，营销等参数直传场景，格式为json格式。|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|

### <a name="_toc5251"></a>*4.1.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|二维码|qrCode|String(300)|是||
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|订单发送时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc32499"></a><a name="_toc12125"></a><a name="_toc5224"></a>4.2支付结果查询
### <a name="_toc18284"></a>*4.2.1业务功能*
<a name="_toc13403"></a><a name="_toc21947"></a>仅支持15天以内的交易查询，超过15天的交易发起查询将返回CMB\_ORDERID\_NOT\_EXIST或NOT\_ALLOW。

商户在一定时间内未收到支付结果通知的情况下必须主动发起支付结果查询，**若因商户没有实现查询机制而导致通知异常时无法准确获取支付结果则风险由商户自行承担。**支付结果查询应做以下处理：

收款码申请场景下建议商户在申请二维码15秒钟之后第一次发起查询，后续每5-10秒查询一次，查询10次之后还未支付，建议调关单接口关闭此笔订单并生成新的订单供用户再次支付。

付款码收款场景下建议商户在发起支付请求5秒钟之后第一次发起查询，后续每5-10秒查询一次，查询10次之后还未支付，建议调撤销接口关闭此笔订单并生成新的订单供用户再次支付。

微信统一下单和支付宝服务窗支付场景下建议商户在拉起支付5秒钟之后第一次发起查询，后续每5-10秒查询一次，查询10次之后还未支付，建议调关单接口关闭此笔订单并生成新的订单供用户再次支付。

若查询返回的returnCode和respCode为SUCCESS且tradeState为C（订单已关闭）、D（订单已撤销）、F（交易失败）、R（转入退款，表示已支付成功并发起了退款申请），或respCode未FAIL且errCode为ORDERID\_INVALID（订单已失效），则商户无需再次发起查询。

### <a name="_toc5652"></a>*4.2.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|商户订单号|orderId|String(32)|否|被查询交易的商户订单号，此字段和平台订单号字段至少要上送一个，若两个都上送，则以平台订单号为准|
|外部商户订单号|outOrderId|String(32)|否|支付宝先享后付订单的交易必须上送。支付宝先享后付-订单创建请求参数中的outOrderId|
|平台订单号|cmbOrderId|String(32)|否|被查询交易招行订单号，此字段和商户订单号字段至少要上送一个，若两个都上送，则以此字段为准|
|收银员|userId|String(32)|是|招行系统生成的收银员，需和被查询交易的收银员一致。|
|查询选项|queryOptions|String(1024)|否|<p>商户通过上送该参数来定制同步需要额外返回的信息字段（支付宝），数组形式的字符串</p><p>示例："[\"fund\_bill\_list\",\"voucher\_detail\_list\",\"discount\_goods\_detail\"]"</p><p>参考：https://opendocs.alipay.com/apis/api\_1/alipay.trade.query</p>|

### <a name="_toc3500"></a><a name="_toc13200"></a><a name="_toc27261"></a>*4.2.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|否|请求报文中的商户订单号|
|外部商户订单号|outOrderId|String(32)|否|请求报文中的外部商户订单号|
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，并非交易结果是失败状态，需要商户再次发起查询确认|
|第三方错误描述|errDescription|String(256)|否|查询交易在第三方处理失败时返回第三方的错误信息|
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|交易金额|txnAmt|String(13)|是|单位为分|
|优惠金额|dscAmt|String(13)|是|单位为分|
|银联优惠信息|couponInfo|String(500)|否|银联通道且有优惠活动时出现，字段说明详见[2.6.3.银联优惠信息](#_2.6.3.银联优惠信息)|
|优惠券信息|promotionDetail|String|否|微信、支付宝优惠券信息，规则见[2.6.2.优惠券信息](#_2.6.2.优惠券信息)|
|银联付款方附加数据|issAddnData|String（8000）|否|银联通道且有商品优惠时返回，字段说明详见[2.6.3.银联优惠信息](#_2.6.3.银联优惠信息)|
|订单原始金额|orderOrigAmt|String(13)|否|单位为分，请求上送orderOrigAmt则对应返回该内容|
|订单优惠金额|orderCouponAmt|String(13)|否|单位为分，请求上送orderCouponAmt则对应返回该内容|
|支付宝商品优惠信息|discountGoodsDetail|String（1024）|否|<p>支付宝本次交易支付所使用的单品券优惠的商品优惠信息，示例如下：</p><p>[{"goodsId":"STAN DARD1026181538","goodsName":"雪碧","discountAmount":"10.00"}]</p>|
|交易币种|currencyCode|String(3)|是|默认156，目前只支持人民币（156）|
|支付方式|payType|String(2)|是|<p>目前支持：支付宝/微信/银联/数字人民币<br>ZF：支付宝<br>WX：微信<br>YL：银联</p><p>EC：数字人民币</p>|
|用户标识|openId|String(128)|否|支付宝支付：用户在支付宝系统的唯一标识<br>微信支付：商户上送sub\_appid时返回用户在sub\_appid下的sub\_openid|
|用户标识|oriOpenId|String(128)|否|对应openId|
|付款银行|payBank|String(32)|否|<p>支付宝支付：</p><p>ALIPAYACCOUNT 支付宝账户</p><p>PCREDIT 蚂蚁花呗</p><p>DEBIT\_CARD 借记卡<br>CREDIT\_CARD 信用卡<br>MIXED\_CARD 借贷合一卡 等</p><p>微信支付：CMB\_CREDIT 等</p>|
|第三方订单号|thirdOrderId|String(64)|否|支付宝、微信侧的订单号|
|支付宝账户|buyerLogonId|String(64)|否|支付宝支付的交易返回，如：koh\*\*\*@sandbox.com|
|交易状态|tradeState|String(1)|是|C - 订单已关闭<br>D - 交易已撤销<br>P - 交易在进行<br>F - 交易失败<br>S - 交易成功<br>R - 转入退款|
|订单发送时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|订单完成日期|endDate|String(8)|否|第三方系统返回的交易完成日期，此日期仅在交易成功是返回，不保证是实际清算日期，格式为yyyyMMdd|
|订单完成时间|endTime|String(6)|否|第三方系统返回的交易完成时间，此时间仅在交易成功是返回，格式为HHmmss<br>支付宝和微信通道的成功交易返回此字段<br>银联通道的交易无论成功与否，均不返回此字段|
|商户保留域|mchReserved|String(128)|否|若被查询交易有上送此字段，则返回此字段|
|合约响应内容|contractResp|String|否|合约响应内容，字段说明详见[2.7.2.2合约收款响应内容contractResp](#_2.7.2.2_合约收款响应内容contractresp)|
|付款运营机构编码|debtorAgentId|String(14)|否||
|付款运营机构名称|debtorAgentName|String(60)|否||
|数字人民币优惠详情|ecnyPromotionDetail|String|否|数字人民币优惠详情信息，字段说明详见[2.6.6数字人民币优惠详情](#_2.6.6.数字人民币优惠详情)。|
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc7553"></a><a name="_toc4440"></a><a name="_toc31158"></a>4.3支付结果通知
### <a name="_toc23205"></a>*4.3.1业务功能*
招行发出的通知报文是formdata格式，商户应答的报文须为json字符串。第三方平台受理支付交易扣款完成后将支付结果告知聚合收单平台，聚合收单平台将此支付结果发送到商户指定的notifyUrl。

注：只有成功支付的交易才会有支付结果通知，支付结果通知招行需要提前申请到商户回调地址的网络，正常需要2-3个工作日，请提起提供。

**商户不得依赖招行的支付结果通知，必须在一定时间内未收到通知时主动发起支付结果查询。**
### <a name="_toc30687"></a><a name="_toc12323"></a><a name="_toc30891"></a>*4.3.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|商户订单号|orderId|String(32)|是|支付交易的商户订单号|
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|收银员|userId|String(32)|否|支付交易的收银员信息，若有，则返回|
|交易金额|txnAmt|String(13)|是|单位为分|
|优惠金额|dscAmt|String(13)|是|单位为分|
|银联优惠信息|couponInfo|String(500)|否|银联通道且有优惠活动时出现，字段说明详见[2.6优惠信息字段说明](#_2.6优惠信息字段说明)|
|订单原始金额|orderOrigAmt|String(13)|否|单位为分，请求上送orderOrigAmt则对应返回该内容|
|订单优惠金额|orderCouponAmt|String(13)|否|单位为分，请求上送orderCouponAmt则对应返回该内容|
|优惠券信息|promotionDetail|String|否|微信、支付宝优惠券信息，规则见[2.6优惠信息字段说明](#_2.6优惠信息字段说明)|
|交易币种|currencyCode|String(3)|是|目前只支持人民币（156）|
|支付方式|payType|String(2)|是|<p>目前支持：支付宝/微信/银联/数字人民币<br>ZF：支付宝<br>WX：微信<br>YL：银联</p><p>EC：数字人民币</p>|
|用户标识|openId|String(128)|否|支付宝支付：用户在支付宝系统的唯一标识<br>微信支付：商户上送sub\_appid时返回用户在sub\_appid下的sub\_openid|
|用户标识|oriOpenId|String(128)|否|对应openId|
|付款银行|payBank|String(32)|否|<p>支付宝支付：</p><p>ALIPAYACCOUNT 支付宝账户</p><p>PCREDIT 蚂蚁花呗</p><p>DEBIT\_CARD 借记卡<br>CREDIT\_CARD 信用卡<br>MIXED\_CARD 借贷合一卡 等</p><p>微信支付：CMB\_CREDIT 等</p>|
|第三方订单号|thirdOrderId|String(64)|否|支付宝、微信侧的订单号|
|支付宝账户|buyerLogonId|String(64)|否|支付宝支付的交易返回，如：koh\*\*\*@sandbox.com|
|订单发送时间|txnTime|String(14)|是|支付订单生成的时间，格式为yyyyMMddHHmmss|
|订单完成日期|endDate|String(8)|否|第三方系统返回的交易完成日期，此日期仅在交易成功是返回，不保证是实际清算日期，格式为yyyyMMdd|
|订单完成时间|endTime|String(6)|否|第三方系统返回的交易完成时间，此时间仅在交易成功是返回，格式为HHmmss<br>支付宝和微信通道的成功交易返回此字段<br>银联通道的交易无论成功与否，均不返回此字段|
|商户保留域|mchReserved|String(128)|否|若原交易有上送此字段，则返回此字段|
|合约响应内容|contractResp|String|否|合约响应内容，字段说明详见[2.7.2.2合约收款响应内容contractResp](#_2.7.2.2_合约收款响应内容contractresp)|
|付款运营机构编码|debtorAgentId|String(14)|否||
|付款运营机构名称|debtorAgentName|String(60)|否||
|数字人民币优惠详情|ecnyPromotionDetail|String|否|数字人民币优惠详情信息，字段说明详见[2.6.6数字人民币优惠详情](#_2.6.6.数字人民币优惠详情)。|

### <a name="_toc20346"></a>*4.3.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,SUCCESS表示商户接收通知成功并校验成功|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|响应码|respCode|String(10)|是|商户返回的业务错误码，成功为SUCCESS，失败为FAIL|
|应答信息|respMsg|String(256)|否|请求处理失败的详细描述信息|

## <a name="_toc14323"></a>4.4退款申请
### <a name="_toc31039"></a>*4.4.1业务功能*
当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，平台将在收到商户发起的退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上。 

注意：

1. 退款支持单笔交易分多次退款，多次退款需要提交原支付订单的平台订单号和设置不同的退款单号。申请退款总金额不能超过订单金额。 一笔退款失败后重新提交，请不要更换退款单号，请使用原商户退款单号。
1. 请求频率限制：150qps，即每秒钟正常的申请退款请求次数不超过150次；

   错误或无效请求频率限制：6qps，即每秒钟异常或错误的退款申请请求不超过6次；

3. 每个支付订单的部分退款次数不能超过50次；
3. 测试环境不支持隔日退款，且第三方公司不进行清算，隔日资金无法退回。
### <a name="_toc6821"></a>*4.4.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付退款场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付退款场景，附加经营商户号和经营商户门店号需同时上送|
|商户退款订单号|orderId|String(32)|是|商户端生成退款订单号，要求此订单号整个商户下唯一|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|原交易商户订单号|origOrderId|String(32)|否|原交易的商户订单号，此字段和原交易平台订单号字段至少要上送一个，若两个都上送，则以原交易平台订单号为准|
|原外部商户订单号|origOutOrderId|String(32)|否|支付宝先享后付订单的交易必须上送。支付宝先享后付-订单创建请求参数中的outOrderId|
|原交易平台订单号|origCmbOrderId|String(32)|否|原交易招行订单号，此字段和原交易商户订单号字段至少要上送一个，若两个都上送，则以此字段为准|
|交易通知地址|notifyUrl|String(256)|否|若为空则通知到原交易的通知地址|
|交易金额|txnAmt|String(13)|是|原交易金额，单位为分|
|退款金额|refundAmt|String(13)|是|退款金额，单位为分，refundAmt=refundOrigAmt-refundCouponAmt；|
|退单原始金额|refundOrigAmt|String(13)|否|退单原始金额，单位为分，与refundCouponAmt同时出现|
|退单优惠金额|refundCouponAmt|String(13)|否|退单优惠金额，单位为分，与refundOrigAmt同时出现|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|退款原因|refundReason|String(256)|否||
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在退款结果查询和退款结果通知时原样返回|
|银联收款方附加数据|acqAddnData|String（8000）|否|银联通道且有商品优惠时出现，字段说明详见[2.6.3.银联优惠信息](#_2.6.3.银联优惠信息)|
|支付宝商品列表|goodsDetail|Object|否|支付宝通道且有商品优惠时出现，字段说明详见[2.6.5 支付宝商品列表](#_2.6.5 支付宝商品列表)|
|查询选项|queryOptions|String(1024)|否|<p>商户通过上送该参数来定制同步需要额外返回的信息字段（支付宝），数组形式的字符串</p><p>示例："查询选项，商户通过上送该参数来定制同步需要额外返回的信息字段，数组格式。如："[\"refund\_detail\_item\_list\"]"</p><p>参考：https://opendocs.alipay.com/apis/api\_1/alipay.trade.refund</p>|
|合约退款请求内容|contractRefundReq|String|否|json格式字符串，字段说明详见[2.7.2.3合约退款请求内容contractRefundReq](#_2.7.2.3_合约退款请求内容contractrefundreq)|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
### <a name="_toc17982"></a>*4.4.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户退款订单号|orderId|String(32)|是|请求报文中的商户退款订单号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，并非退款结果是失败状态，需要商户再次发起查询确认|
|第三方错误描述|errDescription|String(256)|否|退款交易在第三方处理失败时返回第三方的错误信息|
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|平台退款订单号|cmbOrderId|String(32)|是|退款受理成功时返回，招行生成的退款订单号|
|退款金额|refundAmt|String(13)|是|单位为分|
|优惠金额|refundDscAmt|String(13)|是|单位为分|
|银联优惠信息|couponInfo|String(500)|否|银联通道且有优惠活动时出现，字段说明详见[2.6.3.银联优惠信息](#_2.6.3.银联优惠信息)|
|银联付款方附加数据|issAddnData|String（8000）|否|银联通道且有商品优惠时出现，字段说明详见[2.6.3.银联优惠信息](#_2.6.3.银联优惠信息)|
|微信优惠退款详情|refundDetail|Object|否|微信通道且有优惠时返回退款优惠详细信息,字段说明详见[2.6.4.微信退款详情](#_2.6.4.微信退款详情)|
|第三方订单号|thirdOrderId|String(64)|否|支付宝、微信侧的订单号|
|退款处理状态|refundState|String(1)|是|<p>P 退款正在处理（原交易为微信渠道）<br>S 退款成功（原交易为支付宝、银联渠道）</p><p>F 退款失败（原交易为微信、支付宝、银联渠道）<br>仅当respCode为SUCCESS时出现</p>|
|失败原因|failureReason|String(128)|否|refundState退款状态为F时返回|
|订单发送时间|txnTime|String(14)|是|退款订单生成时间，格式为yyyyMMddHHmmss|
|订单完成日期|endDate|String(8)|否|第三方系统返回的交易完成日期，此日期仅在交易成功是返回，不保证是实际清算日期，格式为yyyyMMdd<br>若原交易是支付宝和银联通道，则退款成功时返回此字段；<br>若原交易是微信通道，则不返回此字段；|
|订单完成时间|endTime|String(6)|否|第三方系统返回的交易完成时间，此时间仅在退款成功是返回，格式为HHmmss<br>若原交易是支付宝通道，则退款成功时返回此字段<br>若原交易是银联和微信通道，则不返回此字段|
|合约退款响应内容|contractRefundResp|String|否|json格式字符串，字段内容详见[2.7.2.4合约退款响应内容contractRefundResp](#_2.7.2.4_合约退款响应内容contractrefundresp)|
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc5377"></a>4.5退款结果查询
### <a name="_toc28993"></a>*4.5.1业务功能*
仅支持15天以内的查询，超过15天的交易发起查询将返回CMB\_ORDERID\_NOT\_EXIST或NOT\_ALLOW。异步查询退款申请处理结果，查询机制建议30秒查一次，查询10分钟仍为P状态则停止查询并以T+1日对账单中状态为准。
### <a name="_toc2906"></a>*4.5.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|原外部商户订单号|origOutOrderId|String(32)|否|支付宝先享后付订单的交易必须上送。支付宝先享后付-订单创建请求参数中的outOrderId|
|商户退款订单号|orderId|String(32)|否|被查询交易的商户退款订单号，此字段和平台退款订单号字段至少要上送一个，若两个都上送，则以平台退款订单号为准|
|平台退款订单号|cmbOrderId|String(32)|否|被查询交易招行退款订单号，此字段和商户退款订单号字段至少要上送一个，若两个都上送，则以此字段为准|
|收银员|userId|String(32)|是|招行系统生成的收银员，需和被查询交易的收银员一致。|
|查询选项|queryOptions|String(1024)|否|<p>商户通过上送该参数来定制同步需要额外返回的信息字段（支付宝），数组形式的字符串</p><p>示例："查询选项，商户通过上送该参数来定制同步需要额外返回的信息字段，数组格式。如："[\"refund\_detail\_item\_list\"]"</p><p>参考https://opendocs.alipay.com/apis/api\_1/alipay.trade.fastpay.refund.query</p>|

### <a name="_toc22321"></a>*4.5.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户退款订单号|orderId|String(32)|否|请求报文中的商户退款订单号，有则返回|
|平台退款订单号|cmbOrderId|String(32)|是|招行生成的退款订单号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，并非退款结果是失败状态，需要商户再次发起查询确认|
|第三方错误描述|errDescription|String(256)|否|查询交易在第三方处理失败时返回第三方的错误信息|
||||||
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|退款金额|refundAmt|String(13)|是|单位为分|
|优惠金额|refundDscAmt|String(13)|是|单位为分|
|银联优惠信息|couponInfo|String(500)|否|银联通道且有优惠活动时出现，字段说明详见[2.6.3.银联优惠信息](#_2.6.3.银联优惠信息)|
|银联付款方附加数据|issAddnData|String（8000）|否|银联通道且有商品优惠时返回，字段说明详见[2.6.3.银联优惠信息](#_2.6.3.银联优惠信息)|
|微信优惠退款详情|refundDetail|Object|否|微信通道且有优惠时返回退款优惠详细信息,字段说明详见[2.6.4.微信退款详情](#_2.6.4.微信退款详情)|
|退单原始金额|refundOrigAmt|String(13)|否|退单原始金额，单位为分，请求上送refundOrigAmt则返回该内容|
|退单优惠金额|refundCouponAmt|String(13)|否|退单原始金额，单位为分，请求上送refundCouponAmt则返回该内容|
|第三方订单号|thirdOrderId|String(64)|否|支付宝、微信侧的订单号|
|交易币种|currencyCode|String(3)|是|默认156，目前只支持人民币（156）|
|交易状态|tradeState|String(1)|是|P 预退款完成<br>F 失败<br>S 退款成功|
|订单发送时间|txnTime|String(14)|是|退款订单生成时间，格式为yyyyMMddHHmmss|
|订单完成日期|endDate|String(8)|否|第三方系统返回的交易完成日期，此日期仅在退款成功是返回，不保证是实际清算日期，格式为yyyyMMdd|
|订单完成时间|endTime|String(6)|否|第三方系统返回的交易完成时间，此时间仅在退款成功是返回，格式为HHmmss<br>支付宝和微信通道的成功退款交易返回此字段<br>银联通道的退款交易无论成功与否，均不返回此字段|
|商户保留域|mchReserved|String(128)|否|若退款交易有上送此字段，则返回此字段|
|合约退款响应内容|contractRefundResp|String|否|json字符串，字段说明详见[2.7.2.4合约退款响应内容contractRefundResp](#_2.7.2.4_合约退款响应内容contractrefundresp)|
|失败原因|failureReason|String(128)|否|退款状态为F时返回|
|数字人民币优惠详情|ecnyPromotionDetail|String|否|数字人民币优惠详情信息，字段说明详见[2.6.6数字人民币优惠详情](#_2.6.6.数字人民币优惠详情)。|
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc28983"></a>4.6退款结果通知
### <a name="_toc1720"></a>*4.6.1业务功能*
招行发出的通知报文是formdata格式，商户应答的报文须为json字符串。第三方平台受理退款交易完成后将退款结果告知聚合收单平台，聚合收单平台将此退款结果发送到商户指定的notifyUrl。只有退款成功的交易才会有退款结果通知。

**商户不得依赖招行的退款结果通知，必须在一定时间内未收到通知时主动发起退款结果查询。**

### <a name="_toc18152"></a>*4.6.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|商户退款订单号|orderId|String(32)|是|退款申请时上送的商户订单号|
|平台退款订单号|cmbOrderId|String(32)|是|招行生成的退款订单号|
|收银员|userId|String(32)|否|退款交易的收银员信息，若退款交易有上送则返回|
|退款金额|refundAmt|String(13)|是|单位为分|
|优惠金额|refundDscAmt|String(13)|是|单位为分|
|银联优惠信息|couponInfo|String(500)|否|银联通道且有优惠活动时出现，字段说明详见[2.6.3.银联优惠信息](#_2.6.3.银联优惠信息)|
|银联付款方附加数据|issAddnData|String(8000)|否|银联通道且有商品优惠时出现，字段说明详见[2.6.3.银联优惠信息](#_2.6.3.银联优惠信息)|
|退单原始金额|refundOrigAmt|String(13)|否|退单原始金额，单位为分，请求上送refundOrigAmt则返回该内容|
|退单优惠金额|refundCouponAmt|String(13)|否|退单原始金额，单位为分，请求上送refundCouponAmt则返回该内容|
|第三方订单号|thirdOrderId|String(64)|否|支付宝、微信侧的订单号|
|交易币种|currencyCode|String(3)|是|目前只支持人民币（156）|
|支付方式|payType|String(2)|是|<p>目前支持：支付宝/微信/银联/数字人民币<br>ZF：支付宝<br>WX：微信<br>YL：银联</p><p>EC：数字人民币</p>|
|订单发送时间|txnTime|String(14)|是|退款订单生成的时间，格式为yyyyMMddHHmmss|
|订单完成日期|endDate|String(8)|否|第三方系统返回的交易完成日期，此日期仅在交易成功是返回，不保证是实际清算日期，格式为yyyyMMdd|
|订单完成时间|endTime|String(6)|否|第三方系统返回的交易完成时间，此时间仅在交易成功是返回，格式为HHmmss<br>支付宝和微信通道的成功交易返回此字段<br>银联通道的交易无论成功与否，均不返回此字段|
|商户保留域|mchReserved|String(128)|否|若退款交易有上送此字段，则返回此字段|
|微信优惠退款详情|refundDetail|Object|否|微信通道且有优惠时返回退款优惠详细信息,字段说明详见[2.6.4.微信退款详情](#_2.6.4.微信退款详情)|
|合约退款响应内容|contractRefundResp|String|否|Json格式字符串，字段说明详见[2.7.2.4合约退款响应内容contractRefundResp](#_2.7.2.4_合约退款响应内容contractrefundresp)|
|数字人民币优惠详情|ecnyPromotionDetail|String|否|数字人民币优惠详情信息，字段说明详见[2.6.6数字人民币优惠详情](#_2.6.6.数字人民币优惠详情)。|

### <a name="_toc16878"></a>*4.6.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,SUCCESS表示商户接收通知成功并校验成功|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|响应码|respCode|String(10)|是|商户返回的业务错误码，成功为SUCCESS，失败为FAIL|
|应答信息|respMsg|String(256)|否|请求处理失败的详细描述信息|

## <a name="_toc9484"></a>4.7 关闭订单
### <a name="_toc10831"></a>*4.7.1业务功能*
针对收款码申请、统一下单、支付宝native支付、服务窗支付的未支付交易可以调用此接口关闭订单，关闭后的订单用户将无法再对此订单发起支付，支付成功的交易不允许关单，返回respCode为ORDER\_PAID，需调用退款接口。
### <a name="_toc19743"></a>*4.7.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|原交易商户订单号|origOrderId|String(32)|否|被关闭交易的商户订单号，此字段和被关闭交易平台订单号字段至少要上送一个，若两个都上送，则以被关闭交易平台订单号为准|
|外部商户订单号|origOutOrderId|String(32)|否|支付宝先享后付订单的交易必须上送。支付宝先享后付-订单创建请求参数中的outOrderId|
|原交易平台订单号|origCmbOrderId|String(32)|否|被关闭交易招行订单号，此字段和被关闭交易商户订单号字段至少要上送一个，若两个都上送，则以此字段为准|
|收银员|userId|String(32)|是|招行系统生成的收银员，需和被关闭交易的收银员一致。|

### <a name="_toc20883"></a>*4.7.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|origOrderId|String(32)|否|请求报文中的商户订单号，若有则返回|
|外部商户订单号|origOutOrderId|String(32)|否|请求报文中的外部商户订单号，若有则返回|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，并非关单结果是失败状态，需要商户再次发起查询确认|
|第三方错误描述|errDescription|String(256)|否|关单交易在第三方处理失败时返回第三方的错误信息|
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|关单处理状态|closeState|String(1)|是|C 订单关闭成功<br>F 被关闭交易为失败状态，关单失败|
|订单发送时间|txnTime|String(14)|是|关闭订单申请处理时间，格式为yyyyMMddHHmmss|
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|


## <a name="_toc12157"></a>4.8付款码收款
### <a name="_toc32288"></a>*4.8.1业务功能*
商户系统用扫码设备扫描用户展示的微信、支付宝、银联等付款码完成收款功能。在无需输入密码时是同步返回支付结果的（F或S），如需用户输入密码，则会返回P。若招行返回的非F或S状态，则需商户主动发起查询。
### <a name="_toc6785"></a>*4.8.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用，暂不支持数币场景|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|子公众账号ID|subAppId|String(32)|否|商户微信公众号appid，非微信支付模式可不填，若此字段有上送，则同步返回用户在此subAppId下的sub\_openid|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|授权码|authCode|String(128)|是|支付授权码，设备读取用户APP的条码或者二维码信息|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|终端编号|termId|String(8)|是|银联二维码专用的终端编号，招行为商户每个终端设备提供的唯一编号，由招行业务人员单独提供（2月1日后考虑下线）|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知。|
|交易金额|txnAmt|String(13)|是|单位为分|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|商品描述|body|String(128)|否|用于展示支付宝账单详情中的“商品说明”和微信账单详情中的“商品”字段，若不上送则默认显示商户简称。|
|商品优惠信息|itemDiscount|String(6000)|否|第三方单品优惠信息描述，规则见[2.6优惠信息字段说明](#_2.6优惠信息字段说明_1)|
|商品标记|goodsTag|String(32)|否|商品标记，代金券或立减优惠功能的参数，详见微信官网文档中的代金券或立减优惠说明。|
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在支付结果查询时原样返回|
|实名支付信息|encryptIdentity|String(256)|否|<p>实名支付信息<br>` `{"need\_check": "T", //是否校验身份，T是F否<br>`   `"name": "",  //名字  <br>`    `"number": "",  //证件号<br>`    `"mobile": "",  //手机号      <br>`   `"type": "IDCARD" //证件类型，只支持身份证<br>`  `}</p><p>需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)</p>|
|附加数据|attach|String(127)|否|如“深圳分店”|
|限定支付方式|limitPay|String(32)|否|no\_credit--指定不能使用信用卡支付；<br>为空表示无限制|
|保单单号|policyNo|String(100)|否|<p>保险实名支付对接中保信使用，由保险公司生成，须与实名认证上送中保信的“支付单号”一致。</p><p>如果交易有上送此字段则交易成功后会通知中保信做见费出单操作。</p><p>该字段和region需同时出现或同时不出现。</p>|
|地区码|region|String(64)|否|<p>缴税系统地区码按指引填写</p><p>全国： 000000<br>上海地区： 310000<br>深圳地区： 440300</p><p>该字段和policyNo需同时出现或同时不出现。</p>|
|查询选项|queryOptions|String(1024)|否|<p>商户通过上送该参数来定制同步需要额外返回的信息字段（支付宝），**数组形式的字符串**</p><p>示例："[\"fund\_bill\_list\",\"voucher\_detail\_list\",\"discount\_goods\_detail\"]"</p><p>参考：https://opendocs.alipay.com/apis/api\_1/alipay.trade.pay</p>|
|终端信息|encryptTerminalInfo|String(6000)|是|商户侧受理终端信息，字段说明详见<a name="_hlt154070530"></a>[终端信息terminalInfo](#_2.7.1_终端信息terminalinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|微信设备号|deviceInfo|String(32)|否|微信终端设备号(商户自定义，如门店编号)|
|数字人民币支付参数|ecnyPayment|String|否|json格式字符串。当使用数字人民币支付时需上送。字段说明详见[2.7.3数币支付参数](#_2.7.3数币支付参数ecnypayment)|
|商户传入业务信息|businessParams|String(512)|否|支付宝支付专用字段。商户传入业务信息，应用于安全，营销等参数直传场景，格式为json格式。|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|

### <a name="_toc10285"></a>*4.8.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，并非交易结果是失败状态，需要商户再次发起查询确认|
|第三方错误描述|errDescription|String(256)|否|付款码收款交易在第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|支付方式|payType|String(2)|是|<p>目前支持：支付宝/微信/银联/数字人民币<br>ZF：支付宝<br>WX：微信<br>YL：银联</p><p>EC：数字人民币</p>|
|用户标识|openId|String(128)|否|支付宝支付：用户在支付宝系统的唯一标识<br>微信支付：商户上送sub\_appid时返回用户在sub\_appid下的sub\_openid|
|付款银行|payBank|String(32)|否|<p>支付宝支付：</p><p>ALIPAYACCOUNT 支付宝账户</p><p>PCREDIT 蚂蚁花呗</p><p>DEBIT\_CARD 借记卡<br>CREDIT\_CARD 信用卡<br>MIXED\_CARD 借贷合一卡 等</p><p>微信支付：CMB\_CREDIT 等</p>|
|第三方订单号|thirdOrderId|String(64)|否|支付宝、微信侧的订单号|
|支付宝账户|buyerLogonId|String(64)|否|支付宝支付的交易返回，如：koh\*\*\*@sandbox.com|
|交易状态|tradeState|String(1)|是|P - 支付状态未知（可能需要用户输入支付密码）<br>F - 支付失败<br>S - 支付成功|
|交易金额|txnAmt|String(13)|是|单位为分|
|优惠金额|dscAmt|String(13)|是|单位为分|
|优惠券信息|promotionDetail|String|否|微信、支付宝优惠券信息，规则见[2.6优惠信息字段说明](#_2.6优惠信息字段说明)|
|支付宝商品优惠信息|discountGoodsDetail|String（1024）|否|<p>支付宝本次交易支付所使用的单品券优惠的商品优惠信息，示例如下：</p><p>[{"goodsId":"STAN DARD1026181538","goodsName":"雪碧","discountAmount":"10.00"}]</p>|
|订单发送时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|订单完成日期|endDate|String(8)|否|第三方系统返回的交易完成日期，此日期仅在交易成功是返回，不保证是实际清算日期，格式为yyyyMMdd<br>若交易是支付宝和微信通道，则交易成功时返回此字段；<br>若交易是银联通道，则不返回此字段；|
|订单完成时间|endTime|String(6)|否|第三方系统返回的交易完成时间，此时间仅在成功是返回，格式为HHmmss<br>若交易是支付宝和微信通道，则成功时返回此字段<br>若交易是银联通道，则不返回此字段|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc9135"></a>4.9付款码支付撤销
### <a name="_toc7370"></a>*4.9.1业务功能*
商户系统对指定付款码支付交易发起撤销。支付交易返回失败或支付系统超时，调用该接口撤销交易。如果此订单用户支付失败，聚合收单平台会将此订单关闭；支付成功的交易不允许撤销，返回respCode为ORDER\_PAID，需调用退款接口。

注意：7 天以内的交易单可调用撤销，其他正常支付的单如需实现相同功能请调用退款 申请API。提交支付交易后调用【支付结果查询 API】，没有明确的支付结果再调用【付款码支付撤销API】。调用支付接口后请勿立即调用付款码支付撤销API，建议支付后至少 15s 后再调用该撤销接口。
### <a name="_toc8962"></a>*4.9.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|原交易商户订单号|origOrderId|String(32)|否|被撤销交易的商户订单号，此字段和被撤销交易平台订单号字段至少要上送一个，若两个都上送，则以被撤销交易平台订单号为准|
|原交易平台订单号|origCmbOrderId|String(32)|否|被撤销交易招行订单号，此字段和被撤销交易商户订单号字段至少要上送一个，若两个都上送，则以此字段为准|
|收银员|userId|String(32)|是|招行系统生成的收银员，需和被撤销交易的收银员一致。|

### <a name="_toc24176"></a>*4.9.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|origOrderId|String(32)|否|请求报文中的商户订单号，若有则返回|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，并非撤销结果是失败状态，需要商户再次发起查询确认|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|撤销处理状态|cancelState|String(1)|是|<p>C 被撤销的交易已经被关闭</p><p>D 撤销成功<br>F 被撤销交易为失败状态，撤销失败</p>|
|订单发送时间|txnTime|String(14)|是|撤销申请处理时间，格式为yyyyMMddHHmmss|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc6614"></a>4.10微信统一下单
### <a name="_toc22212"></a>*4.10.1业务功能*
用户通过商户APP或商户H5商城在线下单购买商品，在选择支付方式时选微信支付，商家可调用此接口完成向微信后台的下单流程，目前已支持的有APP支付、公众号支付和小程序支付。
### <a name="_toc27148"></a>*4.10.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|设备号|deviceInfo|String(32)|否|PC网页或公众号内支付请传"WEB"|
|子公众账号ID|subAppId|String(32)|是|商户微信公众号appid，app支付时,为在微信开放平台上申请的APPID<br>小程序支付：当前调起支付的小程序APPID<br>APP支付：子商户在微信开放平台上申请的APPID<br>公众号支付：公众号APPID|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|交易类型|tradeType|String(16)|是|APP支付：APP<br>公众号支付：JSAPI<br>小程序支付：JSAPI|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|商品描述|body|String(128)|是|商品描述交易字段格式根据不同的应用场景按照以下格式：<br>APP支付：需传入应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值；<br>公众号支付：传入公众号名称-实际商品名称，例如：腾讯形象店- image-QQ公仔；<br>小程序支付：传入商家名称-销售商品类目，如：腾讯-游戏；|
|商品详情|goodsDetail|String(6000)|否|商品详细描述，规则见[2.3参数规定](#_2.3参数规定)|
|商品标记|goodsTag|String(32)|否|商品标记，代金券或立减优惠功能的参数，详见微信官网文档中的代金券或立减优惠说明。|
|附加数据|attach|String(127)|否|如“深圳分店”|
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在支付结果查询和交易结果通知时原样返回|
|支付有效时间|payValidTime|String(10)|否|支付数据的有效时间，单位为秒，应不小于60|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知|
|交易金额|txnAmt|String(13)|是|单位为分，txnAmt=orderOrigAmt-orderCouponAmt|
|订单原始金额|orderOrigAmt|String(13)|否|单位为分，和orderCouponAmt同时出现|
|订单优惠金额|orderCouponAmt|String(13)|否|单位为分，和orderOrigAmt同时出现|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|终端IP|spbillCreateIp|String(64)|是|必须传正确的用户端IP|
|限定支付方式|limitPay|String(32)|否|no\_credit--指定不能使用信用卡支付；<br>为空表示无限制|
|用户标识|openId|String(128)|否|用户在Appid下的唯一标识。|
|用户子标识|subOpenId|String(128)|否|[trade_type=JSAPI，此参数必传，用户在subAppId下的唯一标识。](http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html)|
|场景信息|sceneInfo|String(256)|否|H5支付支付必填，公众号、APP支付和小程序支付不填<br>1，IOS移动应用<br>{"h5\_info": //h5支付固定传"h5\_info" <br>`    `{"type": "",  //场景类型<br>`     `"app\_name": "",  //应用名<br>`     `"bundle\_id": ""  //bundle\_id<br>`     `}<br>}<br>2，安卓移动应用<br>{"h5\_info": //h5支付固定传"h5\_info" <br>`    `{"type": "",  //场景类型<br>`     `"app\_name": "",  //应用名<br>`     `"package\_name": ""  //包名<br>`     `}<br>}<br>3，WAP网站应用<br>{"h5\_info": //h5支付固定传"h5\_info" <br>`   `{"type": "",  //场景类型<br>`    `"wap\_url": "",//WAP网站URL地址<br>`    `"wap\_name": ""  //WAP 网站名<br>`    `}<br>}<br>wap\_url传网站首页URL地址,必须保证公网能正常访问<br>4，公众号支付：<br>{"store\_info" : {"id": "SZTX001","name": "腾大餐厅","area\_code": "440305","address": "科技园中一路腾讯大厦" }}|
|实名支付信息|encryptIdentity|String(256)|否|<p>实名支付信息<br>` `{"need\_check": "T", //是否校验身份，T是F否<br>`   `"name": "",  //名字  <br>`    `"number": "",  //证件号<br>`    `"mobile": "",  //手机号      <br>`   `"type": "IDCARD" //证件类型，只支持身份证<br>`  `}</p><p>需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)</p>|
|保单单号|policyNo|String(100)|否|<p>保险实名支付对接中保信使用，由保险公司生成，须与实名认证上送中保信的“支付单号”一致。</p><p>如果交易有上送此字段则交易成功后会通知中保信做见费出单操作。</p><p>该字段和region需同时出现或同时不出现。</p>|
|地区码|region|String(64)|否|<p>缴税系统地区码按指引填写</p><p>全国： 000000<br>上海地区： 310000<br>深圳地区： 440300</p><p>该字段和policyNo需同时出现或同时不出现。</p>|
|上海保险平台交易号|paymentNo|String(50)|否|上海保险平台交易号|
|终端信息|encryptTerminalInfo|String(6000)|否|商户侧受理终端信息，字段说明详见[终端信息terminalInfo](#_2.7.1_终端信息terminalinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|指定支付者|limitPayer|String(1000)|否|上传此参数， 可限制用户只有是成年人才能支付.ADULT： 成年人。|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|

### <a name="_toc19372"></a>*4.10.3返回参数*

<table><tr><th colspan="1"><b>变量描述</b></th><th colspan="1"><b>变量名</b></th><th colspan="1"><b>类型</b></th><th colspan="1"><b>是否必填</b></th><th colspan="1"><b>备注</b></th></tr>
<tr><td colspan="1">版本号</td><td colspan="1">version</td><td colspan="1">String(5)</td><td colspan="1">是</td><td colspan="1">固定为0.0.1</td></tr>
<tr><td colspan="1">编码方式</td><td colspan="1">encoding</td><td colspan="1">String(20)</td><td colspan="1">是</td><td colspan="1">固定为UTF-8</td></tr>
<tr><td colspan="1">签名</td><td colspan="1">sign</td><td colspan="1">String(1024)</td><td colspan="1">是</td><td colspan="1"></td></tr>
<tr><td colspan="1">签名方法</td><td colspan="1">signMethod</td><td colspan="1">String(2)</td><td colspan="1">是</td><td colspan="1">02：SM2</td></tr>
<tr><td colspan="1">返回码</td><td colspan="1">returnCode</td><td colspan="1">String(7)</td><td colspan="1">是</td><td colspan="1">SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等</td></tr>
<tr><td colspan="5">以下字段仅在returnCode为SUCCESS时返回</td></tr>
<tr><td colspan="1">商户号</td><td colspan="1">merId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1">请求报文中的商户号</td></tr>
<tr><td colspan="1">商户订单号</td><td colspan="1">orderId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1">请求报文中的商户订单号</td></tr>
<tr><td colspan="1">交易类型</td><td colspan="1">tradeType</td><td colspan="1">String(16)</td><td colspan="1">是</td><td colspan="1">请求报文中的交易类型</td></tr>
<tr><td colspan="1">响应码</td><td colspan="1">respCode</td><td colspan="1">String(10)</td><td colspan="1">是</td><td colspan="1">招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求</td></tr>
<tr><td colspan="1">第三方错误描述</td><td colspan="1">errDescription</td><td colspan="1">String(256)</td><td colspan="1">否</td><td colspan="1">第三方处理失败时返回第三方的错误信息</td></tr>
<tr><td colspan="5">以下字段仅在returnCode和respCode为SUCCESS时返回</td></tr>
<tr><td colspan="1">平台订单号</td><td colspan="1">cmbOrderId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1">招行生成的订单号</td></tr>
<tr><td colspan="1">订单发送时间</td><td colspan="1">txnTime</td><td colspan="1">String(14)</td><td colspan="1">是</td><td colspan="1">订单生成时间，格式为yyyyMMddHHmmss</td></tr>
<tr><td colspan="1" rowspan="16">支付数据</td><td colspan="1">payData</td><td colspan="1"></td><td colspan="1">否</td><td colspan="1">JSON字符串，trade_type为JSAPI或APP时返回，拉起支付时使用；<br>trade_type为JSAPI时，用于微信浏览器里面打开H5网页中执行JS调起支付,或者用于小程序支付。trade_type为APP时，用于APP端调起支付。</td></tr>
<tr><td colspan="4">其中，当trade_type为JSAPI时，payData说明如下</td></tr>
<tr><td colspan="1">appId</td><td colspan="1">String(16)</td><td colspan="1">是</td><td colspan="1">如果是公众号内H5支付，appId对应商户注册具有支付权限的公众号成功后,获取的appId;<br>如果是小程序支付，appId对应特约商户小程序对应的appId；</td></tr>
<tr><td colspan="1">timeStamp</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1">Linux格式时间戳，如1414561699</td></tr>
<tr><td colspan="1">nonceStr</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1">随机字符串</td></tr>
<tr><td colspan="1">package</td><td colspan="1">String(128)</td><td colspan="1">是</td><td colspan="1">统一下单接口返回的prepay_id参数值，格式如：prepay_id=123456789</td></tr>
<tr><td colspan="1">signType</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1">固定位RSA</td></tr>
<tr><td colspan="1">paySign</td><td colspan="1">String(512)</td><td colspan="1">是</td><td colspan="1">服务商秘钥加签的签名</td></tr>
<tr><td colspan="4">其中，当trade_type为APP时，payData说明如下</td></tr>
<tr><td colspan="1">appId</td><td colspan="1">String(16)</td><td colspan="1">是</td><td colspan="1">微信开放平台审核通过的应用APP ID</td></tr>
<tr><td colspan="1">partnerId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1">微信支付分配的商户号</td></tr>
<tr><td colspan="1">prepayId</td><td colspan="1">String(36)</td><td colspan="1">是</td><td colspan="1">微信返回的支付交易会话ID</td></tr>
<tr><td colspan="1">packageValue</td><td colspan="1">String(128)</td><td colspan="1">是</td><td colspan="1">暂填写固定值 Sign=WXPay</td></tr>
<tr><td colspan="1">nonceStr</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1">随机字符串</td></tr>
<tr><td colspan="1">timeStamp</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1">Linux格式时间戳，如1414561699</td></tr>
<tr><td colspan="1">sign</td><td colspan="1">String(512)</td><td colspan="1">是</td><td colspan="1">服务商秘钥加签的签名</td></tr>
<tr><td colspan="5">以下字段仅在returnCode或respCode为FAIL时返回</td></tr>
<tr><td colspan="1">错误码</td><td colspan="1">errCode</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1">请求处理失败的错误码信息</td></tr>
<tr><td colspan="1">应答信息</td><td colspan="1">respMsg</td><td colspan="1">String(256)</td><td colspan="1">是</td><td colspan="1">请求处理失败的详细描述信息</td></tr>
</table>

## <a name="_toc10069"></a>4.11服务窗支付
### <a name="_toc23025"></a>*4.11.1业务功能*
用户使用支付宝通过扫码或打开好友分享的商家页面链接而进入商家页面，商户在H5页面通过调用支付宝提供的JSAPI接口调起支付宝支付模块完成支付。
### <a name="_toc23494"></a>*4.11.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|设备号|deviceInfo|String(32)|否|终端设备号|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|商品描述|body|String(128)|否|商品描述|
|商品优惠信息|itemDiscount|String(6000)|否|第三方单品优惠信息描述，规则见[2.6优惠信息字段说明](#_2.6优惠信息字段说明_1)|
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在支付结果查询和交易结果通知时原样返回|
|支付有效时间|timeoutExpress|String(6)|否|该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知|
|交易金额|txnAmt|String(13)|是|单位为分|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|订单原始金额|orderOrigAmt|String(13)|否|单位为分，和orderCouponAmt同时出现|
|订单优惠金额|orderCouponAmt|String(13)|否|单位为分，和orderOrigAmt同时出现|
|限制支付渠道|disablePayChannels|String(128)|否|禁用渠道,用户不可用指定渠道 支付，多<br>个 渠 道 以 逗 号 分 割 ， 枚举值见https://doc.open.alipay.com/docs/doc.htm?docType=1&articleId=107723|
|买家支付宝账号|buyerLogonId|String(100)|否|买家支付宝账号，和buerId不能同时为空|
|买家支付宝用户ID|buyerId|String(28)|否|买家支付宝用户ID，和buyerLogonId不能同时为空buyerId获取方法：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.8ujLD6&treeId=115&articleId=104114&docType=1通过网页授权获取用户信息，同步响应结果中的user\_id对应文档中的buyer\_id。|
|实名支付信息|encryptIdentity|String(256)|否|<p>实名支付信息<br>` `{"need\_check": "T", //是否校验身份，T是F否<br>`   `"name": "",  //名字  <br>`    `"number": "",  //证件号<br>`    `"mobile": "",  //手机号      <br>`   `"type": "IDCARD" //证件类型，支持身份证：IDCARD、护照：PASSPORT、军官证：OFFICER\_CARD、士兵证：SOLDIER\_CARD、户口本：HOKOU<br>`  `}<br>无需实名验证则不出现此字段</p><p>需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)</p>|
|保单单号|policyNo|String(100)|否|<p>保险实名支付对接中保信使用，由保险公司生成，须与实名认证上送中保信的“支付单号”一致。</p><p>如果交易有上送此字段则交易成功后会通知中保信做见费出单操作。</p><p>该字段和region需同时出现或同时不出现。</p>|
|地区码|region|String(64)|否|<p>缴税系统地区码按指引填写</p><p>全国： 000000<br>上海地区： 310000<br>深圳地区： 440300</p><p>该字段和policyNo需同时出现或同时不出现。</p>|
|上海保险平台交易号|paymentNo|String(50)|否|上海保险平台交易号|
|业务扩展参数|alipayExtendParams|String(6000)|否|业务扩展参数，如：{"sys\_service\_provider\_id":"2088511833207846"}|
|终端信息|encryptTerminalInfo|String(6000)|否|商户侧受理终端信息，字段说明详见[终端信息terminalInfo。](#_2.7.1_终端信息terminalinfo)需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|商户传入业务信息|businessParams|String(512)|否|支付宝支付专用字段。商户传入业务信息，应用于安全，营销等参数直传场景，格式为json格式。|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|同步跳转地址|returnUrl|String(256)|否|可实现支付成功后跳转到商家页面的功能，而且跳转后的页面地址栏中会返回同步通知参数|
### <a name="_toc2556"></a>*4.11.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|支付信息|payInfo|String(64)|是|唤起支付宝支付使用|
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|订单发送时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

商户获取到payInfo之后，在商户界面中参照如下模板组装请求参数：

<script type="text/javascript">

//调用支付宝JS api 支付

var options = {

`                    `"tradeNO":'2016071121001004610284287324'//这个值即取自应答报文中的payInfo的值

`            `};

AlipayJSBridge.call('tradePay', options ,function(result){

if(result.resultCode == '9000'){

location.href="";//支付成功后跳转处理

}

});

</script>


## <a name="_toc8743"></a>4.12支付宝native码支付
### <a name="_toc30580"></a>*4.12.1业务功能*
商户后台系统调用该API获取支付宝的native二维码。用户后续可使用支付宝APP扫一扫功能发起“收款码主扫支付”。
### <a name="_toc19350"></a>*4.12.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**||
| :-: | :-: | :-: | :-: | :- | :- |
|版本号|version|String(5)|是|固定为0.0.1||
|编码方式|encoding|String(20)|是|固定为UTF-8||
|签名|sign|String(1024)|是|||
|签名方法|signMethod|String(2)|是|02：SM2||
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号||
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用||
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送||
|设备号|deviceInfo|String(32)|否|终端设备号||
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一||
|收银员|userId|String(32)|否|招行提供的收银员信息||
|商品描述|body|String(128)|否|商品描述||
|商品优惠信息|goodsDetail|String(6000)|否|第三方单品优惠信息描述，规则见[2.6.5.支付宝商品列表](#_2.6.5.支付宝商品列表)||
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在支付结果查询和交易结果通知时原样返回||
|支付有效时间|timeoutExpress|String(6)|否|该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。||
|二维码有效时间|qrCodeTimeoutExpress |String(6)|否|该笔订单允许的最晚付款时间 <br>，逾期将关闭交易，从生成二维 码开始计时。取值范围：1m～15d 。 m-分钟，h-小时，d-天，1c-当天（1c当天的情况下，无论交易何时创 建，都在 0 点关闭）。 该参数数值 不接受小数点，如 1.5h，可转换 为<br>90m。 ||
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知||
|交易金额|txnAmt|String(13)|是|单位为分，txnAmt=orderOrigAmt-orderCouponAmt||
|订单原始金额|orderOrigAmt|String(13)|否|单位为分，和orderCouponAmt同时出现||
|订单优惠金额|orderCouponAmt|String(13)|否|单位为分，和orderOrigAmt同时出现||
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）||
|限制支付渠道|disablePayChannels|String(128)|否|禁用渠道,用户不可用指定渠道 支付，多<br>个 渠 道 以 逗 号 分 割 ， 枚举值见https://doc.open.alipay.com/docs/doc.htm?docType=1&articleId=107723||
|买家支付宝账号|buyerLogonId|String(100)|否|买家支付宝账号||
|实名支付信息|encryptIdentity|String(256)|否|<p>实名支付信息<br>` `{"need\_check": "T", //是否校验身份，T是F否<br>`   `"name": "",  //名字  <br>`    `"number": "",  //证件号<br>`    `"mobile": "",  //手机号      <br>`   `"type": "IDCARD" //证件类型，支持身份证：IDCARD、护照：PASSPORT、军官证：OFFICER\_CARD、士兵证：SOLDIER\_CARD、户口本：HOKOU<br>`  `}<br>无需实名验证则不出现此字段</p><p>需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)</p>||
|保单单号|policyNo|String(100)|否|<p>保险实名支付对接中保信使用，由保险公司生成，须与实名认证上送中保信的“支付单号”一致。</p><p>如果交易有上送此字段则交易成功后会通知中保信做见费出单操作。</p><p>该字段和region需同时出现或同时不出现。</p>||
|地区码|region|String(64)|否|<p>缴税系统地区码按指引填写</p><p>全国： 000000<br>上海地区： 310000<br>深圳地区： 440300</p><p>该字段和policyNo需同时出现或同时不出现。</p>||
|上海保险平台交易号|paymentNo|String(50)||上海保险平台交易号||
|业务扩展参数|alipayExtendParams|String(6000)|否|业务扩展参数，如：{"sys\_service\_provider\_id":"2088511833207846"}||
|终端信息|encryptTerminalInfo|String(6000)|否|商户侧受理终端信息，字段说明详见[终端信息terminalInfo](#_2.7.1_终端信息terminalinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)||
|商户传入业务信息|businessParams|String(512)|否|支付宝支付专用字段。商户传入业务信息，应用于安全，营销等参数直传场景，格式为json格式。||
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)||

### <a name="_toc2753"></a>*4.12.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|二维码|qrCode |String(1024)|是|唤起支付宝支付使用(当前下单请求生成的二维码码串，可以用二维码生成工具根据该码串值生成对应的二维码 )|
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|订单发送时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|应答信息|respMsg|String(256)|是|交易失败的详细描述信息|
|错误信息|errCode|String(32)|是|交易失败的错误码信息|


## <a name="_toc13181"></a>4.13对账单下载地址获取
### <a name="_toc31685"></a>*4.13.1业务功能*
商户调用此接口获取对账单下载的URL，后台程序再通过公网请求此URL获取对账单数据。T+1日上午10点半以后生成未清分（不含手续费、清分日期等清分信息）账单，下午16:30生成清分账单。
### <a name="_toc15333"></a>*4.13.2请求参数*
接口链接：（补充URL）

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|银行分配给商户的商户号|
|账单日期|billDate|String(8)|是|下载对账单的日期，格式：20180803|
|账单类型|billType|String(3)|否|下载打包对账单须上送：zip，不上送此字段默认下载Excel格式账单|
|下载方式|urlType|String(5)|否|行内业务网下载账单须上送：inner，不上送此字段默认通过互联网下载|

### <a name="_toc20302"></a>*4.13.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下载请求|
|以下字段仅在returnCode或respCode为SUCCESS时返回|||||
|账单下载地址|fileDownloadUrl|String(256)|是|对账单下载URL|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|


## <a name="_toc32168"></a>4.14 订单二维码申请
### <a name="_toc19716"></a>*4.14.1 业务功能*
商户后台系统调用该API获取符合聚合收单平台规则的订单银标码，商户可通过再次调用该API修改订单码的收款金额。用户后续可使用第三方APP扫一扫功能发起“收款码主扫支付”。用户扫码后未完成支付前可在二维码有效期内再次使用相同的支付方式或换用其他支付方式扫码支付（暂不支持使用银联系APP扫码支付后再次扫码支付），如用户首次用微信扫码支付，成功支付前可以再用微信扫码进行支付，也可以再用支付宝扫码进行支付，同一笔订单，最终最多只能成功扫码支付一次。

### <a name="_toc21282"></a>*4.14.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|终端号|termId|String(8)|否|上送分行登记的终端号|
|支付有效时间|payValidTime|String(10)|否|二维码的有效时长，单位为秒，若商户上送，则以商户上送值为准，否则使用默认有效时长1200秒|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知|
|交易金额|txnAmt|String(13)|是|单位为分|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|商品描述|body|String(128)|否|用于展示支付宝账单详情中的“商品说明”和微信账单详情中的“商品”字段，若不上送则默认显示商户简称。|
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在支付结果查询和支付结果通知时原样返回（不上送则不返回此字段）|
|终端信息|encryptTerminalInfo|String(6000)|否|商户侧受理终端信息，字段说明详见[终端信息terminalInfo](#_2.7.1_终端信息terminalinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|


### <a name="_toc6629"></a>*4.14.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|二维码|qrCode|String(300)|是||
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|


## <a name="_toc22842"></a>4.15 微信小程序下单
### <a name="_toc17294"></a>*4.15.1 业务功能*
用户通过商户APP在线下单购买商品，商户通过调用该API完成微信小程序下单。商户接收到响应报文后，跳转到招行小程序收银台，用户在招行小程序收银台中完成支付，支付成功后，返回商户APP。
### <a name="_toc8713"></a>*4.15.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|设备号|deviceInfo|String(32)|否|PC网页或公众号内支付请传"WEB"|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|交易类型|tradeType|String(16)|是|小程序支付：JSAPI|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|商品描述|body|String(128)|是|商品描述交易字段格式根据不同的应用场景按照以下格式：<br>APP支付：需传入应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值；<br>H5支付：应用在浏览器网页上的场景，传入浏览器打开的移动网页的主页title名-实际商品名称，例如：腾讯充值中心-QQ会员充值；<br>公众号支付：传入公众号名称-实际商品名称，例如：腾讯形象店- image-QQ公仔；<br>小程序支付：传入商家名称-销售商品类目，如：腾讯-游戏；|
|商品详情|goodsDetail|String(6000)|否|商品详细描述，规则见[2.3参数规定](#_2.3参数规定)|
|商品标记|goodsTag|String(32)|否|商品标记，代金券或立减优惠功能的参数，详见微信官网文档中的代金券或立减优惠说明。|
|附加数据|attach|String(127)|否|如“深圳分店”|
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在支付结果查询和交易结果通知时原样返回|
|支付有效时间|payValidTime|String(10)|否|支付数据的有效时间，单位为秒，应不小于60|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知|
|交易金额|txnAmt|String(13)|是|单位为分，txnAmt=orderOrigAmt-orderCouponAmt|
|订单原始金额|orderOrigAmt|String(13)|否|单位为分，和orderCouponAmt同时出现|
|订单优惠金额|orderCouponAmt|String(13)|否|单位为分，和orderOrigAmt同时出现|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|终端IP|spbillCreateIp|String(64)|是|必须传正确的用户端IP|
|限定支付方式|limitPay|String(32)|否|no\_credit--指定不能使用信用卡支付；<br>为空表示无限制|
|实名支付信息|encryptIdentity|String(256)|否|<p>实名支付信息<br>` `{"need\_check": "T", //是否校验身份，T是F否<br>`   `"name": "",  //名字  <br>`    `"number": "",  //证件号<br>`    `"mobile": "",  //手机号      <br>`   `"type": "IDCARD" //证件类型，只支持身份证<br>`  `}</p><p>需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)</p>|
|保单单号|policyNo|String(100)|否|<p>保险实名支付对接中保信使用，由保险公司生成，须与实名认证上送中保信的“支付单号”一致。</p><p>如果交易有上送此字段则交易成功后会通知中保信做见费出单操作。</p><p>该字段和region需同时出现或同时不出现。</p>|
|地区码|region|String(64)|否|<p>缴税系统地区码按指引填写</p><p>全国： 000000<br>上海地区： 310000<br>深圳地区： 440300</p><p>该字段和policyNo需同时出现或同时不出现。</p>|
|终端信息|encryptTerminalInfo|String(6000)|否|商户侧受理终端信息，字段说明详见[终端信息terminalInfo](#_2.7.1_终端信息terminalinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|指定支付者|limitPayer|String(1000)|否|上传此参数， 可限制用户只有是成年人才能支付.ADULT： 成年人。|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|

### <a name="_toc26166"></a><a name="_toc10979"></a>*4.15.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|交易类型|tradeType|String(16)|是|请求报文中的交易类型|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|订单发送时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|加密平台订单号|encryptedCmbOrderId|String(32)|是|加密后的招行生成的订单号|
|加密交易数据|encryptedTradeInfo|String(8000)|是|加密交易数据|
|招行小程序原始id|cmbMiniAppId|String(32)|是|招行小程序原始id|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|


## <a name="_toc28008"></a>4.16 银联云闪付
### <a name="_toc28879"></a>*4.16.1 业务功能*
用户通过商户网站选定商品并下单，在商户支付页面选择银联图标进行支付。商户可通过调用此接口完成向银联全渠道的下单流程。目前只支持银联云闪付APP支付。
### <a name="_toc7973"></a>*4.16.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|交易场景|tradeScene|String(10)|是|ONLINE：线上场景                        |
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|商品描述|body|String(128)|是|描述订单信息，显示在银联支付控件或客户端支付界面中|
|商户保留域|mchReserved|String(128)|否|如“深圳分店”|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知|
|交易金额|txnAmt|String(13)|是|单位为分|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|前台通知地址|frontUrl|String(256)|否|前台返回商户结果时使用|
|支付超时时间|payTimeout|String(14)|否|订单支付超时时间，超过此时间用户支付成功的交易，不通知商户，系统自动退款，大约5个工作日金额返还到用户账户，格式为YYYYMMDDhhmmss|
|支付卡类型|payCardType|String(2)|否|<p>取值：</p><p>00：未知</p><p>01：借记账户</p><p>02：贷记账户</p><p>03：准贷记账户</p><p>04：借贷记合一账户</p><p>05：预付费账户</p><p>06：半开放预付费账户</p>|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|

### <a name="_toc24119"></a>*4.16.3返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|交易类型|tradeType|String(16)|是|请求报文中的交易类型|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|订单发送时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|银联受理订单号|tn|String(21)|是|商户推送订单后银联移动支付系统返回流水号，商户调用支付控件时使用|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|
## <a name="_toc10163"></a>4.17 数字人民币统一下单
### <a name="_toc18519"></a>*4.17.1 业务功能*
商户后台系统调用该API获取符合聚合收单平台规则的动态数字人民币二维码。用户后续可使用数研所APP或有数字人民币权限的银行系APP扫一扫功能发起“收款码主扫支付”。

商户后台系统也可以调用该API获取跳转数币APP支付的参数。
### <a name="_toc31635"></a>*4.17.2 请求参数*

|**变量描述**|**变量名**|**类型**|<p>**是否**</p><p>**必填**</p>|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知地址|
|交易币种|currencyCode|String(3)|是|默认156，目前只支持人民币（156）|
|交易类型|transactionType|String(4)|是|<p>TT01：扫码支付</p><p>TT03：APP拉起支付</p><p>TT04：H5拉起支付</p><p>TT13：小程序拉起支付</p><p>后续可能会支持其他类型</p>|
|订单金额|txnAmt|String(15)|是|单位为分|
|受理终端编号|terminalNo|String(32)|是|禁止中文|
|受理终端IP|terminalIp|String(64)|是|禁止中文|
|商品名称|goodsName|String(200)|是|例如：xxx赛事-购票。如北京2022冬奥会-购票。注意：不可使用特殊字符，如/，=，&等|
|订单详情|orderDetails|String(1024)|否|商品详细描述|
|网络交易平台名称|platformName|String(40)|否|当商户类型为网络特约商户时必填|
|交易地点|tradePlace|String(128)|是|实体特约商户填写商户受理终端布放地址，网络特约商户填写网络交易平台网络地址|
|订单失效时间|orderTimeExpire|String(19)|是|订单失效时间时针对订单号（收款运营机构生成的订单号）而言的。格式：yyyy-mm-ddTHH:MM:SS，其中的T为日期和时间的分割符，是必需的。禁止中文|
|商户保留域|mchReserved|String(128)|否|附加数据，在查询和支付通知中原样返回，该字段主要用户商户携带订单的自定义数据|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|保单单号|policyNo|String(100)|否|<p>保险实名支付对接中保信使用，由保险公司生成，须与实名认证上送中保信的“支付单号”一致。</p><p>如果交易有上送此字段则交易成功后会通知中保信做见费出单操作。</p><p>该字段和region需同时出现或同时不出现。</p>|
|地区码|region|String(64)|否|<p>缴税系统地区码按指引填写</p><p>全国： 000000</p><p>上海地区： 310000</p><p>深圳地区： 440300</p><p>该字段和policyNo需同时出现或同时不出现。</p>|
### <a name="_toc15640"></a>*4.17.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|第三方错误描述|errDescription|String(256)|否|交易在第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|订单生成时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|二维码|qrCode|String(500)|否|当交易类型为TT01返回|
|调用地址|invokeUrl|String(256)|否|当交易类型为TT03|TT04|TT13返回，唤起数字人民币APP的地址|
|拉起数币APP的业务信息|context|Object|否|当交易类型为TT03|TT04|TT13返回，拉起数字人民币APP需要的参数|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

context内容

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|收款运营机构金融编码|cdtrPtyId|String(14)|是|　|
|商户号|mrchntNo|String(32)|是|　|
|秘钥密文|encryptKey|String(512)|否|　|
|订单加密信息|encryptInfo|String(2048)|否|　|
|加密证书序列号|ncrptnSN|String(10)|否|商户在拉起数币APP的时候传给数研所|
## <a name="_toc22216"></a>4.18 数字人民币统一支付
### <a name="_toc24367"></a>*4.18.1 业务功能*
商户系统用扫码设备扫描用户展示的数字人民币付款码完成收款功能。该场景是有异步结果通知的。若招行返回的非F状态，且一段时间内未收到通知，需商户主动发起查询。
### <a name="_toc13578"></a>*4.18.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知地址|
|交易币种|currencyCode|String(3)|是|默认156，目前只支持人民币（156）|
|交易类型|transactionType|String(4)|是|TT01:扫码支付<br>注：目前仅支持TT01扫码支付，后续可能支持其他类型的支付|
|订单金额|txnAmt|String(15)|是|单位为分|
|受理终端编号|terminalNo|String(32)|是|禁止中文|
|受理终端IP|terminalIp|String(64)|是|禁止中文|
|商品名称|goodsName|String(40)|是|例如：xxx赛事-购票。如北京2022冬奥会-购票。注意：不可使用特殊字符，如/，=，&等|
|订单详情|orderDetails|String(1024)|否|商品详细描述|
|网络交易平台名称|platformName|String(40)|否|当商户类型为网络特约商户时必填|
|交易地点|tradePlace|String(128)|是|实体特约商户填写商户受理终端布放地址，网络特约商户填写网络交易平台网络地址|
|订单失效时间|orderTimeExpire|String(19)|是|订单失效时间时针对订单号（收款运营机构生成的订单号）而言的。格式：yyyy-mm-ddTHH:MM:SS，其中的T为日期和时间的分割符，是必需的。禁止中文|
|付款码信息|authCode|String(34)|是|　|
|商户保留域|mchReserved|String(128)|否|附加数据，在查询和支付通知中原样返回，该字段主要用户商户携带订单的自定义数据|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|

### <a name="_toc22520"></a>*4.18.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|第三方错误描述|errDescription|String(256)|否|交易在第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|交易状态|tradeState|String(1)|是|P - 支付中<br>F - 交易失败|
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|订单生成时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|
## <a name="_toc27812"></a>4.19 数字人民币子钱包支付
### <a name="_toc13677"></a>*4.19.1 业务功能*
付款用户和商户签约数币子钱包支付后，商户可调用此接口进行数币子钱包收款。本接口正常情况下同步返回结果
### <a name="_toc2328"></a>*4.19.2 请求参数*

<table><tr><th colspan="1"><b>变量描述</b></th><th colspan="1"><b>变量名</b></th><th colspan="1"><b>类型</b></th><th colspan="1"><b>是否必填</b></th><th colspan="1"><b>备注</b></th></tr>
<tr><td colspan="1">版本号</td><td colspan="1">version</td><td colspan="1">String(5)</td><td colspan="1">是</td><td colspan="1" valign="bottom">固定为0.0.1</td></tr>
<tr><td colspan="1">编码方式</td><td colspan="1">encoding</td><td colspan="1">String(20)</td><td colspan="1">是</td><td colspan="1" valign="bottom">固定为UTF-8</td></tr>
<tr><td colspan="1">签名</td><td colspan="1">sign</td><td colspan="1">String(1024)</td><td colspan="1">是</td><td colspan="1" valign="bottom">　</td></tr>
<tr><td colspan="1">签名方法</td><td colspan="1">signMethod</td><td colspan="1">String(2)</td><td colspan="1">是</td><td colspan="1" valign="bottom">02：SM2</td></tr>
<tr><td colspan="1">商户号</td><td colspan="1">merId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">商户在招行完成商户进件后分配的招行商户号</td></tr>
<tr><td colspan="1">商户订单号</td><td colspan="1">orderId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">商户端生成，要求此订单号在整个商户下唯一</td></tr>
<tr><td colspan="1">收银员</td><td colspan="1">userId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。</td></tr>
<tr><td colspan="1">交易币种</td><td colspan="1">currencyCode</td><td colspan="1">String(3)</td><td colspan="1">是</td><td colspan="1" valign="bottom">默认156，目前只支持人民币（156）</td></tr>
<tr><td colspan="1">订单金额</td><td colspan="1">txnAmt</td><td colspan="1">String(15)</td><td colspan="1">是</td><td colspan="1" valign="bottom">单位为分</td></tr>
<tr><td colspan="1">付款运营机构</td><td colspan="1">debtorAgentId</td><td colspan="1">String(14)</td><td colspan="1">是</td><td colspan="1" valign="bottom">付款运营机构</td></tr>
<tr><td colspan="1" rowspan="4">认证方式</td><td colspan="1" rowspan="4">authenticCode</td><td colspan="1" rowspan="4">String(4)</td><td colspan="1" rowspan="4">是</td><td colspan="1" valign="bottom">AC00：协议方式</td></tr>
<tr><td colspan="1" valign="bottom">AC01：在线认证方式</td></tr>
<tr><td colspan="1" valign="bottom">AC02：动态密码方式</td></tr>
<tr><td colspan="1" valign="bottom">AC03：短信认证方式</td></tr>
<tr><td colspan="1">认证信息</td><td colspan="1">authenticInfo</td><td colspan="1">String(130)</td><td colspan="1">是</td><td colspan="1" valign="bottom">认证方式为AC00协议方式时，认证信息填写签约协议号。</td></tr>
<tr><td colspan="1">订单失效时间</td><td colspan="1">orderTimeExpire</td><td colspan="1">String(19)</td><td colspan="1">否</td><td colspan="1" valign="bottom">订单失效时间时针对订单号（收款运营机构生成的订单号）而言的。格式：yyyy-mm-ddTHH:MM:SS，其中的T为日期和时间的分割符，是必需的。禁止中文。</td></tr>
<tr><td colspan="1">商品名称</td><td colspan="1">goodsName</td><td colspan="1">String(40)</td><td colspan="1">是</td><td colspan="1" valign="bottom">例如：xxx赛事-购票。如北京2022冬奥会-购票。注意：不可使用特殊字符，如/，=，&等</td></tr>
<tr><td colspan="1">场景ID</td><td colspan="1">sceneId</td><td colspan="1">String(10)</td><td colspan="1">是</td><td colspan="1" valign="bottom"></td></tr>
<tr><td colspan="1">商户保留域</td><td colspan="1">mchReserved</td><td colspan="1">String(128)</td><td colspan="1">否</td><td colspan="1" valign="bottom">附加数据，在查询中原样返回，该字段主要用于商户携带订单的自定义数据</td></tr>
<tr><td colspan="1">交易地址信息</td><td colspan="1">encryptTradeAddressInfo</td><td colspan="1">String(1024)</td><td colspan="1">否</td><td colspan="1" valign="bottom">交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)</td></tr>
</table>

### <a name="_toc31923"></a>*4.19.3 返回参数*

<table><tr><th colspan="1"><b>变量描述</b></th><th colspan="1"><b>变量名</b></th><th colspan="1"><b>类型</b></th><th colspan="1"><b>是否必填</b></th><th colspan="1"><b>备注</b></th></tr>
<tr><td colspan="1">版本号</td><td colspan="1">version</td><td colspan="1">String(5)</td><td colspan="1">是</td><td colspan="1" valign="bottom">固定为0.0.1</td></tr>
<tr><td colspan="1">编码方式</td><td colspan="1">encoding</td><td colspan="1">String(20)</td><td colspan="1">是</td><td colspan="1" valign="bottom">固定为UTF-8</td></tr>
<tr><td colspan="1">签名</td><td colspan="1">sign</td><td colspan="1">String(1024)</td><td colspan="1">是</td><td colspan="1" valign="bottom">　</td></tr>
<tr><td colspan="1">签名方法</td><td colspan="1">signMethod</td><td colspan="1">String(2)</td><td colspan="1">是</td><td colspan="1" valign="bottom">02：SM2</td></tr>
<tr><td colspan="1">返回码</td><td colspan="1">returnCode</td><td colspan="1">String(7)</td><td colspan="1">是</td><td colspan="1" valign="bottom">SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等</td></tr>
<tr><td colspan="5" valign="bottom">以下字段仅在returnCode为SUCCESS时返回</td></tr>
<tr><td colspan="1">商户号</td><td colspan="1">merId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">请求报文中的商户号</td></tr>
<tr><td colspan="1">商户订单号</td><td colspan="1">orderId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">请求报文中的商户订单号</td></tr>
<tr><td colspan="1">响应码</td><td colspan="1">respCode</td><td colspan="1">String(10)</td><td colspan="1">是</td><td colspan="1" valign="bottom">业务错误码，成功为SUCCESS，失败为FAIL</td></tr>
<tr><td colspan="1">第三方错误描述</td><td colspan="1">errDescription</td><td colspan="1">String(256)</td><td colspan="1">否</td><td colspan="1" valign="bottom">第三方处理失败时返回第三方的错误信息</td></tr>
<tr><td colspan="5" valign="bottom">以下字段仅在returnCode和respCode为SUCCESS时返回</td></tr>
<tr><td colspan="1">平台订单号</td><td colspan="1">cmbOrderId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">招行生成的订单号</td></tr>
<tr><td colspan="1">订单发送时间</td><td colspan="1">txnTime</td><td colspan="1">String(14)</td><td colspan="1">是</td><td colspan="1" valign="bottom">订单生成时间，格式为yyyyMMddHHmmss</td></tr>
<tr><td colspan="1">交易金额</td><td colspan="1">txnAmt</td><td colspan="1">String(13)</td><td colspan="1">是</td><td colspan="1" valign="bottom">单位为分</td></tr>
<tr><td colspan="1">优惠金额</td><td colspan="1">dscAmt</td><td colspan="1">String(13)</td><td colspan="1">是</td><td colspan="1" valign="bottom">单位为分</td></tr>
<tr><td colspan="1" rowspan="3">交易状态</td><td colspan="1" rowspan="3">tradeState</td><td colspan="1" rowspan="3">String(1)</td><td colspan="1" rowspan="3">是</td><td colspan="1" valign="bottom">F - 交易失败</td></tr>
<tr><td colspan="1" valign="bottom">S - 交易成功</td></tr>
<tr><td colspan="1" valign="bottom">P –交易已受理，结果未知</td></tr>
<tr><td colspan="1">第三方订单号</td><td colspan="1">thirdOrderId</td><td colspan="1">String(40)</td><td colspan="1">是</td><td colspan="1" valign="bottom">收款运营结构的订单号</td></tr>
<tr><td colspan="1">备注</td><td colspan="1">remark</td><td colspan="1">String(140)</td><td colspan="1">否</td><td colspan="1" valign="bottom"></td></tr>
<tr><td colspan="1">付款运营机构编码</td><td colspan="1">debtorAgentId</td><td colspan="1">String(14)</td><td colspan="1">否</td><td colspan="1" valign="bottom"></td></tr>
<tr><td colspan="1">付款运营机构名称</td><td colspan="1">debtorAgentName</td><td colspan="1">String(60)</td><td colspan="1">否</td><td colspan="1" valign="bottom"></td></tr>
<tr><td colspan="1">数字人民币优惠详情</td><td colspan="1">ecnyPromotionDetail</td><td colspan="1">String</td><td colspan="1">否</td><td colspan="1" valign="bottom">数字人民币优惠详情信息，字段说明详见[2.6.6数字人民币优惠详情](#_2.6.6.数字人民币优惠详情)。</td></tr>
<tr><td colspan="5" valign="bottom">以下字段仅在returnCode或respCode为FAIL时返回</td></tr>
<tr><td colspan="1">错误码</td><td colspan="1">errCode</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">请求处理失败的错误码信息</td></tr>
<tr><td colspan="1">应答信息</td><td colspan="1">respMsg</td><td colspan="1">String(256)</td><td colspan="1">是</td><td colspan="1" valign="bottom">请求处理失败的详细描述信息</td></tr>
</table>
## <a name="_toc11259"></a>4.20数字人民币子钱包支付 – 带合约
### <a name="_toc15878"></a>*4.20.1 业务功能*
付款用户和商户签约数币子钱包支付后，商户可调用此接口进行数币子钱包收款。本接口正常情况下同步返回结果
### <a name="_toc11694"></a>*4.20.2 请求参数*

<table><tr><th colspan="1"><b>变量描述</b></th><th colspan="1"><b>变量名</b></th><th colspan="1"><b>类型</b></th><th colspan="1"><b>是否必填</b></th><th colspan="1"><b>备注</b></th></tr>
<tr><td colspan="1">版本号</td><td colspan="1">version</td><td colspan="1">String(5)</td><td colspan="1">是</td><td colspan="1" valign="bottom">固定为0.0.1</td></tr>
<tr><td colspan="1">编码方式</td><td colspan="1">encoding</td><td colspan="1">String(20)</td><td colspan="1">是</td><td colspan="1" valign="bottom">固定为UTF-8</td></tr>
<tr><td colspan="1">签名</td><td colspan="1">sign</td><td colspan="1">String(1024)</td><td colspan="1">是</td><td colspan="1" valign="bottom">　</td></tr>
<tr><td colspan="1">签名方法</td><td colspan="1">signMethod</td><td colspan="1">String(2)</td><td colspan="1">是</td><td colspan="1" valign="bottom">02：SM2</td></tr>
<tr><td colspan="1">商户号</td><td colspan="1">merId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">商户在招行完成商户进件后分配的招行商户号</td></tr>
<tr><td colspan="1">商户订单号</td><td colspan="1">orderId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">商户端生成，要求此订单号在整个商户下唯一</td></tr>
<tr><td colspan="1">收银员</td><td colspan="1">userId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。</td></tr>
<tr><td colspan="1">交易币种</td><td colspan="1">currencyCode</td><td colspan="1">String(3)</td><td colspan="1">是</td><td colspan="1" valign="bottom">默认156，目前只支持人民币（156）</td></tr>
<tr><td colspan="1">订单金额</td><td colspan="1">txnAmt</td><td colspan="1">String(15)</td><td colspan="1">是</td><td colspan="1" valign="bottom">单位为分</td></tr>
<tr><td colspan="1">付款运营机构</td><td colspan="1">debtorAgentId</td><td colspan="1">String(14)</td><td colspan="1">是</td><td colspan="1" valign="bottom">付款运营机构</td></tr>
<tr><td colspan="1" rowspan="4">认证方式</td><td colspan="1" rowspan="4">authenticCode</td><td colspan="1" rowspan="4">String(4)</td><td colspan="1" rowspan="4">是</td><td colspan="1" valign="bottom">AC00：协议方式</td></tr>
<tr><td colspan="1" valign="bottom">AC01：在线认证方式</td></tr>
<tr><td colspan="1" valign="bottom">AC02：动态密码方式</td></tr>
<tr><td colspan="1" valign="bottom">AC03：短信认证方式</td></tr>
<tr><td colspan="1">认证信息</td><td colspan="1">authenticInfo</td><td colspan="1">String(130)</td><td colspan="1">是</td><td colspan="1" valign="bottom">认证方式为AC00协议方式时，认证信息填写签约协议号。</td></tr>
<tr><td colspan="1">订单失效时间</td><td colspan="1">orderTimeExpire</td><td colspan="1">String(19)</td><td colspan="1">否</td><td colspan="1" valign="bottom">订单失效时间时针对订单号（收款运营机构生成的订单号）而言的。格式：yyyy-mm-ddTHH:MM:SS，其中的T为日期和时间的分割符，是必需的。禁止中文</td></tr>
<tr><td colspan="1">商品名称</td><td colspan="1">goodsName</td><td colspan="1">String(40)</td><td colspan="1">是</td><td colspan="1" valign="bottom">例如：xxx赛事-购票。如北京2022冬奥会-购票。注意：不可使用特殊字符，如/，=，&等</td></tr>
<tr><td colspan="1">场景ID</td><td colspan="1">sceneId</td><td colspan="1">String(10)</td><td colspan="1">是</td><td colspan="1" valign="bottom"></td></tr>
<tr><td colspan="1">商户保留域</td><td colspan="1">mchReserved</td><td colspan="1">String(128)</td><td colspan="1">否</td><td colspan="1" valign="bottom">附加数据，在查询中原样返回，该字段主要用于商户携带订单的自定义数据</td></tr>
<tr><td colspan="1">合约收款请求内容</td><td colspan="1">contractReq</td><td colspan="1">String</td><td colspan="1">是</td><td colspan="1" valign="bottom">json字符串，字段说明详见[2.7.2.1合约收款请求内容contractReq](#_2.7.2.1合约收款请求内容contractreq)</td></tr>
<tr><td colspan="1">交易地址信息</td><td colspan="1">encryptTradeAddressInfo</td><td colspan="1">String(1024)</td><td colspan="1">否</td><td colspan="1" valign="bottom">交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)</td></tr>
</table>

### <a name="_toc7437"></a>*4.20.3 返回参数*

<table><tr><th colspan="1"><b>变量描述</b></th><th colspan="1"><b>变量名</b></th><th colspan="1"><b>类型</b></th><th colspan="1"><b>是否必填</b></th><th colspan="1"><b>备注</b></th></tr>
<tr><td colspan="1">版本号</td><td colspan="1">version</td><td colspan="1">String(5)</td><td colspan="1">是</td><td colspan="1" valign="bottom">固定为0.0.1</td></tr>
<tr><td colspan="1">编码方式</td><td colspan="1">encoding</td><td colspan="1">String(20)</td><td colspan="1">是</td><td colspan="1" valign="bottom">固定为UTF-8</td></tr>
<tr><td colspan="1">签名</td><td colspan="1">sign</td><td colspan="1">String(1024)</td><td colspan="1">是</td><td colspan="1" valign="bottom">　</td></tr>
<tr><td colspan="1">签名方法</td><td colspan="1">signMethod</td><td colspan="1">String(2)</td><td colspan="1">是</td><td colspan="1" valign="bottom">02：SM2</td></tr>
<tr><td colspan="1">返回码</td><td colspan="1">returnCode</td><td colspan="1">String(7)</td><td colspan="1">是</td><td colspan="1" valign="bottom">SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等</td></tr>
<tr><td colspan="5" valign="bottom">以下字段仅在returnCode为SUCCESS时返回</td></tr>
<tr><td colspan="1">商户号</td><td colspan="1">merId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">请求报文中的商户号</td></tr>
<tr><td colspan="1">商户订单号</td><td colspan="1">orderId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">请求报文中的商户订单号</td></tr>
<tr><td colspan="1">响应码</td><td colspan="1">respCode</td><td colspan="1">String(10)</td><td colspan="1">是</td><td colspan="1" valign="bottom">业务错误码，成功为SUCCESS，失败为FAIL</td></tr>
<tr><td colspan="1">第三方错误描述</td><td colspan="1">errDescription</td><td colspan="1">String(256)</td><td colspan="1">否</td><td colspan="1" valign="bottom">第三方处理失败时返回第三方的错误信息</td></tr>
<tr><td colspan="5" valign="bottom"><b>以下字段仅在returnCode和respCode为SUCCESS时返回</b></td></tr>
<tr><td colspan="1">平台订单号</td><td colspan="1">cmbOrderId</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">招行生成的订单号</td></tr>
<tr><td colspan="1">订单发送时间</td><td colspan="1">txnTime</td><td colspan="1">String(14)</td><td colspan="1">是</td><td colspan="1" valign="bottom">订单生成时间，格式为yyyyMMddHHmmss</td></tr>
<tr><td colspan="1">交易金额</td><td colspan="1">txnAmt</td><td colspan="1">String(13)</td><td colspan="1">是</td><td colspan="1" valign="bottom">单位为分</td></tr>
<tr><td colspan="1">优惠金额</td><td colspan="1">dscAmt</td><td colspan="1">String(13)</td><td colspan="1">是</td><td colspan="1" valign="bottom">单位为分</td></tr>
<tr><td colspan="1" rowspan="3">交易状态</td><td colspan="1" rowspan="3">tradeState</td><td colspan="1" rowspan="3">String(1)</td><td colspan="1" rowspan="3">是</td><td colspan="1" valign="bottom">F - 交易失败</td></tr>
<tr><td colspan="1" valign="bottom">S - 交易成功</td></tr>
<tr><td colspan="1" valign="bottom">P –交易已受理，结果未知</td></tr>
<tr><td colspan="1">合约收款响应内容</td><td colspan="1">contractResp</td><td colspan="1">String</td><td colspan="1">是</td><td colspan="1" valign="bottom">合约响应内容，字段说明详见[2.7.2.2合约收款响应内容contractResp](#_2.7.3_合约响应内容contractresp)</td></tr>
<tr><td colspan="1">数字人民币优惠详情</td><td colspan="1">ecnyPromotionDetail</td><td colspan="1">String</td><td colspan="1">否</td><td colspan="1" valign="bottom">数字人民币优惠详情信息，字段说明详见[2.6.6数字人民币优惠详情](#_2.6.6.数字人民币优惠详情)。</td></tr>
<tr><td colspan="5" valign="bottom">以下字段仅在returnCode或respCode为FAIL时返回</td></tr>
<tr><td colspan="1">错误码</td><td colspan="1">errCode</td><td colspan="1">String(32)</td><td colspan="1">是</td><td colspan="1" valign="bottom">请求处理失败的错误码信息</td></tr>
<tr><td colspan="1">应答信息</td><td colspan="1">respMsg</td><td colspan="1">String(256)</td><td colspan="1">是</td><td colspan="1" valign="bottom">请求处理失败的详细描述信息</td></tr>
</table>
## <a name="_toc17627"></a>4.21 数字人民币统一下单 – 带合约
### <a name="_toc6372"></a>*4.21.1 业务功能*
商户后台系统调用该API获取符合聚合收单平台规则的动态数字人民币二维码。用户后续可使用数研所APP或有数字人民币权限的银行系APP扫一扫功能发起“收款码主扫支付”。

商户后台系统也可以调用该API获取跳转数币APP支付的参数。
### <a name="_toc29407"></a>*4.21.2 请求参数*

|**变量描述**|**变量名**|**类型**|<p>**是否**</p><p>**必填**</p>|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知地址|
|交易币种|currencyCode|String(3)|是|默认156，目前只支持人民币（156）|
|交易类型|transactionType|String(4)|是|<p>TT01：扫码支付</p><p>TT03：APP拉起支付</p><p>TT04：H5拉起支付</p><p>TT13：小程序拉起支付</p><p>后续可能会支持其他类型</p>|
|订单金额|txnAmt|String(15)|是|单位为分|
|受理终端编号|terminalNo|String(32)|是|禁止中文|
|受理终端IP|terminalIp|String(64)|是|禁止中文|
|商品名称|goodsName|String(200)|是|例如：xxx赛事-购票。如北京2022冬奥会-购票。注意：不可使用特殊字符，如/，=，&等|
|订单详情|orderDetails|String(1024)|否|商品详细描述|
|网络交易平台名称|platformName|String(40)|否|当商户类型为网络特约商户时必填|
|交易地点|tradePlace|String(128)|是|实体特约商户填写商户受理终端布放地址，网络特约商户填写网络交易平台网络地址|
|订单失效时间|orderTimeExpire|String(19)|是|订单失效时间时针对订单号（收款运营机构生成的订单号）而言的。格式：yyyy-mm-ddTHH:MM:SS，其中的T为日期和时间的分割符，是必需的。禁止中文|
|商户保留域|mchReserved|String(128)|否|附加数据，在查询和支付通知中原样返回，该字段主要用户商户携带订单的自定义数据|
|合约收款请求内容|contractReq|String|是|json字符串，字段说明详见[2.7.2.1合约收款请求内容contractReq](#_2.7.2.1合约收款请求内容contractreq)|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
### <a name="_toc31067"></a>*4.21.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|第三方错误描述|errDescription|String(256)|否|交易在第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|订单生成时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|二维码|qrCode|String(500)|否|当交易类型为TT01返回|
|调用地址|invokeUrl|String(256)|否|当交易类型为TT03|TT04|TT13返回，唤起数字人民币APP的地址|
|拉起数币APP的业务信息|context|Object|否|当交易类型为TT03|TT04|TT13返回，拉起数字人民币APP需要的参数|
|合约收款响应内容|contractResp|String|是|合约响应内容，字段说明详见[2.7.2.2合约收款响应内容contractResp](#_2.7.3_合约响应内容contractresp)|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

context内容

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|收款运营机构金融编码|cdtrPtyId|String(14)|是|　|
|商户号|mrchntNo|String(32)|是|　|
|秘钥密文|encryptKey|String(256)|是|　|
|订单加密信息|encryptInfo|String|是|　|
## <a name="_toc9357"></a>4.22 微信委托代扣
### <a name="_toc13112"></a>*4.22.1 业务功能*
委托代扣可应用于定期扣款或需事后扣款以期提高效率的场景。例如停车场商户、生活缴费、离线刷脸快速支付等，在用户授权给微信后，进行委托扣款的场景。

注：

1、对于papTradeScene取值为车场停车（PARKING）、车位停车（PARKING\_SPACE）、加油（GAS）、高速（HIGHWAY）、路桥（BRIDGE）、生活缴费（LIFE\_PAY）场景，此接口同步返回的为受理状态，订单状态通过通知接口或订单查询接口获取。扣费时首先按签约协议中记录的优先支付方式扣费，否则从可用扣款方式中依次选择扣款。

2、对于papTradeScene取值为离线刷脸场景（K12\_OFFLINE \_FACE），此接口同步返回的为订单状态，机构也可通过代扣结果查询接口获取订单状态。
### <a name="_toc12773"></a>*4.22.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|子公众账号ID|subAppId|String(32)|否|微信分配的子商户公众账号ID|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|商品描述|body|String(128)|是|商品或支付单简要描述，格式要求：门店品牌名 -城市分店名 -实际商品名称|
|商品详情|goodsDetail|String(6000)|否|[商品详细描述，规则见2.3参数规定](file:///C:\Users\80234931\Desktop\微信委托代扣接口文档.xlsx#RANGE!_2.3参数规定)|
|商品标记|goodsTag|String(32)|否|商品标记，代金券或立减优惠功能的参数，详见微信官网文档中的代金券或立减优惠说明。|
|附加数据|attach|String(127)|否|微信附加数据，会透传给微信|
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在支付结果查询和交易结果通知时原样返回|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知|
|交易金额|txnAmt|String(13)|是|单位为分|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|委托代扣交易场景|papTradeScene|String(16)|是|委托代扣的交易场景值，目前支持：<br>1\.PARKING：车场停车场景；<br>2\.PARKING\_SPACE：车位停车场景；<br>3\.GAS：加油场景；<br>4\.HIGHWAY：高速场景；<br>5\.BRIDGE：路桥场景；<br>6\.LIFE\_PAY：生活缴费行业；<br>7\.K12\_OFFLINE\_FACE：离线刷脸代扣场景；|
|代扣业务信息|busiData|String(60000)|是|业务特有订单数据，规则见下文说明|
|授权用户标识|authOpenid|String(128)|否|papTradeScene为LIFE\_PAY生活缴费场景时，为 appid下用户标识；其他车主服务场景则用户在对应授权appid下用户唯一标识。<br>papTradeScene为K12\_OFFLINE\_FACE离线刷脸代扣场景时，为刷脸用户标识。|
|交易地址信息|<p>encryptTrade</p><p>AddressInfo</p>|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|

busiData字段说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|场景信息|scene\_info|object|是|示例值："scene\_info":{"bridge\_info":、{"start\_time":、"2017-08-26T10:43:39+08:00",、"plate\_number":" 粤B100000",、"exit":"虎门大桥"}}<br>场景信息值，格式为json，不同业务场景设置不同的值，规则见TODO说明|
|用户授权公众账号ID|auth\_appid|String(32)|否|车主场景必传，用户授权商户可使用微信支付车主服务的appid，从业机构appid或者特约商户的 appid 两者之一。|
|委托代扣协议id|contract\_id|String(128)|否|签约返回的委托代扣协议id|
|授权码|auth\_code|String(20000)|是|papTradeScene为K12\_OFFLINE\_FACE离线刷脸代扣场景时必送，离线刷脸扣款凭证，用户刷脸成功后由终端设备生成，约 8KB。|

场景信息scene\_info字段说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|交易场景|trade\_scene|String(32)|是|委托代扣的交易场景值，目前支持 ：<br>1\. PARKING： 车场停车场景；<br>2\. PARKING\_SPACE： 车位停车场景；<br>3\. GAS：加油场景；<br>4\. HIGHWAY： 高速场景；<br>5\. BRIDGE： 路桥场景；<br>6\. LIFE\_PAY： 生活缴费行业；<br>7\. K12\_OFFLINE\_FACE： 离线刷脸代扣场景；|
|高速场景信息|highway\_info|object|否|场景信息对象，详细说明见下文|
|停车场景信息|parking\_info|object|否|场景信息对象，详细说明见下文|
|停车位场景信息|parking\_space\_info|object|否|场景信息对象，详细说明见下文|
|路桥场景信息|bridge\_info|object|否|场景信息对象，详细说明见下文|
|加油场景信息|gas\_info|object|否|场景信息对象，详细说明见下文|
|生活缴费行业信息|life\_info|object|否|场景信息对象，详细说明见下文|
|K12离线刷脸业务信息|k12\_offline\_face\_info|object|否|场景信息对象，详细说明见下文|
|商户端设备号|device\_id|String(32)|否|终端设备号（商户自定义，如门店编号）|
|商户端设备IP|device\_ip|String(40)|是|调用微信支付API的机器IP|




parking\_info说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|入场时间|start\_time|String(32)|是|用户入闸时间，按照使用rfc3339所定义的格式，格式为<br>YYYYMM-DDThh:mm:ss+TIMEZONE。如：2017-08-26T09:43:39|
|出场时间|end\_time|String(32)|是|用户出闸时间，按照使用rfc3339所定义的格式，格式为<br>YYYYMM-DDThh:mm:ss+TIMEZONE。|
|计费时长|charge\_duration|Int|是|计费的时间长。单位为秒|
|车牌号|plate\_number|String(32)|是|如粤B888888|
|车辆类型|car\_type|String(16)|否|可选值：小型车，大型车|
|停车场名称|parking\_name|String(32)|是|停车场名称|

parking\_space\_info说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|入场时间|start\_time|String(32)|是|用户入闸时间，按照使用rfc3339所定义的格式，格式为<br>YYYYMM-DDThh:mm:ss+TIMEZONE。|
|出场时间|end\_time|String(32)|是|用户出闸时间，按照使用rfc3339所定义的格式，格式为<br>YYYYMM-DDThh:mm:ss+TIMEZONE。|
|车位编号|space\_number|String(32)|是|车位编号|
|计费时长|charge\_duration|Int|是|计费的时间长。单位为秒|
|车辆类型|car\_type|String(16)|否|可选值：小型车，大型车等|
|停车场名称|parking\_name|String(32)|是|停车场名称|

gas\_info说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|交易时间|start\_time|String(32)|是|用户入闸时间，按照使用rfc3339所定义的格式，格式为<br>YYYYMM-DDThh:mm:ss+TIMEZONE。|
|车牌号|plate\_number|String(32)|是|如粤B888888|
|车辆类型|car\_type|String(16)|否|可选值：小型车，大型车|
|加油站名称|gas\_station|String(32)|是|加油站名称，如：中国石油加油站|
|油品标号名|gas\_label\_no|Int|是|油品标号，可选值：89、90、92、93、95、97、98、5、0、-10、-20、-35、-50|
|油品标准|gas\_standard|String(32)|是|油品标准名称，可选：国V，国IV，粤IV|
|油量|gas\_amount|Int|否|油品量量（单位毫升ml）|
|油品类型名称|gas\_type|String(32)|是|油品类型名称，如：汽油|
|油枪号|gas\_gun\_no|Int|是|加油枪号，纯数字|

highway\_info说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|交易时间|start\_time|String(32)|是|用户入闸时间，按照使用rfc3339所定义的格式，格式为<br>YYYYMM-DDThh:mm:ss+TIMEZONE。|
|结束时间|end\_time|String(32)|是|用户出闸时间，按照使用rfc3339所定义的格式，格式为<br>YYYYMM-DDThh:mm:ss+TIMEZONE。|
|车牌号|plate\_number|String(32)|是|如粤B888888|
|通道类型|channel\_type|String(16)|是|高速通道类型，目前可选：ETC、MTC。商户扣费前必须确认当前车牌的标识属性，用户车牌必须具有该通道标识，才允许扣费。|
|入口站名称|entrance|String(32)|是|入口站名称，如：沿江深圳-大铲湾|
|出口站名称|exit|String(32)|是|出口站名称，如：广珠东线-珠海站|
|车辆类型|car\_type|String(16)|否|车辆类型，如：客车|
|荷载人数|carrying\_capacity|String(32)|否|荷载人数，如：10|
|荷载区间|carrying\_range|String(32)|否|荷载区间，如：6-12|

bridge\_info说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|交易时间|start\_time|String(32)|是|用户入闸时间，按照使用rfc3339所定义的格式，格式为<br>YYYYMM-DDThh:mm:ss+TIMEZONE。|
|车牌号|plate\_number|String(32)|是|如粤B888888|
|车辆类型|car\_type|String(16)|否|车辆类型，如：客车|
|出口站名称|exit|String(32)|是|出口站名称，如：广珠东线-珠海站|

life\_info说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|户号|bill\_key|String(64)|是|生活缴费户号编号|
|项目编号|company\_id|String(64)|是|项目编号|

离线刷脸代扣k12\_offline\_face\_info说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|业务场景|business\_scene|String(32)|是|取值：<br>测试： K12\_TEST<br>食堂： K12\_CANTEEN<br>超市： K12\_SUPERMARKET<br>医院： K12\_HOSPITAL<br>按月支付： K12\_MONTHLY\_PAYMENT|

### <a name="_toc25472"></a>*4.22.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，并非交易结果是失败状态，需要商户再次发起查询确认|
|第三方错误描述|errDescription|String(256)|否|付款码收款交易在第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|用户标识|openId|String(128)|否|受理扣款无authOpenid 且非车主场景时，返回特约商户openid|
|付款银行|payBank|String(32)|否|银行类型，采用字符串类型的银行标识。如：CMB\_CREDIT|
|第三方订单号|thirdOrderId|String(64)|否|支付宝、微信侧的订单号|
|交易状态|tradeState|String(1)|是|P - 支付状态未知<br>F - 支付失败<br>S - 支付成功|
|交易金额|txnAmt|String(13)|是|单位为分|
|优惠金额|dscAmt|String(13)|是|单位为分|
|币种|currencyCode|String(3)|是|目前只支持人民币（156）|
|优惠券信息|promotionDetail|String|否|[微信、支付宝优惠券信息，规则见2.6优惠信息字段说明](file:///C:\Users\80234931\Desktop\微信委托代扣接口文档.xlsx#RANGE!_2.6优惠信息字段说明)|
|订单发送时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|订单完成日期|endDate|String(8)|否|第三方系统返回的交易完成日期，此日期仅在交易成功是返回，不保证是实际清算日期，格式为yyyyMMdd|
|订单完成时间|endTime|String(6)|否|第三方系统返回的交易完成时间，此时间仅在成功是返回，格式为HHmmss|
|受理时间|acceptTime|String(32)|是|即受理订单的受理时间，按照使用 rfc3339所定义的格式，格式为YYYY-MM-DDThh:mm:ss+TIMEZONE。（trade\_state 取值为 ACCEPTED 时出现）|
|业务信息|busiData|String(6000)|是|业务特有订单数据，详细说明见下文|
|错误分类|errorType|String(32)|否|扣款时返回，支付成功时为 SUCCESS，否则为错误类型，如NOT\_ENOUGH|
|欠款状态|debtState|String(32)|是|OT\_DEBT：无欠款（表示订单无垫资支付，无欠款）<br>DEBT：有欠款（表示订单为垫资支付，有欠款）<br>REPAYMENT：已还款（表示订单为垫资支付，但已还款，无欠款）|
|微信还款订单号|repaymentTransactionId|String(32)|否|debtState为REPAYMENT时返回|
||||||
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|否|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|否|请求处理失败的详细描述信息|

busi\_data字段说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|场景信息|scene\_info|object|是|场景信息值|

场景信息scene\_info字段说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|商户端设备号|device\_id|String(32)|否|终端设备号（商户自定义，如门店编号）|
|商户端设备IP|device\_ip|String(40)|是|调用微信支付API的机器IP|

## <a name="_toc31932"></a>4.23 微信委托代扣查询
### <a name="_toc16914"></a>*4.23.1 业务功能*
此接口仅支持微信委托代扣交易且仅支持15天以内的交易查询，超过15天的交易发起查询将返回CMB\_ORDERID\_NOT\_EXIST。

商户在一定时间内未收到支付结果通知的情况下必须主动发起支付结果查询，**若因商户没有实现查询机制而导致通知异常时无法准确获取支付结果则风险由商户自行承担。**

### <a name="_toc11621"></a>*4.23.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|商户订单号|orderId|String(32)|否|被查询交易的商户订单号，此字段和平台订单号字段至少要上送一个，若两个都上送，则以平台订单号为准|
|平台订单号|cmbOrderId|String(32)|否|被查询交易招行订单号，此字段和商户订单号字段至少要上送一个，若两个都上送，则以此字段为准|
|收银员|userId|String(32)|是|招行系统生成的收银员，需和被查询交易的收银员一致。|

### <a name="_toc11803"></a>*4.23.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|否|请求报文中的商户订单号|
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，并非交易结果是失败状态，需要商户再次发起查询确认|
|第三方错误描述|errDescription|String(256)|否|付款码收款交易在第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|交易金额|txnAmt|String(13)|是|单位为分|
|优惠金额|dscAmt|String(13)|是|单位为分|
|币种|currencyCode|String(3)|是|目前只支持人民币（156）|
|用户标识|openId|String(128)|否|受理扣款无authOpenid 且非车主场景时，返回特约商户openid|
|付款银行|payBank|String(32)|否|银行类型，采用字符串类型的银行标识。如：CMB\_CREDIT|
|第三方订单号|thirdOrderId|String(64)|否|支付宝、微信侧的订单号|
|交易状态|tradeState|String(1)|是|P - 支付状态未知<br>F - 支付失败<br>S - 支付成功|
|优惠券信息|promotionDetail|String|否|[微信、支付宝优惠券信息，规则见2.6优惠信息字段说明](file:///C:\Users\80234931\Desktop\微信委托代扣接口文档.xlsx#RANGE!_2.6优惠信息字段说明)|
|订单发送时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|订单完成日期|endDate|String(8)|否|第三方系统返回的交易完成日期，此日期仅在交易成功是返回，不保证是实际清算日期，格式为yyyyMMdd|
|订单完成时间|endTime|String(6)|否|第三方系统返回的交易完成时间，此时间仅在成功是返回，格式为HHmmss|
|受理时间|acceptTime|String(32)|是|即受理订单的受理时间，按照使用 rfc3339所定义的格式，格式为YYYY-MM-DDThh:mm:ss+TIMEZONE。（trade\_state 取值为 ACCEPTED 时出现）|
|业务信息|busiData|String(6000)|是|业务特有订单数据，规则**TODO**|
|错误分类|errorType|String(32)|否|扣款时返回，支付成功时为 SUCCESS，否则为错误类型，如NOT\_ENOUGH|
|欠款状态|debtState|String(32)|是|OT\_DEBT：无欠款（表示订单无垫资支付，无欠款）<br>DEBT：有欠款（表示订单为垫资支付，有欠款）<br>REPAYMENT：已还款（表示订单为垫资支付，但已还款，无欠款）|
|微信还款订单号|repaymentTransactionId|String(32)|否|debtState为REPAYMENT时返回|
|商户保留域|mchReserved|String(128)|否|若支付交易有上送此字段，则返回此字段|
|　|　|　|　|　|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

busi\_data字段说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|场景信息|scene\_info|object|是|场景信息值|

场景信息scene\_info字段说明

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|商户端设备号|device\_id|String(32)|否|终端设备号（商户自定义，如门店编号）|
|商户端设备IP|device\_ip|String(40)|是|调用微信支付API的机器IP|
## <a name="_toc17880"></a>4.24 支付宝APP支付
### <a name="_toc19247"></a>*4.24.1 业务功能*
商户后台系统调用该API获取支付宝app支付请求参数串，再商户APP内唤起快捷SDK创建订单并支付
### <a name="_toc18164"></a>*4.24.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|收银员|userId|String(10)|是|招行系统生成的收银员，需和被查询交易的收银员一致。|
|交易金额|txnAmt|String(13)|是|单位为分|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知|
|销售产品码|productCode|String(64)|是|<p>销售产品码，与支付宝签约的产品码名称。</p><p>目前支持QUICK\_MSECURITY\_PAY、GENERAL\_WITHHOLDING（代扣场景）</p>|
|绝对超时时间|timeExpire|String(19)|否|格式为yyyy-MM-dd HH:mm:ss，如：2016-12-31 10:05:01，timeExpire和timeoutExpress两者传入一个或者都不传，如果两者都传，优先使用timeExpire|
|支付有效时间|timeoutExpress|String(6)|否|该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。|
|商品主类型|goodsType|String(2)|否|0-虚拟类商品,1-实物类商品|
|优惠参数|promoParams|String(512)|否|仅与支付宝协商后可用，如：{"storeIdType":"1"}|
|卖家支付宝用户ID|sellerId|String(28)|否|如果该值为空，则默认为商户签约账号对应的支付宝用户ID|
|订单标题|subject|String(256)|是|订单标题|
|商品描述|body|String(128)|否|商品描述|
|商品优惠信息|itemDiscount|String(6000)|否|第三方单品优惠信息描述，规则见[2.6优惠信息字段说明](#_2.6优惠信息字段说明_1)|
|限制支付渠道|disablePayChannels|String(128)|否|禁用渠道，用户不可用指定渠道支付，多个渠道以逗号分割，枚举值见https://doc.open.alipay.com/docs/doc.htm?docType=1&articleId=107723|
|支付宝业务扩展字段|alipayExtendParams|String(6000)|否|支付宝业务扩展字段，如：{“sys\_service\_provider\_id”:”2088511833207846”}|
|商户传入业务信息|businessParams|String(512)|否|商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景|
|实名信息|encryptIdentity|String(256)|否|<p>实名支付信息</p><p>` `{"need\_check": "T", //是否校验身份，T是F否</p><p>`   `"name": "",  //名字  </p><p>`    `"number": "",  //证件号</p><p>`    `"mobile": "",  //手机号      </p><p>`   `"type": "IDCARD" //证件类型，支持身份证：IDCARD、护照：PASSPORT、军官证：OFFICER\_CARD、士兵证：SOLDIER\_CARD、户口本：HOKOU</p><p>`  `}</p><p>无需实名验证则不出现此字段</p><p>需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)</p>|
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在支付结果查询和交易结果通知时原样返回|
|保单单号|policyNo|String(100)|否|<p>保险实名支付对接中保信使用，由保险公司生成，须与实名认证上送中保信的“支付单号”一致。</p><p>如果交易有上送此字段则交易成功后会通知中保信做见费出单操作。</p><p>该字段和region需同时出现或同时不出现。</p>|
|地区码|region|String(64)|否|<p>缴税系统地区码按指引填写</p><p>全国： 000000<br>上海地区： 310000<br>深圳地区： 440300</p><p>该字段和policyNo需同时出现或同时不出现。</p>|
|订单原始金额|orderOrigAmt|String(13)|否|单位为分，和orderCouponAmt同时出现|
|订单优惠金额|orderCouponAmt|String(13)|否|单位为分，和orderOrigAmt同时出现|
|上海保险平台交易号|paymentNo|String(50)|否|上海保险平台交易号|
|终端信息|encryptTerminalInfo|String(6000)|否|商户侧受理终端信息，字段说明详见[终端信息terminalInfo。](#_2.7.1_终端信息terminalinfo)需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|交易地址信息|<p>encryptTrade</p><p>AddressInfo</p>|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|同步跳转地址|returnUrl|String(256)|否|可实现支付成功后跳转到商家页面的功能，而且跳转后的页面地址栏中会返回同步通知参数|

### <a name="_toc7167"></a>*4.24.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|第三方错误描述|errDescription|String(256)|否|交易在第三方处理失败时返回第三方的错误信息|
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|订单生成时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|app支付请求参数|orderStr||是|app支付请求参数字符串，主要包含商户的订单信息，key=value形式，以&连接。|
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc16573"></a>4.25 支付宝手机网站支付
### <a name="_toc12305"></a>*4.25.1 业务功能*
商户后台系统调用该API获取支付宝手机网站支付请求form表单，商户可通过form表单创建订单并支付
### <a name="_toc11737"></a>*4.25.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|收银员|userId|String(10)|是|招行系统生成的收银员，需和被查询交易的收银员一致。|
|交易金额|txnAmt|String(13)|是|单位为分|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|交易通知地址|notifyUrl|String(256)|是|支付结果将送到本通知|
|销售产品码|productCode|String(64)|是|销售产品码，商家和支付宝签约的产品码。注：目前仅支持QUICK\_WAP\_WAY|
|绝对超时时间|timeExpire|String(19)|否|格式为yyyy-MM-dd HH:mm:ss，如：2016-12-31 10:05:01，timeExpire和timeoutExpress两者传入一个或者都不传，如果两者都传，优先使用timeExpire|
|支付有效时间|timeoutExpress|String(6)|否|该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。|
|商品主类型|goodsType|String(2)|否|0-虚拟类商品,1-实物类商品|
|优惠参数|promoParams|String(512)|否|仅与支付宝协商后可用，如：{"storeIdType":"1"}|
|用户授权token|authToken|String(40)|否|针对用户授权接口，获取用户相关数据时，用于标识用户授权关系|
|退出返回的网站地址|quitUrl|String(400)|是|用户付款中途退出返回商户网站的地址|
|卖家支付宝用户ID|sellerId|String(28)|否|如果该值为空，则默认为商户签约账号对应的支付宝用户ID|
|订单标题|subject|String(256)|是|订单标题|
|商品描述|body|String(128)|否|商品描述|
|商品优惠信息|itemDiscount|String(6000)|否|第三方单品优惠信息描述，规则见[2.6优惠信息字段说明](#_2.6优惠信息字段说明_1)|
|限制支付渠道|disablePayChannels|String(128)|否|禁用渠道，用户不可用指定渠道支付，多个渠道以逗号分割，枚举值见https://doc.open.alipay.com/docs/doc.htm?docType=1&articleId=107723|
|支付宝业务扩展字段|alipayExtendParams|String(6000)|否|支付宝业务扩展字段，如：{“sys\_service\_provider\_id”:”2088511833207846”}|
|商户传入业务信息|businessParams|String(512)|否|商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景|
|实名信息|encryptIdentity|String(256)|否|<p>实名支付信息</p><p>` `{"need\_check": "T", //是否校验身份，T是F否</p><p>`   `"name": "",  //名字  </p><p>`    `"number": "",  //证件号</p><p>`    `"mobile": "",  //手机号      </p><p>`   `"type": "IDCARD" //证件类型，支持身份证：IDCARD、护照：PASSPORT、军官证：OFFICER\_CARD、士兵证：SOLDIER\_CARD、户口本：HOKOU</p><p>`  `}</p><p>无需实名验证则不出现此字段</p><p>需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)</p>|
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在支付结果查询和交易结果通知时原样返回|
|保单单号|policyNo|String(100)|否|<p>保险实名支付对接中保信使用，由保险公司生成，须与实名认证上送中保信的“支付单号”一致。</p><p>如果交易有上送此字段则交易成功后会通知中保信做见费出单操作。</p><p>该字段和region需同时出现或同时不出现。</p>|
|地区码|region|String(64)|否|<p>缴税系统地区码按指引填写</p><p>全国： 000000<br>上海地区： 310000<br>深圳地区： 440300</p><p>该字段和policyNo需同时出现或同时不出现。</p>|
|订单原始金额|orderOrigAmt|String(13)|否|单位为分，和orderCouponAmt同时出现|
|订单优惠金额|orderCouponAmt|String(13)|否|单位为分，和orderOrigAmt同时出现|
|上海保险平台交易号|paymentNo|String(50)|否|上海保险平台交易号|
|终端信息|encryptTerminalInfo|String(6000)|否|商户侧受理终端信息，字段说明详见[终端信息terminalInfo。](#_2.7.1_终端信息terminalinfo)需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|交易地址信息|<p>encrypt</p><p>TradeAddressInfo</p>|String(1024)|否|交易地址信息，字段说明详见[交易地址信息tradeAddressInfo](#_2.7.4_交易地址信息tradeaddressinfo)。需加密详见[敏感信息加密](#_2.4.4_敏感信息加密)|
|同步跳转地址|returnUrl|String(256)|否|可实现支付成功后跳转到商家页面的功能，而且跳转后的页面地址栏中会返回同步通知参数|

### <a name="_toc25572"></a>*4.25.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|第三方错误描述|errDescription|String(256)|否|交易在第三方处理失败时返回第三方的错误信息|
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|订单生成时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|手机网站支付参数|formData||是|为开发者生成前台页面请求需要的完整form表单的html（不包含自动提交脚本），商户可决定是否直接提交form表单，如需要直接提交的，可将这个表单的String加自动提交脚本输出到http response中，如不需要直接提交的，可以自行决定中间处理过程，但提交至支付宝侧的form表达内容不可修改，否则会引起支付宝侧报错。自动提交脚本示例：<script>document.form[0].submit();</script>|
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc15248"></a>4.26微信支付分预授权
### <a name="_toc28501"></a>*4.26.1 业务功能*
支付分预授权

### <a name="_toc27412"></a>*4.26.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|服务ID|serviceId|String(32)|是|微信支付分分配的服务ID|
|子公众账号ID|subAppId|String(32)|否|微信公众平台分配的与传入的子商户商户号建立了支付绑定关系的appId，可在公众平台查看绑定关系，此参数需在微信支付分系统先进行配置。                    |
|授权协议号|authorizationCode|String(32)|是|要求以“商户号+0”开头上送，要求此参数只能由数字、大小写字母\_-|\*组成。前缀占用16位，后16位商户自定义上送。如：30899914206070X0123456|

### <a name="_toc7260"></a>*4.26.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|微信子商户号|wechatSubMchid|String(32)|是|微信子商户号,查询预授权和撤销预授权时上送|
|申请许可token|applyPermissionsToken|String(300)|是|用于跳转到微信侧小程序授权数据,跳转到微信侧小程序传入|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc7658"></a>4.27微信支付分预授权查询
### <a name="_toc4162"></a>*4.27.1 业务功能*
使用authorization\_code查询与用户授权关系

### <a name="_toc28320"></a>*4.27.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|服务ID|serviceId|String(32)|是|微信支付分分配的服务ID|
|授权协议号|authorizationCode|String(32)|是|要求以“商户号+0”开头上送，要求此参数只能由数字、大小写字母\_-|\*组成。前缀占用16位，后16位商户自定义上送。如：30899914206070X0123456|
|微信子商户号|wechatSubMchid|String(32)|否|微信子商户号,如果不上送默认取的商管录入的子商户号。可能存在修改后导致查询不到问题，请自行评估是否上送|

### <a name="_toc9224"></a>*4.27.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|服务ID|serviceId|String(32)|是|微信支付分分配的服务ID|
|授权协议号|authorizationCode|String(32)|否|预授权成功时的授权协议号|
|授权状态|authorizationState|String(16)|是|标识用户授权服务情况。UNAVAILABLE: 用户未授权服务；AVAILABLE: 用户已授权服务； UNBINDUSER: 未绑定用户|
|最近一次解除授权时间|cancelAuthorizationTime|String(64)|否|最近一次解除授权时间，遵循Rfc399标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。|
|最近一次授权成功时间|authorizationSuccessTime|String(64)|否|最近一次授权成功时间，遵循Rfc399标准，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。|
|子公众号ID|subAppId|String(32)|否|微信公众平台分配的与传入的子商户商户号建立了支付绑定关系的AppID，可在公众平台查看绑定关系，此参数需在微信支付分系统先进行配置。|
|用户标识|openId|String(128)|否||
|子商户的用户标识|subOpenId|String(128)|否||
|用户标签|userLabel|String(32)|否|仅授权成功时返回（并且不保证一定返回） 枚举值：A、B、C（其中A>B>C）|
|用户分层|userRiskLevel|String(10)|否|仅授权成功时返回，数值越高，用户风险越低|
|分层版本|riskLevelVersion|String(10)|否|表示返回的“用户分层”归属于的数据版本|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|


## <a name="_toc57"></a>4.28微信支付分解除授权
### <a name="_toc27806"></a>*4.28.1 业务功能*
使用authorization\_code解除用户授权关系

### <a name="_toc502"></a>*4.28.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|服务ID|serviceId|String(32)|是|微信支付分分配的服务ID|
|授权协议号|authorizationCode|String(32)|是|要求以“商户号+0”开头上送，要求此参数只能由数字、大小写字母\_-|\*组成。前缀占用16位，后16位商户自定义上送。如：30899914206070X0123456|
|原因|reason|String(50)|是|解除授权原因|
|微信子商户号|wechatSubMchid|String(32)|否|微信子商户号,如果不上送默认取的商管录入的子商户号。可能存在修改后导致查询不到问题，请自行评估是否上送|

### <a name="_toc23051"></a>*4.28.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|


## <a name="_toc21091"></a>4.29微信支付分预授权通知
### <a name="_toc19653"></a>*4.29.1 业务功能*
支付分授权和解除授权结果通知。

### <a name="_toc17362"></a>*4.29.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|服务ID|serviceId|String(32)|是|微信支付分分配的服务ID|
|子公众账号ID|subAppId|String(32)|否|微信公众平台分配的与传入的子商户商户号建立了支付绑定关系的AppID，可在公众平台查看绑定关系，此参数需在微信支付分系统先进行配置。|
|授权协议号|authorizationCode|String(32)|否|要求以“商户号+0”开头上送，要求此参数只能由数字、大小写字母\_-|\*组成。示例：30899914206070X0123456"|
|用户标识|openId|String(128)|否||
|子商户的用户标识|subOpenId|String(128)|否||
|用户授权状态|userServiceStatus|String(32)|否|USER\_OPEN\_SERVICE：授权成功；USER\_CLOSE\_SERVICE：解除授权成功|
|服务授权/解除授权成功时间|openorcloseTime|String(32)|否||

### <a name="_toc15039"></a>*4.29.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|响应码|respCode|String(10)|是|商户返回的业务错误码，成功为SUCCESS|
|应答信息|respMsg|String(256)|否|交易失败的详细描述信息|



## <a name="_toc21932"></a>4.30微信支付分创建订单
### <a name="_toc4409"></a>*4.30.1 业务功能*
用户申请使用服务时，商户可通过此接口申请创建微信支付分订单。

### <a name="_toc13479"></a>*4.30.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|服务ID|serviceId|String(32)|是|微信支付分分配的服务ID|
|子公众账号ID|subAppId|String(32)|否|微信公众平台分配的与传入的子商户商户号建立了支付绑定关系的AppID，可在公众平台查看绑定关系，此参数需在微信支付分系统先进行配置。|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一，要求以“商户号+0”开头上送，要求此参数只能由数字、大小写字母\_-|\*组成。此订单号会作为支付分商户服务订单号上送给微信。示例：30899914206070X0123456|
|收银员|userId|String(32)|是|招行提供的收银员信息|
|服务信息|serviceIntroduction|String(20)|是|用于介绍本订单所提供的服务|
|后付费项目|postPayments||否|<p>后付费项目列表，格式为array[Payment]转换成的json字符串，Payment相关说明见下方。最多包含100条付费项目，用于用户侧展示与完结订单时的总金额计算。</p><p>示例：[{"name":"就餐费用","amount":40000,"description":"就餐人均100元","count":4}],详细格式见附录5微信支付分对象结构</p>|
|商户优惠|postDiscounts||否|<p>商户优惠列表，格式为array[ServiceOrderCoupon]转换成的json字符串，ServiceOrderCoupon相关说明见下方。最多包含30条商户优惠，用于用户侧展示与完结订单时的总金额计算。</p><p>示例：[{"name":"满20减1元","description":"不与其他优惠叠加","amount":100,"count":2}]</p><p>附录5微信支付分对象结构</p>|
|服务风险金|riskFund||是|<p>格式为RiskFund转换成的json字符串，RiskFund相关说明见下方。用于微信支付分对本次服务进行风险评估。</p><p>示例：{"name":"DEPOSIT","amount":10000,"description":"就餐的预估费用"}</p><p>附录5微信支付分对象结构</p>|
|服务时间|timeRange||是|<p>格式为TimeRange转换成的json字符串，TimeRange相关说明见下方。用于用户侧展示服务时间。</p><p>示例：{"start\_time":"20091225091010","end\_time":"20091225121010","start\_time\_remark":"备注1","end\_time\_remark":"备注2"}</p><p>附录5微信支付分对象结构</p>|
|服务位置|location||否|<p>格式为Location转换成的json字符串，Location相关说明见下方。用于用户侧展示服务位置。</p><p>示例：{"start\_location":"嗨客时尚主题展餐厅","end\_location":"嗨客时尚主题展餐厅"}</p><p>附录5微信支付分对象结构</p>|
|用户标识|openId|String(128)|否|微信用户标识，needUserConfirm为false时，openId与subOpenId必须填写并且只能填写一个|
|子用户标识|subOpenId|String(128)|否|微信用户在子商户公众号sub\_appid下的唯一标识，needUserConfirm为false时，openId与subOpenId必须填写并且只能填写一个|
|是否需要用户确认|needUserConfirm|String(10)|否|填写true或者false，是否需要用户确认订单：true（需确认订单模式）：创建订单成功后需要跳转到支付分侧，用户自行确认订单, false（免确认订单模式）：此接口创建并为用户确认订单（需要用户授权此服务）,默认值false|
|交易通知地址|notifyUrl|String(256)|是|需确认模式的用户确认结果以及支付结果将送到本通知地址|
|商户保留域|mchReserved|String(40)|否|用于传输商户自定义数据，在支付结果查询和交易结果通知时原样返回|
|支付分交易场景|wechatTradeScene|String(32)|是|<p>支付分交易场景的取值包括 ：</p><p>PARKING—车场停车场场景</p><p>PARKING\_SPACE—车位停车场</p><p>GAS—加油场景</p><p>HIGHWAY—高速场景</p><p>BRIDGE—路桥场景</p><p>LIFE\_PAY—生活缴费行业</p><p>SHARABLE\_BIKE—共享单车</p><p>SHARABLE\_CHARGERS—共享充电宝</p><p>E-COMMERCE—电商</p><p>OTHERS—其他</p>|

### <a name="_toc28121"></a>*4.30.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的母单商户订单号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode或respCode为SUCCESS时返回|||||
|服务ID|serviceId|String(32)|是|请求报文中的服务ID|
|子公众账号ID|subAppId|String(32)|否|请求报文中的subAppId|
|服务信息|serviceIntroduction|String(20)|是|请求报文中的serviceIntroduction|
|服务订单状态|state|String(32)|是|<p>当前单据状态</p><p>CREATED: 服务订单已创建</p><p>DOING: 服务订单进行中</p><p>DONE: 服务订单已完成</p><p>REVOKED: 商户取消服务订单</p><p>EXPIRED: 服务订单已失效，"CREATED"状态超过1小时未变动，则订单失效</p>|
|订单状态说明|stateDescription|String(32)|否|<p>对服务订单"DOING"状态的附加说明：</p><p>USER\_CONFIRM：用户确认</p><p>MCH\_COMPLETE：商户完结</p>|
|后付费项目|postPayments||否|请求报文中的postPayments|
|商户优惠|postDiscounts||否|请求报文中的postDiscounts|
|服务风险金|riskFund||否|请求报文中的riskFund|
|服务时间|timeRange||否|请求报文中的timeRange|
|服务位置|location||否|请求报文中的location|
|微信支付服务订单号|wechatOrderId|String(64)|否|微信支付服务订单号，每个微信支付服务订单号与商户号下对应的商户订单号一一对应|
|跳转微信侧数据包|package|String(1024)|否|确认订单流程，商户前端跳转到微信侧传入的数据包|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|



## <a name="_toc11010"></a>4.31微信支付分完结订单
### <a name="_toc32699"></a>*4.31.1 业务功能*
完结微信支付分订单。用户使用服务完成后，商户可通过此接口完结订单。完结接口调用成功后，招行将自动发起免密代扣。若扣款失败，招行在一定时间范围内按照一定频次将自动再次发起免密代扣，最终代扣结果以查询结果为准。

前置条件：服务订单状态为“进行中”且订单状态说明需为[USER\_CONFIRM:用户确认]

### <a name="_toc18853"></a>*4.31.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|服务ID|serviceId|String(32)|是|微信支付分分配的服务ID|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一，要求以“商户号+0”开头上送，要求此参数只能由数字、大小写字母\_-|\*组成。此订单号会作为支付分商户服务订单号上送给微信。示例：30899914206070X0123456|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|收银员|userId|String(32)|是|招行提供的收银员信息|
|后付费项目|postPayments||是|<p>后付费项目列表，格式为array[Payment]转换成的json字符串，Payment相关说明见下方。最少包含1条，最多包含100条付费项目，创建订单接口传入的【后付费项目】将失效，以本接口传入的【付费项目】为准。</p><p>示例：[{"name":"就餐费用","amount":40000,"description":"就餐人均100元","count":4}]</p><p>详细结构见附录5微信支付分对象结构</p>|
|商户优惠|postDiscounts||否|<p>商户优惠列表，格式为array[ServiceOrderCoupon]转换成的json字符串，ServiceOrderCoupon相关说明见下方。最多包含30条商户优惠，创建订单接口传入的【商户优惠】将失效，以本接口传入的【商户优惠】为准。</p><p>示例：[{"name":"满20减1元","description":"不与其他优惠叠加","amount":100,"count":2}]</p><p>详细结构见附录5微信支付分对象结构</p>|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|交易金额|txnAmt|String(13)|是|<p>单位为分，</p><p>1\. 金额：数字，必须≥0（单位：分）</p><p>2\. 总金额 =（付费项目1+...+付费项目n）-（商户优惠1+…+完结商户优惠n）</p><p>3\. 总金额上限</p><p>1）【评估不通过：交押金】模式：总金额≤创单时填写的“订单风险金额”</p><p>2）【评估不通过：拒绝】模式：总金额≤“服务风险金额”</p>|
|服务时间|timeRange||否|<p>格式为TimeRange转换成的json字符串，TimeRange相关说明见下方。实际服务时间，创建订单未填写服务结束时间，则完结的时候，服务结束时间必填</p><p>示例：{"start\_time":"20091225091010","end\_time":"20091225121010","start\_time\_remark":"备注1","end\_time\_remark":"备注2"}</p><p>详细结构见附录5微信支付分对象结构</p>|
|服务位置|location||否|<p>格式为Location转换成的json字符串，Location相关说明见下方。实际服务位置，覆盖创建订单时的服务位置，用于用户端展示</p><p>示例：{"start\_location":"嗨客时尚主题展餐厅","end\_location":"嗨客时尚主题展餐厅"}</p><p>详细结构见附录5微信支付分对象结构</p>|
|完结服务时间|completeTime|String(64)|否|<p>时间使用ISO 8601所定义的格式。</p><p>示例：</p><p>- YYYY-MM-DDTHH:mm:ss.SSSZ</p><p>- YYYY-MM-DDTHH:mm:ssZ</p><p>- YYYY-MM-DDTHH:mm:ss.SSS+08:00</p><p>- YYYY-MM-DDTHH:mm:ss+08:00</p>|

### <a name="_toc3477"></a>*4.31.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文种的商户商户订单号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode或respCode为SUCCESS时返回|||||
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|


## <a name="_toc12008"></a>4.32微信支付分查询订单
### <a name="_toc19702"></a>*4.32.1 业务功能*
用于查询单笔微信支付分订单详细信息。扣款结果查询需调用支付结果查询接口。
### <a name="_toc20589"></a>*4.32.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|招行商户号|
|服务ID|serviceId|String(32)|是|微信支付分分配的服务ID|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一，要求以“商户号+0”开头上送，要求此参数只能由数字、大小写字母\_-|\*组成。此订单号会作为支付分商户服务订单号上送给微信。示例：30899914206070X0123456|
|收银员|userId|String(32)|是|招行提供的收银员信息|

### <a name="_toc16917"></a>*4.32.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的母单商户订单号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode或respCode为SUCCESS时返回|||||
|服务ID|serviceId|String(32)|是||
|子公众账号ID|subAppId|String(32)|否||
|服务信息|serviceIntroduction|String(20)|是||
|服务订单状态|state|String(32)|是|<p>当前单据状态</p><p>CREATED: 服务订单已创建</p><p>DOING: 服务订单进行中</p><p>DONE: 服务订单已完成</p><p>REVOKED: 商户取消服务订单</p><p>EXPIRED: 服务订单已失效，"CREATED"状态超过1小时未变动，则订单失效</p>|
|订单状态说明|stateDescription|String(32)|否|<p>对服务订单"DOING"状态的附加说明：</p><p>USER\_CONFIRM：用户确认</p><p>MCH\_COMPLETE：商户完结</p>|
|后付费项目|postPayments||否|详细结构见附录5微信支付分对象结构|
|商户优惠|postDiscounts||否|详细结构见附录5微信支付分对象结构|
|服务风险金|riskFund||否|详细结构见附录5微信支付分对象结构|
|交易金额|txnAmt|String(13)|否|单位是分|
|收款信息|collection||否|<p>收款成功后，展示具体的收款信息，格式为Collection转换成的json字符串，Collection相关说明见下方。</p><p>示例：{"state":"USER\_PAID","total\_amount":50000,"paying\_amount":40000,"paid\_amount":10000,"details":[{"seq":1,"amount":10000,"paid\_type":"NEWTON","paid\_time":"20091225091210","transaction\_id":"15646546545165651651","promotion\_detail":[{"coupon\_id":"123456","name":"单品优惠-6","scope":"GLOBAL","type":"CASH","amount":100,"stock\_id":"activity\_id","wechatpay\_contribute":100,"merchant\_contribute":100,"other\_contribute":100,"currency":"CNY","goods\_detail":[{"goods\_id":"M1006","quantity":1,"unit\_price":1,"discount\_amount":100,"goods\_remark":"商品备注信息"}]}]}]}</p><p>详细结构见附录5微信支付分对象结构</p>|
|服务时间|timeRange||否|详细结构见附录5微信支付分对象结构|
|服务位置|location||否|详细结构见附录5微信支付分对象结构|
|用户标识|openId|String(128)|否|用户标识|
|用户标识|subOpenId|String(128)|否|微信用户在子商户公众号sub\_appid下的唯一标识|
|微信支付服务订单号|wechatOrderId|String(64)|否|微信支付服务订单号，每个微信支付服务订单号与商户号下对应的商户订单号一一对应|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|


## <a name="_toc31267"></a>4.33微信支付分撤销订单
### <a name="_toc26459"></a>*4.33.1 业务功能*
微信支付分订单创建之后，由于某些原因导致订单不能正常支付时，可使用此接口取消订单。订单为以下状态时可以取消订单：CREATED（已创单）、DOING（进行中）（包括商户完结支付分订单后，且支付分订单收款状态为待支付USER\_PAYING）

### <a name="_toc27194"></a>*4.33.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|招行商户号|
|服务ID|serviceId|String(32)|是|微信支付分分配的服务ID|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一，要求以“商户号+0”开头上送，要求此参数只能由数字、大小写字母\_-|\*组成。此订单号会作为支付分商户服务订单号上送给微信。示例：30899914206070X0123456|
|收银员|userId|String(32)|是|招行提供的收银员信息|
|原因|reason|String(50)|是|取消订单原因|

### <a name="_toc8696"></a>*4.33.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的母单商户订单号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode或respCode为SUCCESS时返回|||||
|关单处理状态|closeState|String(1)|是|<p>C 订单关闭成功</p><p>F 被关闭交易为失败状态，关单失败</p>|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc6624"></a>4.35微信支付分确认订单通知
### <a name="_toc29749"></a>*4.35.1 业务功能*
将用户确认订单消息通知给商户。通知地址为创建订单时上送的notifyUrl
### <a name="_toc192"></a>*4.35.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|通知类型|notifyType|String(40)|是|固定PAYSCORE.USER\_CONFIRM|
|商户号|merId|String(32)|是|招行商户号|
|服务ID|serviceId|String(32)|是|微信支付分分配的服务ID|
|子公众账号ID|subAppId|String(32)|是|` `微信公众平台分配的与传入的子商户商户号建立了支付绑定关系的AppID，可在公众平台查看绑定关系，此参数需在微信支付分系统先进行配置。|
|商户订单号|orderId|String(32)|是|<p>"要求以“商户号+0”开头上送，要求此参数只能由数字、大小写字母\_-|\*组成。</p><p>示例：30899914206070X0123456"</p>|
|子用户标识|subOpenId|String(128)|否||
|服务信息|serviceIntroduction|String(20)|是||
|服务订单状态|state|String(32)|是|当前单据状态，DOING|
|订单状态描述|stateDescription|String(32)|否|对服务订单"进行中"状态的附加说明，USER\_CONFIRM:用户确认|
|后付费项目|postPayments||是|详细结构见附录5微信支付分对象结构|
|商户优惠|postDiscounts||否|详细结构见附录5微信支付分对象结构|
|服务风险金|riskFund||是|详细结构见附录5微信支付分对象结构|
|交易币种|currencyCode|String(3)|是|目前只支持人民币（156）|
|交易金额|txnAmt|String(13)|是|单位是分|
|服务时间|timeRange||是|详细结构见附录5微信支付分对象结构|
|服务位置|location||否|详细结构见附录5微信支付分对象结构|
|微信支付服务订单号|wechatOrderId|String(64)|否|微信支付服务订单号，每个微信支付服务订单号与商户号下对应的商户订单号一一对应|
|是否需要收款|needCollection|String(5)|否|<p>是否需要收款</p><p>true: 微信支付分代收款</p><p>false:无需微信支付分代收款</p>|

### <a name="_toc9073"></a>*4.35.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :- |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|响应码|respCode|String(10)|是|招行返回的业务错误码，成功为SUCCESS，失败为FAIL，若此时errCode为SYSTERM\_ERROR则表示本次请求处理异常，商户可尝试再次发起下单请求|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|

## <a name="_toc20887"></a>4.36 智能合约交易分账
### <a name="_toc30438"></a>*4.36.1 业务功能*
客户可调用此接口主动对智能合约交易执行分账操作
### <a name="_toc24673"></a>*4.36.2 请求参数*

|**变量描述**|**变量名**|**类型**|<p>**是否**</p><p>**必填**</p>|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|合约ID|contractId|String(64)|是|合约ID|

### <a name="_toc7591"></a>*4.36.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|合约ID|contractId|String(64)|是|请求报文中的合约ID|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|分润状态|result|String(4)|是|<p>BS00：分润成功</p><p>BS01：分润失败</p>|
|子合约执行信息|benefitResult|Map<String,Object>|否|<p>子合约执行信息。</p><p>Map中的</p><p>key:子合约id,</p><p>value:子合约执行状态(true:成功 false:失败)</p>|
|失败原因|errorMsg|String(1024)|否|失败原因|
|分润时间|benefitTime|String(19)|否|格式：yyyy-mm-dd hh:MM:ss|
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|


## <a name="_toc9955"></a>4.37 微信授权码查询openid
### <a name="_toc32116"></a>*4.37.1 业务功能*
通过授权码查询公众号 openid，调用查询后，该授权码只能由此商户号发起扣款，直至授权码更新。 如果子商户号没有绑定 appid，只返回 openid；如果子商户号绑定一个或多个 appid，入参 sub\_appid 必传， 返回 openid 和 sub\_openid。
### <a name="_toc17059"></a>*4.37.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|子商户公众账号ID|subAppId|String(32)|否||
|授权码|authCode|String(128)|是||

### <a name="_toc31068"></a>*4.37.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，请求是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|子商户公众账号ID|subAppId|String(32)|是|请求报文中的子商户公众账号ID|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|用户标识|openId|String(128)|是||
|用户子标识|subOpenId|String(129)|否||
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc24465"></a>4.38 支付宝先享后付-统一收单交易支付
### <a name="_toc30277"></a>*4.38.1 业务功能*
商户使用已创建的订单信息进行支付。
### <a name="_toc23778"></a>*4.38.2 请求参数*

|**变量描述**|**变量名**|**类型**|<p>**是否**</p><p>**必填**</p>|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(15)|是|商户在招行完成商户进件后分配的招行商户号|
|附加经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商户门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|收银员|userId|String(32)|是|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|商户订单号|orderId|String(32)|是|商户端生成，要求此订单号在整个商户下唯一|
|外部商户订单号|outOrderId|String(32)|是|支付宝先享后付-订单创建请求参数中的外部商户订单号outOrderId|
|销售产品码|productCode|String(32)|是|<p>线下预授权场景：PRE\_AUTH</p><p>线上预授权场景：PRE\_AUTH\_ONLINE</p><p>**代扣场景：GENERAL\_WITHHOLDING**</p>|
|订单标题|subject|String(256)|是||
|订单描述|body|String(128)|否||
|买家的支付宝用户ID|buyerId|String(28)|否|预授权场景下必送，填写预授权冻结阶段支付宝返回的 payer\_logon\_id|
|交易金额|txnAmt|String(13)|是|单位为分|
|交易币种|currencyCode|String(3)|否|默认156，目前只支持人民币（156）|
|商品优惠信息|goodsDetail|String(6000)|否|第三方单品优惠信息描述，规则见[2.6.5.支付宝商品列表](#_2.6.5.支付宝商品列表)|
|业务扩展参数|alipayExtendParams|String(6000)|否|<p>支付宝业务扩展字段</p><p>productCode为代扣场景GENERAL\_WITHHOLDING需上送：tradeComponentOrderId 交易组件业务主单号     填写订单创建alipay.open.mini.order.create时返回的交易组件订单号order\_id</p><p>tcInstallmentOrderId 填写**创建分期单-alipay.open.mini.order.installment.create**返回的分期单号installment\_order\_id</p>|
|支付有效时间|timeoutExpress|String(6)|是|该笔订单允许的最晚付款时间，逾期将关闭交易。**取值范围：1m～15d**。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。|
|协议信息|agreementParams|String(6000)|否|<p>productCode为代扣业务需要传入协议相关信息，代扣场景必送。</p><p>agreementNo 代扣协议号   填**zhima.credit.payafteruse.creditagreement.changed**返回的ext\_info中的ext\_info.deductAgreement.GENERAL\_WITHHOLDING\_P</p>|
|限制支付渠道|disablePayChannels|String(128)|否|禁用渠道，用户不可用指定渠道支付，多个渠道以逗号分割，枚举值见https://doc.open.alipay.com/docs/doc.htm?docType=1&articleId=107723|
|预授权号|authNo|String(64)|否|预授权号，预授权转交易请求中传入，适用于预授权转交易业务使用，目前只支持 FUND\_TRADE\_FAST\_PAY（资金订单即时到帐交易）、境外预授权产品（OVERSEAS\_AUTH\_PAY）两个产品。|
|预授权确认模式|authConfirmMode|String(32)|否|<p>预授权确认模式，授权转交易请求中传入，适用于预授权转 交易业务使用。</p><p>目前只支持 PRE\_AUTH(预授权产品码) COMPLETE：转交易支付完成结束预授权 ， 解冻剩余金额 ;NOT\_COMPLETE：转交易支付完成不结束预授权，不解冻剩余金额</p>|
|优惠参数|promoParams|String(512)|否|优惠明细参数，通过此属性补充营销参数|
|支付模式类型|advancePaymentType|String(20)|否|支付模式类型,若值为ENJOY\_PAY\_V2表示当前交易允许走先享后付2.0垫资|
|查询选项|queryOptions|String(1024)|否|<p>商户通过上送该参数来定制同步需要额外返回的信息字段（支付宝），**数组形式的字符串**</p><p>示例："[\"fund\_bill\_list\",\"voucher\_detail\_list\",\"discount\_goods\_detail\"]"</p>|
|商户传入业务信息|businessParams|String(512)|否|商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景|
|商户保留域|mchReserved|String(128)|否|用于传输商户自定义数据，在支付结果查询和交易结果通知时原样返回|
|终端信息|encryptTerminalInfo|String(10000)|是|<p>终端信息，详见[终端信息](#_2.7.1 终端信息terminalinfo)</p><p>[terminalInfo](#_2.7.1 终端信息terminalinfo)。需加密[详见敏感信加密](#_2.4.4 敏感信息加密)</p><p>需加密[详见敏感信加密](#_2.4.4 敏感信息加密)</p>|
|交易地址信息|encryptTradeAddressInfo|String(1024)|否|<p>交易地址信息，[详见交易地址信息](#_2.7.4 交易地址信息tradeaddressinfo)</p><p>[tradeAddressInfo](#_2.7.4 交易地址信息tradeaddressinfo)。</p><p>需加密[详见敏感信加密](#_2.4.4 敏感信息加密)</p>|

### <a name="_toc21709"></a>*4.38.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|`	`**以下字段仅在returnCode为SUCCESS时返回**	|||||
|商户号|merId|String(32)|是|请求报文中的商户号merId|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号orderId|
|外部商户订单号|outOrderId|String(32)|是|请求报文中的外部商户订单号outOrderId|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|平台订单号|cmbOrderId|String(32)|是|招行生成的订单号|
|用户标识|openId|String(128)|否|支付宝支付：用户在支付宝系统的唯一标识|
|第三方订单号|thirdOrderId|String(64)|否|支付宝侧的订单号|
|支付宝账户|buyerLogonId|String(64)|否|支付宝支付的交易返回，如：koh\*\*\*@sandbox.com|
|交易状态|tradeState|String(1)|是|P - 支付状态未知（可能需要用户输入支付密码）<br>F - 支付失败<br>S - 支付成功|
|交易金额|txnAmt|String(13)|是|单位为分|
|优惠金额|dscAmt|String(13)|是|单位为分|
|支付宝商品优惠信息|discountGoodsDetail|String（1024）|否|<p>支付宝本次交易支付所使用的单品券优惠的商品优惠信息，示例如下：</p><p>[{"goodsId":"STAN DARD1026181538","goodsName":"雪碧","discountAmount":"10.00"}]</p>|
|订单发送时间|txnTime|String(14)|是|订单生成时间，格式为yyyyMMddHHmmss|
|订单完成日期|endDate|String(8)|否|第三方系统返回的交易完成日期，此日期仅在交易成功是返回，不保证是实际清算日期，格式为yyyyMMdd<br>若交易是支付宝和微信通道，则交易成功时返回此字段；<br>若交易是银联通道，则不返回此字段；|
|订单完成时间|endTime|String(6)|否|第三方系统返回的交易完成时间，此时间仅在成功是返回，格式为HHmmss<br>若交易是支付宝和微信通道，则成功时返回此字段<br>若交易是银联通道，则不返回此字段|
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## <a name="_toc9718"></a><a name="_toc1983"></a>4.39 微信刷脸获取调用凭证
### <a name="_toc4903"></a><a name="_toc9636"></a>*4.39.1 业务功能*
通过调用微信接口获取调用凭证返回商户以便使企业提供刷脸支付场景服务时能够使用微信人脸支付服务
### <a name="_toc18242"></a>*4.39.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|门店编号|storeId|string(32)|是|门店编号， 由商户定义， 各门店唯一。|
|门店名称|storeName|string(128)|是|门店名称，由商户定义。（可用于展示）|
|终端设备编号|deviceId|string(32)|是|终端设备编号，由商户定义。|
|子商户公众账号ID|subAppId|String(32)|否||
|初始化数据|rawdata|String(2048)|是||

### <a name="_toc25788"></a><a name="_toc7898"></a>*4.39.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，请求是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|子商户公众账号ID|subAppId|String(32)|否|请求报文中的子商户公众账号ID|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|SDK调用凭证|authInfo|String(4096)|是||
|authinfo的有效时间|expiresIn|String|否||
|随机字符串|nonceStr|String（32）|是||
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## 4\.40 支付宝商户前置内容咨询
### *4.40.1 业务功能*
在展示商户支付页时调用，获取用户营销信息便于向用户展示营销内容
### *4.40.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|业务场景|bizScene|String(64)|是|业务场景，用于区分商户具体的咨场景，示例：ALIPAY\_PROMO|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|收银员|userId|String(10)|否|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|交易总金额|totalAmt|string(11)|是|订单总金额，单位分|
|拓展参数|alipayExtendParams|string(6000)|是|<p>JSON格式的字符串</p><p>示例："alipayExtendParams": {</p><p>"outOpenId":"match\_test\_id", // 在商户系统中唯一标识用户</p><p>"appSource":"wechat" // 标识从哪个APP端来源</p><p>"promo\_ext\_params": "[{\"payType\":\"xxxxICBC\_DEBIT\",\"lastUseModified\":\"24.3\"},{\"pay</p><p>Type\":\"xxxxICBC\_CREDIT\",\"lastUseModified\":\"24.3\"}]" // 预留，可不填</p><p>}</p>|
### *4.39.3 返回参数*
在调用预创建交易接口时（支付宝native接口），通过支付宝接口“businessParams”字段的二级字段“channel\_operation\_info”传递商户前置内容咨询接口返回的channel\_operation\_info内容。传递内容示例如下："businessParams":{"channel\_operation\_info":"#{UCBJeS6DV4wrBfYWZf32QQr0JBQLvm}#"

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，请求是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|**以下字段仅在returnCode为SUCCESS时返回**|||||
|商户号|merId|String(32）|是|请求报文中的商户号|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|**以下字段仅在returnCode和respCode为SUCCESS时返回**|||||
|优惠信息|channelInfoList|PayChannelPromoInfo[]|否|<p>详见：[2.7.5 商户营销信息PayChannelPromoInfo](#_2.7.5 商户营销信息paychannelpromoinfo)</p><p>示例：{</p><p>"channelInfoList":[{"channel\_name":"花呗","channel\_enable":true,"channel\_operation\_info":"#{o2u3490flaut9f70273946h}#","operation\_list":[{"view\_data":{"operation\_tip":"花呗立减","operation\_desc":"花呗支付立减优惠","promo\_type":"ALICREDIT","logo":"http:/xxxx.xxx.xxx","promo\_price":"0.5"}}]}]}</p>|
|**以下字段仅在returnCode或respCode为FAIL时返回**|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|

## 4\.41 支付宝吱口令获取
### *4.41.1 业务功能*
吱口令服务场景，用于在商户支付页，当用户选择支付宝支付时，生成可通过支付宝App完成支付的口令信息
### *4.41.2 请求参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是||
|签名方法|signMethod|String(2)|是|02：SM2|
|业务场景|bizScene|String(64)|是|示例：ISV\_PAY\_PAGE|
|商户号|merId|String(32)|是|商户在招行完成商户进件后分配的招行商户号|
|<p>商户订单号</p><p></p>|orderId|string(32)|是|请求报文中的商户订单号|
|经营商户号|subMerId|String(32)|否|招行附加经营商户号。平台商户和附加经营商户联合支付场景使用|
|经营商门店号|subStoreId|String(32)|否|招行附加经营商户号对应的门店号。平台商户和附加经商商户联合支付场景，附加经营商户号和经营商户门店号需同时上送|
|收银员|userId|String(10)|否|招行系统生成的收银员，每个收银员均会对应到一个门店。若商户无门店、收银员概念则上送默认的虚拟收银员即可。|
|付款金额|payAmt|String(11)|否|订单需要支付的金额，单位分|
|商户用户唯一标识|outOpenId|String(64)|否|开放平台为服务商用户分配的用户唯一标识|
|吱口令跳转地址|bizLink|String(1024)|是|下单返回的qrCode|
|吱口令有效期|expireTime|String(16)|否|吱口令有效期，单位秒|
|营销信息|channelInfo|String(32)|是|<p>渠道信息摘要标识，在APP内吱口令跳转时用</p><p>到，用来标识吱口令关联的服务信息，比如红</p><p>包、花呗工具。有两种方式获得：1.在于支付宝</p><p>进行业务合作时，由平台侧分配；2.在咨询前置</p><p>服务时由接口返回</p>|
|业务跟踪参数|bizTracker|String(512)|否|用于串联用户业务行为的关系|
|拓展字段|alipayExtendParams|String(1024)|否|<p>JSON格式的字符串</p><p>示例："alipayExtendParams":{		"trade\_no":"2023101822001462491412827405" //交易号</p><p>`	`}</p>|

### *4.41.3 返回参数*

|**变量描述**|**变量名**|**类型**|**是否必填**|**备注**|
| :-: | :-: | :-: | :-: | :-: |
|版本号|version|String(5)|是|固定为0.0.1|
|编码方式|encoding|String(20)|是|固定为UTF-8|
|签名|sign|String(1024)|是|　|
|签名方法|signMethod|String(2)|是|02：SM2|
|返回码|returnCode|String(7)|是|SUCCESS/FAIL,此字段是通信标识，非交易标识，请求是否成功需要查看respCode来判断。SUCCESS表示商户上送的报文符合规范，FAIL表示报文内的字段不符合规范，包括长度超长、非法字符、签名错误等|
|以下字段仅在returnCode为SUCCESS时返回|||||
|商户号|merId|String(32)|是|请求报文中的商户号|
|商户订单号|orderId|String(32)|是|请求报文中的商户订单号|
|响应码|respCode|String(10)|是|业务错误码，成功为SUCCESS，失败为FAIL|
|第三方错误描述|errDescription|String(256)|否|第三方处理失败时返回第三方的错误信息|
|以下字段仅在returnCode和respCode为SUCCESS时返回|||||
|吱口令|shareToken|String(1024)|是||
|吱口令过期时间|expireDate|String(32)|是|吱口令失效时间，若为空则表示永久有效，示例：2023-05-06 00:00:00|
|业务token|bizToken|String(64)|是|用来串联业务操作行为及分析|
|分享引导文案1|guideText1|String(1024)|否|吱口令分析引导文案前半段，即【#吱口令#长按复制此条消息即可分享,】|
|分享引导文案2|guideText2|String(1024)|否|吱口令分析引导文案后半段，即【,赶快去分享吧】|
|以下字段仅在returnCode或respCode为FAIL时返回|||||
|错误码|errCode|String(32)|是|请求处理失败的错误码信息|
|应答信息|respMsg|String(256)|是|请求处理失败的详细描述信息|


# <a name="_toc11194"></a><a name="_toc18310"></a><a name="_toc5829"></a>**5.错误代码说明**
## <a name="_toc22238"></a><a name="_toc23956"></a><a name="_toc17194"></a>5.1接口返回的returnCode说明
returnCode为通讯层错误码，该字段返回SUCCESS表示聚合收单系统解析商户系统的请求报文是成功的，返回FAIL表示通讯失败或商户系统的请求报文不符合规范，如必传字段为空或签名校验失败等，当且仅当该字段为SUCCESS时才会返回业务数据。
## <a name="_toc20456"></a>5.2接口返回的respCode说明
respCode为业务层错误码，该字段返回SUCCESS表示业务层处理是成功的，返回FAIL表示受理此业务处理失败。
## <a name="_toc28007"></a>5.2接口返回的errCode说明

errCode表示具体错误原因，该字段在returnCode或respCode为FAIL试返回，具体取值可参见[附录3](#_附录3)。


# <a name="_toc16803"></a><a name="_附录1"></a>**附录1 接入参数说明**
异步通知的回调地址招行需要申请网络开通（测试环境和生产环境均需要），开通需要2~3个工作日，请商户提前提供回调地址给负责联调支持的同事。

商户在完成测试环境联调时支付的金额必须当天进行退款，**测试环境隔日无法退款**。联调完成之后请务必联系招行对接人获取验收用例文档，须在测试环境执行验收用例并反馈给招行对接人完成测试环境验收后方能进行生产接入。

注：测试环境联调测试需注意以下事项：

1、测试环境银联的扫码支付和条码支付，请使用银联仿真工具进行测试，仿真工具地址为：https://open.unionpay.com/tjweb/ij/tool/qrcodeFormPage，使用方法（以扫码支付为例）如下：

1\.1、选择【主扫场景】-【付款放仿真】；

1\.2、查询订单

1\.3、点击【2.查询订单】,在【二维码】中填上二维码，点击【发送】，发起订单查询，返回【查询订单应答】,复制其中的txnNo，用户付款时使用；

1\.4、付款

1\.5、点击【3.付款】,在【交易序列号】中填上txnNo,点击【发送】完成付款；

2、因测试环境限制，微信的收款码申请场景无法做扫码支付测试，请在生产环境验证；

3、测试环境的扫码支付，商户需要修改二维码字段（生产环境无需修改），将字段中的https://qr.95516.com改为http://payment-uat.cs.cmburl.cn，然后再转成二维码图片展示；

线上场景测试请准备以下信息，并联系行内联调支持人员：

1. 公众号支付：
   1) 公众号APPID
   1) 公众号主体信息
   1) 支付授权目录
1. APP支付：
   1) APP应用的APPID
   1) APP的主体信息
1. 小程序支付：
   1) 小程序APPID

小程序主体信息

测试环境报文头MD5加签秘钥（生产环境在聚合收款服务平台获取）：

测试环境APP ID：8ab74856-8772-45c9-96db-54cb30ab9f74

测试环境APP SECRET：5b96f20a-011f-4254-8be8-9a5ceb2f317f


测试环境报文体SM2加签秘钥（生产环境在聚合收款服务平台设置和获取）：

商户私钥（商户端联调测试加签使用）：

D5F2AFA24E6BA9071B54A8C9AD735F9A1DE9C4657FA386C09B592694BC118B38

招行公钥（商户端联调测试验签使用）：

MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE6Q+fktsnY9OFP+LpSR5Udbxf5zHCFO0PmOKlFNTxDIGl8jsPbbB/9ET23NV+acSz4FEkzD74sW2iiNVHRLiKHg==
# <a name="_toc24627"></a><a name="_附录2"></a>**附录2 报文样例**
注：所有商户发起的请求报文，均需在报文头中填写APP ID校验所需字段内容，详见[2.4.3章节](#_2.4.3 app id校验)介绍。

1\.付款码申请

`      `"API案例描述": "收款码申请正向报文样例"

`      `"调用方式": "POST"

`      `"请求报文内容": 

{

`    `"biz\_content": "{\"termId\":\"00001\",\"orderId\":\"120180329587545340\",\"notifyUrl\":\"http://wlhost1.paas.cmbchina.cn/mch\_notify/api/notify\",\"merId\":\"3089991701207X7\",\"payValidTime\":\"1000\",\"currencyCode\":\"156\",\"userId\":\"N003109945\",\"txnAmt\":\"1\",\"mchReserved\":\"1\"}",

`    `"encoding": "UTF-8",

`    `"sign": "BkVDmv8uqPNoHt//gsZwLd2yia0KCzL3D03PsclN21ahBwhP6o0CHpf6CQOMRg73gnnDiis17GvQNYFewpgzEKFaoOB6cEGmONnVZpxwdw+CvoVIoEIzzdY5XdWdV2a/Xd6z9NVx7YYqQE7p92ycE9/YWBgDiQEqbzG3s8DMu6Fgr+kI1TKr12i5bNEA5bbIrNRUybivIm2uC1zQyUzhnZKsJ3z6NkBr074nJ6XLU1/ZEgWUX7ikdikKpBAtekuIdgKZk+R9mBiS+mqP68qNdHGxgS7e+tHOqIuDD13IEkh5eiDcV+Xz6PjbDRsIVJkAzfNe3PDK+G+Mmp1LdXFkMQ==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"cmbOrderId\":\"100419022715054630934407\",\"qrCode\":\"https://qr.95516.com/03080000/1004/100419022715054630934407\",\"orderId\":\"120180329587545340\",\"txnTime\":\"20190227150547\",\"merId\":\"3089991701207X7\"}",

`    `"sign": "Lp01sZWyNwmAReYpI/fH+AZYhJSqFrZQFIrbFrBykilL9dRz73xJmQ3mWZKknejC9wwndHuJhi+LZEiwVjb26RGIO1iobDOnwXPYAMumrI+7f+AFWcTJC+peLoJqUGv0gnMOjk3CtFZzLJ449nDRDjsKGkNMLzRQb/CAib/o0vMWz0lpaylA/dJZaSgtJ+k4euVMR3cX02XWJY3y1wKi1O3JvBbkqkTSYoUdCm2dNzzZISiJKtW73kRkpfxGHaOH+bw5vRX5cXFRUDOF0tSzKxmAyPhE9sr6EqA2LmJc8ad21hHADqt0h++r8VkHXxpp2rP5cPoQZcAZPs2nVuZRPw==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}


`    `"API案例描述": "收款码申请异常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"termId\":\"00001\",\"orderId\":\"120180329587545340\",\"notifyUrl\":\"http://wlhost1.paas.cmbchina.cn/mch\_notify/api/notify\",\"merId\":\"3089991701207X71\",\"payValidTime\":\"1000\",\"currencyCode\":\"156\",\"userId\":\"N003109945\",\"txnAmt\":\"1\",\"mchReserved\":\"1\"}",

`    `"encoding": "UTF-8",

`    `"sign": "DR28lL2HKk3CMbpKobV5DZKet8PdKHfBsGeFcx8GuInRfLL/PedXsBiqlHiYnYXsrr1gq6+4gd7FekOy/rI0AomTYVmm2fg4e67ESdr4dD6fzuMf/jiAc2N93RmOJXeB1q8UiX0TXA26Pi3X2i3X0GiguwLMcKx+aQ9K411ovRul68zrfyat7F47pfWnnmnjQ34K4yEFg2+/XOed1NtSY0j8f+wJj4VRlWuhJ4M1sVQb3CaxFOmljWk10TzbRuZUSdeYjMqQ9Pp3RFAKgTjMVw1xJEtlPFPlPCqBt0FNPTkAqdo8z8WPyptNFxXt0u28CFwEMGxO5pz9Y3dbsMxptA==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`	`"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "U4+/PMYMecqlQBF5CULJHa2QZuUnAS4bEujLHBBpQZi2w5Q1JaMW0vcjIn6oaLoXtB030njP50w9mWympcGDEAi6XW0kjZPBSfwUtS9stLRF4TXyPO0mw/H9hd+WbGbBkoOEGnEFSRCJpI0LNRAFczSoZB1dBtfnlSFTEXA49mI2KdZTeH9JOcdwMMpyINR83dJhGFI2zQtGnZ68n3wQ4sKRbuHXmg4qnmIDYHJSc4bXbtHUGKuWMZ6M/NEy3UEhRjnDhIq5zwUGRI/Z4l92s2jdVckNfcuRzpNZ60OCrNZQnspQTgtBzABHH1svVamvbtU3j3Hu/ihwC8wAFbLZdA==",

`    `"respMsg": "商户号不存在",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}

2\.支付结果查询

`    `"API案例描述": "支付结果查询正向报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"cmbOrderId\":\"900119022715203210134445\",\"userId\":\"N003109945\",\"merId\":\"3089991701207X7\",\"orderId\":\"9001004180329103417277\"}",

`    `"encoding": "UTF-8",

`    `"sign": "UwCQ3qXGG7J+ODlZmfT5MSLqAC0etJwb1kt6zTuMazp1MIxDA8LoLIrPTsjCxdfl8bTjQySBJIED0RBt82U3/1OTOqHQROdTVygS+V8XfdzMznyjpefl2Ev905M5klz8u7/LzrTANZ5E2mOoWeswz2sEXowjYXv5sTHe+apFX7t4Cu+eD5uevSFcZ9DYdT12jUoLzx8yol22lIHwQR0LoyOLGK5whAisXuYN4lbZIM0o1ZxJZyCXfFgIq17lD/YhRWNjpeK5t9lEfQv42R9WjkfkDZp3Xi3/q4+tSh1Q7j1yELdl5BxfZ1z4ChHP0TaMoHbtGD325A1IuLO2vdC9sw==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"mchReserved\":\"1\",\"cmbOrderId\":\"900119022715203210134445\",\"dscAmt\":\"0\",\"payType\":\"ZF\",\"orderId\":\"9001004180329103417277\",\"txnTime\":\"20190227152032\",\"merId\":\"3089991701207X7\",\"currencyCode\":\"156\",\"txnAmt\":\"1\",\"tradeState\":\"S\"}",

`    `"sign": "kGE7mwX/ubRlPsPZGNydjY3uCjILgGuxD4j1e/inyC/DlHn5o7LkISpmrH0YQvoZT6lyOxtr9uIkKnqVcTMZNYeYIBU+Tz8NRaPZHuFr/qQb0+fUgEgq5j9ovaFczAF8wrnEfIRYBEqp0ERtK7NG+X6eZLIr9nNVy31eKcnFx1tToJ/zPYN91GOKOtTrJaJrKeDY4+r3ctzsDhnD+TO2MX5zfvW0WLoUjvX5geiYLVpt022BiyxSJyOsrDS858RBmZ5FbVlYP0v/WqwX+J8VY1kDSLxvPtSZuPnsluJPXw6ccnYNH8dir0VgrYfrWRvnupctIm2elCmL7ES6KzDTGg==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}


"API案例描述": "支付结果查询异常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"cmbOrderId\":\"900119022715203210134445\",\"userId\":\"N002988723\",\"merId\":\"3089991701207X7\",\"orderId\":\"9001004180329103417277\"}",

`    `"encoding": "UTF-8",

`    `"sign": "X4ui83gl9cLm1pg8tGDOtrcZ3YaW6M106r0gUN/qUhUk46f+jaMB1BaQzQM+qgcSMHJBAXzOcr9kTBNMLRV3A45/9fwHtqDwXIpWEnbwgptQgDQSMzbaT6nQVr9YN+ReYDHo6nb277T6WgaXilDuGaFufxNB1qW2dns5VgN6T4liOKJgpzc1prJdARgMd3WGYmahZ4yGWytLekEnvJelzXUlRli/AMAHmRDnNBxYIHbXom8Ho3KlZZKWL5my80sf/K+J0nMAjmO6hr2uZF2xuZlk6hthIBmFkJUJhc7v7e3vhe5cexaLYwD35t7SRuD/6R884gC2ticzYwTmW29K1Q==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"cmbOrderId\":\"900119022715203210134445\",\"orderId\":\"9001004180329103417277\",\"merId\":\"3089991701207X7\"}",

`    `"errCode": "USERID\_CHECK\_FAILED",

`    `"sign": "kt1lWNZDmFTEgZHIxKPwpXBc424aCuogjAd+j75VXKP+TBiiD7y1Lrklqc4lCgBjWG9cR7bxX9rSAK6ihnJ57wzGfl29rzD1hEy42IVsfPx0BH4wsIHkzzLhXDwrTv1ZvCfxsU4pMfJCL3G6+EcMzDUQYpiIbuA8S7PrcCOTxvGbnSOX0pWmuaOTO3amky73k9ZbMe4IlzQcVXoSs0rFf7QpNZ+8nKzLrnYu+dLLJEo1shL5Mya0TzD5mioZKidJWo3aKa77EuRpeQl58xemc65+Xa62IgaPEzoMuorl48uL44ib30WjRv6CF83iqNVRxbwJFrmT1qMkPdJJIFrBVQ==",

`    `"respMsg": "收银员信息校验失败",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "FAIL"

}

3\.退款申请

`    `"API案例描述": "退款申请正向报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容":

{

`    `"biz\_content": "{\"orderId\":\"900120191227174141826\",\"notifyUrl\":\"http://wlhost1.paas.cmbchina.cn/mch\_notify/api/notify\",\"merId\":\"3089991701207X7\",\"currencyCode\":\"156\",\"txnAmt\":\"1\",\"refundAmt\":\"1\",\"refundReason\":\"api refund test\",\"origOrderId\":\"9001004180329103417277\",\"origCmbOrderId\":\"900119022715203210134445\",\"mchReserved\":\"23333333333\",\"userId\":\"N003109945\"}",

`    `"encoding": "UTF-8",

`    `"sign": "K42God9OQ6rRiQm1GRUTV8tdTcsU9AXRyLLIo6JZ2PPo+nWXaE6JqrCAjkjqGxog6BDUgv5YtiRo7YFCltzu8oR0z9XPYOImTnEPIHJiddyvVh9v2qKeQHXePx12R5U6milwOpOg5cdALioKTrZ1h11pg4rrhoW8LooYAfX9K/E5QWFqIv0BkCK4/P4KgMR49xbIxBcLirELLtwnNKe4OwdG0tbKJaLa5eqYzJoWzGvcVcProHqaNlM2oYWk41nv1femgags8Kw7pyzJciE6V7IWqgf8CBoGwglVW4IH8j4EtxA3mw57mopw2+G2NAy3QOXn/XkAAE1DrDotMbYDvw==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`	`"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"refundState\":\"P\",\"cmbOrderId\":\"900119022715340810134449\",\"orderId\":\"900120191227174141826\",\"txnTime\":\"20190227153408\",\"merId\":\"3089991701207X7\"}",

`    `"sign": "XazVn3fhQHCp+eWqtZllkZHW43VikdiiYj1cEWgqVp1IBagn3appooPbZitDWJLRltc4jnbM1J3r+FcUcA+p+5u0Uh0vXu/vQr5jpgfLOYNXDnWYNH8b7ifYYEvl3dDYB1TbHkLvJW0u2tKTY3S0NhBXHZjIVN6poeuezaojhaIchHmWwfAGeMa7I8iD0T6Da7fEB3bNCX5bIFauFsLTHKoKUTfD2hNTYCsWdYiRHMH73zM4ZUuLSw8XTuZ7WJaA8VxhxyHRlEpOAUfqljO9RGq81fLAM0fnAow92sBsZpKO8obArO/jrK9sS6gcqqtttVp7uI9g5c9fOAPOFhhwww==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}

"API案例描述": "退款申请异常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"orderId\":\"900120191227174141827\",\"notifyUrl\":\"http://wlhost1.paas.cmbchina.cn/mch\_notify/api/notify\",\"merId\":\"3089991701207X7\",\"currencyCode\":\"156\",\"txnAmt\":\"1\",\"refundAmt\":\"1\",\"refundReason\":\"api refund test\",\"origOrderId\":\"9001004180329103417277\",\"origCmbOrderId\":\"900119022715203210134445\",\"mchReserved\":\"23333333333\",\"userId\":\"N003109945\"}",

`    `"encoding": "UTF-8",

`    `"sign": "K42God9OQ6rRiQm1GRUTV8tdTcsU9AXRyLLIo6JZ2PPo+nWXaE6JqrCAjkjqGxog6BDUgv5YtiRo7YFCltzu8oR0z9XPYOImTnEPIHJiddyvVh9v2qKeQHXePx12R5U6milwOpOg5cdALioKTrZ1h11pg4rrhoW8LooYAfX9K/E5QWFqIv0BkCK4/P4KgMR49xbIxBcLirELLtwnNKe4OwdG0tbKJaLa5eqYzJoWzGvcVcProHqaNlM2oYWk41nv1femgags8Kw7pyzJciE6V7IWqgf8CBoGwglVW4IH8j4EtxA3mw57mopw2+G2NAy3QOXn/XkAAE1DrDotMbYDvw==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"orderId\":\"900120191227174141827\",\"merId\":\"3089991701207X7\"}",

`    `"errCode": "TRADESTATE\_NOT\_LAWFUL",

`    `"sign": "UVGPmAQd/opihF1qrh73ufz+sXR4WxThQN1K4kucgCbsezK4D9L964TeYOmS6uhRusKSDKFM0m8MET23FvtwprRZzvOUNKFXY/RdWzf9rNSl7Pz8Xejp2+mg66p3xnu2ThCOLaKfN5yOcUwbTarT9Y06ikZhQN3Y1+59VzVDa6a+6WoiNg33vE5MDL8MdRI1dSjdtDKh0y6TF5KyzS1FKC5MRgXIXOIExACfXqK1rmEgr6tuDBO7Ikx/gH1WlCQpg2VwAmNBaiiDPQLrorlDiMzagCP2xoyxTrGuUaFJQzaV9Kf34QjbMvRig1RmDyxrz28XweXKCr7OUahc8gfArQ==",

`    `"respMsg": "原交易状态非法",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "FAIL"

}

4\.退款结果查询

`    `"API案例描述": "退款结果查询正向报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"cmbOrderId\":\"002119022517155841234354\",\"userId\":\"N003109945\",\"merId\":\"3089991701207X7\",\"orderId\":\"27710041829103410011\"}",

`    `"encoding": "UTF-8",

`    `"sign": "MnJLJWEzUvzc7ZGyWWVni6ZJO2hS64t9JDy9QH4xMUbeFMGGTxBmfWKiLrkvvnWkiMRXGzcujGo05C+ATXluLjoOK9kG/jhB0x0g57q76XsawHukO5vxdQJLkCKD262tDwfHA0u5PbFE5IpVRXurn7C6kNnJ2gafI9cdHmdp6XjMGrUPMO4hY0ljVSeUcBRgnqNAWWAutrLf30bC6p7wVmyEoNkiJkQNGHFITeND7xXaMLcXPzWbaApoa4ycfsSNItRDRAHoQzK+eO5NTQA4jBaeqeZz7xh7qh8J7jo8TINx8LFl1nLHReIVGnSi3PmZ4+YDsU/vgcIPyMCR5WNmeA==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`	`"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"refundDscAmt\":\"0\",\"cmbOrderId\":\"002119022517155841234354\",\"orderId\":\"02101902251712101207X70000000549\",\"endDate\":\"20190225\",\"txnTime\":\"20190225171558\",\"merId\":\"3089991701207X7\",\"endTime\":\"171558\",\"currencyCode\":\"156\",\"tradeState\":\"S\",\"refundAmt\":\"6\"}",

`    `"sign": "FNCoG9KLrW2U0V5dDbND5dxEpg2jvhhvrPocwzBFG39AKYH7uuCT/q4mzGinTPJWP49yIwRwp8D8Yj+GG4SC1EboqFcFxPubOtKxMotlGW+rcJyq1bx50mk1NEb16Grov8PFrTTEOB1uCAkDYQ9Z0BrD3oaUM3jL45GmiFeFAJaZ3oe6nlD2yJ8EQ/m/r6Cohex984W1baOLunWeUuCbT3Q0sKq9RlZFLpLjF76D5w94VwMnLO2oHHF/rPPd8hKdzvnhvFsaWZ/hz4G7p2ieVzBwZCCSU3f0SAr9vZBS8Hwrh/2ODVvEgChyz03Odo6KhdodYyGreiUVK/dOz7Hhig==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}

"API案例描述": "退款结果查询异常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"cmbOrderId\":\"002119022517155841234354\",\"userId\":\"N003109945\",\"merId\":\"3089991701207X71\",\"orderId\":\"27710041829103410011\"}",

`    `"encoding": "UTF-8",

`    `"sign": "Xl/rWghFCY+/Y/q5oQXI6ueF7jfg4vts22C4dm9P08LOVUgVIJc2t0tpf8ebyZOPF1LsK9Z9sglywuSqrGkGHhN6oHorCb5+gQ5O1gZciD2d6XMlOIN0wGv5DKC5XIlv7vx2yX+igi+h9qHtGXsZVjHBKwbCcb/q+x3IcPXAarqyiCQQR+POqvjEdAWlLLrT4hJen/0im36p1EdXb9KDWcrcz6HhBSGHVRKoUGuL5SkPgFmivw8nZLsZH/I2O165zeJiTXaL8fzX6GNXI6F4Wv2kkl1Sz26MByjxWnYEDa6lNjo2LiPm49gaA5aWWLJjxTXHTxUG7juP0e8+sXodqw==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`    `"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "U4+/PMYMecqlQBF5CULJHa2QZuUnAS4bEujLHBBpQZi2w5Q1JaMW0vcjIn6oaLoXtB030njP50w9mWympcGDEAi6XW0kjZPBSfwUtS9stLRF4TXyPO0mw/H9hd+WbGbBkoOEGnEFSRCJpI0LNRAFczSoZB1dBtfnlSFTEXA49mI2KdZTeH9JOcdwMMpyINR83dJhGFI2zQtGnZ68n3wQ4sKRbuHXmg4qnmIDYHJSc4bXbtHUGKuWMZ6M/NEy3UEhRjnDhIq5zwUGRI/Z4l92s2jdVckNfcuRzpNZ60OCrNZQnspQTgtBzABHH1svVamvbtU3j3Hu/ihwC8wAFbLZdA==",

`    `"respMsg": "商户号不存在",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}

5\.付款码收款

"API案例描述": "付款码收款正向报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"orderId\":\"9001004180329103417277\",\"merId\":\"3089991701207X7\",\"authCode\":\"288731800822702275\",\"termId\":\"00000001\",\"notifyUrl\":\"http://wlhost1.paas.cmbchina.cn/mch\_notify/api/notify\",\"currencyCode\":\"156\",\"body\":\"哈哈\",\"userId\":\"N003109945\",\"txnAmt\":\"1\",\"mchReserved\":\"1\"}",

`    `"encoding": "UTF-8",

`    `"sign": "KDlKlYuEr5OdD5BP4lUvf0bblYwdc1mb5b7NHL3gB2RppuF4qbz7hd6EF6B+g+6Q7vwznjOPJAZsxaXxoN2+U8QGqqudzhfptVfRww9LCvLP3Fgas5bkuNTy8/sNAUY8DBMNqp4TWR+IxVW/L+dxVHCofTvGYtuLHYOgtC9K4AlQas+SBmuz/+B1aR1ocoJdKI3S5bHX422HePPIVqAS2e4l8ApHCmwVRAqJnPR4oL0skeRxYRH6NrGbjKStHtun/tWqARuAQNc5yiP3JYZpiHjN8uoDRKNYj0aj80aBnWAnAj3RXGJKsJmz6B6iLm3n0KbsezzggG01uHEnxNIdeQ==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`	`"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"cmbOrderId\":\"900119022715203210134445\",\"payType\":\"ZF\",\"dscAmt\":\"0\",\"orderId\":\"9001004180329103417277\",\"txnTime\":\"20190227152032\",\"merId\":\"3089991701207X7\",\"tradeState\":\"S\",\"txnAmt\":\"1\"}",

`    `"sign": "YNKfzqFdzZlkE/ZdIVkLNdWETaYddyCy4GTHZ4Q06FuXIU1styQRngt2aYMJiR0gwvTKAzdiEvQSRFDJg0EPQadPEv/EWW1Hgxm+4MeP39u9Oj/dwuFgfxK6xICEQrLKz2jvfLJIL77A74mx5N/qbRO2ye5Jns47H1SFnePWYc25+6Z+DbkfBstA1mmUYnDGZUUEjp0JmYk4JAX2//qCHGEX3XX76KRdXRLr+SOKFSMQnSlmlnD2Q5gOgYp9LenCpZag756WOWAPny8O/oPrRE1Kfio+8Fshk6E8cbWVUTgCCudzlwCZOr2hJpDlBsb+8aj4ZPLCZI6WtyD+2swnog==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}

"API案例描述": "付款码收款异常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"orderId\":\"9001004180329103417277\",\"merId\":\"3089991701207X71\",\"authCode\":\"288731800822702275\",\"termId\":\"00000001\",\"notifyUrl\":\"http://wlhost1.paas.cmbchina.cn/mch\_notify/api/notify\",\"currencyCode\":\"156\",\"body\":\"哈哈\",\"userId\":\"N003109945\",\"txnAmt\":\"1\",\"mchReserved\":\"1\"}",

`    `"encoding": "UTF-8",

`    `"sign": "Cmz0Hm/Q/o65SPCNsG+B1VOXvR2m9so90SyWRDjVi2xT8koq3kQbiJzBi/o9beTonj9fkapEwNCPd9Qy6QBrtRsY9SghLTOs39iWE5GEEMlfDK5cNjADKUp1UIs9Khm12OPFClfvJE3qVk1UJCWS5dt9pzQdKuSpX7hfsJSgZ8YG4cCvZ8X5AWUbPbmHBcQKRMaQxCkOGpdaCTfLs//lMhZZB/N3VzHqZvHIq7n/Slb53ghmaHh0hzND+2ClxwRcGTCtVvwI23mSlTXVZRBf2fBKy9uVjjOklIsFA2z0PvBrVBVhkkWVrZ47pcadlFVimbBYyXP6WV33GwboHGPN5w==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`    `"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "U4+/PMYMecqlQBF5CULJHa2QZuUnAS4bEujLHBBpQZi2w5Q1JaMW0vcjIn6oaLoXtB030njP50w9mWympcGDEAi6XW0kjZPBSfwUtS9stLRF4TXyPO0mw/H9hd+WbGbBkoOEGnEFSRCJpI0LNRAFczSoZB1dBtfnlSFTEXA49mI2KdZTeH9JOcdwMMpyINR83dJhGFI2zQtGnZ68n3wQ4sKRbuHXmg4qnmIDYHJSc4bXbtHUGKuWMZ6M/NEy3UEhRjnDhIq5zwUGRI/Z4l92s2jdVckNfcuRzpNZ60OCrNZQnspQTgtBzABHH1svVamvbtU3j3Hu/ihwC8wAFbLZdA==",

`    `"respMsg": "商户号不存在",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}

6\.付款码收款撤销

"API案例描述": "付款码收款撤销正向报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"origOrderId\":\"02101902251711371207X70000000548\",\"merId\":\"3089991701207X7\",\"origCmbOrderId\":\"002119022119102220734312\",\"userId\":\"N003109945\"}",

`    `"encoding": "UTF-8",

`    `"sign": "WI+cnO3cxiS8zQGnkyCGSHWXlTq4P0r7VXNOT3sdHyWAYkxkMz9YzJvzoX7H3pYjUh2JCFoqmpFJd0TYUk/2zDipK2JKadvVpxLzy3VEoSoDgKri/yku5EJJh0pnnReBGuZUK1eWeNRLjzjhWozjm3zxhYnkIXZg+yjFldmWeyukQSAZr62rbTIM1/YmAmUKeXmi10scriRfQ1dtLihik8yRk3FQXFk95AaWuyN5chbDjw6VlELAhDApfTSP8F1CuNtcQGlBmTy3teI6CrtW08BQLqyJER8XpTPcI95Vmk1S+1i6dNYN1eR++yxjm+PAKz1x41GswC1BG6QJa502Ng==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`	`"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"origOrderId\":\"02101902251711371207X70000000548\",\"txnTime\":\"20190227165430\",\"merId\":\"3089991701207X7\",\"cancelState\":\"D\"}",

`    `"sign": "a4W2RtURyhV1DQBhHRKsLLgjVvQUp5hM6bfpwDzgyJEzVvIifUJDHJlhlZj3oa239ql+dDWd1mFTLL0pPBXxn/d9st82UPD3nmt9AlzDl/u3aynDC2Ffl5xwnAo1Qkx8F88AjT10HdDsBazHduzipgw69oP+EdKZTu4FSVoC4pVRd+mhsrnOXXkmvcb3jPG+//I6ZdA1xtwhtnFRGphCSNG0xOiuPeV+2HEK+zekpsheOI6hodzvFb+grxBW1zrxongd+5CKIGY/LfvXbV7pYbqPJs0h9WrCbtMpOdlVbrkkVQWWsWZ5dobz3ILwsiXYVWqn72wLlD1qjJ340uXFdg==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}

"API案例描述": "付款码收款撤销异常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"origOrderId\":\"02101902251711371207X70000000548\",\"merId\":\"3089991701207X71\",\"origCmbOrderId\":\"002119022119102220734312\",\"userId\":\"N003109945\"}",

`    `"encoding": "UTF-8",

`    `"sign": "Vz96Ud3Jr6mWLCN0lY4dVncVb2WWg1XAPgUfDrpY35PU07pV8qq2T/6sRAEpz0fpXJP6qg7gnQ0tvKyV+OVFiDGp9JH85Qg/CoTkRfC95vK8iiobsrBWcAmc0Vx8CNiwe2xuXJo7jl4m/MVhEJAupxFTtDg+afb5GelVOI60/WsTQoCBCYPnf2vz9dvP/suO71vzWAUSfwhJSfv6ZZ+L4qI3/9Ejcgibv+pt9UMQXGDl7lZSrpDzZa/qucGkToMgQ4Ixnfk9GZByT/x8gdq7IOLARo5hJq0PRV/K4dnWS8iQq7WHSIFHJl5eqp61xtliqWHhK6iwPvEdC1E3dUQSFQ==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`    `"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "U4+/PMYMecqlQBF5CULJHa2QZuUnAS4bEujLHBBpQZi2w5Q1JaMW0vcjIn6oaLoXtB030njP50w9mWympcGDEAi6XW0kjZPBSfwUtS9stLRF4TXyPO0mw/H9hd+WbGbBkoOEGnEFSRCJpI0LNRAFczSoZB1dBtfnlSFTEXA49mI2KdZTeH9JOcdwMMpyINR83dJhGFI2zQtGnZ68n3wQ4sKRbuHXmg4qnmIDYHJSc4bXbtHUGKuWMZ6M/NEy3UEhRjnDhIq5zwUGRI/Z4l92s2jdVckNfcuRzpNZ60OCrNZQnspQTgtBzABHH1svVamvbtU3j3Hu/ihwC8wAFbLZdA==",

`    `"respMsg": "商户号不存在",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}

7\.微信统一下单

"API案例描述": "微信统一下单正向报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"orderId\":\"dev201902150018\",\"notifyUrl\":\"http://99.12.99.165:30086/mch/api/notify\",\"merId\":\"30899913301052V\", \"txnAmt\":\"1\",\"body\":\"1\",\"tradeType\":\"JSAPI\",\"spbillCreateIp\":\"117.136.40.178\",\"subAppId\":\"wx2421b1c4370ec43b\",\"subOpenId\":\"wx2421b1c4370ec43b\",\"userId\":\"N111558671\"}",

`    `"encoding": "UTF-8",

`    `"sign": "S1Uw+UKiM5lN+u+exOt2p5mzc5+ADw7e08SaKEgnda3ttZR+g/LFqAq3i9VmlxRMf56iNMG1aSFr0PVVtm7HHycu8+F7bq0uiEE7+gGp+ReuUF9TJKfEviBLjyZkcZten6+IxLIVJU1EqbwNte7v6+nbJo3px1StlAmaMBUa3X9y2QmqTYDHdwiViQJCVPWku6j4njd/FR4gFGvCu7VOUJBHxLZwZtbmtClVHBJ/e23p3U3VwlZ9u/aTq++FAn0TgaBDOa8O5Xh9C3IaB1Wl93PMOulLRU9y3l61+KFNK3tkdxfcn1Y8QxUw9EraCaamVE9+OBEYbphXqWkw+2MyMg==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`	`"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"cmbOrderId\":\"003219021519025220616370\",\"orderId\":\"dev201902150018\",\"txnTime\":\"20190215190252\",\"merId\":\"30899913301052V\",\"payData\":{\"timeStamp\":\"1550229163\",\"packageValue\":\"Sign=WXPay\",\"appId\":\"wx777094fe3db1cfd0\",\"sign\":\"gHL7W6VeniB4W7wlDtR4Z4wbNOEo0mktTcXmLdIfQi2w2Na43UGiPGozhMHKKx762UmrIjHDJJP07UULDm4DPQF02etomeeeWWnRgvfIWX6LUBkO/XTgjN7QhiEuP0p4qU4GPrKSsl921WTvvhGTVx8DAIfncrmBUO2TfS2BQfkC0dLWMLRyweqBImL79JRm8Y5p9Sts23uu5z/mZ301SqoiPuTrHv7qe3xhispgWzkOLRMDpo0w6732t/fnAlohZaWAU1wUfTzC5biL09HZ4nkiWvrUHlLEVGv9JErNI5L5VBAnCrVVazp/eJSeMEa9OvtUz9/ZPU6bPuzUN4+eVQ==\",\"partnerId\":\"1900009211\",\"prepayId\":\"wx15191243056645b7f10e72aa2869289340\",\"nonceStr\":\"faf31972b6ba4ffb87deb72e2f616fc8\"},\"tradeType\":\"JSAPI\"}",

`    `"sign": "FnEHZIV/px0+dIDlON365cfE0Mt/LRgbn5x/CKzeKOJL4Y2kxad9ltc7MRqBLdE+8hDjkL7XYKvKk2dwYvejqPaXnj81G98WvuWLAVH2V2EOWcqjgAp5a2oBImj+eQ9qxEJ33G6KwDWOlpJKc9vZ2H1x2XSUc050Y0sl3SBlC26ihGdUYnfNeBjzvg5FKRdMFpB8oGw4DKgafTx6DlO70ww0TtrOLE32VsTpB23qZv9CfnXpcC+qs4Zd4dw6I7QcJZfPNyGma1arALCnHclMj7auHUZy0Fa/bUc0lRxiEa5DLTjnK2O2O2Y1/yCyWqP1lf/D7fLm6+iJc9cgRD7HlQ==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}

"API案例描述": "微信统一下单异常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"orderId\":\"dev201902150018\",\"notifyUrl\":\"http://99.12.99.165:30086/mch/api/notify\",\"merId\":\"30899913301052V1\", \"txnAmt\":\"1\",\"body\":\"1\",\"tradeType\":\"JSAPI\",\"spbillCreateIp\":\"117.136.40.178\",\"subAppId\":\"wx2421b1c4370ec43b\",\"subOpenId\":\"wx2421b1c4370ec43b\",\"userId\":\"N111558671\"}",

`    `"encoding": "UTF-8",

`    `"sign": "JE91bCkXy/U2kVOjJuvqKb4BOFOX50+FbxK56hB8hg6FSE/8IouL3vLiQS6qQDzpkjdWKXs/oPrrYybuRWLsYj8pa4vM7g/kLf5Al4FowefG2+gAxsEGpbuMTWKEtPa4hQSDk2lp5SkkdX0sIPZquEs9s9ynqTxt6gM0jQye4pJXZJo8IbO++k4HBHELJzLxIBXMlMXQGp5O4hi4y2Qao2NXz/iw0S86Jls1f0Si3p8nfE/gVFAgSxgOMmHlV7Zu21rmnrnXg3zoB5mKqF5zAcK2j+frMvQGcGBAtKq5KzG3N4yhJGHm3hwWhawy/Kem9p3StHP9SC5oZAnebGIZLg==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`    `"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "U4+/PMYMecqlQBF5CULJHa2QZuUnAS4bEujLHBBpQZi2w5Q1JaMW0vcjIn6oaLoXtB030njP50w9mWympcGDEAi6XW0kjZPBSfwUtS9stLRF4TXyPO0mw/H9hd+WbGbBkoOEGnEFSRCJpI0LNRAFczSoZB1dBtfnlSFTEXA49mI2KdZTeH9JOcdwMMpyINR83dJhGFI2zQtGnZ68n3wQ4sKRbuHXmg4qnmIDYHJSc4bXbtHUGKuWMZ6M/NEy3UEhRjnDhIq5zwUGRI/Z4l92s2jdVckNfcuRzpNZ60OCrNZQnspQTgtBzABHH1svVamvbtU3j3Hu/ihwC8wAFbLZdA==",

`    `"respMsg": "商户号不存在",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}

8\.关闭订单

"API案例描述": "关闭订单正向报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"origOrderId\":\"201910201121036\",\"merId\":\"30899913301052V\",\"origCmbOrderId\":\"003119022611221920416540\",\"userId\":\"N000097377\"}",

`    `"encoding": "UTF-8",

`    `"sign": "Yh4Yy0QJhfjaJNMlUC2lGbxXyXaOyOgZCHfmGkY26IlQpH2s4Htz3IMQCeMsusXyVABycmnMxUUXpt2VRHpLHiFQrI3UT8qtGoJgSKioE4INEdgPh7swwMv8LYh73bNCmKp21kOT+OgnPw0ZisoU42xVj5oRIBPJKcTvNU5T4ph9Qy1HbbFKBHSGVip++H9fc4aFO522OCax2AuDwMlE6+/FryjhE6nzxne/pn4HfNERXJhSI1PKvg611dVcQhdpTjcTPmJksH6vft0NbRC13qp2AwFlfwG39BSZAXtHpmvDVJwITJk8O3Bq74WHGSVQu7ZZxZVP6r11FDziKWdULA==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`	`"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"origOrderId\":\"201910201121036\",\"txnTime\":\"20190227175412\",\"merId\":\"30899913301052V\",\"closeState\":\"C\"}",

`    `"sign": "D9wiFZIAjaNTKTVIone4yoM++p8M7JD/9Ha+DNWkNaxIB5oj340KD9uOSduYWzL7Vp+dXeqD6HU88vcHAR3NPTi/7r9gxzAMlzWKbIed/JHL4C8aDZ2Mgi3zoeVyIWOVasij03E5VgSNLK3KQHbjaXRppRfMCep7gBqUE0IsjRWzrHfdfwIZAkZnOekA6cK3NGDIjDhW+D25EMdeVnaVW4k/6Hg+ve4k45cWV+s0lKxdjtIc7O5Ob3ENV44GDLaxFNoMuZUVJwibj/u6NVTs6Ztpo+cN+2tAvZgHb1/puUjt0IJLr4mEzO4wAH0fWvUbFEX4wWhdL3FOITQExYoifA==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}

"API案例描述": "关闭订单异常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"origOrderId\":\"201910201121036\",\"merId\":\"30899913301052V1\",\"origCmbOrderId\":\"003119022611221920416540\",\"userId\":\"N000097377\"}",

`    `"encoding": "UTF-8",

`    `"sign": "KET2obFdrYuZ01LJ6lWY3h7cWE9CmJcPBptcQUs8B7M0bQ1C6kJZq3/+uuwV9h6VLsZ+AQ2+kUtSTLUMeJqjFUZj/mr5f6Ce7UdRGCTim3tFiY1ZYrEYSADCzzM+gquLpgTwC+5/39BOpVQOxrMxGJFg66lPggf/bHksl+Q3Jd4cdXiE3p5v+hfPmCX0a+53nXQ0KzxoPvLKCKtQl9yoOOsk37SZw2Pho5nIQrDoHtAJHCESWgFDsyfU/W6VSVFeiKKgU3LWHHcmRXrH+DUzvaihs1XbjANUSr1+3Rw0zH/dsuNfCBr7I4IGZJgJEg1u4sDdrMHE2F/By1ti2GYU9w==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`    `"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "U4+/PMYMecqlQBF5CULJHa2QZuUnAS4bEujLHBBpQZi2w5Q1JaMW0vcjIn6oaLoXtB030njP50w9mWympcGDEAi6XW0kjZPBSfwUtS9stLRF4TXyPO0mw/H9hd+WbGbBkoOEGnEFSRCJpI0LNRAFczSoZB1dBtfnlSFTEXA49mI2KdZTeH9JOcdwMMpyINR83dJhGFI2zQtGnZ68n3wQ4sKRbuHXmg4qnmIDYHJSc4bXbtHUGKuWMZ6M/NEy3UEhRjnDhIq5zwUGRI/Z4l92s2jdVckNfcuRzpNZ60OCrNZQnspQTgtBzABHH1svVamvbtU3j3Hu/ihwC8wAFbLZdA==",

`    `"respMsg": "商户号不存在",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}

9\.支付宝服务窗支付

`      `"API案例描述": "支付宝服务窗支付报文样例"

`      `"调用方式": "POST"

`      `"请求报文内容": 

{

`    `"biz\_content": "{\"orderId\":\"t201910201121038\",\"notifyUrl\":\"http://99.12.99.165:30086/mch/api/notify\",\"merId\":\"30899913301052V\", \"txnAmt\":\"1\",\"body\":\"1\",\"disablePayChannels\":\"coupon\",\"timeoutExpress\":\"4d\",\"buyerId\":\"2088522115115513\",\"buyerLogonId\":\"114\*\*\*@qq.com\",\"userId\":\"N111558671\"}",

`    `"encoding": "UTF-8",

`    `"sign": "VWThJtd1M714/2c6xmZTnOwKLl5s2QlQ6bcuDzdtgDiM8dpqN21Q5Ceg+8YUCJoEM5wv9SL5PqBVQRcSBTrclmnSutGK+QFomOIwC2GNuDZogZOMreeox+RkxvDb1HZlxn3T1qzKiutV8RI4FT7vmWMjh7jRVoh05uzdBEsk+DZ610J+DAuqXwx2qcZJDDZYiQltLhz2bpQdEhI0YUxfcwIbd1BhIx2/FBWPLLz2XFCNV51In/BSM3wqPRsUwmYjTAG4Y/p7zLiMUYomhfCnVUJQ8ZA3YSoZ1KHi52kYSCoYbF+o+va0IRdkmBheBmCUCrsIPWY086u10fYMCxIK/w==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`      `"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"cmbOrderId\":\"003119022717023531016593\",\"orderId\":\"t201910201121038\",\"txnTime\":\"20190227170235\",\"merId\":\"30899913301052V\",\"payInfo\":\"2019022722001415511018791416\"}",

`    `"sign": "cO0503CTOS8ntPhMBZ/G28mLLxIcCP1+co/OPt/a44N7nFIrwFKXZaeX6Ap5qk9Z3T3l7aQRd5Pv7U9Eoq+xH3KI2+OlFbUZ34iHMZ/tsq7khurZqvy1N0CThr/oNV0CMlhIqHuhsR0kYObEqyZUrbbT77NyByFs0bm/ojHkn+RzKrstldI1IPY+jxyAvLqdWHB+ZeCHEUYvhRnxD7m90rl6yyyUZuI3d1Y3tt2+S61g0bGBKmyUshaCBQd99XsOtikL//7KlXfCbXAywrrtkoWiy2iHe3vZont8t2Bs6X2yj9sewaiGrPRG7Qz9V24TwrhJ4dAiNIkMmopBtBH24w==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}

"API案例描述": "支付宝服务窗支付异常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"orderId\":\"t201910201121038\",\"notifyUrl\":\"http://99.12.99.165:30086/mch/api/notify\",\"merId\":\"30899913301052V1\", \"txnAmt\":\"1\",\"body\":\"1\",\"disablePayChannels\":\"coupon\",\"timeoutExpress\":\"4d\",\"buyerId\":\"2088522115115513\",\"buyerLogonId\":\"114\*\*\*@qq.com\",\"userId\":\"N111558671\"}",

`    `"encoding": "UTF-8",

`    `"sign": "YZgQf88eDSoal0RUitob2DS5RV3fQCoc3UEb/cp93cAYqRphZNfbvKUHGKy6j0RdkG4pOcovdaxyTQd4CfNzMo49Kwkuyuf4KwmCNVrWMHkciaJHZ3MhXb+S73tTyjEbQthuWhWmKO/NK96CEy3DSbZeIfN0CaEMbW2EM64mkqboRN1li59vR71pSAxEg7NthnPqfcCtVmPgOE7d2JcVz65kyJ8BsppvT/5jdx4KpXBRDAlXKlHOU0mzCiP0zXZmyByg3nsizybFObNllAOMqp6dYi9DpOsDMXoAqLcYQ4Fd5dv9dObNHDaJNzCikmXc2UbMaAD5cpWGd5xgfQdwyQ==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

`    `"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "U4+/PMYMecqlQBF5CULJHa2QZuUnAS4bEujLHBBpQZi2w5Q1JaMW0vcjIn6oaLoXtB030njP50w9mWympcGDEAi6XW0kjZPBSfwUtS9stLRF4TXyPO0mw/H9hd+WbGbBkoOEGnEFSRCJpI0LNRAFczSoZB1dBtfnlSFTEXA49mI2KdZTeH9JOcdwMMpyINR83dJhGFI2zQtGnZ68n3wQ4sKRbuHXmg4qnmIDYHJSc4bXbtHUGKuWMZ6M/NEy3UEhRjnDhIq5zwUGRI/Z4l92s2jdVckNfcuRzpNZ60OCrNZQnspQTgtBzABHH1svVamvbtU3j3Hu/ihwC8wAFbLZdA==",

`    `"respMsg": "商户号不存在",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}

10\.支付宝native支付

`   `"API案例描述": "支付宝native正向报文样例"

`      `"调用方式": "POST"

`      `"请求报文内容": 

{

`    `"biz\_content": "{\"orderId\":\"20190423123456826\",\"notifyUrl\":\"http://99.12.99.165:30086/mch/api/notify\",\"merId\":\"30899917012000T\", \"txnAmt\":\"1\",\"body\":\"ggg\",\"disablePayChannels\":\"coupon\",\"timeoutExpress\":\"1d\",\"qrCodeTimeoutExpress\":\"2d\",\"buyerLogonId\":\"114\*\*\*@qq.com\",\"userId\":\"N002852494\"}",

`    `"encoding": "UTF-8",

`    `"sign": "g0oGB+bmiY3nKgJ+L5nRf+otlH8iIpygQ2rYJekpleoGvUhpgAT1iYLaUbAv6trdoK5tPSwaau2osm2Lj27Fk+3WiTFsT59qk+1C2Pzte6mvwPpQAd5ZwyC8Kz+JMgfPSgO87fNsdLUBWk0zuE/kt9mxwX7PGQbtxCEfPWbDcu4NWhL6+WAeTy8O6MkzFvLOylGjUJ8b/TBSjx3RpiR8SznpiiV+FuCDgRY5xlKOiZ4QebSpSTDqjY6oOdokDtX44XG4/AbsEsLWHz4CM8M2I4fmhJQP4epw2CUXj5CXnnSo07ZUYWU2dsUDTo+Dajumc4n3vyrecOy02+ad3BhNiA==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"cmbOrderId\":\"004119052314142410107281\",\"qrCode\":\"https://qr.alipay.com/bax09044lcv1vnvr2h39204e\",\"orderId\":\"20190423123456826\",\"txnTime\":\"20190523141424\",\"merId\":\"30899917012000T\"}",

`    `"sign": "B+Hb5O+Jy5Oi1Vr/yT6fiqztEHPQdVUyUh6a4gA8C3bRQZ7lZ3UBUs03VvYQChULUTGdI0NcF2FE16aY6jaE5obP5v0ZtNncHhFUXRbKVyOC3HYjR72kGX0tjX1vv/VSKZRMAgDzgHvbks7OrKWHUyeU9Xc0diq+bPmR4VBVSuwfNMqe2VHuXDZPe0sNvaEhId7ecZFdXubmL+l1FJEVwOB4s/MH8HqhGIZ9BdlYHQoP9ih6eNFyzzcZF4noQ/uYHxOI/lIwXjbISS9OEti0kCDJaWtKRUS3QYfdoGRjli5Zh3w/Q3TpFcVsqewTnhrpdTwdNpUIw8gVRasYMBMK3Q==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}

`  `"API案例描述": "支付宝native异常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"orderId\":\"20190423123456826\",\"notifyUrl\":\"http://99.12.99.165:30086/mch/api/notify\",\"merId\":\"30899917012000T1\", \"txnAmt\":\"1\",\"body\":\"ggg\",\"disablePayChannels\":\"coupon\",\"timeoutExpress\":\"1d\",\"qrCodeTimeoutExpress\":\"2d\",\"buyerLogonId\":\"114\*\*\*@qq.com\",\"userId\":\"N002852494\"}",

`    `"encoding": "UTF-8",

`    `"sign": "Pq3Kg83kqxkVe193WeGZ2xZVnwytEzBh8Nm+70QOiFZRlRQV/I80x0LRWJXBz49Tv0K7Ih+ZlTSt/e4HT/114eZdDPCK1Ur2TUYpKa/75aubKxi78lxsVU4aHcqLrTKqdutAMhtREeU4ZtXyAiApN79XTncoC/s1qGnrJBUo78UB/cQ2QfRw+d044lAz1CHRdF/Uns1Z1hXk+7SRA1UZao5cTY1NSW5Ihqz907SGvcAcY0s8v8dHSL2rRbOMPN/XXz8lgCSTzuse5noH+PbzZB+1EWMiSBMebdtj+7y7g+YIewFYiXV2T+C3ZGCXiEFI6TgUbteBJR9WeID4w9PBvw==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "hrPh/5gtNwlFOHetCq8IB4L/LisTiKe75UwGAZiZM3flUO+8g2xeh5X1lfP83l9wIcxUwwPf2ReItuSGWVdbVOIuChezBF+y/Ox0rrViNemFRdUtPgHLXtiKdPnqucXUmitQCtUInHHZtnzLBW/R3SjU+GeL09Ksbp8m8ifLr8HctqnYU8r+Gk2igIZKPtV1C79csHnBhvgl23SXvfpDHghhjS8RZsvRUQ7fli4tK/XwsSxcrVtCNPnlxIOc8Oj3huowU5J4tZz1KyuNLwTyJb8HaR72zOwBwVdH5jVXtRem4Mdw4/CzjuuC+/K/YByGw4MHZngyekrMXex1wJAXXw==",

`    `"respMsg": "商户号不存在",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}

11\.微信native支付

"API案例描述": "微信native正向报文样例"

`      `"调用方式": "POST"

`      `"请求报文内容": 

{

`    `"biz\_content": "{\"body\":\"1\",\"merId\":\"30899917012002Z\",\"notifyUrl\":\"http://localhost:8081/polynotify/paynotify\",\"orderId\":\"1557381916745\",\"payValidTime\":\"60000\",\"spbillCreateIp\":\"117.136.40.178\",\"txnAmt\":\"1\",\"userId\":\"N003109940\"}",

`    `"encoding": "UTF-8",

`    `"sign": "Ud7bke3W3D0JwmSsTjZ2uhPQjs+4cc3qva0mfmRJWkGDe11ghF/ht4wcyjbvxVW4hBwUyww3LQ8ftzajlEKzPEhLV3xW4zuR3q4LK6TzBuDbwhpQPbrck6xFCmzthqZMYbtbgGcfNC06s9JEBsvtt15Aah61k22CtHJywMPUMfrUQebtnUbc/s2X7TkWDuxi8e9wpsIpNsZLXuGgXu6qd8lEM/8LPwRl3cOBAtTiaCRtSbOU7fJgYosvR01U/VCELOFs9c6oN8ntFk+QYnHyYH6UA7gzhEDdC54lsvSTB+KOISnYC8++IIPzc4EDjMJqY8C8HJghROmxIGZ6U217Wg==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"cmbOrderId\":\"004219050914075681304245\",\"qrCode\":\"weixin://wxpay/bizpayurl?pr=DnkoQmy\",\"orderId\":\"1557381916745\",\"txnTime\":\"20190509140756\",\"merId\":\"30899917012002Z\"}",

`    `"sign": "VLEVExxuMKyp6qikHLVgK20BHdZDM/xfne4pLYjVrPIzMpn3rCU1u4w13Q/2Tz2Ss0abZ3vvwy8z4LHqmsw87fNgqgztun5M7iR8lbaZPpccK4mzB4wYptpPWQSvS7IUSoEgQJBIt13XXd3tNXGx9MfP/EsHIjVolGQ5QHb3x4jK+fQxd936lwhCZtYitYT9MyHpefVcjzInYCWSzy/Rr99idotmckpLvCLnY7aGpMCA3JCf4zSq5gTzqqSls1LPAd5C+UD6siIPxifKpEmS9yEiuW0Cp5b0rIN1so86NMY+RrL9DNcynEMihoHTLWiUtBiXb1VZ2aEjUt03joeTyw==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}

"API案例描述": "微信native异常报文样例"

`      `"调用方式": "POST"

`      `"请求报文内容": 

{

`    `"biz\_content": "{\"body\":\"1\",\"merId\":\"30899917012002Z1\",\"notifyUrl\":\"http://localhost:8081/polynotify/paynotify\",\"orderId\":\"1557381916745\",\"payValidTime\":\"60000\",\"spbillCreateIp\":\"117.136.40.178\",\"txnAmt\":\"1\",\"userId\":\"N003109940\"}",

`    `"encoding": "UTF-8",

`    `"sign": "iWIpu5j47WOYmIBiWuhD9L58ReECnZtHcWxZbGoRnDVWCf06t+Z6EtFtjkqSmAyQqADz9gLlryo+Jo4LtRlf7bCJEGuCkxxa8IY2VDwlPKNJsIvbZhmfzMaoQdh8bITbJiwRBw6plp0ulOceusUYqaYJEyh/s9uMHwso/HwSM0Eel0gYmomYxs2Mys0DvyMpYIYb56t1RIONPNigoi9Fn6HHXkh/Q6I2FXVxLvasisfbsl4bZ6bssInW1hLbZL0CDM3zAU3STHmdAar6bBxAPuq4Wt3bR08cUCeKvCu+QxQYLuqQTHSJNv/IFLvrdl6eaLc5QJUf90ybkvJTVuq77g==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "hrPh/5gtNwlFOHetCq8IB4L/LisTiKe75UwGAZiZM3flUO+8g2xeh5X1lfP83l9wIcxUwwPf2ReItuSGWVdbVOIuChezBF+y/Ox0rrViNemFRdUtPgHLXtiKdPnqucXUmitQCtUInHHZtnzLBW/R3SjU+GeL09Ksbp8m8ifLr8HctqnYU8r+Gk2igIZKPtV1C79csHnBhvgl23SXvfpDHghhjS8RZsvRUQ7fli4tK/XwsSxcrVtCNPnlxIOc8Oj3huowU5J4tZz1KyuNLwTyJb8HaR72zOwBwVdH5jVXtRem4Mdw4/CzjuuC+/K/YByGw4MHZngyekrMXex1wJAXXw==",

`    `"respMsg": "商户号不存在",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}


12\.支付结果通知

`      `"API案例描述": "支付结果通知报文样例"

`      `"API调用地址": 聚合收单平台主动调起商户端

`      `"调用方式": "POST"

`      `"请求报文内容": 

biz\_content=%7B%22merId%22%3A%22308999150570002%22%2C%22openId%22%3A%22o0xFV4wXFttZiHplNCvq9GGm8lrM%22%2C%22orderId%22%3A%2214233022%22%2C%22cmbOrderId%22%3A%22003219052720175970907079%22%2C%22userId%22%3A%22N002864744%22%2C%22txnAmt%22%3A%221%22%2C%22currencyCode%22%3A%22156%22%2C%22payType%22%3A%22WX%22%2C%22txnTime%22%3A%2220190527201844%22%2C%22endDate%22%3A%2220190527%22%2C%22endTime%22%3A%22201843%22%2C%22dscAmt%22%3A%220%22%7D&sign=MCMCKUgAv%2FIUIL3ceQ3gaFhUHPN4LMb8xBG2zOUaurdpciSFmCnJAD3SpnEaCIGTl3XhKsXaK%2FqWVxaZk5x%2BPt5%2F5BKypqLrmyOiqsq45H8%2FSyOYLE9VKPWL02YztJcFVNNNrOmeLOzcWbxqt7RPhgSanyZ9pXxXIBvqA9Uk91G2NN6TxP5gxcaTKMWAidLxhyYLiEO0XDRZZCDTg%2BkW1WNH2imjpGSlfR%2BhwI0lcMzdH7QRDDyB1jEKrNr%2Fcuy12mC2MMX61pFGzh5GSoO2s%2FS1eoPf9vSdPzrrBqqshDss3yBRWlPLa6GnTw9oxJ%2F7uQVizaur960rW7UOcsOzYg%3D%3D&encoding=UTF-8&version=0.0.1&signMethod=01

`      `"应答报文内容": 

{

`  `"returnCode": "SUCCESS",

`  `"sign": "ihODFCxRA0r8R4NmmejdbXIquv6gPa4LXqWZuzCpjrC8IscrwMfzBohn9u4tHVUUlf6SCdKb5J2LLhGMZhDSyeZv0KFeRBu09fBpKkrCJgqWu7KngCKH/57lE0k0QtjVc+YzY4VxXw3mbBeGDT4lTw/tIE10DrfrjS77zZgKooXCuf/jzEiaxYvhJIkv29KAxci6VrR3ipcaGtKE3Qn5N71uBB2YkHG3uHzrICs9YTptKYORSLCB0plgv1M2z6pL196JFPdAxvVUGE1H8uhU6C5jacdEir0sI1kzNSC8kcxfQdY+BIVwreVDIUQ55GYUjG2V9AfuOsWkOCxfLICayQ==",

`  `"encoding": "UTF-8",

`  `"version": "0.0.1",

`  `"signMethod": "01",

`  `"respCode": "SUCCESS"

}

13\.退款结果通知

`      `"API案例描述": "退款结果通知报文样例"

`      `"API调用地址": 聚合收单平台主动调起商户端

`      `"调用方式": "POST"

`      `"请求报文内容": 

biz\_content=%7B%22merId%22%3A%22308999150570002%22%2C%22openId%22%3A%22o0xFV4wXFttZiHplNCvq9GGm8lrM%22%2C%22orderId%22%3A%2214233022%22%2C%22cmbOrderId%22%3A%22003219052720175970907079%22%2C%22userId%22%3A%22N002864744%22%2C%22txnAmt%22%3A%221%22%2C%22currencyCode%22%3A%22156%22%2C%22payType%22%3A%22WX%22%2C%22txnTime%22%3A%2220190527201844%22%2C%22endDate%22%3A%2220190527%22%2C%22endTime%22%3A%22201843%22%2C%22dscAmt%22%3A%220%22%7D&sign=MCMCKUgAv%2FIUIL3ceQ3gaFhUHPN4LMb8xBG2zOUaurdpciSFmCnJAD3SpnEaCIGTl3XhKsXaK%2FqWVxaZk5x%2BPt5%2F5BKypqLrmyOiqsq45H8%2FSyOYLE9VKPWL02YztJcFVNNNrOmeLOzcWbxqt7RPhgSanyZ9pXxXIBvqA9Uk91G2NN6TxP5gxcaTKMWAidLxhyYLiEO0XDRZZCDTg%2BkW1WNH2imjpGSlfR%2BhwI0lcMzdH7QRDDyB1jEKrNr%2Fcuy12mC2MMX61pFGzh5GSoO2s%2FS1eoPf9vSdPzrrBqqshDss3yBRWlPLa6GnTw9oxJ%2F7uQVizaur960rW7UOcsOzYg%3D%3D&encoding=UTF-8&version=0.0.1&signMethod=01

`      `"应答报文内容": 

{

`  `"returnCode": "SUCCESS",

`  `"sign": "ihODFCxRA0r8R4NmmejdbXIquv6gPa4LXqWZuzCpjrC8IscrwMfzBohn9u4tHVUUlf6SCdKb5J2LLhGMZhDSyeZv0KFeRBu09fBpKkrCJgqWu7KngCKH/57lE0k0QtjVc+YzY4VxXw3mbBeGDT4lTw/tIE10DrfrjS77zZgKooXCuf/jzEiaxYvhJIkv29KAxci6VrR3ipcaGtKE3Qn5N71uBB2YkHG3uHzrICs9YTptKYORSLCB0plgv1M2z6pL196JFPdAxvVUGE1H8uhU6C5jacdEir0sI1kzNSC8kcxfQdY+BIVwreVDIUQ55GYUjG2V9AfuOsWkOCxfLICayQ==",

`  `"encoding": "UTF-8",

`  `"version": "0.0.1",

`  `"signMethod": "01",

`  `"respCode": "SUCCESS"

}

14\.下载对账单

`	  `"API案例描述": "下载对账单正向报文样例"

`      `"调用方式": "POST"

`      `"请求报文内容": 

{    

`	`"biz\_content": "{\"billDate\":\"20180812\",\"merId\":\"100000000000002\"}",    

`	`"encoding": "UTF-8",    

`	`"sign": "b4XADFcDlmWoeCoD/o6ZCuaVGXswChwVusbyzfIlEgPtvuUCzZ119kw3kI7AkXp3onXTBvj29DsTd6q7wXIF8jr3q8sHhETFFdxwQ+FGEKqs5+vo5UbK0FG01UVwr2v2Zf8ztcqHBJpK0jLp44jlhMEmuOEs5LEaQn0qajsMcbik1jMp1vZAyFUhmxnH1X65dq2dmjDIefyIQF7NuNltg5Qef/3EWjACBxg4txDiHPz+tEgTYkxiWPVgxpVTRcfFH2EOGwfloEeX3Js1h53CKUgf2aztS/kOGjcrVl05TijlKmzoHklaradnKRWaTmc1XXu06Za7R7S9HyVRRqlrAg==",    

`	`"signMethod": "01",    

`	`"version": "0.0.1"

}

`      `"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"fileDownloadUrl\":\"http://99.12.88.124/g/L2x1NzRfMTJfa2ZtLjExL1BPTDEwMDAwMDAwMDAwMDAwMjIwMTgwODEy/MUkjE1nEFPmcGwSet7EQGKmmAsU=/lu74\_user2/1534770442\",\"merId\":\"100000000000002\"}",

`    `"sign": "U9gxcrL36ErW8GYW52sNYONECgbjTzOZLvmx+n7OJ+epvuetvql2ehCGfJboZoscIOmeUGhmWVkxyavEm1EQs7KuUQ4cxXJzhu2oV0hB9AZOuEwb/m4JiwH1t4HWxxKihvnu+2nDcgk7x1QQ/MbkeLb65nl0/zkl1+xtA6R8pBzgM2mkt6tM1rn+7YpkssiYAwG72EdtxJ2D0zjbTWT6avIG5ApnWWYPAKarlvZNJyo1mG2Vx1DmB8+m+xZVOhixAP+du2l34x9A8ThPJLe3rV9DDhyIgRVTRybEpSNZpTfSp8XkzY2I5K2pdpa78YOvVBR9npcibMLKIuwg52uyDg==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}

"API案例描述": "下载对账单异常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{    

`	`"biz\_content": "{\"billDate\":\"20180812\",\"merId\":\"1000000\"}",    

`	`"encoding": "UTF-8",    

`	`"sign": "b4XADFcDlmWoeCoD/o6ZCuaVGXswChwVusbyzfIlEgPtvuUCzZ119kw3kI7AkXp3onXTBvj29DsTd6q7wXIF8jr3q8sHhETFFdxwQ+FGEKqs5+vo5UbK0FG01UVwr2v2Zf8ztcqHBJpK0jLp44jlhMEmuOEs5LEaQn0qajsMcbik1jMp1vZAyFUhmxnH1X65dq2dmjDIefyIQF7NuNltg5Qef/3EWjACBxg4txDiHPz+tEgTYkxiWPVgxpVTRcfFH2EOGwfloEeX3Js1h53CKUgf2aztS/kOGjcrVl05TijlKmzoHklaradnKRWaTmc1XXu06Za7R7S9HyVRRqlrAg==",    

`	`"signMethod": "01",    

`	`"version": "0.0.1"

}

`    `"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"sign": "b+f/EggXaZ7vDziL6E91dQ4qLyCitWdayGNzyXHAwuHkVZeJr/cyFtNs4LGDHg+FG2EGekiSmAr8D3vEa3hNoDTlbAk7SXooGEtIFBJ3XyrSEmdd/T9KfQkk25zojEFhJ0WEadKR4xiNPpEqHjEsUy+wwsNzsq7nzvz11Hfh1sXLmFu7RF5LlRytr5vJfCn3a6L41SUvitL+kq3kK8YMBk1PXvP7K2TOgjQ+MzyVM4NbcnMhBEMZDsZBwuGMfqQGCOnHFPue+4N7OBQhD6JzK02H56pfgcLkyp68f2tUcsMDYzxTrH9MSBu2PkciI0n0+H4eRTh49Hk18oYtRxFilA==",

`    `"errorCode": "MERID\_NOT\_EXIST",

`    `"respMsg": "商户号不存在",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}

15\. 订单二维码申请

"API案例描述": "动态二维码正常报文样例"

`    `"调用方式": "POST"

`    `"请求报文内容": 

{

`    `"biz\_content": "{\"termId\":\"\",\"orderId\":\"STtest20200907AAAA1\",\"notifyUrl\":\"http://wlhost1.paas.cmbchina.cn/mch\_notify/api/notify\",\"merId\":\"3089991701205KB\",\"payValidTime\":\"2400\",\"currencyCode\":\"156\",\"userId\":\"N003024104\",\"txnAmt\":\"3\",\"body\":\"\"}",

`    `"encoding": "UTF-8",

`    `"sign": "WjOXKB5MfoE4ZNE4vLcr3lLsBc4ipO1t8Uhkf2/Q3vVa/0Op8nIuqFc7ANjxuYh532Zy+xmdNJ3HaHrvZbFXiDE/JWlSMLlDaStY/gJXWwJWwRgcYk2RcAgOLSIM+IrOcP1Dx90Vb2nUDiQU8s7cqpJYg3468lCdT+PHR4mrRH3f84qzubkC3BOfj3fbgLOslBTpH9vq6o1C9eenexyHxgiYtFa25otnRhDdt1I881rdcHiWa/vYsKEjhILt+8UBeu+OMA5Hmh/Wpxr85idUoFZEUN9i4HciYAUrLFdb2+NUy4Xi7O/VPl+NsX3EBQDXgmk8T0IeuuDvaV10UmZ7Tg==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容": 

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"qrCode\":\"https://qr.95516.com/03080000/1005/100520090710140030803020\",\"orderId\":\"STtest20200907AAAA1\",\"merId\":\"3089991701205KB\"}",

`    `"sign": "ZVYS1dwVomES+qlRfN0FrEcChnJcFyD0TK/D0h0yeH5BcQIDDmoHkpWK65vOqkQDDfnnnPO5WaXfra5OyZ5o0MtAYjSQLe12pZ5aj23n1M5isgUikvQtflcuxTBSKkTGmVXnh+qXYIZ2mvgd3FHlC3jXH7lqBOPDr+STq/qHVV16qKSmJd0T9kYb1EiqWBP0n+cJL9pRoAIsnqVIjr/YqySSYK1tNh2OmLBwuvcxxK54/CJv62LUICFOTBVVZqTdZHy6ruxe9uXTMSvLHEz3JE54NmvaCfranETfDK6HXcSVwtJ7aNLvvCgJfL/iSFuo3QxDu2mBxWLkuPh5Co7HKQ==",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01",

`    `"respCode": "SUCCESS"

}


"API案例描述": "动态二维码异常报文样例"

`    `"调用方式": "POST"

` `"请求报文内容":

{

`    `"biz\_content": "{\"termId\":\"\",\"orderId\":\"STtest20200907AAAA2\",\"notifyUrl\":\"http://wlhost1.paas.cmbchina.cn/mch\_notify/api/notify\",\"merId\":\"3089991701205KC\",\"payValidTime\":\"2400\",\"currencyCode\":\"156\",\"userId\":\"N003024104\",\"txnAmt\":\"3\",\"body\":\"\"}",

`    `"encoding": "UTF-8",

`    `"sign": "PQnMaH6d0t53BEN3tlwOp1hUAjk01QBbGi8wh08WDbjlnY1bVfRJtU5Ib0RsYRFNsYveXrGIYRX6nXAmyrVNcdmJN2AkpxIX2wE4yAGDed5JVOgwhskV60QN2z+MoP5X1XhvcKO4InjEkPXZBhEwdqbbSJIITGAHfped85Ht0DhqIxxVLLfdey82etq/+1sZUHpYSS7vxAOM1URLsRgkK8m1upwMDQifHqSXyQwhugtRUC2h0UE5znPSkgryALh0G7AVjEfU3wtD+EuydWOQw99NbSIeqQWxMxaDXo5tcbsIzGABBiTCQQYmOQsBXxI0Qdas6BSXEng+tMiuTEUFnQ==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "SdmPwWg+unX1Gdm8sWyQ38wmpbNJD/UpfV/jksOHGPqI7Pt8dfZbqObjuaFIOP+aZImvnKcns0et+AzrIqftvxXZT7MAgCUfan5SRAH7ri3usthasaBnC0jEgIqi/TbCuGIb0df8IrM9AwzggDbbDRZfuO+N+RC9qldhCl/FupgFilTrUQ/IPNENNRKo5OzOw6YiGhSAJGyiJ9gd0l/GMFN4wFwAGq7kyaHIv0Qtd/ot37eUueRPXrZkPoXlioFzcwo5LDdYpv1Zff1n62EG1I+vqLGPQTtAPybx2iABaamfJhcer0JXu6azdYiYRRejOe1/9NWX0KNvNNHWzOvymQ==",

`    `"respMsg": "商户号不存在:RQZ7013",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}

16. 微信小程序下单

    "API案例描述": "微信小程序下单正常报文样例"

    `    `"调用方式": "POST"

"请求报文内容": 

{"biz\_content": "{\"orderId\": \"20200925153248346\", \"notifyUrl\": \"http://99.12.99.165:30086/mch/api/notify\", \"merId\": \"3089991152000NH\", \"txnAmt\": \"1\", \"body\": \"auto\", \"tradeType\": \"JSAPI\", \"spbillCreateIp\": \"117.136.40.178\", \"deviceInfo\": null, \"goodsDetail\": null, \"goodsTag\": null, \"userId\": \"N003082458\", \"attach\": null, \"mchReserved\": null, \"payValidTime\": null, \"currencyCode\": null, \"limitPay\": null, \"sceneInfo\": null, \"orderOrigAmt\": null, \"orderCouponAmt\": null}", "encoding": "UTF-8", "signMethod": "01", "version": "0.0.1", "sign": "HsefvLqzADqqYS3LNlBopJIBYcjXj+fGdrv880tKUyjxTBBFOwyYFASXJRsZKFuZwGRZR1OrSFkjgCggdH5xaMXZaODkzwfhMo6qohl96K1x3po4fXobbocY2GF45BgSML7Mztnz4jyZnyyyYuk0fCAP1nCBcdzGN8jWKgl7chhxvSoBX96ZRaEl1PFK3uIoqIAwDpTk0rwB53sTp2aTHtB1zr/ZPl+C7PHYZ4BMB4RVdXQK8gNa4AMqCrG/LVWhoGpskGc2vqV697WFuDs7pF7UdHHzzts744MCDANY4k8WbDgAA/K3RJ50s8cSUtQ0YoVJFPYq/4iHSCL7TqtaqQ=="}

"应答报文内容":

{"cmbOrderId":"003220092515324820419099","orderId":"20200925153248346","encryptedTradeInfo":"jAptHT8M9zycoXLUkwHUqwggeCZakx0Q0sgF1sEZx7K4BVJrMbyVpN7UNxqN1h40TZs6IxYbC787CjphveQ+mFaH3j1L1gxExrSSDupLDCmruZjz3sUr5k0qVqD27634ueDqdlswOhHA471XwKIWPYhoU/lvElmiWYqybDCGpKtWYi7dnItWYmHuSdz/41ijEEZ40meL8alc5E28DIsSlzf1Rf3TutjBv/TgUBj0ExZm2YBCkpyHxLW6YC3Ix2PufM2YxjYflo6px+2hwXeHR6waH7bVj+1PXcRzjUlcuUav++0Um/C8EO+TC4mMerkye5uvRpQTpQRuDkxtHY4+BAVbiEQaZWE6gysjsO2rg1MY5xqDaIiJ29HW8GuJPUIEAswo5budmR/gcR85qqN4ey485N723XZdFlLewWOa+NxSgV3EKfid9+temP/DP8U0ZZm3i68+azgN9nwYh6uNzg==","txnTime":"20200925153248","cmbMiniAppId":"gh\_03660ed15887","merId":"3089991152000NH","tradeType":"JSAPI","encryptedCmbOrderId":"nO6AgbKzffhTiApGvXjrNHAS1uabANQ4kyZQkv+BH/U="}


"API案例描述": "动态二维码异常报文样例"

`    `"调用方式": "POST"

` `"请求报文内容":

{"biz\_content": "{\"orderId\": \"20200925153248347\", \"notifyUrl\": \"http://99.12.99.165:30086/mch/api/notify\", \"merId\": \"3089991152000NI\", \"txnAmt\": \"1\", \"body\": \"auto\", \"tradeType\": \"JSAPI\", \"spbillCreateIp\": \"117.136.40.178\", \"deviceInfo\": null, \"goodsDetail\": null, \"goodsTag\": null, \"userId\": \"N003082458\", \"attach\": null, \"mchReserved\": null, \"payValidTime\": null, \"currencyCode\": null, \"limitPay\": null, \"sceneInfo\": null, \"orderOrigAmt\": null, \"orderCouponAmt\": null}", "encoding": "UTF-8", "signMethod": "01", "version": "0.0.1", "sign": "HsefvLqzADqqYS3LNlBopJIBYcjXj+fGdrv880tKUyjxTBBFOwyYFASXJRsZKFuZwGRZR1OrSFkjgCggdH5xaMXZaODkzwfhMo6qohl96K1x3po4fXobbocY2GF45BgSML7Mztnz4jyZnyyyYuk0fCAP1nCBcdzGN8jWKgl7chhxvSoBX96ZRaEl1PFK3uIoqIAwDpTk0rwB53sTp2aTHtB1zr/ZPl+C7PHYZ4BMB4RVdXQK8gNa4AMqCrG/LVWhoGpskGc2vqV697WFuDs7pF7UdHHzzts744MCDANY4k8WbDgAA/K3RJ50s8cSUtQ0YoVJFPYq/4iHSCL7TqtaqQ=="}

"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "SdmPwWg+unX1Gdm8sWyQ38wmpbNJD/UpfV/jksOHGPqI7Pt8dfZbqObjuaFIOP+aZImvnKcns0et+AzrIqftvxXZT7MAgCUfan5SRAH7ri3usthasaBnC0jEgIqi/TbCuGIb0df8IrM9AwzggDbbDRZfuO+N+RC9qldhCl/FupgFilTrUQ/IPNENNRKo5OzOw6YiGhSAJGyiJ9gd0l/GMFN4wFwAGq7kyaHIv0Qtd/ot37eUueRPXrZkPoXlioFzcwo5LDdYpv1Zff1n62EG1I+vqLGPQTtAPybx2iABaamfJhcer0JXu6azdYiYRRejOe1/9NWX0KNvNNHWzOvymQ==",

`    `"respMsg": "商户号不存在:RQZ7013",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}


16. 银联云闪付

    "API案例描述": "银联云闪付正常报文样例"

    `    `"调用方式": "POST"

"请求报文内容": 

{

`    `"biz\_content": "{\"merId\": \"308999170120FWZ\",\"orderId\": \"20201028163011034A1\", \"tradeScene\": \"ONLINE\", \"userId\": null, \"body\": \"Test\", \"mchReserved\": null, \"notifyUrl\": \"http://99.12.99.165:30040/mch/api/notifyYTH\", \"txnAmt\": \"101\", \"currencyCode\": \"156\", \"frontUrl\": \"http://99.12.99.165:30040/mch/api/notifyYTH\", \"payTimeout\": \"20201230200000\", \"payCardType\": null}",

`    `"encoding": "UTF-8",

`    `"sign": "T4k+Hu1pOVkvuzhZcPrxUtm3QY4n1UlBDN5v4T0P/Z9wZxgK7FBgxL8uAF9KBT5okuMw6zTVjXMbPc5RIzDkD+4L2rFjAcjXFywZmvuIue2sl62mgNUuj5ByXZqOpoLcqExQ17re+i25SyrOQ7zBJYBgptysUN4F0MlJk0n9oZyHmGZXOr/qXN18wMLzbPghRDcjs0iIhZppoYydg6OV9fEIiZKLTd85K7O4xM+MXnc2UHhpNXc00xT19599vixEp+OkEcvcB0apOE3ml1w5XkjxkLUbcjQCQgxqzarvWvSbGt9oAOYW3H5Am4HtQ0nJDgoUlsj+4RdnRumTx0ooAQ==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容":

{

`    `"returnCode": "SUCCESS",

`    `"biz\_content": "{\"cmbOrderId\":\"003320102809331641366158\",\"orderId\":\"20201028163011034A1\",\"txnTime\":\"20201028093316\",\"merId\":\"308999170120FWZ\",\"tn\":\"R6546748120298048\"}",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"respCode": "SUCCESS",

`    `"signMethod": "01",

`    `"sign": "Op/BdgbC9PD5exPpH7W/bogAJsF+0x+NQ1g6OWbLFBlnhwsKggTQyChlKfHA5nQtkkQ06vvQNvVaLKF+v70DtK6v5JFSapGWLW3Eyo77TOzoy7smXb3szjfTI4zUUEWRMlEAY3t5jO4RI4liZ7hM9RakpLD/1OaY5hLtVjXeB6h4dbs6GA41kk/EGVeN15jJfCq4UqCF9nXpZIq31hiy9vRBb0ieYtahDUK2p7em82G1X1JnhqAX5GEOw2jcDWSe8ys0OexD3W6CS0kZgtCf6ooNrUzTDu0ckKFkmF0qy/8HZ+B/0VpyAvdralU7Ib0GdzGH25/lyHznEyW1wzneDg=="

}

"API案例描述": "银联云闪付异常报文样例"

`    `"调用方式": "POST"

` `"请求报文内容":

{

`    `"biz\_content": "{\"merId\": \"308999170120FWZ\",\"orderId\": \"20201028163011034A2\", \"tradeScene\": \"ONLINE\", \"userId\": null, \"body\": \"Test\", \"mchReserved\": null, \"notifyUrl\": \"http://99.12.99.165:30040/mch/api/notifyYTH\", \"txnAmt\": \"101\", \"currencyCode\": \"156\", \"frontUrl\": \"http://99.12.99.165:30040/mch/api/notifyYTH\", \"payTimeout\": \"20201230200000\", \"payCardType\": null}",

`    `"encoding": "UTF-8",

`    `"sign": "XB9yEyLc0SonIcfpQPyLxEptLdS69KcmJVEMlKNJjwCoT8aZZ+ZDkipa6B1sMJMezzLExTCAcALBJPcNfEKFf8B0yujD3cYZW+O7inVjHwxMCnVPMFCowj3NpkqVrz58XltMSirtMKo76uuL/OMD33v1ZCJ9uq1SJJ2z93371RSDZxq/0VAEAn6rlQnV1YgPDWrwqvnKy9emxzIzGYeXvnmwNKdsoIgFo5w84w3m4U5EVQkF2OzJbJWJYH2UA6n2bw4GT7s1zzhmAs+jJpaCekza0q2ab5a+QOD0gJP0ylOwNw2jCVpSRl0xM/o0InGbjDdA0HEsplcrwzTJ1syiug==",

`    `"signMethod": "01",

`    `"version": "0.0.1"

}

"应答报文内容": 

{

`    `"returnCode": "FAIL",

`    `"errCode": "MERID\_NOT\_EXIST",

`    `"sign": "SdmPwWg+unX1Gdm8sWyQ38wmpbNJD/UpfV/jksOHGPqI7Pt8dfZbqObjuaFIOP+aZImvnKcns0et+AzrIqftvxXZT7MAgCUfan5SRAH7ri3usthasaBnC0jEgIqi/TbCuGIb0df8IrM9AwzggDbbDRZfuO+N+RC9qldhCl/FupgFilTrUQ/IPNENNRKo5OzOw6YiGhSAJGyiJ9gd0l/GMFN4wFwAGq7kyaHIv0Qtd/ot37eUueRPXrZkPoXlioFzcwo5LDdYpv1Zff1n62EG1I+vqLGPQTtAPybx2iABaamfJhcer0JXu6azdYiYRRejOe1/9NWX0KNvNNHWzOvymQ==",

`    `"respMsg": "商户号不存在:RQZ7013",

`    `"encoding": "UTF-8",

`    `"version": "0.0.1",

`    `"signMethod": "01"

}


# <a name="_toc3690"></a><a name="_附录3"></a>**附录3 错误码列表**

<table><tr><th colspan="1"><b>场景</b></th><th colspan="1"><b>名称</b></th><th colspan="1"><b>描述</b></th><th colspan="1"><b>原因</b></th><th colspan="1"><b>解决方案</b></th></tr>
<tr><td colspan="1" rowspan="4">平台订单号查询</td><td colspan="1">MERID_NOT_EXIST</td><td colspan="1">商户号不存在</td><td colspan="1">后台系统中不存在此商户号信息</td><td colspan="1">请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">MERID_NOT_LAWFUL</td><td colspan="1">商户号字段内容非法</td><td colspan="1">商户号字段为空或长度超长</td><td colspan="1">此API调用时商户号必传，且内容不得超过32个字符，请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">ORDERID_NOT_EXIST</td><td colspan="1">商户订单号不存在</td><td colspan="1">后台系统中不存在此商户订单号</td><td colspan="1">此API仅支持按商户订单号的信息查询，请商户检查需要查询的商户订单号是否正确</td></tr>
<tr><td colspan="1">ORDERID_NOT_LAWFUL</td><td colspan="1">商户订单号字段内容非法</td><td colspan="1">商户订单号字段为空或长度超长</td><td colspan="1">此API调用时商户订单号必传，且内容不得超过32个字符，请商户检查需要查询的商户订单号是否正确</td></tr>
<tr><td colspan="1" rowspan="27">微信统一下单</td><td colspan="1">USERID_NOT_EXIST</td><td colspan="1">收银员信息不存在</td><td colspan="1">后台系统中不存在此收银员信息</td><td colspan="1">请商户检查上送的收银员是否正确</td></tr>
<tr><td colspan="1">USERID_CHECK_FAILED</td><td colspan="1">收银员信息校验失败</td><td colspan="1">收银员信息和商户信息不匹配</td><td colspan="1">请商户检查上送的收银员或商户号是否正确</td></tr>
<tr><td colspan="1">SUBAPPID_NOT_LAWFUL</td><td colspan="1">子公众账号字段内容为空或非法</td><td colspan="1">子公众账号字段长度超长或者需要填写的情况没有填写</td><td colspan="1">请检查上送的子公众账号长度，长度不超过32</td></tr>
<tr><td colspan="1">TRADETYPE_NOT_LAWFUL</td><td colspan="1">交易类型字段内容为空或非法</td><td colspan="1">交易类型字段超长或者需要填写的情况没有填写</td><td colspan="1">请检查是否上送了交易类型，且长度不应超过16</td></tr>
<tr><td colspan="1">DEVICEINFO_NOT_LAWFUL</td><td colspan="1">设备号字段内容非法</td><td colspan="1">设备号字段长度超长</td><td colspan="1">请检查上送的设备号长度，长度不超过32</td></tr>
<tr><td colspan="1">GOODESDETAIL_NOT_LAWFUL</td><td colspan="1">商品详情字段内容非法</td><td colspan="1">商品详情长度超长</td><td colspan="1">请检查上送的长度是否超过6000</td></tr>
<tr><td colspan="1">GOODESTAG_NOT_LAWFUL</td><td colspan="1">商品标记字段内容非法</td><td colspan="1">商品标记字段长度超长</td><td colspan="1">请检查上送的长度是否超过32</td></tr>
<tr><td colspan="1">ATTACH_NOT_LAWFUL</td><td colspan="1">附加数据字段内容非法</td><td colspan="1">附加内容字段长度超长</td><td colspan="1">请检查上送的长度是否超过127</td></tr>
<tr><td colspan="1">SPBILLCREATEIP_NOT_LAWFUL</td><td colspan="1">终端IP内容为空或不是IPV4格式</td><td colspan="1">终端IP字段内容为空或者不是IPV4格式的</td><td colspan="1">请检查上送的IP格式是否正确</td></tr>
<tr><td colspan="1">OPENID_NOT_LAWFUL</td><td colspan="1">用户标识字段内容非法</td><td colspan="1">用户标识字段长度超长</td><td colspan="1">请检查上送的长度是否超过128</td></tr>
<tr><td colspan="1">LIMITPAY_NOT_LAWFUL</td><td colspan="1">限定支付方式字段内容非法</td><td colspan="1">限定支付方式字段长度超长</td><td colspan="1">请检查上送的长度是否超过32</td></tr>
<tr><td colspan="1">SUBOPENID_NOT_LAWFUL</td><td colspan="1">用户子标识为空或字段内容非法</td><td colspan="1">用户子标识字段长度超长</td><td colspan="1">请检查上送的长度是否超过128</td></tr>
<tr><td colspan="1">SCENEINFO_NOT_LAWFUL</td><td colspan="1">场景信息为空或字段内容非JSON格式或者长度超长</td><td colspan="1">场景信息字段内容为空或者长度超长或者非JSON格式</td><td colspan="1">请检查上送的场景信息字段的内容、长度、格式</td></tr>
<tr><td colspan="1">MERID_NOT_EXIST</td><td colspan="1">商户号不存在</td><td colspan="1">后台系统中不存在此商户号信息</td><td colspan="1">请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">MERID_NOT_LAWFUL</td><td colspan="1">商户号字段内容非法</td><td colspan="1">商户号字段为空或长度超长</td><td colspan="1">此API调用时商户号必传，且内容不得超过32个字符，请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">ORDERID_DUPLICATION</td><td colspan="1">商户订单号重复</td><td colspan="1">商户订单不允许重复</td><td colspan="1">同一商户下的收款码申请、退款申请和付款码支付的商户订单号要求唯一，请商户检查上送的商户订单号是否已使用过</td></tr>
<tr><td colspan="1">ORDERID_NOT_LAWFUL</td><td colspan="1">商户订单号字段内容非法</td><td colspan="1">商户订单号字段为空或长度超长</td><td colspan="1">此API调用时商户订单号必传，且内容不得超过32个字符，请商户检查商户订单号是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_LAWFUL</td><td colspan="1">收银员字段内容非法</td><td colspan="1">收银员字段长度超长</td><td colspan="1">收银员内容不得超过32个字符，请商户检查收银员是否正确</td></tr>
<tr><td colspan="1">PAYVALIDTIME_NOT_LAWFUL</td><td colspan="1">支付有效时间字段内容非法</td><td colspan="1">支付有效时间字段长度超长或含有非数字字符</td><td colspan="1">支付有效时间若上送空，则默认为1200秒，若上送，则需上送长度为10以内的数字字符串，请商户检查支付有效时间字段是否正确</td></tr>
<tr><td colspan="1">NOTIFYURL_NOT_LAWFUL</td><td colspan="1">通知地址字段内容非法</td><td colspan="1">通知地址字段为空或长度超长</td><td colspan="1">此API调用时通知地址必传，且内容不得超过256个字符，请商户检查通知地址是否正确</td></tr>
<tr><td colspan="1">TXNAMT_NOT_LAWFUL</td><td colspan="1">交易金额字段内容非法</td><td colspan="1">交易金额字段为空或金额不合法</td><td colspan="1">此API调用时交易金额为必传，且内容不得超过13个数字字符，单位为分，请商户检查交易金额是否正确</td></tr>
<tr><td colspan="1">AMT_MISMATCHED_ORDER</td><td colspan="1">金额和订单信息不符</td><td colspan="1">上送的金额和订单信息中的金额不一致</td><td colspan="1">请检查新上送的金额和原订单的金额是否一致</td></tr>
<tr><td colspan="1">ORDER_PAID</td><td colspan="1">订单已支付</td><td colspan="1">该笔商户订单已支付</td><td colspan="1">请确认是否使用了重复订单号进行下单支付</td></tr>
<tr><td colspan="1">ORDERID_INVALID</td><td colspan="1">订单号已失效</td><td colspan="1">该笔商户订单已失效</td><td colspan="1">请确认订单是否已失效或已关闭</td></tr>
<tr><td colspan="1" valign="top">TRADEAMOUNT_LIMITED</td><td colspan="1" valign="top">交易金额大于商户单笔限额</td><td colspan="1" valign="top">本次上送交易金额大于商户单笔限额</td><td colspan="1" valign="top">减小交易金额</td></tr>
<tr><td colspan="1" valign="top">MCH_DAILY_QUOTA_EXCEED</td><td colspan="1" valign="top">商户支付日限额超限</td><td colspan="1" valign="top">商户支付日限额超限</td><td colspan="1" valign="top">如要修改商户支付日限额，请联系银行客服人员</td></tr>
<tr><td colspan="1">CURRENCYCODE_NOT_LAWFUL</td><td colspan="1">币种字段内容非法</td><td colspan="1">币种非156</td><td colspan="1">币种若不送，则默认为156，若上送，则必须填充156，请商户检查币种字段是否正确</td></tr>
<tr><td colspan="1" rowspan="15">收款码申请</td><td colspan="1">USERID_NOT_EXIST</td><td colspan="1">收银员信息不存在</td><td colspan="1">后台系统中不存在此收银员信息</td><td colspan="1">请商户检查上送的收银员是否正确</td></tr>
<tr><td colspan="1">USERID_CHECK_FAILED</td><td colspan="1">收银员信息校验失败</td><td colspan="1">收银员信息和商户信息不匹配</td><td colspan="1">请商户检查上送的收银员或商户号是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_LAWFUL</td><td colspan="1">收银员字段内容非法</td><td colspan="1">收银员字段长度超长</td><td colspan="1">请商户检查上送的收银员字段是否超长</td></tr>
<tr><td colspan="1">MERID_NOT_EXIST</td><td colspan="1">商户号不存在</td><td colspan="1">后台系统中不存在此商户号信息</td><td colspan="1">请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">MERID_NOT_LAWFUL</td><td colspan="1">商户号字段内容非法</td><td colspan="1">商户号字段为空或长度超长</td><td colspan="1">此API调用时商户号必传，且内容不得超过32个字符，请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">ORDERID_DUPLICATION</td><td colspan="1">商户订单号重复</td><td colspan="1">商户订单不允许重复</td><td colspan="1">同一商户下的收款码申请、退款申请和付款码支付的商户订单号要求唯一，请商户检查上送的商户订单号是否已使用过</td></tr>
<tr><td colspan="1">ORDERID_NOT_LAWFUL</td><td colspan="1">商户订单号字段内容非法</td><td colspan="1">商户订单号字段为空或长度超长</td><td colspan="1">此API调用时商户订单号必传，且内容不得超过32个字符，请商户检查商户订单号是否正确</td></tr>
<tr><td colspan="1">STOREID_NOT_LAWFUL</td><td colspan="1">门店号字段内容非法</td><td colspan="1">门店号字段长度超长</td><td colspan="1">门店号内容不得超过32个字符，请商户检查门店号是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_LAWFUL</td><td colspan="1">收银员字段内容非法</td><td colspan="1">收银员字段长度超长</td><td colspan="1">收银员内容不得超过32个字符，请商户检查收银员是否正确</td></tr>
<tr><td colspan="1">TERMID_NOT_LAWFUL</td><td colspan="1">终端号字段内容非法</td><td colspan="1">终端号字段长度超长</td><td colspan="1">终端号内容不得超过8个字符，请商户检查终端号是否正确</td></tr>
<tr><td colspan="1">PAYVALIDTIME_NOT_LAWFUL</td><td colspan="1">支付有效时间字段内容非法</td><td colspan="1">支付有效时间字段长度超长或含有非数字字符</td><td colspan="1">支付有效时间若上送空，则默认为1200秒，若上送，则需上送长度为10以内的数字字符串，请商户检查支付有效时间字段是否正确</td></tr>
<tr><td colspan="1">NOTIFYURL_NOT_LAWFUL</td><td colspan="1">通知地址字段内容非法</td><td colspan="1">通知地址字段为空或长度超长</td><td colspan="1">此API调用时通知地址必传，且内容不得超过256个字符，请商户检查通知地址是否正确</td></tr>
<tr><td colspan="1">TXNAMT_NOT_LAWFUL</td><td colspan="1">交易金额字段内容非法</td><td colspan="1">交易金额字段为空或金额不合法</td><td colspan="1">此API调用时交易金额为必传，且内容不得超过13个数字字符，单位为分，请商户检查交易金额是否正确</td></tr>
<tr><td colspan="1">CURRENCYCODE_NOT_LAWFUL</td><td colspan="1">币种字段内容非法</td><td colspan="1">币种非156</td><td colspan="1">币种若不送，则默认为156，若上送，则必须填充156，请商户检查币种字段是否正确</td></tr>
<tr><td colspan="1">BODY_NOT_LAWFUL</td><td colspan="1">商品描述字段内容非法</td><td colspan="1">商品描述字段长度超长</td><td colspan="1">商品描述内容不得超过128个字符，请商户检查商品描述字段是否正确</td></tr>
<tr><td colspan="1" rowspan="11">支付结果查询</td><td colspan="1">USERID_NOT_EXIST</td><td colspan="1">收银员信息不存在</td><td colspan="1">后台系统中不存在此收银员信息</td><td colspan="1">请商户检查上送的收银员是否正确</td></tr>
<tr><td colspan="1">USERID_CHECK_FAILED</td><td colspan="1">收银员信息校验失败</td><td colspan="1">收银员信息和商户信息不匹配</td><td colspan="1">请商户检查上送的收银员或商户号是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_LAWFUL</td><td colspan="1">收银员字段内容非法</td><td colspan="1">收银员字段超长</td><td colspan="1">请检查上送的收银员字段是否超长</td></tr>
<tr><td colspan="1">MERID_MISMATCHED_ORDER</td><td colspan="1">商户号与订单信息不符</td><td colspan="1">上送的商户号与订单信息不符</td><td colspan="1">请检查上送的商户号和订单是否匹配</td></tr>
<tr><td colspan="1">MERID_NOT_EXIST</td><td colspan="1">商户号不存在</td><td colspan="1">后台系统中不存在此商户号信息</td><td colspan="1">请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">MERID_NOT_LAWFUL</td><td colspan="1">商户号字段内容非法</td><td colspan="1">商户号字段为空或长度超长</td><td colspan="1">此API调用时商户号必传，且内容不得超过32个字符，请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">ORDERID_NOT_LAWFUL</td><td colspan="1">商户订单号字段内容非法</td><td colspan="1">商户号字段长度超长</td><td colspan="1">此API调用时内容不得超过32个字符，请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">ORDERID_INVALID</td><td colspan="1">订单号已失效</td><td colspan="1">订单已超时</td><td colspan="1">请检查时间是否超过默认有效时长或上送有效时长</td></tr>
<tr><td colspan="1">CMBORDERID_NOT_EXIST</td><td colspan="1">平台订单号不存在</td><td colspan="1">后台系统中不存在此平台订单号的支付交易</td><td colspan="1">此API仅支持按商户号和平台订单号的信息查询，请商户检查需要查询的平台订单号是否正确</td></tr>
<tr><td colspan="1">CMBORDERID_NOT_LAWFUL</td><td colspan="1">平台订单号字段内容非法</td><td colspan="1">平台订单号字段为空或长度超长</td><td colspan="1">此API调用时平台订单号必传，且内容不得超过32个字符，请商户检查需要查询的平台订单号是否正确</td></tr>
<tr><td colspan="1">UNPAIED_ORDER</td><td colspan="1">订单未支付</td><td colspan="1">该笔订单尚未支付</td><td colspan="1">只能查询已做交易的订单</td></tr>
<tr><td colspan="1" rowspan="26">退款申请</td><td colspan="1">MERID_NOT_EXIST</td><td colspan="1">商户号不存在</td><td colspan="1">后台系统中不存在此商户号信息</td><td colspan="1">请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">USERID_CHECK_FAILED</td><td colspan="1">收银员信息校验失败</td><td colspan="1">收银员信息和商户信息不匹配</td><td colspan="1">请商户检查上送的收银员或商户号是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_EXIST</td><td colspan="1">收银员信息不存在</td><td colspan="1">后台系统中不存在此收银员信息</td><td colspan="1">请商户检查上送的收银员是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_LAWFUL</td><td colspan="1">收银员字段内容非法</td><td colspan="1">收银员字段长度超长</td><td colspan="1">请上送正确的收银员信息</td></tr>
<tr><td colspan="1">MERID_NOT_LAWFUL</td><td colspan="1">商户号字段内容非法</td><td colspan="1">商户号字段为空或长度超长</td><td colspan="1">此API调用时商户号必传，且内容不得超过32个字符，请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">ORDERID_DUPLICATION</td><td colspan="1">商户订单号重复</td><td colspan="1">商户订单不允许重复</td><td colspan="1">同一商户下的收款码申请、退款申请和付款码支付的商户订单号要求唯一，请商户检查上送的商户订单号是否已使用过</td></tr>
<tr><td colspan="1">MERID_MISMATCHED_ORDER</td><td colspan="1">商户号与订单信息不符</td><td colspan="1">上送的商户号与订单信息不符</td><td colspan="1">请检查上送的商户号和订单是否匹配</td></tr>
<tr><td colspan="1">ORDERID_NOT_LAWFUL</td><td colspan="1">商户订单号字段内容非法</td><td colspan="1">商户订单号字段为空或长度超长</td><td colspan="1">此API调用时商户订单号必传，且内容不得超过32个字符，请商户检查商户订单号是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_LAWFUL</td><td colspan="1">收银员字段内容非法</td><td colspan="1">收银员字段长度超长</td><td colspan="1">收银员内容不得超过32个字符，请商户检查收银员是否正确</td></tr>
<tr><td colspan="1">ORIGORDERID_NOT_LAWFUL</td><td colspan="1">原交易商户订单号字段内容非法</td><td colspan="1">原交易商户订单号字段为空或长度超长</td><td colspan="1">原交易商户订单号内容不得超过32个字符，请商户检查上送的商户订单号是否正确</td></tr>
<tr><td colspan="1">ORDERID_INVALID</td><td colspan="1">订单号已失效</td><td colspan="1">订单已超时</td><td colspan="1">请检查时间是否超过默认有效时长或上送有效时长</td></tr>
<tr><td colspan="1">OCMBORDERID_NOT_EXIST</td><td colspan="1">平台订单号不存在</td><td colspan="1">后台系统中不存在此平台订单号的支付交易信息</td><td colspan="1">请商户检查上送的原交易平台订单号是否正确</td></tr>
<tr><td colspan="1">ORIGCMBORDERID_NOT_LAWFUL</td><td colspan="1">平台订单号字段内容非法</td><td colspan="1">原交易平台订单号字段为空或长度超长</td><td colspan="1">此API调用时原交易平台订单号必传，且内容不得超过32个字符，请商户检查上送的原交易平台订单号是否正确</td></tr>
<tr><td colspan="1">NOTIFYURL_NOT_LAWFUL</td><td colspan="1">通知地址字段内容非法</td><td colspan="1">通知地址字段长度超长</td><td colspan="1">通知地址内容不得超过256个字符，请商户检查通知地址是否正确</td></tr>
<tr><td colspan="1">TXNAMT_ERROR</td><td colspan="1">原交易金额不符</td><td colspan="1">商户上送的原交易金额与后台不一致</td><td colspan="1">请检查原交易金额</td></tr>
<tr><td colspan="1">TXNAMT_NOT_LAWFUL</td><td colspan="1">交易金额字段内容非法</td><td colspan="1">交易金额字段为空或金额不合法</td><td colspan="1">此API调用时交易金额为必传，且内容不得超过13个数字字符，单位为分，请商户检查交易金额是否正确</td></tr>
<tr><td colspan="1">REFUNDAMT_NOT_LAWFUL</td><td colspan="1">退款交易金额字段内容非法</td><td colspan="1">退款金额字段为空或金额不合法</td><td colspan="1">此API调用时退款交易金额为必传，且内容不得超过13个数字字符，单位为分，请商户检查退款金额是否正确</td></tr>
<tr><td colspan="1">REFUNDAMT_ERROR</td><td colspan="1">退款金额与原交易金额不等</td><td colspan="1">仅支持全额退款</td><td colspan="1">目前仅支持全额退款，请商户检查退款金额是否与原交易金额相等</td></tr>
<tr><td colspan="1">NOT_ENOUGH</td><td colspan="1">余额不足</td><td colspan="1">订单可用退款余额不足</td><td colspan="1">请商户检查退款金额是否大于此订单可退金额。</td></tr>
<tr><td colspan="1">TRADESTATE_NOT_LAWFUL </td><td colspan="1">原交易状态非法</td><td colspan="1">原交易状态不允许退款</td><td colspan="1">失败交易、已撤销交易等不允许商户再发起退款申请，请商户检查原交易状态。</td></tr>
<tr><td colspan="1">TRADE_OVERDUE</td><td colspan="1">订单已经超过退款期限</td><td colspan="1">订单已经超过可退款的最大期限</td><td colspan="1">请选择其他方式自行退款</td></tr>
<tr><td colspan="1">CURRENCYCODE_NOT_LAWFUL</td><td colspan="1">币种字段内容非法</td><td colspan="1">币种非156</td><td colspan="1">币种若不送，则默认为156，若上送，则必须填充156，请商户检查币种字段是否正确</td></tr>
<tr><td colspan="1">REFUNDREASON_NOT_LAWFUL</td><td colspan="1">退款原因内容非法</td><td colspan="1">退款原因长度超长</td><td colspan="1">退款原因内容不得超过256个字符，请商户检查退款原因是否正确</td></tr>
<tr><td colspan="1">UNPAIED_ORDER</td><td colspan="1">订单未支付</td><td colspan="1">该笔订单尚未支付</td><td colspan="1">只能查询已做交易的订单</td></tr>
<tr><td colspan="1">MCH_EXSRFN_AMOUNT_LESS</td><td colspan="1">商户超额退款剩余可用额度不足</td><td colspan="1">当日收款金额小于退款金额且钱包额度不足</td><td colspan="1">稍后收款后再发起退款或充值钱包</td></tr>
<tr><td colspan="1">PYETYPE_NOT_LAWFUL</td><td colspan="1">支付方式字段内容非法</td><td colspan="1">原交易支付方式字段为空或内容不正确</td><td colspan="1">此API调用时支付方式必传，且目前仅支持ZF、WX和YL三个取值，请商户检查支付方式是否正确</td></tr>
<tr><td colspan="1" rowspan="10">退款结果查询</td><td colspan="1">USERID_CHECK_FAILED</td><td colspan="1">收银员信息校验失败</td><td colspan="1">收银员信息和商户信息不匹配</td><td colspan="1">请商户检查上送的收银员或商户号是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_EXIST</td><td colspan="1">收银员信息不存在</td><td colspan="1">后台系统中不存在此收银员信息</td><td colspan="1">请商户检查上送的收银员是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_LAWFUL</td><td colspan="1">收银员字段内容非法</td><td colspan="1">收银员字段长度超长</td><td colspan="1">请上送正确的收银员信息</td></tr>
<tr><td colspan="1">MERID_NOT_EXIST</td><td colspan="1">商户号不存在</td><td colspan="1">后台系统中不存在此商户号信息</td><td colspan="1">请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">MERID_NOT_LAWFUL</td><td colspan="1">商户号字段内容非法</td><td colspan="1">商户号字段长度超长</td><td colspan="1">此API调用时内容不得超过32个字符，请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">MERID_MISMATCHED_ORDER</td><td colspan="1">商户号与订单信息不符</td><td colspan="1">上送的商户号与订单信息不符</td><td colspan="1">请检查上送的商户号和订单是否匹配</td></tr>
<tr><td colspan="1">ORDERID_NOT_LAWFUL</td><td colspan="1">商户订单号字段内容非法</td><td colspan="1">商户订单号字段为空或长度超长</td><td colspan="1">商户订单号内容不得超过32个字符，请商户检查商户订单号是否正确</td></tr>
<tr><td colspan="1">CMBORDERID_NOT_EXIST</td><td colspan="1">平台订单号不存在</td><td colspan="1">后台系统中不存在此平台订单号的退款交易</td><td colspan="1">此API仅支持按商户号和平台订单号的信息查询退款交易，请商户检查需要查询的退款交易平台订单号是否正确</td></tr>
<tr><td colspan="1">ORIGCMBORDERID_NOT_LAWFUL</td><td colspan="1">平台订单号字段内容非法</td><td colspan="1">平台订单号字段为空或长度超长</td><td colspan="1">此API调用时平台订单号必传，且内容不得超过32个字符，请商户检查需要查询的平台订单号是否正确</td></tr>
<tr><td colspan="1">PYETYPE_NOT_LAWFUL</td><td colspan="1">支付方式字段内容非法</td><td colspan="1">支付方式字段为空或内容不正确</td><td colspan="1">此API调用时支付方式必传，且目前仅支持ZF、WX和YL三个取值，请商户检查支付方式是否正确</td></tr>
<tr><td colspan="1" rowspan="14">付款码支付</td><td colspan="1">USERID_CHECK_FAILED</td><td colspan="1">收银员信息校验失败</td><td colspan="1">收银员信息和商户信息不匹配</td><td colspan="1">请商户检查上送的收银员或商户号是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_EXIST</td><td colspan="1">收银员信息不存在</td><td colspan="1">后台系统中不存在此收银员信息</td><td colspan="1">请商户检查上送的收银员是否正确</td></tr>
<tr><td colspan="1">MERID_NOT_EXIST</td><td colspan="1">商户号不存在</td><td colspan="1">后台系统中不存在此商户号信息</td><td colspan="1">请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">MERID_NOT_LAWFUL</td><td colspan="1">商户号字段内容非法</td><td colspan="1">商户号字段长度超长</td><td colspan="1">此API调用时内容不得超过32个字符，请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">ORDERID_DUPLICATION</td><td colspan="1">商户订单号重复</td><td colspan="1">商户订单不允许重复</td><td colspan="1">同一商户下的收款码申请、退款申请和付款码支付的商户订单号要求唯一，请商户检查上送的商户订单号是否已使用过</td></tr>
<tr><td colspan="1">ORDERID_NOT_LAWFUL</td><td colspan="1">商户订单号字段内容非法</td><td colspan="1">商户订单号字段为空或长度超长</td><td colspan="1">此API调用时商户订单号必传，且内容不得超过32个字符，请商户检查商户订单号是否正确</td></tr>
<tr><td colspan="1">STOREID_NOT_LAWFUL</td><td colspan="1">门店号字段内容非法</td><td colspan="1">门店号字段长度超长</td><td colspan="1">门店号内容不得超过32个字符，请商户检查门店号是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_LAWFUL</td><td colspan="1">收银员字段内容非法</td><td colspan="1">收银员字段长度超长</td><td colspan="1">收银员内容不得超过32个字符，请商户检查收银员是否正确</td></tr>
<tr><td colspan="1">TERMID_NOT_LAWFUL</td><td colspan="1">终端号字段内容非法</td><td colspan="1">终端号字段长度超长</td><td colspan="1">终端号内容不得超过8个字符，请商户检查终端号是否正确</td></tr>
<tr><td colspan="1">AUTHCODE_NOT_LAWFUL</td><td colspan="1">授权码为空或字段内容非法</td><td colspan="1">授权码字段为空或长度超长</td><td colspan="1">此API调用时授权码必传，内容不得超过128个字符，且只支持支付宝、微信和银行APP生成的付款码，请商户检查授权码是否正确</td></tr>
<tr><td colspan="1">NOTIFYURL_NOT_LAWFUL</td><td colspan="1">通知地址字段内容非法</td><td colspan="1">通知地址字段为空或长度超长</td><td colspan="1">此API调用时通知地址必传，且内容不得超过256个字符，请商户检查通知地址是否正确</td></tr>
<tr><td colspan="1">TXNAMT_NOT_LAWFUL</td><td colspan="1">交易金额字段内容非法</td><td colspan="1">交易金额字段为空或金额不合法</td><td colspan="1">此API调用时交易金额为必传，且内容不得超过13个数字字符，单位为分，请商户检查交易金额是否正确</td></tr>
<tr><td colspan="1">CURRENCYCODE_NOT_LAWFUL</td><td colspan="1">币种字段内容非法</td><td colspan="1">币种非156</td><td colspan="1">币种若不送，则默认为156，若上送，则必须填充156，请商户检查币种字段是否正确</td></tr>
<tr><td colspan="1">BODY_NOT_LAWFUL</td><td colspan="1">商品描述字段内容非法</td><td colspan="1">商品描述字段长度超长</td><td colspan="1">商品描述内容不得超过128个字符，请商户检查商品描述字段是否正确</td></tr>
<tr><td colspan="1" rowspan="12">付款码支付撤销</td><td colspan="1">USERID_CHECK_FAILED</td><td colspan="1">收银员信息校验失败</td><td colspan="1">收银员信息和商户信息不匹配</td><td colspan="1">请商户检查上送的收银员或商户号是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_EXIST</td><td colspan="1">收银员信息不存在</td><td colspan="1">后台系统中不存在此收银员信息</td><td colspan="1">请商户检查上送的收银员是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_LAWFUL</td><td colspan="1">收银员字段内容非法</td><td colspan="1">收银员字段长度超长</td><td colspan="1">请上送正确的收银员信息</td></tr>
<tr><td colspan="1">MERID_NOT_EXIST</td><td colspan="1">商户号不存在</td><td colspan="1">后台系统中不存在此商户号信息</td><td colspan="1">请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">MERID_NOT_LAWFUL</td><td colspan="1">商户号字段内容非法</td><td colspan="1">商户号字段长度超长</td><td colspan="1">此API调用时内容不得超过32个字符，请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">ORIGORDERID_NOT_LAWFUL</td><td colspan="1">商户订单号字段内容非法</td><td colspan="1">原交易商户订单号字段为空或长度超长</td><td colspan="1">原交易商户订单号内容不得超过32个字符，请商户检查原交易商户订单号是否正确</td></tr>
<tr><td colspan="1">MERID_MISMATCHED_ORDER</td><td colspan="1">商户号与订单信息不符</td><td colspan="1">上送的商户号与订单信息不符</td><td colspan="1">请检查上送的商户号和订单是否匹配</td></tr>
<tr><td colspan="1">CMBORDERID_NOT_EXIST</td><td colspan="1">平台订单号不存在</td><td colspan="1">后台系统中不存在此平台订单号的支付交易</td><td colspan="1">此API仅支持按商户号和平台订单号的信息查询，请商户检查需要撤销的平台订单号是否正确</td></tr>
<tr><td colspan="1">NOT_ALLOWED</td><td colspan="1">暂不支持</td><td colspan="1">主扫交易暂不支持撤销</td><td colspan="1">主扫交易暂不支持撤销</td></tr>
<tr><td colspan="1">ORIGCMBORDERID_NOT_LAWFUL</td><td colspan="1">平台订单号字段内容非法</td><td colspan="1">平台订单号字段为空或长度超长</td><td colspan="1">此API调用时原交易平台订单号必传，且内容不得超过32个字符，请商户检查需要查询的原交易平台订单号是否正确</td></tr>
<tr><td colspan="1">UNPAIED_ORDER</td><td colspan="1">订单未支付</td><td colspan="1">该笔订单尚未支付</td><td colspan="1">只能查询已做交易的订单</td></tr>
<tr><td colspan="1">TRADESTATE_NOT_LAWFUL</td><td colspan="1">原交易状态非法</td><td colspan="1">原交易状态不允许撤销</td><td colspan="1">已退款的订单不允许再撤销，请商户检查原交易状态</td></tr>
<tr><td colspan="1" rowspan="12">关闭订单</td><td colspan="1">USERID_CHECK_FAILED</td><td colspan="1">收银员信息校验失败</td><td colspan="1">收银员信息和商户信息不匹配</td><td colspan="1">请商户检查上送的收银员或商户号是否正确</td></tr>
<tr><td colspan="1">USERID_NOT_EXIST</td><td colspan="1">收银员信息不存在</td><td colspan="1">后台系统中不存在此收银员信息</td><td colspan="1">请商户检查上送的收银员是否正确</td></tr>
<tr><td colspan="1"><a name="ole_link3"></a>USERID_NOT_LAWFUL</td><td colspan="1">收银员字段内容非法</td><td colspan="1">收银员字段长度超长</td><td colspan="1">请上送正确的收银员信息</td></tr>
<tr><td colspan="1">MERID_NOT_EXIST</td><td colspan="1">商户号不存在</td><td colspan="1">后台系统中不存在此商户号信息</td><td colspan="1">请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">MERID_NOT_LAWFUL</td><td colspan="1">商户号字段内容非法</td><td colspan="1">商户号字段长度超长</td><td colspan="1">此API调用时内容不得超过32个字符，请商户检查上送的商户号是否正确</td></tr>
<tr><td colspan="1">ORIGORDERID_NOT_LAWFUL</td><td colspan="1">商户订单号字段内容非法</td><td colspan="1">原交易商户订单号字段为空或长度超长</td><td colspan="1">原交易商户订单号内容不得超过32个字符，请商户检查原交易商户订单号是否正确</td></tr>
<tr><td colspan="1">MERID_MISMATCHED_ORDER</td><td colspan="1">商户号与订单信息不符</td><td colspan="1">上送的商户号与订单信息不符</td><td colspan="1">请检查上送的商户号和订单是否匹配</td></tr>
<tr><td colspan="1">CMBORDERID_NOT_EXIST</td><td colspan="1">平台订单号不存在</td><td colspan="1">后台系统中不存在此平台订单号的支付交易</td><td colspan="1">此API仅支持按商户号和平台订单号的信息查询，请商户检查需要撤销的平台订单号是否正确</td></tr>
<tr><td colspan="1">ORIGCMBORDERID_NOT_LAWFUL</td><td colspan="1">平台订单号字段内容非法</td><td colspan="1">平台订单号字段为空或长度超长</td><td colspan="1">此API调用时原交易平台订单号必传，且内容不得超过32个字符，请商户检查需要查询的原交易平台订单号是否正确</td></tr>
<tr><td colspan="1">NOT_ALLOWED</td><td colspan="1">暂不支持</td><td colspan="1">银联交易暂不支持关单</td><td colspan="1">银联交易暂不支持关单</td></tr>
<tr><td colspan="1">UNPAIED_ORDER</td><td colspan="1">订单未支付</td><td colspan="1">该笔订单尚未支付</td><td colspan="1">只能查询已做交易的订单</td></tr>
<tr><td colspan="1">TRADESTATE_NOT_LAWFUL</td><td colspan="1">原交易状态非法</td><td colspan="1">原交易状态不允许关单</td><td colspan="1">已退款的订单和已支付的订单不允许再关单，请商户检查原交易状态。</td></tr>
<tr><td colspan="1" rowspan="10">公共错误</td><td colspan="1">SIGN_ERROR</td><td colspan="1">签名错误</td><td colspan="1">参数签名结果不正确</td><td colspan="1">请检查签名参数和方法是否都符合签名算法要求</td></tr>
<tr><td colspan="1">VERSION_ERROR</td><td colspan="1">版本号错误</td><td colspan="1">未使用指定版本号</td><td colspan="1">请使用指定的版本号</td></tr>
<tr><td colspan="1">ENCODING_ERROR</td><td colspan="1">编码格式错误</td><td colspan="1">未使用指定编码格式</td><td colspan="1">请使用指定编码格式</td></tr>
<tr><td colspan="1">SIGNMETHOD_ERROR</td><td colspan="1">加签方式错误</td><td colspan="1">未使用指定价钱方式</td><td colspan="1">请使用指定签名方式</td></tr>
<tr><td colspan="1">POST_DATA_EMPTY</td><td colspan="1">POST数据为空</td><td colspan="1">POST数据不能为空</td><td colspan="1">请检查POST数据是否为空</td></tr>
<tr><td colspan="1">UNDEFINED_PRAM</td><td colspan="1">未识别的参数</td><td colspan="1">有不能识别的参数</td><td colspan="1">请检查参数是否为接口文档中所示参数</td></tr>
<tr><td colspan="1">JSON_FORMAT_ERROR</td><td colspan="1">JSON格式错误</td><td colspan="1">JSON格式错误</td><td colspan="1">请检查JSON参数格式是否正确</td></tr>
<tr><td colspan="1">SYSTERM_ERROR</td><td colspan="1">系统处理异常</td><td colspan="1">系统处理请求时发生未知错误</td><td colspan="1">需要商户端发起查询确保交易结果</td></tr>
<tr><td colspan="1">MCH_SPC80_NOT_LAWFUL</td><td colspan="1">扩展字段内容非法</td><td colspan="1">扩展字段超长</td><td colspan="1">非必传字段，传的时候长度不可超过80个字符</td></tr>
<tr><td colspan="1">MCH_RESERVED_NOT_LAWFUL</td><td colspan="1">商户保留域字段内容非法</td><td colspan="1">商户保留域字段超长</td><td colspan="1"></td></tr>
</table>


# <a name="_toc4866"></a>**附录4 错误码处理机制参考**

<table><tr><th colspan="1">交易场景</th><th colspan="1">returnCode</th><th colspan="1">respCode</th><th colspan="1">tradeState</th><th colspan="1">errCode</th><th colspan="1">招行订单状态</th><th colspan="1">后续处理</th><th colspan="1">备注</th></tr>
<tr><td colspan="1" rowspan="8">付款码收款</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">未知</td><td colspan="1">发起查询</td><td colspan="1">超时未返回</td></tr>
<tr><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">无此订单</td><td colspan="1">使用新商户订单号重新发起收款</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SYSTERM_ERROR</td><td colspan="1">未知</td><td colspan="1">发起查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SYSTERM_MAINTAINING</td><td colspan="1">未知</td><td colspan="1">发起查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">其它</td><td colspan="1">失败</td><td colspan="1">使用新商户订单号重新发起收款</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">P</td><td colspan="1">不出现</td><td colspan="1">待支付</td><td colspan="1">发起查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">F</td><td colspan="1">不出现</td><td colspan="1">失败</td><td colspan="1">使用新商户订单号重新发起收款</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">S</td><td colspan="1">不出现</td><td colspan="1">成功</td><td colspan="1">收款成功，给用户发货</td><td colspan="1"></td></tr>
<tr><td colspan="1" rowspan="11">支付结果查询</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">未知</td><td colspan="1">查询失败，请再次支付结果查询</td><td colspan="1">超时未返回</td></tr>
<tr><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">未知</td><td colspan="1">查询失败，请再次支付结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SYSTERM_ERROR</td><td colspan="1">未知</td><td colspan="1">查询失败，请再次支付结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SYSTERM_MAINTAINING</td><td colspan="1">未知</td><td colspan="1">查询失败，请再次支付结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">CMBORDERID_NOT_EXIST</td><td colspan="1">待支付</td><td colspan="1">请再次支付结果查询，超过有效时间后停止查询，调起关单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">UNPAIED_ORDER</td><td colspan="1">待支付</td><td colspan="1">请再次支付结果查询，超过有效时间后停止查询，调起关单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">ORDERID_INVALID</td><td colspan="1">未支付</td><td colspan="1">停止发起查询，调起关单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">其它</td><td colspan="1">未知</td><td colspan="1">请再次支付结果查询，超过有效时间后停止查询，调起关单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">P</td><td colspan="1">不出现</td><td colspan="1">待支付</td><td colspan="1">请再次支付结果查询，超过有效时间后停止查询，调起关单或撤销</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">F</td><td colspan="1">不出现</td><td colspan="1">失败</td><td colspan="1">收款失败，不给用户发货</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">S</td><td colspan="1">不出现</td><td colspan="1">成功</td><td colspan="1">收款成功，给用户发货</td><td colspan="1"></td></tr>
<tr><td colspan="1" rowspan="8">撤销</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">未知</td><td colspan="1">发起支付结果查询</td><td colspan="1">超时未返回</td></tr>
<tr><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">撤销失败，原交易状态不变</td><td colspan="1">撤销失败，可重复发起撤销</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SYSTERM_ERROR</td><td colspan="1">未知</td><td colspan="1">发起支付结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SYSTERM_MAINTAINING</td><td colspan="1">未知</td><td colspan="1">发起支付结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">OPERATING_FREQUENTLY</td><td colspan="1">未知</td><td colspan="1">发起支付结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">其它</td><td colspan="1">撤销失败，原交易状态不变</td><td colspan="1">撤销失败，可重复发起撤销或支付结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">F</td><td colspan="1">不出现</td><td colspan="1">撤销失败，原交易状态不变</td><td colspan="1">撤销失败，可重复发起撤销或支付结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">D</td><td colspan="1">不出现</td><td colspan="1">已撤销</td><td colspan="1">撤销成功，不给用户发货</td><td colspan="1"></td></tr>
<tr><td colspan="1" rowspan="12">退款申请</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">未知</td><td colspan="1">发起退款结果查询</td><td colspan="1">超时未返回</td></tr>
<tr><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">无退款订单</td><td colspan="1">退款失败，可使用相同商户订单号发起幂等退款</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SYSTERM_ERROR</td><td colspan="1">未知</td><td colspan="1">发起退款结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SYSTERM_MAINTAINING</td><td colspan="1">未知</td><td colspan="1">发起退款结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">MCH_EXSRFN_AMOUNT_LESS</td><td colspan="1">失败</td><td colspan="1">待正向交易金额增加后重试</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">MCH_FORWARD_AMOUNT_LESS</td><td colspan="1">失败</td><td colspan="1">待正向交易金额增加后重试</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SUBMCH_FORWARD_AMOUNT_LESS</td><td colspan="1">失败</td><td colspan="1">待正向交易金额增加后重试</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SERVMCH_FORWARD_AMOUNT_LESS</td><td colspan="1">失败</td><td colspan="1">待正向交易金额增加后重试</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">其它</td><td colspan="1">失败</td><td colspan="1">退款失败，可使用相同商户订单号发起幂等退款</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">P</td><td colspan="1">不出现</td><td colspan="1">退款中</td><td colspan="1">发起退款结果查询(可能持续1-2天）</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">F</td><td colspan="1">不出现</td><td colspan="1">失败</td><td colspan="1">退款失败，可使用相同商户订单号发起幂等退款</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">S</td><td colspan="1">不出现</td><td colspan="1">成功</td><td colspan="1">退款成功，不给用户发货</td><td colspan="1"></td></tr>
<tr><td colspan="1" rowspan="8">退款结果查询</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">未知</td><td colspan="1">再次发起退款结果查询</td><td colspan="1">超时未返回</td></tr>
<tr><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">未知</td><td colspan="1">查询失败，请再次退款结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SYSTERM_ERROR</td><td colspan="1">未知</td><td colspan="1">再次发起退款结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">SYSTERM_MAINTAINING</td><td colspan="1">未知</td><td colspan="1">再次发起退款结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL</td><td colspan="1">` `- </td><td colspan="1">其它</td><td colspan="1">未知</td><td colspan="1">查询失败，请再次退款结果查询</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">P</td><td colspan="1">不出现</td><td colspan="1">退款中</td><td colspan="1">再次发起退款结果查询(可能持续1-2天）</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">F</td><td colspan="1">不出现</td><td colspan="1">失败</td><td colspan="1">退款交易失败</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">S</td><td colspan="1">不出现</td><td colspan="1">成功</td><td colspan="1">退款交易成功</td><td colspan="1"></td></tr>
<tr><td colspan="1" rowspan="6">线上支付</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">未知</td><td colspan="1">可使用相同商户订单号发起下单</td><td colspan="1">超时未返回</td></tr>
<tr><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">-</td><td colspan="1">-</td><td colspan="1">下单失败</td><td colspan="1">下单失败，可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">SYSTERM_ERROR</td><td colspan="1">未知</td><td colspan="1">可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">SYSTERM_MAINTAINING</td><td colspan="1">未知</td><td colspan="1">可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">其它</td><td colspan="1">失败</td><td colspan="1">下单失败，可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">-</td><td colspan="1">不出现</td><td colspan="1">下单成功</td><td colspan="1">拉起支付</td><td colspan="1"></td></tr>
<tr><td colspan="1" rowspan="6">服务窗支付</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">未知</td><td colspan="1">可使用相同商户订单号发起下单</td><td colspan="1">超时未返回</td></tr>
<tr><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">-</td><td colspan="1">-</td><td colspan="1">下单失败</td><td colspan="1">下单失败，可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">SYSTERM_ERROR</td><td colspan="1">未知</td><td colspan="1">可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">SYSTERM_MAINTAINING</td><td colspan="1">未知</td><td colspan="1">可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">其它</td><td colspan="1">失败</td><td colspan="1">下单失败，可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">-</td><td colspan="1">不出现</td><td colspan="1">下单成功</td><td colspan="1">拉起支付</td><td colspan="1"></td></tr>
<tr><td colspan="1" rowspan="6">原生支付<br>（支付宝or微信）</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">未知</td><td colspan="1">可使用相同商户订单号发起下单</td><td colspan="1">超时未返回</td></tr>
<tr><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">-</td><td colspan="1">-</td><td colspan="1">下单失败</td><td colspan="1">下单失败，可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">SYSTERM_ERROR</td><td colspan="1">未知</td><td colspan="1">可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">SYSTERM_MAINTAINING</td><td colspan="1">未知</td><td colspan="1">可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">其它</td><td colspan="1">失败</td><td colspan="1">下单失败，可使用相同商户订单号发起下单</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">-</td><td colspan="1">不出现</td><td colspan="1">下单成功</td><td colspan="1">拉起支付</td><td colspan="1"></td></tr>
<tr><td colspan="1" rowspan="6">收款码申请</td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">` `- </td><td colspan="1">下单失败</td><td colspan="1">使用新商户订单号重新申请二维码</td><td colspan="1">超时未返回</td></tr>
<tr><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">-</td><td colspan="1">-</td><td colspan="1">无此订单</td><td colspan="1">使用新商户订单号重新申请二维码</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">SYSTERM_ERROR</td><td colspan="1">下单失败</td><td colspan="1">使用新商户订单号重新申请二维码</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">SYSTERM_MAINTAINING</td><td colspan="1">下单失败</td><td colspan="1">使用新商户订单号重新申请二维码</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">FAIL </td><td colspan="1">-</td><td colspan="1">其它</td><td colspan="1">下单失败</td><td colspan="1">使用新商户订单号重新申请二维码</td><td colspan="1"></td></tr>
<tr><td colspan="1">SUCCESS</td><td colspan="1">SUCCESS</td><td colspan="1">-</td><td colspan="1">不出现</td><td colspan="1">下单成功</td><td colspan="1">展示二维码给用户扫码支付</td><td colspan="1"></td></tr>
</table>

# <a name="_toc4275"></a>**附录5 微信支付分对象结构**

|**Payment**|||||
| :- | :- | :- | :- | :- |
|**变量描述**|**变量名**|**类型**|**必填**|**备注**|
|付费名称|name|String(20)|否|　|
|付费金额|amount|integer|否|此付费项目总金额，大于等于0，单位为分，等于0时代表不需要扣费|
|付费说明|description|String(30)|否|　|
|付费数量|count|integer|否|付费项目的数量|
||||||
|**ServiceOrderCoupon**|||||
|**变量描述**|**变量名**|**类型**|**必填**|**备注**|
|优惠名称|name|String(20)|否|　|
|优惠说明|description|String(30)|否|　|
|优惠金额|amount|integer|否|此优惠项目优惠总金额，大于等于0，单位为分|
|优惠数量|count|integer|否|优惠项目的数量|
||||||
|**RiskFund**|||||
|**变量描述**|**变量名**|**类型**|**必填**|**备注**|
|风险名称|name|String(30)|是|1\.【评估不通过：交押金】模式：由微信支付分指定名称，商户可选择一种： 押金[DEPOSIT]、预付款[ADVANCE]、保证金[CASH\_DEPOSIT] （若微信支付分提供的名称，商户均认为不合适，需联系微信支付分新增合适的名称） 2.【评估不通过：拒绝】模式：默认 ESTIMATE\_ORDER\_COST [预估订单费用]|
|风险说明|description|String(30)|否|　|
|风险金额|amount|integer|是|` `1.数字，必须>0（单位元） 2.风险金额≤每个服务ID的风险金额上限。 3.当商户优惠字段为空时，付费项目总金额≤风险金额 （未填写金额的付费项目，视为该付费项目金额为0）|
||||||
|**TimeRange**|||||
|**变量描述**|**变量名**|**类型**|**必填**|**备注**|
|服务开始时间|start\_time|String(30)|否|【用户端展示用途】<br>【创建订单接口：是必填项】<br>用户下单时确认的服务开始时间（比如用户今天下单，明天开始接受服务，这里指的是明天的服务开始时间）.<br>支持三种格式: "yyyyMMddHHmmss"、"yyyyMMdd" 和 "OnAccept":<br>传入20091225091010表示2009年12月25日9点10分10秒<br>传入20091225默认认为时间为2009年12月25日0点0分0秒<br>传入OnAccept表示用户确认订单成功时间为【服务开始时间】<br>【服务开始时间】不能早于调用接口时间。|
|服务结束时间|end\_time|String(30)|否|用户端展示用途，支持两种格式:yyyyMMddHHmmss和yyyyMMdd 传入20091225091010表示2009年12月25日9点10分10秒 传入20091225默认认为时间为2009年12月25日23点59分59秒|
|服务开始时间备注|start\_time\_remark|String(20)|否|　|
|服务结束时间备注|end\_time\_remark|String(20)|否|　|
||||||
|**Location**|||||
|**变量描述**|**变量名**|**类型**|**必填**|**备注**|
|服务开始地点|start\_location|String(30)|否|开始使用服务的地点接口选填说明：<br>1\. 创建订单接口：可填入；<br>2\. 完结订单接口：不填写；|
|服务结束地点|end\_location|String(30)|否|　|
||||||
|**Collection**|||||
|**变量描述**|**变量名**|**类型**|**必填**|**备注**|
|收款状态|state|String(32)|是|USER\_PAYING：待支付；<br>USER\_PAID：已支付|
|总收款金额|total\_amount|integer|否|总金额，大于等于0的数字，单位为分<br>需满足：总金额=付费项目金额之和-商户优惠项目金额之和<=订单风险金额<br>未使用服务，取消订单时，该字段必须填0|
|待收金额|paying\_amount|integer|否|等待用户付款金额|
|已收金额|paid\_amount|integer|否|用户已付款的金额|
|收款明细列表|details|array[Detail]|否|收款明细列表|
||||||
|**Detail**|||||
|**变量描述**|**变量名**|**类型**|**必填**|**备注**|
|收款序号|seq|integer|否|从1开始递增|
|单笔收款金额|amount|integer|否|单笔收款动作的金额|
|收款成功渠道|paid\_type|String(32)|否|微信支付分：NEWTON；<br>商户渠道: MCH|
|收款成功时间|paid\_time|String(32)|否|支付成功时间，支持两种格式:yyyyMMddHHmmss和yyyyMMdd|
|微信支付交易单号|transaction\_id|String(64)|否|结单交易单号,等于普通支付接口中的transaction\_id，可以使用该订单号在APP支付->API列表->查询订单进行查询订单、申请退款。只有单据状态为USER\_PAID，且收款成功渠道为支付分渠道, 才会返回结单交易单号。|
|优惠功能|promotion\_detail|array[PromotionDetail]|否|　|
||||||
|**PromotionDetail**|||||
|**变量描述**|**变量名**|**类型**|**必填**|**备注**|
|券ID|coupon\_id|String(32)|是|　|
|优惠名称|name|String(64)|否|　|
|优惠范围|scope|String(32)|否|GLOBAL：全场代金券；<br>SINGLE：单品优惠|
|优惠类型|type|String(32)|否|CASH：充值；<br>NOCASH：免充值。|
|优惠券面额|amount|integer|是|　|
|活动ID|stock\_id|String(32)|否|　|
|微信出资|wechatpay\_contribute|integer|否|　|
|商户出资|merchant\_contribute|integer|否|　|
|其他出资|other\_contribute|integer|否|　|
|优惠币种|currency|String(32)|否|　|
|单品列表|goods\_detail|array[GoodsDetail]|否|　|
||||||
|**GoodsDetail**|||||
|**变量描述**|**变量名**|**类型**|**必填**|**备注**|
|商品编码|goods\_id|String(32)|是|　|
|商品数量|quantity|integer|否|　|
|商品价格|unit\_price|integer|否|　|
|商品优惠金额|discount\_amount|integer|否|　|
|商品备注|goods\_remark|String(128)|是|　|
||||||
|**IndirectSyncDetail**|||||
|**变量描述**|**变量名**|**类型**|**必填**|**备注**|
|收款成功时间|paid\_time|String(64)|是|支付成功时间，支持两种格式：yyyyMMddHHmmss和yyyyMMdd<br>1、传入20091225091010表示2009年12月25日9点10分10秒<br>2、传入20091225默认认为时间为2009年12月25日0点0分0秒<br>用户通过其他方式付款成功的实际时间，需满足条件：<br>服务开始时间＜调用商户完结订单接口的时间＜用户通过其他方式付款成功的实际时间≤商户调用支付分订单同步接口的时间+60秒 注：【服务开始时间】<br>1、当完结订单有填写【实际服务开始时间】时，【服务开始时间】=完结订单【实际服务开始时间】<br>2、当完结订单未填写【实际服务开始时间】时，【服务开始时间】=创建订单【服务开始时间】<br>场景类型为“Order\_Paid”时，必填<br>支持两种格式:yyyyMMddHHmmss和yyyyMMdd<br>1、传入20091225091010表示2009年12月25日9点10分10秒<br>2、传入20091225表示时间为2009年12月25日23点59分59秒<br>注：微信支付分会根据此时间更新用户侧的守约记录、负面记录信息；因此请务必如实填写用户实际付款成功时间，以免造成不必要的客诉|


