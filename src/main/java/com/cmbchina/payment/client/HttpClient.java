package com.cmbchina.payment.client;

import com.cmbchina.payment.config.PaymentConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * HTTP客户端
 */
public class HttpClient {
    
    private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);
    
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;
    private final PaymentConfig config;
    
    public HttpClient(PaymentConfig config) {
        this.config = config;
        this.objectMapper = new ObjectMapper();
        this.client = new OkHttpClient.Builder()
                .connectTimeout(config.getConnectTimeout(), TimeUnit.MILLISECONDS)
                .readTimeout(config.getReadTimeout(), TimeUnit.MILLISECONDS)
                .writeTimeout(config.getReadTimeout(), TimeUnit.MILLISECONDS)
                .build();
    }
    
    /**
     * 发送POST请求
     */
    public <T> T post(String url, Object request, Class<T> responseClass) {
        try {
            String json = objectMapper.writeValueAsString(request);
            logger.debug("发送请求: {}", json);
            
            RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
            Request httpRequest = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .build();
            
            try (Response response = client.newCall(httpRequest).execute()) {
                if (!response.isSuccessful()) {
                    throw new RuntimeException("HTTP请求失败: " + response.code() + " " + response.message());
                }
                
                String responseBody = response.body().string();
                logger.debug("收到响应: {}", responseBody);
                
                return objectMapper.readValue(responseBody, responseClass);
            }
            
        } catch (IOException e) {
            logger.error("HTTP请求异常", e);
            throw new RuntimeException("HTTP请求异常", e);
        }
    }
    
    /**
     * 发送GET请求
     */
    public <T> T get(String url, Class<T> responseClass) {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("Accept", "application/json")
                    .build();
            
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new RuntimeException("HTTP请求失败: " + response.code() + " " + response.message());
                }
                
                String responseBody = response.body().string();
                logger.debug("收到响应: {}", responseBody);
                
                return objectMapper.readValue(responseBody, responseClass);
            }
            
        } catch (IOException e) {
            logger.error("HTTP请求异常", e);
            throw new RuntimeException("HTTP请求异常", e);
        }
    }
    
    /**
     * 关闭客户端
     */
    public void close() {
        client.dispatcher().executorService().shutdown();
        client.connectionPool().evictAll();
    }
}