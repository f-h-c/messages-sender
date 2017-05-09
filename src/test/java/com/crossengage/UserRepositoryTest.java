package com.crossengage;

import org.junit.Test;

import com.crossengage.model.ContactType;
import com.crossengage.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTest {

	@Test
	public void testGetAllEmails() throws IOException {
		UserRepository repository = new UserRepository(
				new File(this.getClass().getResource("/test_user_data.txt").getFile()));
		List<String> emails = repository.getAllEmails();

		assertEquals(4, emails.size());
		System.out.println(emails);
	}

	private List<User> getUsersMock() {
		List<User> result = new ArrayList<>();

		result.add(new User(1, true,  ContactType.MAIL, "test1@mail.com", "+999999999999", false));
		result.add(new User(2, true,  ContactType.BOTH, "test2@mail.com", "+999999999998", true));
		result.add(new User(4, true,  ContactType.MAIL, "test4@mail.com", "+999999999996", true));
		result.add(new User(5, true,  ContactType.BOTH, "test4@mail.com", "+999999999996", false));
		
		return result;
	}

	@Test
	public void testConsumeUsersFile() {
		UserRepository repository = new UserRepository(
				new File(this.getClass().getResource("/test_user_data.txt").getFile()));
		
		assertEquals(getUsersMock().toString(), repository.toString());

	}

}
