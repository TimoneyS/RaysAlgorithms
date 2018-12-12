package com.ray.LintCode.resolved;

/**
 * A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid.
 * How many possible unique paths are there?
 * @author rays1
 *
 */
public class L_0114_Unique_Paths {

    static class Solution {
        
        /**
         * @param m: positive integer (1 <= m <= 100)
         * @param n: positive integer (1 <= n <= 100)
         * @return: An integer
         */
        public int uniquePaths(int h, int w) {
            
            int[][] grid = new int[h][w];
            
            for (int i = 1; i < h; i++) grid[i][0] = 1;
            for (int i = 1; i < w; i++) grid[0][i] = 1;
            for (int i = 1; i < h; i++)
                for (int j = 1; j < w; j++)
                    grid[i][j] += grid[i][j-1] + grid[i-1][j];
            return grid[h-1][w-1];
        }
    }

}
