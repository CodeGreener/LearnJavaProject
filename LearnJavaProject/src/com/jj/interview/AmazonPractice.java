package com.jj.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AmazonPractice {

	/**
	 * 1) Run length encoding
	 * aaaaaabb -> a5b2
	 * aaaaabccc -> a5bc3
	 * 
	 * @param str
	 * @return encoded string
	 */
	public static String lengthEncodeing(String str) {
		int length = str.length();
		
		if (length > 0) {
			String encoded = "";
			char current = str.charAt(0);
			int count = 1;
			for (int i = 1; i < length; i ++) {
				if (str.charAt(i) == current) {
					count ++;
				} else {
					//write out encoded str
					encoded += String.valueOf(current) + count;
					
					count = 1;
					current = str.charAt(i);
				}
			}
			//write out last character
			if (count > 0) {
				encoded += String.valueOf(current) + count;
			}
			return encoded;
		} else {
			return "";
		}
		
		
	}
	
	/**
	 *  Linked List pair sum count
	 *  0 -> 2 -> 5 -> 7 -> 4 -> 6 -> 10 -> 20 -> -10 -> Null
	 *  Given Sum: 10
	 *  Output : 3
	 *  Explanation: (4, 6) (0, 10) (20, -10)
	 */
	public static int linkedListPairCount(List<Integer> data, int sum) {
		
		int pairCount = 0;
		
		for (int i = 0; i < data.size() - 1; i ++) {
			for (int j = i + 1; j < data.size(); j ++) {
				if (data.get(i) + data.get(j) == sum) {
					//found a pair
					pairCount ++;
					System.out.println("found " + data.get(i) + "," + data.get(j));
				}
			}
			
		}
		
		return pairCount;
	}
	
	
	public static boolean findPattern(String str, String pattern) {
		return str.matches(pattern);
	}
	/**
	 * Rotate Doubly Linked List by N time
	 * 
	 * @param list
	 */
	public static <T> ArrayDeque<T> rotate(ArrayDeque<T> list, int n) {
		for (int i = 0; i < n; i ++) {
			T item = list.removeFirst();
			list.addLast(item);
		}
		return list;
	}
	
	/**
	 * Given a list of words, find if any of the two words can be joined to form a palindrome.
	 * 
	 * @param args
	 */
	public static void findPalindrome(String[] strings) {
		int count = 0;
		for (int i = 0; i < strings.length - 1; i ++) {
			for (int j = 0; j < strings.length; j ++) {
				if (isAPalindrome(strings[i] + strings[j])) {
					count ++;
				}
			}
		}
		
		Predicate<String> isAPalindrome = (String s) -> {
			int length = s.length();
			for (int i = 0; i < length / 2; i ++)
				if (s.charAt(i) != s.charAt(length - i - 1)) {
					return false;
				}
			return true;
		};
		
		
		
	}
	public static boolean isAPalindrome(String s) {
		int length = s.length();
		for (int i = 0; i < length / 2; i ++) {
			if (s.charAt(i) != s.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}
	 
	public static void main(String[] args) {
		String p = "abcdcba";
		System.out.println(p + AmazonPractice.isAPalindrome(p));
		p = "aaaaaaaaaaaaaaaaa";
		System.out.println(p + AmazonPractice.isAPalindrome(p));
		p = "abcdefecba";
		System.out.println(p + AmazonPractice.isAPalindrome(p));
		p = "a";
		System.out.println(p + AmazonPractice.isAPalindrome(p));
		p = "abba";
		System.out.println(p + AmazonPractice.isAPalindrome(p));

		
		String a = "aaaaaaaaaabbcefff";
		System.out.println(AmazonPractice.lengthEncodeing(a));
		
		String b = "";
		System.out.println(AmazonPractice.lengthEncodeing(b));
		
		String c = "xxxxxxxxxxxxxxxxx";
		System.out.println(AmazonPractice.lengthEncodeing(c));
		
		String d = "a";
		System.out.println(AmazonPractice.lengthEncodeing(d));
		
		String e = "aa";
		System.out.println(AmazonPractice.lengthEncodeing(e));
		
		ArrayList<Integer> ints = new ArrayList<>();
		ints.add(0);
		ints.add(2);
		ints.add(5);
		ints.add(7);
		ints.add(4);
		ints.add(6);
		ints.add(10);
		ints.add(20);
		ints.add(-10);
		
		System.out.println(AmazonPractice.linkedListPairCount(ints, 10));
		
		System.out.println(AmazonPractice.findPattern("abcdefgabc", "(.*)abc(.*)"));
		
		System.out.println(AmazonPractice.findPattern("abcdefgabc", "(.*)abc(.*)bca"));
		
	}
}
