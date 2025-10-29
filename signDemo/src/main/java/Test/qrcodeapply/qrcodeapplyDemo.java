package Test.qrcodeapply;

import Test.DemoConstant;
import Test.sm2.SM2Util;
import Test.sm2.test;
import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static Test.DemoConstant.appId;
import static Test.DemoConstant.appSecret;

public class qrcodeapplyDemo {

    private static final String url = "https://api.cmburl.cn:8065/polypay/v1.0/mchorders/qrcodeapply";  //UAT

    private static final String notifyUrl = "https://www.baidu.com";

    public static void main(String[] args){
        // 组装requestBody并加签
        String signResult= signMethod();
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String,String> signResultMap = mapper.readValue(signResult, Map.class);

            long currentTimeMills = System.currentTimeMillis() / 1000;

            // 组apiSign加密Map
            Map<String,String> apiSign = new TreeMap<>();
            apiSign.put("appid", appId);
            apiSign.put("secret", appSecret);
            apiSign.put("sign", signResultMap.get("sign"));
            apiSign.put("timestamp", "" + currentTimeMills);

            // MD5加密
            String MD5Content = Test.SignatureUtil.getSignContent(apiSign);
            String apiSignString = Test.MD5Utils.getMD5Content(MD5Content).toLowerCase();

            // 组request头部Map
            Map<String, String> apiHeader = new HashMap<>();
            apiHeader.put("appid", appId);
            apiHeader.put("timestamp", "" + currentTimeMills);
            apiHeader.put("apisign", apiSignString);

            // 发送HTTP post请求
            Map<String,String> response = Test.Utils.postForEntity(url, signResult, apiHeader);

            System.out.println(mapper.writeValueAsString(response));
            // 返回结果验签
            Boolean checkResult1 = checkSign(mapper.writeValueAsString(response));
            if(!checkResult1){
                return;
            }

            String success = response.get("returnCode");
            System.out.println("返回结果：" + success);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }

    private static String signMethod(){
        Map<String, String> requestPublicParams = new TreeMap<>();
        String requestStr = null;
        try {
            //公共请求参数
            requestPublicParams.put("version", "0.0.1");    //版本号，固定为0.0.1(必传字段)
            requestPublicParams.put("encoding", "UTF-8");   //编码方式，固定为UTF-8(必传)
            requestPublicParams.put("signMethod", "02");    //签名方法，固定为02，表示签名方式为国密(必传)
            //业务要素
            Map<String, String> requestTransactionParams = new HashMap<>();
            requestTransactionParams.put("body", "聚合支付测试");   //商户号(必传)
            requestTransactionParams.put("currencyCode", "156");    //交易币种，默认156，目前只支持人民币（156）
            requestTransactionParams.put("merId", "3089991074200KV");   //商户号(必传)
            requestTransactionParams.put("notifyUrl", notifyUrl);  //交易通知地址(必传)
            requestTransactionParams.put("orderId", "" + System.currentTimeMillis()); //商户订单号(必传)
            requestTransactionParams.put("payValidTime", "1200"); //支付有效时间
            requestTransactionParams.put("termId", "00774411");  //终端号
            requestTransactionParams.put("txnAmt", "1405");  //交易金额,单位为分(必传)
            requestTransactionParams.put("userId", "N003363806");   //收银员
            requestTransactionParams.put("tradeScene", "OFFLINE");   //交易场景
            ObjectMapper mapper = new ObjectMapper();
            requestPublicParams.put("biz_content", mapper.writeValueAsString(requestTransactionParams));

            System.out.println("加签前的报文内容：" + mapper.writeValueAsString(requestPublicParams));

            //对待加签内容进行排序拼接
            String signContent= Test.SignatureUtil.getSignContent(requestPublicParams);
            //加签
            requestPublicParams.put("sign", SM2Util.sm2Sign(signContent, test.privateKey));

            requestStr = mapper.writeValueAsString(requestPublicParams);

            System.out.println("加签后的报文内容：" + requestStr);
            return requestStr;

        }catch (Exception e){
            System.out.println("加签发生异常！");
            e.printStackTrace();
            return requestStr;
        }
    }

    private static Boolean checkSign(String string){
        System.out.println("要验签的报文内容：" + string);
        try {
            //验签
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> responseBodyMap = objectMapper.readValue(string, Map.class);
            String sign = responseBodyMap.remove("sign");
            String contentStr = Test.SignatureUtil.getSignContent(responseBodyMap);
            boolean result = SM2Util.sm2Check(contentStr,sign, DemoConstant.publicKey);

            if (result) {
                System.out.println("报文验签成功!");
            } else {
                System.out.println("报文验签失败!");
            }
            return result;
        }catch (Exception e){
            System.out.println("验签发生异常！");
            e.printStackTrace();
            return false;
        }
    }
}
