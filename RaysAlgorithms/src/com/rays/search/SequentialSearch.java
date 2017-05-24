package com.rays.search;

import com.rays.utils.Timer;

import static com.rays.utils.ArrayUtil.*;

/**
 * <b>链表实现的符号表，查找算法为顺序查找</b>
 * @author Ray
 *
 */
public class SequentialSearch <Key extends Comparable<Key>,Value> {
	private Node head;
	
	private class Node {
		public Node next;
		public Key key;
		public Value value;
		public Node(Node next, Key key, Value value) {
			this.next = next;
			this.key = key;
			this.value = value;
		}
	}
	
	public SequentialSearch() {
		head = null;
	}
	
	public void put(Key key, Value value) {
		for(Node n = head; n!= null; n = n.next)
			if(n.key.equals(key)) { n.value = value; return; } 
		head = new Node(head, key, value);
	}

	public Value get(Key key) {
		for(Node n = head; n!= null; n = n.next)
			if(n.key.equals(key)) return n.value;
		return null;
	}
	
	public static void main(String[] args) {
		int size = 20000;  // 数据规模
		
		Integer[] arr = intArr(size);
		shuffle(arr);
		SequentialSearch<Integer, Integer> st = new SequentialSearch<>();
		
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
