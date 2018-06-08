package com.jj.learn.api;

import java.util.Arrays;

public class InsertionSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = {23, 12, 56, 45, 97, 2, 56, 99, 24, 125, 99, 4, 7};
		
		insertionSort(input);
		System.out.println(Arrays.toString(input));
		
		int[] input2 = {23};
		insertionSort(input2);
		System.out.println(Arrays.toString(input2));
		
		
		int[] input3 = {23, 23, 23,23};
		insertionSort(input3);
		System.out.println(Arrays.toString(input3));
	}

	public static void insertionSort(int[] input) {
		for (int i = 1, j; i < input.length; i ++) {
			int x = input[i];
			
			for (j = i - 1; j >= 0 && input[j] > x; j --) {
				input[j + 1] = input[j];
			}
			input[j + 1] = x;
		}
	}
}
