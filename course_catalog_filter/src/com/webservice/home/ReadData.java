package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/data")
public class ReadData {
	
   	String output;
	String output2;
	String output3;
	String output4;
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sayConfirm(String msg) {
		try {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(msg);
		/*
		String course_subject = actualObj.get("course_subject").textValue();
		String course_number = actualObj.get("course_number").textValue();
		String course_name = actualObj.get("course_name").textValue();
		String course_desc = actualObj.get("course_desc").textValue();
		  */     
		
		String course_subject = "course_subject";
		String course_number = "course_number";
		String course_name = "course_name";
		String course_desc = "course_desc";
		
		
        try{
        	System.out.println("Before DB Connection");
               Class.forName("com.mysql.jdbc.Driver");
               
               Connection con=DriverManager.getConnection
                              ("jdbc:mysql://144.167.232.127:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
               
               PreparedStatement ps =con.prepareStatement
                                   ("SELECT * FROM course");
               
               System.out.println("DB CONNECTION SUCCESS");

               ResultSet rs =ps.executeQuery();
               
               while (rs.next()) {
            	course_subject = rs.getString("course_subject");
            	course_number = rs.getString("course_number");
            	course_name = rs.getString("course_name");
            	course_desc = rs.getString("course_desc");
            	
               	output = "Course Subject: " + course_subject;
            	output2 = "Course Number:  " + course_number;
            	output3 = "Course Name: " + course_name;
            	output4 = "Course Description " + course_desc;
            	
            	System.out.print(output+ "\n" + output2+ "\n" + output3+ "\n" + output4 + "\n \n");
               }
               
               rs.close();
               
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    	return Response.status(200).entity(output).build();
		}
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).build();
		}
    }  
}
