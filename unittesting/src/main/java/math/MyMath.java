package math;

public class MyMath {
	
	/**
	 * Computes the factorial of an integer 
	 * @param n the integer that we want to calculate its factorial
	 * @return the factorial of the integer n 
	 * @exception IllegalArgumentException if n is smaller that zero or higher than twelve
	 */

	public int factorial(int n) {
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException();
		}
		if (n == 0)
			return 1;
		else
			return (n * factorial(n - 1));
	}
	
	/**
	 * Checks whether an integer number is prime or not
	 * @param n the integer that we want to check if it is prime
	 * @return true is the number is prime and false if the number is not prime
	 * @exception IllegalArgumentException if n is smaller than two
	 */

	public boolean isPrime(int n) {
		if (n < 2) {
			throw new IllegalArgumentException();
		}
		boolean isItPrime = true;
		for (int i = 2; i <= n / 2; i++) {
			if ((n % i) == 0) {
				isItPrime = false;

				break;
			}
		}
		return isItPrime;

	}
}
