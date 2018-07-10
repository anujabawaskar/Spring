package com.anuja.annotationdemo;

import org.springframework.stereotype.Component;

@Component("info")
public class CoachImpl implements Coach {

	@Override
	public String nextWorkingDay() {
		return "Monday";
	}

}
