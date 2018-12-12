package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a m x n grid filled with non-negative numbers,
 *  find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * @author rays1
 *
 */
public class L_0110_Minimum_Path_Sum {

    static class Solution {
        /**
         * @param grid: a list of lists of integers
         * @return: An integer, minimizes the sum of all numbers along its path
         */
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
        
        int[][] grid = {
                {1,2},
                {3,4}
        };
        
        Out.p(new Solution().minPathSum(grid));
        
    }

}
