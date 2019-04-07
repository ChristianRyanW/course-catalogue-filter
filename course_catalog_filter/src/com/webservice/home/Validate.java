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
         
         /*
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://144.167.232.127:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
         */
         
         Connection con=DriverManager.getConnection
                 ("jdbc:mysql://localhost:3306/testschema","root","tacotaco");
         
         /*
         PreparedStatement ps =con.prepareStatement
                             ("select * from user where user_email=? and password_hash=?");
         */
         
         PreparedStatement ps =con.prepareStatement
                 ("select * from users where email=? and pass=?");
         
         
         ps.setString(1, email);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();

      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}