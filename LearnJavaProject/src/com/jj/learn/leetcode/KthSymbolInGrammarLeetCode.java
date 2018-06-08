package com.jj.learn.leetcode;


public class KthSymbolInGrammarLeetCode {
	

	public static void main(String[] args) {
		KthSymbolInGrammarLeetCode add = new KthSymbolInGrammarLeetCode();
		 
		//add.buildFirst6Rows();
		
		System.out.println(add.kthGrammar(30, 12342133));	//expected 1
		//System.out.println(add.kthGrammar(30, 12232345));
		//System.out.println(add.kthGrammar(2, 1));
		//System.out.println(add.kthGrammar(2, 2));
		//System.out.println(add.kthGrammar(4, 5));
		
		//System.out.println(add.kthGrammar(24, 5));
	}

	/**
	 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and 
	 * replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
	 * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
	 * 
	 * Note: the above operation is equivalent of appending the reverse of row i-1 to the end of row i-1 to get the value for row i.
	 * 
	 * Examples:
	 * Input: N = 1, K = 1
	 * Output: 0
	 * 
	 * Input: N = 2, K = 1
	 * Output: 0
	 * 
	 * Input: N = 2, K = 2
	 * Output: 1
	 * 
	 * Input: N = 4, K = 5
	 * Output: 1
	 * 
	 * Explanation:
	 * row 1: 0
	 * row 2: 01
	 * row 3: 0110
	 * row 4: 01101001
	 * 
	 * @param N
	 * @param K
	 * @return
	 */
	public int kthGrammar(int N, int K) {
		//row i has 2^(i-1) number of bits
		//To get to a K-th bit, we need to be at this row:
		int row = (int)(Math.ceil(Math.log(K) / Math.log(2) + 1));
		boolean reverse = false;
		
		
		//at row r, if the K-th bit is at the second half of the bit string, the K-th bit is 
		//the reverse of a corresponding bit at row r-1;
		//if the K-th bit is at the first half of the bit string, the K-th bit is the same as
		//the k-th bit in row r-1.
		while (row >= 2) {
			if (K <= Math.pow(2, row - 2)) {
				//K-th bit is at the first half of this row, which is the same as previous row
			}
			else {
				//K-th bit is at the second half of this row, so it is the reverse of corresponding value
				//in the previous row
				K = K - (int)Math.pow(2, row - 2);
				reverse = !reverse;
			}
			row --;
		}
	
		return reverse? 1 : 0;
		
		
	}
	
	//==============================
	//below preallocates memory and save all the row values
	//out of heap space when n > 25
	//===============================
	
	public int slowkthGrammar(int N, int K) {
        int[] matrix = new int[(int)Math.pow(2, 30)];
        
        matrix[0] = this.buildFirst6Rows();
        //System.out.println(Integer.toBinaryString(matrix[0]));
        
		int row = 7;
		int numberOfBitsBuilt = (int)Math.pow(2, 5);
		int matrixEnd = 0;	//last entry in matrix, currently 0 as there is only one entry in it.
		
		while (numberOfBitsBuilt < K && row <= N) {
			
			int maxIntToProcess = matrixEnd;
			for (int i = 0; i <= maxIntToProcess; i ++) {
				int bits = matrix[i];
				bits = reverse(bits);
				matrix[maxIntToProcess + i + 1] = bits;
				numberOfBitsBuilt += 32;
				matrixEnd ++;
			}
			
			
			row ++;
		}
		
		int atIndex = this.arrayIndexFor(K);
		int bits = matrix[atIndex];
		
		int bitMask = 1;
		bitMask = bitMask << (K - 1 - atIndex *32);
		int result = bits & bitMask;
		
		if (result == 0) {
			return 0;
		} else {
			return 1;
		}
    }
	
	private int buildFirst6Rows() {
		int result = 0;  	//32 bits
		for (int i = 2; i <= 6; i ++) {
			int numberOfBits = (int)Math.pow(2, i-2);
			int mask = 0;
			mask = ~mask << (32 - numberOfBits) >>> (32-numberOfBits);
			
			//System.out.println("mask for row " + i + " " + Integer.toBinaryString(mask));
			
			int bits = ~result & mask;
			//System.out.println("bits for row " + i + " " + Integer.toBinaryString(bits));
			bits = bits << numberOfBits;
			result = result | bits;
			//System.out.println("row " + i + " " + Integer.toBinaryString(result));
		}
		
		return result;
	}
	
	//k starts at 1
	private int arrayIndexFor(int k) {
		return (int)Math.floor((k - 1) / 32);
	}
	private int reverse(int i) {
		return ~i;
	}
	
}
