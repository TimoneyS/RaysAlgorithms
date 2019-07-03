package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 *   
 *   You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 *   
 *   The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 *   
 *   If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 *
 * Example :
 *   Example 1:
 *   ~~~~.
 *   Input: 
 *   nums = 
 *   [[1,2],
 *    [3,4]]
 *   r = 1, c = 4
 *   Output: 
 *   [[1,2,3,4]]
 *   Explanation:
 *   The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 *   ~~~~
 *   Example 2:
 *   ~~~~.
 *   Input: 
 *   nums = 
 *   [[1,2],
 *    [3,4]]
 *   r = 2, c = 4
 *   Output: 
 *   [[1,2],
 *    [3,4]]
 *   Explanation:
 *   There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 *   ~~~~
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reshape-the-matrix/description
 * @date   2019-07-03 17:39:59
 */
public class L_1170_Reshape_the_Matrix {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
