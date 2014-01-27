package com.jayasagar.ds.curious.stack;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

	@Test
	public void push_test() {
		Stack stack = new Stack();
		stack.push(12);
		stack.push(17);
		stack.push(13);
		
		// Assert
		Assert.assertEquals(3, stack.getSize());
	}
	
	@Test
	public void pop_test() {
		Stack stack = new Stack();
		stack.push(12);
		stack.push(17);
		stack.push(13);
		Assert.assertEquals(3, stack.getSize());
		
		stack.pop();
		// Assert
		Assert.assertEquals(2, stack.getSize());
		
		stack.pop();
		Assert.assertEquals(1, stack.getSize());
		stack.pop();
		Assert.assertEquals(0, stack.getSize());
		
		stack.pop();
		Assert.assertEquals(0, stack.getSize());
	}
}
