package com.ray.common.collections;

public interface MaxPQ<Key extends Comparable<Key>> {
    
    /**
     * 插入元素
     * @param key
     */
    void insert(Key key);
    
    /**
     * 获取最大元素
     * @return
     */
    Key max();
    
    /**
     * 删除最大元素
     * @return
     */
    Key delMax();
    
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
