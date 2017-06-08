package com.ray.search;

public class HashSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
	
	@SuppressWarnings("unused")
	private int N;
	private int M;
	
	private SequentialSearch<Key, Value>[] st;
	
	public HashSymbolTable() {
		this(997);
	}
	
	@SuppressWarnings("unchecked")
	public HashSymbolTable(int size) {
		M = size;
		st = (SequentialSearch<Key, Value>[]) new SequentialSearch[M];
		for (int i = 0; i < st.length; i ++)
			st[i] = new SequentialSearch<Key, Value>();
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public Value get(Key key) {
		return st[hash(key)].get(key);
	}
	
	public void put(Key key, Value value) {
		st[hash(key)].put(key, value);
	}
	
}
