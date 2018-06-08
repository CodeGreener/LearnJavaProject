package com.jj.learn;

import java.util.ArrayList;

import com.jj.learn.BSTTreeTest.Node;

/**
 * Binary Search Tree.
 * 
 * No repeat value is allowed.  No null value is allowed.
 * 
 * @author che
 *
 * @param <T>
 */
public class BSTTree <T extends Comparable<T>> {
	
	class Node<T> {
		private T data = null;
		private Node<T> left;
		private Node<T> right;
		
	}
	
	private Node<T> root = null;
	
	public void insert(T data) {
		root = addNode(root, data);
	}
	
	/**
	 * Insert a data value into BST.
	 * 
	 * @param parent is the root of the tree to insert data into
	 * @param data
	 * @return the resulting tree root
	 */
	private Node<T> addNode(Node<T> parent, T data) {
		if (parent == null) {
			parent = new Node<T>();
			parent.data = data;
			return parent;
		} else {
			if (parent.data.compareTo(data) == 0) {
				throw new IllegalArgumentException("duplicate data " + data + " not allowed!!");
			}
			else if (parent.data.compareTo(data) > 0) {
				parent.left = addNode(parent.left, data);
			} 
			else if (parent.data.compareTo(data) < 0) {
				parent.right = addNode(parent.right, data);
			}
			return parent;
		}
	}
	
	public void remove(T data) {
		root = removeNode(root, data);
	}
	
	/**
	 * Remove data from tree with root as parent. 
	 * 
	 * @param parent
	 * @param data
	 * @return the resulting subtree root
	 */
	private Node<T> removeNode(Node<T> parent, T data) {
		if (parent != null) {
			if (parent.data.compareTo(data) == 0) {
				//remove root; and return new root
				if (parent.left == null) {
					parent = parent.right;
				}
				else if (parent.right == null) {
					parent = parent.left;
				} 
				else {
					Node<T> rightMostNode = getRightMostNode(parent.left);
					System.out.println("right most " + rightMostNode.data);
					
					parent.data = rightMostNode.data;
					parent.left = removeNode(parent.left, rightMostNode.data);
					return parent;
				}
			} 
			else if (parent.data.compareTo(data) < 0) {
				parent.right = removeNode(parent.right, data);
			} else {
				parent.left = removeNode(parent.left, data);
			}
		}
		return parent;
	}
	
	private Node<T> getRightMostNode(Node<T> parent) {
		
		while (parent.right != null) {
			parent = parent.right;
		}
		return parent;
	}
	/**
	 * Is a tree at root node a BST?  A binary tree is a BST iff when traversed, it gives a sorted list of objects.
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
    
	 public ArrayList<T> traverseBST() {
		 return this.traverseBST(this.root);
	 }
	/*
	 * Depth first traverse.
	 * 
	 * @return array list of data of all the nodes in tree, depth first, intra traverse(left, root, right).
	 * 
	 */
    private <T extends Comparable<T>> ArrayList<T> traverseBST(Node<T> root) {
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
    	BSTTree<Integer> bt = new BSTTree<>();
    	
    	bt.insert(100);
    	bt.insert(300);
    	bt.insert(110);
    	bt.insert(56);
    	bt.insert(1245);
    	bt.insert(3340);
    	bt.insert(79);
    	
    	System.out.println(bt.traverseBST());
    	
    	bt.remove(100);
    	System.out.println(bt.traverseBST());
    	
    	bt.remove(3340);
    	System.out.println(bt.traverseBST());
    }
}
	    