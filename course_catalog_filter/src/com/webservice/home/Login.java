package com.webservice.home;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

@Path("/login")
public class Login {
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sayConfirm(String msg) {
		try {
			
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(msg);
		String email = actualObj.get("email").textValue();
		String pass = actualObj.get("pass").textValue();

      if(ValidateLogin.checkUser(email, pass))
      {	  
    	String token = TokenGenerator.nextToken();
      	DataClass.loginStatus logStat = new DataClass.loginStatus();
      	logStat.setStatus("Success", token);
      	
      	StoreUserToken.sessionToken(token, email);
   	   	
      	NewCookie cookie = CookieGenerator.createDomainCookie("token", token, 60);
      	NewCookie cookie2 = CookieGenerator.createDomainCookie("email", email, 60);
      	
      	Response.ResponseBuilder responsebuild = Response.ok(logStat, MediaType.APPLICATION_JSON);
      	Response response = responsebuild.cookie(cookie, cookie2).build();
      	return response;
      	//return Response.ok(logStat, MediaType.APPLICATION_JSON).cookie(cookie, cookie2).build();
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
}
