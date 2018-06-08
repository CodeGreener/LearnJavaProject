package com.jj.learn;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class AllSubsetsOfSetTest {

	private AllSubsetsOfSet inst = null;
	@Before
	public void setUp() throws Exception {
		inst = new AllSubsetsOfSet();
	}
	
	@Test
	public void recursiveTest() {
		int[] given_array = {1,2,3,4,5,6,7,8};
		inst.printAllSubsetsRecursively(given_array);
		
	}

	@Test
	public void testGetRecursive() {
		int[] given_array = {1,3,5};
		ArrayList<ArrayList<Integer>> result = inst.getAllSubsetsRecursively(given_array);
		
		assertEquals(8, result.size());
	}

	@Test
	public void testPrintRecursive() {
		int[] given_array = {1,3,5};
		 inst.printAllSubsetsRecursively(given_array);
		
	}

	@Test
	public void testPrintRecursive1() {
		int[] given_array = {1,3,5,7,9,11,13,15};
		inst.printAllSubsetsRecursively(given_array);
		
	}
	
	@Test
	public void testPrintRecursive2() {
		int[] given_array = {1,3,5,7,9,11,13,15};
		inst.printAllSubsetsRecursively(given_array);
		
	}
	@Test
	public void test() {
		int[] given_array = {12, 45, 67, 13};
		ArrayList<ArrayList<Integer>> result = inst.getAllSubsetsIteratively(given_array);
		
		
		assertEquals(16, result.size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test1() {
		int[] given_array = new int[17];
		for (int i = 0; i < given_array.length; i ++) {
			given_array[i] = i;
		}
		ArrayList<ArrayList<Integer>> result = inst.getAllSubsetsIteratively(given_array);
		
		
		assertEquals(16, result.size());
	}

	@Test
	public void test2() {
		int[] given_array = new int[10];
		for (int i = 0; i < given_array.length; i ++) {
			given_array[i] = i;
		}
		ArrayList<ArrayList<Integer>> result = inst.getAllSubsetsIteratively(given_array);
		
		
		assertEquals(1024, result.size());
	}
}
