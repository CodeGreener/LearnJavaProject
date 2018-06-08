package com.jj.learn;

import java.util.HashMap;

public class SubsetDP {

	public static void main(String[] args) {
		int[] data = {1,2,3, 4};
		System.out.println(findSub(data, 6));
		
		int[] data2 = {2, 4, 6, 10};
		System.out.println(findSub(data2, 16));
	}
	public static int findSub(int[] data, int sum) {
		HashMap<String, Integer> cache = new HashMap<>();
		
		return findSubR2(data, 0, data.length - 1, sum, cache);
	}
	
	public static int findSubR(int[] data, int from, int to, int sum, HashMap<String, Integer> cache) {
		if (sum == 0) {
			return 1;
		} else if (sum < 0) {
			return 0;
		}
		
		if (from > to) {
			return 0;
		}
		/*
		if (data[to] == sum) {
			return 1 + findSubR(data, from, to - 1, sum, cache);
		}
		*/
		if (cache.containsKey(sum + ":" + to)) {
			return cache.get(sum + ":" + to);
		}
		
		if (data[to] > sum) {
			int count =  findSubR(data, from, to - 1, sum, cache);
			cache.put(sum + ":" + to, count);
			return count;
		} else {
			int one = findSubR(data, from, to - 1, sum, cache);
			int two = findSubR(data, from, to - 1, sum - data[to], cache);
			cache.put(sum + ":" + to, one + two);
			return one + two;
		}
	}
	
	public static int findSubR2(int[] data, int from, int to, int sum, HashMap<String, Integer> cache) {
		if (sum < 0) {
			return 0;
		}
		else if (sum == 0) {
			return 1;
		}
		else if (from > to) {
			return 0;
		}
		
		String cacheKey = to + ":" + sum;
		if (cache.containsKey(cacheKey)) {
			return cache.get(cacheKey);
		}
		
		int toReturn = 0;
		if (data[to] > sum) {
			toReturn = findSubR2(data, from, to - 1, sum, cache);
		} else {
			toReturn = findSubR2(data, from, to - 1, sum, cache) + findSubR2(data, from, to - 1, sum - data[to], cache);
		}
		cache.put(cacheKey, toReturn);
		
		return toReturn;
	}
}
