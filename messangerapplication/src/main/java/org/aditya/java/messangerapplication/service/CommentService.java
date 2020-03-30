package org.aditya.java.messangerapplication.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aditya.java.messangerapplication.database.Database;
import org.aditya.java.messangerapplication.model.Comment;
import org.aditya.java.messangerapplication.model.Message;

public class CommentService {
	
	private Map<Long,Message> messages = Database.getMessages();

	
	// get all the comments of the message 
	
	public List<Comment> getAllcomments(long mesid){
		Map<Long,Comment> comments = new HashMap<>();
		messages.get(mesid);
		comments.putAll(Message.getCommentsMap());
		
		List<Comment> comment = new ArrayList<>();
		comment.addAll(comments.values());
		
		return comment;
		
	}
	// get comment with specific message-id and comment-id
	public Comment getComment(long msg_id,long com_id){
		messages.get(msg_id);
		Map<Long,Comment> comments = Message.getCommentsMap();
		return comments.get(com_id);
	}
	// create comment for message id	
	public Comment createComment(long msg_id, Comment com) {
		messages.get(msg_id);
		Map<Long,Comment> comments = Message.getCommentsMap();
		com.setId(comments.size()+1);
		comments.put(com.getId(), com);
		//return comments.get(com.getId());
		return com;
	}
	//update 
	public Comment updateComment(long msg_id, Comment com) {
		
		messages.get(msg_id);
		Map<Long,Comment> comments = Message.getCommentsMap();
		if(com.getId()<=0) {
			return null;
		}
		comments.put(com.getId(), com);
		return com;	
		
	}
	//delete
	public Comment DeleteComment(long msg_id, long com_id) {
		messages.get(msg_id);
		Map<Long,Comment> comments = Message.getCommentsMap();
		return comments.remove(com_id );
	}
}
