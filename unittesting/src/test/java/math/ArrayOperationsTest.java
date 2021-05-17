package math;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito.*;

import io.FileIO; 

public class ArrayOperationsTest {
	
	ArrayOperations ar = new ArrayOperations();
	public static String resourcesPath = "src/test/resources/";
	
	
	/*
	 * A unit test case that mocks ArrayOperations class
	 * and determines whether the output of the method 
	 * findPrimesInFile is right 
	 */

	@Test
	public void test_findPrimesInFile_mocking() {
		//Mock ArrayOperations dependency
		
		MyMath m = mock(MyMath.class);
		FileIO f = mock(FileIO.class);
		String filepath = resourcesPath.concat("primeAndNot.txt");
		
		when(f.readFile(filepath)).thenReturn(new int[] {3,4,7,2,8,9});
		when(m.isPrime(3)).thenReturn(true);
		when(m.isPrime(4)).thenReturn(false);
		when(m.isPrime(7)).thenReturn(true);
		when(m.isPrime(2)).thenReturn(true);
		when(m.isPrime(8)).thenReturn(false);
		when(m.isPrime(9)).thenReturn(false);
		
		int[] expected= {3,7,2};
		int[] actual= ar.findPrimesInFile(f, filepath, m);
		
		Assert.assertArrayEquals(expected, actual);
		
		
	}

}
