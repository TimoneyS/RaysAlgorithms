package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Rotate Image
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example:
 *      Example 1
 *      Given input matrix = 
 *      [
 *        [1,2,3],
 *        [4,5,6],
 *        [7,8,9]
 *      ],
 *      rotate the input matrix in-place such that it becomes:
 *      [
 *        [7,4,1],
 *        [8,5,2],
 *        [9,6,3]
 *      ]
 *      Example 2
 *      Given input matrix =
 *      [
 *        [ 5, 1, 9,11],
 *        [ 2, 4, 8,10],
 *        [13, 3, 6, 7],
 *        [15,14,12,16]
 *      ], 
 *      rotate the input matrix in-place such that it becomes:
 *      [
 *        [15,13, 2, 5],
 *        [14, 3, 4, 1],
 *        [12, 6, 8, 9],
 *        [16, 7,10,11]
 *      ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/rotate-image/
 * @since   2020-02-27 22:16:44
 */
public class L0048_Rotate_Image {
    /**
     * 因为是n x n的图像，因此图像可以从外到内分为若干个环，对每个环进行旋转90°的操作即可。
     * 每个环上轴对称的四个顶点顺时针算为  { r, c} -> { c, n-r} -> { n-r, n-c} -> {n-c, r}，这四个顶点按逆时针依次调换值即可
     */
    static class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int s = 0, t = n-1, row = 0;
            while (s < t) {

                for (int col = s; col < t; col++) {
                    int temp = matrix[row][col];
                    // 逆时针将轴对称的四个顶点依次调换
                    matrix[row][col]         = matrix[n-1-col][row];
                    matrix[n-1-col][row]     = matrix[n-1-row][n-1-col];
                    matrix[n-1-row][n-1-col] = matrix[col][n-1-row];
                    matrix[col][n-1-row]     = temp;

                }
                s++;
                t--;
                row++;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
