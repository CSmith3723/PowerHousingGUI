package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login implements ActionListener {


    JFrame frame = new JFrame();
    JLabel title = new JLabel("Welcome to PowerHousing!");
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Clear");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("User ID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel outputMessage = new JLabel();

    HashMap<String, String> loginInfo = new HashMap<>();

    public Login(){};

    protected Login(HashMap<String, String> userLoginInfo){
        loginInfo = userLoginInfo;

        title.setBounds(120,20,800, 50);
        title.setFont(new Font("Arial", Font.ITALIC, 40));

        userIDLabel.setBounds(150, 150, 150, 26);
        userIDField.setBounds(300, 150, 150, 26);
        userIDLabel.setFont(new Font("Arial",Font.BOLD, 26));
        userPasswordLabel.setBounds(150, 250, 150, 26);
        userPasswordField.setBounds(300, 250, 150, 26);
        userPasswordLabel.setFont(new Font("Arial",Font.BOLD, 26));
        outputMessage.setBounds(300,450,300,30);
        outputMessage.setFont(new Font("Arial", Font.ITALIC,26));

        loginButton.setBounds(275, 350, 100, 25);
        loginButton.addActionListener(this);
        resetButton.setBounds(375, 350, 100, 25);
        resetButton.addActionListener(this);

        frame.add(title);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(outputMessage);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource() == loginButton){
            String userID = userIDField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());

            if(loginInfo.containsKey(userID)){
                if(loginInfo.get(userID).equals(userPassword)){
                    outputMessage.setForeground(Color.green);
                    outputMessage.setText("Login Successful!");
                    frame.dispose();
                    Home homePage = new Home(userID);
                }else{
                    outputMessage.setForeground(Color.red);
                    outputMessage.setText("Password incorrect.");
                }
            }else{
                outputMessage.setForeground(Color.red);
                outputMessage.setText("Username not found.");
            }

        }


    }
}
