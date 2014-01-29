package com.jayasagar.ds.curious.queue;

import com.jayasagar.ds.curious.stack.Stack;

public class QueueByTwoStacks {

	private Stack enqueueStack = new Stack();
	private Stack dequeueStack = new Stack();
	
	public QueueByTwoStacks() {
		
	}
	
	/**
	 * Time complexity O(1); 
	 */
	public void enqueue(int data) {
		enqueueStack.push(data);
	}
	
	public int dequeue() {
		
		// Already it has records, just pop 
		if (!dequeueStack.isEmpty()) {
			return dequeueStack.pop().getData();
		}
		// if empty dequeue stack, then load from enqueue stack.
		while(!enqueueStack.isEmpty()) {
			dequeueStack.push(enqueueStack.pop().getData());
		}
		
		if (!dequeueStack.isEmpty()) {
			int data = dequeueStack.pop().getData();
			return data;
		}
		
		return -1;
	}
}

