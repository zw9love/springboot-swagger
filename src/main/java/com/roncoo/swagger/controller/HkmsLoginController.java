package com.roncoo.swagger.controller;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.swagger.bean.SwaggerResponse.ResponseResult;
import com.roncoo.swagger.util.MyUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author zenngwei
 * @date 2018/6/25
 */

//@Api(value = "SayController|一个用来测试swagger注解的控制器", description = "用户接口")
@Api(description = "hkms登录")
@RestController
@RequestMapping("/emall-miniapp/hkms")
public class HkmsLoginController {

    //    @ApiOperation(value="修改用户密码", notes="根据用户id修改密码")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="query", name = "userId", value = "用户ID", required = true, dataType = "Integer"),
//            @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType="query", name = "newPassword", value = "新密码", required = true, dataType = "String")
//    })
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "vilidCode", value = "验证码", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sessionId", value = "sessionId", required = true, paramType = "header", dataType = "String"),
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResult post(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String phone = request.getParameter("phone");
        String vilidCode = request.getParameter("vilidCode");
        JSONObject json = MyUtil.getHttpData("https://emxcxuat.moco.com/emall-miniapp/hkms/login?phone=" + phone + "&vilidCode=" + vilidCode, "", "POST");
        return new ResponseResult(200, json.getString("message"));
    }
}
