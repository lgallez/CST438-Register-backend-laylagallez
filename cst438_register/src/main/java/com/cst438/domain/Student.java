package com.cst438.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String name;
	private String email;
	private int statusCode;
	private String status;
	
	public Student() {
		super();
	}
	
	public int getStudent_id() {
		return student_id;
	}
	public Student setStudent_id(int student_id) {
		this.student_id = student_id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Student setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Student setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public Student setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public String getStatus() {
		return status;
	}
	public Student setStatus(String status) {
		this.status = status;
		return this;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", email=" + email + ", statusCode="
				+ statusCode + ", status=" + status + "]";
	}

}
