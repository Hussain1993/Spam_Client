package com.Hussain.pink.triangle.Views;

import com.Hussain.pink.triangle.Model.DatabaseQueries.DatabaseQueries;
import com.Hussain.pink.triangle.Model.User;
import com.Hussain.pink.triangle.Utils.HashingFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Hussain on 01/12/2014.
 */
public class LoginView extends JFrame {
    private static final Logger LOG = LoggerFactory.getLogger(LoginView.class);

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
        getRootPane().setDefaultButton(loginButton);

        addActionListeners();

        pack();
    }


    private void addActionListeners(){
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameText.getText();
                String password = new String(passwordText.getPassword());
                if(!username.isEmpty() && !password.isEmpty())
                {
                    try {
                        String hashedPassword = HashingFunctions.hashPassword(password);
                        User loggedInUser = DatabaseQueries.loginUser(username,hashedPassword);
                        if(loggedInUser == null)
                        {
                            statusLabel.setText("Try Again");
                        }
                        else
                        {
                            statusLabel.setText("Logged in");
                        }
                    }
                    catch (NoSuchAlgorithmException e1) {
                        LOG.error("There was an error while hashing the password for the login", e1);
                    }
                }
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
