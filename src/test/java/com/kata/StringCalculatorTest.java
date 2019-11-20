package com.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
	        new Object[] { "3,4,6",13 },
	        new Object[] { "1,2,3,4,5,6,7,8,9", 45 },
	        new Object[] { "1\n2,3", 6 },
	        new Object[] { "//;\n1;2", 3 },
	        new Object[] { "1001,2", 2 },
	        new Object[] { "//[***]\n1***2***3", 6 }
	    };
	}
	@Test
	@Parameters(method = "parametersToShouldAdd")
	public void shouldAdd(String numbers,Integer result){
		assertThat(stringCalculator.add(numbers),is(result));
	}
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
    public void throwsExceptionWhenNegativeNumbers() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("negatives not allowed: [-2, -3]");
        stringCalculator.add("1,-2,-3");
    }
}
