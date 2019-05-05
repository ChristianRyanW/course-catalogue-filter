package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StoreUserToken 
{	
	public static String sessionToken(String token, String email)
	{
     try
     {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://144.167.232.198:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
        Statement ps =con.createStatement();
        
        String remSql = ("DELETE FROM token WHERE user_email=" + "'" + email + "'");
        String sql = ("INSERT INTO token VALUES(" + "'" + token + "'" + ","+ "'" + email + "'" + ")");
       
        ps.execute(remSql);
        ps.execute(sql);
        con.close();

     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return "";                  
}
}
