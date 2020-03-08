package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Number of Islands
 * -----------------------------------------------------------------------------
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example:
 *      Example 1
 *      Input:
 *      11110
 *      11010
 *      11000
 *      00000
 *      Output: 1
 *      Example 2
 *      Input:
 *      11000
 *      11000
 *      00100
 *      00011
 *      Output: 3
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/number-of-islands/
 * @since   2020-03-08 21:53:08
 */
public class L0200_Number_of_Islands {
    /**
     * 遍历，遇到任何岛屿将岛屿数+1
     * 然后基于该岛屿开始图的搜索，将遇到的所有岛屿降为海。
     */
    static class Solution {
        int m, n;
        public int numIslands(char[][] grid) {
            int num = 0;
            m = grid.length;
            if (m == 0) return 0;
            n = grid[0].length;
            if (n == 0) return 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        num ++;
                        grid[i][j] = '0';
                        bfs(grid, i, j);
                    }
                }
            }
            return num;
        }

        public void bfs(char[][] grid, int i, int j) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i*n+j);
            while(!queue.isEmpty()) {
                int c = queue.poll();
                int x = c / n;
                int y = c % n;
                if (x > 0   && grid[x-1][y] == '1') { grid[x-1][y] = '0';queue.add((x-1)*n+y); }   // 上
                if (x < m-1 && grid[x+1][y] == '1') { grid[x+1][y] = '0';queue.add((x+1)*n+y); }    // 下
                if (y > 0   && grid[x][y-1] == '1') { grid[x][y-1] = '0';queue.add(x*n+y-1); }      // 左
                if (y < n-1 && grid[x][y+1] == '1') { grid[x][y+1] = '0';queue.add(x*n+y+1); }      // 右
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
