package com.rays.utils;

import static com.rays.utils.ArrayUtil.*;

public class BinaryHeap <Key extends Comparable<Key>> {
	private Key[] inner;
	private int cursor;
	
	@SuppressWarnings("unchecked")
	public BinaryHeap(int size) {
		inner = (Key[]) new Comparable[size+1];
		cursor = 0;
	}
	
	public void insert(Key v) {
		inner[++cursor] = v;
		swim(cursor);
	}
	
	public Key delete() {
		Key key = inner[1];
		inner[1] = inner[cursor--];
		sink(1);
		return key;
	}

	private void swim(int index) {
		while(index > 1 && less(inner, index/2, index)) { swap(inner, index, index/2); index/=2; }
	}
	
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
