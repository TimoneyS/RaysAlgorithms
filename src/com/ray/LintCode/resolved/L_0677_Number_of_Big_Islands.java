package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个 布尔矩阵，0表示海洋，1表示岛屿。如果两个1相邻，那么表示他们位于同一个岛屿。只考虑上下左右相邻。
 * 寻找所有面积大于等于 k 的岛屿的数量。
 *
 * @author rays1
 *
 */
public class L_0677_Number_of_Big_Islands {

    static class Solution {
    
        public int numsofIsland(boolean[][] grid, int k) {
            
            int m = grid.length, n = m == 0 ? 0 : grid[0].length;
            if (m * n == 0) return 0;
            
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] ) {
                        int size = -1;
                        if ( (size = dfs(grid, 1, i, j, m, n)) >= k) {
                            count++;
                        }
                        Out.p(grid, "%5s ");
                        Out.p(size);
                        Out.sep();
                    }
                }
            }
            
            return count;
        }
        
        private int dfs(boolean[][] grid, int size, int i, int j, int m, int n) {
            grid[i][j] = false;
            if (i > 0   && grid[i-1][j]) size = dfs(grid, size+1, i-1, j, m, n);
            if (i < m-1 && grid[i+1][j]) size = dfs(grid, size+1, i+1, j, m, n);
            if (j > 0   && grid[i][j-1]) size = dfs(grid, size+1, i, j-1, m, n);
            if (j < n-1 && grid[i][j+1]) size = dfs(grid, size+1, i, j+1, m, n);
            return size;
        }
        
    }
    
    public static void main(String[] args) {
        boolean t = true;
        boolean f = false;
        
        boolean[][] grid = {
                {t,t,f,t,f},
                {f,f,f,t,t},
                {t,t,f,t,f},
                {t,t,f,f,f},
                {f,f,f,f,t},
        };
        int k = 5;
        
        Out.p(new Solution().numsofIsland(grid, k));
        
    }

}
