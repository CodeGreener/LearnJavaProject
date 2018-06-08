package com.jj.learn;

import java.util.Arrays;

public class MinRemoval {

	public static void main (String[] args) {
		System.out.println("GfG!");
		
		int a[] = {1, 3, 4, 9, 10, 11, 12, 17, 20};
		System.out.println(removal(a, 4));
		
		 int[] b = {1, 5, 6, 2, 8};
		 System.out.println(removal(b, 2));
	}
	
	/*
	 * Given N integers and K, find the minimum number of elements that should be removed such that Amax-Amin<=K. 
	 * After removal of elements, Amax and Amin is considered among the remaining elements.
	 */
	public static int removal(int[] arr, int k) {
		Arrays.sort(arr);
		
		int minRemoval = 0;
		int first = 0;
		int last = arr.length - 1;
		if (arr[last] - arr[first] > k) {
			//try removing first
			int[] newArr = new int[arr.length - 1];
			System.arraycopy(arr, 1, newArr, 0, newArr.length);
			int firstCount = 1 + removal(newArr, k);
			
			//try remove last
			int[] lastArr = new int[arr.length - 1];
			System.arraycopy(arr, 0, newArr, 0, newArr.length);
			int lastCount = 1 + removal(newArr, k);
			
			minRemoval = firstCount > lastCount? lastCount : firstCount;
		}
		
		return minRemoval;
	}
}
