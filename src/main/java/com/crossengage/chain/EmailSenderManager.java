package com.crossengage.chain;

import com.crossengage.model.ContactType;
import com.crossengage.model.User;

public class EmailSenderManager extends SenderManagerChain {

	public EmailSenderManager() {
		super(ContactType.MAIL);
	}

	@Override
	protected void send(User user, String message) {
		new EmailSender(user, message).start();
	}

}
