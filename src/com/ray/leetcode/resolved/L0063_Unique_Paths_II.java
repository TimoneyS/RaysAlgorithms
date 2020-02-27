package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Unique Paths II
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * Note: m and n will be at most 100.
 *
 * Example:
 *      Example 1
 *      Input:
 *      [
 *        [0,0,0],
 *        [0,1,0],
 *        [0,0,0]
 *      ]
 *      Output: 2
 *      Explanation:
 *      There is one obstacle in the middle of the 3x3 grid above.
 *      There are two ways to reach the bottom-right corner:
 *      1. Right -> Right -> Down -> Down
 *      2. Down -> Down -> Right -> Right
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/unique-paths-ii/
 * @since   2020-02-27 22:38:34
 */
public class L0063_Unique_Paths_II {
    /**
     * 跟进的问题，依然采用 dp，此时障碍物的 dp 为 0
     *      如果 某个位置是 障碍物，则该点的系数为 0
     *      dp[i][j] = n1 * dp[i-1][j] + n2 * dp[i][j-1];
     *
     * 需要注意，位于障碍物右侧和下方的点可能无法达到，在计算路径是需要注意区别，例如
     */
    static class Solution {
        public int uniquePathsWithObstacles(int[][] grid) {

            int h = grid.length;
            int w = grid[0].length;
            int[][] dp = new int[h][w];

            if (grid[0][0] == 0)dp[0][0] = 1;
            else return 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (grid[i][j] == 1 || i == j && i == 0) continue;
                    int l = j > 0 ? dp[i][j-1] : 0;
                    int r = i > 0 ? dp[i-1][j] : 0;
                    dp[i][j] = l + r;
                }
            }
            return dp[h-1][w-1];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
