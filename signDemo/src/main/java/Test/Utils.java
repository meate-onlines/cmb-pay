package Test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;


public class Utils {

    static {
        disableSslVerification();
    }

    private static void disableSslVerification() {
        try
        {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };
            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }


    public static Map<String, String> postForEntity(String url,String requestBody, Map<String, String> apiHeader){
        RestTemplate client = getRestTemplate();
        client.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        HttpHeaders headers = getHttpHeaders();

        // 以json的方式提交
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("appid", apiHeader.get("appid"));
        headers.add("timestamp", apiHeader.get("timestamp"));
        headers.add("apisign", apiHeader.get("apisign"));

        // 将请求头部和参数合成一个请求
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        // 执行HTTP请求
        Map<String,String> response = client.postForEntity(url,requestEntity,Map.class).getBody();

        return response;
    }

    public static RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static HttpHeaders getHttpHeaders(){
        return new HttpHeaders();
    }

}
