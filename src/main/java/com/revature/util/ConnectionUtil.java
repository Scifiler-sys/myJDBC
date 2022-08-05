package com.revature.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * What is JDBC?
 * 
 * JDBC (Java Database Connectivity) is the Java API that manages 
 * connecting to a database, issuing queries and commands, 
 * and handling result sets obtained from the database
 * 
 * What is a Singleton Design Pattern? 
 * 
 * A Singleton Class is a software design pattern that ensures 
 * there will be one single instance of that class.
 * 
 * -- private constructors 
 * -- static field of an instance of the class to be returned 
 * -- leverage a public static getInstance() (our getInstance method is the getConnection() method
 * 
 * The connection to our DB will be established by a singleton class which will
 * contain all the necessary driver information (jdbc url, username, password).
 */
public class ConnectionUtil {

    //Connection class is from JDBC Api, hence import java.sql
    private static Connection con;

    //Singleton's have private constructors
    private ConnectionUtil() {
        con = null;
    }

    public static Connection getConnection() {
        try {

            //Check to see if we have an existing connection, if so go ahead and return it
            if(con != null && !con.isClosed()){
                return con;
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        //Properties class is used to configure our database credentials for the Connection class to use
        Properties prop = new Properties();

        String url, username, password;

        try {
            //Reads the properties file we made in resource folder that holds our DB credentials
            prop.load(new FileReader("C:\\Users\\Stephen - Work\\Documents\\Revature\\Java\\jdbc\\src\\main\\resources\\application.properties"));

            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return con;
    }
}
