package com.webservice.home;

//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.security.SecureRandom;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
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
	
	private static DataClass.loginStatus loginStatus;
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sayConfirm(String msg) {
		try {
			
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(msg);
		String email = actualObj.get("email").textValue();
		String pass = actualObj.get("pass").textValue();
			
		
		
		String passHash = PasswordHashing.main(pass);
		System.out.println(passHash);
		
		boolean passHashValid = PasswordHashValidate.main(pass);
		System.out.println("HashValid?: " + passHashValid);
		System.out.println("pass: " + pass);
		
		
		
      if(Validate.checkUser(email, pass))
      {	  
    	  SecureRandom randomTok = new SecureRandom();
    	  byte bytesTok[] = new byte[255]; //128
    	  randomTok.nextBytes(bytesTok);
    	  String token = bytesTok.toString();
    	  
      	DataClass.loginStatus logStat = new DataClass.loginStatus();
      	logStat.setStatus("Success", token);
      	System.out.println(logStat);
      	return Response.ok(logStat, MediaType.APPLICATION_JSON).build();
      }
      else
      {
      	DataClass.loginStatus logStat = new DataClass.loginStatus();
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
