package pages;


import data.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Home implements ActionListener {

    DBConnection dbConnection = new DBConnection();

    String url = dbConnection.getUrl();
    String user = dbConnection.getUser();
    String pass = dbConnection.getPass();
    String newSql = dbConnection.getSql();

    public String neighborhoodValue;

    String [] wageTypes = {"Salaried", "Hourly"};
    String [] locations = {"Apollo Beach","Brandon"};
    String [] housingTypes = {"Home", "One-Bedroom Apartment", "Two-Bedroom Apartment"};


    JFrame frame = new JFrame();

    JComboBox<String> wageType = new JComboBox<>(wageTypes);
    JComboBox<String> neighborhoodComboBox = new JComboBox<>(locations);
    JComboBox<String> housingTypeComboBox = new JComboBox<>(housingTypes);

    JButton calculate = new JButton("Calculate");

    JLabel title = new JLabel("Welcome to PowerHousing!");
    JLabel hoursWorkedLabel = new JLabel("Hours Worked:");
    JLabel monthlyExpensesLabel = new JLabel("Monthly Expenses:");
    JLabel grossMonthlyWagesLabel = new JLabel("Gross Monthly Income:");
    JLabel netMonthlyWagesLabel = new JLabel("Net Monthly Income:");
    JLabel neighborhoodLabel = new JLabel("Neighborhood:");
    JLabel housingTypeLabel = new JLabel("Housing Type:");
    JLabel welcome = new JLabel();
    JLabel grossMonthlyWagesOutput = new JLabel();
    JLabel netMonthlyWagesOutput = new JLabel();

    JTextField hoursWorkedField = new JTextField();
    JTextField monthlyExpensesField = new JTextField();
    JTextField wageField = new JTextField();

    public Home(){}

    protected Home(String userName) {

     title.setBounds(120,20,800,50);
     title.setFont(new Font("Arial",Font.ITALIC, 40));

     welcome.setBounds(500,75,300,24);
     welcome.setText("Welcome back, " + userName);
     welcome.setFont(new Font("Arial",Font.PLAIN, 16));

     wageType.setBounds(50,300,100,24);
     wageType.setFont(new Font("Arial", Font.PLAIN,16));
     wageField.setBounds(200,300,150,24);

     hoursWorkedLabel.setBounds(50,350,150,24);
     hoursWorkedLabel.setFont(new Font("Arial",Font.PLAIN, 16));
     hoursWorkedField.setBounds(200,350,150,24);

     monthlyExpensesLabel.setBounds(50,400,150,24);
     monthlyExpensesLabel.setFont(new Font("Arial",Font.PLAIN, 16));
     monthlyExpensesField.setBounds(200,400,150,24);


     neighborhoodLabel.setBounds(50,500,125,24);
     neighborhoodLabel.setFont(new Font("Arial",Font.PLAIN, 16));
     neighborhoodComboBox.setBounds(200,500,150,24);
     neighborhoodComboBox.setFont(new Font("Arial",Font.PLAIN, 16));
     neighborhoodComboBox.addActionListener(this);

     housingTypeLabel.setBounds(400,500,100,24);
     housingTypeLabel.setFont(new Font("Arial",Font.PLAIN, 16));
     housingTypeComboBox.setBounds(550,500,150,24);
     housingTypeComboBox.setFont(new Font("Arial",Font.PLAIN, 16));

     calculate.setBounds(375, 550, 100, 24);
     calculate.addActionListener(this);

     grossMonthlyWagesOutput.setBounds(300,600,200,24);
     grossMonthlyWagesOutput.setFont(new Font("Arial",Font.PLAIN, 16));
     grossMonthlyWagesLabel.setBounds(50,600,200,24);
     grossMonthlyWagesLabel.setFont(new Font("Arial",Font.PLAIN, 16));

     netMonthlyWagesOutput.setBounds(300,650,200,24);
     netMonthlyWagesOutput.setFont(new Font("Arial",Font.PLAIN, 16));
     netMonthlyWagesLabel.setBounds(50,650,200,24);
     netMonthlyWagesLabel.setFont(new Font("Arial",Font.PLAIN, 16));




     frame.add(title);
     frame.add(welcome);
     frame.add(wageType);
     frame.add(wageField);
     frame.add(hoursWorkedLabel);
     frame.add(hoursWorkedField);
     frame.add(monthlyExpensesLabel);
     frame.add(neighborhoodLabel);
     frame.add(neighborhoodComboBox);
     frame.add(housingTypeLabel);
     frame.add(housingTypeComboBox);
     frame.add(grossMonthlyWagesLabel);
     frame.add(grossMonthlyWagesOutput);
     frame.add(netMonthlyWagesLabel);
     frame.add(netMonthlyWagesOutput);
     frame.add(monthlyExpensesField);

     frame.add(calculate);

     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(800,800);
     frame.setLayout(null);
     frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calculate){
            grossMonthlyWagesOutput.setText(String.format("%.2f", calculateMonthlyWages()));

        }
        if(e.getSource() == neighborhoodComboBox){
            grossMonthlyWagesOutput.setText(getNeighborhoodComboBox());
            dbConnection.setSql("SELECT * FROM neighborhoods WHERE neighborhood = " + "'" + getNeighborhoodComboBox()+ "'");
            try {
                System.out.println("Connection Successful.");
                Connection connection = DriverManager.getConnection(url, user, pass);
                Statement statement = connection.createStatement();
                newSql = dbConnection.getSql();
                ResultSet rs = statement.executeQuery(newSql);


                while(rs.next()) {
                    System.out.println("Median housing prices for " + getNeighborhoodComboBox() + ": "
                            + (rs.getInt("median_home_price") + " "
                            + rs.getInt("median_onebr_apt_price") + " "
                            + rs.getInt("median_twobr_apt_price")));

                }
                connection.close();

            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }


    }


    public double calculateMonthlyWages() {

        double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
        double wages = Double.parseDouble(wageField.getText());


        if (wageType.getSelectedItem() == "Salaried") {
            return wages / 12;
        } else if (wageType.getSelectedItem() == "Hourly") {
            return hoursWorked * 4 * wages;
        }
        return 0.00;
    }

    public  String getHousingTypeComboBox() {
        return String.valueOf(housingTypeComboBox.getSelectedItem());
    }

    public  String getNeighborhoodComboBox(){
        return String.valueOf(neighborhoodComboBox.getSelectedItem());
    }



}
