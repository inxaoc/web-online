package edu.itmo.model;

import java.util.ArrayList;
import java.util.List;

public class Mailbox {
	
	private List<Email> emails = new ArrayList<Email>();
	private String name = "Vitaly's Mailbox";
	private String email = "inxaoc@gmail.com";
	private String ownerName = "Vitaly Vlasov";
	
	private static Mailbox mail = new Mailbox(); 
	
	private Mailbox() {
	
	}
	
	public static Mailbox getMailbox() {
		if(mail == null) {
			return new Mailbox();			
		} else {
			return mail;
		}
	}
	
	public List<Email> getEmails() {
		return emails;
	}
	
	public void addEmail(Email email) {
		emails.add(email);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	

}
