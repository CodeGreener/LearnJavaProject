package com.jj.learn.leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordSearchLeetCode79Test {

	private WordSearchLeetCode79 inst = null;
	@Before
	public void setUp() throws Exception {
		inst = new WordSearchLeetCode79();
	}

	@Test
	public void test() {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word = "ABCCED";
		boolean found = inst.exist(board, word);
		assertEquals(true, found);
		
		word = "SEE";
		found = inst.exist(board, word);
		assertEquals(true, found);
		
		word = "ABCB";
		found = inst.exist(board, word);
		assertEquals(false, found);
	}

	@Test
	public void test1() {
		char[][] board = {
				{'a', 'a'}
		};
		String word = "";
		boolean found = inst.exist(board, word);
		assertEquals(true, found);
		
		word = "G";
		found = inst.exist(board, word);
		assertEquals(false, found);
		
		word = "aaa";
		found = inst.exist(board, word);
		assertEquals(false, found);
	}
	
	@Test
	public void test2() {
		char[][] board = {
				{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}
		};
		//String word = "ABCESEEEFS";
		String word = "ABCESEEE";
		boolean found = inst.exist(board, word);
		assertEquals(true, found);
	}
}
