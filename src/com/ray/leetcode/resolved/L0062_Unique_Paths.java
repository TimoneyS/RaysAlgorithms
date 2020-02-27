package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * Note: m and n will be at most 100.
 *
 * Example:
 *      Example 1
 *      Input: m = 3, n = 2
 *      Output: 3
 *      Explanation:
 *      From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 *      1. Right -> Right -> Down
 *      2. Right -> Down -> Right
 *      3. Down -> Right -> Right
 *      Example 2
 *      Input: m = 7, n = 3
 *      Output: 28
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/unique-paths/
 * @since   2020-02-27 22:37:14
 */
public class L0062_Unique_Paths {
    /**
     * 设 dp[i][j] 表示机器人到达 位置[i, j] 有多少种可能。
     * 因为机器人只能向右或者向下，那么如果要到达位置 [i, j]，只可能是从 [i-1, j] 或者 [i, j-1] 而来
     * 所以
     *      dp[i][j] = dp[i-1][j] + dp[i][j-1];
     */
    static class Solution {
        public int uniquePaths(int h, int w) {
            int[] dp = new int[w];
            for (int i = 0; i < w; i++)
                dp[i] = 1;
            for (int i = 1; i < h; i++)
                for (int j = 1; j < w; j++)
                    dp[j] += dp[j-1];
            return dp[w-1];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
