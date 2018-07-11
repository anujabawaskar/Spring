package com.anuja.homework6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoachImpl implements Coach {

	@Autowired
	FortuneService fortuneService;
	
	
	@Override
	public int getCalorie(int base) {
		return base * 50;
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}


}
