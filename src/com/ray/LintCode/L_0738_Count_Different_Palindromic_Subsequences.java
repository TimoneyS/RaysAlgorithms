package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string `S`, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.
 *      
 *      A subsequence of a string S is obtained by deleting `0` or more characters from `S`.
 *      A sequence is palindromic if it is equal to the sequence reversed.
 *      
 *      Two sequences `A[1]`, `A[2]`, ... and `B[1]`, `B[2]`, ... are different if there is some i for which `A[i]` != `B[i]`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input："bccb"
 *      Output：6
 *      Explanation: 
 *      The 6 different non-empty palindromic subsequences are "b", "c", "bb", "cc", "bcb", "bccb".
 *      Note that `bcb` is counted only once, even though it occurs twice.
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input："abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"
 *      Output：104860361
 *      Explanation：
 *      There are `3104860382` different non-empty palindromic subsequences, which is `104860361` modulo `10^9 + 7`.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/count-different-palindromic-subsequences/description
 * @date   2019-07-11 18:35:56
 */
public class L_0738_Count_Different_Palindromic_Subsequences {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
