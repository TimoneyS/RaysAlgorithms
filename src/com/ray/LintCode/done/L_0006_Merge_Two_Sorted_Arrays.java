package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      合并两个已经有序的数组 A 和 B
 *
 * 挑战：
 *      当一个数组特别大，另一个数组特别小时如何优化算法。
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/merge-two-sorted-arrays/description

 * @date   2019-07-10 15:33:08
 */
public class L_0006_Merge_Two_Sorted_Arrays {

    /**
     * 同时遍历两个数组，谁小谁前进。
     * @author rays1
     *
     */
    static class Solution {
        
        public int[] mergeSortedArray(int[] A, int[] B) {
            int[] arr = new int[A.length + B.length];
            
            int i = 0;
            int j = 0;
            
            for (int k = 0; k < arr.length; k++) {
                if (i == A.length) {
                    arr[k] = B[j++];
                } else if (j == B.length) {
                    arr[k] = A[i++];
                } else if (A[i] <= B[j]) {
                    arr[k] = A[i++];
                } else {
                    arr[k] = B[j++];
                }
            }
            return arr;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
