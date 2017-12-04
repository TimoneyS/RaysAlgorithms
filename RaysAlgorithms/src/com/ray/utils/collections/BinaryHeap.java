package com.ray.utils.collections;

import static com.ray.utils.ArrayUtil.*;

/**
 * 二叉堆
 * @author rays1
 *
 * @param <Key>
 */
public class BinaryHeap <Key extends Comparable<Key>> {
    private Key[] inner;            // 内部保存元素的数据结构
    private int   cursor;           // 游标
	
	@SuppressWarnings("unchecked")
	public BinaryHeap(int size) {
		inner = (Key[]) new Comparable[size+1];
		cursor = 0;
	}
	
	/**
	 * 插入
	 * @param v
	 */
	public void insert(Key v) {
		inner[++cursor] = v;
		swim(cursor);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public Key delete() {
		Key key = inner[1];
		inner[1] = inner[cursor--];
		sink(1);
		return key;
	}

	/**
	 * 上浮操作
	 * @param index
	 */
	private void swim(int index) {
		while(index > 1 && less(inner, index/2, index)) {
		    swap(inner, index, index/2);
		    index/=2;
		}
	}
	
	/**
	 * 下沉操作
	 * @param index
	 */
	private void sink(int index) {
		while (index * 2 <= cursor) {
			int j = index*2;
			if(less(inner, j,j+1)) j ++;
			if(!less(inner, index, j)) break; 
			swap(inner, index, j);
			index = j;
		}
	}
	
}
