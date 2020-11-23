package controller;

import model.validation.Notification;
import service.clientAccountService.ClientAccountService;
import view.DeleteClientAccView;
import view.ViewClientAccView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewAccountController {
    private final ViewClientAccView viewClientAccView;
    private final ClientAccountService clientAccountService;

    public ViewAccountController(ViewClientAccView viewClientAccView, ClientAccountService clientAccountService) {
        this.viewClientAccView = viewClientAccView;
        this.clientAccountService = clientAccountService;
        viewClientAccView.setViewAccountButtonListener(new ViewAccountButtonListener());
        viewClientAccView.setBackButtonListener(new BackButtonListener());
    }

    public ViewClientAccView getViewAccountView() {
        return viewClientAccView;
    }

    private class ViewAccountButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Notification<Boolean> addClientNotification;
            addClientNotification =  clientAccountService. viewAccount(viewClientAccView.getTfIdentificationNumber());

            //clientInfoService.addClientInfo(addClientInfoView.getTfClientName(),addClientInfoView.getTfPersonalNumericalCode(),addClientInfoView.getTfCardNumber(),addClientInfoView.getTfAddress());

                if(addClientNotification.hasErrors())
                {
                    JOptionPane.showMessageDialog(viewClientAccView.getContentPane(), addClientNotification.getFormattedErrors());
                }
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.viewAccountController.getViewAccountView().setVisible(false);
            Controller.employeeController.getEmployeeView().setVisible(true);

        }
    }

}
