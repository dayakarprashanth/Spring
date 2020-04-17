package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + "Add an account");
	}
	
	public void deleteAccount()
	{
		System.out.println(getClass() + "Deleteing the Account");
	}
}

