package edu.wccnet.jopataylor.restDemo.controller;

@SuppressWarnings("serial")
public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String msg) {
		super(msg);
	}

}
