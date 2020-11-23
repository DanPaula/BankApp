package controller;

import model.validation.Notification;
import service.clientAccountService.ClientAccountService;
import view.CreateClientAccView;
import view.UpdateClientAccView;

import javax.swing.*;
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
            Notification<Boolean> addClientNotification;
            addClientNotification = clientAccountService. updateAccount(updateClientAccView.getTfIdentificationNumber(),updateClientAccView.getTfAccountType(),updateClientAccView.getTfMoneyAmount());

            //clientInfoService.addClientInfo(addClientInfoView.getTfClientName(),addClientInfoView.getTfPersonalNumericalCode(),addClientInfoView.getTfCardNumber(),addClientInfoView.getTfAddress());

                if(addClientNotification.hasErrors())
                {
                    JOptionPane.showMessageDialog(updateClientAccView.getContentPane(), addClientNotification.getFormattedErrors());
                }
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
