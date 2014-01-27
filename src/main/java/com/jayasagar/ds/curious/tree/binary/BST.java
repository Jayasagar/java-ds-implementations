package com.jayasagar.ds.curious.tree.binary;

import java.util.ArrayList;
import java.util.List;

public class BST {

	private Node root;
	private int height;
	private int size;
	
	public int getSize() {
		return size;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public int getHeight() {
		return height;
	}
	
	// Operations 
	// Height -> Done
	// Level -> Done
	// Insert -> Done
	// Delete
	// Search -> Done
	// Traversals -> Separate class ? -> Done
	
	/**
	 * Find the list of elements at level kth in BST
	 */
	public List<Node> findElementsAtKthLevel(int level) {
		List<Node> kthElements = new ArrayList<BST.Node>();
		
		if (root == null) {
			return kthElements;
		}
		 
		// If given level is more than than height , return empty :(
		if (height == level +1) {
			return kthElements;
		}
		findElementsAtKthLevel(root, kthElements, level);
		
		return kthElements;
	}
	
	private void findElementsAtKthLevel(Node node, List<Node> kthElements, int level) {
		int nodeLevel = node.getLevel();
		
		if (nodeLevel == level) {
			kthElements.add(node);
			return ;
		}
		
		// Process left node
		Node left = node.getLeft();
		if (left != null) {
			findElementsAtKthLevel(left, kthElements, level);
		}
		
		// Process Right node
		Node right = node.getRight();
		if (right != null) {
			findElementsAtKthLevel(right, kthElements, level);
		}
	}

	public boolean find(int element) {
		if (root == null) {
			return false;
		}
		
		return find(root, element);
	}
	
	private boolean find(Node node, int element) {
		int data = node.getData();
		if (data == element) { // If already found return true
			return true;
		}

		if (element > data) {
			Node right = node.getRight();
			if (right != null) {
				boolean isFound = find(right, element);
				if (isFound) {
					return isFound;
				}
			}
		} else {
			Node left = node.getLeft();
			if (left != null) {
				boolean isFound = find(left, element);
				if (isFound) {
					return isFound;
				}
			}
		}
		
		return false;
	}

	public void insert(int obj) {
		// is root exist ?? , else insert as a root
		if (root == null) {
			root = new Node(obj, 0);
			height++;
			size++;
		}
		
		// traverse tree and insert at right side and place
		insert(root, obj);
	}
	
	private void insert(final Node node, final int input) {
		// compare data 
		int data = node.getData();
		
		// Less than case
		if (input < data) {
			Node leftNode = node.getLeft();
			if (leftNode == null) {
				Node newLeftNode = new Node(input, node.getLevel()+1);
				node.setLeft(newLeftNode);
				
				size++;
				
				// Set new height if required 
				calculateHeight(newLeftNode.getLevel());
			} else {
				insert(leftNode, input);
			}
		}
		// Greater than case
		if (input > data) {
			Node rightNode = node.getRight();
			if (rightNode == null) {
				Node newRightNode = new Node(input, node.getLevel()+1);
				node.setRight(newRightNode);
				size++;
				// Set new height if required 
				calculateHeight(newRightNode.getLevel());

			} else {
				insert(rightNode, input);
			}
		}
	}

	private void calculateHeight(int level) {
		if (height < level +1) {
			height++;
		}
	}

	public class Node {
		private int data;
		private Node left;
		private Node right;
		private int level;
		
		public Node(int data, int depth) {
			this.data = data;
			this.level = depth;
		}
		
		// equlas and hashcode
		
		public int getLevel() {
			return level;
		}
		
		public int getData() {
			return data;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public Node getLeft() {
			return left;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node getRight() {
			return right;
		}
	}
}

