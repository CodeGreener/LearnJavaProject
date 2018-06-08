package com.jj.learn.api;

import java.util.Arrays;

public class HeapSortTest {

	private int[] items = new int[10];
	private int size = 0;
	
	public static void main(String[] args) {
		int[] input = {23, 12, 56, 45, 97, 2, 56, 99, 24, 125, 99, 4, 7, 87};
		
		System.out.println("Input:\n" + Arrays.toString(input));
		int[] output = new HeapSortTest().heapSort(input);
		System.out.println("Output:\n" + Arrays.toString(output));
	}
	
	
	public int[] heapSort(int[] input) {
		int[] result = new int[input.length];
		
		//build min heap
		heapify(input);
		
		int index = 0;
		while (!isEmpty()) {
			result[index] = poll();
			index ++;
		}
		
		return result;
	}
	
	private boolean isEmpty() {
		return size == 0;
	}
	/**
	 * Remove root node from heap and rebuild heap
	 * 
	 * @return
	 */
	private int poll() {
		if (size == 0) throw new IllegalStateException();
		
		int result = items[0];
		items[0] = items[size - 1];
		size --;
		siftDown();
		
		return result;
	}
	/**
	 * Min heap.
	 * 
	 * @param input
	 */
	public void heapify(int[] input) {
		size = 0;
		for (int i = 0; i < input.length; i ++) {
			add(input[i]);
		}
	}
	
	
	public void add(int item) {
		ensureCapacity();
		items[size] = item;
		size ++;
		siftUp();
	}
	
	public int peek() {
		if (size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	private void ensureCapacity() {
		if (size == items.length) {
			//increase array size
			int newSize = size * 2;
			int[] newArray = Arrays.copyOfRange(items, 0, newSize);
			
			items = newArray;
		}
		
	}
	private void siftUp() {
		int index = size - 1;
		while (hasParent(index) && items[getParentIndex(index)] > items[index]) {
			swap( index, getParentIndex(index));
			
			index = getParentIndex(index);
		}
		
	}
	
	private void siftDown() {
		int index = 0;
		
		while (hasLeft(index)) {
			
			if (!hasRight(index) || items[getLeftChildIndex(index)] < items[getRightChildIndex(index)]) {
				if (items[getLeftChildIndex(index)] < items[index]) {
					swap(index, getLeftChildIndex(index));
					index = getLeftChildIndex(index);
				} else {
					return;
				}
			} else {
				if (items[getRightChildIndex(index)] < items[index]) {
					swap(index, getRightChildIndex(index));
					index = getRightChildIndex(index);
				} else {
					return;
				}
			}
		}
		
	}
	private void swap(int i1, int i2) {
		int temp = items[i1];
		items[i1] = items[i2];
		items[i2] = temp;
	}
	
	private static int getParentIndex(int i) {
		return (i - 1) / 2;
	}

	private boolean hasLeft(int index) {
		return index * 2 + 1 < size? true : false;
	}
	
	private boolean hasRight(int index) {
		return index * 2 + 2 < size? true : false;
	}
	
	private boolean hasParent(int index) {
		return index > 0;
	}
	private int getLeftChildIndex(int i) {
		return 2 * i + 1;
	}
	
	private int getRightChildIndex(int i) {
		return 2 * i + 2;
	}
}
