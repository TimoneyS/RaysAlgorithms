package com.rays.algo.search;

/**
 * 键为可排序类型，且符号表中键是有序的
 * @author rays1
 *
 * @param <Key>
 * @param <Value>
 */
public interface SortedSymbolTable <Key extends Comparable<Key>,Value> extends SymbolTable<Key, Value> {
    /**
     * 最小的键
     * @return
     */
    public Key min();
    
    /**
     * 删除最小键
     */
    public void deleteMin();
    
    /**
     * 删除最大键
     */
    public void deleteMax();
    
    /**
     * 最大的键
     * @return
     */
    public Key max();
    
    /**
     * 小于等于key的最大键
     * @param key
     * @return
     */
    public Key floor(Key key);
    
    /**
     * 大于等于key的最小键
     * @param key
     * @return
     */
    public Key ceiling(Key key);
    
    /**
     * 小于key的键的数量
     * @param key
     * @return
     */
    public int rank(Key key);
    
    /**
     * 排名为k的键
     * @param index
     * @return
     */
    public Key select(int k);

    /**
     * lo和hi之间的所有键
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<Key> keys(Key lo, Key hi);
}
