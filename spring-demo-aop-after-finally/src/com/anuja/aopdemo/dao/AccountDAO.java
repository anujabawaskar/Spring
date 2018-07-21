package com.anuja.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

import com.anuja.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	
	private String serviceCode;
	
	public List<Account> findAccounts(boolean b) {
		
		if(b) {
			throw new RuntimeException("no pizza for you!!");
		}
		List<Account> accounts = new ArrayList<>();
		
		Account acc = new Account("anuja", "silver");
		Account acc1 = new Account("abc", "silver");
		Account acc2 = new Account("xyz", "silver");
		accounts.add(acc);
		accounts.add(acc1);
		accounts.add(acc2);
		return accounts;
	}
	
	public String getName() {
		System.out.println(getClass() + "in getName()");
		return name;
	}
	public void setName(String name) {
		System.out.println(getClass() + "in setName");
		this.name = name;
	}
	public String getServiceCode() {
		System.out.println(getClass() + "in getServiceCode()");
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + "in setServiceCode");
		this.serviceCode = serviceCode;
	}
	public void addAccount(Account acc, boolean flag) {
		System.out.println(getClass() + "Doing my DB work!");
	}
	public boolean doWork() {
		System.out.println(getClass() + "Doing my work!");
		return false;
	}
}
