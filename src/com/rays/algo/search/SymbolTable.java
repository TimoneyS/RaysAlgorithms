package com.rays.algo.search;

/**
 * 符号表 API<br/>
 * 一种存储键值对的数据结构，可以根据键从中取出对应的值，其中一些约定如下 :</p>
 *  1.键不能为 null<br>
 *  2.值不能为 null<br>
 *  3.键不能重复<br>
 *  
 * @author rays1
 *
 * @param <Key>
 * @param <Value>
 */
public interface SymbolTable <Key, Value> {
    
    /**
     * 获取值
     * @param key
     * @return
     */
    public Value get(Key key);

    /**
     * 插入键值对
     * @param key
     * @param value
     */
    public void put(Key key, Value value);
    
    /**
     * 删除键值对
     * @param key
     */
    public void delete(Key key);
    
    /**
     * 符号表是否为空
     * @return
     */
    public boolean isEmpty();
    
    /**
     * 是否包含某个键值对
     * @param key
     * @return
     */
    public boolean contains(Key key);
    
    /**
     * 键值对个数
     * @return
     */
    public int size();
    
    /**
     * 获取所有键
     * @return
     */
    public Iterable<Key> keys();
    
}
