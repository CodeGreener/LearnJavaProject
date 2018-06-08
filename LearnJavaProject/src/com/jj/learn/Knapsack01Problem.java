package com.jj.learn;

import java.util.ArrayList;
import java.util.HashMap;

public class Knapsack01Problem {

	/**
	 * return list of item indexes to put in a knapsack given
	 * max weight knapsack can hold, so that the total values in the knapsack
	 * is maximized.
	 * 
	 * @param itemWeights
	 * @param itemValues
	 * @param maxWeight
	 * @return
	 */
	
	/*
	public int[] knapsackSolution(int[] itemWeights, int[] itemValues, int maxWeight) {
		ArrayList<Integer> result = new ArrayList<>();
		
		int value = this.knapsackSolutionHelper(itemWeights, itemValues, maxWeight, itemWeights.length - 1, result, null);
		
		int[] array = new int[result.size()];
		for (int i = 0; i < array.length; i ++) {
			array[i] = result.get(i);
		}
		return array;
		//return value;
	}
	*/
	/**
	 * As I am returning the list of items to put in knapsack to achieve the most value, the cache 
	 * needs to save this list, which may turn out consuming lots of memory. So this is actually not
	 * working well.  In case we just need to figure the max value, then cache is good.
	 * 
	 * @param itemWeights
	 * @param itemValues
	 * @param maxWeight
	 * @return
	 */
	public int[] knapsackSolution(int[] itemWeights, int[] itemValues, int maxWeight) {
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<String, PartialKnapSack> cache = new HashMap<>();
		
		int value = this.knapsackSolutionHelper(itemWeights, itemValues, maxWeight, itemWeights.length - 1, result, cache);
		
		int[] array = new int[result.size()];
		for (int i = 0; i < array.length; i ++) {
			array[i] = result.get(i);
		}
		return array;
		//return value;
	}
	
	public int knapsackSolutionValue(int[] itemWeights, int[] itemValues, int maxWeight) {
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<String, PartialKnapSack> cache = new HashMap<>();
		
		int value = this.knapsackSolutionHelper(itemWeights, itemValues, maxWeight, itemWeights.length - 1, result, cache);
		
		int[] array = new int[result.size()];
		for (int i = 0; i < array.length; i ++) {
			array[i] = result.get(i);
		}
		return value;
		//return value;
	}
	
	/**
	 * 
	 * @param itemWeights
	 * @param itemValues
	 * @param maxWeight - knapsack capacity
	 * @param start - index of item being considered
	 * @param indexesInKnapsack - indexes of items included in knapsack
	 * @return value of items in knapsack
	 */
	private int knapsackSolutionHelper(int[] itemWeights, int[] itemValues, int maxWeight, int start, ArrayList<Integer> indexesInKnapsack, HashMap<String, PartialKnapSack> cache) {
		if (maxWeight == 0) {
			return 0;
		}
		if (start < 0) {
			return 0;
		}
		String key = maxWeight + ":" + start;
		if (cache.containsKey(key)) {
			System.out.println(key);
			return cache.get(key).value;
		}
		
		
		ArrayList<Integer> included = new ArrayList<>();
		//ArrayList<Integer> notIncluded = new ArrayList<>();
		
		int value;
		
		if (itemWeights[start] > maxWeight) {
			value = this.knapsackSolutionHelper(itemWeights, itemValues, maxWeight , start - 1, included, cache);
		} else {
			int value1 = this.knapsackSolutionHelper(itemWeights, itemValues, maxWeight - itemWeights[start], start - 1, included, cache) + itemValues[start];
			int value2 = this.knapsackSolutionHelper(itemWeights, itemValues, maxWeight, start - 1, included, cache);
			if (value1 > value2) {
				value = value1;
				included.add(start);
			}
			else {
				value = value2;
				
			}
		}
		
		PartialKnapSack s = new PartialKnapSack();
		s.value = value;
		s.itemIndexs = included;
		cache.put(key, s);
		
		return value;
		
		
	}
	
	class PartialKnapSack {
		ArrayList<Integer> itemIndexs = null;
		int value = 0;
	}
}
