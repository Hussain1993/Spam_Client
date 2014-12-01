package com.Hussain.pink.triangle.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hussain on 01/12/2014.
 */
public class LoginView extends JFrame {

    private JPanel rootPanel;
    private JButton loginButton;
    private JButton backButton;
    private JTextField usernameText;
    private JLabel statusLabel;
    private JPasswordField passwordText;
    private JButton registerButton;

    public LoginView(){
        super("Login to Spam Client");

        setContentPane(rootPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addActionListeners();

        pack();
    }


    private void addActionListeners(){
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginView.this.dispose();
                new InitialView().setVisible(true);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginView.this.dispose();
                new RegisterView().setVisible(true);
            }
        });
    }

}
