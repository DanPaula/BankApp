package controller;

import service.clientAccountService.ClientAccountService;
import view.DeleteClientAccView;
import view.TransferMoneyView;

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
            clientAccountService.transferMoney(transferMoneyView.getTfAccountNumberSender(),transferMoneyView.getTfAccountNumberReceiver(),transferMoneyView.getTfMoneyAmount());
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
