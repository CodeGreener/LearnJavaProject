/**
 * 
 */
package com.jj.learn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.jj.learn.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author che
 *
 */
public class MergeSortTest {

	private static MergeSort ms = null;
	List<Integer> a, b;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUp() throws Exception {
		ms = new MergeSort();
		
		
	}

	@Test
	public void testMergeSort() {
		a = new LinkedList<>();
		b = new LinkedList<>();
		
		for (int i = 0; i < 50; i ++) {
			a.add((int)(Math.random() * 100));
		}
		for (int i = 0; i < 72; i ++) {
			b.add((int)(Math.random() * 200));
		}
		
		a.sort((x, y) -> x - y);		//Comarator compare(..) returns int
		//a.sort(null);
		b.sort(null);					//natural order
		
		List<Integer> sorted = ms.mergeSortedLists(a, b);
		
		System.out.println("a=" + Arrays.toString(a.toArray()));
		System.out.println("b=" + Arrays.toString(b.toArray()));
		System.out.println("result=" + Arrays.toString(sorted.toArray()));
		
		assertEquals(a.size() + b.size(), sorted.size());
		
		for (int i = 0; i < sorted.size() - 1; i ++) {
			assertTrue(sorted.get(i) <= sorted.get(i+1));
		}
		
		//boundary cases
		List<Integer> sorted2 = ms.mergeSortedLists(new LinkedList<Integer>(), b);
		assertEquals(b, sorted2);
		
		List<Integer> sorted3 = ms.mergeSortedLists(new LinkedList<Integer>(), new LinkedList<Integer>());
		assertEquals(new LinkedList<Integer>(), sorted3);
		
		List<Integer> c = new LinkedList<>();
		c.add(100);
		List<Integer> sorted4 = ms.mergeSortedLists(c, c);
		assertEquals(2, sorted4.size());
	}

}
