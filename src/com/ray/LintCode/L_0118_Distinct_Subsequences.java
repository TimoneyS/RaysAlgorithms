package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two strings `S` and `T`. Count the number of distinct subsequences of `S` which equals `T`.
 *      
 *      A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, `"ACE"` is a subsequence of `"ABCDE"` while `"AEC"` is not)
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: S = "rabbbit", T = "rabbit"
 *      Output: 3
 *      Explanation: You could remove any 'b' in S, so there are 3 ways to get T.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: S = "abcd", T = ""
 *      Output: 1
 *      Explanation: There is only 1 way to get T - remove all chars in S.
 *      ```
 *
 * 挑战：
 *      Do it in O($n^2$) time and O(n) memory. 
 *      
 *      O($n^2$) memory is also acceptable if you do not know how to optimize memory.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/distinct-subsequences/description
 * @date   2019-07-11 18:30:47
 */
public class L_0118_Distinct_Subsequences {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
