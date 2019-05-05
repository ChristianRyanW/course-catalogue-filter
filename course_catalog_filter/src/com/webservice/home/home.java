package com.webservice.home;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// The home path is to make sure the homeClient is working properly before testing other methods, it serves no practical purpose outside of testing.
@Path("/home")
public class home {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Tag It RESTful Service!";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Tag It RESTful Service!"
				+ "</hello>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Tag It RESTful Service!"
				+ "</title>" + "<body><h1>" + "Tag It RESTful Service!"
				+ "</body></h1>" + "</html> ";
	}

	@POST
	@Consumes("application/json")
	public Response sayConfirm(String msg) {
		String output = "POST : " + msg;
		return Response.status(200).entity(output).build();
	}
}
