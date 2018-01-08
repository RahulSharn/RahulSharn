package com;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DBConnector {
    
   
    
    
    static { 
        try {
            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
    public static synchronized Connection getConnection() throws Exception {
        Connection connection = null;
        try {
        	  Class.forName("com.db2.jcc.DB2Driver");
        	String url= "jdbc:db2:";
        	  String user="";
        	  String password="";
            connection = DriverManager.getConnection(url, user, password);
            
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("DB is down", e);
        }
    }

    /**
     * this method closes the db connection
     *
     * @param connection
     * @throws Exception
     */
    public static void closeConnection(Connection connection) throws Exception {
        if (connection != null) {
            connection.close();
            System.out.println("connection closed");
            connection = null;
            
        }
    }
}
