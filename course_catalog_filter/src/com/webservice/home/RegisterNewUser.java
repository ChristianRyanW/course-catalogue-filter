package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RegisterNewUser
{
	public static String newUser(String email, String pass)
	{
     try
     {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
        Statement ps =con.createStatement();
        
        String sql = ("INSERT INTO user VALUES(" + "'" + email + "'" + "," + "'" + "" + "'" + "," + "'" + pass + "'" + "," + 0 + ")");
        ps.execute(sql);
        con.close();

     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return "";                  
	}
}
