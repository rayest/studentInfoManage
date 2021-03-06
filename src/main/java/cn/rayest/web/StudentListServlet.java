package cn.rayest.web;

import cn.rayest.dao.StudentDao;
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
 * Created by Rayest on 2016/8/25 0025.
 */
public class StudentListServlet extends HttpServlet {
    DbUtil dbUtil = new DbUtil();
    StudentDao studentDao = new StudentDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Connection connection = null;
        try {
            connection = dbUtil.getConnection();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = JsonUtil.formatResultSetToJsonArray(studentDao.StudentList(connection, pageBean));
            int total = studentDao.studentCount(connection);
            jsonObject.put("rows", jsonArray);
            jsonObject.put("total", total);
            ResponseUtil.write(response, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                dbUtil.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
