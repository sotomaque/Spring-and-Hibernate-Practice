package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	// create an array of fortunes
	private String[] fortunes = {"Good Day", "OK day", "Forgetable Day", "What a day", "Bad Day"};

	@Override
	public String getFortune() {
		// pick random string from array
		int randomIndex = new Random().nextInt(fortunes.length);
		return fortunes[randomIndex];
	}

}
