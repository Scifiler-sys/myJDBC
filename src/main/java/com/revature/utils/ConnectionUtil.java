package com.revature.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {

    private static Connection con;

    private ConnectionUtil() {
        con = null;
    }

    public static Connection getConnection(){
        
        //Determine if we already have an existing connection
        try {
            //In the event that connection wasn't made yet and the connection is currently open
            if (con != null && !con.isClosed()) {
                return con;
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        String url, user, pass;

        //Java made class that uses .properties files to grab information from
        //It uses key-value pair to find information
        // Properties prop = new Properties();

        
        try {
            //This sets the location of the postgresql driver that we got from our JDBC maven dependency
            Class.forName("org.postgresql.Driver");

            //Loads our property file from the resources folder
            // prop.load(ConnectionUtil.class.getResourceAsStream("/database.properties"));
            //Uses key-value pair to find information
            url = System.getenv("url");
            user = System.getenv("user");
            pass = System.getenv("pass");

            // url = prop.getProperty("url");
            // user = prop.getProperty("user");
            // pass = prop.getProperty("pass");

            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return con;
    }
}
