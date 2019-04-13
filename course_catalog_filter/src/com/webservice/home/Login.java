package com.webservice.home;

//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.security.SecureRandom;

//import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import java.sql.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

@Path("/login")
public class Login {
	
	
	public static class loginStatus{
		private String status;
		private String token;
		
		public void setStatus(String status, String token) {
			this.status = status;
			this.token = token;
		}
		
		public String getstatus() {return status;}
		public String gettoken() {return token;}
	}
	
	private static loginStatus loginStatus;
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sayConfirm(String msg) {
		try {
			
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(msg);
		String email = actualObj.get("email").textValue();
		String pass = actualObj.get("pass").textValue();
			
		
      if(Validate.checkUser(email, pass))
      {	  
    	  SecureRandom random = new SecureRandom();
    	  byte bytes[] = new byte[128];
    	  random.nextBytes(bytes);
    	  String token = bytes.toString();
    	  
      	loginStatus logStat = new loginStatus();
      	logStat.setStatus("Success", token);
      	
      	System.out.println(logStat);
      	
      	return Response.ok(logStat, MediaType.APPLICATION_JSON).build();
      }
      else
      {
      	loginStatus logStat = new loginStatus();
      	logStat.setStatus("Failure", "");
      	return Response.ok(logStat, MediaType.APPLICATION_JSON).build();
      }		
		}
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).build();
		}
  }  
	/*
	@Override
	public int hashCode() {
	    int hash = 3;
	    hash = 71 * hash + Objects.hashCode(this.id);
	    hash = 71 * hash + Objects.hashCode(this.name);
	    hash = 71 * hash + this.population;
	    return hash; */
}
