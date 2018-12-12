package com.ray.LintCode.resolved;

import com.ray.io.Out;

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
            int[] grid = new int[w];
            for (int i = 0; i < w; i++) grid[i] = 1;
            for (int i = 1; i < h; i++) {
                for (int j = 1; j < w; j++) {
                    grid[j] += grid[j-1];
                }
            }
            return grid[w-1];
        }
        
    }
    
    public static void main(String[] args) {
        int h = 3;
        int w = 3;
        
        Out.p(new Solution().uniquePaths(h, w));
    }

}
