package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class EmployeeView extends JFrame{
    private JButton btnAddClientInfo;
    private JButton btnUpdateClientInfo;
    private JButton btnViewClientInfo;
    private JButton btnCreateClientAcc;
    private JButton btnUpdateClientAcc;
    private JButton btnDeleteClientAcc;
    private JButton btnViewClientAcc;
    private JButton btnTransferMoney;
    private JButton btnProcessBills;
    private JButton btnBack;

    public EmployeeView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(btnAddClientInfo);
        add(btnUpdateClientInfo);
        add(btnViewClientInfo);
        add(btnCreateClientAcc);
        add(btnUpdateClientAcc);
        add(btnDeleteClientAcc);
        add(btnViewClientAcc);
        add(btnTransferMoney);
        add(btnProcessBills);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        btnAddClientInfo = new JButton("Add Client Information");
        btnUpdateClientInfo = new JButton("Update Client Information");
        btnViewClientInfo = new JButton("View Client Information");
        btnCreateClientAcc = new JButton("Create Client Account");
        btnUpdateClientAcc = new JButton("Update Client Account");
        btnDeleteClientAcc = new JButton("Delete Client Account");
        btnViewClientAcc = new JButton("View Client Account");
        btnTransferMoney = new JButton("Transfer Money");
        btnProcessBills = new JButton("Process Bills");
        btnBack = new JButton("Back");
    }

    public void addClientInfoButtonListener(ActionListener addClientInfoButtonListener) {
        btnAddClientInfo.addActionListener(addClientInfoButtonListener);
    }

    public void updateClientInfoButtonListener(ActionListener updateClientInfoButtonListener) {
        btnUpdateClientInfo.addActionListener(updateClientInfoButtonListener);
    }

    public void viewClientInfoButtonListener(ActionListener viewClientInfoButtonListener) {
        btnViewClientInfo.addActionListener(viewClientInfoButtonListener);
    }
    public void createClientAccButtonListener(ActionListener createClientAccButtonListener) {
        btnCreateClientAcc.addActionListener(createClientAccButtonListener);
    }

    public void updateClientAccButtonListener(ActionListener updateClientAccButtonListener) {
        btnUpdateClientAcc.addActionListener(updateClientAccButtonListener);
    }

    public void deleteClientAccButtonListener(ActionListener deleteClientAccButtonListener) {
        btnDeleteClientAcc.addActionListener(deleteClientAccButtonListener);
    }

    public void viewClientAccButtonListener(ActionListener viewClientInfoAccListener) {
        btnViewClientAcc.addActionListener(viewClientInfoAccListener);
    }

    public void transferMoneyButtonListener(ActionListener transferMoneyListener) {
        btnTransferMoney.addActionListener(transferMoneyListener);
    }

    public void processBillsButtonListener(ActionListener processBillsListener) {
        btnProcessBills.addActionListener(processBillsListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }

}
