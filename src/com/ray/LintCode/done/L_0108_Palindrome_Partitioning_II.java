package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string `s`, cut `s` into some substrings such that every substring is a palindrome. 
 *      
 *      Return the **minimum** cuts needed for a palindrome partitioning of *s*.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "a"
 *      Output: 0
 *      Explanation: "a" is already a palindrome, no need to split.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "aab"
 *      Output: 1
 *      Explanation: Split "aab" once, into "aa" and "b", both palindrome.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/palindrome-partitioning-ii/description
 * @date   2019-07-11 18:30:39
 */
public class L_0108_Palindrome_Partitioning_II {

    static class Solution {
        
        int[] mem;
        
        /**
         * @param s: A string
         * @return: An integer
         */
        public int minCut(String s) {
            mem = new int[s.length()];
            return minCut(s, 0, s.length()-1)-1;
        }
        
        public int minCut(String s, int start, int end) {
            if (start == end) return 1;
            if (start > end) return 0;
            
            if (mem[start] != 0) return mem[start];
            
            int min = Integer.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                if (isPalindrom(s, start, i)) {
                    min = Math.min(min, minCut(s, i+1, end));
                }
            }
            mem[start] = 1+min;
            return mem[start];
        }
        
        boolean isPalindrom(String s, int start, int end) {
            int l = start, r = end;
            while(l < r)
                if(s.charAt(l++) != s.charAt(r--))
                    return false;
            return true;
        }
        
    }
    
    public static void main(String[] args) {
        
        String s = "ababababababababababababcbabababababababababababa";
        
        Out.p(new Solution().minCut(s));
        
    }

}
