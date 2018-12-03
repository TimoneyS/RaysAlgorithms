package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * @author rays1
 *
 */
public class L_0064_Merge_Sorted_Array {

    static class Solution {
        /*
         * @param A: sorted integer array A which has m elements, but size of A is m+n
         * @param m: An integer
         * @param B: sorted integer array B which has n elements
         * @param n: An integer
         * @return: nothing
         */
        public void mergeSortedArray(int[] A, int m, int[] B, int n) {
            
            int i=0,j=0;
            while (i <= m && j < n) {
                if (i == m) {
                    A[i++] = B[j++];
                    m++;
                } else if (A[i] <= B[j]) {
                    i++;
                } else {
                    
                    int c = 0;
                    while (j < n) {
                        if (A[i] <= B[j]) break;
                        j++;
                        c++;
                    }
                    
                    for (int k = m+c-1; k >= i+c; k--) {
                        A[k] = A[k-c];
                    }
                    
                    for (int k = c; k > 0; k--) {
                        A[i++] = B[j-k];
                        m++;
                    }
                    
                }
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,3,4,6,0,0};
        int[] B = {2,5};
        int m = 4;
        int n = 2;
        new Solution().mergeSortedArray(A, m, B, n);
        Out.p(A);
    }

}
