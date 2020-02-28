package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Set Matrix Zeroes
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example:
 *      Example 1
 *      Input: 
 *      [
 *        [1,1,1],
 *        [1,0,1],
 *        [1,1,1]
 *      ]
 *      Output: 
 *      [
 *        [1,0,1],
 *        [0,0,0],
 *        [1,0,1]
 *      ]
 *      Example 2
 *      Input: 
 *      [
 *        [0,1,2,0],
 *        [3,4,5,2],
 *        [1,3,1,5]
 *      ]
 *      Output: 
 *      [
 *        [0,0,0,0],
 *        [0,4,5,0],
 *        [0,3,1,0]
 *      ]
 *      Follow up:
 *      	A straight forward solution using O(mn) space is probably a bad idea.
 *      	A simple improvement uses O(m + n) space, but still not the best solution.
 *      	Could you devise a constant space solution?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/set-matrix-zeroes/
 * @since   2020-02-28 23:23:06
 */
public class L0073_Set_Matrix_Zeroes {
    /**
     * 用两个变量分别记录当前行和上一行是否需要置0
     * 算法如下:
     *      1. 每一行如果出现0则将当前行标记设置为true，并将0向上扩散
     *           否则将上一行为0的列扩散到本行
     *      2. 每一行处理完毕后，检查上一行标记，若为true，则将上一行全部设置为0
     *      3. 将当前行表级设置为上一行标记，继续处理下一行。
     */
    static class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) return;
            int n = matrix[0].length;
            boolean prev = false;
            boolean curr = false;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < n; col++) {
                    if (matrix[row][col] == 0) {
                        curr = true;
                        for (int r = row-1; r >= 0; r--) matrix[r][col] = 0;
                    } else if (row > 0 && matrix[row-1][col] == 0) {
                        matrix[row][col] = 0;
                    }
                }
                if (prev) {
                    for (int c = 0; c < n; c++) matrix[row-1][c] = 0;
                }
                prev = curr;
                curr = false;
            }
            if (prev) {
                for (int c = 0; c < n; c++) matrix[m-1][c] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
