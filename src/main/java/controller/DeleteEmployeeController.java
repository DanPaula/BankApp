package controller;

import service.admin.AdminService;
import view.DeleteEmployeeView;
import view.UpdateEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEmployeeController {

    private final DeleteEmployeeView deleteEmployeeView;
    private final AdminService adminService;

    public DeleteEmployeeController(DeleteEmployeeView deleteEmployeeView, AdminService adminService) {
        this.deleteEmployeeView = deleteEmployeeView;
        this.adminService = adminService;
        deleteEmployeeView.setDeleteButtonListener(new DeleteButtonListener());
        deleteEmployeeView.setBackButtonListener(new BackButtonListener());
    }

    public DeleteEmployeeView getDeleteEmployeeView() {
        return deleteEmployeeView;
    }

    private class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adminService.deleteEmployee(deleteEmployeeView.getTfName(),deleteEmployeeView.getTfUsername());

        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.deleteEmployeeController.getDeleteEmployeeView().setVisible(false);
            Controller.adminController.getAdminView().setVisible(true);

        }
    }
}
