package com.anuja.homework2;

public class FootballCoach implements Coach {
	
	FortuneService fortuneService;
	
	public FootballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run 15 km";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
