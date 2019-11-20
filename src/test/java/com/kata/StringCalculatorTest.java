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
	
	private Object[] parametersToShouldAdd() {
	    return new Object[] { 
	        new Object[] { "",0 }, 
	        new Object[] { "2",2 },
	        new Object[] { "3,5",8 },
	        new Object[] { "3,4,6",13 }
	    };
	}
	@Test
	@Parameters(method = "parametersToShouldAdd")
	public void shouldAdd(String numbers,Integer result){
		assertThat(stringCalculator.add(numbers),is(result));
	}
}
