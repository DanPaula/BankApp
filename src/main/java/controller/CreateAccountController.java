package controller;

import service.clientAccountService.ClientAccountService;
import service.clientInfoService.ClientInfoService;
import view.CreateClientAccView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountController {

    private final CreateClientAccView createClientAccView;
    private final ClientAccountService clientAccountService;

    public CreateAccountController(CreateClientAccView createClientAccView, ClientAccountService clientAccountService) {
        this.createClientAccView = createClientAccView;
        this.clientAccountService = clientAccountService;
        createClientAccView.setCreateAccountButtonListener(new CreateAccountButtonListener());
        createClientAccView.setBackButtonListener(new BackButtonListener());
    }

    public CreateClientAccView getCreateAccountView() {
        return createClientAccView;
    }

    private class CreateAccountButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientAccountService. createAccount(createClientAccView.getTfIdentificationNumber(),createClientAccView.getTfAccountType(),createClientAccView.getTfMoneyAmount(),createClientAccView.getTfAccountNumber());
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.createAccountController.getCreateAccountView().setVisible(false);
            Controller.employeeController.getEmployeeView().setVisible(true);

        }
    }
}
