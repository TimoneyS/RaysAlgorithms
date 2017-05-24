package com.rays.search;

import static com.rays.utils.ArrayUtil.*;

import com.rays.utils.Timer;

/**
 * 演示基于有序数组的二分搜索
 * @author Ray
 * @param <Key>
 * @param <Value>
 */
@SuppressWarnings("unchecked")
public class BinarySearch <Key extends Comparable<Key>, Value> {
	
	private Key[] keys;
	private Value[] values;
	private int cursor;
	
	public BinarySearch(int size) {
		keys = (Key[]) new Comparable[size];
		values = (Value[]) new Object[size];
		this.cursor = -1;
	}
	
	public void put(Key key, Value value) {
		
		// 这段代码应该可以优化
		for(int i = 0; i <= cursor; i ++) {
			if(keys[i].equals(key)) { values[i] = value; return;}
			if (keys[i].compareTo(key) > 0) {
				for(int j = cursor; j >= i; j--) {
					keys[j+1] = keys[j];
					values[j+1] = values[j];
				}
				keys[i] = key;
				values[i] = value;
				cursor ++;
				return;
			}
		}
		
		cursor ++;
		keys[cursor] = key;
		values[cursor] = value;
	}

	public Value get(Key key) {
		int l = 0, h = cursor;
		
		while( l < h) {
			int mid = (l+h)/2;
			if (key.equals(keys[mid])) 					return values[mid];
			else if (key.compareTo(keys[mid]) > 0 )  	l = mid;
			else 										h = mid;
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		int size = 20000;
		
		Integer[] arr = intArr(size);
		shuffle(arr);
		
		BinarySearch<Integer, Integer> st = new BinarySearch<>(size);
		
		Timer.click();
		for(Integer i : arr) {
			st.put(i, i*10);
		}
		Timer.click();
		for(Integer i = 0; i < size; i++) {
			st.get(i);
		}
		Timer.click();
		
	}

}
