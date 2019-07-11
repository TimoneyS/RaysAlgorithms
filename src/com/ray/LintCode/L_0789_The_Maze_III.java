package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling `up (u)`, `down (d)`, `left (l)` or `right (r)`, `but it won't stop rolling until hitting a wall`. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.
 *      
 *      Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the `shortest distance`. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). `Output the moving directions by using 'u', 'd', 'l' and 'r'`. Since there could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".
 *      
 *      The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]
 *      [4,3]
 *      [0,1]
 *      
 *      Output:
 *      "lul"
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:
 *      [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]
 *      [0,0]
 *      [1,1]
 *      [2,2]
 *      [3,3]
 *      Output:
 *      "impossible"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/the-maze-iii/description
 * @date   2019-07-11 18:36:44
 */
public class L_0789_The_Maze_III {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
