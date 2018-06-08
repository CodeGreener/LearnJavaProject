package com.jj.learn;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(5, 2));
		
		
		System.out.println(p.getPermutation(8, 1));
		System.out.println(p.getPermutation(9, 26));
		System.out.println(p.getPermutation(4, 16));
	}
	
	 public String getPermutation(int n, int k) {
		 int max = this.factorial(n);
		 if (k > max) {
			 return "";
		 }
		 
		 
		 String result = "";
		 int count = n;
		 List<Integer> digits = new ArrayList<>();
		 for (int i = 0; i <= n; i ++) {
			 digits.add(i);
		 }
		 for (int i = 1; i < count; i ++) {
			float groupSize = factorial(n-1); 
	        int group = (int)Math.ceil(k / groupSize);
	        k = k - (group -1) * (int)groupSize;
	        
	        int firstDigit = digits.get(group);
	        digits.remove(group);
	        
	        result += firstDigit;
	        n --;
	    }
		 
		 //add last digit
		 result += digits.get(1);
		 return result;
	 }
	 
	 public int factorial(int n) {
		 int result = 1;
		 for (int i = 2; i <= n; i ++) {
			 result *= i;
		 }
		 return result;
	 }
}
