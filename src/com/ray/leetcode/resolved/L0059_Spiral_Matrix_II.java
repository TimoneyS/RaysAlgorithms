package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Spiral Matrix II
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * Example:
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @since   2020-02-27 22:33:24
 */
public class L0059_Spiral_Matrix_II {
    /**
     * 将添加到 List 的过程替换为设置值即可
     */
    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int[][] dirs = { { 0,  1}, { 1,  0}, { 0, -1}, {-1,  0} };
            int[] steps = {n, n-1, n-1, n-2};

            int idx = 0;
            int num = 1;
            int x = 0, y = -1;
            while (true) {
                if (steps[idx] <= 0) break;
                for (int i = 0; i < steps[idx]; i++) {
                    x += dirs[idx][0];
                    y += dirs[idx][1];
                    matrix[x][y] = num ++;
                }
                steps[idx] -= 2;
                idx ++;
                idx = idx % 4;
            }
            return matrix;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
