package fr.afcepf.al32.groupe2.util;

public enum UserDeregistrationMotive {
	
	SATISFACTION("I'm not satisfied with the platform"),
	INTEREST("I have no more interest in the platform"),
	ERGONOMICS("I'm not satisfied with platform ergonomics");
	
	private UserDeregistrationMotive(String description){
		this.description = description;
	}
	
	private String description;
	
	public String getDescription() {
		return description;
	}
}
