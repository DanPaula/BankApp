package view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class UpdateClientInfoView extends JFrame{
    private JButton btnBack;
    private JButton btnUpdateClient;
    private JTextField tfOldClientName;
    private JLabel labelOldClientName;
    private JTextField tfNewClientName;
    private JLabel labelNewClientName;
    private JTextField tfOldCardNumber;
    private JLabel labelOldCardNumber;
    private JTextField tfNewCardNumber;
    private JLabel labelNewCardNumber;
    private JTextField tfPersonalNumericalCode;
    private JLabel labelPersonalNumericalCode;
    private JTextField tfOldAddress;
    private JLabel labelOldAddress;
    private JTextField tfNewAddress;
    private JLabel labelNewAddress;

    //nu am modificat cnp-ul deorece nu se poate modifica
    //voi cauta dupa el deoarece este unic
    public UpdateClientInfoView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelOldClientName);
        add(tfOldClientName);
        add(labelNewClientName);
        add(tfNewClientName);
        add(labelPersonalNumericalCode);
        add(tfPersonalNumericalCode);
        add(labelOldAddress);
        add(tfOldAddress);
        add(labelNewAddress);
        add(tfNewAddress);
        add(labelOldCardNumber);
        add(tfOldCardNumber);
        add(labelNewCardNumber);
        add(tfNewCardNumber);
        add(btnUpdateClient);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        labelOldClientName = new JLabel("Old Client Name");
        tfOldClientName = new JTextField();
        labelNewClientName = new JLabel("New Client Name");
        tfNewClientName = new JTextField();
        labelOldAddress = new JLabel("Old Address");
        tfOldAddress = new JTextField();
        labelNewAddress = new JLabel("New Address");
        tfNewAddress = new JTextField();
        labelOldCardNumber = new JLabel("Old Card Number");
        tfOldCardNumber = new JTextField();
        labelNewCardNumber = new JLabel("New Card Number");
        tfNewCardNumber = new JTextField();
        labelPersonalNumericalCode = new JLabel("Personal Numerical Code");
        tfPersonalNumericalCode = new JTextField();
        btnBack=new JButton("Back");
        btnUpdateClient=new JButton("Update");
    }

    public String getTfOldClientName() {
        return tfOldClientName.getText();
    }
    public String getTfNewClientName() {
        return tfNewClientName.getText();
    }
    public String getTfOldAddress() {
        return tfOldAddress.getText();
    }
    public String getTfNewAddress() {
        return tfNewAddress.getText();
    }
    public String getTfOldCardNumber() {
        return tfOldCardNumber.getText();
    }
    public String getTfNewCardNumber() {
        return tfNewCardNumber.getText();
    }
    public String getTfPersonalNumericalCode() {
        return tfPersonalNumericalCode.getText();
    }

    public void setUpdateClientButtonListener(ActionListener updateClientButtonListener) {
        btnUpdateClient.addActionListener(updateClientButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }
}
