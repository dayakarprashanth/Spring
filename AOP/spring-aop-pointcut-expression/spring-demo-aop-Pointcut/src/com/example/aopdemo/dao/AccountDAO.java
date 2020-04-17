package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		
		System.out.println(getClass() + "Add an account");
	}
	
	public void deleteAccount()
	{
		System.out.println(getClass() + "Deleteing the Account");
	}
}

