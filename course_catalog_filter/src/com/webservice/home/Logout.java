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

@Path("/logout")
public class Logout 
{	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sessionToken(String msg)
	{
     try
     {
 		ObjectMapper mapper = new ObjectMapper();
 		JsonNode actualObj = mapper.readTree(msg);
 		String email = actualObj.get("email").textValue();
 		
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://144.167.232.198:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
        Statement ps =con.createStatement();
        String remSql = ("DELETE FROM token WHERE user_email=" + "'" + email + "'");
        ps.execute(remSql);
        
      	DataClass.GenericMessage message = new DataClass.GenericMessage();
      	message.setMessage("SUCCESS");
   		return Response.ok(message, MediaType.APPLICATION_JSON).build(); 

     }catch(Exception e)
     {
         e.printStackTrace();
       	DataClass.GenericMessage message = new DataClass.GenericMessage();
       	message.setMessage("FAILURE");
    	return Response.ok(message, MediaType.APPLICATION_JSON).build(); 
     }                  
}
}
