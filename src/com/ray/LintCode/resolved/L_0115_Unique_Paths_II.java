package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * 
 * @author rays1
 *
 */
public class L_0115_Unique_Paths_II {

    static class Solution {
        
        /**
         * @param obstacleGrid: A list of lists of integers
         * @return: An integer
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            
            int h = obstacleGrid.length;
            int w = obstacleGrid[0].length;
            
            int[] grid = new int[w];
            grid[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            
            for (int i = 0; i < h; i++) {
                if (obstacleGrid[i][0] == 1) grid[0] = 0;
                for (int j = 1; j < w; j++) {
                    grid[j] = (obstacleGrid[i][j] == 1) ? 0 : grid[j] + grid[j-1];
                }
            }
            return grid[w-1];
        }
        
    }
    
    public static void main(String[] args) {
        
        
        int[][] obstacleGrid = {
                {0,0},
                {0,0},
                {0,0},
                {1,0},
                {0,0}
        };
        
        Out.p(new Solution().uniquePathsWithObstacles(obstacleGrid));
        
    }

}
 