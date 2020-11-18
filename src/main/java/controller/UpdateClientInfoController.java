package controller;

import service.clientInfoService.ClientInfoService;
import view.AddClientInfoView;
import view.UpdateClientInfoView;

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
            clientInfoService.updateClientInfo(updateClientInfoView.getTfOldClientName(),updateClientInfoView.getTfNewClientName(),updateClientInfoView.getTfPersonalNumericalCode(),updateClientInfoView.getTfOldCardNumber(),updateClientInfoView.getTfNewCardNumber(),updateClientInfoView.getTfOldAddress(),updateClientInfoView.getTfNewAddress());
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
