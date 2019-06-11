package com.roncoo.swagger.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @author zenngwei
 * @date 2018/11/25
 * @describe 获取其他服务端接口数据
 */
public class GetData {

    public static void main(String[] args) throws Exception {
//        URL url = new URL("http://localhost/test.php?action=showApacheLogs");
        URL url = new URL("https://emxcxuat.moco.com/emall-miniapp/hkms/sendApi/18514075699");
//        URL url = new URL("https://emxcxuat.moco.com/emall-miniapp/hkms/seach/18514075699");
//        URL url = new URL("https://www.baidu.com/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(10000);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "application/json");
//        conn.setRequestProperty("sessionId", "18514075699:8B338C0BF7B4D980B5033D04311579AA");
        conn.setDoInput(true);
        conn.setDoOutput(true);


        // 输出返回结果
        InputStream input = conn.getInputStream();
        int resLen = 0;
        byte[] res = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while ((resLen = input.read(res)) != -1) {
            sb.append(new String(res, 0, resLen));
        }

        String jsonStr = sb.toString();

        //String转换成Map
        Map<String, Object> map = new Gson().fromJson(jsonStr, new TypeToken<Map<String, Object>>() {
        }.getType());
        System.out.println(map.toString());
    }
}
