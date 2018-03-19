package com.rays.algo.string.search;

public class Test {
    
    public static void testStringST() {
        String str = "she sells sea shells by the sea shore";
        
        RaysStringST<Integer> st = new RaysStringST<Integer>();
        String[] arr = str.split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            st.put(arr[i], i);
        }
        
        RaysStringST.Node.printNode(st.root, 1);
    }
    
    public static void main(String[] args) {
        testStringST();
    }
    
}
