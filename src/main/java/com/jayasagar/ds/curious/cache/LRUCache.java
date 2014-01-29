package com.jayasagar.ds.curious.cache;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {

	// SoftReference is used for a memory friendly cache.
	// the value will be removed under memory shortage situations and
	// the keys of the values will be removed from the cache map.
	private final Map<K, SoftReference<V>> cache;

	public LRUCache(final int cacheSize) {
		// 'true' uses the access order instead of the insertion order.
		this.cache = new LinkedHashMap<K, SoftReference<V>>(cacheSize, 0.75f, true) {
			private static final long serialVersionUID = 1L;
			@Override
			protected boolean removeEldestEntry(Map.Entry<K, SoftReference<V>> eldest) {
				// When to remove the eldest entry i.e Least Recently Used (i.e LRU) entry
				return size() > cacheSize; // Size exceeded the max allowed.
			}
		};
	}
	
	public V put(K key, V value) {
		SoftReference<V> previousValueReference = cache.put(key, new SoftReference<V>(value));
	    return previousValueReference != null ? previousValueReference.get() : null;
	}
	
	public V get(K key) {
	     SoftReference<V> valueReference = cache.get(key);
	     return valueReference != null ? valueReference.get() : null;
	 }
	 
	 public V atomicGetAndSet(K key, V value) {
	    V result = get(key);
	    put(key, value);
	    return result;
	 }
}
