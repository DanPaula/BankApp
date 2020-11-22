package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import static javax.swing.BoxLayout.Y_AXIS;

public class GenerateReportsView  extends JFrame{
    private JButton btnGenerate;
    private JButton btnBack;
    private JLabel labelStartingPeriod;
    private JLabel labelEndPeriod;
    private JTextField tfStartingPeriod;
    private JTextField tfEndPeriod;
    private JLabel labelEmployeeName;
    private JTextField tfEmployeeName;

    public GenerateReportsView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(labelStartingPeriod);
        add(tfStartingPeriod);
        add(labelEndPeriod);
        add(tfEndPeriod);
        add(labelEmployeeName);
        add(tfEmployeeName);
        add(btnGenerate);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        labelStartingPeriod = new JLabel("Starting Period");
        labelEndPeriod = new JLabel("End Period");
        tfStartingPeriod = new JTextField();
        tfEndPeriod = new JTextField();
        labelEmployeeName = new JLabel("Employee Name");
        tfEmployeeName = new JTextField();
        btnBack = new JButton("Back");
        btnGenerate = new JButton("Generate");
    }

    public Timestamp getTfStartingPeriod() {
        return Timestamp.valueOf(tfStartingPeriod.getText());
    }

    public Timestamp getTfEndPeriod() {
        return Timestamp.valueOf(tfEndPeriod.getText());
    }

    public String getTfEmployeeName() { return tfEmployeeName.getText(); }

    public void setGenerateButtonListener(ActionListener generateButtonListener) {
        btnGenerate.addActionListener(generateButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }

}
