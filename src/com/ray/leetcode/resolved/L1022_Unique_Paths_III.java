package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Unique Paths III
 *
 * On a 2-dimensional grid, there are 4 types of squares:
 * 	1 represents the starting square.  There is exactly one starting square.
 * 	2 represents the ending square.  There is exactly one ending square.
 * 	0 represents empty squares we can walk over.
 * 	-1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 * Example:
 *      Example 1
 *      Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 *      Output: 2
 *      Explanation: We have the following two paths: 
 *      1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 *      2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 *      Example 2
 *      Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 *      Output: 4
 *      Explanation: We have the following four paths: 
 *      1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 *      2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 *      3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 *      4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 *      Example 3
 *      Input: [[0,1],[2,0]]
 *      Output: 0
 *      Explanation: 
 *      There is no path that walks over every empty square exactly once.
 *      Note that the starting and ending square can be anywhere in the grid.
 *      Note:
 *      	1 &lt;= grid.length * grid[0].length &lt;= 20
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/unique-paths-iii/
 * @since   2020-02-27 22:39:44
 */
public class L1022_Unique_Paths_III {
    /**
     * 用 dp[i][j] 表示每个点可能存在的不同的路径值
     *      用 dfs搜索，并记录遍历路径的值，如果搜索到某个点发现当前遍历值已经在dp中
     *      则说明和已经存在的某个路径经过这个点的值相同，则后续一定会有重复路径，则当前路径终止搜索。
     */
    static class Solution {
        static int[][] DIRS = new int[][] {
                { 1, 0},
                { 0, 1},
                {-1, 0},
                { 0,-1},
        };

        public int uniquePathsIII(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            boolean[][] marked = new boolean[n][m];
            int x = 0, y = 0, pathCount = 1;
            for (int i = 0; i < n; i++ ) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        x = i;
                        y = j;
                    } else if (grid[i][j] == 0) {
                        pathCount ++;
                    }
                }
            }
            return dfs(grid, x, y, pathCount, marked);
        }

        private int dfs(int[][] grid, int i, int j, int pathCount, boolean[][] marked) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || marked[i][j] || grid[i][j] == -1) {
                return 0;
            } else if (grid[i][j] == 2) {
                return pathCount == 0 ? 1 : 0;
            }
            marked[i][j] = true;
            int rs = 0;
            for (int[] DIR : DIRS) {
                rs += dfs(grid, i + DIR[0], j + DIR[1], pathCount-1, marked);
            }
            marked[i][j] = false;
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
