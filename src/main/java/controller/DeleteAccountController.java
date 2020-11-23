package controller;

import model.validation.Notification;
import service.clientAccountService.ClientAccountService;
import view.CreateClientAccView;
import view.DeleteClientAccView;

import javax.swing.*;
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

            Notification<Boolean> deleteAccountNotification;
            deleteAccountNotification =  clientAccountService. deleteAccount(deleteClientAccView.getTfIdentificationNumber(),deleteClientAccView.getTfAccountType());

            //clientInfoService.addClientInfo(addClientInfoView.getTfClientName(),addClientInfoView.getTfPersonalNumericalCode(),addClientInfoView.getTfCardNumber(),addClientInfoView.getTfAddress());

                if(deleteAccountNotification.hasErrors())
                {
                    JOptionPane.showMessageDialog(deleteClientAccView.getContentPane(), deleteAccountNotification.getFormattedErrors());
                }

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
