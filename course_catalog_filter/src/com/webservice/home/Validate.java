package com.webservice.home;

import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String email,String pass) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.cj.jdbc.Driver");

 	 //creating connection with the database 
         
         
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://144.167.232.25:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
         PreparedStatement ps =con.prepareStatement
        		 		("SELECT password_hash FROM USER WHERE user_email=?");
                             //("select * from user where user_email=? and password_hash=?");
         /*
         Connection con=DriverManager.getConnection
                 ("jdbc:mysql://localhost:3306/testschema","root","tacotaco");
         PreparedStatement ps =con.prepareStatement
                 ("select * from users where email=? and pass=?");
         */
         
         ps.setString(1, email);
         //ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         
         String passHash = "";
         while (rs.next()) {
         passHash = rs.getString("password_hash");
         }
         st = PasswordHashValidate.main(pass, passHash);
         
         //st = rs.next();

      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}