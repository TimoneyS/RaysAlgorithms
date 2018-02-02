package com.rays.algo.search;

import static com.ray.common.util.ArrayUtil.intArr;

import com.ray.common.io.Out;
import com.ray.common.util.Timer;

public class TestSymbolTable {
	
    /**
     * 测试链表实现的顺序查找的符号表
     */
    public static void testSequentialSearchST() {
        int size = 10;
        SymbolTable<Integer, Integer> st = new SequentialSearchST<>();
        Timer t = Timer.create();
        
        Integer[] arr = intArr(size);
        t.click();
        for(Integer i : arr) st.put(i, i);
        Out.p(st.size());
        t.click();
        for(Integer i = size; i > 0; i--) st.get(i);
        t.stop();
    }
    
	public static void main(String[] args) {
	    testSequentialSearchST();
		
//		test(size, new BinarySearch<>(size));
		
//		test(size, new BinarySearchTree<>());
		
//		test(size, new HashSymbolTable<>(size/10));
		
//		test(size, new RedBlackBinarySearchTree<>());
		
	}
	
}
