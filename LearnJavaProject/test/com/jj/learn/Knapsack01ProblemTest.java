package com.jj.learn;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Knapsack01ProblemTest {

	private Knapsack01Problem inst = new Knapsack01Problem();
	
	@BeforeAll
	public static void setUp() throws Exception {
	}
	
	@Test
	public void test0() {
		int[] weights = {5};
		int[] values = {3};
		int maxWeight = 8;
		
		int value = inst.knapsackSolutionValue(weights, values, maxWeight);
		
		assertEquals(3, value);
	}
	
	@Test
	public void test0_1() {
		int[] weights = {5};
		int[] values = {3};
		int maxWeight = 2;
		
		int value = inst.knapsackSolutionValue(weights, values, maxWeight);
		
		assertEquals(0, value);
	}

	@Test
	public void test() {
		int[] weights = {23,
				   31,
				   29,
				   44,
				   53,
				   38,
				   63,
				   85,
				   89,
				   82};
		int[] values = {92,
				   57,
				   49,
				   68,
				   60,
				   43,
				   67,
				   84,
				   87,
				   72};
		int maxWeight = 165;
		
		int value = inst.knapsackSolutionValue(weights, values, maxWeight);
		int[] expected = {0,1,2,3,5};
		
		assertEquals(309, value);
		//assertArrayEquals(expected, indexes);
	}

	
	@Test
	public void test2() {
		int[] weights = {1,2,4,2,5};
		int[] values = {5,3,5,3,2};
		int maxWeight = 8;
		
		int value = inst.knapsackSolutionValue(weights, values, maxWeight);
		int[] expected = {0,1,2};
		
		assertEquals(13, value);
	}
	
	@Test
	public void test3() {
		int[] weights = {56,
				59,
				80,
				64,
				75,
				17};
		int[] values = {50,
				50,
				64,
				46,
				50,
				 5};
		int maxWeight = 190;
		
		int value = inst.knapsackSolutionValue(weights, values, maxWeight);
		int[] expected = {0,1,4};
		
		assertEquals(150, value);
		
	}
	
	@Test
	public void test4() {
		int[] weights = {382745,
				799601,
				909247,
				729069,
				467902,
				 44328,
				 34610,
				698150,
				823460,
				903959,
				853665,
				551830,
				610856,
				670702,
				488960,
				951111,
				323046,
				446298,
				931161,
				 31385,
				496951,
				264724,
				224916,
				169684};
		int[] values = {825594,
				1677009,
				1676628,
				1523970,
				 943972,
				  97426,
				  69666,
				1296457,
				1679693,
				1902996,
				1844992,
				1049289,
				1252836,
				1319836,
				 953277,
				2067538,
				 675367,
				 853655,
				1826027,
				  65731,
				 901489,
				 577243,
				 466257,
				 369261};
		int maxWeight = 6404180;
		
		int value = inst.knapsackSolutionValue(weights, values, maxWeight);
		int[] expected = {0,1,3,4,5,9,10,12,15,21,22,23};
		
		assertEquals(330, value);
		
	}
	@Test
	public void test4_DP() {
		int[] weights = {382745,
				799601,
				909247,
				729069,
				467902,
				 44328,
				 34610,
				698150,
				823460,
				903959,
				853665,
				551830,
				610856,
				670702,
				488960,
				951111,
				323046,
				446298,
				931161,
				 31385,
				496951,
				264724,
				224916,
				169684};
		int[] values = {825594,
				1677009,
				1676628,
				1523970,
				 943972,
				  97426,
				  69666,
				1296457,
				1679693,
				1902996,
				1844992,
				1049289,
				1252836,
				1319836,
				 953277,
				2067538,
				 675367,
				 853655,
				1826027,
				  65731,
				 901489,
				 577243,
				 466257,
				 369261};
		int maxWeight = 6404180;
		
		int[] indexes = inst.knapsackSolution(weights, values, maxWeight);
		int[] expected = {0,1,3,4,5,9,10,12,15,21,22,23};
		
		assertArrayEquals(expected, indexes);
		
	}
}
