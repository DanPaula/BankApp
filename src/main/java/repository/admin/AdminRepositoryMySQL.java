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

    private static int user_id=0;

    public AdminRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void createEmployee(String name,String username) {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("INSERT INTO employee values (null,?,?)", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setLong(1, findIdByUsername(username));
            insertUserStatement.setString(2,name);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //gasesc id-ul din tabela username pentru un anume user
    @Override
    public int findIdByUsername(String username){
        int userID=0;
        try {
            PreparedStatement findStatement = connection
                    .prepareStatement("Select id from user where username = ?");
            findStatement.setString(1, username);
            ResultSet findResultSet = findStatement.executeQuery();
            findResultSet.next();
            userID=findResultSet.getInt("id");
            user_id=userID;
        } catch (SQLException e) {

        }
        return userID;
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

    @Override
    public void generateReports(Timestamp tfStartingPeriod, Timestamp tfEndPeriod, String employeeName) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("GenerateReports.txt"));

            int employee_id=findIdByEmployeeName(employeeName);


            PreparedStatement reportsStatement = connection
                    .prepareStatement("select* from EmployeeActivity where employee_id=? and activityDate>? and activityDate<?;",Statement.RETURN_GENERATED_KEYS);
            reportsStatement.setInt(1, employee_id);
            reportsStatement.setTimestamp(2, tfStartingPeriod);
            reportsStatement.setTimestamp(3, tfEndPeriod);
            ResultSet readResult = reportsStatement.executeQuery();
            while(readResult.next()){
                String name=readResult.getString("activity");
                writer.write(name);
                writer.write("\n");
                String date=readResult.getString("activityDate");
                writer.write(date);
                writer.write("\n");

            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        }catch(SQLException|IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void addEmployeeActivity(String activity, Timestamp date) {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("INSERT INTO EmployeeActivity values (null,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setInt(1, EmployeeID());
            insertUserStatement.setString(2, activity);
            insertUserStatement.setTimestamp(3, date);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int EmployeeID() {
        int employeeID=0;
        try {
            PreparedStatement findStatement = connection
                    .prepareStatement("Select id from Employee where user_id = ?");
            findStatement.setInt(1, user_id);
            ResultSet findResultSet = findStatement.executeQuery();
            findResultSet.next();
            employeeID=findResultSet.getInt("id");
        } catch (SQLException e) {

        }
        System.out.println(employeeID);
        return employeeID;
    }

    public int findIdByEmployeeName(String name) {
        int employeeID=0;
        try {
            PreparedStatement findStatement = connection
                    .prepareStatement("Select id from Employee where name = ?");
            findStatement.setString(1, name);
            ResultSet findResultSet = findStatement.executeQuery();
            findResultSet.next();
            employeeID=findResultSet.getInt("id");
        } catch (SQLException e) {

        }
        return employeeID;
    }

}
