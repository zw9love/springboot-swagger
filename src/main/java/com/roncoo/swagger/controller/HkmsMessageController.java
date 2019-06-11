package com.roncoo.swagger.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.roncoo.swagger.util.MyUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zenngwei
 * @date 2018/6/25
 */

@RestController
@RequestMapping("/emall-miniapp/hkms")
public class HkmsMessageController {
    @RequestMapping("/sendApi/{phone}")
    public JSONObject post(@PathVariable String phone, HttpServletRequest request, HttpServletResponse response)  throws Exception {
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/hkms/sendApi/" + phone, "", "POST");
    }

    @RequestMapping("/sendOverseasMsg/{phone}")
    public JSONObject sendOverseasMsg(@PathVariable String phone, HttpServletRequest request, HttpServletResponse response)  throws Exception {
        String phoneCode = request.getParameter("phoneCode");
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/hkms/sendOverseasMsg/" + phone + "?phoneCode" + phoneCode, "", "POST");
    }
}
