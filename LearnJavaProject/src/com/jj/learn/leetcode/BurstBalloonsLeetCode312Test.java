package com.jj.learn.leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BurstBalloonsLeetCode312Test {

	private BurstBalloonsLeetCode312 inst = null;
	
	@Before
	public void setUp() throws Exception {
		inst = new BurstBalloonsLeetCode312();
	}

	@Test
	public void test() {
		int[] nums = {3,1,5,8};
		
		int coins = inst.maxCoins(nums);
		
		assertEquals(167, coins);
	}

	@Test
	public void test1() {
		int[] nums = {9};
		
		int coins = inst.maxCoins(nums);
		
		assertEquals(9, coins);
	}

	@Test
	public void test2() {
		int[] nums = {35,16,83,87,84,59,48,41};
		
		int coins = inst.maxCoins(nums);
		
		assertEquals(1583373, coins);
	}

	@Test
	public void test3() {
		int[] nums = {7,9,8,0,7,1,3,5,5,2,3};
		
		int coins = inst.maxCoins(nums);
		
		assertEquals(1654, coins);
	}
	
	@Test
	public void test4() {
		int[] nums = {2,4,8,4,0,7,8,9,1,2,4,7,1,7,3};
		
		int coins = inst.maxCoins(nums);
		
		assertEquals(2925, coins);
	}
	
	@Test
	public void test5() {
		int[] nums = {2,4,8,4,0,7,8,9,1,2,4,7,1,7,3,6};
		
		int coins = inst.maxCoins(nums);
		
		assertEquals(3304, coins);
	}
}
