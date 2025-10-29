package Test.sm2;

import Test.SignatureUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class test {

    public static final String privateKey = "D5F2AFA24E6BA9071B54A8C9AD735F9A1DE9C4657FA386C09B592694BC118B38";
    public static final String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE1xPq3B3Cw2U+t+R7Fb0JCJvy87/LDbUDFilGjkQU89VLl57pbUPLKUwP2jnAyOEKmJS9USsz+VwXNd4/bjdIFA==";

    public static void main(String[] args) throws IOException {
        //加签
        String str = "{\"biz_content\":\"{\\\"orderId\\\": \\\"STtest0519080001TESTABAB1\\\", \\\"body\\\": \\\"\\\\u5355\\\\u7b14\\\\u652f\\\\u4ed8body\\\", \\\"mchReserved\\\": \\\"\\\\u5355\\\\u7b14\\\\u652f\\\\u4ed8\\\\u5546\\\\u6237\\\\u4fdd\\\\u7559\\\\u57df\\\", \\\"notifyUrl\\\": \\\"http://99.12.95.160:30040/mch/api/notifyYTH\\\", \\\"currencyCode\\\": \\\"156\\\", \\\"userId\\\": \\\"N003525987\\\", \\\"payValidTime\\\": null, \\\"tradeScene\\\": \\\"OFFLINE\\\", \\\"serviceFee\\\": \\\"111\\\", \\\"termId\\\": \\\"00000001\\\", \\\"txnAmt\\\": \\\"1111\\\", \\\"plantformNo\\\": \\\"308999170120FWX\\\", \\\"merId\\\": \\\"308999170120FWY\\\"}\",\"encoding\":\"UTF-8\",\"signMethod\":\"02\",\"version\":\"0.0.1\",\"sign\":\"MEUCIQDbGeUpR00VA7vUdHDcukYd9pyDsWjQ+tOpRJcOoMYd2AIgPdhcIT+1bDaoAetsbhHEIpPt0Dy3D+PFk1FCPt03HuI=\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,String> requestMap = objectMapper.readValue(str,Map.class);
        requestMap.remove("sign");
        String signContent = SignatureUtil.getSignContent(requestMap);
        String sign = SM2Util.sm2Sign(signContent,privateKey);
        requestMap.put("sign",sign);
        System.out.println(objectMapper.writeValueAsString(requestMap));
        //验签
        String repsStr = objectMapper.writeValueAsString(requestMap);
        Map<String,String> respMap = objectMapper.readValue(repsStr,Map.class);
        String respSign = respMap.remove("sign");
        String respSignContent = SignatureUtil.getSignContent(respMap);
        System.out.println("验签结果："+SM2Util.sm2Check(respSignContent,respSign,publicKey));

    }
}
