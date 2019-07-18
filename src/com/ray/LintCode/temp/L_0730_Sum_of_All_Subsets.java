package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a number `n`, we need to find the sum of all the elements from all possible subsets of a set formed by first n natural numbers.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : n = 2
 *      Output : 6
 *      Explanation : 
 *      Possible subsets are {{1}, {2}, {1, 2}}. Sum of elements in subsets
 *      is 1 + 2 + 1 + 2 = 6
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : n = 3
 *      Output : 24
 *      Explanation : 
 *      Possible subsets are {{1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}
 *      Sum of subsets is : 
 *      1 + 2 + 3 + (1 + 2) + (1 + 3) + 
 *      (2 + 3) + (1 + 2 + 3) = 24
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sum-of-all-subsets/description
 * @date   2019-07-11 18:35:54
 */
public class L_0730_Sum_of_All_Subsets {


    /**
     * 观察规律即可
     * 
     * n 个数的排列组合 =  n-1 个数的排列组合 + n-1 个数的每个排列组合中加入 n + 单独一个n构成的组合
     * n 个数的排列组合之和 = n-1 个数的排列组合之和 + n-1 个数的排列组合之和 + n-1的排列组合数 * n + n
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int subSum(int n) {
            
            int[] count = new int[n];
            int[] sum   = new int[n];
            
            count[0] = 1;
            sum[0] = 1;
            
            for (int i = 1; i < n; i++) {
                count[i] = count[i-1] * 2 + 1;
                sum[i]   = sum[i-1]*2 + count[i-1] * (i+1) + i+1;
            }
            
            return sum[n-1];
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
