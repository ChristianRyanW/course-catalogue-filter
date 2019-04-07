package com.webservice.home;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/home")
public class home {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello World RESTful Jersey!";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello World RESTful Jersey"
				+ "</hello>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello World RESTful Jersey"
				+ "</title>" + "<body><h1>" + "Hello World RESTful Jersey"
				+ "</body></h1>" + "</html> ";
	}

	@POST
	@Consumes("application/json")
	public Response sayConfirm(String msg) {
		String output = "POST : " + msg;
		return Response.status(200).entity(output).build();
	}
}