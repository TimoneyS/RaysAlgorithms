package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a string s, cut s into some substrings such that every substring is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * @author rays1
 *
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
