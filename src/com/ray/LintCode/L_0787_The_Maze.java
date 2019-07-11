package com.ray.LintCode;

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

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
