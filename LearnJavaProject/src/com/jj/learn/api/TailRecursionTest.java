package com.jj.learn.api;

import java.util.Date;

public class TailRecursionTest {

	public static void main(String[] args) {
		Date start = new Date();
		System.out.format("factorial %f\n", new TailRecursionTest().factorial(100));
		Date end = new Date();
		System.out.println("time taken " + (end.getTime() - start.getTime()));
		
		start = new Date();
		System.out.format("factorial %f\n", new TailRecursionTest().factorial(100, 1));
		end = new Date();
		System.out.println("time taken " + (end.getTime() - start.getTime()));
		 
	}

	/**
	 * No tail recursion.
	 * 
	 * @param n
	 * @return
	 */
	public double factorial(long n) {
		if (n <= 1) {
			return n;
		}
		
		return n * factorial(n-1);
	}
	
	/**
	 * Tail recursion.
	 * 
	 * @param n
	 * @param product
	 * @return
	 */
	public double factorial(long n, double product) {
		if (n <= 1) {
			return product;
		}
		//System.out.println(n + ", " + product);
		return factorial(n-1, n * product);
	}
}
