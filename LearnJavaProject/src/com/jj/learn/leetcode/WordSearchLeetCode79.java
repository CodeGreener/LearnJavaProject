package com.jj.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * For example,
 * 
 * Given board =
 * [
 *    ['A','B','C','E'],
 *    ['S','F','C','S'],
 *    ['A','D','E','E']
 * ]
 * 
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * @author che
 *
 */
public class WordSearchLeetCode79 {
	public boolean exist(char[][] board, String word) {
        if (word == null || word.equals("")) {
        	return true;
        }
        
		String[][] used = null;
		used = new String[board.length][board[0].length];
		
		for (int i = 0; i < used.length; i ++) {
			for (int j = 0; j < used[0].length; j ++) {
				used[i][j] = "";
			}
		}
		
		for (int row = 0; row < board.length; row ++) {
			for (int col = 0; col < board[row].length; col ++) {
				if (board[row][col] == word.charAt(0)) {
					used[row][col] = ":" + String.valueOf(word.charAt(0));
					boolean found = findWord(board, word, row, col, 1, used);
					if (found) {
						return true;
					}
				}
			}
		}
		return false;
    }
	
	boolean findWord(char[][] board, String word, int row, int col, int startIndex, String[][] used) {
		if (startIndex >= word.length()) {
			return true;
		}
		
		
		boolean found = false;
		while (!found) {
			Loc loc = this.find(board, word.charAt(startIndex), word.charAt(startIndex-1), row, col, used);
			
			if (loc == null) {
				//used[row][col] = "";
				return false;
			}
			String key = String.valueOf(word.charAt(startIndex-1)) + ":" + String.valueOf(word.charAt(startIndex));
			used[loc.row][loc.col] = key;
			found = findWord(board, word, loc.row, loc.col, startIndex+1, used);
			if (found) {
				return true;
			} else {
				//reset used flag
				//used[row][col].replace(key, "");
			}
		}
		
		
		return found;
		
	}
	/**
	 * find character c near given row,col location.
	 * 
	 * @param board
	 * @param findChar
	 * @param row
	 * @param col
	 * @return
	 */
	private Loc find(char[][] board, char findChar, char fromChar, int row, int col, String[][] used) {
		Loc result = null;
		String key = String.valueOf(fromChar) + ":" + String.valueOf(findChar);
		if (row > 0) {
			//can look up
			if (used[row-1][col].indexOf(key) < 0 && board[row-1][col] == findChar) {
				return new Loc(row-1, col);
			}
		} 
		if (row < used.length - 1) {
			//can look down
			if (used[row+1][col].indexOf(key) < 0 && board[row+1][col] == findChar) {
				return new Loc(row+1, col);
			}
		}
		
		if (col > 0) {
			//can look left
			if (used[row][col-1].indexOf(key) < 0 && board[row][col-1] == findChar) {
				return new Loc(row, col-1);
			}
		}
		
		if (col < used[0].length-1) {
			//can look right
			if (used[row][col+1].indexOf(key) < 0 && board[row][col+1] == findChar) {
				return new Loc(row, col+1);
			}
		}
		return result;
	}
	
	class Loc {
		Loc(int _row, int _col) {
			row = _row;
			col = _col;
		}
		int row;
		int col;
	}
}
