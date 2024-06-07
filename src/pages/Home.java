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


    String[] wageTypes = {"Salaried", "Hourly"};
    String[] locations = {"Apollo Beach", "Brandon"};
    String[] housingTypes = {"Home", "One-Bedroom Apartment", "Two-Bedroom Apartment"};


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
    JLabel medianHomePrice = new JLabel("Median Home Price:");
    JLabel median1BRAptPrice = new JLabel("Median One Bedroom Apt:");
    JLabel median2BRAptPrice = new JLabel("Median Two Bedroom Apt:");
    JLabel welcome = new JLabel();
    JLabel grossMonthlyWagesOutput = new JLabel();
    JLabel netMonthlyWagesOutput = new JLabel();
    JLabel homePriceOutput = new JLabel();
    JLabel oneBROutput = new JLabel();
    JLabel twoBROutput = new JLabel();


    JTextField hoursWorkedField = new JTextField();
    JTextField monthlyExpensesField = new JTextField();
    JTextField wageField = new JTextField();


    public Home() {
    }

    protected Home(String userName) {

        title.setBounds(120, 20, 800, 50);
        title.setFont(new Font("Arial", Font.ITALIC, 40));
        title.setForeground(Color.white);

        welcome.setBounds(500, 75, 300, 24);
        welcome.setText("Welcome back, " + userName);
        welcome.setFont(new Font("Arial", Font.PLAIN, 16));
        welcome.setForeground(Color.white);

        wageType.setBounds(50, 200, 100, 24);
        wageType.setFont(new Font("Arial", Font.PLAIN, 16));
        wageField.setBounds(200, 200, 150, 24);
        wageField.setForeground(Color.white);

        hoursWorkedLabel.setBounds(50, 250, 150, 24);
        hoursWorkedLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        hoursWorkedLabel.setForeground(Color.white);
        hoursWorkedField.setBounds(200, 250, 150, 24);
        housingTypeLabel.setForeground(Color.white);

        monthlyExpensesLabel.setBounds(50, 300, 150, 24);
        monthlyExpensesLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        monthlyExpensesField.setBounds(200, 300, 150, 24);
        monthlyExpensesLabel.setForeground(Color.white);

        neighborhoodLabel.setBounds(50, 400, 125, 24);
        neighborhoodLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        neighborhoodLabel.setForeground(Color.white);
        neighborhoodComboBox.setBounds(200, 400, 150, 24);
        neighborhoodComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        neighborhoodComboBox.addActionListener(this);

        housingTypeLabel.setBounds(400, 400, 100, 24);
        housingTypeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        housingTypeLabel.setForeground(Color.white);
        housingTypeComboBox.setBounds(550, 400, 150, 24);
        housingTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 16));

        calculate.setBounds(375, 450, 100, 24);
        calculate.addActionListener(this);

        grossMonthlyWagesLabel.setBounds(50, 500, 175, 24);
        grossMonthlyWagesLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        grossMonthlyWagesLabel.setForeground(Color.white);
        grossMonthlyWagesOutput.setBounds(250, 500, 100, 24);
        grossMonthlyWagesOutput.setFont(new Font("Arial", Font.PLAIN, 16));

        netMonthlyWagesLabel.setBounds(400, 500, 200, 24);
        netMonthlyWagesLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        netMonthlyWagesLabel.setForeground(Color.white);
        netMonthlyWagesOutput.setBounds(650, 500, 100, 24);
        netMonthlyWagesOutput.setFont(new Font("Arial", Font.PLAIN, 16));

        medianHomePrice.setBounds(50, 550, 175, 24);
        medianHomePrice.setForeground(Color.white);
        medianHomePrice.setFont(new Font("Arial", Font.PLAIN, 16));
        homePriceOutput.setBounds(250, 550, 100, 24);
        homePriceOutput.setFont(new Font("Arial", Font.PLAIN, 16));
        homePriceOutput.setForeground(Color.white);

        median1BRAptPrice.setBounds(400, 550, 200, 24);
        median1BRAptPrice.setForeground(Color.white);
        median1BRAptPrice.setFont(new Font("Arial", Font.PLAIN, 16));
        oneBROutput.setBounds(625, 550, 175, 24);
        oneBROutput.setFont(new Font("Arial", Font.PLAIN, 16));
        oneBROutput.setForeground(Color.white);

        median2BRAptPrice.setBounds(50, 600, 200, 24);
        median2BRAptPrice.setForeground(Color.white);
        median2BRAptPrice.setFont(new Font("Arial", Font.PLAIN, 16));
        twoBROutput.setBounds(275, 600, 175, 24);
        twoBROutput.setFont(new Font("Arial", Font.PLAIN, 16));
        twoBROutput.setForeground(Color.white);

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
        frame.add(medianHomePrice);
        frame.add(median1BRAptPrice);
        frame.add(median2BRAptPrice);
        frame.add(homePriceOutput);
        frame.add(oneBROutput);
        frame.add(twoBROutput);
        frame.add(calculate);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.decode("#03989e"));
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculate) {
            grossMonthlyWagesOutput.setText(String.format("%.2f", calculateMonthlyWages()));

        }
        if (e.getSource() == neighborhoodComboBox) {
            grossMonthlyWagesOutput.setText(getNeighborhoodComboBox());
            dbConnection.setSql("SELECT * FROM neighborhoods WHERE neighborhood = " + "'" + getNeighborhoodComboBox() + "'");
            try {
                System.out.println("Connection Successful.");
                Connection connection = DriverManager.getConnection(url, user, pass);
                Statement statement = connection.createStatement();
                newSql = dbConnection.getSql();
                ResultSet rs = statement.executeQuery(newSql);


                while (rs.next()) {
                    homePriceOutput.setText(String.valueOf(rs.getInt("median_home_price")));
                    oneBROutput.setText(String.valueOf(rs.getInt("median_onebr_apt_price")));
                    twoBROutput.setText(String.valueOf(rs.getInt("median_twobr_apt_price")));

                }
                connection.close();

            } catch (SQLException ex) {
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

    public String getHousingTypeComboBox() {
        return String.valueOf(housingTypeComboBox.getSelectedItem());
    }

    public String getNeighborhoodComboBox() {
        return String.valueOf(neighborhoodComboBox.getSelectedItem());
    }


}
