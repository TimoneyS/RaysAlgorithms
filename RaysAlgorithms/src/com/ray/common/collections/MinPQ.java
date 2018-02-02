package com.ray.common.collections;

/**
 * 最小优先级队列
 * @author rays1
 *
 * @param <Key>
 */
public interface MinPQ<Key extends Comparable<Key>> {
    
    /**
     * 插入元素
     * @param key
     */
    void insert(Key key);
    
    /**
     * 获取最小元素
     * @return
     */
    Key min();
    
    /**
     * 删除最小元素
     * @return
     */
    Key delMin();
    
    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();
    
    /**
     * 队列中元素个数
     * @return
     */
    int size();
    
}
