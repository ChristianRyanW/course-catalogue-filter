package com.webservice.home;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

// This client is used to test the methods and the connection to the DataBase.
public class homeClient {
	
	private static DataClass.userProfile userProfile;
	private static DataClass.userProfile userProfile2;
	
	private static DataClass.Tags tag1;
	private static DataClass.Tags tag2;
	private static DataClass.Tags tag3;
	
	private static DataClass.userBookmark book1;
	private static DataClass.userBookmark book2;
	
	private static final String webServiceURI = "http://localhost:8080/course_catalog_filter";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		
		ObjectMapper mapper = new ObjectMapper();
		
		userProfile = new DataClass.userProfile();
		userProfile.setCred("testemail@test.com", "password123" );
		
		userProfile2 = new DataClass.userProfile();
		userProfile2.setCred("NewUserMay4@test.com", "Thispasswordhere");
		
		tag1 = new DataClass.Tags();
		tag2 = new DataClass.Tags();
		tag3 = new DataClass.Tags();
		
		tag1.setTag("AI");
		tag2.setTag("Software");
		tag3.setTag("Games");
		
		List<DataClass.Tags> tags = new ArrayList<>();
		tags.add(0, tag1);
		tags.add(1, tag2);
		tags.add(2, tag3);
		
		book1 = new DataClass.userBookmark();
		book2 = new DataClass.userBookmark();
		
		book1.setUserBookmark("CPSC", "4377");
		book2.setUserBookmark("IFSC", "1105");
		
		List<DataClass.userBookmark> bookmarks = new ArrayList<>();
		bookmarks.add(0, book1);
		bookmarks.add(1, book2);
		
		try {
		String jsonInString = mapper.writeValueAsString(userProfile2);
		//System.out.println(jsonInString);
		
		String registerJSON = mapper.writeValueAsString(userProfile2);
		
		String jsonInStringTag = mapper.writeValueAsString(tags);
		
		String jsonInStringBookmark = mapper.writeValueAsString(bookmarks);
		
		System.out.println(jsonInStringBookmark);
		//System.out.println(registerJSON);

		// response
		//System.out.println(webTarget.path("rest").path("home").request().accept(MediaType.TEXT_PLAIN).get(Response.class).toString());

		// text
		//System.out.println(webTarget.path("rest").path("home").request().accept(MediaType.TEXT_PLAIN).get(String.class));

		// xml
		//System.out.println(webTarget.path("rest").path("home").request().accept(MediaType.TEXT_XML).get(String.class));

		// html
		//System.out.println(webTarget.path("rest").path("home").request().accept(MediaType.TEXT_HTML).get(String.class));
		
		
		
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
		System.out.println("\n" + response2.getCookies().get("token"));
		System.out.println(response2.getCookies().get("email") + "\n");
		
		
		//Get data pull test
		Response response3 = webTarget.path("rest").path("data").request("application/json").get(Response.class);
		if (response3.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response3.getStatus());
			}
		if (response3.getStatus() == 200) {
			System.out.println("GET SUCCESS Data");
			//System.out.println(response3.readEntity(String.class));
			} 
		//POST Register test
		Response response4 = webTarget.path("rest").path("register").request("application/json").post(Entity.json(registerJSON));
		if (response4.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response4.getStatus());
			}
		if (response4.getStatus() == 200) {
			System.out.println("POST SUCCESS Register");
			System.out.println(response4.readEntity(String.class));
			} 
		
		//POST tag Select Test
		//System.out.println("\n" + jsonInStringTag + "\n");
		Response response5 = webTarget.path("rest").path("tagselect").request("application/json").post(Entity.json(jsonInStringTag));
		if (response5.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response5.getStatus());
			}
		if (response5.getStatus() == 200) {
			System.out.println("POST SUCCESS Tag Select");
			System.out.println(response5.readEntity(String.class));
			}
		
		//Get tags pull test
		Response response6 = webTarget.path("rest").path("taglist").request("application/json").get(Response.class);
		if (response6.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response6.getStatus());
			}
		if (response6.getStatus() == 200) {
			System.out.println("GET SUCCESS TAGS");
			System.out.println(response6.readEntity(String.class));
			} 
		
		//Save user tags
		Response response7 = webTarget.path("rest").path("saveusertag").request("application/json").cookie(response2.getCookies().get("token")).cookie(response2.getCookies().get("email")).post(Entity.json(jsonInStringTag));
		if (response7.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response7.getStatus());
			}
		if (response7.getStatus() == 200) {
			System.out.println("POST SUCCESS SAVE USER TAGS");
			System.out.println(response7.readEntity(String.class));
			} 
		
		//Load Courses by users saved tags Test
		Response response8 = webTarget.path("rest").path("loadusertag").request("application/json").cookie(response2.getCookies().get("token")).cookie(response2.getCookies().get("email")).get(Response.class);
		if (response8.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response8.getStatus());
			}
		if (response8.getStatus() == 200) {
			System.out.println("GET SUCCESS LOAD USER TAGS");
			System.out.println(response8.readEntity(String.class));
			} 
		
		//remove user tags
		Response response9 = webTarget.path("rest").path("removeusertag").request("application/json").cookie(response2.getCookies().get("token")).cookie(response2.getCookies().get("email")).post(Entity.json(jsonInStringTag));
		if (response9.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response9.getStatus());
			}
		if (response9.getStatus() == 200) {
			System.out.println("POST SUCCESS REMOVE USER TAGS");
			System.out.println(response9.readEntity(String.class));
			} 
		
		//save user bookmarks
		Response response10 = webTarget.path("rest").path("saveuserbookmark").request("application/json").cookie(response2.getCookies().get("token")).cookie(response2.getCookies().get("email")).post(Entity.json(jsonInStringBookmark));
		if (response10.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response10.getStatus());
			}
		if (response10.getStatus() == 200) {
			System.out.println("POST SUCCESS SAVE USER BOOKMARKS");
			System.out.println(response10.readEntity(String.class));
			} 
		
		//load courses by user bookmark
		Response response11 = webTarget.path("rest").path("loaduserbookmark").request("application/json").cookie(response2.getCookies().get("token")).cookie(response2.getCookies().get("email")).get(Response.class);
		if (response11.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response11.getStatus());
			}
		if (response11.getStatus() == 200) {
			System.out.println("GET SUCCESS LOAD USER BOOKMARKS");
			System.out.println(response11.readEntity(String.class));
			} 
		
		//remove user bookmarks
		Response response12 = webTarget.path("rest").path("removeuserbookmark").request("application/json").cookie(response2.getCookies().get("token")).cookie(response2.getCookies().get("email")).post(Entity.json(jsonInStringBookmark));
		if (response12.getStatus() != 200) {
			throw new RuntimeException("Failure HTTP Status : " + response12.getStatus());
			}
		if (response12.getStatus() == 200) {
			System.out.println("POST SUCCESS REMOVE USER BOOKMARKS");
			System.out.println(response12.readEntity(String.class));
			} 
			
		//TestingSQLFunction.Test();
		} 
		
		catch (Exception e){
			e.printStackTrace();
			}

		}
}
