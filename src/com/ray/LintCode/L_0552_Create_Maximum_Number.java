package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two arrays of length `m` and `n` with digits `0-9` representing two numbers. Create the maximum number of length `k <= m + n` from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the `k` digits. You should try to optimize your time and space complexity.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：nums1 = [3, 4, 6, 5]， nums2 = [9, 1, 2, 5, 8, 3]，k = 5
 *      Output：[9, 8, 6, 5, 3]
 *      Explanation：
 *      select [9,8,3] from the first array and select[6,5] from the second array
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：nums1 = [6, 7]， nums2 = [6, 0, 4]，k = 5
 *      Output：[6, 7, 6, 0, 4]
 *      Explanation：
 *      select [6,7] from the first array and select[6,0,4] from the second array
 *      ```
 *      
 *      **Example 3:**
 *      ```
 *      Input：nums1 = [3, 9]， nums2 = [8, 9]，k = 3
 *      Output：[9, 8, 9]
 *      Explanation：
 *      select [9] from the first array and select[8, 9] from the second array
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/create-maximum-number/description
 * @date   2019-07-11 18:33:58
 */
public class L_0552_Create_Maximum_Number {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
