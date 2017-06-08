package com.ray.utils;

public interface SortedSymbolTable <Key extends Comparable<Key>,Value> extends SymbolTable<Key, Value> {
	Key min();
	Key max();
	Key floor(Key key);
	Key celing(Key key);
    int rank(Key key);
    Key select(int index);
    Key[] keys(int lo, int hi);
}
