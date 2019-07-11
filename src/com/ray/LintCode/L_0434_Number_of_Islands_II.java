package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). Originally, the 2D matrix is all 0 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: n = 4, m = 5, A = [[1,1],[0,1],[3,3],[3,4]]
 *      Output: [1,1,2,2]
 *      Explanation:
 *      0.  00000
 *          00000
 *          00000
 *          00000
 *      1.  00000
 *          01000
 *          00000
 *          00000
 *      2.  01000
 *          01000
 *          00000
 *          00000
 *      3.  01000
 *          01000
 *          00000
 *          00010
 *      4.  01000
 *          01000
 *          00000
 *          00011
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: n = 3, m = 3, A = [[0,0],[0,1],[2,2],[2,1]]
 *      Output: [1,1,2,2]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/number-of-islands-ii/description
 * @date   2019-07-11 18:33:06
 */
public class L_0434_Number_of_Islands_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
