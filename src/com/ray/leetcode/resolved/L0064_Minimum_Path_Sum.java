package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * Example:
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/minimum-path-sum/
 * @since   2020-02-27 22:40:44
 */
public class L0064_Minimum_Path_Sum {
    static class Solution {
        public int minPathSum(int[][] grid) {

            int h = grid.length;
            int w = grid[0].length;

            for (int i = 1; i < h; i++) grid[i][0] += grid[i-1][0];
            for (int i = 1; i < w; i++) grid[0][i] += grid[0][i-1];
            for (int i = 1; i < h; i++)
                for (int j = 1; j < w; j++)
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);

            return grid[h-1][w-1];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
