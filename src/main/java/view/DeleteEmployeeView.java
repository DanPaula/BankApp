package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class DeleteEmployeeView extends JFrame{
    private JButton btnDelete;
    private JButton btnBack;
    private JTextField tfName;
    private JLabel labelName;
    private JTextField tfUsername;
    private JLabel labelUsername;

    public DeleteEmployeeView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelName);
        add(tfName);
        add(labelUsername);
        add(tfUsername);
        add(btnDelete);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        tfName = new JTextField();
        tfUsername = new JTextField();
        btnBack = new JButton("Back");
        btnDelete = new JButton("Delete");
        labelName=new JLabel("Employee Name");
        labelUsername=new JLabel("Employee Username");
    }

    public String getTfName() {
        return tfName.getText();
    }


    public String getTfUsername() {
        return tfUsername.getText();
    }

    public void setDeleteButtonListener(ActionListener deleteButtonListener) {
        btnDelete.addActionListener(deleteButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }
}
