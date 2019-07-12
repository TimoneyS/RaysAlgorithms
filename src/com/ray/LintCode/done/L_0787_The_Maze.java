package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling `up`, `down`, `left` or `right`, `but it won't stop rolling until hitting a wall`. When the ball stops, it could choose the next direction.
 *      
 *      Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 *      
 *      The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      map = 
 *      [
 *       [0,0,1,0,0],
 *       [0,0,0,0,0],
 *       [0,0,0,1,0],
 *       [1,1,0,1,1],
 *       [0,0,0,0,0]
 *      ]
 *      start = [0,4]
 *      end = [3,2]
 *      Output:
 *      false
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      map = 
 *      [[0,0,1,0,0],
 *       [0,0,0,0,0],
 *       [0,0,0,1,0],
 *       [1,1,0,1,1],
 *       [0,0,0,0,0]
 *      ]
 *      start = [0,4]
 *      end = [4,4]
 *      Output:
 *      true
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/the-maze/description
 * @date   2019-07-11 18:36:43
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
        
        Out.p(new Solution());
        
    }

}
