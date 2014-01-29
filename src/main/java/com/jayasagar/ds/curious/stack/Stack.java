package com.jayasagar.ds.curious.stack;


/**
 * Interesting questions :
 * 1. Show how to implement a queue using two stacks. Analyze the running time of the queue operations
 */
public class Stack {

	private Node root;
	private int size;

	public int getSize() {
		return size;
	}
	
	// diaply
	public void display() {
		Node node = root;
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}
		
	// Push - o(1)
	public void push(int data) {
		Node newNode = new Node(data);
		size++;
		if (root != null) {
			newNode.setNext(root);
		}
		
		// Always new node will be top/root of this list
		root = newNode;
	}
	
	// Pop
	public Node pop() {
		if (!isEmpty()) {
			Node t = root;
			size--;
			root = root.getNext();
			return t;
		}
		
		return null;
	}
	
	// isEmpty
	public boolean isEmpty() {
		return root == null;
	}
	
	public class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
		public int getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}
}
