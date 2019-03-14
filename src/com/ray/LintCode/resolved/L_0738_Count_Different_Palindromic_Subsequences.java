package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给出一个字符串 S, 计算字符串 S 中不同非空回文子序列的数量, 返回这个数对 10^9 + 7 取模后得结果. 字符串 S 的子序列可以通过删去 S
 * 中 0 个或多个字符得到. 一个序列如果是回文的, 那么它逆序后与原序列相等. 两个序列 A[1], A[2], ... B[1], B[2], ...
 * 如果存在 A[i] != B[i], 那么这两个序列是不同的.
 * 
 * 给出 S = "bccb", 返回 6 解释如下: 6 个不同的非空回文子序列为 b, c, bb, cc, bcb, bccb. 注意 bcb
 * 只计一次, 即使它出现了两次
 * 
 * 给出 S = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba", 返回
 * 104860361 解释如下: 字符串 S 有 3104860382 个不同的非空回文子序列, 对 10^9 + 7 取模后得 104860361
 * 
 * @author rays1
 *
 */
public class L_0738_Count_Different_Palindromic_Subsequences {

    /**
     * 假设 s[i][j] 之间有 x 个不同的非空回文子序列。
     * 
     * @author rays1
     *
     */
    static class Solution {

        public int countPalindSubseq(String str) {
            if (str == null || str.isEmpty())
                return 0;
            int n = str.length();
            int[][] dp = new int[n][n];

            for (int len = 1; len <= n; len++) {
                for (int l = 0; l + len - 1 < n; l++) {
                    int r = l + len - 1;
                    
                    if (l == r) {
                        dp[l][r] = 1;
                    } else if (str.charAt(l) != str.charAt(r)) {
                        dp[l][r] = dp[l + 1][r] + dp[l][r - 1] - dp[l + 1][r - 1];
                    } else {
                        // 两个字符 c 相等的情况，寻找两个字符 c 之内是否还有字符 c。
                        int left = l + 1, right = r - 1;
                        while (left <= right && str.charAt(left) != str.charAt(l))
                            left++;
                        
                        while (left <= right && str.charAt(right) != str.charAt(l))
                            right--;

                        if (left == right) {
                            // 只有一个字符 c 说明只有 cc 可以作为新的回文串加入
                            dp[l][r] = dp[l + 1][r - 1] * 2 + 1;
                        } else if (left > right) {
                            // 没有字符 c，说明 c cc 可以作为新的回文串加入
                            dp[l][r] = dp[l + 1][r - 1] * 2 + 2;
                        } else {
                            // 有两个字符 c，如果用这两个字符作为新的回文边界，那么必然和已经存在的边界产生重复的部分结果
                            dp[l][r] = dp[l + 1][r - 1] * 2 - dp[left + 1][right - 1];
                        }
                    }
                    
                    if (dp[l][r] < 0) {
                        // overflow
                        dp[l][r] += 1000000007;
                    } else {
                        dp[l][r] %= 1000000007;
                    }
                    
                }
            }
            
            return dp[0][n - 1];
        }

    }

    public static void main(String[] args) {

        String str = "aabaa";
        
        Out.p(new Solution().countPalindSubseq(str));

    }

}
