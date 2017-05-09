package com.crossengage.model;

import com.crossengage.exception.ConvertException;
import com.crossengage.exception.InvalidEmailException;
import com.crossengage.validator.EmailValidator;

public class User {

	private int id;
	private boolean active;
	private ContactType contactTypes;
	private String email;
	private String phone;
	private boolean receiveEmail = false;
	
	public User(int id, boolean active, ContactType contactTypes, String email, String phone, boolean receiveEmail) {
		this.id = id;
		this.active = active;
		this.contactTypes = contactTypes;
		this.email = email;
		this.phone = phone;
		this.receiveEmail = receiveEmail;
	}
	
	public User() {
		
	}

	public String toString() {
		return "{id: " + id + ", active: " + active + ", contactTypes: " + contactTypes + ", email: " + email + ", phone: "
				+ phone + ", enabled: " + receiveEmail + "}";
	}

	private void setField(int fieldIndex, String value) throws InvalidEmailException {
		switch (fieldIndex) {
			case 0:
				setId(value);
				break;
			case 1:
				setActive(value);
				break;
			case 2:
				setContactTypes(value);
				break;
			case 3:
				setEmail(value);
				break;
			case 4:
				setPhone(value);
				break;
			case 5:
				setReceiveEmail(value);
				break;
		}
	}

	public static User parseUser(String line) throws ConvertException {
		User user = new User();
		Exception error = null;

		if (line != null) {
			String[] pieces = line.split(",");

			try {
				for (int i = 0; i < pieces.length; i++)
					user.setField(i, pieces[i]);
			}
			catch (Exception e) {
				error = e;
			}
		}

		if (error != null)
			throw new ConvertException("Problems converting '" + line + "' to User.\n" + error.getMessage());

		return user;
	}

	public int getId() {
		return id;
	}

	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = Boolean.parseBoolean(active);
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws InvalidEmailException {
		if (EmailValidator.isEmailValid(email))
			this.email = email;
		else
			throw new InvalidEmailException("Invalid email: " + email);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ContactType getContactTypes() {
		return contactTypes;
	}

	public void setContactTypes(String value) {
		this.contactTypes = ContactType.valueOf(value.toUpperCase());
	}

	public void setContactTypes(ContactType contactTypes) {
		this.contactTypes = contactTypes;
	}

	public boolean canReceiveEmail() {
		return receiveEmail;
	}

	public void setReceiveEmail(String value) {
		this.receiveEmail = Boolean.parseBoolean(value);
	}

	public void setReceiveEmail(boolean value) {
		this.receiveEmail = value;
	}

}
