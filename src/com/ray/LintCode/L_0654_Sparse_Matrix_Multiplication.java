package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two [Sparse Matrix](https://en.wikipedia.org/wiki/Sparse_matrix "Sparse Matrix") A and B, return the result of AB.
 *      
 *      You may assume that A's column number is equal to B's row number.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: 
 *      [[1,0,0],[-1,0,3]]
 *      [[7,0,0],[0,0,0],[0,0,1]]
 *      Output:
 *      [[7,0,0],[-7,0,3]]
 *      Explanation:
 *      A = [
 *        [ 1, 0, 0],
 *        [-1, 0, 3]
 *      ]
 *      
 *      B = [
 *        [ 7, 0, 0 ],
 *        [ 0, 0, 0 ],
 *        [ 0, 0, 1 ]
 *      ]
 *      
 *      
 *           |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 *      AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                        | 0 0 1 |
 *      ```
 *      **Example2**
 *      ```
 *      Input:
 *      [[1,0],[0,1]]
 *      [[0,1],[1,0]]
 *      Output:
 *      [[0,1],[1,0]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sparse-matrix-multiplication/description
 * @date   2019-07-11 18:35:07
 */
public class L_0654_Sparse_Matrix_Multiplication {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
