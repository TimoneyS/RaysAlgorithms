package com.rays.algo.search;

import com.ray.io.Out;
import com.ray.util.RArrays;

public class TestChainingHashST {
    
    public static void testPut() {
        Integer[] arr =  RArrays.integerArr(10);
        
        ChainingHashST<Integer, Integer> st = new ChainingHashST<>(3);
        for (int i : arr) {
            st.put(i, i);
        }
        Out.p("done put");
        
        st.show();
    }
    
    public static void testDelete() {
        Integer[] arr =  RArrays.integerArr(10);
        
        ChainingHashST<Integer, Integer> st = new ChainingHashST<>(3);
        for (int i : arr) {
            st.put(i, i);
        }
        Out.p("done put");
        st.show();
        Out.sep();
        st.delete(4);
        st.show();
    }
    
    
    public static void main(String[] args) {
        testDelete();
    }
}
