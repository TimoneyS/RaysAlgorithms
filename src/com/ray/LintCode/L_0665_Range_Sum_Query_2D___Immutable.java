package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a 2D matrix, find the sum of the elements inside the rectangle defined by its upper left corner `(row1, col1)` and lower right corner `(row2, col2)`.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      [[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]
 *      sumRegion(2, 1, 4, 3)
 *      sumRegion(1, 1, 2, 2)
 *      sumRegion(1, 2, 2, 4)
 *      Output:
 *      8
 *      11
 *      12
 *      Explanation:
 *      Given matrix = 
 *      [
 *        [3, 0, 1, 4, 2],
 *        [5, 6, 3, 2, 1],
 *        [1, 2, 0, 1, 5],
 *        [4, 1, 0, 1, 7],
 *        [1, 0, 3, 0, 5]
 *      ]
 *      sumRegion(2, 1, 4, 3) = 2 + 0 + 1 + 1 + 0 + 1 + 0 + 3 + 0 = 8
 *      sumRegion(1, 1, 2, 2) = 6 + 3 + 2 + 0 = 11
 *      sumRegion(1, 2, 2, 4) = 3 + 2 + 1 + 0 + 1 + 5 = 12
 *      ```
 *      **Example2**
 *      ```
 *      Input:
 *      [[3,0],[5,6]]
 *      sumRegion(0, 0, 0, 1)
 *      sumRegion(0, 0, 1, 1)
 *      Output:
 *      3
 *      14
 *      Explanation:
 *      Given matrix = 
 *      [
 *        [3, 0],
 *        [5, 6]
 *      ]
 *      sumRegion(0, 0, 0, 1) = 3 + 0 = 3
 *      sumRegion(0, 0, 1, 1) = 3 + 0 + 5 + 6 = 14
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/range-sum-query-2d-immutable/description
 * @date   2019-07-11 18:35:16
 */
public class L_0665_Range_Sum_Query_2D___Immutable {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
