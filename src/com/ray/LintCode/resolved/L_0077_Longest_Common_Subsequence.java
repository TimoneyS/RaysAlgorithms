package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 
 * Given two strings, find the longest common subsequence (LCS).
 * Your code should return the length of LCS.
 * 
 * @author rays1
 *
 */
public class L_0077_Longest_Common_Subsequence {

    static class Solution {
        
        int[][] mem;
        
        /**
         * @param A: A string
         * @param B: A string
         * @return: The length of longest common subsequence of A and B
         */
        public int longestCommonSubsequence(String A, String B) {
            if (A.length() == 0 || B.length() == 0) return 0;
            
            mem = new int[A.length()][B.length()];
            for (int i = 0; i < A.length(); i++) {
                for (int j = 0; j < B.length(); j++) {
                    mem[i][j] = -1;
                }
            }

            return lcs(A,B,0,0);
        }
        
        public int lcs(String A, String B, int sa, int sb) {
            if (sa >= A.length() || sb >= B.length()) return 0;
            if (mem[sa][sb] >= 0) return mem[sa][sb];
            if (A.charAt(sa) == B.charAt(sb))  mem[sa][sb] = 1 + lcs(A, B, sa + 1, sb + 1);
            else                               mem[sa][sb] = Math.max(lcs(A, B, sa + 1, sb), lcs(A, B, sa, sb + 1));
            return mem[sa][sb];
        }
        
    }
    
    public static void main(String[] args) {
        
        String A = "ABCD";
        String B = "EACB";
        
        Out.p(new Solution().longestCommonSubsequence(A, B));
        
    }

}
