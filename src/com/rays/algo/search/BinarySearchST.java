package com.rays.algo.search;

import java.util.LinkedList;
import java.util.List;

/**
 * ������������Ķ��ֲ����㷨ʵ�ֵķ��ű�
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
        if (keys[rank] != null && keys[rank].equals(key)) {     // �¼�Ϊ����
            values[cursor] = value;
        } else {
            for (int j = cursor; j >= rank; j--) {              // �¼���Ҫ����
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
            for (int j = rank; j < cursor; j ++) {              // rank�Ҳ�ļ�ֵ������һ��
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
        for (int j = 0; j < cursor; j ++) {              // 0�Ҳ�ļ�ֵ������һ��
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
        if (key.equals(keys[index])) {      // key��������һ��
            return keys[rank(key)];
        } else if (index == 0) {            // û��С��key�ļ�
            return null;
        }
        return keys[index-1];               // ȡkey��������һ�ļ�
    }

    @Override
    public Key ceiling(Key key) {
        return keys[rank(key)];             // ���ڵ���key'�ļ�����Ϊ�������ļ�
    }

    @Override
    public int rank(Key key) {
        int l = 0;                                       // ��λ����(low)
        int h = cursor;                                  // ��λ����(high)
        while( l <= h) {
            int mid = (l+h) / 2;                         // �е�
            if (key.equals(keys[mid])) {                 // ǡ�������е�
                l = mid;
                break;
            } else if (key.compareTo(keys[mid]) > 0 ) {  // Ŀ�����Ұ��
                l = mid+1;
            } else {                                     // Ŀ��������
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
