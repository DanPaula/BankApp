package view;

import controller.AdminController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class AdminView extends JFrame {
    private JButton btnCreate;
    private JButton btnRead;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnReport;
    private JButton btnBack;

    public AdminView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(btnCreate);
        add(btnRead);
        add(btnUpdate);
        add(btnDelete);
        add(btnReport);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        btnCreate = new JButton("Create Employee");
        btnRead = new JButton("Read Employee");
        btnUpdate = new JButton("Update Employee");
        btnDelete = new JButton("Delete Employee");
        btnReport = new JButton("Generate Reports");
        btnBack = new JButton("Back");
    }

    public void setCreateButtonListener(ActionListener createButtonListener) {
        btnCreate.addActionListener(createButtonListener);
    }

    public void setReadButtonListener(ActionListener readButtonListener) {
        btnRead.addActionListener(readButtonListener);
    }

    public void setUpdateButtonListener(ActionListener updateButtonListener) {
        btnUpdate.addActionListener(updateButtonListener);
    }

    public void setDeleteButtonListener(ActionListener deleteButtonListener) {
        btnDelete.addActionListener(deleteButtonListener);
    }
    public void setReportButtonListener(ActionListener reportButtonListener) {
        btnReport.addActionListener(reportButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }
}
