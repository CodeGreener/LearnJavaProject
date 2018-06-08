/**
 * 
 */
package com.jj.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Returns all subsets of a given array.  The input array contains unique integers
 * and can not be empty or null.
 * 
 * This obviously can be done recursively, or iteratively.
 * 
 * total number of entries in result is 2^n, as each number has the option of being in, or not in a subset.
 * 
 * @author che
 *
 */
public class AllSubsetsOfSet {

	//==================Recursion============================
	
	public void printAllSubsetsRecursively(int[] given_array) {
		Integer[] subset = new Integer[given_array.length];
		
		this.recursePrint(given_array, 0, subset);
		
		return;
	}
	
	public ArrayList<ArrayList<Integer>> getAllSubsetsRecursively(int[] given_array) {
		if (given_array.length > 15) {
			throw new IllegalArgumentException("input array size is too big");
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		this.getAllSubsetsRecursivelyHelper(given_array, 0, result);
		
		//add empty set which is a valid subset
		result.add(new ArrayList<Integer>());
		
		this.printSet(result);
		return result;
	}
	
	
	private void getAllSubsetsRecursivelyHelper(int[] given_array, int i, ArrayList<ArrayList<Integer>> subsets) {
		if (i == given_array.length) {
			return;
		}
		ArrayList<ArrayList<Integer>> updates = new ArrayList<>();
		
		 for (ArrayList<Integer> oneSet : subsets) {
			 ArrayList<Integer> newSet = new ArrayList<>();
			 for (Integer value : oneSet) {
				 newSet.add(new Integer(value));
			 }
			 newSet.add(given_array[i]);
			 updates.add(newSet);
		 }
		 subsets.addAll(updates);
		 ArrayList<Integer> t = new ArrayList<>();
		 t.add(given_array[i]);
		 subsets.add(t);
		 
		 //tail recursion
		 this.getAllSubsetsRecursivelyHelper(given_array, i+1, subsets);
		 
		 
		 return;
	}
	
	private void recursePrint(int[] given_array, int i, Integer[] subset) {
		if (i == given_array.length) {
			printArray(subset);
			//System.out.println(Arrays.toString(subset));
			return;
		}

		subset[i] = null;
		recursePrint(given_array, i+1, subset);
		
		subset[i] = given_array[i];
		recursePrint(given_array, i+1, subset);
		
		return;
		
	}
	
	//============================Iteration================================
	/**
	 * This will create space and cpu problems when given_array (n) is too big, as the size of 
	 * the result is 2^n.
	 * 
	 * @param given_array
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> getAllSubsetsIteratively(int[] given_array) {
		if (given_array.length > 15) {
			throw new IllegalArgumentException("input array size is too big");
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		for (Integer value : given_array) {
			
			//duplciate current result - need deep copy as array list is an object.
			
			ArrayList<ArrayList<Integer>> intermediate = new ArrayList<>();
			for (int i = 0; i < result.size(); i ++) {
				ArrayList<Integer> temp = new ArrayList<>();
				for (int j = 0; j < result.get(i).size(); j ++) {
					temp.add(new Integer(result.get(i).get(j)));
				}
				intermediate.add(temp);
			}
			
			//add new value to every subset we already have
			for (ArrayList<Integer> set : intermediate) {
				set.add(value);
			}
			result.addAll(intermediate);

			ArrayList<Integer> myself = new ArrayList<>();
			myself.add(value);
			result.add(myself);
		}
		
		//add empty subset
		result.add(new ArrayList<Integer>());
		
		printSet(result);
		return result;
	}

	
	//================================Utility================================
	
	private void printSet(List<ArrayList<Integer>> set) {
		
		for (ArrayList<Integer> value : set) {
			System.out.print("[");
			for (Integer i : value) {
				System.out.print(i + ", ");
			}
			System.out.println("]");
		}
	}
	
	private void printArray(Integer[] a) {
		System.out.print("[");
		for (Integer i : a) {
			if (i != null)
				System.out.print(i + ",");
		}
		System.out.println("]");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
