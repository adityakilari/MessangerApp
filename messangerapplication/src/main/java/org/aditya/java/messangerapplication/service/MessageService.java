package org.aditya.java.messangerapplication.service;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.aditya.java.messangerapplication.database.Database;
import org.aditya.java.messangerapplication.exception.WebServiceException;
import org.aditya.java.messangerapplication.model.Message;;

public class MessageService {
	
	
// creating an local member variable which points to the static instance call
	private Map<Long,Message> messages = Database.getMessages();
	
	public MessageService() {
		messages.put(1l,new Message(1l,"hello world!","Aditya"));
		messages.put(2l,new Message(2l,"hello ","Nagarjuna"));
		messages.put(3l,new Message(2l,"hello ","Usha"));
			
	}
	
// method to get all the messages	
	public List<Message> getAllMessages(){
		ArrayList<Message> list = new ArrayList<>();
		list.addAll(messages.values());
		return list;
	}
	
// method to filter the messages
	
	public List<Message> getmessageByyear(int year) {
		
		List<Message> list = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message mes : messages.values()) {
			cal.setTime(mes.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				list.add(mes);	
			}	
		}
		return list;
		
	}
	
	// method to filter the message using start and end parameters 
	
	public List<Message> getAllintheRange(int start, int size){
		List<Message> list = new ArrayList<>();
		list.addAll(messages.values());
		
		if(start+size >= list.size()) {
			return new ArrayList<Message>();
		}
		return list.subList(start, start+size);
	}
	
// method to get message based on id
	
	public Message getMessageById(long id) {
		Message m = messages.get(id);
		if(m == null) {
			throw new WebServiceException("Message with id"+ id + "not found");	
		}
		return m;
	}
	
// method to create a new message
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
// method to update a message 
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
		
	}
// method to delete a message
	public Message DeleteMessage(long id) {
		return messages.remove(id);
	}
	
}


