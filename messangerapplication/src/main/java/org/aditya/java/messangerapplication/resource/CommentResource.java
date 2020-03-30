package org.aditya.java.messangerapplication.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.aditya.java.messangerapplication.model.Comment;
import org.aditya.java.messangerapplication.service.CommentService;


public class CommentResource {

	private CommentService  service= new CommentService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getAllComments(@PathParam("messageid") long mess_id){
		return service.getAllcomments(mess_id);	
		
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
 
	public Comment createComment(@PathParam("messageid") long mess_id , Comment com) {		
		return service.createComment(mess_id, com);
		
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{commentid}")
	public Comment updateComment(@PathParam("messageid") long mess_id,Comment com) {
		return service.updateComment(mess_id, com);
		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{commentid}")
	public Comment DeleteComment(@PathParam("messageid") long mess_id, @PathParam("commentid") long commentid) {
		return service.DeleteComment(mess_id, commentid);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{commentid}")
	public Comment getComment(@PathParam("messageid") long mess_id, @PathParam("commentid") long commentid) {
		return service.getComment(mess_id, commentid);
		
	}
	
	
	
}