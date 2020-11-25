package repository.security;

import model.Right;
import model.Role;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static database.Constants.Tables.*;

public class RightsRolesRepositoryMySQL implements RightsRolesRepository {

    private final Connection connection;

    public RightsRolesRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addRole(String role) {
        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT IGNORE INTO " + ROLE + " values (null, ?)");
            insertStatement.setString(1, role);
            insertStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void addRight(String right) {
        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT IGNORE INTO `" + RIGHT + "` values (null, ?)");
            insertStatement.setString(1, right);
            insertStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public Role findRoleByTitle(String role) {

        try {
            PreparedStatement fetchRoleStatement = connection
                    .prepareStatement("Select * from " + ROLE + " where `role`=\'" + role + "\'");
            fetchRoleStatement.executeQuery();
            ResultSet roleResultSet = fetchRoleStatement.executeQuery();
            roleResultSet.next();
            Long roleId = roleResultSet.getLong("id");
            String roleTitle = roleResultSet.getString("role");
            return new Role(roleId, roleTitle, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Role findRoleById(Long roleId) {

        try {
            PreparedStatement fetchRoleStatement =connection
                    .prepareStatement("Select * from " + ROLE + " where `id`=\'" + roleId + "\'");
            ResultSet roleResultSet = fetchRoleStatement.executeQuery();
            roleResultSet.next();
            String roleTitle = roleResultSet.getString("role");
            return new Role(roleId, roleTitle, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Long findRoleByUserId(Long userId) {
        long user_roleId=0;
        try {
            PreparedStatement statement = connection
                    .prepareStatement("Select role_id from user_role where user_id=?");
            statement.setLong(1,userId);
            ResultSet roleResultSet = statement.executeQuery();
            roleResultSet.next();
            user_roleId=roleResultSet.getLong("role_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return user_roleId;
    }

    @Override
    public Right findRightByTitle(String right) {
        try {
            PreparedStatement fetchRoleStatement =connection
                    .prepareStatement("Select * from `" + RIGHT + "` where `right`=\'" + right + "\'");

            ResultSet rightResultSet = fetchRoleStatement.executeQuery();
            rightResultSet.next();
            Long rightId = rightResultSet.getLong("id");
            String rightTitle = rightResultSet.getString("right");
            return new Right(rightId, rightTitle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addRolesToUser(User user, List<Role> roles) {
        try {
            for (Role role : roles) {
                PreparedStatement insertUserRoleStatement = connection
                        .prepareStatement("INSERT INTO `user_role` values (null, ?, ?)");
                insertUserRoleStatement.setLong(1, user.getId());
                insertUserRoleStatement.setLong(2, role.getId());
                insertUserRoleStatement.executeUpdate();
            }
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Role> findRolesForUser(Long userId) {
        try {
            List<Role> roles = new ArrayList<>();
            PreparedStatement fetchRoleStatement = connection
                    .prepareStatement("Select * from " + USER_ROLE + " where `user_id`=\'" + userId + "\'");

            ResultSet userRoleResultSet = fetchRoleStatement.executeQuery();
            while (userRoleResultSet.next()) {
                long roleId = userRoleResultSet.getLong("role_id");
                roles.add(findRoleById(roleId));
            }
            return roles;
        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public void addRoleRight(Long roleId, Long rightId) {
        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT IGNORE INTO " + ROLE_RIGHT + " values (null, ?, ?)");
            insertStatement.setLong(1, roleId);
            insertStatement.setLong(2, rightId);
            insertStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }
}