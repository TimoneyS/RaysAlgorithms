package com.ray.LintCode.temp;

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

    /**
     * 题目要求的是稀疏矩阵的算法，实际上使用普通矩阵算法也可以达到要求。
     * 原始的算法的复杂度为 O(pqr)， 空间复杂度为 0
     * 
     * 稀疏矩阵的特点是 0 元素较多的矩阵，因此在实际计算中，很多元素可以略过不计算。
     * 但是为了保存略过不计算的部分，需要额外空间的存储。
     * 比如记录A中每行中的每个元素的下一个非0的，可以用于计算的值的位置。
     * 这样如果行中的0元素较多，一次可以略过大多数元素。
     * 
     * 如果一个矩阵的50%的元素都是 0，那么复杂度为 O(pqr/2)，可以减少一半的无效计算。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int[][] multiply(int[][] A, int[][] B) {
            int p = A.length, q = B.length, r = B[0].length;
            int[][] rs = new int[p][r];
            
            int[][] next = new int[p][q];
            for (int i = 0; i < p; i++) {
                int prev = q;
                for (int j = q-1; j >= 0; j--) {
                    next[i][j] = prev;
                    if (A[i][j] != 0) {
                        prev = j;
                    }
                }
            }
            
            for (int i = 0; i < p; i ++) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < q; k = next[i][k]) {
                        rs[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
