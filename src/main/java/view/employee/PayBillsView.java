package view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class PayBillsView extends JFrame {
    private JButton btnBack;
    private JButton btnPay;
    private JTextField tfCompanyName;
    private JLabel labelCompanyName;
    private JTextField tfMoneyAmount;
    private JLabel labelMoneyAmount;
    private JTextField tfClientName;
    private JLabel labelClientName;

    public PayBillsView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelCompanyName);
        add(tfCompanyName);
        add(labelMoneyAmount);
        add(tfMoneyAmount);
        add(labelClientName);
        add(tfClientName);
        add(btnPay);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        labelCompanyName = new JLabel("Company Name");
        tfCompanyName = new JTextField();
        labelClientName = new JLabel("Client Name");
        tfClientName = new JTextField();
        labelMoneyAmount = new JLabel("Money Amount");
        tfMoneyAmount = new JTextField();
        btnPay = new JButton("Pay");
        btnBack = new JButton("Back");
    }

    public String getTfCompanyName() {
        return tfCompanyName.getText();
    }

    public int getTfMoneyAmount() {
        return Integer.parseInt(tfMoneyAmount.getText());
    }

    public String getTfClientName() {
        return tfClientName.getText();
    }

    public void setPayButtonListener(ActionListener createAccountButtonListener) {
        btnPay.addActionListener(createAccountButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }

}
