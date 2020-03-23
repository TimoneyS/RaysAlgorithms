package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Kth Smallest Element in a Sorted Matrix
 * -----------------------------------------------------------------------------
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *      Example 1
 *      matrix = [
 *         [ 1,  5,  9],
 *         [10, 11, 13],
 *         [12, 13, 15]
 *      ],
 *      k = 8,
 *      return 13.
 *      Note: 
 *      You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @since   2020-03-23 21:47:46
 */
public class L0378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    /**
     * 二分搜索
     */
    static class Solution {
        public int[] check(int value, int[][] matrix) {
            int[] rs = {-1, 0};
            int i = matrix.length - 1, j = 0;
            while (i >= 0 && j < matrix[0].length) {
                if (matrix[i][j] == value) rs[0] = 1;
                if (matrix[i][j] <= value) {
                    rs[1] += i + 1;
                    j += 1;
                } else {
                    i -= 1;
                }
            }
            return rs;
        }

        public int kthSmallest(int[][] matrix, int k) {
            int l = matrix[0][0];
            int r = matrix[matrix.length - 1][matrix[0].length - 1];
            while (l <= r) {
                int m = l + (r - l) / 2;
                int[] rs = check(m, matrix);
                if (rs[0] == 1 && rs[1] == k) return m;
                else if (rs[1] < k)           l = m + 1;
                else                          r = m - 1;
            }
            return l;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
