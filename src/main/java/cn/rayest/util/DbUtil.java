package cn.rayest.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Rayest on 2016/8/24 0024.
 */
public class DbUtil {
    private String url = "jdbc:mysql://localhost:3306/db_studentInfo";
    private String user = "root";
    private String password = "199011081108";
    private String jdbcName = "com.mysql.jdbc.Driver";

    public Connection getConnection() throws Exception {
        Class.forName(jdbcName);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public void closeConnection(Connection connection) throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        DbUtil dbUtil = new DbUtil();
        try {
            dbUtil.getConnection();
            System.out.println("数据库连接成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
