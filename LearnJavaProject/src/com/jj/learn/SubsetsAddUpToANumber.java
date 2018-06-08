package com.jj.learn;

import java.util.ArrayList;

public class SubsetsAddUpToANumber {

	/**
	 * Given an array of integers, find all subsets whose numbers add up to aNumber.
	 * 
	 * Only positive numbers in array. No duplicates in array either.
	 * 
	 * When aNumber = 0, the answer is {}.
	 * 
	 * 
	 * 
	 * @param given_array
	 * @param aNumber
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> subsetAddUpTo(int[] given_array, int aNumber) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		this.findAllSubsets(given_array, aNumber, given_array.length - 1, result);
		
		return result;
	}
	/**
	 * 
	 * @param given_array
	 * @param aNumber
	 * @param start: index of element in array that we are trying to process
	 * @param result
	 */
	private void findAllSubsets(int[] given_array, int aNumber, int start, ArrayList<ArrayList<Integer>> result) {
		if (start < 0) {
			return;
		}
		
		if (given_array[start] > aNumber) {
			this.findAllSubsets(given_array, aNumber, start - 1, result);
			return;
		}
		
		//find all subsets that includes the number at start position
		if (given_array[start] == aNumber) {
			ArrayList<Integer> t = new ArrayList<>();
			t.add(given_array[start]);
			result.add(t);
			
			this.findAllSubsets(given_array, aNumber, start - 1, result);
			return;
		}
		
		ArrayList<ArrayList<Integer>> newResult = new ArrayList<>();
		this.findAllSubsets(given_array, aNumber - given_array[start], start - 1, newResult);
		for (ArrayList<Integer> oneSet : newResult) {
			oneSet.add(given_array[start]);
			result.add(oneSet);
		}
		//done finding all subsets that include the number at start position
		
		//now try to find all subsets for numbers before start position
		this.findAllSubsets(given_array, aNumber, start - 1, result);
	}
}
