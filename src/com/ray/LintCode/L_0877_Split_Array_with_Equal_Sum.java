package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array with n integers, you need to find if there are triplets `(i, j, k)` which satisfies following conditions:
 *      
 *      1. `0 < i, i + 1 < j, j + 1 < k < n - 1`
 *      2. Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
 *      
 *      We define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
 *      
 *      If it exists, return `true`, otherwise return `false`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [1,3,2,1,3,2,1,3,2,1,3]
 *      Output: true
 *      Explanation: (2,5,8) => Four subarrays are all [1, 3].
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [1,2,1,2,1,2,1]
 *      Output: true
 *      Explanation: (1,3,5)
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/split-array-with-equal-sum/description
 * @date   2019-07-11 18:38:14
 */
public class L_0877_Split_Array_with_Equal_Sum {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
