package com.Hussain.pink.triangle.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hussain on 01/12/2014.
 */
public class InitialView extends JFrame {
    private JButton registerButton;
    private JButton loginButton;
    private JPanel rootPanel;

    public InitialView(){
        super("Spam Client");

        setContentPane(rootPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addActionListeners();

        pack();

    }

    private void addActionListeners(){
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitialView.this.dispose();
                new RegisterView().setVisible(true);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitialView.this.dispose();
                new LoginView().setVisible(true);
            }
        });
    }


}
