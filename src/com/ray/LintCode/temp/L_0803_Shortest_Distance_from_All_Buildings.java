package com.ray.LintCode.temp;

import java.util.ArrayDeque;
import java.util.Queue;

import com.ray.io.Out;

/**
 * 描述：
 *      You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values **0**, **1** or **2**, where:
 *      
 *      - Each **0** marks an empty land which you can pass by freely.
 *      - Each **1** marks a building which you cannot pass through.
 *      - Each **2** marks an obstacle which you cannot pass through.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 *      Output: 7
 *      Explanation:
 *      In this example, there are three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
 *      1 - 0 - 2 - 0 - 1
 *      |   |   |   |   |
 *      0 - 0 - 0 - 0 - 0
 *      |   |   |   |   |
 *      0 - 0 - 1 - 0 - 0
 *      The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: [[1,0],[0,0]]
 *      Output: 1
 *      In this example, there is one buildings at (0,0).
 *      1 - 0
 *      |   |
 *      0 - 0
 *      The point (1,0) or (0,1) is an ideal empty land to build a house, as the total travel distance of 1 is minimal. So return 1.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/shortest-distance-from-all-buildings/description
 * @date   2019-07-11 18:36:51
 */
public class L_0803_Shortest_Distance_from_All_Buildings {

    /**
     * 从每个房屋开始bfs，取所有bfs结果的交集的和最小的一个。
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        int n, m;
        
        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        
        public int shortestDistance(int[][] grid) {
            
            n = grid.length;
            m = grid[0].length;
            
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) c++;
                }
            }
            
            int[][][] dp = new int[n][m][c+1];
            int[][] count = new int[n][m];
            
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] != 1) continue;
                    k++;
                    bfs(grid, dp, count, i, j, k);
                }
            }
            
            int x = -1, y = -1, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (count[i][j] == c && dp[i][j][0] < min) {
                        min = dp[i][j][0];
                        x = i; y = j;
                    }
                }
            }
            
            return x == -1 ? -1 : dp[x][y][0];
        }

        private void bfs(int[][] grid, int[][][] dp, int[][] count, int i, int j, int k) {
            
            boolean[][] marked = new boolean[n][m];
            
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[] {i, j});
            
            while (!q.isEmpty()) {
                int x = q.peek()[0], y = q.poll()[1];
                marked[x][y] = true;
                for (int[] dir : dirs) {
                    i = x + dir[0];
                    j = y + dir[1];
                    
                    if (i < 0 || j < 0 || i >= n || j >= m || marked[i][j] || grid[i][j] != 0) continue;
                    count[i][j] ++;
                    dp[i][j][k] = dp[x][y][k] + 1;
                    dp[i][j][0] += dp[i][j][k];
                    marked[i][j] = true;
                    q.add(new int[] {i, j});
                }
                
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
