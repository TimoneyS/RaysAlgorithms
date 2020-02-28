package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 	Integers in each row are sorted from left to right.
 * 	The first integer of each row is greater than the last integer of the previous row.
 *
 * Example:
 *      Example 1
 *      Input:
 *      matrix = [
 *        [1,   3,  5,  7],
 *        [10, 11, 16, 20],
 *        [23, 30, 34, 50]
 *      ]
 *      target = 3
 *      Output: true
 *      Example 2
 *      Input:
 *      matrix = [
 *        [1,   3,  5,  7],
 *        [10, 11, 16, 20],
 *        [23, 30, 34, 50]
 *      ]
 *      target = 13
 *      Output: false
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @since   2020-02-28 23:25:07
 */
public class L0074_Search_a_2D_Matrix {
    /**
     * 将二维坐标转换为一位坐标，然后使用二分搜索
     */
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length;
            if (row == 0) return false;
            int col = matrix[0].length;
            int l = 0;
            int r = row * col - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                int c = Integer.compare(target, matrix[mid/col][mid % col]);
                if (c == 0) return true;
                if (c > 0) l = mid + 1;
                else       r = mid - 1;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
