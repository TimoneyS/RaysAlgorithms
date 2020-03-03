package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Interleaving String
 * -----------------------------------------------------------------------------
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example:
 *      Example 1
 *      Input: s1 = aabcc, s2 = dbbca, s3 = aadbbcbcac
 *      Output: true
 *      Example 2
 *      Input: s1 = aabcc, s2 = dbbca, s3 = aadbbbaccc
 *      Output: false
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/interleaving-string
 * @since   2020-03-03 22:57:55
 */
public class L0097_Interleaving_String {
    /**
     * 设 A[i][j] 表示到 i j 为止，s1 s2 能够构成 i+j 长度的 s3
     * A[i][j] = A[i-1][j] && s1[i] == s3[i+j] || A[i][j-1] && s2[j] == s3[i+j]
     */
    static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int l1 = s1.length(), l2 = s2.length();
            if (l1 + l2 != s3.length()) {
                return false;
            }

            boolean[][] A = new boolean[l1+1][l2+1];
            A[0][0] = true;
            for (int i = 1; i <= l1; i++) {
                A[i][0] = A[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
            }
            for (int j = 1; j <= l2; j++) {
                A[0][j] = A[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
            }
            for (int i = 1; i <= l1; i++) {
                for (int j = 1; j <= l2; j++) {
                    A[i][j] = A[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) || A[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }
            }
            return A[l1][l2];
        }
    }
    
    public static void main(String[] args) {
        String s1 = "", s2 = "", s3 = "a";
        Out.p(new Solution().isInterleave(s1, s2, s3));
    }
}
