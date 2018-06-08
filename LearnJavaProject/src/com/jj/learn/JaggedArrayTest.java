package com.jj.learn;

import java.util.Arrays;

/**
 * Multi dim array with different lengths.
 * 
 * @author che
 *
 */
public class JaggedArrayTest {

	public static void main(String[] args) {
		new JaggedArrayTest().method();
	}
	
	private void method() {
		int[][] a = new int[4][];
		a[0] = new int[6];
		a[1] = new int[3];
		a[2] = new int[5];
		a[3] = new int[10];
		
		System.out.println(Arrays.toString(a[0]));
	}
}
