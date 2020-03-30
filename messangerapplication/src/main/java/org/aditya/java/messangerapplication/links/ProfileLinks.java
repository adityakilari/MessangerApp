package org.aditya.java.messangerapplication.links;

import javax.ws.rs.core.UriInfo;

import org.aditya.java.messangerapplication.model.Profile;
import org.aditya.java.messangerapplication.resource.ProfileResource;

public class ProfileLinks {
	
	public String getProfileurl(UriInfo path, Profile pro) {
		
		String url = path.getBaseUriBuilder()
					.path(ProfileResource.class)
					.path(pro.getProfilename())
					.build().toString();
		return url;
		
	}

}
