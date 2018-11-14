package com.dxs.server.utils;

import net.sf.json.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * Created by Mr.Dxs on 2018/10/29.
 */
public class SignAuthUtil {

    public static String createSign(String key, SortedMap<Object, Object> parameters) {
        String sb = new String();
        JSONObject params = new JSONObject();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                params.put(k, v.toString());
            }
        }
        String result = params.toString().replaceAll("]","");
        result = result.replaceAll("\\[","") + key;

        System.out.println(result);
        String sign = MD5Util.MD5Encode(result);
        return sign;
    }


}
