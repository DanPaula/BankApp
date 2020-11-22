package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class UpdateClientAccView extends JFrame {

    private JButton btnBack;
    private JButton btnUpdateClientAcc;
    private JTextField tfIdentificationNumber;
    private JLabel labelIdentificationNumber;
    private JTextField tfAccountType;
    private JLabel labelAccountType;
    private JTextField tfMoneyAmount;
    private JLabel labelMoneyAmount;

    public UpdateClientAccView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelIdentificationNumber);
        add(tfIdentificationNumber);
        add(labelAccountType);
        add(tfAccountType);
        add(labelMoneyAmount);
        add(tfMoneyAmount);
        add(btnUpdateClientAcc);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        labelIdentificationNumber=new JLabel("Identification Number");
        tfIdentificationNumber = new JTextField();
        labelAccountType = new JLabel("Account Type");
        tfAccountType = new JTextField();
        labelMoneyAmount = new JLabel("Money Amount");
        tfMoneyAmount = new JTextField();
        btnUpdateClientAcc = new JButton("Update Account");
        btnBack = new JButton("Back");
    }

    public int getTfIdentificationNumber() {
        return Integer.parseInt(tfIdentificationNumber.getText());
    }

    public String getTfAccountType() {
        return tfAccountType.getText();
    }

    public int getTfMoneyAmount() {
        return Integer.parseInt(tfMoneyAmount.getText());
    }

    public void setUpdateAccountButtonListener(ActionListener updateAccountButtonListener) {
        btnUpdateClientAcc.addActionListener(updateAccountButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }

}
