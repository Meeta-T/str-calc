package com.kata;

public class StringCalculator {
	Integer add(String numbers){
		if(numbers.equals(""))
			return 0;
		return Integer.parseInt(numbers);
	}
}
