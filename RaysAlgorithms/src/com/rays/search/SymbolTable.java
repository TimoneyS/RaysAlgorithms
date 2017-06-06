package com.rays.search;

public interface SymbolTable<Key extends Comparable<Key>, Value> {
	public void put(Key key, Value value);
	public Value get(Key key);
}
