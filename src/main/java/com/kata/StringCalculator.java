package com.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
	public static final String NEW_LINE = "\n";
	Integer add(String numbers){
		Integer result = new Integer(0);
		String seperator = ",";
		String[] customSeperator;
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		Integer iNumber;
		if(!numbers.isEmpty()){
			String firstLine = numbers.split(NEW_LINE)[0];
			if(firstLine.startsWith("//")){
				customSeperator = getCustomSeparator(firstLine);
				numbers = numbers.split(NEW_LINE)[1];
				for (int i = 0; i < customSeperator.length; i++) {
					numbers = numbers.replace(customSeperator[i], ",");
				}
			}
			String[] arrNumbersNewLine = numbers.split(NEW_LINE);
			
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
	private String[] getCustomSeparator(String SeperatorInput){
		String seperatorString = SeperatorInput.substring(2);
		if(seperatorString.length()!=1){
			seperatorString = seperatorString.replace("][",",");
			seperatorString = seperatorString.replace("[","");
			seperatorString = seperatorString.replace("]","");
		}
		return seperatorString.split(",");
	}
}
