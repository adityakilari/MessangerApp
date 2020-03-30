package org.aditya.java.messangerapplication.database;


import java.util.HashMap;
import java.sql.*;
import java.util.Map;


import org.aditya.java.messangerapplication.model.Message;
import org.aditya.java.messangerapplication.model.Profile;

public class Database {
	
	private static String url = "jdbc:mysql://localhost:3306/";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "Aditya@1997";
    private static Connection con;
    
    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            	
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
	
		
	private static Map<Long,Message> Messagemap = new HashMap<>();
	private static  Map<String,Profile> Profilemap = new HashMap<>();
	
	
	
	public static Map<Long,Message> getMessages(){
		return Messagemap;
	}
	
	public static  Map<String,Profile> getProfiles(){
		return Profilemap;
	}

	
	
	
	
	

}
