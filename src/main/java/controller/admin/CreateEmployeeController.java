package controller.admin;

import controller.Controller;
import service.admin.AdminService;
import view.admin.CreateEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateEmployeeController {
    private final CreateEmployeeView createEmployeeView;
    private final AdminService adminService;

    public CreateEmployeeController(CreateEmployeeView createEmployeeView, AdminService adminService) {
        this.createEmployeeView = createEmployeeView;
        this.adminService = adminService;
        createEmployeeView.setCreateButtonListener(new CreateButtonListener());
        createEmployeeView.setBackButtonListener(new BackButtonListener());
    }

    public CreateEmployeeView getCreateEmployeeView() {
        return createEmployeeView;
    }

    private class CreateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adminService.createEmployee(createEmployeeView.getTfName(),createEmployeeView.getUsername(),createEmployeeView.getTfPassword());

        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.createEmployeeController.getCreateEmployeeView().setVisible(false);
            Controller.adminController.getAdminView().setVisible(true);

        }
    }


}
