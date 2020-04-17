package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String name;
	private String email;

	public void addAccount() {
		
		System.out.println(getClass() + "Add an account");
	}
	
	public void deleteAccount()
	{
		System.out.println(getClass() + "Deleteing the Account");
	}
	
	public String getName() {
		System.out.println(getClass() + "==== Getting name");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + "====== Setting name");
		this.name = name;
	}

	public String getEmail() {
		System.out.println(getClass() + "==== Getting Email");
		return email;
	}

	public void setEmail(String email) {
		System.out.println(getClass() + "==== Setting Email");
		this.email = email;
	}
}

