package cn.rayest.web;
import cn.rayest.dao.GradeDao;
import cn.rayest.model.Grade;
import cn.rayest.util.DbUtil;
import cn.rayest.util.ResponseUtil;
import cn.rayest.util.StringUtil;
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
public class GradeSaveServlet extends HttpServlet {
    DbUtil dbUtil = new DbUtil();
    GradeDao gradeDao = new GradeDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String gradeName = request.getParameter("gradeName");
        String gradeDesc = request.getParameter("gradeDesc");
        String gradeId = request.getParameter("id");
        Grade grade = new Grade(gradeName, gradeDesc);
        if (StringUtil.isNotEmpty(gradeId)) {
            grade.setId(Integer.parseInt(gradeId));
        }
        Connection connection = null;
        try {
            connection = dbUtil.getConnection();
            JSONObject jsonObject = new JSONObject();
            int saveNumbers = 0;
            if (StringUtil.isNotEmpty(gradeId)) {
                saveNumbers = gradeDao.gradeModify(connection, grade);
            } else {
                saveNumbers = gradeDao.gradeAdd(connection, grade);
            }
            if (saveNumbers > 0) {
                jsonObject.put("success", "true");

            } else {
                jsonObject.put("success", "true");
                jsonObject.put("errorMessage", "±£¥Ê ß∞‹");
            }
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
