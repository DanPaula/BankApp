package controller;

import service.clientAccountService.ClientAccountService;
import view.CreateClientAccView;
import view.DeleteClientAccView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteAccountController {

    private final DeleteClientAccView deleteClientAccView;
    private final ClientAccountService clientAccountService;

    public DeleteAccountController(DeleteClientAccView deleteClientAccView, ClientAccountService clientAccountService) {
        this.deleteClientAccView = deleteClientAccView;
        this.clientAccountService = clientAccountService;
        deleteClientAccView.setDeleteAccountButtonListener(new DeleteAccountButtonListener());
        deleteClientAccView.setBackButtonListener(new BackButtonListener());
    }

    public DeleteClientAccView getDeleteAccountView() {
        return deleteClientAccView;
    }

    private class DeleteAccountButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientAccountService. deleteAccount(deleteClientAccView.getTfIdentificationNumber(),deleteClientAccView.getTfAccountType());
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.deleteAccountController.getDeleteAccountView().setVisible(false);
            Controller.employeeController.getEmployeeView().setVisible(true);

        }
    }

}
