package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.Queue;

import com.ray.io.Out;

/**
 * 433. Number of Islands
 * 
 * 岛屿数
 * 
 * 给定 boolean 2D 矩阵， 0(false) 表示为海，1(true) 表示为岛。
 * 如果两个 1 相邻，我们认为它们在同一个岛上。
 * 只考虑上/下/左/右相邻，找出岛屿的数量。
 *
 * @author rays1
 *
 */
public class L_0433_Number_of_Islands {

    /**
     * 遍历，遇到任何岛屿将岛屿数+1
     * 然后基于该岛屿开始图的搜索，将遇到的所有岛屿降为海。
     * @author rays1
     *
     */
    static class Solution {
    
        int m, n;
        
        public int numIslands(boolean[][] grid) {
            
            int num = 0;
            
            m = grid.length;
            if (m == 0) return 0;
            n = grid[0].length;
            if (n == 0) return 0;
            
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j]) {
                        num ++;
                        
                        grid[i][j] = false;
                        bfs(grid, i, j);
                    }
                }
            }
            
            return num;
        }
        
        public void bfs(boolean[][] grid, int i, int j) {
            Queue<Integer> queue = new ArrayDeque<>();
            
            queue.add(i*n+j);
            while(!queue.isEmpty()) {
                int c = queue.poll();
                int x = c / n;
                int y = c % n;        
                
                if (x > 0   && grid[x-1][y]) { grid[x-1][y] = false;queue.add((x-1)*n+y); }   // 上
                if (x < m-1 && grid[x+1][y]) { grid[x+1][y] = false;queue.add((x+1)*n+y); }    // 下
                if (y > 0   && grid[x][y-1]) { grid[x][y-1] = false;queue.add(x*n+y-1); }      // 左
                if (y < n-1 && grid[x][y+1]) { grid[x][y+1] = false;queue.add(x*n+y+1); }      // 右
                
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        
        boolean[][] grid = {
                {true,true,false,false,false},
                {false,true,false,false,true},
                {false,false,false,true,true},
                {false,false,false,false,false},
                {false,false,false,false,true}
                };
        
        Out.p(new Solution().numIslands(grid));
        
    }

}
