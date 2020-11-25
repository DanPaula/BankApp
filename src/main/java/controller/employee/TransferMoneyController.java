package controller.employee;

import controller.Controller;
import model.validation.Notification;
import service.clientAccountService.ClientAccountService;
import view.employee.TransferMoneyView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferMoneyController {


    private final TransferMoneyView transferMoneyView;
    private final ClientAccountService clientAccountService;

    public TransferMoneyController(TransferMoneyView transferMoneyView, ClientAccountService clientAccountService) {
        this.transferMoneyView = transferMoneyView;
        this.clientAccountService = clientAccountService;
        transferMoneyView.setDeleteAccountButtonListener(new TransferMoneyButtonListener());
        transferMoneyView.setBackButtonListener(new BackButtonListener());
    }

    public TransferMoneyView getTransferMoneyView() {
        return transferMoneyView;
    }

    private class TransferMoneyButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Notification<Boolean> addClientNotification ;
            addClientNotification = clientAccountService.transferMoney(transferMoneyView.getTfAccountNumberSender(),transferMoneyView.getTfAccountNumberReceiver(),transferMoneyView.getTfMoneyAmount());

            //clientInfoService.addClientInfo(addClientInfoView.getTfClientName(),addClientInfoView.getTfPersonalNumericalCode(),addClientInfoView.getTfCardNumber(),addClientInfoView.getTfAddress());

                if(addClientNotification.hasErrors())
                {
                    JOptionPane.showMessageDialog(transferMoneyView.getContentPane(), addClientNotification.getFormattedErrors());
                }

        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.transferMoneyController.getTransferMoneyView().setVisible(false);
            Controller.employeeController.getEmployeeView().setVisible(true);

        }
    }

}
