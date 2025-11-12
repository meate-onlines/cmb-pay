package com.cmbchina.payment.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * HTTP请求和响应日志打印工具类
 * 用于打印请求和响应的原始数据流
 * 
 * @author CMB Payment SDK Team
 * @version 1.0.0
 * @since 2024-10-29
 */
public class HttpLoggingUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(HttpLoggingUtil.class);
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String SEPARATOR = "============================================";
    
    /**
     * 打印HTTP请求的原始数据流
     * 
     * @param request HTTP请求
     * @param body 请求体
     */
    public static void logRequest(HttpRequest request, byte[] body) {
        if (!logger.isInfoEnabled()) {
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(LINE_SEPARATOR);
        sb.append(SEPARATOR).append(" HTTP REQUEST ").append(SEPARATOR).append(LINE_SEPARATOR);
        
        // 请求方法和URL
        sb.append("Request Method: ").append(request.getMethod()).append(LINE_SEPARATOR);
        sb.append("Request URL: ").append(request.getURI()).append(LINE_SEPARATOR);
        
        // 请求头
        sb.append("Request Headers:").append(LINE_SEPARATOR);
        HttpHeaders headers = request.getHeaders();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(": ");
            List<String> values = entry.getValue();
            if (values.size() == 1) {
                sb.append(values.get(0));
            } else {
                sb.append(values);
            }
            sb.append(LINE_SEPARATOR);
        }
        
        // 请求体
        sb.append("Request Body:").append(LINE_SEPARATOR);
        if (body != null && body.length > 0) {
            String bodyStr = new String(body, StandardCharsets.UTF_8);
            sb.append(bodyStr).append(LINE_SEPARATOR);
        } else {
            sb.append("(empty)").append(LINE_SEPARATOR);
        }
        
        // // 请求体原始字节（十六进制）
        // sb.append("Request Body (Raw Bytes - Hex):").append(LINE_SEPARATOR);
        // if (body != null && body.length > 0) {
        //     sb.append(bytesToHex(body)).append(LINE_SEPARATOR);
        // } else {
        //     sb.append("(empty)").append(LINE_SEPARATOR);
        // }
        
        // sb.append(SEPARATOR).append(LINE_SEPARATOR);
        
        logger.debug(sb.toString());
    }
    
    /**
     * 打印HTTP响应的原始数据流
     * 
     * @param response HTTP响应
     * @param body 响应体
     */
    public static void logResponse(ClientHttpResponse response, byte[] body) {
        if (!logger.isInfoEnabled()) {
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(LINE_SEPARATOR);
        sb.append(SEPARATOR).append(" HTTP RESPONSE ").append(SEPARATOR).append(LINE_SEPARATOR);
        
        // 响应状态
        try {
            sb.append("Response Status: ").append(response.getStatusCode()).append(LINE_SEPARATOR);
            sb.append("Response Status Text: ").append(response.getStatusText()).append(LINE_SEPARATOR);
        } catch (IOException e) {
            sb.append("Response Status: (无法获取)").append(LINE_SEPARATOR);
        }
        
        // 响应头
        sb.append("Response Headers:").append(LINE_SEPARATOR);
        HttpHeaders headers = response.getHeaders();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(": ");
            List<String> values = entry.getValue();
            if (values.size() == 1) {
                sb.append(values.get(0));
            } else {
                sb.append(values);
            }
            sb.append(LINE_SEPARATOR);
        }
        
        // 响应体
        sb.append("Response Body:").append(LINE_SEPARATOR);
        if (body != null && body.length > 0) {
            String bodyStr = new String(body, StandardCharsets.UTF_8);
            sb.append(bodyStr).append(LINE_SEPARATOR);
        } else {
            sb.append("(empty)").append(LINE_SEPARATOR);
        }
        
        // // 响应体原始字节（十六进制）
        // sb.append("Response Body (Raw Bytes - Hex):").append(LINE_SEPARATOR);
        // if (body != null && body.length > 0) {
        //     sb.append(bytesToHex(body)).append(LINE_SEPARATOR);
        // } else {
        //     sb.append("(empty)").append(LINE_SEPARATOR);
        // }
        
        // sb.append(SEPARATOR).append(LINE_SEPARATOR);
        
        logger.debug(sb.toString());
    }
    
    /**
     * 将字节数组转换为十六进制字符串
     * 
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return "";
        }
        
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02X ", b));
            // 每16个字节换行
            if (hex.length() % 48 == 0) {
                hex.append(LINE_SEPARATOR);
            }
        }
        return hex.toString();
    }
    
    /**
     * 创建HTTP日志拦截器
     * 用于自动拦截和打印HTTP请求和响应
     * 
     * @return ClientHttpRequestInterceptor
     */
    public static ClientHttpRequestInterceptor createLoggingInterceptor() {
        return new ClientHttpRequestInterceptor() {
            @Override
            @NonNull
            public ClientHttpResponse intercept(
                    @NonNull HttpRequest request,
                    @NonNull byte[] body,
                    @NonNull ClientHttpRequestExecution execution) throws IOException {
                
                // 打印请求
                logRequest(request, body);
                
                // 执行请求
                ClientHttpResponse response = execution.execute(request, body);
                
                // 读取响应体（需要包装响应以便可以多次读取）
                BufferingClientHttpResponseWrapper bufferedResponse = 
                    new BufferingClientHttpResponseWrapper(response);
                
                // 打印响应
                byte[] responseBody = StreamUtils.copyToByteArray(bufferedResponse.getBody());
                logResponse(bufferedResponse, responseBody);
                
                return bufferedResponse;
            }
        };
    }
    
    /**
     * 缓冲响应包装类，用于多次读取响应体
     */
    private static class BufferingClientHttpResponseWrapper implements ClientHttpResponse {
        private final ClientHttpResponse response;
        private byte[] body;
        
        public BufferingClientHttpResponseWrapper(ClientHttpResponse response) {
            this.response = response;
        }
        
        @Override
        @NonNull
        public HttpStatusCode getStatusCode() throws IOException {
            return response.getStatusCode();
        }
        
        @Override
        @SuppressWarnings("deprecation")
        public int getRawStatusCode() throws IOException {
            return response.getRawStatusCode();
        }
        
        @Override
        @NonNull
        public String getStatusText() throws IOException {
            return response.getStatusText();
        }
        
        @Override
        public void close() {
            response.close();
        }
        
        @Override
        @NonNull
        public InputStream getBody() throws IOException {
            if (body == null) {
                body = StreamUtils.copyToByteArray(response.getBody());
            }
            return new java.io.ByteArrayInputStream(body);
        }
        
        @Override
        @NonNull
        public HttpHeaders getHeaders() {
            return response.getHeaders();
        }
    }
}

