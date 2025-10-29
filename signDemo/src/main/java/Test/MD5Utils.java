package Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /**
     * MD5加密
     *
     * @param input
     * @return
     */
    public static String getMD5Content(String input){
        try {
            // 拿到MD转换器
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            byte[] inputByteArray = input.getBytes();
            messageDigest.update(inputByteArray);

            byte[] resultByteArray = messageDigest.digest();

            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将字节数组转换成16进组的字符串
     *
     * @param byteArray
     * @return
     */
    public static String byteArrayToHex(byte[] byteArray){
        // 初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        char[] resultCharArray = new char[byteArray.length * 2];

        int index = 0;
        // 遍历字节数组，通过位运算，转换成字符放到字符数据中
        for (byte b : byteArray){
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }

        return new String(resultCharArray);
    }
}
