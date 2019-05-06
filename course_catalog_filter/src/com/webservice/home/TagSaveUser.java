package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/saveusertag")
public class TagSaveUser 
{
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
 		List<DataClass.Tags> tags = mapper.readValue(msg, new TypeReference<List<DataClass.Tags>>() {});
 		
      if(ValidateToken.checkToken(token, email))
      {	  
          try
          {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://144.167.232.198:3306/tagit","notroot","K-YQ@5^Bq2d5~drD"); 
                 Statement ps =con.createStatement();
                 String sql = "";
                 
                 for(int i = 0; i <= tags.size() - 1; i++) {
                	 sql = ("INSERT INTO INTERESTS VALUES ('" + tags.get(i).gettag() + "', '" + email + "')");
                	 System.out.println(sql);
                	 ps.execute(sql);
                 }
                 ps.close();
                 con.close();
                 
              }catch(Exception e)
              {
                  e.printStackTrace();
              }
          
       	return Response.ok("", MediaType.APPLICATION_JSON).build();
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
