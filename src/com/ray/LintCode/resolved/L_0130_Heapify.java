package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given an integer array, heapify it into a min-heap array.
 * For a heap array A, A[0] is the root of heap,
 *  and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 * 
 * 一个整数数组，将其转换为一个最小堆格式的数组
 * 
 * Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
 * @author rays1
 *
 */
public class L_0130_Heapify {

    static class Solution {
        public void heapify(int[] A) {
            for (int i = 1; i < A.length; i++) {
                up(A, i);
            }
        }
        
        public void up(int[] A, int i) {
            int findex = (i-1)/2;
            while (findex >= 0 && A[i] < A[findex]) {
                int t = A[i];
                A[i] = A[findex];
                A[findex] = t;
                i = findex;
                findex = (findex-1)/2;
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {6,3,2,1,5,4};
        
        new Solution().heapify(A);
        Out.p(A);
        
    }

}
