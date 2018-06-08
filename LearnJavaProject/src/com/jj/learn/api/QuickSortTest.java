package com.jj.learn.api;

import java.util.Arrays;

public class QuickSortTest {

	public static void main(String[] args) {
		int[] input = {23, 12, 56, 45, 97, 2, 56, 99, 24, 125, 99, 4, 7, 87};
		//int[] input = {23, 99, 4, 7, 87, 99};
		
		System.out.println("Input:\n" + Arrays.toString(input));
		new QuickSortTest().quickSort(input, 0, input.length - 1);
		System.out.println("Output:\n" + Arrays.toString(input));
	}
	
	/**
	 * 
	 * @param input
	 * @param lo
	 * @param hi  inclusive
	 */
	public void quickSort(int[] input, int lo, int hi) {
		if (lo < hi) {
			System.out.println(lo + ", " + hi);
			int pivot = pickPivotValue(input, lo, hi);
			
			int partition = partition2(input, lo, hi, pivot);
			System.out.println(partition);
			
			quickSort(input, lo, partition);
			quickSort(input, partition + 1, hi);
			
		}
		
	}
	
	private int pickPivotValue(int[] input, int lo, int hi) {
		return input[lo];
	}
	
	private int partition(int[] input, int lo, int hi, int pivot) {
		int left = lo - 1;
		int right = hi + 1;
		
		while (true) {
			do {
				left ++;
			} while (input[left] < pivot);
			
			do {
				right --;
			} while (input[right] > pivot) ;
			
			if (left >= right) {
				return right;
			}
			
			swap(input, left, right);
			System.out.println(Arrays.toString(input));
		}
	}
	
	private int partition2(int[] input, int lo, int hi, int pivot) {
		int left = lo;
		int right = hi;
		
		while (true) {
			while (input[left] < pivot) {
				left ++;
			} ;
			
			while (input[right] > pivot)  {
				right --;
			} ;
			
			if (left >= right) {
				return right;
			}
			
			swap(input, left, right);
			left ++;
			right --;
			System.out.println(Arrays.toString(input));
		}
	}
	
	private void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
