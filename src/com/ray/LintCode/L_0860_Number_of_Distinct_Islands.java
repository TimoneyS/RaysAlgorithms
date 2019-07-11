package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a non-empty 2D array `grid` of 0's and 1's, an **island** is a group of `1`'s (representing land) connected 4-directionally (horizontal or vertical). You may assume all four edges of the grid are surrounded by water.
 *      
 *      Count the number of **distinct** islands. An island is considered to be the same as another if and only if one island has the same shape as another island (and not rotated or reflected).
 *      
 *      Notice that:
 *      ```
 *      11
 *      1
 *      ```
 *      and
 *      ```
 *       1
 *      11
 *      ```
 *      are considered different island, because we do not consider reflection / rotation.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 
 *        [
 *          [1,1,0,0,1],
 *          [1,0,0,0,0],
 *          [1,1,0,0,1],
 *          [0,1,0,1,1]
 *        ]
 *      Output: 3
 *      Explanation:
 *        11   1    1
 *        1        11   
 *        11
 *         1
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *        [
 *          [1,1,0,0,0],
 *          [1,1,0,0,0],
 *          [0,0,0,1,1],
 *          [0,0,0,1,1]
 *        ]
 *      Output: 1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/number-of-distinct-islands/description
 * @date   2019-07-11 18:37:41
 */
public class L_0860_Number_of_Distinct_Islands {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
