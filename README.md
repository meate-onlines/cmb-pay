# 招商银行支付SDK (Java17+)

[![Java Version](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](https://opensource.org/licenses/Apache-2.0)
[![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]()

一个适配Java17+的招商银行聚合支付SDK，提供完整的支付、查询、退款、回调处理等功能。

## 特性

- ✅ **Java17+兼容**: 完全适配Java17及以上版本
- ✅ **SM2国密加密**: 支持招商银行要求的SM2签名算法
- ✅ **完整API覆盖**: 支持收款码申请、付款码收款、订单查询、退款等全部API
- ✅ **回调处理**: 内置Spring Boot回调处理器，自动验签和业务处理
- ✅ **类型安全**: 使用强类型请求响应模型，避免字段错误
- ✅ **异常处理**: 完善的异常处理机制
- ✅ **单元测试**: 高覆盖率的单元测试
- ✅ **文档完整**: 详细的API文档和使用示例

## 快速开始

### 1. 添加依赖

```gradle
dependencies {
    implementation 'com.cmbchina:cmb-payment-sdk:1.0.0'
}
```

### 2. 配置参数

```java
CmbPaymentConfig config = new CmbPaymentConfig.Builder()
    .merchantId("your_merchant_id")           // 商户号
    .appId("your_app_id")                     // 应用ID
    .appSecret("your_app_secret")             // 应用密钥
    .privateKey("your_sm2_private_key")       // SM2私钥
    .publicKey("cmb_sm2_public_key")          // 招行SM2公钥
    .apiUrl("https://api.cmburl.cn:8065")     // API地址
    .notifyUrl("https://your-domain.com/notify") // 回调地址
    .sandbox(false)                           // 是否沙箱环境
    .build();
```

### 3. 创建客户端

```java
CmbPaymentClient client = new CmbPaymentClient(config);
```

### 4. 发起支付

```java
// 收款码申请
QrCodeApplyRequest request = new QrCodeApplyRequest();
request.setMerId("your_merchant_id");
request.setOrderId("ORDER_" + System.currentTimeMillis());
request.setOrderAmt(10000L); // 100.00元，单位：分
request.setGoodsDes("测试商品");
request.setNotifyUrl("https://your-domain.com/notify");

try {
    QrCodeApplyResponse response = client.qrCodeApply(request);
    if (response.isSuccess()) {
        String qrCode = response.getQrCode();
        System.out.println("二维码链接: " + qrCode);
    } else {
        System.out.println("申请失败: " + response.getResultMsg());
    }
} catch (CmbPaymentException e) {
    System.out.println("请求异常: " + e.getMessage());
}
```

## 主要功能

### 支付相关

#### 1. 收款码申请（主扫支付）

```java
QrCodeApplyRequest request = new QrCodeApplyRequest();
request.setMerId("123456789");
request.setOrderId("ORDER_20241029001");
request.setOrderAmt(10000L);
request.setGoodsDes("测试商品");
request.setNotifyUrl("https://your-domain.com/notify");
request.setExpireTime(30); // 30分钟有效期

QrCodeApplyResponse response = client.qrCodeApply(request);
```

#### 2. 付款码收款（被扫支付）

```java
PaymentRequest request = new PaymentRequest();
request.setMerId("123456789");
request.setOrderId("ORDER_20241029002");
request.setOrderAmt(10000L);
request.setGoodsDes("测试商品");
request.setPayCode("134567890123456789"); // 用户付款码
request.setNotifyUrl("https://your-domain.com/notify");

PaymentResponse response = client.pay(request);
```

#### 3. 订单查询

```java
OrderQueryRequest request = new OrderQueryRequest();
request.setMerId("123456789");
request.setOrderId("ORDER_20241029001");

OrderQueryResponse response = client.orderQuery(request);
if (response.isSuccess()) {
    System.out.println("订单状态: " + response.getOrderStat());
    System.out.println("支付金额: " + response.getPayAmt());
}
```

### 退款相关

#### 1. 申请退款

```java
RefundRequest request = new RefundRequest();
request.setMerId("123456789");
request.setOrderId("ORDER_20241029001");
request.setRefundId("REFUND_20241029001");
request.setRefundAmt(5000L); // 退款50.00元
request.setRefundReason("用户申请退款");

RefundResponse response = client.refund(request);
```

#### 2. 退款查询

```java
RefundQueryRequest request = new RefundQueryRequest();
request.setMerId("123456789");
request.setRefundId("REFUND_20241029001");

RefundQueryResponse response = client.refundQuery(request);
```

### 回调处理

SDK提供了完整的回调处理功能，自动验签和业务处理。

#### 1. 配置回调处理器

```java
@Component
public class MyNotifyProcessor implements NotifyProcessor {
    
    @Override
    public boolean processNotify(NotifyResponse notifyResponse) {
        // 处理支付成功回调
        if (notifyResponse.isPaymentSuccess()) {
            // 更新订单状态
            // 发送通知等业务逻辑
            System.out.println("支付成功: " + notifyResponse.getOrderId());
            return true;
        }
        return false;
    }
    
    @Override
    public boolean processRefundNotify(NotifyResponse notifyResponse) {
        // 处理退款回调
        System.out.println("退款成功: " + notifyResponse.getRefundId());
        return true;
    }
}
```

#### 2. 手动处理回调

```java
// 验证回调签名
boolean isValid = client.verifyNotify(notifyData);

// 处理回调数据
if (isValid) {
    NotifyResponse notify = client.handleNotify(notifyData);
    // 处理业务逻辑
}
```

## 配置说明

### 基础配置

| 参数 | 类型 | 必填 | 说明 |
|------|------|------|------|
| merchantId | String | 是 | 商户号 |
| appId | String | 是 | 应用ID |
| appSecret | String | 是 | 应用密钥 |
| privateKey | String | 是 | 商户SM2私钥 |
| publicKey | String | 是 | 招行SM2公钥 |

### 可选配置

| 参数 | 类型 | 默认值 | 说明 |
|------|------|--------|------|
| apiUrl | String | https://api.cmburl.cn:8065 | API基础地址 |
| notifyUrl | String | - | 默认回调地址 |
| returnUrl | String | - | 默认返回地址 |
| connectTimeout | int | 30000 | 连接超时时间(ms) |
| readTimeout | int | 30000 | 读取超时时间(ms) |
| sandbox | boolean | false | 是否沙箱环境 |

## 错误处理

SDK使用`CmbPaymentException`来处理各种异常情况：

```java
try {
    QrCodeApplyResponse response = client.qrCodeApply(request);
} catch (CmbPaymentException e) {
    System.out.println("错误码: " + e.getErrorCode());
    System.out.println("错误信息: " + e.getErrorMessage());
    
    // 根据错误码进行不同处理
    switch (e.getErrorCode()) {
        case "SIGN_ERROR":
            // 签名错误处理
            break;
        case "PARAM_ERROR":
            // 参数错误处理
            break;
        default:
            // 其他错误处理
            break;
    }
}
```

## 最佳实践

### 1. 订单号生成

```java
// 推荐使用时间戳+随机数的方式生成唯一订单号
String orderId = "ORDER_" + System.currentTimeMillis() + "_" + 
    SignatureUtil.generateNonce(6);
```

### 2. 金额处理

```java
// 所有金额单位都是分，避免浮点数精度问题
BigDecimal yuan = new BigDecimal("100.50");
long fen = yuan.multiply(new BigDecimal("100")).longValue(); // 10050分
```

### 3. 异步处理

```java
@Async
public void processPaymentAsync(String orderId) {
    try {
        OrderQueryRequest request = new OrderQueryRequest();
        request.setMerId(merchantId);
        request.setOrderId(orderId);
        
        OrderQueryResponse response = client.orderQuery(request);
        // 处理查询结果
    } catch (Exception e) {
        // 异常处理
    }
}
```

### 4. 重试机制

```java
@Retryable(value = CmbPaymentException.class, maxAttempts = 3)
public QrCodeApplyResponse applyQrCodeWithRetry(QrCodeApplyRequest request) 
    throws CmbPaymentException {
    return client.qrCodeApply(request);
}
```

## 安全建议

1. **密钥安全**: 私钥不要硬编码在代码中，使用配置文件或环境变量
2. **HTTPS通信**: 生产环境必须使用HTTPS
3. **签名验证**: 必须验证所有回调通知的签名
4. **重放攻击**: 实现订单号唯一性检查
5. **日志脱敏**: 记录日志时要脱敏敏感信息

## 常见问题

### Q: 签名验证失败怎么办？
A: 检查以下几点：
- 私钥格式是否正确（16进制字符串）
- 参数是否按字典序排序
- 编码是否为UTF-8
- 是否包含了所有非空参数

### Q: 回调通知收不到怎么办？
A: 检查以下几点：
- 回调地址是否可以公网访问
- 是否正确返回了SUCCESS响应
- 防火墙是否允许招行IP访问

### Q: 如何在Spring Boot中使用？
A: 参考以下配置：

```java
@Configuration
public class PaymentConfig {
    
    @Bean
    public CmbPaymentConfig cmbPaymentConfig() {
        return new CmbPaymentConfig.Builder()
            .merchantId("${cmb.merchant.id}")
            .appId("${cmb.app.id}")
            .appSecret("${cmb.app.secret}")
            .privateKey("${cmb.private.key}")
            .publicKey("${cmb.public.key}")
            .build();
    }
    
    @Bean
    public CmbPaymentClient cmbPaymentClient(CmbPaymentConfig config) {
        return new CmbPaymentClient(config);
    }
}
```

## 更新日志

### v1.0.0 (2024-10-29)
- 初始版本发布
- 支持Java17+
- 实现SM2签名算法
- 完整的支付API覆盖
- 内置回调处理器
- 完善的单元测试

## 许可证

本项目采用 Apache License 2.0 许可证。详情请参阅 [LICENSE](LICENSE) 文件。

## 支持

如有问题或建议，请提交 [Issue](https://github.com/cmbchina/cmb-payment-sdk/issues)。

## 贡献

欢迎提交 Pull Request 来改进这个项目。请确保：

1. 代码符合项目的编码规范
2. 添加适当的单元测试
3. 更新相关文档
4. 提交信息清晰明确