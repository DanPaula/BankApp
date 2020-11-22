package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class TransferMoneyView extends JFrame {
    private JButton btnBack;
    private JButton btnTransferMoney;
    private JTextField tfAccountNumberSender;
    private JLabel labelAccountNumberSender;
    private JTextField tfAccountNumberReceiver;
    private JLabel labelAccountNumberReceiver;
    private JTextField tfMoneyAmount;
    private JLabel labelMoneyAmount;

    public TransferMoneyView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelAccountNumberSender);
        add(tfAccountNumberSender);
        add(labelAccountNumberReceiver);
        add(tfAccountNumberReceiver);
        add(labelMoneyAmount);
        add(tfMoneyAmount);
        add(btnTransferMoney);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        labelAccountNumberSender=new JLabel("Account Number Sender");
        tfAccountNumberSender = new JTextField();
        labelAccountNumberReceiver = new JLabel("Account Number Receiver");
        tfAccountNumberReceiver = new JTextField();
        labelMoneyAmount = new JLabel("Money Amount");
        tfMoneyAmount = new JTextField();
        btnTransferMoney = new JButton("Transfer");
        btnBack = new JButton("Back");
    }

    public String getTfAccountNumberSender() {
        return tfAccountNumberSender.getText();
    }

    public String getTfAccountNumberReceiver() {
        return tfAccountNumberReceiver.getText();
    }

    public int getTfMoneyAmount() {
        return Integer.parseInt(tfMoneyAmount.getText());
    }

    public void setDeleteAccountButtonListener(ActionListener transferMoneyButtonListener) {
        btnTransferMoney.addActionListener(transferMoneyButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }


}
