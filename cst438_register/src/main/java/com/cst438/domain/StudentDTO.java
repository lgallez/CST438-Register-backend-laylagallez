package com.cst438.domain;

public class StudentDTO {

	private int id;
	private int studentStatus;
	private String email;
	private String studentName;
	
	public int getId() {
		return id;
	}
	
	public int getStatus() {
		return studentStatus;
	}
	
	public StudentDTO setStudentStatus(int studentStatus) {
		this.studentStatus = studentStatus;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public StudentDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getStudentName() {
		return studentName;
	}

	public StudentDTO setStudentName(String studentName) {
		this.studentName = studentName;
		return this;
	}
}
