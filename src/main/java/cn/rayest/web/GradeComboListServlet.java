package cn.rayest.web;

import cn.rayest.dao.GradeDao;
import cn.rayest.util.DbUtil;
import cn.rayest.util.JsonUtil;
import cn.rayest.util.ResponseUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Rayest on 2016/8/27 0027.
 */
public class GradeComboListServlet extends HttpServlet{
    DbUtil dbUtil = new DbUtil();
    GradeDao gradeDao = new GradeDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = dbUtil.getConnection();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonObject.put("id", "");
            jsonObject.put("gradeName", "«Î—°‘Ò");
            jsonArray.add(jsonObject);
            jsonArray.addAll(JsonUtil.formatResultSetToJsonArray(gradeDao.gradeList(connection, null, null)));
            ResponseUtil.write(response, jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
