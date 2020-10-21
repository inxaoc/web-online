package edu.itmo.model;

import java.util.List;

public class Email {
	
	private String topic;
	private Contact sender;
	private String body;
	private List<Contact> cc;
	
	public Email(String topic, Contact sender, String body) {
		super();
		this.topic = topic;
		this.sender = sender;
		this.body = body;
	}
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Contact getSender() {
		return sender;
	}
	public void setSender(Contact sender) {
		this.sender = sender;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public List<Contact> getCc() {
		return cc;
	}
	public void setCc(List<Contact> cc) {
		this.cc = cc;
	}

}
