package com.qa.PersonProject.entities;

public class PersonDTO {
	
	public PersonDTO(){
		super();
	}
	
	public PersonDTO(Long id, int age, String firstname, String lastname) {
		this.id = id;
		this.age = age;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	private Long id;
	private int age;
	private String firstname;
	private String lastname;
	
	
}
