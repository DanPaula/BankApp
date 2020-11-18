package controller;

import service.clientInfoService.ClientInfoService;
import view.UpdateClientInfoView;
import view.ViewClientInfoView;

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
            clientInfoService.viewClientInfo(viewClientInfoView.getTfClientName(),viewClientInfoView.getTfPersonalNumericalCode());
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
