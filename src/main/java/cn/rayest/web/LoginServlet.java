package cn.rayest.web;

import cn.rayest.dao.UserDao;
import cn.rayest.model.User;
import cn.rayest.util.DbUtil;
import cn.rayest.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Rayest on 2016/8/24 0024.
 */
public class LoginServlet extends HttpServlet {
    DbUtil dbUtil = new DbUtil();
    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        request.setAttribute("userName", userName);
        request.setAttribute("password", password);
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
            request.setAttribute("error", "用户名或密码为空！");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        User user = new User(userName, password);
        Connection connection = null;
        try {
            connection = dbUtil.getConnection();
            User currentUser = userDao.login(connection, user);
            if (currentUser == null) {
                request.setAttribute("error", "用户名或密码错误");
                // 服务器端跳转
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                // 获取 session
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", currentUser);
                // 客户端跳转
                response.sendRedirect("main.jsp");
            }
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
