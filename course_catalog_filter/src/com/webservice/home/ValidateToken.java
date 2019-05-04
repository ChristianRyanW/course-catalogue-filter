package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidateToken {
	
    public static boolean checkToken(String token,String email) 
    {
     boolean st =false;
     try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection ("jdbc:mysql://144.167.232.198:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
        
        PreparedStatement ps =con.prepareStatement ("SELECT * FROM token WHERE token=? and user_email =?");
        
        ps.setString(1, token);
        ps.setString(2, email);
        ResultSet rs =ps.executeQuery();
        st = rs.next();

     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return st;                 
 }   
}
