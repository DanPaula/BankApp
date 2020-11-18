package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class AddClientInfoView extends JFrame{
    private JButton btnBack;
    private JButton btnAddClient;
    private JTextField tfClientName;
    private JLabel labelClientName;
    private JTextField tfCardNumber;
    private JLabel labelCardNumber;
    private JTextField tfPersonalNumericalCode;
    private JLabel labelPersonalNumericalCode;
    private JTextField tfAddress;
    private JLabel labelAddress;

    public AddClientInfoView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelClientName);
        add(tfClientName);
        add(labelPersonalNumericalCode);
        add(tfPersonalNumericalCode);
        add(labelAddress);
        add(tfAddress);
        add(labelCardNumber);
        add(tfCardNumber);
        add(btnAddClient);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        labelClientName = new JLabel("Client Name");
        tfClientName = new JTextField();
        labelPersonalNumericalCode = new JLabel("Personal Numerical Code");
        tfPersonalNumericalCode = new JTextField();
        labelAddress = new JLabel("Address");
        tfAddress = new JTextField();
        labelCardNumber = new JLabel("Identity Card Number");
        tfCardNumber = new JTextField();
        btnAddClient = new JButton("Add Client");
        btnBack = new JButton("Back");

    }

    public String getTfClientName() {
        return tfClientName.getText();
    }

    public String getTfPersonalNumericalCode() {
        return tfPersonalNumericalCode.getText();
    }

    public String getTfAddress() {
        return tfAddress.getText();
    }

    public String getTfCardNumber() {
        return tfCardNumber.getText();
    }

    public void setAddClientButtonListener(ActionListener addClientButtonListener) {
        btnAddClient.addActionListener(addClientButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }

}
