package com.jj.learn.leetcode;

/**
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * 
 * 
 * @author che
 *
 */
public class DivideTwoIntegersLeetCode29 {

	 public int divide(int dividend, int divisor) {
	
		 if (divisor == 0) {
			 return Integer.MAX_VALUE;
		 }
		boolean negativeResult = false;

		if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
			negativeResult = true;
		}
		
		//use long to handle Integer.MIN_VALUE, which will overflow if taken its absolute value
		long adividend = (long) Math.abs((long)dividend);
		long adivisor = (long) Math.abs((long)divisor);
		
		
		if (adividend == 0 || adivisor > adividend) {
			return 0;
		}
	    
		if (adividend == adivisor) {
			
			return negativeResult? -1 : 1;
		}
		
		if (adivisor == 1) {
			if (adividend > Integer.MAX_VALUE && !negativeResult) {
				return Integer.MAX_VALUE;
			} else {
				return negativeResult ? (int) -adividend : (int) adividend;
			}

		}
		
		int result = 0;
		long tmpDividend = adividend;
		long tmpDivisor = adivisor;
		while (tmpDividend >= adivisor) {
			int count = 0;
			while (tmpDivisor <= tmpDividend) {
				tmpDivisor = tmpDivisor << 1;
				count ++;
			}
			count --;
			long subtract = tmpDivisor >> 1;
			tmpDividend = tmpDividend - subtract;
			
			int intermediateResult = 1 << count;
			result = result + intermediateResult;
			tmpDivisor = adivisor;
		}
		
		if (negativeResult) {
			return -result;
		} else {
			return result;
		}
		
	 }
}
