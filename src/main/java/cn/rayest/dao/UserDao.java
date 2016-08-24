package cn.rayest.dao;

import cn.rayest.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rayest on 2016/8/24 0024.
 */
public class UserDao {
    public User login(Connection connection, User user) throws SQLException {
        User resultUser = null;
        String sql = "SELECT * FROM t_user WHERE userName = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            resultUser = new User();
            resultUser.setUserName(resultSet.getString("userName"));
            resultUser.setPassword(resultSet.getString("password"));
        }
        return resultUser;
    }
}
