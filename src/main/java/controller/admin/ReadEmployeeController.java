package controller.admin;

import controller.Controller;
import service.admin.AdminService;
import view.admin.ReadEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadEmployeeController {
    private final ReadEmployeeView readEmployeeView;
    private final AdminService adminService;

    public ReadEmployeeController(ReadEmployeeView readEmployeeView, AdminService adminService) {
        this.readEmployeeView = readEmployeeView;
        this.adminService = adminService;
        readEmployeeView.setReadButtonListener(new ReadButtonListener());
        readEmployeeView.setBackButtonListener(new BackButtonListener());
    }

    public ReadEmployeeView getReadEmployeeView() {
        return readEmployeeView;
    }

    private class ReadButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           adminService.readEmployee();
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.adminController.getAdminView().setVisible(true);
            Controller.readEmployeeController.getReadEmployeeView().setVisible(false);

        }
    }
}
