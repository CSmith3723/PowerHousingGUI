package data;

import pages.Home;

import java.sql.*;

public class DBConnection {


    private String url = "jdbc:mysql://localhost:3306/powerhousing";
    private String user = "springstudent";
    private String pass = "springstudent";
    private String sql = "SELECT * FROM neighborhoods";

    public DBConnection(){}


    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String newSql){
      sql = newSql;
    }

}
