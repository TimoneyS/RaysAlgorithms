package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Surface Area of 3D Shapes
 * -----------------------------------------------------------------------------
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * Return the total surface area of the resulting shapes.
 *
 * Example:
 *      Example 1
 *      Input: [[2]]
 *      Output: 10
 *      Example 2
 *      Input: [[1,2],[3,4]]
 *      Output: 34
 *      Example 3
 *      Input: [[1,0],[0,2]]
 *      Output: 16
 *      Example 4
 *      Input: [[1,1,1],[1,0,1],[1,1,1]]
 *      Output: 32
 *      Example 5
 *      Input: [[2,2,2],[2,1,2],[2,2,2]]
 *      Output: 46
 *      Note:
 *      	1 <= N <= 50
 *      	0 <= grid[i][j] <= 50
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 * @since   2020-03-25 20:04:24
 */
public class L0928_Surface_Area_of_3D_Shapes {
    static class Solution {
        public int surfaceArea(int[][] grid) {
            int[][] DIRS = {{1, 0},{-1,0}, {0, 1}, {0, -1}};
            int rs = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0) continue;
                    rs += grid[i][j] * 4 + 2;
                    for (int[] dir : DIRS) {
                        rs -= (i+dir[0] >= 0 && i+dir[0] < grid.length && j + dir[1] >= 0 && j + dir[1] < grid[i].length ?
                                Math.min(grid[i][j], grid[i+dir[0]][j+dir[1]]) : 0);
                    }
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
