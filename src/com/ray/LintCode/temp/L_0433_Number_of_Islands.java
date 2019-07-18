package com.ray.LintCode.temp;

import java.util.ArrayDeque;
import java.util.Queue;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a boolean 2D matrix, `0` is represented as the sea, `1` is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 *      
 *      Find the number of islands.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      [
 *        [1,1,0,0,0],
 *        [0,1,0,0,1],
 *        [0,0,0,1,1],
 *        [0,0,0,0,0],
 *        [0,0,0,0,1]
 *      ]
 *      Output:
 *      3
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:
 *      [
 *        [1,1]
 *      ]
 *      Output:
 *      1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/number-of-islands/description
 * @date   2019-07-11 18:33:05
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
