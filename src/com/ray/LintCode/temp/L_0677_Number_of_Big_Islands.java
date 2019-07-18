package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a boolean 2D matrix, `0` is represented as the sea, `1` is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider `up/down/left/right` adjacent.
 *      
 *      Find the number of islands that size bigger or equal than `K`.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: 
 *      [[1,1,0,0,0],[0,1,0,0,1],[0,0,0,1,1],[0,0,0,0,0],[0,0,0,0,1]]
 *      2
 *      Output: 2
 *      Explanation:
 *      the 2D grid is
 *      [
 *        [1, 1, 0, 0, 0],
 *        [0, 1, 0, 0, 1],
 *        [0, 0, 0, 1, 1],
 *        [0, 0, 0, 0, 0],
 *        [0, 0, 0, 0, 1]
 *      ]
 *      there are two island which size is equals to 3.
 *      ```
 *      **Example2**
 *      ```
 *      Input: 
 *      [[1,0],[0,1]]
 *      1
 *      Output: 2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/number-of-big-islands/description
 * @date   2019-07-11 18:35:22
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
        
        Out.p(new Solution());
        
    }

}
