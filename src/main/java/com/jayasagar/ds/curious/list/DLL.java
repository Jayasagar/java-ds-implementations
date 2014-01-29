package com.jayasagar.ds.curious.list;

public class DLL {

	private int size;
	private Node first;
	private Node last;
	
	public DLL() {
		
	}
	
	public DLL(Object data) {
		first = new Node(data);
		last = new Node(data);
		size ++;
	}
	
	public int size () {
		return size;
	}
	
	public boolean isEmpty() {
		return size ==0;
	}
	
	public boolean addFirst(Object data) {
		Node newFirst = new Node(data);

		if (first != null) { // Already first exist, so new node's next is first and first previous is newnode
			newFirst.setNext(first);
			first.setPrev(newFirst);
		} else { // If first is null, last should be new node.
			last = newFirst;
		}
		first = newFirst;
		size ++;
		return true;
	}

	public void addLast(Object data) {
		
		Node newLastNode = new Node(data);
		
		if (last != null) { // lastnode exist, last next node is new node, and new node previous is last node. 
			last.setNext(newLastNode);
			newLastNode.setPrev(last);
		}
		size ++;
		last = newLastNode;
	}

	public void add(Object data) {
		if (first == null) {
			addFirst(data);
		} else {
			addLast(data);
		}
	}
	
	public void removeLast() {
		if (isEmpty()) {
			return ; 
		}
		
		// If only 1 element exist
		if (first == last) {
			first = last = null;
		}
		
		if (last != null) {
			Node newLast = last.getPrev();
			last = newLast;
		}
		
		size --;
	}
	
	public void remove(Object data) {
		// what if list is empty
		// Only 1 element exist i.e. last element deletion 
		// Make sure to reference last and next correctly
		
		Node traverse = null;
		if (first != null ) {
			traverse = first;
		} else {
			return ;
		}
		
		while (first != null) {
			
		}
	}
	
	private class Node {
		private Object data;
		private Node next;
		private Node prev;
		
		public Node(Object data) {
			this.data = data;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public Node getPrev() {
			return prev;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			return true;
		}

		private DLL getOuterType() {
			return DLL.this;
		}
		
		
	}
}
