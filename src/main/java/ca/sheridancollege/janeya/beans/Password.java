package ca.sheridancollege.janeya.beans;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Password implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String website;
	private String userEmail;
	private String userPass;
	
	public Password() {}
	
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setPassword(String userPass) {
		this.userPass = userPass;
	}
	
	
}
