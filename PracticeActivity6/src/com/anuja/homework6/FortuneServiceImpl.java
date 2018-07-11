package com.anuja.homework6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {
	List<String> fortunes = new ArrayList<String>();
	
	@PostConstruct
	public void init() {
		File file = new File("fortunes.txt");
		FileReader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader buff = new BufferedReader(reader);
		String sb;
		try {
			while((sb = buff.readLine()) != null) {
				fortunes.add(sb);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String getFortune() {
		
		
		Random random = new Random();
		int num = random.nextInt(fortunes.size());
		return fortunes.get(num);
	}

}
