package repository.admin;

import model.User;

import java.sql.Timestamp;

public interface AdminRepository {

    void createEmployee(String name,String username);
    void readEmployee();
    void updateEmployee(String oldName,String newName);
    void deleteEmployee(String name);

    void generateReports(Timestamp tfStartingPeriod, Timestamp tfEndPeriod,String employeeName);

    void addEmployeeActivity(String activity, Timestamp date);
    int findIdByUsername(String username);
}
