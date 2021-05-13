package math;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class MyMathTest {
	
	MyMath m = new MyMath();
	
	/*
	 * A unit test that checks the output of factorial
	 */
	
	@Test
	public void test_factorial() {
		Assert.assertEquals(2, m.factorial(2));
	}
	
	/*
	 * A unit test that checks that if the factorial of 
	 * number zero returns one
	 */
	
	@Test
	public void test_factorial_zero() {
		Assert.assertEquals(1, m.factorial(0));
	}
	
	
	/*
	 * A unit test that checks an input below zero 
	 * in the factorial function causes an
	 * IllegalArgumentException 
	 */

	@Rule 
	public ExpectedException t = ExpectedException.none();
	
	@Test
	public void test_factorial_number_smaller_than_zero() {
		t.expect(IllegalArgumentException.class);
		t.expectMessage("Input number should be higher than zero and smaller than twelve");
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
		thrown.expectMessage("Input number should be higher than zero and smaller than twelve");
		m.factorial(13);
	}
	
	/*
	 * A unit test that checks the output of factorial
	 */
	
	@Test
	public void test_factorial_border() {
		Assert.assertEquals(479001600, m.factorial(12));
	}
	
	
	
	/*
	 * A unit test that checks an input smaller than two 
	 * in the isPrime function causes an
	 * IllegalArgumentException 
	 */
	
	@Rule 
	public ExpectedException thr = ExpectedException.none();
	
	@Test
	public void test_prime_number_smaller_than_two() {
		thr.expect(IllegalArgumentException.class);
		thr.expectMessage("Input number should be higher than two");
		m.isPrime(1);
	}
	
	/*
	 * A unit test that checks an input smaller than two 
	 * in the isPrime function causes an
	 * IllegalArgumentException 
	 */
	
	@Rule 
	public ExpectedException th = ExpectedException.none();
	
	@Test
	public void test_prime_number_zero() {
		th.expect(IllegalArgumentException.class);
		th.expectMessage("Input number should be higher than two");
		m.isPrime(1);
	}
	
	/*
	 * A unit test that checks that the isPrime method
	 * determines successfully whether number two which is the border
	 * is prime
	 */
	@Test 
	public void test_prime_border() {
		Assert.assertEquals(true, m.isPrime(2));
	}
	
	
	/*
	 * A unit test that checks that the isPrime method
	 * determines successfully whether a number is prime
	 */
	
	@Test
	public void test_if_prime() {
		Assert.assertEquals(true, m.isPrime(7));
	}
	
	/*
	 * A unit test that checks that the isPrime method
	 * determines successfully whether a number is prime
	 */
	
	@Test
	public void test_if_not_prime() {
		Assert.assertEquals(false, m.isPrime(4));
	}
	
	
	
}
