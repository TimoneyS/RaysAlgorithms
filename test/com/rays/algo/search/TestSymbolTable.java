package com.rays.algo.search;

import com.ray.util.ArrayUtil;
import com.ray.util.Timer;
import com.ray.util.io.Out;

public class TestSymbolTable {
	
    /**
     * 测试链表实现的顺序查找的符号表
     */
    public static void testSequentialSearchST() {
        int size = 10;
        SymbolTable<Integer, Integer> st = new SequentialSearchST<>();
        Timer t = Timer.create();
        
        Integer[] arr = ArrayUtil.integerArr(size);
        t.click();
        for(Integer i : arr) st.put(i, i);
        Out.p(st.size());
        t.click();
        for(Integer i = size; i > 0; i--) st.get(i);
        t.stop();
    }
    
    /**
     * 测试基于有序数组的二分搜索符号表
     */
    public static void testBinarySearchST() {
        int size = 10;
        SortedSymbolTable<Integer, Integer> st = new BinarySearchST<>(size);
        Integer[] arr = ArrayUtil.integerArr(size);
        
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
    
    public static void testBinarySearchTree() {
//        int size = 11;
        //Integer[] arr = ArrayUtil.integerArr(size);
        Integer[] arr = new Integer[] {8, 10, 2, 6, 9, 11, 1, 3, 5, 7};
        BinarySearchTree<Integer, Integer> st = new BinarySearchTree<>();
        
        for (Integer i : arr) st.put(i,i);
        
        st.show();
    }
    
	public static void main(String[] args) {
//      testSequentialSearchST();
//      testBinarySearchST();
	    testBinarySearchTree();
//		test(size, new BinarySearch<>(size));
		
//		test(size, new BinarySearchTree<>());
		
//		test(size, new HashSymbolTable<>(size/10));
		
//		test(size, new RedBlackBinarySearchTree<>());
		
	}
	
}
