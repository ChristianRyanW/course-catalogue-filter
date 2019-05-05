package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestingSQLFunction 
{	
	public static String Test()
	{
     try
     {
    	 
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://144.167.232.25:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
        Statement ps =con.createStatement();
        String sql = ("SELECT DISTINCT HASQUALITY.course_subject, HASQUALITY.course_number, getCourseTagCount(course_subject, course_number, 'rweeks2010@hotmail.com') FROM HASQUALITY, INTERESTS WHERE INTERESTS.user_email='rweeks2010@hotmail.com' AND INTERESTS.tag_name=HASQUALITY.tag_name");
        ResultSet rs =ps.executeQuery(sql);
        
        while (rs.next()) 
        {
        	String course_subject = rs.getString("course_subject");
        	String course_number = rs.getString("course_number");
        	int tag_name = rs.getInt("getCourseTagCount(course_subject, course_number, 'rweeks2010@hotmail.com')");
        	
        	System.out.println("Course Sub: " + course_subject + " Course num: " + course_number + " Tags: " + tag_name);
        }
        rs.close();
        con.close();
        
     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return "";                  
	}
}
