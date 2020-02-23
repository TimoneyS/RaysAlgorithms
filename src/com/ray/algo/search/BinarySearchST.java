package com.ray.algo.search;

import java.util.LinkedList;
import java.util.List;

/**
 * 基于有序数组的二分查找算法实现的符号表
 * @author Ray
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST <Key extends Comparable<Key>, Value> implements SortedSymbolTable<Key, Value> {
	
    private Key[]   keys;
    private Value[] values;
    private int     cursor;
	
	@SuppressWarnings("unchecked")
    public BinarySearchST(int size) {
        keys = (Key[]) new Comparable[size];
        values = (Value[]) new Object[size];
        cursor = -1;
	}
	
	public Value get(Key key) {
    	return values[rank(key)];
    }

    public void put(Key key, Value value) {
        int rank = rank(key);
        if (keys[rank] != null && keys[rank].equals(key)) {     // 新键为最大键
            values[cursor] = value;
        } else {
            for (int j = cursor; j >= rank; j--) {              // 新键需要插入
                keys[j + 1] = keys[j];
                values[j + 1] = values[j];
            }
            cursor++;
            keys[cursor] = key;
            values[cursor] = value;
        }
	}

    @Override
    public void delete(Key key) {
        int rank = rank(key);
        if (keys[rank] != null && keys[rank].equals(key)) {
            for (int j = rank; j < cursor; j ++) {              // rank右侧的键值对左移一格
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
            keys[cursor] = null;
            values[cursor] = null;
            cursor--;
        }
    }

    @Override
    public boolean isEmpty() {
        return cursor == -1;
    }

    @Override
    public boolean contains(Key key) {
        return rank(key) == cursor+1;
    }

    @Override
    public int size() {
        return cursor + 1;
    }

    @Override
    public void deleteMin() {
        for (int j = 0; j < cursor; j ++) {              // 0右侧的键值对左移一格
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }
        keys[cursor] = null;
        values[cursor] = null;
        cursor--;
    }

    @Override
    public void deleteMax() {
        keys[cursor] = null;
        values[cursor] = null;
        cursor--;
    }

    @Override
    public Key max() {
        return keys[cursor];
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key floor(Key key) {
        int index = rank(key);
        if (key.equals(keys[index])) {      // key和其排名一致
            return keys[rank(key)];
        } else if (index == 0) {            // 没有小于key的键
            return null;
        }
        return keys[index-1];               // 取key的排名减一的键
    }

    @Override
    public Key ceiling(Key key) {
        return keys[rank(key)];             // 大于等于key'的键，即为其排名的键
    }

    @Override
    public int rank(Key key) {
        int l = 0;                                       // 低位索引(low)
        int h = cursor;                                  // 高位索引(high)
        while( l <= h) {
            int mid = (l+h) / 2;                         // 中点
            if (key.equals(keys[mid])) {                 // 恰好命中中点
                l = mid;
                break;
            } else if (key.compareTo(keys[mid]) > 0 ) {  // 目标在右半侧
                l = mid+1;
            } else {                                     // 目标在左半侧
                h = mid-1;
            }
        }
        return l;
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> l = new LinkedList<>();
        for (Key key : keys)
            if (key != null) l.add(key);
        return l;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        int l = rank(floor(lo));
        int h = rank(ceiling(hi));
        List<Key> list = new LinkedList<>();
        for (int i = l; i < h; i++)
            if (keys[i] != null) list.add(keys[i]);
        return list;
    }

}
