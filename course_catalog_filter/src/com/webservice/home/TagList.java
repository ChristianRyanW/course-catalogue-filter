package com.webservice.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/taglist")
public class TagList {
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response sayConfirm() {
		try {
		String tag;

		List<DataClass.Tags> tags = new ArrayList<>();
		
        try{
               Class.forName("com.mysql.cj.jdbc.Driver");
            
               Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tagit","notroot","K-YQ@5^Bq2d5~drD");
               
               PreparedStatement ps =con.prepareStatement("SELECT DISTINCT HASQUALITY.tag_name FROM HASQUALITY;");
           
               ResultSet rs =ps.executeQuery();
               
               while (rs.next()) {
            	tag = rs.getString("tag_name");

        		DataClass.Tags currentTag = new DataClass.Tags();
            	currentTag.setTag(tag);
            	tags.add(currentTag);
               }
               rs.close();
               
            }catch(Exception e)
            {
                e.printStackTrace();
            }
     	return Response.ok(tags, MediaType.APPLICATION_JSON).build();
		}
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).build();
		}
    }  
}
