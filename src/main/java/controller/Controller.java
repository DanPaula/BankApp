package controller;

import view.EmployeeView;

public class Controller {
    public static LoginController loginController;
    public static AdminController adminController;
    public static CreateEmployeeController createEmployeeController;
    public static ReadEmployeeController readEmployeeController;
    public static UpdateEmployeeController updateEmployeeController;
    public static DeleteEmployeeController deleteEmployeeController;
    public static EmployeeController employeeController;
    public static AddClientInfoController addClientInfoController;
    public static UpdateClientInfoController updateClientInfoController;
    public static ViewClientController viewClientInfoController;

    public Controller(LoginController loginController, AdminController adminController, CreateEmployeeController createEmployeeController, ReadEmployeeController readEmployeeController, UpdateEmployeeController updateEmployeeController,
                      DeleteEmployeeController deleteEmployeeController, EmployeeController employeeController, AddClientInfoController addClientInfoController,
                      UpdateClientInfoController updateClientInfoController, ViewClientController viewClientController) {
        this.loginController=loginController;
        this.adminController=adminController;
        this.createEmployeeController=createEmployeeController;
        this.readEmployeeController=readEmployeeController;
        this.updateEmployeeController=updateEmployeeController;
        this.deleteEmployeeController=deleteEmployeeController;
        this.employeeController=employeeController;
        this.addClientInfoController=addClientInfoController;
        this.updateClientInfoController=updateClientInfoController;
        this.viewClientInfoController = viewClientController;

    }
}
