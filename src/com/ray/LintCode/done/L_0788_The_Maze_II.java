package com.ray.LintCode.done;

import java.util.PriorityQueue;
import java.util.Queue;

import com.ray.io.Out;

/**
 * 描述：
 *      There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling `up`, `down`, `left` or `right`, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 *      
 *      Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 *      
 *      The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  
 *      	(rowStart, colStart) = (0,4)
 *      	(rowDest, colDest)= (4,4)
 *      	0 0 1 0 0
 *      	0 0 0 0 0
 *      	0 0 0 1 0
 *      	1 1 0 1 1
 *      	0 0 0 0 0
 *      
 *      	Output:  12
 *      	
 *      	Explanation:
 *      	(0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(2,0)->(2,1)->(2,2)->(3,2)->(4,2)->(4,3)->(4,4)
 *      
 *      Example 2:
 *      	Input:
 *      	(rowStart, colStart) = (0,4)
 *      	(rowDest, colDest)= (0,0)
 *      	0 0 1 0 0
 *      	0 0 0 0 0
 *      	0 0 0 1 0
 *      	1 1 0 1 1
 *      	0 0 0 0 0
 *      
 *      	Output:  6
 *      	
 *      	Explanation:
 *      	(0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(0,0)
 *      	
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/the-maze-ii/description
 * @date   2019-07-11 18:36:44
 */
public class L_0788_The_Maze_II {

    /**
     * BFS 搜索
     * 
     * 使用优先级队列保存当前所有路径，每次选择最短的路径继续前进
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
        
        public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            n = maze.length;
            m = maze[0].length;
            
            boolean[][] marked = new boolean[n][m];
            Queue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[2] - arr2[2]);
            
            pq.add(new int[] {start[0], start[1], 0});
            
            while (!pq.isEmpty()) {
                int[] p = pq.poll();
                if (marked[p[0]][p[1]]) continue;
                if (p[0] == destination[0] && p[1] == destination[1]) return p[2];
                marked[p[0]][p[1]] = true;
                
                Out.p(marked);
                Out.sep();
                
                for (int[] dir : dirs) {
                    int[] next = next(maze, p, dir);
                    pq.add(next);
                }
            }
            
            return -1;
            
        }
    
        int[] next(int[][] maze, int[] start, int[] dir) {
            int[] rs = new int[]{start[0], start[1], start[2]};
            int tx = start[0] + dir[0], ty = start[1] + dir[1];
            while (tx >= 0 && tx < n && ty >= 0 && ty < m && maze[tx][ty] == 0) {
                rs[0] = tx;
                rs[1] = ty;
                rs[2] ++;
                tx += dir[0];
                ty += dir[1];
            }
            return rs;
        }

    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
