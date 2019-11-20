package com.kata;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	Integer add(String numbers){
		Integer result = new Integer(0);
		String seperator = ",";
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		if(!numbers.isEmpty()){
			String firstLine = numbers.split("\n")[0];
			if(firstLine.startsWith("//")){
				seperator = firstLine.substring(2);
				numbers = numbers.substring(4);
			}
			String[] arrNumbersNewLine = numbers.split("\n");
			
			for (String strNewLine : arrNumbersNewLine){
				String[] arrNumbers = strNewLine.split(seperator);
				for (String string : arrNumbers) {
					if(Integer.parseInt(string)>=0)
						result = result + Integer.parseInt(string);
					else
						negativeNumbers.add(Integer.parseInt(string));
				}
			}
			if(!negativeNumbers.isEmpty())
				throw new IllegalArgumentException("negatives not allowed: "+negativeNumbers.toString());
		}
		return result;
	}
}
