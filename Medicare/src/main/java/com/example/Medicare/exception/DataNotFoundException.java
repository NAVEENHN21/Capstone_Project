package com.example.Medicare.exception;

public class DataNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(){
		super("Requested data not found");
	}
}