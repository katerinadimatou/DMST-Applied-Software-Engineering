package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;


public class ArithmeticOperationsTest {
	
	ArithmeticOperations op = new ArithmeticOperations();
	
	/*
	 * A unit test that checks whether a denominator that is equal to zero
	 * causes an ArithmeticException
	 */
	
	@Test (expected = ArithmeticException.class)
	public void test_divide_with_zero_exception() {
		op.divide(5, 0);
		
	}
	
	/*
	 * A unit test that checks the result of the divide function
	 */
	@Test
	public void test_divide_result() {
		Assert.assertEquals(3,op.divide(6, 2), 0);
	}
	
	/*
	 * A unit test that checks whether the input of negative numbers in the multiply
	 * function causes an IllegalArgumentException
	 */
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	
	@Test 
	public void test_multiply_RuleException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		op.multiply(-1, 2);
	}
	
	
	/*
	 * A unit test that checks whether the input of very big numbers in the multiply
	 * function causes an IllegalArgumentException
	 */
	
	@Rule 
	public ExpectedException thr = ExpectedException.none();
	
	@Test 
	public void test_multiply_RuleException_maxvalue() {
		thr.expect(IllegalArgumentException.class);
		thr.expectMessage("The product does not fit in an Integer variable");
		op.multiply(2147483647, 2147483647);
	}
}
