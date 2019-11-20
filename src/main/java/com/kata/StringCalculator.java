package com.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
	Integer add(String numbers){
		Integer result = new Integer(0);
		String seperator = ",";
		String[] arrSeperator;
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		Integer iNumber;
		if(!numbers.isEmpty()){
			String firstLine = numbers.split("\n")[0];
			if(firstLine.startsWith("//")){
				String seperatorString = firstLine.substring(2);
				if(seperatorString.length()!=1){
					seperatorString = seperatorString.replace("][",",");
					seperatorString = seperatorString.replace("[","");
					seperatorString = seperatorString.replace("]","");
				}
				arrSeperator = seperatorString.split(",");
				numbers = numbers.split("\n")[1];
				for (int i = 0; i < arrSeperator.length; i++) {
					numbers = numbers.replace(arrSeperator[i], ",");
				}
			}
			String[] arrNumbersNewLine = numbers.split("\n");
			
			for (String strNewLine : arrNumbersNewLine){
				String[] arrNumbers = strNewLine.split(Pattern.quote(seperator));
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
