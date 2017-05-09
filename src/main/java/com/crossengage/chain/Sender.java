package com.crossengage.chain;

import com.crossengage.model.User;

public abstract class Sender extends Thread implements iSender {

	private User user;
	private String message;

	public Sender(User user, String message) {
		this.user = user;
		this.message = message;
	}

	public void run() {
		send();
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}