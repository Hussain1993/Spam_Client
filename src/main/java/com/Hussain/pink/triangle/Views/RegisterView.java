package com.Hussain.pink.triangle.Views;

import com.Hussain.pink.triangle.Model.DatabaseQueries.DatabaseQueries;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hussain on 01/12/2014.
 */
public class RegisterView extends JFrame {

    private JPanel rootPanel;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton registerButton;
    private JButton loginScreenButton;
    private JButton backButton;
    private JLabel statusLabel;

    public RegisterView(){
        super("Register for the Spam Client");

        setContentPane(rootPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addActionListeners();

        pack();
    }

    private void addActionListeners(){
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameText.getText();
                if(DatabaseQueries.userExistsInDatabase(username))
                {
                    usernameText.setText("");
                    JOptionPane.showMessageDialog(RegisterView.this, "Please choose another username", "Warning", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        loginScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterView.this.dispose();
                new LoginView().setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterView.this.dispose();
                new InitialView().setVisible(true);
            }
        });
    }
}
