package com.jayasagar.ds.curious.queue;



public class Queue {
	
	private Node root;
	private Node tail; // tail is only required for enqueue 
	private int size;

	// diaply
	public void display() {
		Node node = root;
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}
	
	// enqueue
	public void enqueue(int data) {
		Node newNode = new Node(data);
		size++;
		
		if (root == null) {
			root = newNode;
		}
		if (tail != null) {
			newNode.setNext(tail);
		}
		
		// Always new node will be top/root of this list
		tail = newNode;
	}
	
	// dequeue
	public Node dequeue() {
		// check root
		if(isEmpty()) {
			return null;
		}
		if (size == 1) {
			size--;
			root = tail = null;
			return root;
		}
		
		com.jayasagar.ds.curious.queue.Queue.Node next = root.getNext();
		Node d = root;
		root = next;
		size --;
		return d;
	}
	
	// isEmpty
	public boolean isEmpty() {
		return root == null;
	}
	
	// size
	public int getSize() {
		return size;
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
