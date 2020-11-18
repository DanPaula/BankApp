package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class CreateEmployeeView extends JFrame{
    private JButton btnCreate;
    private JButton btnBack;
    private JTextField tfName;
    private JLabel labelName;
    private JTextField tfusername;
    private JLabel labelUsername;
    private JTextField tfPassword;
    private JLabel labelPassword;

    public CreateEmployeeView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelName);
        add(tfName);
        add(labelUsername);
        add(tfusername);
        add(labelPassword);
        add(tfPassword);
        add(btnCreate);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        tfName = new JTextField();
        tfusername = new JTextField();
        tfPassword = new JTextField();
        btnBack = new JButton("Back");
        btnCreate = new JButton("Create");
        labelName=new JLabel("Employee Name");
        labelUsername=new JLabel("Employee Username");
        labelPassword=new JLabel("Employee Password");
    }

    public String getTfName() {
        return tfName.getText();
    }


    public String getTfPassword() {
        return tfPassword.getText();
    }


    public String getUsername() {
        return tfusername.getText();
    }

    public void setCreateButtonListener(ActionListener createButtonListener) {
        btnCreate.addActionListener(createButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }
}
