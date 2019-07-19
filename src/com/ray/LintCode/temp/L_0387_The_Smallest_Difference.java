package com.ray.LintCode.temp;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two array of integers(the first array is array `A`, the second array is array `B`), now we are going to find a element in array A which is A[i], and another element in array B which is B[j], so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: A = [3, 6, 7, 4], B = [2, 8, 9, 3]
 *      Output: 0
 *      Explanation: A[0] - B[3] = 0
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: A = [1, 2, 3, 4], B = [7, 6, 5]
 *      Output: 1
 *      Explanation: B[2] - A[3] = 1
 *      ```
 *
 * 挑战：
 *      O(*n* log *n*) time
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/the-smallest-difference/description
 * @date   2019-07-11 18:32:24
 */
public class L_0387_The_Smallest_Difference {

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
        
        Out.p(new Solution());
        
    }

}