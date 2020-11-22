package controller;

import model.User;
import model.validation.Notification;
import repository.admin.AdminRepository;
import repository.user.AuthenticationException;
import service.user.AuthenticationService;
import view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginController {
    private final LoginView loginView;
    private final AuthenticationService authenticationService;
    private final AdminRepository adminRepository;

    public LoginController(LoginView loginView, AuthenticationService authenticationService,AdminRepository adminRepository) {
        this.loginView = loginView;
        this.authenticationService = authenticationService;
        this.adminRepository=adminRepository;
        loginView.setLoginButtonListener(new LoginButtonListener());
        //loginView.setRegisterButtonListener(new RegisterButtonListener());
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setId(String username){adminRepository.findIdByUsername(username);}

    private class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();

            Notification<User> loginNotification = null;
            try {
                loginNotification = authenticationService.login(username, password);
            } catch (AuthenticationException e1) {
                e1.printStackTrace();
            }

            if (loginNotification != null) {
                if (loginNotification.hasErrors()) {
                    JOptionPane.showMessageDialog(loginView.getContentPane(), loginNotification.getFormattedErrors());
                } else {
                    if(authenticationService.UserRole(username,password).equals("administrator")) {
                        Controller.adminController.getAdminView().setVisible(true);
                        Controller.loginController.getLoginView().setVisible(false);
                        //JOptionPane.showMessageDialog(loginView.getContentPane(), "Login successful!");
                    }
                    else if(authenticationService.UserRole(username,password).equals("employee")) {
                        Controller.employeeController.getEmployeeView().setVisible(true);
                        Controller.loginController.getLoginView().setVisible(false);
                        Controller.loginController.setId(username);
                        //JOptionPane.showMessageDialog(loginView.getContentPane(), "Login successful!");
                    }
                }
            }
        }
    }


    private class RegisterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();

            Notification<Boolean> registerNotification = authenticationService.register(username, password);
            if (registerNotification.hasErrors()) {
                JOptionPane.showMessageDialog(loginView.getContentPane(), registerNotification.getFormattedErrors());
            } else {
                if (!registerNotification.getResult()) {
                    JOptionPane.showMessageDialog(loginView.getContentPane(), "Registration not successful, please try again later.");
                } else {
                    JOptionPane.showMessageDialog(loginView.getContentPane(), "Registration successful!");
                }
            }
        }
    }


}