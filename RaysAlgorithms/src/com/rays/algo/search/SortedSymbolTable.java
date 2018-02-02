package com.rays.algo.search;

public interface SortedSymbolTable <Key extends Comparable<Key>,Value> extends SymbolTable<Key, Value> {
    public Key min();
    public Key max();
    public Key floor(Key key);
    public Key celing(Key key);
    public int rank(Key key);
    public Key select(int index);
    public Key[] keys(int lo, int hi);
}
