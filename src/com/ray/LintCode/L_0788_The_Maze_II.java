package com.ray.LintCode;

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

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
