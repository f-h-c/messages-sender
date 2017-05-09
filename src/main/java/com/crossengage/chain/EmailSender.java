package com.crossengage.chain;

import com.crossengage.model.User;

public class EmailSender extends Sender {
	
	public EmailSender(User user, String message) {
		super(user, message);
	}
	
	@Override
	public void send() {
		if (getUser().canReceiveEmail()) {
			/*try {
				sleep(1000);//Simulating the time needed to send email
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			System.out.println("Email sent to " + getUser().getEmail() + "(id:" + getUser().getId() + ")" + " with text: " + getMessage());
		}
	}

}
