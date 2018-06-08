package com.jj.learn;

import java.util.LinkedList;
import java.util.List;

public class MergeSort {

	
	/**
	 * Merge two already sorted sublists into one.
	 * 
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public <T extends Comparable<T>> List<T> mergeSortedLists(List<T> a, List<T> b) {
		
		List<T> result = new LinkedList<>();
		
		int indexA = 0;
		int indexB = 0;
		
		while (indexA < a.size() && indexB < b.size()) {
			T item1 = a.get(indexA);
			T item2 = b.get(indexB);
			
			if (item1.compareTo(item2) <= 0) {
				result.add(item1);
				indexA ++;
			}
			else {
				result.add(item2);
				indexB ++;
			}
		}
		
		//deal with left overs
		if (indexA < a.size()) {
			for (int i = indexA; i < a.size(); i ++) {
				result.add(a.get(i));
			}
		}
		
		if (indexB < b.size()) {
			for (int i = indexB; i < b.size(); i ++) {
				result.add(b.get(i));
			}
		}
		
		return result;
		
	}
}
