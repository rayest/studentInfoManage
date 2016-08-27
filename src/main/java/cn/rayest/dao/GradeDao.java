package cn.rayest.dao;

import cn.rayest.model.Grade;
import cn.rayest.model.PageBean;
import cn.rayest.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rayest on 2016/8/24 0024.
 */
public class GradeDao {
    public ResultSet gradeList(Connection connection, PageBean pageBean, Grade grade) throws SQLException {
        StringBuffer stringBuffer = new StringBuffer("select * from t_grade");
        if (StringUtil.isNotEmpty(grade.getGradeName())) {
            stringBuffer.append(" and gradeName like '%" + grade.getGradeName() + "%'");
        }
        if (pageBean != null) {
            stringBuffer.append(" limit " + pageBean.getStart() + ", " + pageBean.getRows());
        }
        System.out.println(stringBuffer.toString());
        PreparedStatement preparedStatement = connection.prepareStatement(stringBuffer.toString().replaceFirst("and", "where"));
        return preparedStatement.executeQuery();
    }

    public int gradeCount(Connection connection, Grade grade) throws SQLException {

        StringBuffer stringBuffer = new StringBuffer("SELECT COUNT(*) AS total FROM t_grade");
        if (StringUtil.isNotEmpty(grade.getGradeName())) {
            stringBuffer.append(" and gradeName like '%" + grade.getGradeName() + "%'");
        }
        PreparedStatement preparedStatement = connection.prepareStatement(stringBuffer.toString().replaceFirst("and", "where"));
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("total");
        } else {
            return 0;
        }
    }


    // delete from tableName where field in (1, 3, 5)
    public int gradeDelete(Connection connection, String deleteIds) throws SQLException {
        String sql = "DELETE FROM t_grade WHERE id IN (" + deleteIds + ")";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeUpdate();
    }

    public int gradeAdd(Connection connection, Grade grade) throws SQLException {
        String sql = "INSERT INTO t_grade VALUES (NULL, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, grade.getGradeName());
        preparedStatement.setString(2, grade.getGradeDesc());
        return preparedStatement.executeUpdate();
    }

    public int gradeModify(Connection connection, Grade grade) throws SQLException {
        String sql = "UPDATE t_grade SET gradeName=?, gradeDesc=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, grade.getGradeName());
        preparedStatement.setString(2, grade.getGradeDesc());
        preparedStatement.setInt(3, grade.getId());
        return preparedStatement.executeUpdate();
    }
}
