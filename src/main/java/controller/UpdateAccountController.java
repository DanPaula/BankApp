package controller;

import service.clientAccountService.ClientAccountService;
import view.CreateClientAccView;
import view.UpdateClientAccView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateAccountController {
    private final UpdateClientAccView updateClientAccView;
    private final ClientAccountService clientAccountService;

    public UpdateAccountController(UpdateClientAccView updateClientAccView, ClientAccountService clientAccountService) {
        this.updateClientAccView = updateClientAccView;
        this.clientAccountService = clientAccountService;
        updateClientAccView.setUpdateAccountButtonListener(new UpdateAccountButtonListener());
        updateClientAccView.setBackButtonListener(new BackButtonListener());
    }

    public UpdateClientAccView getUpdateAccountView() {
        return updateClientAccView;
    }

    private class UpdateAccountButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientAccountService. updateAccount(updateClientAccView.getTfIdentificationNumber(),updateClientAccView.getTfAccountType(),updateClientAccView.getTfMoneyAmount());
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.updateAccountController.getUpdateAccountView().setVisible(false);
            Controller.employeeController.getEmployeeView().setVisible(true);
        }
    }
}
