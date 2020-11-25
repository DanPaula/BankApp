package view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class ViewClientAccView extends JFrame {
    private JButton btnBack;
    private JButton btnViewClientAcc;
    private JTextField tfIdentificationNumber;
    private JLabel labelIdentificationNumber;

    public ViewClientAccView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelIdentificationNumber);
        add(tfIdentificationNumber);
        add(btnViewClientAcc);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        labelIdentificationNumber=new JLabel("Identification Number");
        tfIdentificationNumber = new JTextField();
        btnViewClientAcc = new JButton("View Account");
        btnBack = new JButton("Back");
    }

    public int getTfIdentificationNumber() {
        return Integer.parseInt(tfIdentificationNumber.getText());
    }

    public void setViewAccountButtonListener(ActionListener viewAccountButtonListener) {
        btnViewClientAcc.addActionListener(viewAccountButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }

}
