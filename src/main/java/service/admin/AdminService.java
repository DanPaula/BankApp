package service.admin;

import java.sql.Timestamp;

public interface AdminService {

    void createEmployee(String nume,String username,String password);
    void readEmployee();
    void updateEmployee(String oldName,String newName, String oldUsername, String newUsername,String password);
    void deleteEmployee(String name,String username);

    void generateReports(Timestamp tfStartingPeriod, Timestamp tfEndPeriod,String employeeName);
}
