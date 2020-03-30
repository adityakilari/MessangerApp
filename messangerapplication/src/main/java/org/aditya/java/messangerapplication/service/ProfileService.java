package org.aditya.java.messangerapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.aditya.java.messangerapplication.database.Database;
import org.aditya.java.messangerapplication.model.Profile;

public class ProfileService {
	private Map<String,Profile> profiles = Database.getProfiles();
	
	
	
	

	
	public ProfileService() {
		profiles.put("Aditya",new Profile(1l,"Aditya","aditya","kilati"));
		profiles.put("Nagarjuna",new Profile(2l,"Nagarjuna","Kilari","Nagarjuna"));
		profiles.put("Usha",new Profile(3l,"Usha","usha","rani"));
		
		//profiles.clear();
		
	}
	
	// method to get all profile names 
	
	public List<Profile> getAllprofiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	// method to get profile by profile name 
	
	public Profile getProfilebypname(String pname) {
		
		
		return profiles.get(pname);
		
	}
	
	// method to create new profile with profile id
	
	public Profile createProfile(Profile p) {
		p.setId(profiles.size()+1);
		profiles.put(p.getProfilename(),p);
		return p;
	}
	
	// method to update with profile name 
	
	public Profile updateProfile(Profile p)
	{
		if(p.getProfilename().isEmpty()) {
		return null;
		}
		profiles.put(p.getProfilename(), p);
		return p;
		
	}
	// method to delete profile
	
	public Profile deleteProfile(String pname) {
		return profiles.remove(pname);
		
	}
}
