package io;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*
 * A unit test that checks whether the method reads the file
 * with the numbers successfully
 */

public class FileIOTest {
	
	FileIO file = new FileIO();
	public static String resourcesPath = "src/test/resources/";

	@Test
	public void test_read_file() {
		int[] expected = new int[] {
				1,2,3,4,5,6,7,8};
		String filepath = resourcesPath.concat("nums.txt");
		Assert.assertArrayEquals(expected, file.readFile(filepath));
		
	}
	
	/*
	 * A unit test that checks whether the method throws an IllegalArgumentException 
	 * if the given file does not exist
	 */
	
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_nonexistent_file_exception() {
		thrown.expect(IllegalArgumentException.class);
		String filepath = resourcesPath.concat("names.txt");
		int[] result = file.readFile(filepath);
		
		
	}
	
	/*
	 * A unit test that checks whether the method throws an IllegalArgumentException 
	 * if the given file is empty
	 */
	
	@Rule 
	public ExpectedException thr = ExpectedException.none();
	
	@Test
	public void test_empty_file_exception() {
		thr.expect(IllegalArgumentException.class);
		String filepath = resourcesPath.concat("emptynums.txt");
		int[] result = file.readFile(filepath);
		
		
	}
	
	@Test 
	public void testReadFileContainsInvalidEntries() {
		String filepath = resourcesPath.concat("invaliddata.txt");
		int[] result = file.readFile(filepath);
	}

}
