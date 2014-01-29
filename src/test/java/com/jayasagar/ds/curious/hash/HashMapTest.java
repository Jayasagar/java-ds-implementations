package com.jayasagar.ds.curious.hash;

import org.junit.Assert;
import org.junit.Test;

public class HashMapTest {

	@Test
	public void put_with_sameKey_test() {
		HashMap hashMap = new HashMap(5);
		
		hashMap.put(new Customer(2), "Gold");
		hashMap.put(new Customer(2), "Silver");
		
		Assert.assertEquals(2, hashMap.getSize());
	}
	
	@Test
	public void put_test() {
		HashMap hashMap = new HashMap(5);
		
		hashMap.put(new Customer(2), "Gold");
		hashMap.put(new Customer(3), "Silver");
		
		Assert.assertEquals(2, hashMap.getSize());
	}
	
	@Test
	public void get_test() {
		HashMap hashMap = new HashMap(5);
		
		hashMap.put(new Customer(2), "Gold");
		Customer silver = new Customer(3);
		hashMap.put(silver, "Silver");
		
		Assert.assertEquals("Silver", hashMap.get(silver));
		Assert.assertEquals("Silver", hashMap.get(new Customer(3)));
	}
	
	private class Customer {
		private int id;
		
		public Customer(int id) {
			this.id = id;
		}
	
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + id;
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
			Customer other = (Customer) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id != other.id)
				return false;
			return true;
		}

		private HashMapTest getOuterType() {
			return HashMapTest.this;
		}
		
	}
}

