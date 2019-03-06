package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * L_0114_Unique_Paths 的跟进问题：
 *      现在考虑在网格种加入一些障碍物，那么还有多少种可能的路径？
 *      在矩阵中 1 表示障碍物。
 *      
 * @author rays1
 *
 */
public class L_0115_Unique_Paths_II {

    /**
     * 跟进的问题，依然采用 dp，此时障碍物的 dp 为 0
     *      如果 某个位置是 障碍物，则该点的系数为 0
     *      dp[i][j] = n1 * dp[i-1][j] + n2 * dp[i][j-1];
     *      
     * 需要注意，位于障碍物右侧和下方的点可能无法达到，在计算路径是需要注意区别，例如
     * 
     * @author rays1
     *
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
 