package Test.unifydemo;

import Test.DemoConstant;
import Test.MD5Utils;
import Test.SignatureUtil;
import Test.Utils;
import Test.pojo.Pojo;
import Test.pojo.wechat.WechatRefundQueryVo;
import Test.sm2.SM2Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static Test.DemoConstant.appId;
import static Test.DemoConstant.appSecret;

public class WechatRefundQueryDemo {

    private static final Logger LOGGER = Logger.getLogger(WechatRefundQueryDemo.class);

    private static final String url = "https://api.cmburl.cn:8065/polypay/v1.0/mchorders/refundquery" ;

    public static void main(String []args){
        //初始化请求报文
        String requestString = initRequestParam();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String,String> requestMap = objectMapper.readValue(requestString,Map.class);

            long currentTimeMills = System.currentTimeMillis() / 1000;

            //对请求报文进行加密
            Map<String,String> apiEncMap = new HashMap<>();
            apiEncMap.put("appid",appId);
            apiEncMap.put("secret",appSecret);
            apiEncMap.put("sign",requestMap.get(DemoConstant.SIGN));
            apiEncMap.put("timestamp",""+currentTimeMills);

            //MD5加密
            String MD5Content = SignatureUtil.getSignContent(apiEncMap);
            String apiEncString = MD5Utils.getMD5Content(MD5Content).toLowerCase();

            //组请求报文头
            Map<String,String> requstHeader = new HashMap<>();
            requstHeader.put("appid",appId);
            requstHeader.put("timestamp",""+currentTimeMills);
            requstHeader.put("apisign",apiEncString);

            //发送http请求
            Map<String,String> responseMap = Utils.postForEntity(url,requestString,requstHeader);
            //处理响应报文
            GenerateUtil.handleResponse(responseMap);

            return;

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static  String initRequestParam(){
        WechatRefundQueryVo wechatRefundQueryVo = new WechatRefundQueryVo();
        wechatRefundQueryVo.setMerId("3089991074200KV");
        wechatRefundQueryVo.setCmbOrderId("003220030617423310398695");
        return initRequestParam(wechatRefundQueryVo);
    }

    public static String initRequestParam(Pojo pojo){

        //设置公共请求参数
        Map<String,String> resultPublicParam = new HashMap<>();
        resultPublicParam.put(DemoConstant.VERSION,DemoConstant.VERSION_VALUE);
        resultPublicParam.put(DemoConstant.ENCODING,DemoConstant.ENCODING_VALUE);
        resultPublicParam.put(DemoConstant.SIGN_METHOD, "02");

        //初始化业务请求参数

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String bizContent = objectMapper.writeValueAsString(pojo);
            System.out.println(bizContent);
            resultPublicParam.put(DemoConstant.BIZ_CONTENT,bizContent);

            //对待加签内容进行排序拼接
            String signStr = SignatureUtil.getSignContent(resultPublicParam);
            //加签
            String sign = SM2Util.sm2Sign(signStr, DemoConstant.privateKey);

            resultPublicParam.put(DemoConstant.SIGN,sign);

            String requestStr  = objectMapper.writeValueAsString(resultPublicParam);
            LOGGER.info("加签后的报文内容：" + requestStr);
            return requestStr;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

}
