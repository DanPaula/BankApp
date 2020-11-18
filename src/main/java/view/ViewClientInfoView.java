package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class ViewClientInfoView extends JFrame{
    private JButton btnView;
    private JButton btnBack;
    private JLabel labelClientName;
    private JTextField tfClientName;
    private JTextField tfPersonalNumericalCode;
    private JLabel labelPersonalNumericalCode;

    public ViewClientInfoView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelClientName);
        add(tfClientName);
        add(labelPersonalNumericalCode);
        add(tfPersonalNumericalCode);
        add(btnView);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        labelClientName = new JLabel("Client Name");
        tfClientName = new JTextField();
        labelPersonalNumericalCode = new JLabel("Personal Numerical Code");
        tfPersonalNumericalCode = new JTextField();
        btnBack=new JButton("Back");
        btnView=new JButton("View Information");
    }

    public String getTfClientName() {
        return tfClientName.getText();
    }
    public String getTfPersonalNumericalCode() {
        return tfPersonalNumericalCode.getText();
    }

    public void setViewClientButtonListener(ActionListener viewClientButtonListener) {
        btnView.addActionListener(viewClientButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }
}
