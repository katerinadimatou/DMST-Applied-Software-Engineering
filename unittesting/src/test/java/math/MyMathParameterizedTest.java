package math;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


/**
 * A test class that implements a Parameterized test
 * for the MyMath factorial method, 
 * for demonstrating Unit Testing.
 */
@RunWith(Parameterized.class)
public class MyMathParameterizedTest {
	
	// the value is the id of each parameter
	@Parameter (value=0)
	public int input;
	
	@Parameter (value=1)
	public int factorial;
	
	
	MyMath m = new MyMath();
	
	/*
	 * The following method generates the input values 
	 * for the tests. 
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{0,1},{1,1},{2,2},{12,479001600}};
		
		return Arrays.asList(data);
	}
	
	/*
	 * A unit test that is executed for each pair of 
	 * parameters. 
	 */
	
	@Test
	public void test_factorial_of_four_inputs() {
		Assert.assertEquals(factorial, m.factorial(input));
	}
	
}
