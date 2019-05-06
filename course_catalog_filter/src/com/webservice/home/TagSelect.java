package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/tagselect")
public class TagSelect {
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public static Response SelectTag(String msg)
	{
     try{
 		String course_subject;
 		String course_number;
 		String course_name;
 		String course_desc;
 		
 		List<DataClass.CourseData> courses = new ArrayList<>();
 		ObjectMapper mapper = new ObjectMapper();
 		List<DataClass.Tags> tags = mapper.readValue(msg, new TypeReference<List<DataClass.Tags>>() {});
 		
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
        Statement ps =con.createStatement();
        String sqlStart = ("SELECT HASQUALITY.course_subject, HASQUALITY.course_number, COURSE.course_name, COURSE.course_desc, count(*) FROM HASQUALITY, COURSE WHERE (HASQUALITY.tag_name = "); 
        
        for(int i = 0; i <= tags.size() - 1; i++) 
        {
        	if (i > 0) 
        	{
        		sqlStart += " OR HASQUALITY.tag_name=";
        	}
        	sqlStart += "'" + tags.get(i).gettag() + "'";
        } 
        
        String sqlEnd = (") AND HASQUALITY.course_subject=COURSE.course_subject AND HASQUALITY.course_number=COURSE.course_number Group By HASQUALITY.course_subject, HASQUALITY.course_number ORDER BY count(*) DESC;");
        String sql = sqlStart + sqlEnd;
        ResultSet rs =ps.executeQuery(sql);
        
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
   		return Response.ok(courses, MediaType.APPLICATION_JSON).build(); 
     }catch(Exception e)
     {
        e.printStackTrace();
       	DataClass.GenericMessage errorMessage = new DataClass.GenericMessage();
       	errorMessage.setMessage(e.getMessage());
        return Response.ok(errorMessage, MediaType.APPLICATION_JSON).build();  
     }
            
	}
}
