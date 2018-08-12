package com.jj.learn;

import java.util.*;

/**
 * Binary Search Tree.
 * 
 * @author che
 *
 */
public class BSTTreeTest<T> {

	private Node<T> root = null;
	
	class Node<T> {
		Node<T> left = null;
		Node<T> right = null;
		T data = null;
	}
	
	/**
	 * Is a tree with root a BST?  A binary tree is a BST iff when traversed, it gives a sorted list of objects.
	 * 
	 * @param root
	 * @return 1 if yes, 0 if not
	 */
	public <T extends Comparable<T>> int isBST(Node<T> root)  
    {
        ArrayList<T> result = traverseBST(root);
        for (int i = 0; i < result.size() - 1; i ++) {
            if (result.get(i).compareTo(result.get(i+1)) > 0) {
                return 0;
            }
        }
        return 1;   
    }
    
	/*
	 * Depth first traverse.
	 * 
	 * @return array list of data of all the nodes in tree, depth first, intra traverse(left, root, right).
	 * 
	 */
    public <T extends Comparable<T>> ArrayList<T> traverseBST(Node<T> root) {
        if (root == null) {
            return new ArrayList<T>();
        }
        if (root.left == null && root.right == null) {
            ArrayList<T> r = new ArrayList<>();
            r.add(root.data);
            return r;
        }
        ArrayList<T> left = traverseBST(root.left);
        ArrayList<T> right = traverseBST(root.right);
        
        left.add(root.data);
        left.addAll(right);
        
        return left;
    }
    

   
    public static void main(String[] args) {
    	BSTTreeTest<Integer> bst = new BSTTreeTest<>();
    	
    	
    }
}
