package math;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyMathTest {
	
	MyMath m = new MyMath();
	
	/*
	 * A unit test that checks an input below zero 
	 * in the factorial function causes an
	 * IllegalArgumentException 
	 */

	@Test(expected = IllegalArgumentException.class)
	public void test_factorial_number_smaller_than_zero(){
		m.factorial(-1);
	}
	
	/*
	 * A unit test that checks an input higher that twelve 
	 * in the factorial function causes an
	 * IllegalArgumentException 
	 */
	
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_factorial_number_higher_than_twelve() {
		thrown.expect(IllegalArgumentException.class);
		m.factorial(13);
	}
}
