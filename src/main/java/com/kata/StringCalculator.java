package com.kata;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	Integer add(String numbers){
		Integer result = new Integer(0);
		String seperator = ",";
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		Integer iNumber;
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
					iNumber = Integer.parseInt(string);
					if(iNumber>=0 && iNumber<=1000)
						result = result + iNumber;
					else if(iNumber<0)
						negativeNumbers.add(iNumber);
				}
			}
			if(!negativeNumbers.isEmpty())
				throw new IllegalArgumentException("negatives not allowed: "+negativeNumbers.toString());
		}
		return result;
	}
}
