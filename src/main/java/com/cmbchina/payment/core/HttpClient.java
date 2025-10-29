package com.cmbchina.payment.core;

import com.cmbchina.payment.config.CmbPaymentConfig;
import com.cmbchina.payment.crypto.SignatureUtil;
import com.cmbchina.payment.exception.CmbPaymentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * HTTP客户端 - 适配Java17+
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class HttpClient {
    
    private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);
    
    private final CmbPaymentConfig config;
    private final RestTemplate restTemplate;
    
    static {
        // 禁用SSL验证（仅用于测试环境）
        disableSslVerification();
    }
    
    public HttpClient(CmbPaymentConfig config) {
        this.config = config;
        this.restTemplate = createRestTemplate();
    }
    
    /**
     * 发送POST请求
     * 
     * @param url 请求URL
     * @param requestBody 请求体
     * @return 响应体
     * @throws CmbPaymentException 请求异常
     */
    public String post(String url, String requestBody) throws CmbPaymentException {
        try {
            // 构建请求头
            HttpHeaders headers = buildHeaders(requestBody);
            
            // 创建请求实体
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
            
            // 发送请求
            ResponseEntity<String> response = restTemplate.exchange(
                url, 
                HttpMethod.POST, 
                requestEntity, 
                String.class
            );
            
            // 检查响应状态
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new CmbPaymentException("HTTP_ERROR", 
                    "HTTP请求失败，状态码：" + response.getStatusCode());
            }
            
            return response.getBody();
            
        } catch (Exception ex) {
            logger.error("HTTP请求失败: url={}, error={}", url, ex.getMessage(), ex);
            if (ex instanceof CmbPaymentException) {
                throw ex;
            }
            throw new CmbPaymentException("HTTP_REQUEST_FAIL", "HTTP请求失败", ex);
        }
    }
    
    /**
     * 构建请求头
     */
    private HttpHeaders buildHeaders(String requestBody) throws CmbPaymentException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("User-Agent", "CMB-Payment-SDK/1.0.0");
        
        try {
            // 生成时间戳
            long timestamp = System.currentTimeMillis() / 1000;
            
            // 解析请求体获取业务签名
            Map<String, String> requestMap = parseRequestBody(requestBody);
            String businessSign = requestMap.get("sign");
            
            if (businessSign == null) {
                throw new CmbPaymentException("SIGN_MISSING", "业务签名缺失");
            }
            
            // 生成API签名
            String apiSign = SignatureUtil.generateApiSign(
                config.getAppId(), 
                config.getAppSecret(), 
                businessSign, 
                timestamp
            );
            
            // 设置API认证头
            headers.set("appid", config.getAppId());
            headers.set("timestamp", String.valueOf(timestamp));
            headers.set("apisign", apiSign);
            
            return headers;
            
        } catch (Exception ex) {
            logger.error("构建请求头失败", ex);
            throw new CmbPaymentException("BUILD_HEADERS_FAIL", "构建请求头失败", ex);
        }
    }
    
    /**
     * 解析请求体
     */
    private Map<String, String> parseRequestBody(String requestBody) {
        try {
            // 这里简单实现，实际可以使用Jackson解析
            Map<String, String> result = new HashMap<>();
            
            // 移除JSON格式的大括号
            String content = requestBody.trim();
            if (content.startsWith("{") && content.endsWith("}")) {
                content = content.substring(1, content.length() - 1);
            }
            
            // 简单解析JSON字段（这里只解析sign字段）
            String[] pairs = content.split(",");
            for (String pair : pairs) {
                String[] keyValue = pair.split(":", 2);
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim().replaceAll("\"", "");
                    String value = keyValue[1].trim().replaceAll("\"", "");
                    result.put(key, value);
                }
            }
            
            return result;
            
        } catch (Exception ex) {
            logger.error("解析请求体失败: requestBody={}", requestBody, ex);
            return new HashMap<>();
        }
    }
    
    /**
     * 创建RestTemplate
     */
    private RestTemplate createRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(config.getConnectTimeout());
        factory.setReadTimeout(config.getReadTimeout());
        
        return new RestTemplate(factory);
    }
    
    /**
     * 禁用SSL验证（仅用于测试环境）
     */
    private static void disableSslVerification() {
        try {
            // 创建信任所有证书的TrustManager
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
            };
            
            // 安装信任所有证书的TrustManager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            
            // 创建信任所有主机名的HostnameVerifier
            HostnameVerifier allHostsValid = (hostname, session) -> true;
            
            // 安装信任所有主机名的HostnameVerifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
            
        } catch (Exception ex) {
            logger.error("禁用SSL验证失败", ex);
        }
    }
}