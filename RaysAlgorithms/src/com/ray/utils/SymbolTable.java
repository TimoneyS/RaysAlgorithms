package com.ray.utils;

/**
 * <p>Table是一种存储键值对的数据结构，可以根据键从中取出对应的值</p>
 * <p><b>约定</b><br>
 * 1.键不能为 null<br>
 * 2.值不能为 null<br>
 * 3.键不能重复<br>
 * @author Ray
 *
 * @param <Key>  键
 * @param <Value> 值
 */
public interface SymbolTable <Key extends Comparable<Key>, Value> {
	void put(Key key, Value value);
	Value get(Key key);
	Value delete(Key key);
	int size();
	
//	boolean isEmpty();
//	boolean contains(Key key);
}
