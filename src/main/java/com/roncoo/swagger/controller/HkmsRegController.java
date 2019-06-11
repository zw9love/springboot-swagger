package com.roncoo.swagger.controller;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.swagger.util.MyUtil;
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
public class HkmsRegController {
    @RequestMapping("/registerMember")
    public JSONObject post(HttpServletRequest request, HttpServletResponse response)  throws Exception {
        String recruitBrandId = request.getParameter("recruitBrandId");
        String storeId = request.getParameter("storeId");
        String empId = request.getParameter("empId");
        String mobilephonecode = request.getParameter("mobilephonecode");
        String mobilephone = request.getParameter("mobilephone");
        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String preferredcommethod = request.getParameter("preferredcommethod");
        String preferredlanguage = request.getParameter("preferredlanguage");
        String brandConnect = request.getParameter("brandConnect");
        String channelConnect = request.getParameter("channelConnect");
        String nonemessage = request.getParameter("nonemessage");
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/hkms/registerMember?recruitBrandId=" + recruitBrandId + "&storeId=" + storeId + "&empId=" + empId + "&mobilephonecode=" + mobilephonecode + "&mobilephone=" + mobilephone + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&email=" + email + "&preferredcommethod=" + preferredcommethod + "&preferredlanguage=" + preferredlanguage + "&brandConnect=" + brandConnect + "&channelConnect=" + channelConnect + "&nonemessage=" + nonemessage, request.getHeader("sessionId"), "POST");
    }
}
