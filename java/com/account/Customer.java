package com.account;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int amount;
	
	public Customer(String firstName, String lastName, String email, int amount) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.amount = amount;
	}

	public Customer(int id, String firstName, String lastName, String email, int amount) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", amount=" + amount + "]";
	}
	
	
}
