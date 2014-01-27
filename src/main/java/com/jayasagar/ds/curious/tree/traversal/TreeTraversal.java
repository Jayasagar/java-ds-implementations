package com.jayasagar.ds.curious.tree.traversal;

import com.jayasagar.ds.curious.tree.binary.BST.Node;

public final class TreeTraversal {

	private TreeTraversal() {
		
	}
	
	/**
	 * Process LNR  
	 */
	public static void inOrder(Node root) {
		// process Left Node
		Node left = root.getLeft();
		if (left != null) {
			inOrder(left);
		}
		// process Node 
		System.out.println(root.getData());
		
		// process Right Node
		Node right = root.getRight();
		if (right != null) {
			inOrder(right);
		}
	}
	
	/**
	 * Process NLR  
	 */
	public static void preOrder(Node root) {
		// process Node 
		System.out.println(root.getData());
		
		// process Left Node
		Node left = root.getLeft();
		if (left != null) {
			preOrder(left);
		}
		
		// process Right Node
		Node right = root.getRight();
		if (right != null) {
			preOrder(right);
		}
	}

	
	/**
	 * Process LRN
	 */
	public static void postOrder(Node root) {
		// process Left Node
		Node left = root.getLeft();
		if (left != null) {
			postOrder(left);
		}
		
		// process Right Node
		Node right = root.getRight();
		if (right != null) {
			postOrder(right);
		}
		
		// process Node 
		System.out.println(root.getData());
		
	}

}
