package com.kata;

public class StringCalculator {
	Integer add(String numbers){
		Integer result = new Integer(0);
		String seperator = ",";
		if(!numbers.isEmpty()){
			String[] arrNumbersNewLine = numbers.split("\n");
			
			for (String strNewLine : arrNumbersNewLine){
				String[] arrNumbers = strNewLine.split(seperator);
				for (String string : arrNumbers) {
					result = result + Integer.parseInt(string);
				}
			}
		}
		return result;
	}
}
