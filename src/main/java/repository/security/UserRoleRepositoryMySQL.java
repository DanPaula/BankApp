package repository.security;

import model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static database.Constants.Tables.ROLE_RIGHT;
import static database.Constants.Tables.USER_ROLE;

public class UserRoleRepositoryMySQL implements UserRoleRepository{

    private final Connection connection;

    public UserRoleRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addUserRole(Long userId, Long roleId) {
        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT IGNORE INTO " + USER_ROLE + " values (null, ?, ?)");
            insertStatement.setLong(1, userId);
            insertStatement.setLong(2, roleId);
            insertStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public long findIdByUser(String username, String password){
        long userId=0;
        try {
            PreparedStatement findStatement = connection
                    .prepareStatement("Select id from user where username = ? and password = ?");
            findStatement.setString(1, username);
            findStatement.setString(2, password);
            ResultSet findResultSet = findStatement.executeQuery();
            findResultSet.next();
            userId=findResultSet.getLong("id");
        } catch (SQLException e) {

        }
        return userId;
    }

}
