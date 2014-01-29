package com.jayasagar.ds.curious.queue;

import org.junit.Assert;
import org.junit.Test;

public class QueueByTwoStacksTest {

	@Test
	public void push_test() {
		QueueByTwoStacks byTwoStacks = new QueueByTwoStacks();
		
		byTwoStacks.enqueue(12);
		byTwoStacks.enqueue(13);
		byTwoStacks.enqueue(16);
		
		Assert.assertEquals(12, byTwoStacks.dequeue());
		Assert.assertEquals(13, byTwoStacks.dequeue());
		
		byTwoStacks.enqueue(19);
		Assert.assertEquals(16, byTwoStacks.dequeue());
		Assert.assertEquals(19, byTwoStacks.dequeue());
	}
}

