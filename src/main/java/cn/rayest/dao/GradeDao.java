package cn.rayest.dao;

import cn.rayest.model.PageBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rayest on 2016/8/24 0024.
 */
public class GradeDao {
    public ResultSet gradeList(Connection connection, PageBean pageBean) throws SQLException {
        StringBuffer stringBuffer = new StringBuffer("select * from t_grade");
        if (pageBean != null) {
            stringBuffer.append(" limit " + pageBean.getStart() + ", " + pageBean.getRows());
        }
        PreparedStatement preparedStatement = connection.prepareStatement(stringBuffer.toString());
        return preparedStatement.executeQuery();
    }

    public int gradeCount(Connection connection) throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM t_grade";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("total");
        } else {
            return 0;
        }
    }
}
