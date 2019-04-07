package com.webservice.home;

//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
		
		public void setStatus(String status) {
			this.status = status;
		}
		
		public String getstatus() {return status;}
	}
	
	private static loginStatus loginStatus;
	
	@POST
	@Consumes("application/json")
	//@Produces("applicaiton/json")
	public Response sayConfirm(String msg) {
		try {
			
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(msg);
		String email = actualObj.get("email").textValue();
		String pass = actualObj.get("pass").textValue();
			
		
      if(Validate.checkUser(email, pass))
      {
      	String output = "Success"; 
      	
      	//loginStatus logStat = new loginStatus();
      	//logStat.setStatus("Success");
      	
      	//return Response.status(200).entity(logStat).build();
      	
      	//return Response.ok(output, MediaType.APPLICATION_JSON).build();
      	return Response.status(200).entity(output).build();
      	//return Response.ok(output).build();
      }
      else
      {
      	String output = "Failure";
      	return Response.ok(output, MediaType.APPLICATION_JSON).build();
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
