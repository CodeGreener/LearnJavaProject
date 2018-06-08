package com.jj.learn.leetcode;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * leetcode 312
 * 
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
 * You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note:
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * Example:
 * 
 * Given [3, 1, 5, 8]
 * 
 * Return 167
 * 
 *  nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *  coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *  
 * @author che
 *
 */
public class BurstBalloonsLeetCode312 {

	
	public int maxCoins(int[] nums) {
		int n = nums.length;
		int[] newnums = new int[n + 2];
		newnums[0] = 1;
		newnums[n + 1] = 1;
		for (int i = 0; i < n; i++) {
			newnums[i + 1] = nums[i];
		}
		int[][] C = new int[n + 1][n + 1];
		return helper(newnums, C, 1, n);
	}

	int helper(int[] nums, int[][] C, int s, int e) {
		if (s > e)
			return 0;
		if (C[s][e] > 0) {
			return C[s][e];
		}
		for (int i = s; i <= e; i++) {
			//try popping i-th balloon last: so we pop everything to the left of i, and everything
			//to the right of i, then i-th.
			
			int v = nums[s - 1] * nums[i] * nums[e + 1]
					+ helper(nums, C, s, i - 1) + helper(nums, C, i + 1, e);
			C[s][e] = Math.max(C[s][e], v);
		}
		return C[s][e];
	}

	//=========================================================================
	
	public int maxCoins_slow(int[] nums) {
		 
		 HashMap<Integer, Integer> cache = new HashMap<>();
		 
		 int myMaxCoins = this.myCoins(nums, cache);
		 return myMaxCoins;
	    
	 }
	 	 
	//this method is slow because when we try to pop i-th bolloon, it recurses to the rest of
	//all balloons, so the list is cut down only by 1 element. So the potential depth of the stack
	//could be as long as the list of balloons.  While the method above divides the list into two sublists.
	//
	private int myCoins(int[] coinNums, HashMap<Integer, Integer> cache) {
		 switch (coinNums.length) {
		 case 0: return 0;
		 case 1:
			 return coinNums[0];
		 case 2:
			 Integer key = Arrays.toString(coinNums).hashCode();
			 if (cache.containsKey(key)) {
				 return cache.get(key);
			 }
			 else {
				 int wayOne = coinNums[0] * coinNums[1] + coinNums[0];
				 int wayTwo = coinNums[0] * coinNums[1] + coinNums[1];
				 int coins = wayOne > wayTwo? wayOne : wayTwo;
				 cache.put(key, coins);
				 //System.out.println(Arrays.toString(coinNums) + " coins " + coins);
				 return coins;
			 }
		 }
		 
		 
		 int thisMax = 0;
		 
		 	 
		 for (int i = 0; i < coinNums.length; i ++) {
			 //pop i-th ballon
			 Integer key = (i + Arrays.toString(coinNums)).hashCode();
			 if (!cache.containsKey(key)) {
				 ResultC r = popBallon(coinNums, i);
					
				 
				 int rest = 0;
				 Integer restkey = (Arrays.toString(r.balloons)).hashCode();
				 if (cache.containsKey(restkey)) {
					 //System.out.println("find max " + Arrays.toString(r.balloons));
					 rest = cache.get(restkey);
				 } 
				 else {
					 rest = this.myCoins(r.balloons, cache);
					 cache.put(restkey, rest);
				 }
				 
				 int coins = r.coins + rest;
				 //System.out.println("***coins " + coins);
				 
				 if (coins > thisMax) {
					 thisMax = coins;
					 cache.put(key, coins);
					 
					 //System.out.println(" max coins " + thisMax);
				 }
			 } else {
				 int coins = cache.get(key);
				 //System.out.println("found " + i + Arrays.toString(coinNums));
				 if (coins > thisMax) {
					 thisMax = coins;
					 //cache.put(key, coins);
					 //System.out.println(" reuse max coins " + thisMax);
				 }
			 }
			 
		 }
		 
		return thisMax;
	 }
	 private ResultC popBallon(int[] nums, int i) {
		 int coins = (i > 0? nums[i-1] : 1) * nums[i] * (i < nums.length - 1? nums[i+1] : 1);
		 
		 int[] newNumbs = new int[nums.length - 1];
		 for (int j = 0; j < i; j ++) {
			 newNumbs[j] = nums[j];
		 }
		 for (int j = i+1; j < nums.length; j ++) {
			 newNumbs[j - 1] = nums[j];
		 }
		 //System.out.println("pop " + i + " " + Arrays.toString(nums) + " coins " + coins + " " + Arrays.toString(newNumbs));
		 ResultC r = new ResultC();
		 r.coins = coins;
		 r.balloons = newNumbs;
		 return r;
	 }
	 private class ResultC {
		 private int coins = 0;
		 private int[] balloons = null;
	 }
}
