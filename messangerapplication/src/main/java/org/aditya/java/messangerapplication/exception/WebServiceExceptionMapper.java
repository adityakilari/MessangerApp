 package org.aditya.java.messangerapplication.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.aditya.java.messangerapplication.model.ErrorMessage;


@Provider
// @Provider registers this class in jax-rs
public class WebServiceExceptionMapper implements ExceptionMapper<WebServiceException> {

	@Override
	public Response toResponse(WebServiceException exception) {
		ErrorMessage message = new ErrorMessage(exception.getMessage(), 404, "contact aditya");
		return Response.status(Status.NOT_FOUND)
				.entity(message) 
				.build();
	}

	

}
