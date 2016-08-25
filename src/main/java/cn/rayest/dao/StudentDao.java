package cn.rayest.dao;

import cn.rayest.model.PageBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rayest on 2016/8/25 0025.
 */
public class StudentDao {
    public ResultSet StudentList(Connection connection, PageBean pageBean) throws SQLException {
        StringBuffer stringBuffer = new StringBuffer("select * from t_student s, t_grade g where s.gradeId = g.id");
        if (pageBean != null) {
            stringBuffer.append(" limit " + pageBean.getStart() + ", " + pageBean.getRows());
        }
        PreparedStatement preparedStatement = connection.prepareStatement(stringBuffer.toString().replaceFirst("and", "where"));
        return preparedStatement.executeQuery();
    }

    public int studentCount(Connection connection) throws SQLException {
        StringBuffer stringBuffer = new StringBuffer("select count(*) as total from t_student s, t_grade g where s.gradeId = g.id");
        PreparedStatement preparedStatement = connection.prepareStatement(stringBuffer.toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("total");
        } else{
            return 0;
        }
    }
}
