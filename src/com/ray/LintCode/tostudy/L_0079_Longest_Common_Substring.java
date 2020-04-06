package com.ray.LintCode.tostudy;

import com.ray.io.Out;

/**
 * 描述：
 *      两个字符串，寻找最长共同子串
 *      返回子串长度
 *
 * 用例：
 *      Example 1:
 *      	Input:  "ABCD" and "CBCE"
 *      	Output:  2
 *      	Explanation:
 *      	Longest common substring is "BC"
 *
 * 挑战：
 *      O(n x m) time and memory.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/longest-common-substring/description
 * @since  2019-07-11 18:29:56
 */
public class L_0079_Longest_Common_Substring {
    /**
     * 令 dp[i][j] 表示恰好A以i，B以j为止
     * 最长的子串
     *
     * 如果 A[i] = B[j] 则 dp[i][j] = d[i-1][j-1] + 1
     * 否则 dp[i][j] = 0
     *
     * rs = max {dp}
     */
    static class Solution {
        public int longestCommonSubstring(String A, String B) {
            int m = A.length(), n = B.length();
            int[][] dp = new int[m+1][n+1];
            int rs = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                    rs = Math.max(rs, dp[i][j]);
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        String A = "abcd";
        String B = "ac";
        Out.p(new Solution().longestCommonSubstring(A, B));
    }
}
