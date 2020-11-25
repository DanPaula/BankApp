package controller.employee;

import controller.Controller;
import model.validation.Notification;
import service.clientAccountService.ClientAccountService;
import view.employee.PayBillsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayBillsController {

    private final PayBillsView payBillsView;
    private final ClientAccountService clientAccountService;

    public PayBillsController(PayBillsView addClientInfoView, ClientAccountService clientAccountService) {
        this.payBillsView = addClientInfoView;
        this.clientAccountService = clientAccountService;
        payBillsView.setPayButtonListener(new PayButtonListener());
        payBillsView.setBackButtonListener(new BackButtonListener());
    }

    public PayBillsView getPayBillsView() {
        return payBillsView;
    }

    private class PayButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Notification<Boolean> addClientNotification;
            addClientNotification = clientAccountService.payBills(payBillsView.getTfMoneyAmount(),payBillsView.getTfCompanyName(),payBillsView.getTfClientName());

            //clientInfoService.addClientInfo(addClientInfoView.getTfClientName(),addClientInfoView.getTfPersonalNumericalCode(),addClientInfoView.getTfCardNumber(),addClientInfoView.getTfAddress());

                if(addClientNotification.hasErrors())
                {
                    JOptionPane.showMessageDialog(payBillsView.getContentPane(), addClientNotification.getFormattedErrors());
                }
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.payBillsController.getPayBillsView().setVisible(false);
            Controller.employeeController.getEmployeeView().setVisible(true);

        }
    }
}
