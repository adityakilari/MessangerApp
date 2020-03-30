package org.aditya.java.messangerapplication.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.aditya.java.messangerapplication.model.Message;
import org.aditya.java.messangerapplication.resource.Been.MessageFilterBeen;
import org.aditya.java.messangerapplication.service.MessageService;
import org.aditya.java.messangerapplication.links.MessageLinks;


@Path("/messages")
public class MessageResource {
	MessageService Service = new MessageService();
	MessageLinks Hatoslinks = new MessageLinks();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageFilterBeen bean)
									 {
		if(bean.getYear()>0) {
			return Service.getmessageByyear(bean.getYear());
		}if(bean.getStart()>=0 && bean.getSize()>0) {
			return Service.getAllintheRange(bean.getStart(), bean.getSize());
			
		}
		return Service.getAllMessages();	
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Message createMessage(Message mes) {
		return Service.addMessage(mes);	
	}
	
	@PUT
	@Path("/{messageid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageid") int id, Message msg) {
		msg.setId(id);
		return Service.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageid") long id) {
		Service.DeleteMessage(id); 
		
	}
	
	@GET
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageid") long id, @Context UriInfo pathinfo) {
		 Message m= Service.getMessageById(id);
		 m.getLinks(Hatoslinks.geturiself(pathinfo, m),"self");
		 m.getLinks(Hatoslinks.getProfilelinkinMessage(pathinfo, m), "self");
		 return m;
		 
	}

	@Path("/{messageid}/comments")
	public CommentResource getCommentswhentriggered() {
		return new CommentResource();
	}
	
}
