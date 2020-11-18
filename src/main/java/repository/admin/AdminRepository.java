package repository.admin;

import model.User;

public interface AdminRepository {

    void createEmployee(String name);
    void readEmployee();
    void updateEmployee(String oldName,String newName);
    void deleteEmployee(String name);

}
