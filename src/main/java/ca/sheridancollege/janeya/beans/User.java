package ca.sheridancollege.janeya.beans;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mstrUser;
	private String mstrPass;
	
	public User() {}

	public String getUser() {
		return mstrUser;
	}

	public void setUser(String mstrUser) {
		this.mstrUser = mstrUser;
	}

	public String getPass() {
		return mstrPass;
	}

	public void setPass(String mstrPass) {
		this.mstrPass = mstrPass;
	}
	
	
}
