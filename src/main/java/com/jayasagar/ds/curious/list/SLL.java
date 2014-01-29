package com.jayasagar.ds.curious.list;

public class SLL {
	
	private Node root;
	private Node tail;
	private int size;

	// Add
	// Remove
	// Search
	// Display
	// Kth element from last

	public Node search(int data) {
		Node t = root;
		
		while (t != null) {
			int nodeData = t.getData();
			if (nodeData == data) {
				return t;
			}
			t = t.getNext();
		}
		
		return null;
	}
	
	public boolean remove(int data) {
		
		if (root == null) {
			return false;
		}
		if (root.getData() == data) {
			root = tail = null;
			return true;
		}
		
		Node prev = root;
		Node t = root.getNext();
		
		while (t != null) {
			int nodeData = t.getData();
			if (nodeData == data) {
				// cut the link 
				prev.setNext(t.getNext());
				return true;
			}
			prev = t;
			t = t.getNext();
		}
		
		return false;
	}
	
	// // Not yet working , TODO - Fix it , idea is clear but need to write test cases and fix it later.
	// What if k is greater ? size of list ???
	public Node getKthNodeFromLast(int k) {
		// root null
		if (root == null) {
			return null;
		}
		// if root == tail -> only one element in list and if k == 1,return it else :(, not possible
		if (root == tail) {
			if(k == 1) {
				return root;
			} else {
				return null;
			}
		}
		
		Node kthNode = root;
		Node traversal = root;
		
		// traverse k-1 times from head
		while (k == 1) {
			traversal = traversal.getNext();
			k--;
		}
		
		// traverse k to end of list, AND SAME time , traverse from head 
		while(traversal != null) {
			traversal = traversal.getNext();
			kthNode = kthNode.getNext();
		}
		return kthNode;
	}
	
	// Not yet working , TODO - Fix it , idea is clear but need to write test cases and fix it later.
	public Node recursiveKthNodeFromLast(int k) {
		// root null
		if (root == null) {
			return null;
		}
		// if root == tail -> only one element in list and if k == 1,return it else :(, not possible
		if (root == tail) {
			if(k == 1) {
				return root;
			} else {
				return null;
			}
		}
		
		Node kthNode = root;
		Node traversal = root;
		
		return recursiveKthNodeFromLast(kthNode, traversal, k);
	}
	
	// 
	
	// Not yet working , TODO - Fix it , idea is clear but need to write test cases and fix it later.
	private Node recursiveKthNodeFromLast(Node kthNode, Node traversal, int k) {
		
		if (k >= 1) {
			recursiveKthNodeFromLast(kthNode, traversal.getNext(), k--);
		} else {
			if (traversal != null) {
				recursiveKthNodeFromLast(kthNode.getNext(), traversal.getNext(), k);
			}
		}
		
		return kthNode;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public class Node {
		private Node next;
		private int data;
		
		public int getData() {
			return data;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getNext() {
			return next;
		}
		
		// equals and hashcode
	}
}
