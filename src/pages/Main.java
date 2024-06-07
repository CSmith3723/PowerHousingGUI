package pages;


import data.DBConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) {


        IDandPasswords idAndPass = new IDandPasswords();
        Login loginPage = new Login(idAndPass.getLoginInfo());

        DBConnection dbConnection = new DBConnection();

    }

}