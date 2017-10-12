package com.ray.search;

import static com.ray.utils.ArrayUtil.intArr;
import static com.ray.utils.ArrayUtil.shuffle;

import com.ray.utils.StdOut;
import com.ray.utils.Timer;

public class TestSymbolTable {
	
	public static void test(int size, SymbolTable<Integer, Integer> st) {
		StdOut.p(">Test " + st.getClass().getSimpleName());
		Integer[] arr = intArr(size);
		shuffle(arr);
		
		Timer.click();
		for(Integer i : arr) {
			st.put(i, i*10);
		}
		Timer.click();
		for(Integer i = 0; i < size; i++) {
			st.get(i);
		}
		Timer.stop();
	}
	
	public static void main(String[] args) {
		int size = 1000000;
		
//		test(size, new BinarySearch<>(size));
		
		test(size, new BinarySearchTree<>());
		
		test(size, new HashSymbolTable<>(size/10));
		
		test(size, new RedBlackBinarySearchTree<>());
		
//		test(size, new SequentialSearch<>());
		
		
	}
	
}