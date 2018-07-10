package com.anuja.homework2;

import java.util.Random;

public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getFortune() {
		Random r = new Random();
		int Low = 0;
		int High = 3;
		int Result = r.nextInt(High-Low) + Low;
		System.out.println(Result);
		String[] fortunes = {"you will be lucky", "you will win", "you will be sad"};
		return fortunes[Result];
	}

}
