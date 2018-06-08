package com.jj.learn;

public class PronicNumber {

	/**
	 * A number n is a pronic number if there exists k, where n = k * (k + 1).
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPronic(long n) {
		//a pronic number has to be an even number
		if (n %2 != 0) {
			return false;
		}
		
		int maxBound = (int) Math.floor(Math.sqrt(n));		//n = k^2 + k > k^2; k < sqrt(n)
		int minBound = (int) Math.floor(Math.sqrt(n/2));	//n = k^2 + k <= 2k^2; k >= sqrt(n/2)
		
		int count = 0;
		//for (int i = minBound; i <= maxBound; i ++) {
		for (long i = maxBound; i >= minBound; i --) {		//answer is more likely to be close to sqrt(n) than to 1.
			count ++;
			long r = i * (i + 1);
			if (r < n) {
				break;
			}
			if (r == n) {
				System.out.println("loop " + count);
				return true;
			}
		}
		System.out.println("loop " + count);
		return false;
	}
	
	public static void main(String[] args) {
		
		long a = 380;
		System.out.println(a + " " + (isPronic(a)? "is " : "is not ") + "a pronic number");
		
		a = 110*111;
		System.out.println(a + " " + (isPronic(a)? "is " : "is not ") + "a pronic number");
		
		a = 165*166;
		System.out.println(a + " " + (isPronic(a)? "is " : "is not ") + "a pronic number");
		
		a = ((long)326201)*((long)326202);		//default literal number is int, not long.
		System.out.println(a + " " + (isPronic(a)? "is " : "is not ") + "a pronic number");
		
		
		a = 165*165;
		System.out.println(a + " " + (isPronic(a)? "is " : "is not ") + "a pronic number");
		
		a = 165*356;
		System.out.println(a + " " + (isPronic(a)? "is " : "is not ") + "a pronic number");
		
		a = 16235*3533256;
		System.out.println(a + " " + (isPronic(a)? "is " : "is not ") + "a pronic number");
	}
}
