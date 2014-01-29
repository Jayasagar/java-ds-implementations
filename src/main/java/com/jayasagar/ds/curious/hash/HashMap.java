package com.jayasagar.ds.curious.hash;

public class HashMap {

	private int size;
	private int capacity;
	private Entry[] elements;
	
	public HashMap(int initialSize) {
		capacity = initialSize;
		elements = new Entry[capacity];
	}
	
	/**
	 *  Operations
	 *  put
	 *  get
	 *  remove
	 *
	 */

	public void put(Object key, Object value) {
		int hashCode = key.hashCode();
		
		int indexBucket = calBucketIndex(hashCode);
		Entry entry = elements[indexBucket];

		Entry newEntry = new Entry(key, value);
		
		if (entry == null) {
			elements[indexBucket] = newEntry;
		} else {
			Entry last = null;
			boolean found = false;
			while (entry != null) {
				Object entryKey = entry.getKey();
				if (key == entryKey || entryKey.equals(key)) {
					entry.setValue(value);
					found = true;
				}
				last = entry;
				entry = entry.getNext();
			}
			
			if (!found) {
				last.setNext(newEntry);
			}
		}
		
		size ++;
	}
	
	public int getSize() {
		return size;
	}

	public Object get(Object key) {
		int hashCode = key.hashCode();
		int indexBucket = calBucketIndex(hashCode);
		Entry entry = elements[indexBucket];
		while (entry != null) {
			Object entryKey = entry.getKey();
			if (key == entryKey || entryKey.equals(key)) {
				return entry.getValue();					
			}
			entry = entry.getNext();
		}
		
		return null;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private int calBucketIndex(int hashCode) {
		return Math.abs(hashCode%capacity);
	}


	public class Entry {
		private Object key;
		private Object value;
		private Entry next;
		
		public Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
		
		public void setNext(Entry next) {
			this.next = next;
		}
		
		public void setValue(Object value) {
			this.value = value;
		}
		
		public Entry getNext() {
			return next;
		}
		
		public Object getKey() {
			return key;
		}
		
		public Object getValue() {
			return value;
		}
	}
}
