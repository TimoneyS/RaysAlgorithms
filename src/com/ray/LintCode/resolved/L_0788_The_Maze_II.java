package com.ray.LintCode.resolved;

import java.util.PriorityQueue;
import java.util.Queue;

import com.ray.io.Out;

/**
 * 条件参见 L_0787_The_Maze
 * 这里要寻找最短路径
 * @author rays1
 *
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
        
           int[][] maze = {
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
            };
           int[] start = {0,4};
           int[] destination = {4,4};
        
        Out.p(new Solution().shortestDistance(maze, start, destination));
        
    }

}
