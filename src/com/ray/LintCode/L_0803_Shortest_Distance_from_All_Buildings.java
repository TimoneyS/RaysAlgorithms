package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values **0**, **1** or **2**, where:
 *      
 *      - Each **0** marks an empty land which you can pass by freely.
 *      - Each **1** marks a building which you cannot pass through.
 *      - Each **2** marks an obstacle which you cannot pass through.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 *      Output: 7
 *      Explanation:
 *      In this example, there are three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
 *      1 - 0 - 2 - 0 - 1
 *      |   |   |   |   |
 *      0 - 0 - 0 - 0 - 0
 *      |   |   |   |   |
 *      0 - 0 - 1 - 0 - 0
 *      The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: [[1,0],[0,0]]
 *      Output: 1
 *      In this example, there is one buildings at (0,0).
 *      1 - 0
 *      |   |
 *      0 - 0
 *      The point (1,0) or (0,1) is an ideal empty land to build a house, as the total travel distance of 1 is minimal. So return 1.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/shortest-distance-from-all-buildings/description
 * @date   2019-07-11 18:36:51
 */
public class L_0803_Shortest_Distance_from_All_Buildings {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
