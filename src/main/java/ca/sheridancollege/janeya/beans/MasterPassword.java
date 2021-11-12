package ca.sheridancollege.janeya.beans;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class MasterPassword implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mstrUser;
	private String msterPass;
	
	public MasterPassword() {}

	public String getMstrUser() {
		return mstrUser;
	}

	public void setMstrUser(String mstrUser) {
		this.mstrUser = mstrUser;
	}

	public String getMsterPass() {
		return msterPass;
	}

	public void setMsterPass(String msterPass) {
		this.msterPass = msterPass;
	}
	
	
}
