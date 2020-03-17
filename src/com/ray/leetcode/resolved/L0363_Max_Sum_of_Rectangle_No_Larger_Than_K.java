package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Max Sum of Rectangle No Larger Than K
 * -----------------------------------------------------------------------------
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
 *
 * Example:
 *      Example 1
 *      Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 *      Output: 2 
 *      Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
 *                   and 2 is the max number no larger than k (k = 2).
 *      Note:
 *      	The rectangle inside the matrix must have an area > 0.
 *      	What if the number of rows is much larger than the number of columns?
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * @since   2020-03-17 22:45:15
 */
public class L0363_Max_Sum_of_Rectangle_No_Larger_Than_K {
    /**
     * 将左右的列固定，那么每一行的和，就是数组的一个元素。
     * 问题就转变为求一位数组的和不超过 k 的最大值
     * 然后所有左右列可能的组合都计算一遍
     */
    static class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int n = matrix.length, m = matrix[0].length;
            int rs = Integer.MIN_VALUE;
            for (int l = 0; l < m; l ++) {
                int[] row = new int[n];
                for (int r = l; r < m; r ++) {
                    for (int i = 0; i < row.length; i ++) row[i] += matrix[i][r];
                    rs = Math.max(rs, maxSub(row, k));
                }
            }
            return rs;
        }

        private int maxSub(int[] row, int k) {
            // O(rows ^ 2)
            int max = Integer.MIN_VALUE;
            for (int l = 0; l < row.length; l++) {
                int sum = 0;
                for (int r = l; r < row.length; r++) {
                    sum += row[r];
                    if (sum > max && sum <= k) max = sum;
                    if (max == k) return k; // 尽量提前
                }
            }
            return max;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
