package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class RegisterNewUser
{
	public static String newUser(String email, String pass)
	{
     try{

	 //loading drivers for mysql
        Class.forName("com.mysql.cj.jdbc.Driver");

	 //creating connection with the database 
        
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://144.167.232.25:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
        Statement ps =con.createStatement();
        String sql = ("INSERT INTO user VALUES(" + email + "," + "' '" + "," + pass + ")");
        System.out.println(email +" " + pass);
        
        //Insert into user values(user_email, user_name, password_hash);
        
        ps.execute(sql);
        /*
        Connection con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/testschema","root","tacotaco");
        PreparedStatement ps =con.prepareStatement
                ("select * from users where email=? and pass=?");
        */
        //ps.setString(1, email);
        //ps.setString(2, pass);
        //ps.executeUpdate(ps);
        //ResultSet rs =ps.executeQuery();

     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return "";                  
}
}
