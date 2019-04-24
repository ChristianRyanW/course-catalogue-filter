package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/tagrequest")
public class TagRequest {
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public static Response newTag(String msg)
	{
     try{
 		ObjectMapper mapper = new ObjectMapper();
 		JsonNode actualObj = mapper.readTree(msg);
 		String course_subject = actualObj.get("course_subject").textValue();
 		String course_number = actualObj.get("course_number").textValue();
 		String tag = actualObj.get("tag").textValue();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://144.167.232.198:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
        Statement ps =con.createStatement();
        String sql = ("INSERT INTO suggestedtag VALUES(" + "'" + course_subject + "'" + "," + "'" + course_number + "'" + "," + "'" + tag + "'" + ")");
        ps.execute(sql);
        
      	DataClass.GenericMessage message = new DataClass.GenericMessage();
      	message.setMessage("Tag Submitted Successfully");
   		return Response.ok(message, MediaType.APPLICATION_JSON).build(); 
     }catch(Exception e)
     {
        e.printStackTrace();
       	DataClass.GenericMessage errorMessage = new DataClass.GenericMessage();
       	errorMessage.setMessage("Tag was not submitted successfully");
        return Response.ok(errorMessage, MediaType.APPLICATION_JSON).build();  
     }
            
	}
}
