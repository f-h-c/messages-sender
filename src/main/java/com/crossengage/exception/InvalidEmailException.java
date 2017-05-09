package com.crossengage.exception;


public class InvalidEmailException extends Exception {

	private static final long serialVersionUID = 821162064458522280L;

	public InvalidEmailException(String message) {
    super(message);
  }

}
