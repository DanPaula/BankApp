package controller;

import service.admin.AdminService;
import service.clientInfoService.ClientInfoService;
import view.AddClientInfoView;
import view.CreateEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientInfoController {

    private final AddClientInfoView addClientInfoView;
    private final ClientInfoService clientInfoService;

    public AddClientInfoController(AddClientInfoView addClientInfoView, ClientInfoService clientInfoService) {
        this.addClientInfoView = addClientInfoView;
        this.clientInfoService = clientInfoService;
        addClientInfoView.setAddClientButtonListener(new AddClientInfoButtonListener());
        addClientInfoView.setBackButtonListener(new BackButtonListener());
    }

    public AddClientInfoView getCreateEmployeeView() {
        return addClientInfoView;
    }

    private class AddClientInfoButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientInfoService.addClientInfo(addClientInfoView.getTfClientName(),addClientInfoView.getTfPersonalNumericalCode(),addClientInfoView.getTfCardNumber(),addClientInfoView.getTfAddress());
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.addClientInfoController.getCreateEmployeeView().setVisible(false);
            Controller.employeeController.getEmployeeView().setVisible(true);

        }
    }
}
