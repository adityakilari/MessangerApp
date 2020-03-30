package org.aditya.java.messangerapplication.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	
	
	private String Profilename;
	private long id;
	private String firstname;
	private String lastname;
	private Date created;
	
	private List<ProfileLinks> links = new ArrayList<ProfileLinks>();
	


public Profile() {
		
	}
	
public Profile(long id, String Profilename,String firstname, String lastname) {
	this.created=new Date();
	this.firstname = firstname;
	this.id = id;
	this.lastname = lastname;
	this.Profilename = Profilename;
		
	}
	
	public String getProfilename() {
		return Profilename;
	}

	public void setProfilename(String profilename) {
		Profilename = profilename;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	
	
	public List<ProfileLinks> getLinks() {
		return links;
	}

	public void setLinks(List<ProfileLinks> links) {
		this.links = links;
	}
	
	public void getProfilelinks(String url, String rel) {
		ProfileLinks l = new ProfileLinks();
		l.setUrl(url);
		l.setRelation(rel);
		links.add(l);

	}
	
	

}
