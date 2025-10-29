package com.cmb.notify.util;


import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SignatureUtil {

    public SignatureUtil() {
    }


    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            if (null != key && null != value) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }

    public static String decode(String str) {
        String result = null;
        if (str != null) {
            try {
                result = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException var4) {
                throw new RuntimeException(var4);
            }
        }
        return result;
    }
}
