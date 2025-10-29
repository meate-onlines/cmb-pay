package Test.settle;

import Test.DemoConstant;
import Test.MD5Utils;
import Test.SignatureUtil;
import Test.Utils;
import Test.pojo.Pojo;

import Test.unifydemo.GenerateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class SettleBillDownDemo {

    private static final String url = "https://api.cmburl.cn:8065/hou/apiuat/bill/settleBillDownload";

    private static final String appId = "8ab74856-8772-45c9-96db-54cb30ab9f74";

    private static final String appSecret = "5b96f20a-011f-4254-8be8-9a5ceb2f317f";


    public static void main(String args[]){
        //初始化请求参数
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

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


    private static String initRequestParam(){
        //初始化请求参数
        BillUrlVo billUrlVo = new BillUrlVo();
        billUrlVo.setMerId("308999115200075");
        billUrlVo.setBillDate("20200331");
        return GenerateUtil.initRequestParam(billUrlVo);
    }
}

class BillUrlVo extends Pojo {
    String merId;

    String plantformNo;

    String billDate;

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getPlantformNo() {
        return plantformNo;
    }

    public void setPlantformNo(String plantformNo) {
        this.plantformNo = plantformNo;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }
}
