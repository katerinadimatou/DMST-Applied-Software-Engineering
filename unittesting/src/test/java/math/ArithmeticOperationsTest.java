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
		op.divide(5.0, 0);	
	}
	
	/*
	 * A unit test that checks the function division with numerator
	 * zero returns zero
	 */
	
	@Test
	public void test_divide_with_zero_case() {
		op.divide(0, 8.4);	
	}
	
	/*
	 * A unit test that checks the result of the divide function
	 */
	@Test
	public void test_divide_result() {
		Assert.assertEquals(2,op.divide(6.2, 3.1), 0);
	}
	
	/*
	 * A unit test that checks the result of the multiply function 
	 */
	@Test 
	public void test_multiply_result() {
		Assert.assertEquals(30, op.multiply(5, 6));
	}
	
	/*
	 * A unit test that checks the result of the multiply zero case when x is zero
	 */
	@Test 
	public void test_multiply_zero_case_x() {
		Assert.assertEquals(0, op.multiply(5, 0));
	}
	
	/*
	 * A unit test that checks the result of the multiply zero case when y is zero
	 */
	@Test 
	public void test_multiply_zero_case_y() {
		Assert.assertEquals(0, op.multiply(0, 5));
	}
	
	
	/*
	 * A unit test that checks the result of the multiply zero case when x and y 
	 * are equal to zero
	 */
	@Test 
	public void test_multiply_zero_case_xy() {
		Assert.assertEquals(0, op.multiply(0, 0));
	}
	
	/*
	 * A unit test that checks whether the negative input x in the multiply
	 * function causes an IllegalArgumentException
	 */
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	
	@Test 
	public void test_multiply_RuleException_x() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		op.multiply(-1, 2);
	}
	
	/*
	 * A unit test that checks whether the negative input y in the multiply
	 * function causes an IllegalArgumentException
	 */
	@Rule 
	public ExpectedException thro = ExpectedException.none();
	
	@Test 
	public void test_multiply_RuleException_y() {
		thro.expect(IllegalArgumentException.class);
		thro.expectMessage("x & y should be >= 0");
		op.multiply(4, -2);
	}
	
	/*
	 * A unit test that checks whether the negative input y in the multiply
	 * function causes an IllegalArgumentException
	 */
	@Rule 
	public ExpectedException ex = ExpectedException.none();
	
	@Test 
	public void test_multiply_RuleException_zero_x() {
		ex.expect(IllegalArgumentException.class);
		ex.expectMessage("x & y should be >= 0");
		op.multiply(0, -2);
	}
	
	/*
	 * A unit test that checks whether the negative input y in the multiply
	 * function causes an IllegalArgumentException
	 */
	@Rule 
	public ExpectedException expe = ExpectedException.none();
	
	@Test 
	public void test_multiply_RuleException_zero_y() {
		expe.expect(IllegalArgumentException.class);
		expe.expectMessage("x & y should be >= 0");
		op.multiply(-3, 0);
	}
	
	/*
	 * A unit test that checks whether the negative input of x and y in the multiply
	 * function causes an IllegalArgumentException
	 */
	@Rule 
	public ExpectedException th = ExpectedException.none();
	
	@Test 
	public void test_multiply_RuleException_xy() {
		th.expect(IllegalArgumentException.class);
		th.expectMessage("x & y should be >= 0");
		op.multiply(-2, -2);
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
