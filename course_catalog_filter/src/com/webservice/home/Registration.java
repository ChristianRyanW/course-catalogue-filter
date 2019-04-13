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

@Path("/register")
public class Registration {
	
	
	public static class RegisterStatus{
		private String status;
		private String error;
		
		public void setStatus(String status, String error) {
			this.status = status;
			this.status = error;
		}
		
		public String getstatus() {return status;}
		public String geterror() {return error;}
	}
	
	private static RegisterStatus registerStatus;
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sayConfirm(String msg) {
		try {
			
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(msg);
		String email = actualObj.get("email").textValue();
		String pass = actualObj.get("pass").textValue();
			
		
    if(!RegisterValidation.checkUser(email, pass))
    {	  
    	String error = "No Errors";
    	RegisterStatus regStat = new RegisterStatus();
    	regStat.setStatus("Success", error);
    	
    	System.out.println(regStat);
    	
    	RegisterNewUser.newUser(email, pass);
    	
    	return Response.ok(regStat, MediaType.APPLICATION_JSON).build();
    }
    else
    {
    	RegisterStatus regStat = new RegisterStatus();
    	regStat.setStatus("Failure", "");
    	return Response.ok(regStat, MediaType.APPLICATION_JSON).build();
    }		
		}
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).build();
		}
}  
}

