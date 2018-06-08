package com.jj.learn;

public class BST {

	BST left, right;
	int data;
	
	public BST(int data) {
		this.data = data;
	}
	
	public void insert(int data) {
		if (data <= this.data) {
			//left
			if (left == null) {
				left = new BST(data);
			} else {
				left.insert(data);
			}
		}
		else {
			if (right == null) {
				right = new BST(data);
			} else {
				right.insert(data);
			}
		}
	}
	
	public boolean contains(int value) {
		if (data == value) {
			return true;
		}
		else if (value < data) {
			if (left == null) {
				return false;
			} else {
				return left.contains(value);
			}
		}
		else {
			if (right == null) {
				return false;
			} else {
				return right.contains(value);
			}
		}
	}
	
	public void inorderTraverse() {
		if (left != null) {
			left.inorderTraverse();
		}
		System.out.println(data);
		if (right != null) {
			right.inorderTraverse();
		}
	}
}
