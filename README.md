# 招商银行聚合支付SDK

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-green.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

招商银行商户聚合支付接口SDK，支持Java 17+版本，提供完整的支付、查询、退款功能，支持配置文件和数据库两种配置方式。

## 功能特性

- ✅ **多支付方式支持**: 微信支付、支付宝、银联等
- ✅ **完整支付流程**: 创建订单、查询订单、申请退款、查询退款
- ✅ **多种配置方式**: 支持配置文件和数据库配置
- ✅ **安全签名**: 支持RSA2、MD5、HMAC-SHA256签名算法
- ✅ **异步通知**: 完整的异步通知处理和验签
- ✅ **Java 17+**: 兼容Java 17及以上版本
- ✅ **易于集成**: 简洁的API设计，快速集成

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>com.cmbchina</groupId>
    <artifactId>cmb-aggregated-payment-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 2. 配置文件方式

在 `src/main/resources` 目录下创建 `cmb-payment.properties` 文件：

```properties
# 招商银行聚合支付配置
cmb.merchant.id=your_merchant_id
cmb.private.key=your_private_key
cmb.public.key=your_public_key
cmb.api.url=https://api.cmbchina.com
cmb.notify.url=https://your-domain.com/notify
cmb.return.url=https://your-domain.com/return
cmb.sign.type=RSA2
cmb.charset=UTF-8
cmb.connect.timeout=30000
cmb.read.timeout=30000
cmb.sandbox=false
```

### 3. 数据库配置方式

创建数据库表（参考 `src/main/resources/db/schema.sql`）：

```sql
CREATE TABLE cmb_payment_config (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    merchant_id VARCHAR(64) NOT NULL,
    config_key VARCHAR(128) NOT NULL,
    config_value TEXT,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE KEY uk_merchant_config (merchant_id, config_key)
);
```

配置数据库连接信息 `cmb-payment-db.properties`：

```properties
db.url=jdbc:mysql://localhost:3306/payment_db?useSSL=false&serverTimezone=UTC
db.username=your_username
db.password=your_password
db.table.name=cmb_payment_config
```

## 使用示例

### 基本用法

```java
import com.cmbchina.payment.config.ConfigManager;
import com.cmbchina.payment.config.PaymentConfig;
import com.cmbchina.payment.model.*;
import com.cmbchina.payment.service.CmbPaymentService;
import java.math.BigDecimal;
import java.time.LocalDateTime;

// 从配置文件加载配置
PaymentConfig config = ConfigManager.loadFromFile();

// 或者从数据库加载配置
// PaymentConfig config = ConfigManager.loadFromDatabase("your_merchant_id");

// 创建支付服务
CmbPaymentService paymentService = new CmbPaymentService(config);
```

### 创建支付订单

```java
PaymentRequest request = new PaymentRequest();
request.setOutTradeNo("ORDER_" + System.currentTimeMillis());
request.setTotalAmount(new BigDecimal("100.00"));
request.setSubject("测试商品");
request.setBody("这是一个测试订单");
request.setNotifyUrl("https://your-domain.com/notify");
request.setReturnUrl("https://your-domain.com/return");
request.setPaymentType("WECHAT");
request.setExpireTime(LocalDateTime.now().plusMinutes(30));

PaymentResponse response = paymentService.createPayment(request);

if (response.isSuccess()) {
    System.out.println("支付链接: " + response.getPayUrl());
    System.out.println("二维码: " + response.getQrCode());
} else {
    System.out.println("创建失败: " + response.getMessage());
}
```

### 查询支付订单

```java
QueryRequest queryRequest = new QueryRequest();
queryRequest.setOutTradeNo("ORDER_123456789");

PaymentResponse response = paymentService.queryPayment(queryRequest);

if (response.isSuccess()) {
    System.out.println("交易状态: " + response.getTradeStatus());
    System.out.println("支付金额: " + response.getTotalAmount());
}
```

### 申请退款

```java
RefundRequest refundRequest = new RefundRequest();
refundRequest.setOutTradeNo("ORDER_123456789");
refundRequest.setOutRefundNo("REFUND_" + System.currentTimeMillis());
refundRequest.setRefundAmount(new BigDecimal("50.00"));
refundRequest.setRefundReason("用户申请退款");

RefundResponse response = paymentService.createRefund(refundRequest);

if (response.isSuccess()) {
    System.out.println("退款状态: " + response.getRefundStatus());
}
```

### 处理异步通知

```java
@PostMapping("/notify")
public String handleNotify(@RequestBody NotifyRequest notifyRequest) {
    // 验证签名
    boolean isValid = paymentService.verifyNotify(notifyRequest);
    
    if (isValid) {
        // 处理支付成功逻辑
        if ("SUCCESS".equals(notifyRequest.getTradeStatus())) {
            // 更新订单状态
            updateOrderStatus(notifyRequest.getOutTradeNo(), "PAID");
        }
        return "SUCCESS";
    } else {
        return "FAIL";
    }
}
```

## API 参考

### 核心类

#### PaymentConfig
支付配置类，包含所有必要的配置信息。

#### CmbPaymentService
主要的支付服务类，提供所有支付相关功能。

#### 请求/响应模型
- `PaymentRequest` / `PaymentResponse`: 支付相关
- `QueryRequest`: 查询请求
- `RefundRequest` / `RefundResponse`: 退款相关
- `NotifyRequest`: 异步通知

### 配置管理

#### ConfigManager
配置管理器，提供从文件和数据库加载配置的功能。

```java
// 从文件加载
PaymentConfig config = ConfigManager.loadFromFile();

// 从数据库加载
PaymentConfig config = ConfigManager.loadFromDatabase("merchant_id");

// 保存到数据库
ConfigManager.saveToDatabase(config);
```

## 签名算法

SDK支持多种签名算法：

- **RSA2**: 推荐使用，安全性最高
- **MD5**: 兼容性好，适合简单场景
- **HMAC-SHA256**: 性能好，适合高并发场景

## 错误处理

所有API调用都会抛出 `RuntimeException`，建议在业务代码中进行适当的异常处理：

```java
try {
    PaymentResponse response = paymentService.createPayment(request);
    // 处理成功响应
} catch (RuntimeException e) {
    // 处理异常
    logger.error("支付失败", e);
}
```

## 测试

运行单元测试：

```bash
mvn test
```

运行示例代码：

```bash
mvn exec:java -Dexec.mainClass="com.cmbchina.payment.example.PaymentExample"
```

## 构建

```bash
mvn clean package
```

## 许可证

MIT License

## 贡献

欢迎提交Issue和Pull Request来改进这个SDK。

## 联系方式

如有问题，请联系开发团队或提交Issue。