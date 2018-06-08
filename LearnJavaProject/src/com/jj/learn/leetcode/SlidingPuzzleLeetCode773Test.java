package com.jj.learn.leetcode;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Timer;

import org.junit.Before;
import org.junit.Test;

public class SlidingPuzzleLeetCode773Test {

	private SlidingPuzzleLeetCode773 lc = null;
	
	@Before
	public void setUp() throws Exception {
		lc = new SlidingPuzzleLeetCode773();
	}

	@Test
	public void test0() {
		int[][] b1 = {{1,2,3},{4,5,0}};
		int moves = lc.slidingPuzzle(b1);
		
		assertEquals(0, moves);
	}

	@Test
	public void test1() {
		int[][] b1 = {{1,2,3},{0, 4, 5}};
		int moves = lc.slidingPuzzle(b1);
		
		assertEquals(2, moves);
	}

	@Test
	public void test2() {
		int[][] b3 = {{4,1,2},{5,0,3}};
		int moves = lc.slidingPuzzle(b3);
		assertEquals(5, moves);
	}
	@Test
	public void test3() {
		
		int[][] b2 = {{1,2,3},{4,0,5}};
		int moves = lc.slidingPuzzle(b2);
		assertEquals(1, moves);
	}
	@Test
	public void test4() {
		
		int[][] b2 = {{3,2,4},{1,5,0}};
		int moves = lc.slidingPuzzle(b2);
		assertEquals(14, moves);
	}
	
	@Test
	public void test5() {
		//no route to goal
		int[][] b2 = {{1,2,3},{5,4,0}};
		int moves = lc.slidingPuzzle(b2);
		assertEquals(-1, moves);
	}
	
	@Test
	public void test6() {
		//no route to goal
		Date start = new Date();
		int[][] b2 = {{3,1,0},{2,4,5}};
		int moves = lc.slidingPuzzle(b2);
		Date end = new Date();
		assertEquals(13, moves);
		System.out.println("time " + (end.getTime() - start.getTime()));
	}
	
	@Test
	public void test7() {
		//no route to goal
		Date start = new Date();
		int[][] b2 = {{1,3,4},{0,2,5}};
		int moves = lc.slidingPuzzle(b2);
		Date end = new Date();
		assertEquals(14, moves);
		System.out.println("time " + (end.getTime() - start.getTime()));
	}
}
