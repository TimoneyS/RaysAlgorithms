package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given two strings, find the longest common substring. Return the length of
 * it.
 * 
 * @author rays1
 *
 */
public class L_0079_Longest_Common_Substring {

    static class Solution {
        
        /**
         * @param A:
         *            A string
         * @param B:
         *            A string
         * @return: the length of the longest common substring.
         */
        public int longestCommonSubstring(String A, String B) {

            int la = A.length(), lb = B.length();
            
            int[][] mem = new int[la+1][lb+1];
            
            int max = 0;
            for (int i = 1; i <= la; i++) {
                for (int j = 1; j <= lb; j++) {
                    if (A.charAt(i-1) == B.charAt(j-1))
                        mem[i][j] = mem[i-1][j-1] + 1;
                    max = Math.max(max, mem[i][j]);
                }
            }
            
            return max;
        }
        
    }
    
    public static void main(String[] args) {
        
        String A = "abc";
        String B = "a";
        
        Out.p(new Solution().longestCommonSubstring(A, B));
        
    }

}
