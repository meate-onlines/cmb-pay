# CMB Payment SDK 打包发布指南

本文档提供多种方式打包和发布 SDK。

## 目录
- [快速开始](#快速开始)
- [方法一：发布到本地 Maven 仓库](#方法一发布到本地-maven-仓库)
- [方法二：发布到 GitHub Packages](#方法二发布到-github-packages)
- [方法三：发布到 Maven Central](#方法三发布到-maven-central)
- [方法四：手动构建 JAR 包](#方法四手动构建-jar-包)

---

## 快速开始

### 1. 构建项目

```bash
# Windows
gradlew.bat build

# Linux/Mac
./gradlew build
```

### 2. 运行测试

```bash
# Windows
gradlew.bat test

# Linux/Mac
./gradlew test
```

### 3. 发布到本地仓库

```bash
# Windows
gradlew.bat publishToMavenLocal

# Linux/Mac
./gradlew publishToMavenLocal
```

发布成功后，可以在 `~/.m2/repository/com/github/meate-onlines/cmb-payment-sdk/1.0.0/` 目录下找到生成的包。

---

## 方法一：发布到本地 Maven 仓库

适用于在本地开发测试。

### 步骤

1. **执行发布命令**

```bash
# Windows
gradlew.bat publishToMavenLocal

# Linux/Mac
./gradlew publishToMavenLocal
```

2. **在其他项目中引用**

在需要使用 SDK 的项目的 `build.gradle` 中添加：

```gradle
repositories {
    mavenLocal()
}

dependencies {
    implementation 'com.cmbchina:cmb-payment-sdk:1.0.0'
}
```

---

## 方法二：发布到 GitHub Packages

适用于开源项目，可以通过 GitHub 托管。

### 前置条件

1. 创建 GitHub Personal Access Token (PAT)
   - 访问：https://github.com/settings/tokens
   - 勾选 `write:packages` 权限
   - 生成 token 并保存

### 步骤

1. **修改 build.gradle**

取消注释以下代码：

```gradle
repositories {
    mavenLocal()
    
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/meate-onlines/cmb-pay")
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_USERNAME")
            password = project.findProperty("gpr.token") ?: System.getenv("GITHUB_TOKEN")
        }
    }
}
```

2. **配置凭证**

方式一：在 `gradle.properties` 中添加：

```properties
gpr.user=你的GitHub用户名
gpr.token=你的GitHub_Token
```

方式二：使用环境变量：

```bash
# Windows PowerShell
$env:GITHUB_USERNAME="你的GitHub用户名"
$env:GITHUB_TOKEN="你的GitHub_Token"

# Linux/Mac
export GITHUB_USERNAME=你的GitHub用户名
export GITHUB_TOKEN=你的GitHub_Token
```

3. **发布**

```bash
# Windows
gradlew.bat publish

# Linux/Mac
./gradlew publish
```

4. **在其他项目中使用**

```gradle
repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/meate-onlines/cmb-pay")
        credentials {
            username = project.findProperty("gpr.user")
            password = project.findProperty("gpr.token")
        }
    }
}

dependencies {
    implementation 'com.cmbchina:cmb-payment-sdk:1.0.0'
}
```

---

## 方法三：发布到 Maven Central

适用于生产环境，面向全球开发者。

### 前置条件

1. 在 [Sonatype](https://issues.sonatype.org/) 申请账户
2. 创建 JIRA ticket 申请新仓库
3. 生成 GPG Key 用于签名

### 步骤

1. **生成 GPG Key**

```bash
# 安装 GPG (Windows 使用 GPG4Win)
gpg --gen-key

# 查看 key ID
gpg --list-keys

# 导出公钥并上传到 keyserver
gpg --keyserver hkp://keyserver.ubuntu.com --send-keys YOUR_KEY_ID
```

2. **配置 build.gradle**

添加签名插件和配置：

```gradle
plugins {
    id 'java-library'
    id 'maven-publish'
    id 'signing'  // 添加这一行
}

// 签名配置
signing {
    sign publishing.publications.maven
}
```

取消注释 Maven Central 配置：

```gradle
repositories {
    mavenLocal()
    
    maven {
        url = "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
        credentials {
            username = ossrhUsername
            password = ossrhPassword
        }
    }
}
```

3. **配置 gradle.properties**

```properties
signing.keyId=你的GPG_KEY_ID
signing.password=你的GPG_KEY_PASSWORD
signing.secretKeyRingFile=C:/Users/你的用户名/.gnupg/secring.gpg
ossrhUsername=你的Sonatype用户名
ossrhPassword=你的Sonatype密码
```

4. **发布**

```bash
# Windows
gradlew.bat publish

# Linux/Mac
./gradlew publish
```

5. **在 Sonatype Nexus 中发布**

- 访问 https://oss.sonatype.org/
- 登录并进入 Staging Repositories
- 找到你的发布，点击 Close
- 验证通过后点击 Release

---

## 方法四：手动构建 JAR 包

适用于直接分发 JAR 文件。

### 步骤

1. **构建完整 JAR（包含所有依赖）**

修改 `build.gradle`，添加插件：

```gradle
plugins {
    id 'java-library'
    id 'maven-publish'
    id 'com.github.johnrengelman.shadow' version '7.1.2'
}

shadowJar {
    archiveBaseName.set('cmb-payment-sdk')
    archiveVersion.set('1.0.0')
    archiveClassifier.set('')
    configurations = [project.configurations.runtimeClasspath]
}
```

执行构建：

```bash
# Windows
gradlew.bat shadowJar

# Linux/Mac
./gradlew shadowJar
```

生成的 JAR 在 `build/libs/cmb-payment-sdk-1.0.0.jar`

2. **构建源码和文档**

```bash
# 构建所有任务
gradlew.bat build javadoc sourcesJar

# 或分别执行
gradlew.bat sourcesJar      # 源码 JAR
gradlew.bat javadoc          # Javadoc
gradlew.bat jar              # 编译后的 JAR
```

生成的文件：
- `build/libs/cmb-payment-sdk-1.0.0.jar` - 主 JAR
- `build/libs/cmb-payment-sdk-1.0.0-sources.jar` - 源码
- `build/libs/cmb-payment-sdk-1.0.0-javadoc.jar` - 文档

3. **安装到本地仓库**

```bash
gradlew.bat install
```

---

## 验证发布

### 检查本地 Maven 仓库

```bash
# Windows
dir %USERPROFILE%\.m2\repository\com\cmbchina\cmb-payment-sdk\1.0.0\

# Linux/Mac
ls -la ~/.m2/repository/com/cmbchina/cmb-payment-sdk/1.0.0/
```

应该看到：
- `cmb-payment-sdk-1.0.0.jar`
- `cmb-payment-sdk-1.0.0-sources.jar`
- `cmb-payment-sdk-1.0.0-javadoc.jar`
- `cmb-payment-sdk-1.0.0.pom`

### 测试依赖下载

创建一个简单的测试项目，尝试引用 SDK：

```gradle
dependencies {
    implementation 'com.cmbchina:cmb-payment-sdk:1.0.0'
}
```

如果能够成功下载，说明发布成功。

---

## 发布检查清单

在发布之前，请确认：

- [ ] 版本号已更新
- [ ] 所有测试通过
- [ ] README.md 已更新
- [ ] CHANGELOG.md 已更新
- [ ] POM 信息正确
- [ ] 没有敏感信息泄露
- [ ] 许可证文件存在
- [ ] Git 标签已创建（用于 GitHub Releases）

---

## 版本管理

### 修改版本号

编辑 `build.gradle`：

```gradle
version = '1.0.1'  // 修改版本号
```

### 创建 Git 标签

```bash
git tag -a v1.0.0 -m "Release version 1.0.0"
git push origin v1.0.0
```

---

## 故障排除

### 问题 1：找不到符号
**原因**：缺少依赖  
**解决**：运行 `gradlew dependencies` 检查依赖

### 问题 2：签名失败
**原因**：GPG Key 未正确配置  
**解决**：检查 `gradle.properties` 中的签名配置

### 问题 3：发布到 GitHub Packages 失败
**原因**：Token 权限不足或用户名/密码错误  
**解决**：确保 Token 有 `write:packages` 权限

### 问题 4：JAR 包找不到主类
**原因**：这是一个库，不需要主类  
**解决**：正常现象，SDK 作为库使用

---

## 更多资源

- [Gradle 发布文档](https://docs.gradle.org/current/userguide/publishing_overview.html)
- [Maven Central 指南](https://central.sonatype.com/publish/)
- [GitHub Packages 文档](https://docs.github.com/en/packages)
- [GPG 使用指南](https://www.gnupg.org/)

---

## 联系支持

如有问题，请提交 Issue：https://github.com/meate-onlines/cmb-pay/issues

