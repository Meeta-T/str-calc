package com.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.kata.StringCalculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class StringCalculatorTest {
	private StringCalculator stringCalculator;
	
	@Before
	public void initialie(){
		stringCalculator = new StringCalculator();
	}
	@Test
	@Parameters({",0",
				"2,2"})
	public void shouldAdd(String numbers,Integer result){
		assertThat(stringCalculator.add(numbers),is(result));
	}
}
