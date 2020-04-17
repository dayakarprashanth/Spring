package com.example.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

@Component
public class AccountDAO {
	
	public List<Account> findAccounts()
	{
		List<Account> myAccount = new ArrayList<Account>();
		
		//create few accounts
		
		Account temp1= new Account("Raj","Silver");
		Account temp2= new Account("Banu","Gold");
		Account temp3= new Account("Hari","Platinum");
		
		//adding accounts
		myAccount.add(temp1);
		myAccount.add(temp2);
		myAccount.add(temp3);
		
		return myAccount;
		
	}
	
	

	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + "Add an account");
	}
	
	public void deleteAccount()
	{
		System.out.println(getClass() + "Deleteing the Account");
	}
}

