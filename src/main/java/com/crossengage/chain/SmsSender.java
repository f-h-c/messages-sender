package com.crossengage.chain;

import com.crossengage.model.User;

public class SmsSender extends Sender {
	
	public SmsSender(User user, String message) {
		super(user, message);
	}
	
	@Override
	public void send() {
		/*try {
			sleep(5000);//Simulating the time needed to send SMS
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		System.out.println("SMS sent to " + getUser().getPhone() + "(id:" + getUser().getId() + ")" + " with text: " + getMessage());
	}

}
