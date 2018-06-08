package com.jj.learn.api;

public class BoyerMooreTest {

	public static void main(String[] args) {
		String text = "klsjktestljdauioxklcjkJABCtestabc4rihvtestab";
		String pattern = "testabc";
		
		System.out.println(indexOf(text.toCharArray(), pattern.toCharArray()));
	}
	
	 public static int indexOf(char[] haystack, char[] needle) {
	        if (needle.length == 0) {
	            return 0;
	        }
	        int charTable[] = makeCharTable(needle);
	        //int offsetTable[] = makeOffsetTable(needle);
	        for (int i = needle.length - 1, j; i < haystack.length;) {
	            for (j = needle.length - 1; needle[j] == haystack[i]; --i, --j) {
	                if (j == 0) {
	                    return i;
	                }
	            }
	            //i += needle.length - j; // For naive method; moving one position passed the previous starting point
	            i += charTable[haystack[i]];
	             System.out.println(i);
	        }
	        return -1;
	    }
	 
	 /**
	     * Makes the jump table based on the mismatched character information.
	     */
	    private static int[] makeCharTable(char[] needle) {
	        final int ALPHABET_SIZE = Character.MAX_VALUE + 1; // 65536
	        int[] table = new int[ALPHABET_SIZE];
	        for (int i = 0; i < table.length; ++i) {
	            table[i] = needle.length;
	        }
	        for (int i = 0; i < needle.length - 1; ++i) {
	            table[needle[i]] = needle.length - 1 - i;	//this points to where the pattern's end should be aligned with
	        }
	        return table;
	    }
}
