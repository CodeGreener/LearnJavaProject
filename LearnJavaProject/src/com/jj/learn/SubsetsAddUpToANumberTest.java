package com.jj.learn;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubsetsAddUpToANumberTest {

	private SubsetsAddUpToANumber inst = new SubsetsAddUpToANumber();
	@BeforeAll
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		int[] given_array = {2, 4, 6, 10};
		int aNumber = 16;
		ArrayList<ArrayList<Integer>> result = inst.subsetAddUpTo(given_array, aNumber);
		
		assertEquals(2, result.size());
		ArrayList<Integer> one = new ArrayList<>();
		one.add(6);
		one.add(10);
		ArrayList<Integer> two = new ArrayList<>();
		two.add(2);
		two.add(4);
		two.add(10);
		print2DArrayList(result);
		
		assertEquals(one, result.get(0));
		assertEquals(two, result.get(1));
	}
	
	@Test
	public void test2() {
		int[] given_array = {2, 10, 6, 4};
		int aNumber = 16;
		ArrayList<ArrayList<Integer>> result = inst.subsetAddUpTo(given_array, aNumber);
		
		print2DArrayList(result);
		assertEquals(2, result.size());
		
	}

	@Test
	public void test3() {
		int[] given_array = {7, 3, 2, 10, 6, 4};
		int aNumber = 16;
		ArrayList<ArrayList<Integer>> result = inst.subsetAddUpTo(given_array, aNumber);
		
		print2DArrayList(result);
		assertEquals(4, result.size());
		
	}
	
	@Test
	public void test4() {
		int[] given_array = {7, 3, 2, 10, 6, 4};
		int aNumber = 0;
		ArrayList<ArrayList<Integer>> result = inst.subsetAddUpTo(given_array, aNumber);
		
		print2DArrayList(result);
		assertEquals(0, result.size());
		
	}
	
	@Test
	public void test5() {
		int[] given_array = {7, 3, 2, 10, 6, 4};
		int aNumber = 31;
		ArrayList<ArrayList<Integer>> result = inst.subsetAddUpTo(given_array, aNumber);
		
		print2DArrayList(result);
		assertEquals(0, result.size());
		
	}
	
	@Test
	public void test6() {
		int[] given_array = {};
		int aNumber = 31;
		ArrayList<ArrayList<Integer>> result = inst.subsetAddUpTo(given_array, aNumber);
		
		print2DArrayList(result);
		assertEquals(0, result.size());
		
	}
	private void print2DArrayList(ArrayList<ArrayList<Integer>> a) {
		for (ArrayList<Integer> l : a) {
			System.out.print("[");
			for (Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.print("]");
		}
		System.out.println();
	}
}
