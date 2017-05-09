package com.crossengage.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.crossengage.exception.ConvertException;

public class UserTest {

	private List<User> getUsersMock() {
		List<User> result = new ArrayList<>();

		result.add(new User(1, true, ContactType.MAIL, "test1@mail.com", "+999999999999", false));
		result.add(new User(2, true, ContactType.BOTH, "test2@mail.com", "+999999999998", true));
		result.add(new User(3, false, ContactType.SMS, "test3@mail.com", "+999999999998", true));
		result.add(new User(4, true, ContactType.MAIL, "test4@mail.com", "+999999999996", true));
		result.add(new User(5, true, ContactType.BOTH, "test4@mail.com", "+999999999996", false));

		return result;
	}

	@Test
	public void testParseUserContactTypeMAIL() {

		try {
			assertEquals(getUsersMock().get(0).toString(), User.parseUser("1,true,mail,test1@mail.com,+999999999999,false").toString());
		}
		catch (ConvertException e) { }

	}

	@Test
	public void testParseUserContactTypeSMS() {

		try {
			assertEquals(getUsersMock().get(2).toString(), User.parseUser("3,false,sms,test3@mail.com,+999999999998,true").toString());
		}
		catch (ConvertException e) { }

	}

	@Test
	public void testParseUserContactTypeBOTH() {

		try {
			assertEquals(getUsersMock().get(1).toString(), User.parseUser("2,true,both,test2@mail.com,+999999999998,true").toString());
		}
		catch (ConvertException e) { }

	}

	@Test(expected = ConvertException.class)
	public void testParseUserContactTypeERROR() throws Exception {

		User.parseUser("5,true,none,test4@mail.com,+999999999996,false");

	}

	@Test(expected = ConvertException.class)
	public void testParseUserMailERROR() throws Exception {

		User.parseUser("3,false,sms,test3mail.com,+999999999997,true");

	}

}
