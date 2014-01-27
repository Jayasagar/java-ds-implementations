package com.jayasagar.ds.curious.stack;


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
		
	// Push
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
			if (size == 1) {
				size--;
				root = null;
				return root;
			} else {
				Node next = root.getNext();
				size--;
				Node r = root;
				root = next;
				
				return r;
			}
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
