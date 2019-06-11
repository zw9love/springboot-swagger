package com.roncoo.swagger.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.swagger.bean.Protected;
import com.roncoo.swagger.mapper.ProtectedRowMapper;
import com.roncoo.swagger.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author zenngwei
 * @date 2018/06/25 11:41
 */

@RestController
@RequestMapping("/BeeneedleProtected")
public class BeeeyeProtectedController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String tableName = "beeneedle_protected";

    @RequestMapping("get")
    public JSONObject get(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        String select = " SELECT * FROM  " + tableName;
        String where = " where host_ids = ? and type = ? ";
        String count = " SELECT count(*) FROM  " + tableName + where;
        String pageSql = " limit ?, ? ";
        Map<String, Object> json = MyUtil.getJsonData(request);
        Map<String, Object> page = (Map<String, Object>) json.get("page");
        Map<String, Object> row = (Map<String, Object>) json.get("row");
        String hostIds = row.get("host_ids").toString();
        String type = row.get("type").toString();
        int pageNumber = (int) Double.parseDouble(page.get("pageNumber").toString());
        int pageSize = (int) Double.parseDouble(page.get("pageSize").toString());
        int pageStart = (pageNumber - 1) * pageSize;
        Object[] params = new Object[]{hostIds, type, pageStart, pageSize};
        Object[] countParams = new Object[]{hostIds, type};
        List<Protected> list = jdbcTemplate.query(select + where + pageSql, params, new ProtectedRowMapper());
        // 获取总数
        Integer totalRow = jdbcTemplate.queryForObject(count, countParams, Integer.class);
        int totalPage = (int) Math.ceil((double) totalRow / (double) pageSize);
        JSONObject resObj = MyUtil.getPageJson(list, pageNumber, pageSize, totalPage, totalRow);
        JSONObject jsonObj = MyUtil.getJson("成功", 200, resObj);
        return jsonObj;
    }

    @RequestMapping("get/{ids}")
    public JSONObject getById(@PathVariable String ids) {
        JSONObject jsonObj;
        if (ids != null) {
            String select = "select * from " + tableName + " where ids = ? ";
            Protected protect = jdbcTemplate.queryForObject(select, new ProtectedRowMapper(), ids);
            jsonObj = MyUtil.getJson("成功", 200, protect);
        } else {
            jsonObj = MyUtil.getJson("失败", 200, null);
        }
        return jsonObj;
    }

    @RequestMapping("put")
    public JSONObject put(HttpServletRequest request) {
        JSONObject jsonObj;
        String sql = " UPDATE " + tableName + " SET name = ?, full_path = ? where ids = ? ";
        Map<String, Object> json = MyUtil.getJsonData(request);
        String ids = MyUtil.getString(json, "ids");
        String name = MyUtil.getString(json, "name");
        String full_path = MyUtil.getString(json, "full_path");
        Object[] params = new Object[]{name, full_path, ids};
        int effectRow = jdbcTemplate.update(sql, params);
        if (effectRow > 0)
            jsonObj = MyUtil.getJson("成功", 200, null);
        else
            jsonObj = MyUtil.getJson("失败", 606, null);
        return jsonObj;
    }

    @RequestMapping("post")
    public JSONObject post(HttpServletRequest request) {
        JSONObject jsonObj;
        Map<String, Object> json = MyUtil.getJsonData(request);
        String ids = MyUtil.getRandomString();
        String host_ids = MyUtil.getString(json, "host_ids");
        String name = MyUtil.getString(json, "name");
        String full_path = MyUtil.getString(json, "full_path");
        int type = MyUtil.getInt(json, "type");
        String sql = " INSERT INTO " + tableName + " (ids, host_ids, name, full_path, type, hash) VALUES ( ?, ?, ?, ?, ?, '')";
        int effectRow = jdbcTemplate.update(sql, ids, host_ids, name, full_path, type);
        if (effectRow > 0)
            jsonObj = MyUtil.getJson("成功", 200, null);
        else
            jsonObj = MyUtil.getJson("失败", 606, null);
        return jsonObj;
    }

    @RequestMapping("/delete/{ids}")
    public JSONObject deleteById(@PathVariable String ids) {
        JSONObject jsonObj;
        String sql = " delete from " + tableName + " where ids = ? ";
        int effectRow = jdbcTemplate.update(sql, ids);
        if (effectRow > 0)
            jsonObj = MyUtil.getJson("成功", 200, null);
        else
            jsonObj = MyUtil.getJson("删除失败", 606, null);
        return jsonObj;
    }
}
