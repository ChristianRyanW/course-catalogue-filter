package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/data")
public class ReadData {
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sayConfirm() {
		try {
		String course_subject;
		String course_number;
		String course_name;
		String course_desc;
		
		List<DataClass.CourseData> courses = new ArrayList<>();
		
        try{
               Class.forName("com.mysql.cj.jdbc.Driver");
            
               Connection con=DriverManager.getConnection(Global.DBconnectionString);
               
               PreparedStatement ps =con.prepareStatement("SELECT * FROM course");
           
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
               
            }catch(Exception e)
            {
                e.printStackTrace();
            }
     	return Response.ok(courses, MediaType.APPLICATION_JSON).build();
		}
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).build();
		}
    }  
}
