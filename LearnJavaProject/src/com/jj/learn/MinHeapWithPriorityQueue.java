package com.jj.learn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeapWithPriorityQueue<T> {

	private PriorityQueue q = null;
	
	public <T> MinHeapWithPriorityQueue(T[] data, Comparator<T> c) {
		q = new PriorityQueue(c);
		
		for (T t : data) {
			q.add(t);
		}
	}
	
	public <T> void add(T o) {
		q.add(o);
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[100];
		
		MinHeapWithPriorityQueue<Integer> h = new MinHeapWithPriorityQueue<>(a, (x, y) -> x - y);
		
		
	}
}
