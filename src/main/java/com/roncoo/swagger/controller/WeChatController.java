package com.roncoo.swagger.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.roncoo.swagger.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @author zenngwei
 * @date 2019/5/29
 */

@RestController
public class WeChatController {

    private String secret = "d563be8658e442254b96a8a2b298f58d";
    private String appid = "wxc7e05fdbd8394b0c";


    // https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc7e05fdbd8394b0c&secret=d563be8658e442254b96a8a2b298f58d
    @RequestMapping("/getPath")
    @ResponseBody
    public void getPath(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpURLConnection tokenConn = (HttpURLConnection) new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret).openConnection();
        tokenConn.setConnectTimeout(10000);
        tokenConn.setRequestMethod("GET");
        tokenConn.setDoInput(true);
        tokenConn.setDoOutput(true);


        // 输出返回结果
        InputStream input1 = tokenConn.getInputStream();
        int resLen1 = 0;
        byte[] res1 = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while ((resLen1 = input1.read(res1)) != -1) {
            sb.append(new String(res1, 0, resLen1));
        }

        String jsonStr = sb.toString();

        //String转换成Map
        Map<String, Object> map = new Gson().fromJson(jsonStr, new TypeToken<Map<String, Object>>() {
        }.getType());


        String ACCESS_TOKEN = (String) map.get("access_token");

        URL url = new URL("https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=" + ACCESS_TOKEN);
        String path = request.getParameter("path");
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("path", path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(10000);
        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Charset", "utf-8");
        conn.setDoInput(true);
        conn.setDoOutput(true);

        OutputStream out = new DataOutputStream(conn.getOutputStream());
        // 写入请求的字符串  
        out.write((jsonParam.toString()).getBytes());
        out.flush();
        out.close();
        // 输出返回结果
//        System.out.println(conn.getResponseCode());
//        if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
        InputStream input = conn.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("code.png");
        int resLen = 0;
        byte[] res = new byte[1024];
//            StringBuilder sb = new StringBuilder();
        while ((resLen = input.read(res)) != -1) {
//                sb.append(new String(res, 0, resLen));
            fileOutputStream.write(res, 0, resLen);
        }

        input.close();
        fileOutputStream.close();

        File file = new File("code.png");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        response.setContentType("image/png");
//            return bytes;
        OutputStream out1 = response.getOutputStream();
        out1.write(bytes);
        out1.flush();
        //关闭响应输出流
        out1.close();

    }

    public static void main(String[] args) throws Exception {
        String ACCESS_TOKEN = "22_fwXJswKwyp_zVljyB2hGSwnMklZJcdOTUj6tLYxOwkeMqQmjMpfQ29gw6UtqWF0BZ1_z-eE832bs5oKS2u8SjIH9U2PMwPGK5bexcOqq1KzYSXUamrBQaF082-_7ASX919lpqQxpzJr6E3IAWKAfABAQEU";
//        return MyUtil.getHttpData("https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=" + ACCESS_TOKEN, "", "POST");

        URL url = new URL("https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=" + ACCESS_TOKEN);

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("path", "pages/index/index");
//        jsonParam.put("width", 600);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(10000);
        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Charset", "utf-8");
        conn.setDoInput(true);
        conn.setDoOutput(true);

        OutputStream out = new DataOutputStream(conn.getOutputStream());
        // 写入请求的字符串  
        out.write((jsonParam.toString()).getBytes());
        out.flush();
        out.close();
        // 输出返回结果
//        System.out.println(conn.getResponseCode());
        if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
            InputStream input = conn.getInputStream();
            System.out.println("当前路径：" + new File(".").getAbsolutePath());
            FileOutputStream fileOutputStream = new FileOutputStream("code.png");
            int resLen = 0;
            byte[] res = new byte[1024];
            StringBuilder sb = new StringBuilder();
            while ((resLen = input.read(res)) != -1) {
                sb.append(new String(res, 0, resLen));
                fileOutputStream.write(res, 0, resLen);
            }

            input.close();
            fileOutputStream.close();
            System.out.println("成功！");
//            return sb.toString();
//            StringBuffer sb = new StringBuffer();
//            String readLine = "";
//            BufferedReader responseReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//            while ((readLine = responseReader.readLine()) != null) {
//                sb.append(readLine).append("\n");
//            }
//            responseReader.close();
//            return sb.toString();
        } else {

        }
    }

}
