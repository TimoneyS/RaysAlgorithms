package com.ray.LintCode;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * Given two array of integers(the first array is array A, the second array is array B),
 * now we are going to find a element in array A which is A[i],
 * and another element in array B which is B[j],
 * so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible,
 * return their smallest difference.
 * <p>
 * 给定两个数组 A、B，寻找差异最小的 A[i]和 B[j]
 * <p>
 * <b>Example</b>
 * <p>
 * For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0
 * <p>
 * Challenge ： O(n log n) time
 * @author rays1
 *
 */
public class L_0387_Smallest_Difference {
    
    static class Solution {
        /**
         * @param A: An integer array
         * @param B: An integer array
         * @return: Their smallest difference.
         */
        public int smallestDifference(int[] A, int[] B) {
            // write your code here
            
            Arrays.sort(A);
            Arrays.sort(B);            
            
            int i = 0, j = 0;
            int diff = -1;
            
            while ( i < A.length && j < B.length) {
                
                int temp = A[i]-B[j];
                
                if (temp > 0) {
                    // A 大
                    j ++;
                } else {
                    // B 大
                    i ++;
                }
                
                if (diff == -1 || diff > Math.abs(temp)) {
                    diff = Math.abs(temp);
                }
                
            }
            
            return diff;
        }
    }
    
    public static void main(String[] args) {
        
        int[] A = {1, 3, 7, 8};
        int[] B = {2, 5, 8};
        
        Out.p(new Solution().smallestDifference(A, B));
        
    }

}
