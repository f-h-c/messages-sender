package com.crossengage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.crossengage.chain.EmailSenderManager;
import com.crossengage.chain.SenderManagerChain;
import com.crossengage.chain.SmsSenderManager;
import com.crossengage.exception.ConvertException;
import com.crossengage.model.User;

public class UserRepository {

	private File data;
	private List<User> users = new ArrayList<>();
	private SenderManagerChain senders;

	public UserRepository(File data) {
		this.data = data;
		
		senders = new EmailSenderManager();
		senders.setNext(new SmsSenderManager());
		
		try {
			consumeUsersFile();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> getAllEmails() throws IOException {
		List<String> emails = new ArrayList<>();
		
		for (User user : users)
			emails.add(user.getEmail());
		
		return emails;
	}
	
	public String toString() {
		return users.toString();
	}
	
	public void processMessages(String message) {
		for (User user : users) {
			senders.sendToUser(user, message);
		}
	}

	private void consumeUsersFile() throws IOException {
		int cont = 0;
		Stream<String> lines = Files.lines(data.toPath());

		for (String line : (Iterable<String>) lines::iterator) {
			if (cont++ > 0)
				try {
					users.add(User.parseUser(line));
				}
				catch (ConvertException e) {
					e.printStackTrace();
				}
		}

		lines.close();
	}
}
