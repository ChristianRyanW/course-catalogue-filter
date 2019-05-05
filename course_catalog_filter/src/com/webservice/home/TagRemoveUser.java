package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TagRemoveUser {
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sayConfirm(@CookieParam("token") Cookie cookie, @CookieParam("email") Cookie cookie2, String msg)
	{		
		try 
		{
		String token = cookie.getValue();
		String email = cookie2.getValue();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(msg);
		String tag = actualObj.get("tag").textValue();
			
      if(ValidateToken.checkToken(token, email))
      {	  		
          try
          {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://144.167.232.198:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
                 PreparedStatement ps =con.prepareStatement
                		 ("DELETE FROM INTERESTS WHERE tag_name='" + tag +"' AND user_email='" + email + "'");
               
                 ResultSet rs =ps.executeQuery();
                 
                 rs.close();
                 con.close();
                 
              }catch(Exception e)
              {
                  e.printStackTrace();
              }
       	return Response.ok("Tag Removed", MediaType.APPLICATION_JSON).build();
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
