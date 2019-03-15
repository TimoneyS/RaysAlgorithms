package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.Queue;

import com.ray.io.Out;

/**
 * Chell 是 Valve Corporation 开发的 Portal 视频游戏系列中的主角。
 * 一天，她掉进了一个迷宫。迷宫可以看作是一个大小为 n x m 二维字符数组。
 * 它有4种房间。'S'代表Chell从哪开始（只有一个起点）。'E'代表迷宫的出口（当chell抵达时，她将离开迷宫，该题目可能会有多个出口）。
 * '*'代表这个房间Chell可以经过。'#'代表一堵墙，Chell不能经过墙。
 * 
 * 她可以每次上下左右移动到达一个房间，花费一分钟时间，但是不能到达墙。
 * 现在，你能告诉我她最少需要多少时间离开这个迷宫吗？
 * 如果她不能离开，返回-1
 *
 * @author rays1
 *
 */
public class L_0750_Portal {

    /**
     * 用 dp 导致溢出，这里投机使用Maze直接保存整数，需要注意得是，如果路径过长，导致路径转换为 char 正好是 * 或者 E，导致误判
     * @author rays1
     *
     */
    static class Solution {
    
        public int Portal(char[][] Maze) {
            
            int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
            int x = 0, y = 0;
            int n = Maze.length, m = Maze[0].length;
            
            // 寻找起点
            for (int i = 0; i < Maze.length; i++) {
                for (int j = 0; j < Maze[0].length; j++) {
                    if (Maze[i][j] == 'S') {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }
            
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(x*m+y);
            Maze[x][y] = 100;
            
            while (!queue.isEmpty()) {
                x = queue.peek() / m;
                y = queue.poll() % m;
                for (int[] dir : dirs) {
                    int i = x + dir[0], j = y + dir[1];
                    if (i >= 0 && i < n && j >= 0 && j < m) {
                        if (Maze[i][j] == 'E') return Maze[x][y]-99;
                        if (Maze[i][j] != '*') continue;
                        Maze[i][j] = (char) (Maze[x][y] + 1);
                        queue.add(i*m+j);
                    }
                    
                }
            }
            
            return -1;
        }
    
    }
    
    public static void main(String[] args) {
        
        char[][] Maze = {
                "*#*****".toCharArray(),
                "*#S###*".toCharArray(),
                "***#E**".toCharArray(),
        };
        
        Out.p(new Solution().Portal(Maze));
        
    }

}
