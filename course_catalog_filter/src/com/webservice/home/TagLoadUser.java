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

@Path("/loadusertag")
public class TagLoadUser 
{
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sayConfirm(@CookieParam("token") Cookie cookie, @CookieParam("email") Cookie cookie2) {		//(String msg) {
		try {
		/*	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(msg);
		String email = actualObj.get("email").textValue();
		String token = actualObj.get("token").textValue();
		*/
		String token = cookie.getValue();
		String email = cookie2.getValue();
			
      if(ValidateToken.checkToken(token, email))
      {	  
  		String course_subject;
  		String course_number;
  		String course_name;
  		String course_desc;
  		
  		List<DataClass.CourseData> courses = new ArrayList<>();
  		
          try{
        	  /*
        	  SELECT DISTINCT HASQUALITY.course_subject, HASQUALITY.course_number, getCourseTagCount(course_subject, course_number, 'rweeks2010@hotmail.com')
        	  FROM HASQUALITY, INTERESTS
        	  WHERE INTERESTS.user_email='rweeks2010@hotmail.com' AND INTERESTS.tag_name=HASQUALITY.tag_name;
        	  */
        	  
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://144.167.232.198:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
                 PreparedStatement ps =con.prepareStatement
                		 ("SELECT DISTINCT HASQUALITY.course_subject, HASQUALITY.course_number, COURSE.course_name, COURSE.course_desc, getCourseTagCount(HASQUALITY.course_subject, HASQUALITY.course_number, '" + email +"') FROM HASQUALITY, INTERESTS, COURSE WHERE INTERESTS.user_email='" + email +"' AND INTERESTS.tag_name=HASQUALITY.tag_name AND HASQUALITY.course_subject=COURSE.course_subject AND HASQUALITY.course_number=COURSE.course_number;");
               
                 ResultSet rs =ps.executeQuery();
                 
                 while (rs.next()) {
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
