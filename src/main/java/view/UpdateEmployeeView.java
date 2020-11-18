package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class UpdateEmployeeView extends JFrame{
    private JButton btnUpdate;
    private JButton btnBack;
    private JTextField tfOldName;
    private JLabel labelOldName;
    private JTextField tfNewName;
    private JLabel labelNewName;
    private JTextField tfOldUsername;
    private JLabel labelOldUsername;
    private JTextField tfNewUsername;
    private JLabel labelNewUsername;
    private JTextField tfPassword;
    private JLabel labelPassword;

    public UpdateEmployeeView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelOldName);
        add(tfOldName);
        add(labelNewName);
        add(tfNewName);
        add(labelOldUsername);
        add(tfOldUsername);
        add(labelNewUsername);
        add(tfNewUsername);
        add(labelPassword);
        add(tfPassword);
        add(btnUpdate);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        tfOldName = new JTextField();
        tfNewName = new JTextField();
        tfOldUsername = new JTextField();
        tfNewUsername = new JTextField();
        tfPassword = new JTextField();
        btnBack = new JButton("Back");
        btnUpdate = new JButton("Update");
        labelOldName=new JLabel("Old Employee Name");
        labelNewName=new JLabel("New Employee Name");
        labelOldUsername=new JLabel("Old Employee Username");
        labelNewUsername=new JLabel("New Employee Username");
        labelPassword=new JLabel("New Employee Password");
    }

    public String getTfOldName() {
        return tfOldName.getText();
    }

    public String getTfNewName() {
        return tfNewName.getText();
    }

    public String getTfPassword() {
        return tfPassword.getText();
    }


    public String getTfOldUsername() {
        return tfOldUsername.getText();
    }
    public String getTfNewUsername() {
        return tfNewUsername.getText();
    }


    public void setUpdateButtonListener(ActionListener updateButtonListener) {
        btnUpdate.addActionListener(updateButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }
}
