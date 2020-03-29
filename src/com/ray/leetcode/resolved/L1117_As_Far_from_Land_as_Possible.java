package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * As Far from Land as Possible
 * -----------------------------------------------------------------------------
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * If no land or water exists in the grid, return -1.
 *
 * Example:
 *      Example 1
 *      Input: [[1,0,1],[0,0,0],[1,0,1]]
 *      Output: 2
 *      Explanation: 
 *      The cell (1, 1) is as far as possible from all the land with distance 2.
 *      Example 2
 *      Input: [[1,0,0],[0,0,0],[0,0,0]]
 *      Output: 4
 *      Explanation: 
 *      The cell (2, 2) is as far as possible from all the land with distance 4.
 *      Note:
 *      	1 <= grid.length == grid[0].length <= 100
 *      	grid[i][j] is 0 or 1
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 * @since   2020-03-29 10:04:39
 */
public class L1117_As_Far_from_Land_as_Possible {
    /**
     * 多点BFS
     */
    static class Solution {
        public int maxDistance(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] DIRS = {{1, 0},{0, 1},{-1, 0},{0, -1}};

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) { for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) q.offer(i * m + j);
                }
            }
            if (q.size() == m*n || q.size() == 0) return -1;

            int dist = 0;
            while (!q.isEmpty()) {
                int i = q.peek() / m;
                int j = q.poll() % m;
                for (int[] dir : DIRS) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    dist = Math.max(grid[i][j], dist);
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0) {
                        grid[x][y] = grid[i][j] + 1;
                        q.offer(x * m + y);

                    }
                }
            }
            return dist - 1;
        }
    }
    
    public static void main(String[] args) {
        int[][] g = {
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };
        Out.p(new Solution().maxDistance(g));
    }
}
