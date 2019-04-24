package com.webservice.home;

import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String email,String pass) 
     {
      boolean st =false;
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://144.167.232.198:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
         PreparedStatement ps =con.prepareStatement
        		 		("SELECT password_hash FROM USER WHERE user_email=?");
                             //("select * from user where user_email=? and password_hash=?");
         
         ps.setString(1, email);
         ResultSet rs =ps.executeQuery();
         
         String passHash = "";
         while (rs.next()) {
         passHash = rs.getString("password_hash");
         }
         st = PasswordHashValidate.main(pass, passHash);

      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}