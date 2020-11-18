package repository.user;

import model.User;
import model.builder.UserBuilder;
import model.validation.Notification;
import repository.security.RightsRolesRepository;
import repository.security.UserRoleRepository;

import java.sql.*;
import java.util.List;

import static database.Constants.Tables.USER;

public class UserRepositoryMySQL implements UserRepository {

    private final Connection connection;
    private final RightsRolesRepository rightsRolesRepository;
    private final UserRoleRepository userRoleRepository;

    public UserRepositoryMySQL(Connection connection, RightsRolesRepository rightsRolesRepository, UserRoleRepository userRoleRepository) {
        this.connection = connection;
        this.rightsRolesRepository = rightsRolesRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Notification<User> findByUsernameAndPassword(String username, String password) throws AuthenticationException {
        Notification<User> findByUsernameAndPasswordNotification = new Notification<>();
        try {
            Statement statement = connection.createStatement();
            String fetchUserSql = "Select * from `" + USER + "` where `username`=\'" + username + "\' and `password`=\'" + password + "\'";
            ResultSet userResultSet = statement.executeQuery(fetchUserSql);
            if (userResultSet.next()) {
                User user = new UserBuilder()
                        .setUsername(userResultSet.getString("username"))
                        .setPassword(userResultSet.getString("password"))
                        .setRoles(rightsRolesRepository.findRolesForUser(userResultSet.getLong("id")))
                        .build();
                findByUsernameAndPasswordNotification.setResult(user);
                return findByUsernameAndPasswordNotification;
            } else {
                findByUsernameAndPasswordNotification.addError("Invalid email or password!");
                return findByUsernameAndPasswordNotification;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AuthenticationException();
        }
    }



    @Override
    public boolean save(User user) {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("INSERT INTO user values (null, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, user.getUsername());
            insertUserStatement.setString(2, user.getPassword());
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();
            long userId = rs.getLong(1);
            user.setId(userId);

            userRoleRepository.addUserRole(userId, (long) 2);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(String oldUsername,String newUsername,String newPassword) {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("update user set username = ?, password=? where username = ?", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, newUsername);
            insertUserStatement.setString(2, newPassword);
            insertUserStatement.setString(3, oldUsername);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();
            //long userId = rs.getLong(1);
            //user.setId(userId);

            //userRoleRepository.addUserRole(userId, (long) 2);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(String username) {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("delete from user where username = ?", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, username);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();
            //long userId = rs.getLong(1);
            //user.setId(userId);

            //userRoleRepository.addUserRole(userId, (long) 2);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void removeAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE from user where id >= 0";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
