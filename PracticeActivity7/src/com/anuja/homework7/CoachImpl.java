package com.anuja.homework7;

public class CoachImpl implements Coach {

	TeamFortune fortune;
	
	public CoachImpl(TeamFortune teamfortuneCrazy) {
		fortune = teamfortuneCrazy;
	}

	@Override
	public int getHoliday() {
		return 4;
	}

	@Override
	public String predict() {
		// TODO Auto-generated method stub
		return fortune.prediction();
	}

}
