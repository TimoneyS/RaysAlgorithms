package com.rays.algo.search;

public class HashSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
	
	@SuppressWarnings("unused")
	private int N;
	private int M;
	
	private SequentialSearchST<Key, Value>[] st;
	
	public HashSymbolTable() {
		this(997);
	}
	
	@SuppressWarnings("unchecked")
	public HashSymbolTable(int size) {
		M = size;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i = 0; i < st.length; i ++)
			st[i] = new SequentialSearchST<Key, Value>();
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

    @Override
    public void delete(Key key) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(Key key) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO Auto-generated method stub
        return null;
    }
	
}
