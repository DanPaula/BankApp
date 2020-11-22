package controller;

import view.AdminView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController {

    private final AdminView adminView;


    public AdminController(AdminView adminView) {
        this.adminView = adminView;
        adminView.setCreateButtonListener(new CreateButtonListener());
        adminView.setReadButtonListener(new ReadButtonListener());
        adminView.setUpdateButtonListener(new UpdateButtonListener());
        adminView.setDeleteButtonListener(new DeleteButtonListener());
        adminView.setReportButtonListener(new ReportButtonListener());
        adminView.setBackButtonListener(new BackButtonListener());
    }

    public AdminView getAdminView() {
        return adminView;
    }

    private class CreateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Controller.createEmployeeController.getCreateEmployeeView().setVisible(true);
            Controller.adminController.getAdminView().setVisible(false);

        }
    }

    private class ReadButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.readEmployeeController.getReadEmployeeView().setVisible(true);
            Controller.adminController.getAdminView().setVisible(false);
        }
    }

    private class UpdateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.updateEmployeeController.getUpdateEmployeeView().setVisible(true);
            Controller.adminController.getAdminView().setVisible(false);
        }
    }

    private class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.deleteEmployeeController.getDeleteEmployeeView().setVisible(true);
            Controller.adminController.getAdminView().setVisible(false);
        }
    }

    private class ReportButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.generateReportController.getGenerateView().setVisible(true);
            Controller.adminController.getAdminView().setVisible(false);
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.adminController.getAdminView().setVisible(false);
            Controller.loginController.getLoginView().setVisible(true);
        }
    }



}
