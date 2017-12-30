package com.ray.common.utils.collections;

public interface Stack<T> {
    
    T pop();
    
    void push(T e);
    
    boolean isEmpty();
}
