package com.jayasagar.ds.curious.queue;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

	@Test
	public void enqueue_test() {
		Queue queue = new Queue();
		
		queue.enqueue(12);
		queue.enqueue(17);
		queue.enqueue(13);
		
		Assert.assertEquals(3, queue.getSize());
	}
	
	@Test
	public void dequeue_test() {
		Queue queue = new Queue();
		
		Assert.assertTrue(queue.isEmpty());
		
		queue.enqueue(12);
		queue.enqueue(17);
		queue.enqueue(13);
		
		queue.dequeue();
		
		Assert.assertEquals(2, queue.getSize());
		queue.display();
		
		/*queue.dequeue();
		
		Assert.assertEquals(1, queue.getSize());
		queue.display();*/
	}
}
