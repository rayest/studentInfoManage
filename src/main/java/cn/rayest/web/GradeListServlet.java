package cn.rayest.web;

import cn.rayest.dao.GradeDao;
import cn.rayest.model.Grade;
import cn.rayest.model.PageBean;
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
 * Created by Rayest on 2016/8/24 0024.
 */
public class GradeListServlet extends HttpServlet {
    DbUtil dbUtil = new DbUtil();
    GradeDao gradeDao = new GradeDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String gradeName = request.getParameter("gradeName");
        if (gradeName == null) {
            gradeName = "";
        }
        Grade grade = new Grade();
        grade.setGradeName(gradeName);
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Connection connection = null;
        try {
            connection = dbUtil.getConnection();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = JsonUtil.formatResultSetToJsonArray(gradeDao.gradeList(connection, pageBean, grade));
            int total = gradeDao.gradeCount(connection, grade);
            jsonObject.put("rows", jsonArray);
            jsonObject.put("total", total);
            ResponseUtil.write(response, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
