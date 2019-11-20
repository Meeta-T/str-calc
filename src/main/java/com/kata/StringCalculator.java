package com.kata;

public class StringCalculator {
	Integer add(String numbers){
		Integer result = new Integer(0);
		String seperator = ",";
		if(!numbers.isEmpty()){
			String[] arrNumbers = numbers.split(seperator);
			for (String string : arrNumbers) {
				result = result + Integer.parseInt(string);
			}
		}
		return result;
	}
}
