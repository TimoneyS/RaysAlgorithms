package com.ray.LintCode.temp;

import java.util.ArrayDeque;
import java.util.Queue;

import com.ray.io.Out;

/**
 * 描述：
 *      Chell is the protagonist of the Portal Video game series developed by Valve Corporation.
 *      One day, She fell into a maze. The maze can be thought of as an array of 2D characters of size `n x m`. It has `4` kinds of rooms. `'S'` represents where Chell started(Only one starting point). `'E'` represents the exit of the maze(When chell arrives, she will leave the maze, this question may have multiple exits). `'*'` represents the room that Chell can pass. `'#'` represents a wall, Chell can not pass the wall. 
 *      She can spend a minute moving up,down,left and right to reach a room, but she can not reach the wall.
 *      Now, can you tell me how much time she needs **at least** to leave the maze?
 *      If she can not leave, return `-1`.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: 
 *      [
 *          ['S','E','*'],
 *          ['*','*','*'],
 *          ['*','*','*']
 *      ]
 *      Output: 1
 *      Explanation:
 *      Chell spent one minute walking from (0,0) to (0,1).
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: 
 *      [
 *          ['S','#','#'], 
 *          ['#','*','#'], 
 *          ['#','*','*'], 
 *          ['#','*','E']
 *      ]
 *      Output: -1
 *      Explanation:
 *      Chell can not leave the maze.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/portal/description
 * @date   2019-07-11 18:36:02
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
        
        Out.p(new Solution());
        
    }

}
