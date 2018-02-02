package com.rays.algo.search;

import com.ray.common.io.Out;
import com.ray.common.util.ArrayUtil;
import com.ray.common.util.Timer;

public class TestSymbolTable {
	
    /**
     * 测试链表实现的顺序查找的符号表
     */
    public static void testSequentialSearchST() {
        int size = 10;
        SymbolTable<Integer, Integer> st = new SequentialSearchST<>();
        Timer t = Timer.create();
        
        Integer[] arr = ArrayUtil.intArr(size);
        t.click();
        for(Integer i : arr) st.put(i, i);
        Out.p(st.size());
        t.click();
        for(Integer i = size; i > 0; i--) st.get(i);
        t.stop();
    }
    
    /**
     * 测试有序数组实现的基于二分搜索的符号表
     */
    public static void testBinarySearchST() {
        
        int size = 10;
        SortedSymbolTable<Integer, Integer> st = new BinarySearchST<>(size);
        Integer[] arr = ArrayUtil.intArr(size);
        
        for (Integer i : arr) {
            st.put(i, i);
        }
        st.delete(1);
        st.delete(3);
        st.delete(5);
        for (Integer key : st.keys()) {
            Out.pf("%s -> %s \n", key, st.get(key));
        }
        
        int index = 1;
        Out.pf("floor(%s) = %s\n", index, st.floor(index));
        Out.pf("ceiling(%s) = %s\n", index, st.ceiling(index));
    }
    
	public static void main(String[] args) {
	    //testSequentialSearchST();
	    testBinarySearchST();
//		test(size, new BinarySearch<>(size));
		
//		test(size, new BinarySearchTree<>());
		
//		test(size, new HashSymbolTable<>(size/10));
		
//		test(size, new RedBlackBinarySearchTree<>());
		
	}
	
}
