package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidateRegister 
{
    public static boolean checkUser(String email)//,String pass) 
    {
     boolean st =false;
     try{
    	 
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://144.167.232.198:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
        PreparedStatement ps =con.prepareStatement("select * from user where user_email=?");

        ps.setString(1, email);
        ResultSet rs =ps.executeQuery();
        st = rs.next();
        rs.close();
        con.close();
        
     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return st;                 
 }   
}