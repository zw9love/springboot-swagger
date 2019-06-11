package com.roncoo.swagger.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.swagger.bean.Menu;
import com.roncoo.swagger.util.MyUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author zenngwei
 * @date 2018/02/26 16:06
 */
@RestController
@RequestMapping("/menu")
public class BeeeyeMenuController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    private static String resource = "mybatis.cfg.xml";

    static {
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping("get")
//    public JSONObject get(HttpServletRequest request, HttpServletResponse response) throws JSONException {
//        // select * from common_menu where  names in (select record_hash from common_module_role where role_ids = '0' )
//        // select  lmr.ids as idss,common_menu.ids as ids, names, level, parent_ids, lmr.read r, lmr.write  w, url, icon   from common_menu " +
//        //                "left join common_module_role as lmr on lmr.module_ids=common_menu.ids " +
//        //                "where level>0 and lmr.role_ids=?"
//        HttpSession session = request.getSession();
//        String token = request.getHeader("token");
//        String role_ids;
//        if(token.equals("debug")){
//            role_ids = "0";
//        }else{
//            JSONObject role = (JSONObject) session.getAttribute(token);
//            role_ids = (String) role.get("roleIds");
//        }
//        System.out.println(role_ids);
////        String select = " SELECT * FROM common_menu where names in ( select record_hash from common_module_role where role_ids = ? )";
//        String select = "select lmr.ids as idss, common_menu.ids as ids, names, level, parent_ids, lmr.read r, lmr.write  w, url, icon from common_menu " +
//                "left join common_module_role as lmr on lmr.module_ids = common_menu.ids " +
//                "where level > 0 and lmr.role_ids = ?";
//        Object[] params = new Object[]{role_ids};
//        List<Menu> list = jdbcTemplate.query(select, params, new MenuRowMapper());
////        List<Menu> list = jdbcTemplate.query(select, new RowMapper<Menu>() {
////            @Override
////            public Menu mapRow(ResultSet resultSet, int i) throws SQLException {
////                Menu menu = new Menu();
////                menu.setIds(resultSet.getString("ids"));
////                menu.setNames(resultSet.getString("names"));
////                menu.setLevel(resultSet.getInt("level"));
////                menu.setParent_ids(resultSet.getString("parent_ids"));
////                menu.setDescription(resultSet.getString("description"));
////                menu.setUrl(resultSet.getString("url"));
////                menu.setIcon(resultSet.getString("icon"));
////                return menu;
////            }
////        });
//        JSONObject jsonObj = MyUtil.getJson("成功", 200, list);
//        return jsonObj;
//    }


    // mybatis
    @RequestMapping("get")
    public JSONObject getmbt(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            List<Menu> list = session.selectList("selectMenu");
            session.commit();
            return MyUtil.getJson("成功", 200, list);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return MyUtil.getJson("失败", 606, null);
        } finally {
            session.close();
        }
    }
}
