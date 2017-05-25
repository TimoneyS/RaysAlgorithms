package com.rays.search;

import static com.rays.utils.ArrayUtil.intArr;
import static com.rays.utils.ArrayUtil.shuffle;

import com.rays.utils.StdOut;
import com.rays.utils.Timer;

public class TestSymbolTable {
	
	public static void test(int size, SymbolTable<Integer, Integer> st) {
		StdOut.pt("Test " + st.getClass().getSimpleName() + " ");
		StdOut.sep();
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
