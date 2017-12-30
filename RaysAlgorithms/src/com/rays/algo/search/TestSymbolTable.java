package com.rays.algo.search;

import static com.ray.common.utils.ArrayUtil.intArr;
import static com.ray.common.utils.ArrayUtil.shuffle;

import com.ray.common.utils.Out;
import com.ray.common.utils.Timer;

public class TestSymbolTable {
	
	public static void test(int size, SymbolTable<Integer, Integer> st) {
		Out.p(">Test " + st.getClass().getSimpleName());
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
