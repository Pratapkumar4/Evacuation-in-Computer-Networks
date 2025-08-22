package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    JButton registerButton, loginButton;

    public MainMenu() {
        setTitle("Main Menu");
        setSize(300, 200);
        setLayout(new GridLayout(2, 1));

        registerButton = new JButton("Register");
        loginButton = new JButton("Login");

        registerButton.addActionListener(this);
        loginButton.addActionListener(this);

        add(registerButton);
        add(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            new Register();
        } else if (e.getSource() == loginButton) {
            new Login();
        }
        dispose(); // Close the main menu window
    }

    public static void main(String[] args) {

        new MainMenu();

    }
}
