package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidateLogin 
{
    public static boolean checkUser(String email,String pass) 
    {
     boolean st = false;
     try{
    	 
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
        PreparedStatement ps =con.prepareStatement("SELECT password_hash FROM USER WHERE user_email=?");
        
        ps.setString(1, email);
        ResultSet rs =ps.executeQuery();
        String passHash = "";
        while (rs.next()) {
        passHash = rs.getString("password_hash");
        }
        st = PasswordHashValidate.main(pass, passHash);
        rs.close();
        con.close();
        
     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return st;                 
 }   
}