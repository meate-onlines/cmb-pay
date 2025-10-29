package Test;


import org.apache.tomcat.util.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SignatureUtil {

    public SignatureUtil() {
    }

    public static String rsaSign(String content, String privateKey, String charset) throws Exception {
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initSign(priKey);
            if (null==charset||charset.length()==0) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            byte[] signed = signature.sign();
            return new String(Base64.encodeBase64(signed));
        } catch (Exception var6) {
            throw new RuntimeException("RSAcontent = " + content + "; charset = " + charset, var6);
        }
    }

    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, InputStream ins) throws Exception {
        if (ins != null && null!=algorithm&&algorithm.length()!=0) {
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            byte[] encodedKey= Base64.decodeBase64( copyToString(ins, Charset.forName("UTF-8")));
            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
        } else {
            return null;
        }
    }

    public static String copyToString(InputStream in, Charset charset) throws IOException {
        if (in == null) {
            return "";
        } else {
            StringBuilder out = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, charset);
            char[] buffer = new char[4096];

            int bytesRead;
            while((bytesRead = reader.read(buffer)) != -1) {
                out.append(buffer, 0, bytesRead);
            }

            return out.toString();
        }
    }

    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            if (null!=key&&null!=value) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }

    public static boolean rsaCheck(String content, String sign, String publicKey, String charset) throws Exception {
        try {
            PublicKey pubKey = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(pubKey);
            if (null==charset||charset.length()==0) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception var6) {
            throw new RuntimeException("RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, var6);
        }
    }

    public static PublicKey getPublicKeyFromX509(String algorithm, InputStream ins) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        byte[] encodedKey =  Base64.decodeBase64(copyToString(ins, Charset.forName("UTF-8")));
        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }


}
