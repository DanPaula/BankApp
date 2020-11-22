package controller;

import model.ClientAccount;
import service.clientAccountService.ClientAccountService;
import service.clientInfoService.ClientInfoService;
import view.AddClientInfoView;
import view.PayBillsView;

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
            clientAccountService.payBills(payBillsView.getTfMoneyAmount(),payBillsView.getTfCompanyName(),payBillsView.getTfClientName());
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
