package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.util.ArrayUtil;

import java.util.Arrays;

/**
 * Longest Increasing Path in a Matrix
 * -----------------------------------------------------------------------------
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * Example:
 *      Example 1
 *      Input: nums = 
 *      [
 *        [9,9,4],
 *        [6,6,8],
 *        [2,1,1]
 *      ] 
 *      Output: 4 
 *      Explanation: The longest increasing path is [1, 2, 6, 9].
 *      Example 2
 *      Input: nums = 
 *      [
 *        [3,4,5],
 *        [3,2,6],
 *        [2,2,1]
 *      ] 
 *      Output: 4 
 *      Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 * @since   2020-03-12 23:25:49
 */
public class L0329_Longest_Increasing_Path_in_a_Matrix {
    /**
     * 从每个点开始搜索最长的升序列，然后记录表格
     *
     * 多点搜索时，如果路径已经记录，则使用记录的值，
     * 因为升序访问路径，路径一定不会有交叉，所以已经记录的值一定是最优的
     */
    static class Solution {
        int[][] DIRS = new int[][] { {-1, 0}, { 1, 0}, { 0, 1}, { 0,-1} };

        public int longestIncreasingPath(int[][] matrix) {
            int n = matrix.length;
            int m = n == 0 ? 0 :  matrix[0].length;
            if (n * m == 0) return 0;
            int[][] dp = new int[n][m];
            int max = Integer.MIN_VALUE;
            for (int[] row : dp) Arrays.fill(row, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dp[i][j] == 1) {
                        dfs(matrix, i, j, dp);
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
            Out.p(dp, "%s ");

            return max;
        }

        private int dfs(int[][] matrix, int i, int j, int[][] dp) {
            for (int[] dir : DIRS) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])
                    continue;
                if (dp[x][y] > 1) {
                    dp[i][j] = Math.max(1 + dp[x][y], dp[i][j]);
                } else {
                    dp[i][j] = Math.max(1+dfs(matrix, x, y, dp), dp[i][j]);
                }
            }
            return dp[i][j];
        }
    }
    
    public static void main(String[] args) {
        int[][] m = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };

        Out.p(new Solution().longestIncreasingPath(m));
    }
}
