package com.jj.learn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Palindrome {

	/**
	 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	 * 
	 * @param sin
	 * @return
	 */
	static boolean isPalindrome(String sin) {
		String s = sin.toLowerCase().chars()
				.filter((c) -> Character.isAlphabetic(c) || Character.isDigit(c))
				.mapToObj(c -> new Integer(c))
				.map(i -> Character.toString((char)i.intValue()))
				.collect(Collectors.joining());
		
		int length = s.length();
		for (int i = 0; i < length /2; i ++) {
			if (s.charAt(i) != s.charAt(length - i - 1)) {
				return false;
			}
		}
		
		return true;
	}
	
	public List<List<Integer>> palindromePairs(String[] words) {
		
		int len = words.length;
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		for (int i = 0; i < len - 1; i ++) {
			for (int j = 0; j < len; j ++) {
				if (i == j) {
					continue;
				}
				if (isPalindrome(words[i] + words[j])) {
					List<Integer> ans = new LinkedList<>();
					ans.add(i);
					ans.add(j);
					result.add(ans);
				}
			}
		}
		return result;
        
    }
	
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		String s = "a";
		System.out.println(s + p.isPalindrome(s));
		
		
		
		String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
		
		System.out.println(p.palindromePairs(words));
	}
}
