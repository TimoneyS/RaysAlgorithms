package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Given three strings: s1, s2, s3,
 * determine whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * 判断 s3 能不能由 s1 和 s2 交叉组成
 * <p>
 * Example
 * <p>
 * For s1 = "aabcc", s2 = "dbbca"
 * <li> When s3 = "aadbbcbcac", return true.
 * <li> When s3 = "aadbbbaccc", return false.
 * @author rays1
 *
 */
public class L_0029_Interleaving_String {
    static class Solution {
        
        String s1, s2, s3;
        int l1, l2, l3;
        
        /**
         * @param s1: A string
         * @param s2: A string
         * @param s3: A string
         * @return: Determine whether s3 is formed by interleaving of s1 and s2
         */
        public boolean isInterleave(String s1, String s2, String s3) {
            // write your code here
            
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            
            l1 = s1.length();
            l2 = s2.length();
            l3 = s3.length();
            
            A = new int[l1+1][l2+1];
            if (l1 + l2 != l3) return false;
            
            return isInterleave(0, 0);
        }
        int[][] A;
        
        public boolean isInterleave(int i, int j) {
            if (i == l1 && j == l2) return true;
            if (A[i][j] != 0) return A[i][j] > 0;
            
            int c1 = i < l1 ? s1.charAt(i) : -1;
            int c2 = j < l2 ? s2.charAt(j) : -1;
            int c3 = s3.charAt(i+j);
            
            boolean rs = false;
            if (c1 == c3 && c2 == c3) {
                boolean rs1 = isInterleave(i, j+1);
                boolean rs2 = isInterleave(i+1, j);
                rs = (rs1 || rs2);
            } else if (c1 == c3) {
                rs = isInterleave(i+1, j);
            } else if (c2 == c3) {
                rs = isInterleave(i, j+1);
            }
            
            A[i][j] = rs ? 1 : -1;
            return rs;
            
        }
        
    }
    
    public static void main(String[] args) {
        
        String s1 = "ab";
        String s2 = "ac";
        String s3 = "aabc";
        // "aadbbbaccc"
        
        Out.p(new Solution().isInterleave(s1, s2, s3));
    }
    
}
