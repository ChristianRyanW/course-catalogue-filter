package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/loaduserbookmark")
public class BookmarkLoadCourse 
{
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sayConfirm(@CookieParam("token") Cookie cookie, @CookieParam("email") Cookie cookie2) //(String msg)
	{		
		try 
		{
		String token = cookie.getValue();
		String email = cookie2.getValue();
			
      if(ValidateToken.checkToken(token, email))
      {	  
  		String course_subject;
  		String course_number;
  		String course_name;
  		String course_desc;
  		
  		List<DataClass.CourseData> courses = new ArrayList<>();
  		
          try
          {  
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
                 PreparedStatement ps =con.prepareStatement
                		 ("SELECT SAVES.course_subject, SAVES.course_number, COURSE.course_name, COURSE.course_desc FROM SAVES, COURSE WHERE SAVES.user_email = '" + email + "' AND SAVES.course_subject=COURSE.course_subject AND SAVES.course_number=COURSE.course_number;");
               
                 ResultSet rs =ps.executeQuery();
                 
                 while (rs.next()) 
                 {
                	 course_subject = rs.getString("course_subject");
                	 course_number = rs.getString("course_number");
                	 course_name = rs.getString("course_name");
                	 course_desc = rs.getString("course_desc");

          		DataClass.CourseData CourseData = new DataClass.CourseData();
              	CourseData.setClass(course_subject, course_number, course_name, course_desc);
              	courses.add(CourseData);
                 }
                 rs.close();
                 con.close();
                 
              }catch(Exception e)
              {
                  e.printStackTrace();
              }
       	return Response.ok(courses, MediaType.APPLICATION_JSON).build();
      }
      else
      {
      	return Response.ok("Error : Are you logged in?", MediaType.APPLICATION_JSON).build();
      }		
		}
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).build();
		}
  } 
}
