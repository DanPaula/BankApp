package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class ReadEmployeeView extends JFrame{
    private JButton btnRead;
    private JButton btnBack;

    public ReadEmployeeView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(btnRead);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        btnBack = new JButton("Back");
        btnRead = new JButton("Read Employee");
    }

    public void setReadButtonListener(ActionListener readButtonListener) {
        btnRead.addActionListener(readButtonListener);
    }

    public void setBackButtonListener(ActionListener backButtonListener) {
        btnBack.addActionListener(backButtonListener);
    }
}
