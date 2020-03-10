package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Range Sum Query 2D - Immutable
 * -----------------------------------------------------------------------------
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *
 * Example:
 *      Example 1
 *      Given matrix = [
 *        [3, 0, 1, 4, 2],
 *        [5, 6, 3, 2, 1],
 *        [1, 2, 0, 1, 5],
 *        [4, 1, 0, 1, 7],
 *        [1, 0, 3, 0, 5]
 *      ]
 *      sumRegion(2, 1, 4, 3) -> 8
 *      sumRegion(1, 1, 2, 2) -> 11
 *      sumRegion(1, 2, 2, 4) -> 12
 *      Note:
 *      You may assume that the matrix does not change.
 *      There are many calls to sumRegion function.
 *      You may assume that row1 ≤ row2 and col1 ≤ col2.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * @since   2020-03-11 00:03:26
 */
public class L0304_Range_Sum_Query_2D___Immutable {
    /**
     * 比如数组就范围之和，先求出每一段之和 S(n) 则 范围之和就是 S(n1) - S(n2)
     * 二维数组同理，只是需要做一些变换。
     */
    static class NumMatrix {

        int[][] inner;
        int m, n;

        public NumMatrix(int[][] matrix) {
            m = matrix == null ? 0 : matrix.length;
            n = m == 0 ? 0 : matrix[0].length;
            inner = new int[m][n];

            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    int l = j == 0 ? 0 : inner[i][j-1];
                    int u = i == 0 ? 0 : inner[i-1][j];
                    int lu = i == 0 || j == 0 ? 0 : inner[i-1][j-1];
                    inner[i][j] = l + u + matrix[i][j] - lu;
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int l = col1 == 0 ? 0 : inner[row2][col1-1];
            int u = row1 == 0 ? 0 : inner[row1-1][col2];
            int lu = col1 == 0 || row1 == 0 ? 0 : inner[row1-1][col1-1];
            return inner[row2][col2] - l - u + lu;
        }
    }
    
    public static void main(String[] args) {
    }
}
