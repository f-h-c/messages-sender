package com.crossengage;

import java.io.File;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {

		UserRepository repository = new UserRepository(new File(args[0]));
		
		repository.processMessages("Welcome to our system");
	}
}
