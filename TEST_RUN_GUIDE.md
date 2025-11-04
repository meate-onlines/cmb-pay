# 测试运行指南

本项目使用 Gradle + JUnit 5 进行测试。以下是运行测试的几种方法：

## 方法1：运行所有测试（Gradle 命令行）

在项目根目录下执行：

**Windows:**
```bash
gradlew.bat test
```

**Linux/Mac:**
```bash
./gradlew test
```

## 方法2：运行特定测试类

**Windows:**
```bash
gradlew.bat test --tests "com.cmbchina.payment.CmbPaymentClientTest"
```

**Linux/Mac:**
```bash
./gradlew test --tests "com.cmbchina.payment.CmbPaymentClientTest"
```

## 方法3：运行特定测试方法

运行 `testQrCodeApplyRequest` 方法：

**Windows:**
```bash
gradlew.bat test --tests "com.cmbchina.payment.CmbPaymentClientTest.testQrCodeApplyRequest"
```

**Linux/Mac:**
```bash
./gradlew test --tests "com.cmbchina.payment.CmbPaymentClientTest.testQrCodeApplyRequest"
```

## 方法4：在 IDE 中运行

### IntelliJ IDEA
1. 打开测试文件 `CmbPaymentClientTest.java`
2. 在测试方法 `testQrCodeApplyRequest()` 左侧点击绿色运行图标
3. 或者右键点击方法名，选择 "Run 'testQrCodeApplyRequest()'"

### Eclipse
1. 右键点击测试类或测试方法
2. 选择 "Run As" -> "JUnit Test"

### VS Code
1. 安装 Java Test Runner 扩展
2. 在测试方法上方会出现 "Run Test" 链接
3. 点击即可运行

## 方法5：运行所有测试并查看报告

```bash
gradlew.bat test
```

测试报告会生成在：`build/reports/tests/test/index.html`

用浏览器打开该文件即可查看详细的测试报告。

## 方法6：只运行失败的测试

```bash
gradlew.bat test --rerun-tasks
```

## 方法7：清理并运行测试

```bash
gradlew.bat clean test
```

## 查看测试输出

测试运行时会显示：
- ✅ 通过的测试（绿色）
- ❌ 失败的测试（红色）
- 测试执行时间

## 常见问题

### 问题1：找不到 gradlew
确保在项目根目录下执行命令，项目根目录应该包含 `gradlew` 或 `gradlew.bat` 文件。

### 问题2：测试需要网络连接
某些测试可能需要连接真实的API，如果测试失败，检查：
1. 网络连接
2. API配置是否正确
3. 测试环境是否可用

### 问题3：编译错误
先执行编译：
```bash
gradlew.bat build
```

## 测试类说明

- `CmbPaymentClientTest` - 支付客户端测试
- `CmbPaymentServiceTest` - 支付服务测试
- `SignUtilTest` - 签名工具测试

