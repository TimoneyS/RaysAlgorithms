package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a grid with only 0 and 1, find the number of corner rectangles.
 *      
 *      Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *        [
 *          [1, 0, 0, 1, 0],
 *          [0, 0, 1, 0, 1],
 *          [0, 0, 0, 1, 0],
 *          [1, 0, 1, 0, 1]
 *        ]
 *      Output: 1
 *      Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *        [
 *          [1, 1, 1],
 *          [1, 1, 1],
 *          [1, 1, 1]
 *        ]
 *      Output: 9
 *      Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
 *      ```
 *      
 *      **Example 3:**
 *      
 *      ```
 *      Input: [[1,1,1,1]]
 *      Output: 0
 *      Explanation: Rectangles must have four distinct corners.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/number-of-corner-rectangles/description
 * @date   2019-07-11 18:37:37
 */
public class L_0853_Number_Of_Corner_Rectangles {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
