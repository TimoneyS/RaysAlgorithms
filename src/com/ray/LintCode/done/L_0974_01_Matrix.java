package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *      
 *      The distance between two adjacent cells is 1.
 *      
 *      给定一个由0和1组成的矩阵，求每个单元格最近的0的距离。
 *      两个相邻细胞之间的距离是1。
 *      
 * 用例：
 *      用例 1:
 *      ```
 *      输入:
 *      [[0,0,0],
 *       [0,0,0],
 *       [0,0,0],
 *       [0,0,0],
 *       [0,0,0]]
 *      输出:
 *      [[0,0,0],
 *       [0,0,0],
 *       [0,0,0],
 *       [0,0,0],
 *       [0,0,0]]
 *      
 *      用例 2:
 *      ```
 *      输入:
 *      [[0,1,0,1,1],
 *       [1,1,0,0,1],
 *       [0,0,0,1,0],
 *       [1,0,1,1,1],
 *       [1,0,0,0,1]]
 *      输出:
 *      [[0,1,0,1,2],
 *       [1,1,0,0,1],
 *       [0,0,0,1,0],
 *       [1,0,1,1,1],
 *       [1,0,0,0,1]]
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/01-matrix/description
 * @date   2019-07-22 18:00:28
 */
public class L_0974_01_Matrix {

    /**
     * 先计算所有点到左上角的 0 的最段距离，在计算所有点到右下角的 0 的距离
     * 综合取最小值
     * 
     * @author rays1
     *
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
        
        int[][] matrix = {
                {1,1,0,1,1},
                {1,1,0,0,1},
                {0,0,0,1,0},
                {1,0,1,1,1},
                {1,0,0,0,1}
        };
//                *      输出:
//                *      [[0,1,0,1,2],
//                *       [1,1,0,0,1],
//                *       [0,0,0,1,0],
//                *       [1,0,1,1,1],
//                *       [1,0,0,0,1]]
        
        
        new Solution().updateMatrix(matrix);
        
        Out.p(matrix, "%s ");
        
    }

}
