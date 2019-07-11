package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a non-empty 2D array `grid` of `0`'s and `1`'s, an **island** is a group of `1`'s (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *      
 *      Count the number of **distinct** islands. An island is considered to be the same as another if they have the same shape, or have the same shape after **rotation** (90, 180, or 270 degrees only) or **reflection** (left/right direction or up/down direction).
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [[1,1,0,0,0],[1,0,0,0,0],[0,0,0,0,1],[0,0,0,1,1]]
 *      Output: 1
 *      Explanation:
 *      The island is look like this:
 *      11000
 *      10000
 *      00001
 *      00011
 *      
 *      Notice that:
 *      11
 *      1
 *      and
 *       1
 *      11
 *      are considered same island shapes. Because if we make a 180 degrees clockwise rotation on the first island, then two islands will have the same shapes.
 *      ```
 *      
 *      
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [[1,1,1,0,0],[1,0,0,0,1],[0,1,0,0,1],[0,1,1,1,0]]
 *      Output: 2
 *      Explanation:
 *      The island is look like this:
 *      11100
 *      10001
 *      01001
 *      01110
 *      
 *      Here are the two distinct islands:
 *      111
 *      1
 *      and
 *      1
 *      1
 *      
 *      Notice that:
 *      111
 *      1
 *      and
 *      1
 *      111
 *      are considered same island shapes. Because if we flip the first array in the up/down direction, then they have the same shapes.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/number-of-distinct-islands-ii/description
 * @date   2019-07-11 18:36:52
 */
public class L_0804_Number_of_Distinct_Islands_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
