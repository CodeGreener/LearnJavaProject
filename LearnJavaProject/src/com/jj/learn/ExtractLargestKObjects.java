package com.jj.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ExtractLargestKObjects {

	public static <T extends Comparable<T>> List<T> kLargest(T[] data, int k) {
		if (k >= data.length) {
			return Arrays.stream(data).collect(Collectors.toList());
		}
		
		PriorityQueue<T> q = new PriorityQueue<>((x, y) -> y.compareTo(x));
		
		for (T t : data) {
			q.add(t);
		}
		
		ArrayList<T> result = new ArrayList<T>();
		
		for (int i = 0; i < k; i ++) {
			result.add(q.poll());
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		Integer[] data = new Integer[22];
		for (int i = 0; i < data.length; i ++) {
			data[i] = (int)(Math.random() * 200);
		}
		List<Integer> result = ExtractLargestKObjects.kLargest(data, 7);
		
		System.out.println(Arrays.toString(data));
		System.out.println(result);
		
		data = new Integer[14];
		for (int i = 0; i < data.length; i ++) {
			data[i] = (int)(Math.random() * 200);
		}
		result = ExtractLargestKObjects.kLargest(data, 30);
		
		System.out.println(Arrays.toString(data));
		System.out.println(result);
		
		data = new Integer[14];
		for (int i = 0; i < data.length; i ++) {
			data[i] = (int)(Math.random() * 200);
		}
		result = ExtractLargestKObjects.kLargest(data, 0);
		
		System.out.println(Arrays.toString(data));
		System.out.println(result);
		
		data = new Integer[0];
		for (int i = 0; i < data.length; i ++) {
			data[i] = (int)(Math.random() * 200);
		}
		result = ExtractLargestKObjects.kLargest(data, 30);
		
		System.out.println(Arrays.toString(data));
		System.out.println(result);
	}
}
