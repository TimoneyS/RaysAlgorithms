package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      给定两个字符串，寻找最长的公共子序列。
 * 用例：
 *      Example 1:
 *      	Input:  "ABCD" and "EDCA"
 *      	Output:  1
 *      	Explanation:
 *      	LCS is 'A' or  'D' or 'C'
 *
 *      Example 2:
 *      	Input: "ABCD" and "EACB"
 *      	Output:  2
 *      	Explanation:
 *      	LCS is "AC"
 * 难度： Medium
 * 链接： https://www.lintcode.cn/problem/longest-common-subsequence/description
 * @author rays1
 * @since   2019-07-11 18:29:54
 */
public class L_0077_Longest_Common_Subsequence {

    /**
     * dp(i, j) 表示 字符串A从i开始，字符串B从j开始的最长公共子序列长度
     *
     * 如果 A[i] == B[j] 则 dp(i, j) = 1 + dp(i+1, j+1)
     * 否则 dp(i, j) = max{
     *          dp(i+1, j),
     *          dp(i, j+1)
     * }
     *
     */
    static class Solution {
        public int longestCommonSubsequence(String A, String B) {
            if (A.length() == 0 || B.length() == 0) return 0;
            int[][] mem = new int[A.length()][B.length()];
            for (int i = 0; i < A.length(); i++) {
                for (int j = 0; j < B.length(); j++) {
                    mem[i][j] = -1;
                }
            }
            return lcs(A,B,0,0, mem);
        }
        
        public int lcs(String A, String B, int i, int j, int[][] mem) {
            if (i >= A.length() || j >= B.length()) return 0;
            if (mem[i][j] >= 0) return mem[i][j];
            if (A.charAt(i) == B.charAt(j))  mem[i][j] = 1 + lcs(A, B, i + 1, j + 1, mem);
            else                             mem[i][j] = Math.max(lcs(A, B, i + 1, j, mem), lcs(A, B, i, j + 1, mem));
            return mem[i][j];
        }
    }
    
    public static void main(String[] args) {
        String A = "ABCD";
        String B = "EACB";
        Out.p(new Solution().longestCommonSubsequence(A, B));
    }
}
