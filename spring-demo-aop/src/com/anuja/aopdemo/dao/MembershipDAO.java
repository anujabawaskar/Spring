package com.anuja.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + "In membership");
	}
	public void gosleep() {
		System.out.println("Sleeping now");
	}
}
