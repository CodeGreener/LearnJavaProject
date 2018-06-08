package com.jj.learn.api;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<String> descendingQ = new PriorityQueue<>((s1, s2) -> -s1.compareTo(s2));
		PriorityQueue<String> ascendingQ = new PriorityQueue<>((s1, s2) -> s1.compareTo(s2));
		
		String[] case1 = {"abcd", "343eASD", "TCIO", "ytuhasd", "", " ", "^&*tkjgjkg"};
		
		for (String s : case1) {
			descendingQ.offer(s);
			ascendingQ.offer(s);
		}
		
		System.out.println("============descending==========");
		while (!descendingQ.isEmpty()) {
			System.out.println(descendingQ.poll());
		}
		
		System.out.println("==============ascending===========");
		while (!ascendingQ.isEmpty()) {
			System.out.println(ascendingQ.poll());
		}
		
		
	}
}
