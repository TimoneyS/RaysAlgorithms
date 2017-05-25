package com.rays.search;

import static com.rays.utils.ArrayUtil.intArr;
import static com.rays.utils.ArrayUtil.shuffle;

import com.rays.utils.Timer;

public class HashSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
	
	private int N;
	private int M;
	
	private SequentialSearch<Key, Value>[] st;
	
	public HashSymbolTable() {
		this(997);
	}
	
	@SuppressWarnings("unchecked")
	public HashSymbolTable(int size) {
		M = size;
		st = (SequentialSearch<Key, Value>[]) new SequentialSearch[M];
		for (int i = 0; i < st.length; i ++)
			st[i] = new SequentialSearch<Key, Value>();
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public Value get(Key key) {
		return st[hash(key)].get(key);
	}
	
	public void put(Key key, Value value) {
		st[hash(key)].put(key, value);
	}
	
	public static void main(String[] args) {
		int size = 500000;  // 数据规模
		
		Integer[] arr = intArr(size);
		shuffle(arr);
		HashSymbolTable<Integer, Integer> st = new HashSymbolTable<>();
		
		Timer.click();
		for(Integer i : arr)
			st.put(i, i * 10);
		
		Timer.click();						// 记录将全部数据插入所需的时间
		for(int i = 0; i < size; i++) {
			st.get(i);
		}
		Timer.click();						// 记录将每个元素都查找一次一共所需的时间
	}
	
	
}
