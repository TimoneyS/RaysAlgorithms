package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import com.ray.io.Out;

/**
 * L_0787_The_Maze 和 L_0788_The_Maze_II 的进阶版
 * 
 * 现在面板上某些位置可能有洞，洞的坐标以参数形式给出。
 * 
 * 如果能够到达终点的最短路径的按照顺序移动的 'l', 'u', 'r', 'd' 的列表
 * 如果不能到达输出 impossible
 *
 *
 * @author rays1
 *
 */
public class L_0789_The_Maze_III {

    static class Solution {
        
        int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        String[] ds = { "d", "u", "r", "l" };
        int n, m;
        
        class Path {
            String passed;
            int[] inner;
            int dist;
            public Path(String passed, int[] inner, int d) {
                this.passed = passed;
                this.inner = inner;
                dist = d;
            }
            @Override
            public String toString() {
                return passed + " " +Arrays.toString(inner) + " " + dist;
            }
        }
    
        public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
            
            n = maze.length;
            m = maze[0].length;
            
            boolean[][] marked = new boolean[n][m];
            Queue<Path> pq = new PriorityQueue<>((p1, p2) -> p1.dist == p2.dist ? p1.passed.compareTo(p2.passed) : p1.dist - p2.dist);
            pq.add(new Path("", ball, 0));
            
            while (!pq.isEmpty()) {
                Path p = pq.poll();
                if (marked[p.inner[0]][p.inner[1]]) continue;
                if (p.inner[0] == hole[0] && p.inner[1] == hole[1]) return p.passed;
                marked[p.inner[0]][p.inner[1]] = true;
                

                
               for (int i = 0; i < dirs.length; i++) {
                    pq.add(next(maze, p, hole, i));
               }
               
            }
            
            return "impossible";
        }
        
        Path next(int[][] maze, Path p, int[] hole, int i) {
            int[] dir = dirs[i];
            int[] rs = new int[]{p.inner[0], p.inner[1]};
            int dist = p.dist;
            int tx = p.inner[0] + dir[0], ty = p.inner[1] + dir[1];
            while (tx >= 0 && tx < n && ty >= 0 && ty < m && maze[tx][ty] == 0 && !(rs[0] == hole[0] && rs[1] == hole[1])) {
                rs[0] = tx;
                rs[1] = ty;
                dist ++;
                tx += dir[0];
                ty += dir[1];
            }
            return new Path(p.passed + ds[i], rs, dist);
        }
    
    }
    
    public static void main(String[] args) {
        
        int[][] maze = {
            { 0, 0, 0, 0, 0 },
            { 1, 1, 0, 0, 1 },
            { 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 1 },
            { 0, 1, 0, 0, 0 }
        };
        int[] ball = new int[] {4, 3};
        int[] hole = new int[] {0, 1};
        
        Out.p(new Solution().findShortestWay(maze, ball, hole));
        
    }

}
