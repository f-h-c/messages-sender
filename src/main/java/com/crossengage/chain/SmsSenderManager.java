package com.crossengage.chain;

import com.crossengage.model.ContactType;
import com.crossengage.model.User;

public class SmsSenderManager extends SenderManagerChain {

	public SmsSenderManager() {
		super(ContactType.SMS);
	}

	@Override
	protected void send(User user, String message) {
		new SmsSender(user, message).start();
	}

}
