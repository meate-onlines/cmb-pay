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
    implementation 'com.cmbchina:cmb-payment-sdk:1.0.0'
}
```

#### Maven
```xml
<dependency>
    <groupId>com.cmbchina</groupId>
    <artifactId>cmb-payment-sdk</artifactId>
    <version>1.0.0</version>
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
request.setOrderAmt(10000L); // 100.00元，单位：分
request.setGoodsDes("测试商品");
request.setNotifyUrl("https://your-domain.com/notify");
request.setReturnUrl("https://your-domain.com/return");
request.setExpireTime(30); // 30分钟过期

try {
    QrCodeApplyResponse response = client.qrCodeApply(request);
    
    if (response.isSuccess()) {
        System.out.println("二维码链接: " + response.getQrCode());
        System.out.println("二维码图片: " + response.getQrCodeImg());
        System.out.println("平台订单号: " + response.getTnOrderId());
    } else {
        System.out.println("申请失败: " + response.getResultMsg());
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
        System.out.println("订单金额: " + response.getOrderAmt());
        System.out.println("支付方式: " + response.getPayType());
        System.out.println("支付时间: " + response.getPayTime());
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
refundRequest.setOrderId("ORDER_123456789");
refundRequest.setRefundOrderId("REFUND_" + System.currentTimeMillis());
refundRequest.setRefundAmt(5000L); // 退款50.00元
refundRequest.setRefundReason("用户申请退款");

try {
    RefundResponse response = client.refund(refundRequest);
    
    if (response.isSuccess()) {
        System.out.println("退款状态: " + response.getRefundStat());
        System.out.println("退款金额: " + response.getRefundAmt());
    }
} catch (CmbPaymentException e) {
    System.err.println("退款异常: " + e.getMessage());
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
                if ("SUCCESS".equals(notifyResponse.getOrderStat())) {
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
- `RefundRequest` / `RefundResponse`: 退款相关
- `NotifyResponse`: 异步通知

### 支持的支付方式

1. **收款码主扫支付** - 生成动态聚合银标码
2. **被扫用户付款码支付** - 扫描用户付款码
3. **微信统一下单** - 公众号、小程序、APP支付
4. **支付宝服务窗支付** - 支付宝H5支付
5. **银联云闪付** - 银联二维码支付
6. **数字人民币支付** - 数字人民币统一下单
7. **委托代扣** - 免密支付

### 签名算法

SDK使用国密SM2/SM3算法进行签名和验签：

- **签名方法**: SM2withSM3
- **字符集**: UTF-8
- **签名格式**: ASN1 DER编码

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

- `WAIT_PAY`: 等待支付
- `PAYING`: 支付中
- `SUCCESS`: 支付成功
- `FAIL`: 支付失败
- `CLOSED`: 订单关闭
- `REFUNDING`: 退款中
- `REFUNDED`: 退款成功
- `REFUND_FAIL`: 退款失败

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
- 密钥是否正确
- 参数是否按字典序排序
- 字符编码是否为UTF-8
- 签名算法是否为SM2withSM3

### Q: 如何处理网络超时？
A: 可以通过配置调整超时时间：
```java
config.setConnectTimeout(60000); // 60秒
config.setReadTimeout(60000);   // 60秒
```

### Q: 支持哪些支付方式？
A: 支持微信支付、支付宝、银联、数字人民币等多种支付方式。

## 更新日志

### v1.0.0 (2024-10-29)
- 初始版本发布
- 支持SM2国密算法
- 支持多种支付方式
- 完整的异步通知处理
- Spring Boot集成支持

## 许可证

MIT License

## 贡献

欢迎提交Issue和Pull Request来改进这个SDK。

## 联系方式

如有问题，请联系开发团队或提交Issue。