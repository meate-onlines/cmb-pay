# 招商银行聚合支付SDK

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-green.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

招商银行商户聚合支付接口SDK，支持Java 17+版本，提供完整的支付、查询、退款功能，支持SM2国密加密算法。

## 功能特性

- ✅ **多支付方式支持**: 微信支付、支付宝、银联、数字人民币等
- ✅ **完整支付流程**: 收款码申请、订单查询、退款申请、退款查询
- ✅ **国密加密**: 支持SM2/SM3国密算法签名验签
- ✅ **异步通知**: 完整的异步通知处理和验签
- ✅ **Java 17+**: 兼容Java 17及以上版本
- ✅ **易于集成**: 简洁的API设计，快速集成
- ✅ **Spring Boot**: 完美集成Spring Boot框架

## 快速开始

### 1. 添加依赖

#### Gradle
```gradle
dependencies {
    implementation 'com.github.meate-onlines:cmb-pay:1.0.3'
}
```

#### Maven
```xml
<dependency>
    <groupId>com.github.meate-onlines</groupId>
    <artifactId>cmb-pay</artifactId>
    <version>1.0.3</version>
</dependency>
```

### 2. 配置参数

#### 使用Builder模式配置
```java
import com.cmbchina.payment.config.CmbPaymentConfig;

CmbPaymentConfig config = new CmbPaymentConfig.Builder()
    .merchantId("your_merchant_id")
    .appId("your_app_id")
    .appSecret("your_app_secret")
    .privateKey("your_sm2_private_key")
    .publicKey("your_sm2_public_key")
    .apiUrl("https://api.cmburl.cn:8065")
    .notifyUrl("https://your-domain.com/notify")
    .returnUrl("https://your-domain.com/return")
    .sandbox(true) // 测试环境
    .build();
```

#### 使用配置文件（可选）
在 `src/main/resources` 目录下创建 `cmb-payment.properties` 文件：

```properties
# 招商银行聚合支付配置
cmb.merchant.id=your_merchant_id
cmb.app.id=your_app_id
cmb.app.secret=your_app_secret
cmb.private.key=your_sm2_private_key
cmb.public.key=your_sm2_public_key
cmb.api.url=https://api.cmburl.cn:8065
cmb.notify.url=https://your-domain.com/notify
cmb.return.url=https://your-domain.com/return
cmb.sandbox=true
```

## 使用示例

### 基本用法

```java
import com.cmbchina.payment.CmbPaymentClient;
import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.model.request.*;
import com.cmbchina.payment.model.response.*;
import com.cmbchina.payment.exception.CmbPaymentException;

// 创建配置
CmbPaymentConfig config = new CmbPaymentConfig.Builder()
    .merchantId("your_merchant_id")
    .appId("your_app_id")
    .appSecret("your_app_secret")
    .privateKey("your_sm2_private_key")
    .publicKey("your_sm2_public_key")
    .build();

// 创建支付客户端
CmbPaymentClient client = new CmbPaymentClient(config);
```

### 收款码申请（主扫支付）

```java
import com.cmbchina.payment.model.request.QrCodeApplyRequest;
import com.cmbchina.payment.model.response.QrCodeApplyResponse;

QrCodeApplyRequest request = new QrCodeApplyRequest();
request.setMerId("your_merchant_id");
request.setOrderId("ORDER_" + System.currentTimeMillis());
request.setTxnAmt("10000"); // 100.00元，单位：分
request.setBody("测试商品");
request.setNotifyUrl("https://your-domain.com/notify");
request.setUserId("your_user_id"); // 收银员ID
request.setPayValidTime("300"); // 300秒过期

try {
    QrCodeApplyResponse response = client.qrCodeApply(request);
    
    if (response.isSuccess()) {
        System.out.println("二维码链接: " + response.getQrCode());
        System.out.println("平台订单号: " + response.getCmbOrderId());
        System.out.println("订单发送时间: " + response.getTxnTime());
    } else {
        System.out.println("申请失败: " + response.getRespMsg());
    }
} catch (CmbPaymentException e) {
    System.err.println("支付异常: " + e.getMessage());
}
```

### 订单查询

```java
import com.cmbchina.payment.model.request.OrderQueryRequest;
import com.cmbchina.payment.model.response.OrderQueryResponse;

OrderQueryRequest queryRequest = new OrderQueryRequest();
queryRequest.setMerId("your_merchant_id");
queryRequest.setOrderId("ORDER_123456789");

try {
    OrderQueryResponse response = client.orderQuery(queryRequest);
    
    if (response.isSuccess()) {
        System.out.println("订单状态: " + response.getOrderStat());
        System.out.println("订单金额: " + response.getTxnAmt());
        System.out.println("支付方式: " + response.getPayType());
        System.out.println("订单发送时间: " + response.getTxnTime());
    }
} catch (CmbPaymentException e) {
    System.err.println("查询异常: " + e.getMessage());
}
```

### 退款申请

```java
import com.cmbchina.payment.model.request.RefundRequest;
import com.cmbchina.payment.model.response.RefundResponse;

RefundRequest refundRequest = new RefundRequest();
refundRequest.setMerId("your_merchant_id");
refundRequest.setOrderId("REFUND_" + System.currentTimeMillis()); // 商户退款订单号
refundRequest.setUserId("your_user_id"); // 收银员ID
refundRequest.setOrigOrderId("ORDER_123456789"); // 原交易商户订单号
refundRequest.setTxnAmt("10000"); // 原交易金额，单位：分
refundRequest.setRefundAmt("5000"); // 退款金额，单位：分

try {
    RefundResponse response = client.refund(refundRequest);
    
    if (response.isSuccess()) {
        System.out.println("退款状态: " + response.getRefundState());
        System.out.println("退款金额: " + response.getRefundAmt());
        System.out.println("平台退款订单号: " + response.getCmbOrderId());
    }
} catch (CmbPaymentException e) {
    System.err.println("退款异常: " + e.getMessage());
}
```

### 退款查询

```java
import com.cmbchina.payment.model.request.RefundQueryRequest;
import com.cmbchina.payment.model.response.RefundQueryResponse;

RefundQueryRequest queryRequest = new RefundQueryRequest();
queryRequest.setMerId("your_merchant_id");
queryRequest.setOrderId("REFUND_123456789"); // 商户退款订单号

try {
    RefundQueryResponse response = client.refundQuery(queryRequest);
    
    if (response.isSuccess()) {
        System.out.println("退款状态: " + response.getRefundState());
        System.out.println("退款金额: " + response.getRefundAmt());
    }
} catch (CmbPaymentException e) {
    System.err.println("退款查询异常: " + e.getMessage());
}
```

### 关闭订单

```java
import com.cmbchina.payment.model.request.CloseOrderRequest;
import com.cmbchina.payment.model.response.CloseOrderResponse;

CloseOrderRequest closeRequest = new CloseOrderRequest();
closeRequest.setMerId("your_merchant_id");
closeRequest.setOrigOrderId("ORDER_123456789"); // 原交易商户订单号
closeRequest.setUserId("your_user_id"); // 收银员ID

try {
    CloseOrderResponse response = client.closeOrder(closeRequest);
    
    if (response.isSuccess()) {
        System.out.println("关单状态: " + response.getCloseState());
        System.out.println("订单发送时间: " + response.getTxnTime());
    }
} catch (CmbPaymentException e) {
    System.err.println("关闭订单异常: " + e.getMessage());
}
```

### 对账单下载

```java
import com.cmbchina.payment.model.request.StatementRequest;
import com.cmbchina.payment.model.response.StatementResponse;

StatementRequest statementRequest = new StatementRequest();
statementRequest.setMerId("your_merchant_id");
statementRequest.setBillDate("20241029"); // 账单日期，格式：yyyyMMdd
statementRequest.setBillType("01"); // 账单类型

try {
    StatementResponse response = client.getStatementUrl(statementRequest);
    
    if (response.isSuccess()) {
        System.out.println("账单下载地址: " + response.getFileDownloadUrl());
    }
} catch (CmbPaymentException e) {
    System.err.println("获取对账单异常: " + e.getMessage());
}
```

### 处理异步通知

```java
import org.springframework.web.bind.annotation.*;
import com.cmbchina.payment.model.response.NotifyResponse;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    
    @Autowired
    private CmbPaymentClient paymentClient;
    
    @PostMapping("/notify")
    public Map<String, String> handleNotify(@RequestBody String notifyData) {
        Map<String, String> result = new HashMap<>();
        
        try {
            // 验证通知签名
            boolean isValid = paymentClient.verifyNotify(notifyData);
            
            if (isValid) {
                // 处理通知数据
                NotifyResponse notifyResponse = paymentClient.handleNotify(notifyData);
                
                // 处理业务逻辑
                if ("S".equals(notifyResponse.getOrderStat())) {
                    // 支付成功，更新订单状态
                    updateOrderStatus(notifyResponse.getOrderId(), "PAID");
                }
                
                result.put("returnCode", "SUCCESS");
                result.put("respCode", "SUCCESS");
            } else {
                result.put("returnCode", "FAIL");
                result.put("respCode", "FAIL");
                result.put("respMsg", "签名验证失败");
            }
        } catch (Exception e) {
            result.put("returnCode", "FAIL");
            result.put("respCode", "FAIL");
            result.put("respMsg", "处理异常: " + e.getMessage());
        }
        
        return result;
    }
    
    private void updateOrderStatus(String orderId, String status) {
        // 实现订单状态更新逻辑
    }
}
```

### Spring Boot集成

```java
@Configuration
public class CmbPaymentConfig {
    
    @Value("${cmb.merchant.id}")
    private String merchantId;
    
    @Value("${cmb.app.id}")
    private String appId;
    
    @Value("${cmb.app.secret}")
    private String appSecret;
    
    @Value("${cmb.private.key}")
    private String privateKey;
    
    @Value("${cmb.public.key}")
    private String publicKey;
    
    @Bean
    public CmbPaymentClient cmbPaymentClient() {
        com.cmbchina.payment.config.CmbPaymentConfig config = 
            new com.cmbchina.payment.config.CmbPaymentConfig.Builder()
                .merchantId(merchantId)
                .appId(appId)
                .appSecret(appSecret)
                .privateKey(privateKey)
                .publicKey(publicKey)
                .build();
                
        return new CmbPaymentClient(config);
    }
}
```

## API 参考

### 核心类

#### CmbPaymentClient
主要的支付客户端类，提供所有支付相关功能。

#### CmbPaymentConfig
支付配置类，包含所有必要的配置信息。

#### 请求/响应模型
- `QrCodeApplyRequest` / `QrCodeApplyResponse`: 收款码申请
- `OrderQueryRequest` / `OrderQueryResponse`: 订单查询
- `PaymentRequest` / `PaymentResponse`: 付款码收款
- `RefundRequest` / `RefundResponse`: 退款申请
- `RefundQueryRequest` / `RefundQueryResponse`: 退款查询
- `CloseOrderRequest` / `CloseOrderResponse`: 关闭订单
- `CancelRequest` / `CancelResponse`: 付款码收款撤销
- `StatementRequest` / `StatementResponse`: 对账单下载
- `WechatUnifiedOrderRequest` / `WechatUnifiedOrderResponse`: 微信统一下单
- `AlipayServiceRequest` / `AlipayServiceResponse`: 支付宝服务窗支付
- `NotifyResponse`: 支付异步通知
- `RefundCallbackResponse`: 退款回调通知

### 支持的支付方式

1. **收款码主扫支付** - 生成动态聚合银标码（`qrCodeApply`）
2. **被扫用户付款码支付** - 扫描用户付款码（`pay`）
3. **微信统一下单** - 公众号、小程序、APP支付（`wechatUnifiedOrder`）
4. **支付宝服务窗支付** - 支付宝H5支付（`alipayService`）
5. **银联云闪付** - 银联二维码支付
6. **数字人民币支付** - 数字人民币统一下单
7. **订单查询** - 查询支付订单状态（`orderQuery`）
8. **退款申请** - 申请退款（`refund`）
9. **退款查询** - 查询退款状态（`refundQuery`）
10. **关闭订单** - 关闭未支付订单（`closeOrder`）
11. **付款码收款撤销** - 撤销付款码收款（`cancel`）
12. **对账单下载** - 获取对账单下载地址（`getStatementUrl`）

### 签名算法

SDK使用国密SM2算法进行签名和验签：

- **签名方法**: SM2（signMethod固定为02）
- **字符集**: UTF-8
- **版本号**: 0.0.1
- **编码方式**: UTF-8

### 错误处理

所有API调用都会抛出 `CmbPaymentException`，建议在业务代码中进行适当的异常处理：

```java
try {
    QrCodeApplyResponse response = client.qrCodeApply(request);
    // 处理成功响应
} catch (CmbPaymentException e) {
    // 处理异常
    logger.error("支付失败: {}", e.getMessage());
    logger.error("错误码: {}", e.getErrorCode());
}
```

### 订单状态说明

#### 支付订单状态
- `W`: 等待支付
- `P`: 支付中
- `S`: 支付成功
- `F`: 支付失败
- `C`: 订单关闭

#### 退款状态
- `P`: 退款正在处理（原交易为微信渠道）
- `S`: 退款成功（原交易为支付宝、银联渠道）
- `F`: 退款失败（原交易为微信、支付宝、银联渠道）

#### 关单处理状态
- `C`: 订单关闭成功
- `F`: 被关闭交易为失败状态，关单失败

### 环境配置

#### 测试环境
```java
CmbPaymentConfig config = new CmbPaymentConfig.Builder()
    .apiUrl("https://api.cmburl.cn:8065")
    .sandbox(true)
    .build();
```

#### 生产环境
```java
CmbPaymentConfig config = new CmbPaymentConfig.Builder()
    .apiUrl("https://api.cmbchina.com")
    .sandbox(false)
    .build();
```

## 测试

运行单元测试：

```bash
./gradlew test
```

运行示例代码：

```bash
./gradlew run
```

## 构建

```bash
./gradlew build
```

生成发布包：

```bash
./gradlew publishToMavenLocal
```

## 注意事项

1. **密钥安全**: 请妥善保管您的私钥，不要将其提交到代码仓库
2. **环境区分**: 测试环境和生产环境使用不同的API地址和密钥
3. **金额单位**: 所有金额参数的单位为分（1元=100分）
4. **订单号**: 商户订单号必须唯一，建议使用时间戳+随机数
5. **回调处理**: 异步通知必须返回SUCCESS，否则招行会重复推送
6. **签名验证**: 所有回调都必须验证签名，确保数据安全

## 常见问题

### Q: 如何获取测试环境的密钥？
A: 请联系招商银行获取测试环境的SM2密钥对。

### Q: 签名验证失败怎么办？
A: 请检查：
- 密钥是否正确（SM2私钥和公钥）
- 参数是否按字典序排序
- 字符编码是否为UTF-8
- 签名方法是否为02（SM2）
- 版本号是否为0.0.1

### Q: 如何处理网络超时？
A: 可以通过配置调整超时时间：
```java
CmbPaymentConfig config = new CmbPaymentConfig.Builder()
    .merchantId("your_merchant_id")
    .appId("your_app_id")
    .appSecret("your_app_secret")
    .privateKey("your_sm2_private_key")
    .publicKey("your_sm2_public_key")
    .connectTimeout(60000) // 60秒
    .readTimeout(60000)    // 60秒
    .build();
```

### Q: 支持哪些支付方式？
A: 支持支付宝（ZF）、微信支付（WX）、银联（YL）、数字人民币（EC）等多种支付方式。支付方式通过 `payType` 字段标识。

### Q: 如何处理退款回调？
A: 使用 `refundCallback` 方法处理退款回调通知：
```java
@PostMapping("/refund/notify")
public Map<String, String> handleRefundNotify(@RequestBody String notifyData) {
    try {
        RefundCallbackResponse response = client.refundCallback(notifyData);
        // 处理退款回调业务逻辑
        return client.buildNotifySuccessResponse();
    } catch (CmbPaymentException e) {
        return client.buildNotifyFailedResponse();
    }
}
```

## 更新日志

### v1.0.0 (2024-10-29)
- 初始版本发布
- 支持SM2国密算法（signMethod=02）
- 支持多种支付方式（微信、支付宝、银联、数字人民币）
- 完整的支付流程（收款码申请、订单查询、退款申请、退款查询、关闭订单）
- 完整的异步通知处理（支付通知、退款回调）
- 支持对账单下载
- Spring Boot集成支持
- Java 17+ 支持

## 许可证

MIT License

## 贡献

欢迎提交Issue和Pull Request来改进这个SDK。

## 联系方式

如有问题，请联系lggooef@gmail.com或提交Issue。