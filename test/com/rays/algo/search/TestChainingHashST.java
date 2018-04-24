package com.rays.algo.search;

import com.ray.util.ArrayUtil;
import com.ray.util.io.Out;

public class TestChainingHashST {
    
    public static void testPut() {
        Integer[] arr =  ArrayUtil.integerArr(10);
        
        ChainingHashST<Integer, Integer> st = new ChainingHashST<>(3);
        for (int i : arr) {
            st.put(i, i);
        }
        Out.p("done put");
        
        st.show();
    }
    
    public static void testDelete() {
        Integer[] arr =  ArrayUtil.integerArr(10);
        
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
