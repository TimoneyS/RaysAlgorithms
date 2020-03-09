package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Search a 2D Matrix II
 * -----------------------------------------------------------------------------
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 	Integers in each row are sorted in ascending from left to right.
 * 	Integers in each column are sorted in ascending from top to bottom.
 *
 * Example:
 *      Example 1
 *      Consider the following matrix:
 *      [
 *        [1,   4,  7, 11, 15],
 *        [2,   5,  8, 12, 19],
 *        [3,   6,  9, 16, 22],
 *        [10, 13, 14, 17, 24],
 *        [18, 21, 23, 26, 30]
 *      ]
 *      Given target = 5, return true.
 *      Given target = 20, return false.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * @since   2020-03-09 21:43:18
 */
public class L0240_Search_a_2D_Matrix_II {
    /**
     * 每次搜索将矩阵分割为9个区域   其中 2 4 5 6 8 为 中点所在区域。
     *    1 | 2 | 3
     *   ---|---|---
     *    4 | 5 | 6
     *   ---|---|---
     *    7 | 8 | 9
     * 区域 5 即为中点
     * 若 中点大于或小于目标，则可以过滤一些区域
     * 在剩下的区域中继续搜索
     */
    static class Solution {

        int m;
        int n;

        int[][] matrix;
        int target;

        public boolean searchMatrix(int[][] matrix, int target) {

            this.matrix = matrix;
            this.target = target;

            m = matrix.length;
            if (m == 0) return false;
            n = matrix[0].length;
            if (n == 0) return false;

            int rows = 0  ,cols = 0;
            int rowt = m-1,colt = n-1;
            if (m == 0 || n == 0) return false;
            return search(1, rows, cols, rowt, colt) > 0;
        }

        private int search(int level, int rows, int cols, int rowt, int colt) {
            int rs = 0;
            int rowm = (rows + rowt)/2, colm = (cols + colt)/2;
            int c = Integer.compare(matrix[rowm][colm], target);

            if (rows < 0 || rowt < 0 || cols < 0 || colt < 0) {
                rs = 0;
            } else if (rows == rowt && cols == colt) {
                rs = c == 0 ? 1 : 0;
            } else if (rows <= rowt && cols <= colt) {

                rs += search(level+1, rows, colm+1, rowm-1, colt);   // area 3
                rs += search(level+1, rowm+1, cols,   rowt, colm-1); // area 7

                if (c >= 0) {
                    // target is smaller search area 1 2 4
                    rs += search(level+1, rows, cols,   rowm-1, colm-1); // area 1
                    rs += search(level+1, rows, colm,   rowm-1, colm);   // area 2
                    rs += search(level+1, rowm, cols,   rowm, colm-1);   // area 4
                }
                if (c <= 0) {
                    // target is bigger  search area       6 8 9
                    rs += search(level+1, rowm, colm+1, rowm, colt);     // area 6
                    rs += search(level+1, rowm+1, colm,   rowt, colm);   // area 8
                    rs += search(level+1, rowm+1, colm+1, rowt, colt);   // area 9
                }
                if (c == 0) rs += 1;
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
