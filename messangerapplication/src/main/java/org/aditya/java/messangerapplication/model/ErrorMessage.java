package org.aditya.java.messangerapplication.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	
	private String errormessage;
	private int errorcode;
	private String formoreinfo;
	
	public ErrorMessage() {
		
	}
	
public ErrorMessage(String errormessage, int  errorcode,String formoreinfo ) {
		this.errormessage =  errormessage;
		this.errorcode =  errorcode;
		this.formoreinfo = formoreinfo;
	}
	
	
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	

	public String getFormoreinfo() {
		return formoreinfo;
	}

	public void setFormoreinfo(String formoreinfo) {
		this.formoreinfo = formoreinfo;
	}
	

}
