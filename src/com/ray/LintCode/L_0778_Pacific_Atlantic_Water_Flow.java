package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an `m x n` matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 *      
 *      Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 *      
 *      Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      matrix = 
 *      [[1,2,2,3,5],
 *      [3,2,3,4,4],
 *      [2,4,5,3,1],
 *      [6,7,1,4,5],
 *      [5,1,1,2,4]]
 *      Output:
 *      [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 *      Explanation:
 *      Pacific ~ ~ ~ ~ ~
 *            ~ 1 2 2 3 5 *
 *            ~ 3 2 3 4 4 *
 *            ~ 2 4 5 3 1 *
 *            ~ 6 7 1 4 5 *
 *            ~ 5 1 1 2 4 *
 *              * * * * * Atlantic
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      matrix =
 *      [[1,2],
 *      [4,3]]
 *      Output:
 *      [[0,1],[1,0],[1,1]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/pacific-atlantic-water-flow/description
 * @date   2019-07-11 18:36:37
 */
public class L_0778_Pacific_Atlantic_Water_Flow {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
