package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * 01 Matrix
 * -----------------------------------------------------------------------------
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 *
 * Example:
 *      Example 1
 *      Input:
 *      [[0,0,0],
 *       [0,1,0],
 *       [0,0,0]]
 *      Output:
 *      [[0,0,0],
 *       [0,1,0],
 *       [0,0,0]]
 *      Example 2
 *      Input:
 *      [[0,0,0],
 *       [0,1,0],
 *       [1,1,1]]
 *      Output:
 *      [[0,0,0],
 *       [0,1,0],
 *       [1,2,1]]
 *      Note:
 *      	The number of elements of the given matrix will not exceed 10,000.
 *      	There are at least one 0 in the given matrix.
 *      	The cells are adjacent in only four directions: up, down, left and right.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/01-matrix/
 * @since   2020-04-06 23:11:18
 */
public class L0542_01_Matrix {
    /**
     * 先计算所有点到左上角的 0 的最段距离，在计算所有点到右下角的 0 的距离
     * 综合取最小值
     */
    static class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            for (int i = 0; i < matrix.length; i++ ) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) continue;
                    int u = i == 0 ? m+n : matrix[i-1][j];
                    int l = j == 0 ? m+n - 1 : matrix[i][j-1];
                    matrix[i][j] = Math.min(l, u) + 1;
                }
            }

            for (int i = matrix.length-1; i >= 0; i-- ) {
                for (int j = matrix[0].length-1; j >= 0; j--) {
                    if (matrix[i][j] == 0) continue;
                    int u = i == matrix.length-1 ? m+n - 1 : matrix[i+1][j];
                    int l = j == matrix[0].length-1 ? m+n - 1 : matrix[i][j+1];

                    matrix[i][j] = Math.min(matrix[i][j], Math.min(l, u) + 1);
                }
            }
            return matrix;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
