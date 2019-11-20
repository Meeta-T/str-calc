package com.kata;

public class StringCalculator {
	Integer add(String numbers){
		Integer result = new Integer(0);
		if(numbers.equals(""))
			return 0;
		String[] arrNumbers = numbers.split(",");
		for (String string : arrNumbers) {
			result = result + Integer.parseInt(string);
		}
		return result;
	}
}
