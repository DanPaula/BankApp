package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;


public class LoginView extends JFrame {

    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JButton btnLogin;
    private JButton btnLogout;

    public LoginView() throws HeadlessException {
        setSize(300, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(tfUsername);
        add(tfPassword);
        add(btnLogin);
        add(btnLogout);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        tfUsername = new JTextField();
        tfPassword = new JPasswordField();
        btnLogin = new JButton("Login");
        btnLogout = new JButton("Logout");
    }

    public String getUsername() {
        return tfUsername.getText();
    }

    public String getPassword() {
        return tfPassword.getText();
    }

    public void setUsername() {tfUsername.setText("");}

    public void setPassword() {tfPassword.setText("");
    }

    public void setLoginButtonListener(ActionListener loginButtonListener) {
        btnLogin.addActionListener(loginButtonListener);
    }

    public void setLogoutButtonListener(ActionListener logoutButtonListener) {
        btnLogout.addActionListener(logoutButtonListener);
    }

}
