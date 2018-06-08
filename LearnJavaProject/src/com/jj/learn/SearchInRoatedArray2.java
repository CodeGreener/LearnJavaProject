package com.jj.learn;

import java.util.Arrays;

public class SearchInRoatedArray2 {

	public static void main(String[] args) {
		SearchInRoatedArray2 s = new SearchInRoatedArray2();
		
		int[] a = {4,5,6,7,0,1,2,3};
		System.out.println(s.search(a, 3));
		
		int[] b = {1};
		System.out.println(s.search(b, 2));
		
		int[] c = {100, 101, 102, 103, 104, 105, 106, 110, 120, 132, 134, 144, 145, 146, 167, 168, 0,1,2,3, 4,5,6,7, 12, 14, 56, 57, 67, 77, 79};
		System.out.println(s.search(c, 14));
		System.out.println(s.search(c, 79));
		System.out.println(s.search(c, 111));
		System.out.println(s.search(c, 0));
		
		int[] d = {1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18};
		System.out.println(s.search(d, 2));
		
		//int[] e = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int[] e = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(s.search(e, 2));
	}
	
	public boolean search(int[] nums, int target) {
		return this.fastsearch(nums, target);
	}
	 
	 public boolean slowsearch(int[] nums, int target) {
		 for (int i = 0; i < nums.length; i ++) {
			 if (nums[i] == target) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 
	 public boolean fastsearch(int[] nums, int target) {
		 if (nums.length == 0) {
			 return false;
		 }
	       
		 if (nums.length < 10) {
			 return slowsearch(nums, target);
		 }
		 
		 int mid = nums.length / 2;
		 
		 if (nums[mid] == target) {
			 return true;
		 }
		 if (nums[mid] > nums[nums.length - 1]) {
			 //mid is to the left of break point
			 if (target <= nums[mid] && target >= nums[0]) {
				 int[] newNums = Arrays.copyOfRange(nums, 0, mid - 1);
				 return fastsearch(newNums, target);
			 } else {
				 int[] newNums = Arrays.copyOfRange(nums, mid + 1, nums.length);
				 return fastsearch(newNums, target);
			 }
		 } 
		 else if (nums[mid] == nums[nums.length - 1]) {
			 int[] newNums = Arrays.copyOfRange(nums, mid + 1, nums.length);
			 if (fastsearch(newNums, target)) {
				 return true;
			 } else {
				 int[] nNums = Arrays.copyOfRange(nums, 0, mid);
				 return fastsearch(nNums, target);
			 }
		 }
		 else {
			 //mid is to the right of break point
			 if (target > nums[mid] && target < nums[nums.length - 1]) {
				 int[] newNums = Arrays.copyOfRange(nums, mid + 1, nums.length);
				 return fastsearch(newNums, target);
			 } else {
				 int[] newNums = Arrays.copyOfRange(nums, 0, mid);
				 return fastsearch(newNums, target);
			 }
		 }
		 
	 }
	 
	 
	 public boolean oldsearch(int[] nums, int target) {
		 if (nums.length == 0) {
			 return false;
		 }
	        int breakPoint = this.findBreakPoint(nums);
	        
	        if (target == nums[breakPoint]) {
	        	return true;
	        } else  {
	        	if (target <= nums[breakPoint] && target >= nums[0]) {
	        		//search left
		        	if (Arrays.binarySearch(nums, 0, breakPoint, target) >= 0) {
		        		return true;
		        	}
	        	}
	        	
	        	else {
		        	//search right
	        		int search = Arrays.binarySearch(nums, breakPoint + 1, nums.length, target);
		        	return search >= 0;
		        }
	        }
	        return false;
	 }
	 int findBreakPoint(int[] nums) {
		 for (int i = 0; i < nums.length - 1; i ++) {
			 if (nums[i] > nums[i + 1]) {
				 return i;
			 }
		 }
		 
		 return nums.length - 1;
	 }
	 
	
}
