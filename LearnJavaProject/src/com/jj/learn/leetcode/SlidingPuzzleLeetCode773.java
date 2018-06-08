package com.jj.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class SlidingPuzzleLeetCode773 {

	/**
	 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
	 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
	 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
	 * 
	 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. 
	 * If it is impossible for the state of the board to be solved, return -1.
	 
	 * Input: board = [[1,2,3],[4,0,5]]
	 * Output: 1
	 * Explanation: Swap the 0 and the 5 in one move.
	 * 
	 * Input: board = [[1,2,3],[5,4,0]]
	 * Output: -1
	 * Explanation: No number of moves will make the board solved.
	 * 
	 * Input: board = [[4,1,2],[5,0,3]]
	 * Output: 5
	 * Explanation: 5 is the smallest number of moves that solves the board.
	 * An example path:
	 * After move 0: [[4,1,2],[5,0,3]]
	 * After move 1: [[4,1,2],[0,5,3]]
	 * After move 2: [[0,1,2],[4,5,3]]
	 * After move 3: [[1,0,2],[4,5,3]]
	 * After move 4: [[1,2,0],[4,5,3]]
	 * After move 5: [[1,2,3],[4,5,0]]
	 * 
	 * @param board
	 * @return minimum number of moves to reach goal, or -1 if no solution
	 */
	
	private static final String goalString = "[1, 2, 3][4, 5, 0]";
	
	public int slidingPuzzle(int[][] board) {
		
		//cache to save a board configuration and how many moves to reach this config
		//if there is a move that can lead to this config faster, we definitely want to use the \
		//faster moves.  So this map is updated when we see a board that has not been tried before,
		//or when there is a faster way to get to this board.
		HashMap<String, Integer> seen = new HashMap<>();
		String initialBoard = Arrays.toString(board[0]) + Arrays.toString(board[1]);
		seen.put(initialBoard, 0);
		
		//we do not yet have a way to reach goal
		seen.put(this.goalString, -1);
		
		
		this.mySlidingPuzzle(board, seen, 0);
		
		Integer bestMoves = seen.get(this.goalString);
        return bestMoves.intValue();
    }
	
	/**
	 * 
	 * @param board the starting board positions
	 * @param seen the cache that saves all the moves we have tried so far and how many moves it took to get there
	 * @param startingMoves how many moves we have made so far to get to the given board position
	 * 
	 * @return how many moves to reach goal, or -1 if there is no route.
	 * 
	 */
	private int mySlidingPuzzle(int[][] board, HashMap<String, Integer> seen, int startingMoves) {
		
		//base case
		
		{
			Integer moves = seen.get(goalString);
			if (moves != -1 && moves < startingMoves) {
				return -1;
			} else {
				if (this.isGoal(board)) {
					seen.put(this.goalString, startingMoves);
					return startingMoves;
				}
				
			}
		}
		
		int thisMoves = startingMoves;
		
				
		int[][] newMove = this.makeAMove(board, seen, thisMoves);
		
		if (newMove ==  null) {
			//we don't have a move we have not tried before, and we don't have a better move to get to a board that has been tried.
			return -1;
		}
		
		thisMoves ++;
		
		while (newMove != null) {
			
			if (this.isGoal(newMove)) {
				//System.out.println("xxxx" + thisMoves);
				Integer moves = seen.get(this.goalString);
				if (moves.intValue() == -1 || moves.intValue() > thisMoves) {
					seen.put(this.goalString, thisMoves);
				}
				return thisMoves;
			}
		
			//System.out.println("*********************************");
			//String key = Arrays.toString(newMove[0]) + Arrays.toString(newMove[1]);
			//System.out.println(key);
			
			
			//has a valid move
			int rest = this.mySlidingPuzzle(newMove, seen, thisMoves);
			if (rest != -1) {
				//thisMoves += rest;
				//System.out.println("found goal in " + rest);
				Integer moves = seen.get(goalString);
				if (moves.intValue() == -1 || moves.intValue() > rest) {
					//this is a shorter route to get to goal
					seen.put(this.goalString, rest);
				}
			}
			else {
				//we are not able to find valid route
				//System.out.println("not getting there");
			}
			
			//now we try other moves on the original(inputed) board to get to goal and see if that's any better than what we have.
			thisMoves = startingMoves;
			//if we started by move zero up, maybe next valid move is to move it to the right.
			newMove = this.makeAMove(board, seen, thisMoves);
			thisMoves ++;
		}
		
		//newMove is null, meaning we don't have any valid move.
		return -1;
	}
	
	private int[][] copyBoard(int[][] b) {
		int[][] newb = new int[b.length][b[0].length];
		for (int i = 0; i < b.length; i ++) {
			for (int j = 0; j < newb[i].length; j ++) {
				newb[i][j] = b[i][j];
			}
		}
		
		return newb;
	}
	
	private static final int goalHash = goalString.hashCode();
	private boolean isGoal(int[][] board) {
		String key = Arrays.toString(board[0]) + Arrays.toString(board[1]);
		//return Arrays.equals(goal[0], board[0]) && Arrays.equals(goal[1], board[1]);
		return key.hashCode() == goalHash;
		}
	
	private boolean valid(int[][] board,HashMap<String, Integer> seen, int newMoves) {
		String key = Arrays.toString(board[0]) + Arrays.toString(board[1]);
		//System.out.println("**** look " + key);
		if (seen.containsKey(key)) {
			Integer oldMoves = seen.get(key);
			//System.out.println("**** found " + key + " moves " + oldMoves + " new moves " + newMoves);
			if (oldMoves == -1 || newMoves + 1 < oldMoves) {
				//we want this one as this is fewer moves
				//System.out.println("****seen " + key);
				seen.put(key, newMoves+1);
				return true;
			} else {
				return false;
			}
		} else {
			//System.out.println("*** put " + key + (newMoves+1));
			seen.put(key, newMoves+1);
			return true;
		}
		
	}
	private int[][] makeAMove(int[][] inBoard, HashMap<String, Integer> seen, int currentMoves) {
		int[][] board = this.copyBoard(inBoard);
		//where is zero?
		int row = 0, col = 0;
		boolean found = false;
		while (!found && row < board.length) {
			col = 0;
			while (col < board[0].length) {
				if (board[row][col] == 0) {
					found = true;
					break;
				}
				col ++;
			}
			if (!found)
				row ++;
		}
		
		boolean moved = false;
		
		if (row == 0) {
			//can move down
			board[row][col] = board[row+1][col];
			board[row+1][col] = 0;
			
			if (this.valid(board, seen, currentMoves)) {
				moved = true;
			}
			else {
				//undo move
				board[row+1][col] = board[row][col];
				board[row][col] = 0;
				moved = false;
			}
			
		} 
		if (!moved && row == 1) {
			//can move up
			board[row][col] = board[row-1][col];
			board[row-1][col] = 0;
			
			if (this.valid(board, seen, currentMoves)) {
				moved = true;
			}
			else {
				//undo move
				board[row-1][col] = board[row][col];
				board[row][col] = 0;
				moved = false;
			}
		}
		
		if (!moved && col < 2) {
			//can move right
			board[row][col] = board[row][col+1];
			board[row][col+1] = 0;
			
			if (this.valid(board, seen, currentMoves)) {
				moved = true;
			}
			else {
				//undo move
				board[row][col+1] = board[row][col];
				board[row][col] = 0;
				moved = false;
			}
			
		}
		if (!moved && col > 0) {
			//can move left
			board[row][col] = board[row][col-1];
			board[row][col-1] = 0;
			
			if (this.valid(board, seen, currentMoves)) {
				moved = true;
			}
			else {
				//undo move
				board[row][col-1] = board[row][col];
				board[row][col] = 0;
				moved = false;
			}
			
			
		}
		if (moved) {
			return board;
		} else {
			return null;
		}
	}
	

}
