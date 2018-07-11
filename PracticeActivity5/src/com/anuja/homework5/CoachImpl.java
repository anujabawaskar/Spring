package com.anuja.homework5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoachImpl implements Coach {

	@Autowired
	FortuneService fortuneService;
	
	@Override
	public int getCalorie() {
		return 4500;
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
