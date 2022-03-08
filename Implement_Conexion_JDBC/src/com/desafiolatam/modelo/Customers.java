package com.desafiolatam.modelo;

public class Customers {
    
	private int id;
	private String name;
	private int age;
	private String address;
	private float salary;
	
	public Customers(int id, String name, int age, String address, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	
	   
}
