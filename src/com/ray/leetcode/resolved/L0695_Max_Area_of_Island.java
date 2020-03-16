package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Max Area of Island
 * -----------------------------------------------------------------------------
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * Example 1
 *     [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *      [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *      [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *      [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *      [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *      [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *      [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *      [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *     Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2
 *     [[0,0,0,0,0,0,0,0]]
 *     Given the above grid, return 0.
 *     Note: The length of each dimension in the given grid does not exceed 50.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/max-area-of-island/
 * @since   2020-03-15 19:30:17
 */
public class L0695_Max_Area_of_Island {
    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length, n = m == 0 ? 0 : grid[0].length;
            if (m * n == 0) return 0;
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        max = Math.max(max, dfs(grid, 1, i, j, m, n));
                    }
                }
            }
            return max;
        }

        private int dfs(int[][] grid, int size, int i, int j, int m, int n) {
            grid[i][j] = 0;
            if (i > 0   && grid[i-1][j] == 1) size = dfs(grid, size+1, i-1, j, m, n);
            if (i < m-1 && grid[i+1][j] == 1) size = dfs(grid, size+1, i+1, j, m, n);
            if (j > 0   && grid[i][j-1] == 1) size = dfs(grid, size+1, i, j-1, m, n);
            if (j < n-1 && grid[i][j+1] == 1) size = dfs(grid, size+1, i, j+1, m, n);
            return size;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
