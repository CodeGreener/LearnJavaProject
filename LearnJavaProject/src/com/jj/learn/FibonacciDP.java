package com.jj.learn;

public class FibonacciDP {
	public static void main(String[] args) {
		System.out.println(fib(3));
		System.out.println(fib(5));
		System.out.println(fib(21));
		System.out.println(fib(61));
		
		System.out.println("===========");
		
		System.out.println(fib2(3));
		System.out.println(fib2(5));
		System.out.println(fib2(21));
		System.out.println(fib2(61));
	}
	
	//bottom up
	public static int fib(int n) {
		int[] fn = new int[n+1];
		fn[0] = 0;
		fn[1] = 1;
		for (int i = 2; i <= n; i ++) {
			fn[i] = fn[i-1] + fn[i-2];
		}
		
		return fn[n];
	}
	
	//top down with memoization
	public static int fib2(int n) {
		int[] cache = new int[n+1];
		for (int i = 0; i < cache.length; i ++) {
			cache[i] = -1;
		}
		
		if (n <= 0) {
			return 0;
		} 
		else if (n == 1) {
			return 1;
		}
		else {
			int fn_1 = cache[n-1], fn_2 = cache[n-2];
			
			if (fn_1 == -1) {
				fn_1 = fib(n-1);
				cache[n-1] = fn_1;
			}
			
			if (fn_2 == -1) {
				fn_2 = fib(n-2);
				cache[n-2] = fn_2;
			}
			
			return fn_1 + fn_2;
		}
	}
}
