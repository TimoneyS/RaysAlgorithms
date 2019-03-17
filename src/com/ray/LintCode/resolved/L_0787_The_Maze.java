package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 一个球在一个只有空地和墙的迷宫之中。球可以沿着空地上下左右滚动，直到碰到墙壁。碰到墙壁之后，球可以选择换一个方向。
 * 给定球的开始坐标和终点坐标，判断球能够在终点停下。
 * 迷宫用二维数组表示，0 表示空地，1 表示墙。
 * @author rays1
 *
 */
public class L_0787_The_Maze {

    /**
     * dfs 搜索，标记经过的顶点防止重复搜索
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        int[][] dirs = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        
        int n, m;
        
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            n = maze.length;
            m = maze[0].length;
            
            return helper(maze, new boolean[n][m], start, destination);
        }
        
        boolean helper(int[][] maze, boolean[][] marked, int[] start, int[] destination) {
            
            if (start[0] == destination[0] && start[1] == destination[1]) return true;
            if (!marked[start[0]][start[1]]) {
                marked[start[0]][start[1]] = true;
                return  helper(maze, marked, next(maze, start, dirs[0]), destination)  ||
                        helper(maze, marked, next(maze, start, dirs[1]), destination) ||
                        helper(maze, marked, next(maze, start, dirs[2]), destination) ||
                        helper(maze, marked, next(maze, start, dirs[3]), destination);
                
            } else {
                return false;
            }
        }
        
        int[] next(int[][] maze, int[] start, int[] dir) {
            int i = start[0], j = start[1];
            int tx = i, ty = j;
            while (tx >= 0 && tx < n && ty >= 0 && ty < m && maze[tx][ty] == 0) {
                i = tx;
                j = ty;
                tx += dir[0];
                ty += dir[1];
            }
            return new int[] {i, j};
        }
    
    }
    
    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0},
        };
        int[] start = {0, 4};
        int[] destination = {4, 4};
        Out.p(new Solution().hasPath(maze, start, destination));
        
    }

}
