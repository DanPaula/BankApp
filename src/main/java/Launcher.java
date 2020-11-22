import controller.*;
import service.admin.AdminService;
import view.*;


public class Launcher {

    public static void main(String[] args) {
        ComponentFactory componentFactory = ComponentFactory.instance(false);
        new Controller(new LoginController(new LoginView(), componentFactory.getAuthenticationService()),
                        new AdminController(new AdminView()),
                        new CreateEmployeeController(new CreateEmployeeView(),componentFactory.getAdminRepository()),
                        new ReadEmployeeController(new ReadEmployeeView(),componentFactory.getAdminRepository()),
                        new UpdateEmployeeController(new UpdateEmployeeView(),componentFactory.getAdminRepository()),
                        new DeleteEmployeeController(new DeleteEmployeeView(),componentFactory.getAdminRepository()),
                        new EmployeeController(new EmployeeView()),
                        new AddClientInfoController(new AddClientInfoView(),componentFactory.getClientInfoService()),
                        new UpdateClientInfoController(new UpdateClientInfoView(),componentFactory.getClientInfoService()),
                        new ViewClientController(new ViewClientInfoView(),componentFactory.getClientInfoService()),
                        new CreateAccountController(new CreateClientAccView(),componentFactory.getClientAccountService()),
                        new UpdateAccountController(new UpdateClientAccView(),componentFactory.getClientAccountService()),
                        new DeleteAccountController(new DeleteClientAccView(),componentFactory.getClientAccountService()),
                        new ViewAccountController(new ViewClientAccView(),componentFactory.getClientAccountService()),
                        new TransferMoneyController(new TransferMoneyView(),componentFactory.getClientAccountService())
        );

    }

}
