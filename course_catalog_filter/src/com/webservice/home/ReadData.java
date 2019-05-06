package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/data")
public class ReadData 
{	
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sayConfirm() 
	{
		try 
		{
		String course_subject;
		String course_number;
		String course_name;
		String course_desc;
		String tag;
		
		List<DataClass.CourseDataTag> courses = new ArrayList<>();
		
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
               PreparedStatement ps =con.prepareStatement(
            		   "SELECT COURSE.course_subject, COURSE.course_number, COURSE.course_name, COURSE.course_desc, GROUP_CONCAT(DISTINCT tag_name ORDER BY tag_name SEPARATOR ', ') tag_name\r\n" + 
               			"FROM COURSE\r\n" + 
               			"JOIN HASQUALITY ON (HASQUALITY.course_subject=COURSE.course_subject AND HASQUALITY.course_number=COURSE.course_number)\r\n" + 
               			"GROUP BY COURSE.course_number;");
               
               ResultSet rs =ps.executeQuery();
               
               while (rs.next()) 
               {
            	course_subject = rs.getString("course_subject");
            	course_number = rs.getString("course_number");
            	course_name = rs.getString("course_name");
               	course_desc = rs.getString("course_desc");
               	tag = rs.getString("tag_name");
               	
        		DataClass.CourseDataTag CourseDataTag = new DataClass.CourseDataTag();
            	CourseDataTag.setClass(course_subject, course_number, course_name, course_desc, tag);
            	courses.add(CourseDataTag);
               }
               
               rs.close();
               con.close();
               
     	return Response.ok(courses, MediaType.APPLICATION_JSON).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return Response.status(500).build();
		}
    }  
}
