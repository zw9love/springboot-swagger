package com.roncoo.swagger.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.swagger.bean.User;
import com.roncoo.swagger.mapper.UserRowMapper;
import com.roncoo.swagger.util.MD5Util;
import com.roncoo.swagger.validator.LoginValidator;
import com.roncoo.swagger.util.MyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author zengwei
 */
//@RestController
//@RequestMapping(value = "/login")
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/demo")
    public String getTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "demo";
    }

    @RequestMapping("login")
    public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        logger.info("这里是LoginController的index方法");
        logger.info("=======================");
        logger.info("=========Login=========");
        logger.info("=======================");
//        request.getRequestDispatcher("login.html").forward(request, response);
        return "index";
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("status", 200);
//        map.put("msg", "成功");
//        map.put("data", null);
//        return map;
    }


//    @RequestMapping(value = "/login/dologin")
//    public HashMap<String, Object> doLogin(){
//        System.out.println("进来doLogin方法了");
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("status", 200);
//        map.put("msg", "成功");
//        map.put("data", null);
//        return map;
//    }

    //    @RequestMapping(value = "/login/dologin")
    @RequestMapping("/login/dologin")
    @ResponseBody
    public JSONObject doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println("进来doLogin方法了");
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        Map<String, Object> json = MyUtil.getJsonData(request);
        JSONObject jsonObj;
        JSONObject checkObj = new LoginValidator().dologinValidate(json);
        if (checkObj.getInteger("status").equals(200)) {
            String loginName = json.get("login_name").toString();
            String loginPwd = MD5Util.encrypt(json.get("login_pwd").toString());
            Object[] params = new Object[]{loginName, loginPwd};
            logger.info("login_name = " + loginName);
            logger.info("login_pwd = " + loginPwd);
//            String sql = " SELECT * FROM common_user where login_name = ? and login_pwd = ? ";
            String sql = "select zh_names, user.ids, user.email, user.login_name, user.username, user.phone, user.status, user.role_ids " +
                    "from (select * from common_user where login_name = ? and login_pwd = ? ) as user " +
                    "inner join common_role  as role on user.role_ids = role.ids";
            List<User> list = jdbcTemplate.query(sql, params, new UserRowMapper());
            if (list.size() > 0) {
                JSONObject obj = new JSONObject();
                String userLoginName = list.get(0).getLogin_name();
                String userName = list.get(0).getUsername();
                String ids = list.get(0).getIds();
                String roleIds = list.get(0).getRole_ids();
                System.out.println("roleIds = " + roleIds);
                int expireTime = MyUtil.getRefreshTime();
                obj.put("login_name", userLoginName);
                obj.put("username", userName);
                obj.put("ids", ids);
                obj.put("roleIds", roleIds);
                obj.put("expireTime", expireTime);
                HttpSession session = request.getSession();
                String token = MyUtil.getRandomString();
                session.setAttribute(token, obj);
                session.setAttribute(userLoginName, token);
                response.setHeader("token", token);
                jsonObj = MyUtil.getJson("成功", 200, null);
            } else
                jsonObj = MyUtil.getJson("用户名或密码错误", 606, null);
//        response.getWriter().write(jsonObj.toString());
        } else {
            jsonObj = MyUtil.getJson(checkObj.getString("msg"), 606, null);
        }

        return jsonObj;
    }

    @RequestMapping("/login/loged")
    @ResponseBody
    public JSONObject loged(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Map<String, Object> json = MyUtil.getJsonData(request);
        String token = (String) json.get("token");
        JSONObject role = (JSONObject) session.getAttribute(token);
        JSONObject roleObj = new JSONObject();
        roleObj.put("role", role);
        JSONObject jsonObj;
        if (role == null) {
            jsonObj = MyUtil.getJson("失败", 606, "");
            IndexController.setLoginActive(false);
        } else {
            jsonObj = MyUtil.getJson("成功", 200, roleObj);
            IndexController.setLoginActive(true);
        }
        return jsonObj;
    }

}
