package com.webservice.home;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

public class homeClient {
	
	public static class userProfile{
		private String email;
		private String pass;
		
		public void setCred(String email, String pass) {
			this.email = email;
			this.pass = pass;
		}
		
		public String getemail() {return email;}
		public String getpass() {return pass;}
	}
	
	public static class courseData {
		private String coursePrefix;
		private String courseID;
		private String courseTitle;
		private String courseDescription;
		
		public void setCourse(String prefix, String ID, String title, String description) {
			this.coursePrefix = prefix;
			this.courseID = ID;
			this.courseTitle = title;
			this.courseDescription = description;
		}
		
		public String getcoursePrefix() {return coursePrefix;}
		public String getcourseID() {return courseID;}
		public String getcourseTitle() {return courseTitle;}
		public String getcourseDescription() {return courseDescription;}
	}
	
	private static userProfile userProfile;
	private static userProfile userProfile2;
	private static courseData courseData;

	
	private static final String webServiceURI = "http://localhost:8080/course_catalog_filter";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		
		ObjectMapper mapper = new ObjectMapper();
		
		userProfile = new userProfile();
		userProfile.setCred("testemail@test.com", "password123" );
		
		userProfile2 = new userProfile();
		userProfile2.setCred("regTest@test.com", "passpass321");
		
		try {
		String jsonInString = mapper.writeValueAsString(userProfile);
		System.out.println(jsonInString);
		
		String registerJSON = mapper.writeValueAsString(userProfile2);
		System.out.println(registerJSON);

		// response
		System.out.println(webTarget.path("rest").path("home").request()
				.accept(MediaType.TEXT_PLAIN).get(Response.class).toString());

		// text
		System.out.println(webTarget.path("rest").path("home").request()
				.accept(MediaType.TEXT_PLAIN).get(String.class));

		// xml
		System.out.println(webTarget.path("rest").path("home").request()
				.accept(MediaType.TEXT_XML).get(String.class));

		// html
		System.out.println(webTarget.path("rest").path("home").request()
				.accept(MediaType.TEXT_HTML).get(String.class));
		
		
		//POST test
		Response response = webTarget.path("rest").path("home").request("application/json").post(Entity.json(jsonInString));
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response.getStatus());
			}
		if (response.getStatus() == 200) {
			System.out.println("POST SUCCESS TEST");
			System.out.println(response.readEntity(String.class));
			}

		
		//POST login test
		Response response2 = webTarget.path("rest").path("login").request("application/json").post(Entity.json(jsonInString));
		if (response2.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response2.getStatus());
			}
		if (response2.getStatus() == 200) {
			System.out.println("POST SUCCESS Login");
			System.out.println(response2.readEntity(String.class));
			}
		
		//POST data pull test
		/*Response response3 = webTarget.path("rest").path("data").request("application/json").post(Entity.json(jsonInString));
		if (response3.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response3.getStatus());
			}
		if (response3.getStatus() == 200) {
			System.out.println("POST SUCCESS Data");
			System.out.println(response3.readEntity(String.class));
			} */
		//POST Register test
		Response response4 = webTarget.path("rest").path("register").request("application/json").post(Entity.json(registerJSON));
		if (response4.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response4.getStatus());
			}
		if (response4.getStatus() == 200) {
			System.out.println("POST SUCCESS Register");
			System.out.println(response4.readEntity(String.class));
			} 
			
		} 
		
		catch (Exception e){
			e.printStackTrace();
			}

		}
}
