package com.jj.learn.api;

import java.util.Arrays;

public class MergeSortTest {
	public static void main(String[] args) {
		//int[] test = {1,2,3,4};
		//change(test);
		//System.out.println(Arrays.toString(test));

		int[] input = {23, 12, 56, 45, 97, 2, 56, 99, 24, 125, 99, 4, 7, 87};
		
		System.out.println("bottom up");
		int[] output = mergeSortBottomUp(input);
		System.out.println(Arrays.toString(output));
		
		System.out.println("top down");
		output = mergeSortTopDown(input);
		System.out.println(Arrays.toString(output));
		
		System.out.println("top down 2");
		output = mergeSortTopDown2(input);
		System.out.println(Arrays.toString(output));
		
		int[] input2 = {23};
		int[] output2 = mergeSortBottomUp(input2);
		System.out.println(Arrays.toString(output2));
		
		
		int[] input3 = {23, 23, 23,23};
		int[] output3 = mergeSortBottomUp(input3);
		System.out.println(Arrays.toString(output3));
	}
	
	public static void change(int[] input) {
		int[] that = {2,3,1,4};
		input = that;
	}
	public static int[] mergeSortBottomUp(int[] input) {
		
		int listSize = 1;
		
		while (listSize < input.length) {
			int i1 = 0;
			int i2 = listSize;
			int end = 0;
			int[] output = new int[input.length];
			while (end < input.length) {
				end = Math.min(input.length, i2 + listSize);
				merge(input, i1, i2, end, output);
				i1 = end;
				i2 = i1 + listSize;
			}
			
			input = output;
			listSize *= 2;
		}
		
		return input;
	}
	
	public static int[] mergeSortTopDown(int[] input) {
		int[] copy = Arrays.copyOfRange(input, 0, input.length);
		mergeSortTopDownHelper(copy, 0, input.length, input);
		return input;
	}
	/**
	 * Sorted list will be in original.  Use work array to avoid copying data repeatedly.
	 * 
	 * @param work
	 * @param begin
	 * @param end
	 * @param original
	 */
	public static void mergeSortTopDownHelper(int[] work, int begin, int end, int[] original) {
		if (end - begin <= 1) {
			return;
		}
		
		int mid = begin + (end - begin) / 2;
		
		mergeSortTopDownHelper(original, 0, mid, work);
		mergeSortTopDownHelper(original, mid, end, work);
		
		merge(work, 0, mid, end, original);
		return;
	}
	
	public static int[] mergeSortTopDown2(int[] input) {
		if (input.length <= 1) {
			return input;
		}
		
		int mid = input.length / 2;
		
		int[] left = Arrays.copyOfRange(input,  0, mid);
		int[] right = Arrays.copyOfRange(input, mid, input.length);
		int[] leftSorted = mergeSortTopDown2(left);
		int[] rightSorted = mergeSortTopDown2(right);
		
		return merge(leftSorted, rightSorted);
	}
	
	private static int[] merge(int[] left, int[] right) {
		int[] output = new int[left.length + right.length];
		int lIndex = 0, rIndex = 0;
		
		for (int index = 0; index < output.length; index ++) {
			if (lIndex < left.length && (rIndex >= right.length || left[lIndex] <= right[rIndex])) {
				output[index] = left[lIndex];
				lIndex ++;
			} else {
				output[index] = right[rIndex];
				rIndex ++;
			}
		}
		
		return output;
	}
	/**
	 * Merge two sorted sublist (in input) into one longer sorted list (in output).
	 * 
	 * @param input
	 * @param lStart
	 * @param rStart
	 * @param end
	 * @param output
	 */
	private static void merge(int[] input, int lStart, int rStart, int end, int[] output) {
		int left = lStart, right = rStart;
		for (int k = lStart; k < end; k ++) {
			if (left < rStart && (right >= end ||input[left] <= input[right])) {
				output[k] = input[left];
				left ++;
			}
			else {
				output[k] = input[right];
				right ++;
			}
		}
		
	}
}
