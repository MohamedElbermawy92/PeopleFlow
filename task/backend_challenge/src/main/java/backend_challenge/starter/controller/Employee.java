package backend_challenge.starter.controller;

import backend_challenge.starter.services.States;

public class Employee {

	private int id;
	private String name;
	private int age;
	private States state;
	
	
	public Employee() {
		
	}
	
	
	public Employee(int id, String name, int age,States state) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public States getState() {
		return state;
	}


	public void setState(States state) {
		this.state = state;
	}
	
	
	
	
}
