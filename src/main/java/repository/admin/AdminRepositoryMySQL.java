package repository.admin;

import model.Role;
import model.User;
import repository.security.UserRoleRepositoryMySQL;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.*;

public class AdminRepositoryMySQL implements AdminRepository {

    private final Connection connection;

    public AdminRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void createEmployee(String name) {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("INSERT INTO employee values (null,?)", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, name);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void readEmployee() {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("EmployeeRead.txt"));

            PreparedStatement readEmployeeStatement = connection
                    .prepareStatement("select* from employee;",Statement.RETURN_GENERATED_KEYS);
            ResultSet readResult = readEmployeeStatement.executeQuery();
            while(readResult.next()){
                String name=readResult.getString("name");
                writer.write(name);
                writer.write("\n");

            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        }catch(SQLException|IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(String oldName,String newName) {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("update employee set name=? where name=?;", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, newName);
            insertUserStatement.setString(2,oldName);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(String name) {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("delete from employee where name=?;", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, name);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
