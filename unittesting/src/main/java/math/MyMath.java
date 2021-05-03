package math;

public class MyMath {

	public int factorial(int n) {
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException();
		}
		if (n == 0)
			return 1;
		else
			return (n * factorial(n - 1));
	}

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
