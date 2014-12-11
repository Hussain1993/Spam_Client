package com.Hussain.pink.triangle.Views;

import com.Hussain.pink.triangle.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hussain on 11/12/2014.
 */
public class UploadEmailView extends JFrame{
    private static final Logger LOG = LoggerFactory.getLogger(UploadEmailView.class);

    private JButton browseButton;
    private JButton scanButton;
    private JLabel statusLabel;
    private JTextField emailPathText;
    private JPanel rootPanel;

    private User user;

    public UploadEmailView(User user){
        super("Upload email to scan");

        this.user = user;

        setContentPane(rootPanel);
        getRootPane().setDefaultButton(scanButton);

        addActionListeners();

        pack();
    }

    private void addActionListeners(){
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
