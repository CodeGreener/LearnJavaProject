package com.jj.learn;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. 
 */
public class SortANearlySortedArray {

	public static <T> void sortArray(T[] data, int k) {
		PriorityQueue<T> q = new PriorityQueue<>();
		
		for (int i = 0; i < k + 1; i ++) {					//k+1
			q.offer(data[i]);
		}
		
		ArrayList<T> result = new ArrayList<>();
		
		for (int i = k + 1; i < data.length; i ++) {		// n-k-1
			result.add(q.poll());							// log(k)
			q.offer(data[i]);
		}
		
		while (!q.isEmpty()) {								//k
			result.add(q.poll());
		}
		System.out.println(result); 
	}
	
	public static void main(String[] args) {
		int k = 3;
	    Integer data[] = {2, 6, 3, 12, 56, 8};
		SortANearlySortedArray.sortArray(data, k);
	}
}
