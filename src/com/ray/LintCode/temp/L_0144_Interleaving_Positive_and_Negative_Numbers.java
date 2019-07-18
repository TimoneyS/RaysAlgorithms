package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
 *
 * 用例：
 *      ***Example 1***
 *      ```
 *      Input : [-1, -2, -3, 4, 5, 6]
 *      Outout : [-1, 5, -2, 4, -3, 6]
 *      Explanation :  any other reasonable answer.
 *      ```
 *
 * 挑战：
 *      Do it in-place and without extra memory.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/interleaving-positive-and-negative-numbers/description
 * @date   2019-07-11 18:31:09
 */
public class L_0144_Interleaving_Positive_and_Negative_Numbers {

    static class Solution {
        
        public void rerange(int[] A) {
            
            int l = 0, r = A.length-1;
            while (true) {
                while (l < A.length) if (A[l] > 0) l++; else break;
                while (r >= 0)       if (A[r] < 0) r--; else break;
                
                if (r <= l) break;
                
                swap(A, l, r);
            }
            
            for (int i = 1; i <= r; i += 2) {
                if (l >= A.length ) break;
                swap(A, i, l++);
                r++;
            }
            
            if (r < A.length - 2) {
                int t = A[0];
                for (int i = 0; i < l; i++) {
                    A[i] = A[i+1];
                }
                A[l] = t;
            }
            
        }
        
        public void swap(int[] A, int i, int j) {
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
        }

    }
    
    public static void main(String[] args) {
        
        int[] A = {1,-2,3,-4,5,-1,-2};
        Out.p(A);
        
        new Solution().rerange(A);
        Out.p(A);
    }

}
