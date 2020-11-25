package controller.admin;

import controller.Controller;
import service.admin.AdminService;
import view.admin.GenerateReportsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateReportController {

    private final GenerateReportsView generateReportsView;
    private final AdminService adminService;

    public GenerateReportController(GenerateReportsView generateReportsView,AdminService adminService) {
        this.generateReportsView = generateReportsView;
        this.adminService = adminService;
        generateReportsView.setGenerateButtonListener(new GenerateButtonListener());
        generateReportsView.setBackButtonListener(new BackButtonListener());
    }

    public GenerateReportsView getGenerateView() {
        return generateReportsView;
    }

    private class GenerateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adminService.generateReports(generateReportsView.getTfStartingPeriod(),generateReportsView.getTfEndPeriod(),generateReportsView.getTfEmployeeName());
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.generateReportController.getGenerateView().setVisible(false);
            Controller.employeeController.getEmployeeView().setVisible(true);

        }
    }
}
