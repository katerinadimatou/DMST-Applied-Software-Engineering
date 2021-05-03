package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

public class ArrayOperations {
	
	public int[] findPrimesInFile(FileIO fileIo,
			String filepath, MyMath myMath) {
		
		int[]numbers = fileIo.readFile(filepath);
		List<Integer> primenums = new ArrayList<>();
		
		for (int i=0; i< numbers.length ;i++) {
			if (myMath.isPrime(numbers[i])== true) {
				primenums.add(numbers[i]);
			}
		}
		
		return primenums.stream().mapToInt(i -> i).toArray();
	}

}
