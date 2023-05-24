package com.example.Medicare.exception;

public class DuplicateEmailException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateEmailException(String email) {
		super(email+" Already exists");
	}
}
