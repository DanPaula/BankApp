package controller.employee;

import controller.Controller;
import view.employee.EmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController {

    private final EmployeeView employeeView;


    public EmployeeController(EmployeeView employeeView) {
        this.employeeView = employeeView;
        employeeView.addClientInfoButtonListener(new AddClientInfoButtonListener());
        employeeView.updateClientInfoButtonListener(new UpdateClientInfoButtonListener());
        employeeView.viewClientInfoButtonListener(new ViewClientInfoButtonListener());
        employeeView.createClientAccButtonListener(new CreateClientAccButtonListener());
        employeeView.updateClientAccButtonListener(new UpdateClientAccButtonListener());
        employeeView.deleteClientAccButtonListener(new DeleteClientAccButtonListener());
        employeeView.viewClientAccButtonListener(new ViewClientAccButtonListener());
        employeeView.transferMoneyButtonListener(new TransferMoneyButtonListener());
        employeeView.processBillsButtonListener(new ProcessBillsButtonListener());
        employeeView.setBackButtonListener(new BackButtonListener());
    }

    public EmployeeView getEmployeeView() {
        return employeeView;
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.employeeController.getEmployeeView().setVisible(false);
            Controller.loginController.getLoginView().setVisible(true);
        }
    }

    private class AddClientInfoButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.addClientInfoController.getCreateEmployeeView().setVisible(true);
            Controller.employeeController.getEmployeeView().setVisible(false);
        }
    }

    private class UpdateClientInfoButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.updateClientInfoController.getUpdateClientInfo().setVisible(true);
            Controller.employeeController.getEmployeeView().setVisible(false);
        }
    }

    private class ViewClientInfoButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.viewClientInfoController.getViewClientInfo().setVisible(true);
            Controller.employeeController.getEmployeeView().setVisible(false);
        }
    }

    private class CreateClientAccButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.createAccountController.getCreateAccountView().setVisible(true);
            Controller.employeeController.getEmployeeView().setVisible(false);

        }
    }

    private class UpdateClientAccButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.updateAccountController.getUpdateAccountView().setVisible(true);
            Controller.employeeController.getEmployeeView().setVisible(false);
        }
    }

    private class DeleteClientAccButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.deleteAccountController.getDeleteAccountView().setVisible(true);
            Controller.employeeController.getEmployeeView().setVisible(false);
        }
    }

    private class ViewClientAccButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.viewAccountController.getViewAccountView().setVisible(true);
            Controller.employeeController.getEmployeeView().setVisible(false);
        }
    }

    private class ProcessBillsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.payBillsController.getPayBillsView().setVisible(true);
            Controller.employeeController.getEmployeeView().setVisible(false);
        }
    }

    private class TransferMoneyButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.transferMoneyController.getTransferMoneyView().setVisible(true);
            Controller.employeeController.getEmployeeView().setVisible(false);
        }
    }

}
