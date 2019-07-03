package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given two integers n and k, find how many different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs.
 *   
 *   We define an inverse pair as following: For ith and jth element in the array, if i < j and a[i] > a[j] then it's an inverse pair; Otherwise, it's not.
 *   
 *   Since the answer may be very large, the answer should be modulo 10^9 + 7.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input: n = 3, k = 0
 *   Output: 1
 *   Explanation: Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pair.
 *   ```
 *   **Example 2:**
 *   ```
 *   Input: n = 3, k = 1
 *   Output: 2
 *   Explanation: The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/k-inverse-pairs-array/description
 * @date   2019-07-03 17:39:05
 */
public class L_1118_K_Inverse_Pairs_Array {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
