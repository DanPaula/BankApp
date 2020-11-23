package controller;

import model.validation.Notification;
import service.clientInfoService.ClientInfoService;
import view.UpdateClientInfoView;
import view.ViewClientInfoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewClientController {
    private final ViewClientInfoView viewClientInfoView;
    private final ClientInfoService clientInfoService;

    public ViewClientController(ViewClientInfoView viewClientInfoView, ClientInfoService clientInfoService) {
        this.viewClientInfoView = viewClientInfoView;
        this.clientInfoService = clientInfoService;
        viewClientInfoView.setViewClientButtonListener(new ViewClientInfoButtonListener());
        viewClientInfoView.setBackButtonListener(new BackButtonListener());
    }

    public ViewClientInfoView getViewClientInfo() {
        return viewClientInfoView;
    }

    private class ViewClientInfoButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Notification<Boolean> addClientNotification;
            addClientNotification =  clientInfoService.viewClientInfo(viewClientInfoView.getTfClientName(),viewClientInfoView.getTfPersonalNumericalCode());

            //clientInfoService.addClientInfo(addClientInfoView.getTfClientName(),addClientInfoView.getTfPersonalNumericalCode(),addClientInfoView.getTfCardNumber(),addClientInfoView.getTfAddress());
                if(addClientNotification.hasErrors())
                {
                    JOptionPane.showMessageDialog(viewClientInfoView.getContentPane(), addClientNotification.getFormattedErrors());
                }
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.viewClientInfoController.getViewClientInfo().setVisible(false);
            Controller.employeeController.getEmployeeView().setVisible(true);

        }
    }

}
