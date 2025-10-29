package Test.unifydemo;

import Test.DemoConstant;
import Test.MD5Utils;
import Test.SignatureUtil;
import Test.Utils;

import Test.pojo.wechat.WechatPayQueryVo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import static Test.DemoConstant.appId;
import static Test.DemoConstant.appSecret;

/**
 * 统一收单支付结果查询demo
 */
public class WechatPayQueryDemo {

    private static final String url = "https://api.cmburl.cn:8065/polypay/v1.0/mchorders/orderquery" ;

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

    private static String initRequestParam(){

        //初始化业务请求参数
        WechatPayQueryVo wechatPayQueryVo = new WechatPayQueryVo();
        wechatPayQueryVo.setMerId("3089991074200KV");
        wechatPayQueryVo.setOrderId("dev20190215001812110");
        return GenerateUtil.initRequestParam(wechatPayQueryVo);
    }
}
