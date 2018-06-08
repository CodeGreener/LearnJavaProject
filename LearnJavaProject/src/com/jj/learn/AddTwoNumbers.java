package com.jj.learn;

import java.util.ArrayList;

public class AddTwoNumbers {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  
	 }
	 
	 public static void main(String[] args) {
		 AddTwoNumbers add = new AddTwoNumbers();
		 
		 ListNode a = add.new ListNode(1);
		 ListNode b = add.new ListNode(8);
		 a.next = b;
		 
		 ListNode c = add.new ListNode(0);
		 
		 add.addTwoNumbers(a, c);
	 }
	 
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode n1 = l1;
		ListNode n2 = l2;
		ListNode result = new ListNode(0);
		ListNode current = result;
		ListNode previous = null;
		
		boolean hasCarry = false;
		while (n1 != null || n2 != null) {
			int sum = 0;
			if (n1 != null) {
				sum += n1.val;
			}
			if (n2 != null) {
				sum += n2.val;
			}
			if (hasCarry) {
				sum ++;
			}
			if (sum < 10) {
				current.val = sum;
				hasCarry = false;
			}
			else {
				current.val = sum - 10;
				hasCarry = true;
			}
			
			if (previous != null) {
				
				previous.next = current;
				
			}
			previous = current;
			current = new ListNode(0);
			
			if (n1 != null)
				n1 = n1.next;
			if (n2 != null)
				n2 = n2.next;
		}
		
		
		{
			if (hasCarry) {
				current = new ListNode(1);
				previous.next = current;
			}
		}
		
		
		
		ListNode a = result;
		while (a != null) {
			System.out.println(a.val);
			a = a.next;
		}
		return result;
	        
	    
	 }
}
