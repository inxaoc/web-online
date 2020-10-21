package edu.itmo.service;

import edu.itmo.model.Contact;
import edu.itmo.model.Email;
import edu.itmo.model.Mailbox;

public class MailService {
	
	public static void populateEmails(Contact[] contacts, String[] bodies, String[] topics)
	{
		Mailbox mail = Mailbox.getMailbox();
		
		for(int i=0;i<contacts.length;i++) {
			
			Email email = new Email(topics[i], contacts[i], bodies[i]);
			
			mail.addEmail(email);
		}
	}
}
