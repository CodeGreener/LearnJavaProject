package com.jj.learn.leetcode;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTwoIntegersLeetCode29Test {

	private static DivideTwoIntegersLeetCode29 inst = null;
	@BeforeAll
	public static void setUp() throws Exception {
		inst = new DivideTwoIntegersLeetCode29();
	}

	@Test
	public void test1() {
		int result = inst.divide(-1, 1);
		assertEquals(-1, result);
	}

	
	@Test
	public void test2() {
		int result = inst.divide(10, 10);
		assertEquals(1, result);
	}

	@Test
	public void test3() {
		int result = inst.divide(5, 10);
		assertEquals(0, result);
	}
	
	@Test
	public void test4() {
		int result = inst.divide(-10, 3);
		assertEquals(-3, result);
	}
	
	@Test
	public void test5() {
		int result = inst.divide(-Integer.MIN_VALUE, -1);
		//overflows
		assertEquals(Integer.MAX_VALUE, result);
	}
	
	@Test
	public void test6() {
		int result = inst.divide(-2147483648, 1);
		assertEquals(-2147483648, result);
	}
	
	@Test
	public void test7() {
		int result = inst.divide(-Integer.MIN_VALUE, 2);
		assertEquals(-1073741824, result);
	}
	
	@Test
	public void test8() {
		int result = inst.divide(-Integer.MIN_VALUE, -3);
		//overflows
		assertEquals(715827882, result);
	}

	@Test
    public void test9() {

    }
}
