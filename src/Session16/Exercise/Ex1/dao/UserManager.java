package Session16.Exercise.Ex1.dao;

import Session16.Exercise.Ex1.database.JDBCUtil;
import Session16.Exercise.Ex1.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {
    public User getUser(String name) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        CallableStatement statement = connection.prepareCall("{call getUser(?)}");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAddress(resultSet.getString("address"));
            user.setPhone(resultSet.getString("phone"));
            user.setDateOfBirth(resultSet.getDate("dateOfBirth"));
            user.setRole(resultSet.getBoolean("role"));
            user.setStatus(resultSet.getBoolean("status"));
        }
        resultSet.close();
        statement.close();
        connection.close();
        return user;
    }
}
