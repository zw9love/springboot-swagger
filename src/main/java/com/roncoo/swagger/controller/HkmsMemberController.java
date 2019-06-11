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
//@RequestMapping("/emall-miniapp/hkms")
public class HkmsMemberController {
    @RequestMapping("/emall-miniapp/hkms/seach/{phone}")
    public JSONObject searchInfo(@PathVariable String phone, HttpServletRequest request, HttpServletResponse response)  throws Exception {
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/hkms/seach/" + phone, request.getHeader("sessionId"), "POST");
    }

    @RequestMapping("/emall-miniapp/hkms/getCountry")
    public JSONObject getCountry(HttpServletRequest request, HttpServletResponse response)  throws Exception {
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/hkms/getCountry", request.getHeader("sessionId"), "GET");
    }

    @RequestMapping("/emall-miniapp/hkms/getProvince/{code}/{pageNo}")
    public JSONObject getProvince(@PathVariable String code, @PathVariable String pageNo, HttpServletRequest request, HttpServletResponse response)  throws Exception {
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/hkms/getProvince/" + code + "/" + pageNo, request.getHeader("sessionId"), "GET");
    }

    @RequestMapping("/emall-miniapp/hkms/couponSearch/{phone}/{brandId}")
    public JSONObject couponSearch(@PathVariable String phone, @PathVariable String brandId, HttpServletRequest request, HttpServletResponse response)  throws Exception {
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/hkms/couponSearch/" + phone + "/" + brandId, request.getHeader("sessionId"), "POST");
    }

    @RequestMapping("/emall-miniapp/moco/member/getPointInfo/{phone}")
    public JSONObject getPointInfo(@PathVariable String phone, HttpServletRequest request, HttpServletResponse response)  throws Exception {
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/moco/member/getPointInfo/" + phone, request.getHeader("sessionId"), "GET");
    }

    @RequestMapping("/emall-miniapp/hkms/myCard/{phone}/{brandId}")
    public JSONObject myCard(@PathVariable String phone, @PathVariable String brandId, HttpServletRequest request, HttpServletResponse response)  throws Exception {
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/hkms/myCard/" + phone + "/" + brandId, request.getHeader("sessionId"), "GET");
    }

    @RequestMapping("/emall-miniapp/hkms/svipcode/{phone}")
    public JSONObject svipcode(@PathVariable String phone, HttpServletRequest request, HttpServletResponse response)  throws Exception {
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/hkms/svipcode/" + phone, request.getHeader("sessionId"), "GET");
    }

    @RequestMapping("/emall-miniapp/moco/member/getPointRedeemCouponInfo/{phone}/{brandId}")
    public JSONObject getPointRedeemCouponInfo(@PathVariable String phone, @PathVariable String brandId, HttpServletRequest request, HttpServletResponse response)  throws Exception {
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/moco/member/getPointRedeemCouponInfo/" + phone + "/" + brandId, request.getHeader("sessionId"), "GET");
    }

    @RequestMapping("/emall-miniapp/moco/member/pointChangeData/{phone}/{count}")
    public JSONObject pointChangeData(@PathVariable String phone, @PathVariable String count, HttpServletRequest request, HttpServletResponse response)  throws Exception {
        String pagecookie = request.getParameter("pagecookie");
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/moco/member/pointChangeData/" + phone + "/" + count + "?pagecookie=" + pagecookie, request.getHeader("sessionId"), "GET");
    }

    @RequestMapping("/emall-miniapp/hkms/updateMember/{phone}")
    public JSONObject updateMember(@PathVariable String phone, HttpServletRequest request, HttpServletResponse response)  throws Exception {
        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        String industry = request.getParameter("industry");
        String occupation = request.getParameter("occupation");
        String interest = request.getParameter("interest");
        String lmname = request.getParameter("lmname");
        String lmnickname = request.getParameter("lmnickname");
        String lmbirthday = request.getParameter("lmbirthday");
        String lmsex = request.getParameter("lmsex");
        String lminterest = request.getParameter("lminterest");
        String lmbrothersister = request.getParameter("lmbrothersister");
        String preferredcommethod = request.getParameter("preferredcommethod");
        String preferredlanguage = request.getParameter("preferredlanguage");
        String brandConnect = request.getParameter("brandConnect");
        String channelConnect = request.getParameter("channelConnect");
        String countryid = request.getParameter("countryid");
        String provinceid = request.getParameter("provinceid");
        String addressdetail = request.getParameter("addressdetail");
        String nonemessage = request.getParameter("nonemessage");
        String sharename = request.getParameter("sharename");
        String sharetelephone = request.getParameter("sharetelephone");
        String sharebirthday = request.getParameter("sharebirthday");
        String str = "";
        if(fullname != null){
            str += "&fullname=" + fullname;
        }
        if(gender != null){
            str += "&gender=" + gender;
        }
        if(birthday != null){
            str += "&birthday=" + birthday;
        }
        if(email != null){
            str += "&email=" + email;
        }
        if(age != null){
            str += "&age=" + age;
        }
        if(industry != null){
            str += "&industry=" + industry;
        }
        if(occupation != null){
            str += "&occupation=" + occupation;
        }
        if(interest != null){
            str += "&interest=" + interest;
        }
        if(lmname != null){
            str += "&lmname=" + lmname;
        }
        if(lmnickname != null){
            str += "&lmnickname=" + lmnickname;
        }
        if(lmbirthday != null){
            str += "&lmbirthday=" + lmbirthday;
        }
        if(lmsex != null){
            str += "&lmsex=" + lmsex;
        }
        if(lminterest != null){
            str += "&lminterest=" + lminterest;
        }
        if(lmbrothersister != null){
            str += "&lmbrothersister=" + lmbrothersister;
        }
        if(preferredcommethod != null){
            str += "&preferredcommethod=" + preferredcommethod;
        }
        if(preferredlanguage != null){
            str += "&preferredlanguage=" + preferredlanguage;
        }
        if(brandConnect != null){
            str += "&brandConnect=" + brandConnect;
        }
        if(channelConnect != null){
            str += "&channelConnect=" + channelConnect;
        }
        if(countryid != null){
            str += "&countryid=" + countryid;
        }
        if(provinceid != null){
            str += "&provinceid=" + provinceid;
        }
        if(addressdetail != null){
            str += "&addressdetail=" + addressdetail;
        }
        if(nonemessage != null){
            str += "&nonemessage=" + nonemessage;
        }
        if(sharename != null){
            str += "&sharename=" + sharename;
        }
        if(sharetelephone != null){
            str += "&sharetelephone=" + sharetelephone;
        }
        if(sharebirthday != null){
            str += "&sharebirthday=" + sharebirthday;
        }
        return MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/hkms/updateMember/" + phone + "?" + str, request.getHeader("sessionId"), "POST");
    }
}
