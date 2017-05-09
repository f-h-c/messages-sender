package com.crossengage.chain;

import com.crossengage.model.ContactType;
import com.crossengage.model.User;

public abstract class SenderManagerChain {

	protected SenderManagerChain next;
	protected ContactType type;

	public SenderManagerChain(ContactType type) {
		this.next = null;
		this.type = type;
	}

	public void setNext(SenderManagerChain sender) {
		if (next == null) {
			next = sender;
		}
		else {
			next.setNext(sender);
		}
	}

	public void sendToUser(User user, String message) {
		if (canSend(user.getContactTypes()))
			send(user, message);

		if (next != null)
			next.sendToUser(user, message);
	}

	private boolean canSend(ContactType type) {
		if (this.type == type || type == ContactType.BOTH) {
			return true;
		}
		return false;
	}

	protected abstract void send(User user, String message);
}
