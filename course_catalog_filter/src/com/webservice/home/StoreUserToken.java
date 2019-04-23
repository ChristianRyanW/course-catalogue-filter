package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StoreUserToken {
	
	public static String sessionToken(String token, String email)
	{
     try{
        Class.forName("com.mysql.cj.jdbc.Driver");
  
        Connection con=DriverManager.getConnection
                       (Global.DBconnectionString);
        Statement ps =con.createStatement();
        
        String remSql = ("DELETE FROM token WHERE user_email=" + "'" + email + "'");
        
        String sql = ("INSERT INTO token VALUES(" + "'" + token + "'" + ","+ "'" + email + "'" + ")");
       
        ps.execute(remSql);
        ps.execute(sql);

     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return "";                  
}
}
