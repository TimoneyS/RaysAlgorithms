package com.rays.algo.search;

import com.ray.util.RArrays;
import com.ray.util.io.Out;

public class TestRedBlackST {
    
    public static void testSelect() {
        RedBlackBinarySearchTree<Integer, Integer> st = getRedBlackST(new Integer[] { 1, 3, 5, 7, 9 });
        Out.p();
        Out.p(st.select(1));
    }
    
    public static void testRank() {
        RedBlackBinarySearchTree<Integer, Integer> st = getRedBlackST(new Integer[] {1,3,5,7,9});
        
        Out.p();
        int i = st.rank(9);
        
        Out.p(i);
    }
    
    private static RedBlackBinarySearchTree<Integer, Integer> getRedBlackST(Integer[] arr) {
        RedBlackBinarySearchTree<Integer, Integer> st = new RedBlackBinarySearchTree<>();
        Out.p(arr);
        for (Integer i : arr)
            st.put(i, i);
        st.show();
        return st;
    }
    
    @SuppressWarnings("unused")
    private static RedBlackBinarySearchTree<Integer, Integer> getRedBlackST(int size, int seed) {
        Integer[] arr;
        arr = RArrays.integerArr(size);
        RArrays.shuffle(arr, 1);
        return getRedBlackST(arr);
    }
    
    public static void main(String[] args) {
        testSelect();
    }
    
}
