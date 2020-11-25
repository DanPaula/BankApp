package controller.employee;

import controller.Controller;
import model.validation.Notification;
import service.clientInfoService.ClientInfoService;
import view.employee.UpdateClientInfoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateClientInfoController {
    private final UpdateClientInfoView updateClientInfoView;
    private final ClientInfoService clientInfoService;

    public UpdateClientInfoController(UpdateClientInfoView updateClientInfoView, ClientInfoService clientInfoService) {
        this.updateClientInfoView = updateClientInfoView;
        this.clientInfoService = clientInfoService;
        updateClientInfoView.setUpdateClientButtonListener(new UpdateClientInfoButtonListener());
        updateClientInfoView.setBackButtonListener(new BackButtonListener());
    }

    public UpdateClientInfoView getUpdateClientInfo() {
        return updateClientInfoView;
    }

    private class UpdateClientInfoButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Notification<Boolean> addClientNotification;
            addClientNotification = clientInfoService.updateClientInfo(updateClientInfoView.getTfOldClientName(),updateClientInfoView.getTfNewClientName(),updateClientInfoView.getTfPersonalNumericalCode(),updateClientInfoView.getTfOldCardNumber(),updateClientInfoView.getTfNewCardNumber(),updateClientInfoView.getTfOldAddress(),updateClientInfoView.getTfNewAddress());

            //clientInfoService.addClientInfo(addClientInfoView.getTfClientName(),addClientInfoView.getTfPersonalNumericalCode(),addClientInfoView.getTfCardNumber(),addClientInfoView.getTfAddress());
                if(addClientNotification.hasErrors())
                {
                    JOptionPane.showMessageDialog(updateClientInfoView.getContentPane(), addClientNotification.getFormattedErrors());
                }
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.updateClientInfoController.getUpdateClientInfo().setVisible(false);
            Controller.employeeController.getEmployeeView().setVisible(true);

        }
    }
}
