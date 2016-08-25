package cn.rayest.web;

import cn.rayest.dao.GradeDao;
import cn.rayest.util.DbUtil;
import cn.rayest.util.ResponseUtil;
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
public class GradeDeleteServlet extends HttpServlet {
    GradeDao gradeDao = new GradeDao();
    DbUtil dbUtil = new DbUtil();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteIds = request.getParameter("deleteIds");
        Connection connection = null;
        try {
            JSONObject jsonObject = new JSONObject();
            connection = dbUtil.getConnection();
            int deleteNumbers = gradeDao.gradeDelete(connection, deleteIds);
            if (deleteNumbers > 0) {
                jsonObject.put("success", "true");
                jsonObject.put("deleteNumbers", deleteNumbers);
            } else {
                jsonObject.put("errorMessage", "É¾³ýÊ§°Ü");
            }
            ResponseUtil.write(response, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
