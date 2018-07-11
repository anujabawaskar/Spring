package com.anuja.homework7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public TeamFortune teamfortuneCrazy() {
		return new TeamFortuneImpl();
	}
	
	@Bean
	public Coach coach() {
		return new CoachImpl(teamfortuneCrazy());
	}
	

}
