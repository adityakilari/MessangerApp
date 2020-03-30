package org.aditya.java.messangerapplication.model;


import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
public  class Message {
	
	private String message;
	private long id;
	private String author;
	private Date created;
	private static Map<Long,Comment> commentsMap = new HashMap<>();
	private   List<Link> linklist = new ArrayList<>();
	

	

	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
		//this.commentsMap = commentsMap;
	}
	
	
	public  Message() {
		
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	

	
@JsonIgnore
public static Map<Long, Comment> getCommentsMap() {
	return commentsMap;
}
public static void setCommentsMap(Map<Long, Comment> commentsMap) {
	Message.commentsMap = commentsMap;
}
public  List<Link> getLinklist() {
	return linklist;
}
public void setLinklist(List<Link> linklist) {
	this.linklist = linklist;
}
public void getLinks(String url , String rel){
	Link l = new Link();
	l.setUrl(url);
	l.setRelation(rel);
	linklist.add(l);
	
}
}

