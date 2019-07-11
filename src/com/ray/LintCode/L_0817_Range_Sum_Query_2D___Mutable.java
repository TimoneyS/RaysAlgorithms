package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a 2D matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2). And the elements of the matrix could be changed.
 *      
 *      You have to implement three functions:
 *      
 *      - `NumMatrix(matrix)` The constructor.
 *      - `sumRegion(row1, col1, row2, col2)` Return the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2). 
 *      - `update(row, col, val)` Update the element at (row, col) to `val`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *        NumMatrix(
 *          [[3,0,1,4,2],
 *           [5,6,3,2,1],
 *           [1,2,0,1,5],
 *           [4,1,0,1,7],
 *           [1,0,3,0,5]]
 *        )
 *        sumRegion(2,1,4,3)
 *        update(3,2,2)
 *        sumRegion(2,1,4,3)
 *      Output:
 *        8
 *        10
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *        NumMatrix([[1]])
 *        sumRegion(0, 0, 0, 0)
 *        update(0, 0, -1)
 *        sumRegion(0, 0, 0, 0)
 *      Output:
 *        1
 *        -1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/range-sum-query-2d-mutable/description
 * @date   2019-07-11 18:37:12
 */
public class L_0817_Range_Sum_Query_2D___Mutable {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
