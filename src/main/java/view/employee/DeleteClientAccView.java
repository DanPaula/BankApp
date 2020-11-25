package view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class DeleteClientAccView extends JFrame{

    private JButton btnBack;
    private JButton btnDeleteClientAcc;
    private JTextField tfIdentificationNumber;
    private JLabel labelIdentificationNumber;
    private JTextField tfAccountType;
    private JLabel labelAccountType;

    public DeleteClientAccView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelIdentificationNumber);
        add(tfIdentificationNumber);
        add(labelAccountType);
        add(tfAccountType);
        add(btnDeleteClientAcc);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        labelIdentificationNumber=new JLabel("Identification Number");
        tfIdentificationNumber = new JTextField();
        labelAccountType = new JLabel("Account Type");
        tfAccountType = new JTextField();
        btnDeleteClientAcc = new JButton("Delete Account");
        btnBack = new JButton("Back");
    }

    public int getTfIdentificationNumber() {
        return Integer.parseInt(tfIdentificationNumber.getText());
    }

    public String getTfAccountType() {
        return tfAccountType.getText();
    }

    public void setDeleteAccountButtonListener(ActionListener deleteAccountButtonListener) {
        btnDeleteClientAcc.addActionListener(deleteAccountButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }

}
