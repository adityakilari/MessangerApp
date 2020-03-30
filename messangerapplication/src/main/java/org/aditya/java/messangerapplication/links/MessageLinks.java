package org.aditya.java.messangerapplication.links;

import javax.ws.rs.core.UriInfo;

import org.aditya.java.messangerapplication.model.Message;
import org.aditya.java.messangerapplication.resource.MessageResource;
import org.aditya.java.messangerapplication.resource.ProfileResource;

public class MessageLinks {
	
	
	
	public  String geturiself(UriInfo pathinfo, Message m) {
		String uri = pathinfo.getBaseUriBuilder()
		 		 .path(MessageResource.class)
		 		 .path(Long.toString(m.getId()))
		 		 .build().toString();
		 		  return uri;
		 
	}
	
	
	
	public String getProfilelinkinMessage(UriInfo pathinfo, Message m) {
		
		String url = pathinfo.getBaseUriBuilder()
				.path(ProfileResource.class)
				.path(m.getAuthor())
				.build()
				.toString();
		
		
		
		return url;
		
	}

}
