package controller;

import view.CreateClientAccView;
import view.EmployeeView;
import view.TransferMoneyView;

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
    public static CreateAccountController createAccountController;
    public static UpdateAccountController updateAccountController;
    public static DeleteAccountController deleteAccountController;
    public static ViewAccountController viewAccountController;
    public static TransferMoneyController transferMoneyController;

    public Controller(LoginController loginController, AdminController adminController, CreateEmployeeController createEmployeeController, ReadEmployeeController readEmployeeController, UpdateEmployeeController updateEmployeeController,
                      DeleteEmployeeController deleteEmployeeController, EmployeeController employeeController, AddClientInfoController addClientInfoController,
                      UpdateClientInfoController updateClientInfoController, ViewClientController viewClientController,
                      CreateAccountController createAccountController,UpdateAccountController updateAccountController, DeleteAccountController deleteAccountController,
                      ViewAccountController viewAccountController, TransferMoneyController transferMoneyController) {
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
        this.createAccountController = createAccountController;
        this.updateAccountController = updateAccountController;
        this.deleteAccountController = deleteAccountController;
        this.viewAccountController = viewAccountController;
        this.transferMoneyController = transferMoneyController;

    }
}
