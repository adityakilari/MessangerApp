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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.aditya.java.messangerapplication.model.Profile;
import org.aditya.java.messangerapplication.service.ProfileService;
import org.aditya.java.messangerapplication.links.ProfileLinks;


@Path("/profiles")
public class ProfileResource {

	ProfileService service = new ProfileService();
	ProfileLinks links = new ProfileLinks();
	
	// getall method
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAll() {
		return service.getAllprofiles();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile createnewProfile(Profile p) {
		return service.createProfile(p);	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profilenames}")
	public Profile updateProfile(@PathParam("profilenames") String pname, Profile p) {
		p.setProfilename(pname);
		return service.updateProfile(p) ;	
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profilenames}")
	public void Deleteprofile(@PathParam("profilenames") String pname) {
		 service.deleteProfile(pname);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profilenames}")
	public Profile getBypname(@PathParam("profilenames") String pname , @Context UriInfo info) {
		Profile p =  service.getProfilebypname(pname);
		p.getProfilelinks(links.getProfileurl(info, p), "self");
		return p;
		
	}
	
}
