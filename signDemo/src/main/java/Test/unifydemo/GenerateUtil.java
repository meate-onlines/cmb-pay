package Test.unifydemo;

import Test.DemoConstant;
import Test.SignatureUtil;
import Test.pojo.Pojo;
import Test.sm2.SM2Util;
import Test.sm2.test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

//构造请求报文工具类
public class GenerateUtil {

    private static final Logger LOGGER = Logger.getLogger(GenerateUtil.class);


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

    /**
     * 处理响应报文
     * @param responseMap
     * @return
     */
    public static void handleResponse(Map<String,String> responseMap){

        if( null == responseMap){
            LOGGER.equals("响应的内容为空");
            return ;
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            LOGGER.info("收到响应的内容为：" + objectMapper.writeValueAsString(responseMap));
            //验签
            String sign = responseMap.remove(DemoConstant.SIGN);
            //生成验签字符串
            String signStr = SignatureUtil.getSignContent(responseMap);
            boolean flag = SM2Util.sm2Check(signStr,sign, DemoConstant.publicKey);
            if( flag ){
                LOGGER.info("验签成功！");
            } else {
                LOGGER.error("验签失败！");
            }
            return;

        }catch (Exception ex){
            LOGGER.equals("系统异常");
            return;
        }
    }


}
