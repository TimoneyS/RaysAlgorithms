package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two sequence `P` and `Q` of numbers. The task is to find Longest Common Subsequence of two sequence if we are allowed to change at most k element in first sequence to any value.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      [8,3]
 *      [1,3]
 *      1
 *      Output:
 *      2
 *      
 *      Explanation:
 *      chang 8 to 1,the longest common subsuquence is[1,3]
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      [1, 2, 3, 4, 5]
 *      [5, 3, 1, 4, 2]
 *      1
 *      Output:
 *      3
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-common-subsequence-ii/description
 * @date   2019-07-11 18:36:06
 */
public class L_0762_Longest_Common_Subsequence_II {
    
    /**
     * 
     * dp[i][j][k] 两个数组分别在 i j 结束，可以修改 k 个字符时，最长公共子序列
     * 
     * P[i] == Q[j] // 不需要修改
     *      1+dp(i+1, j+1, k)
     * 
     * P[i] != Q[j] 
     *      rs = max { dp(i+1, j, k), dp(i, j+1, k) }   // 不做修改计算
     *      rs = max { rs, 1+dp(i+1, j+1, k-1) }        // 修改一位计算
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int longestCommonSubsequenceTwo(int[] P, int[] Q, int k) {
            int[][][] mem = new int[P.length][Q.length][k+1];
            return dp(P, Q, mem, 0, 0, k);
        }
        
        public int dp(int[] P, int[] Q, int[][][] mem, int i, int j, int k) {
            if (i >= P.length || j >= Q.length) return 0;
            
            if (mem[i][j][k] == 0) {
                if (P[i] == Q[j]) {
                    mem[i][j][k] = 1 + dp(P, Q, mem, i+1, j+1, k);
                } else {
                    mem[i][j][k] = Math.max(dp(P, Q, mem, i+1, j, k), dp(P, Q, mem, i, j+1, k));
                    if (k>0)
                        mem[i][j][k] = Math.max(mem[i][j][k], 1+dp(P, Q, mem, i+1, j+1, k-1));
                }
            }
            return mem[i][j][k];
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
