package controller;

import service.clientAccountService.ClientAccountService;
import view.DeleteClientAccView;
import view.ViewClientAccView;

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
            clientAccountService. viewAccount(viewClientAccView.getTfIdentificationNumber());
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
