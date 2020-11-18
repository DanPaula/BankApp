package controller;

import service.admin.AdminService;
import view.CreateEmployeeView;
import view.UpdateEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEmployeeController {
    private final UpdateEmployeeView updateEmployeeView;
    private final AdminService adminService;

    public UpdateEmployeeController(UpdateEmployeeView updateEmployeeView, AdminService adminService) {
        this.updateEmployeeView = updateEmployeeView;
        this.adminService = adminService;
        updateEmployeeView.setUpdateButtonListener(new UpdateButtonListener());
        updateEmployeeView.setBackButtonListener(new BackButtonListener());
    }

    public UpdateEmployeeView getUpdateEmployeeView() {
        return updateEmployeeView;
    }

    private class UpdateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adminService.updateEmployee(updateEmployeeView.getTfOldName(),updateEmployeeView.getTfNewName(),updateEmployeeView.getTfOldUsername(),updateEmployeeView.getTfNewUsername(),updateEmployeeView.getTfPassword());

        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.updateEmployeeController.getUpdateEmployeeView().setVisible(false);
            Controller.adminController.getAdminView().setVisible(true);

        }
    }
}
