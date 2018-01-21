package com.ray.common.utils.collections;

public interface MaxPQ<Key extends Comparable<Key>> {
    
    void insert(Key key);
    Key max();
    Key delMax();
    boolean isEmpty();
    int size();
    
}
