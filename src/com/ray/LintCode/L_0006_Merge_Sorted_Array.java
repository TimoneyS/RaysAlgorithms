package com.ray.LintCode;

/**
 * Merge two given sorted integer array A and B into a new sorted integer array.
 * @author rays1
 *
 */
public class L_0006_Merge_Sorted_Array {
    
    static class Solution {
        /**
         * @param A: sorted integer array A
         * @param B: sorted integer array B
         * @return: A new sorted integer array
         */
        public int[] mergeSortedArray(int[] A, int[] B) {
            // write your code here
            int[] arr = new int[A.length + B.length];
            
            int ia = 0;
            int ib = 0;
            
            for (int i = 0; i < arr.length; i++) {
                if (ia == A.length)
                    arr[i] = B[ib++];
                else if (ib == B.length)
                    arr[i] = A[ia++];
                else if (A[ia] <= B[ib])
                    arr[i] = A[ia++];
                else
                    arr[i] = B[ib++];
            }
            return arr;
        }
    }
    
}
