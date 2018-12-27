package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * m x n 的矩阵，如果某个元素是0则将其所在的行列均设置为 0。需要原地实现。
 * 挑战
 *   1. O(m+n) 空间
 *   2. 常量级空间
 * @author rays1
 *
 */
public class L_0162_Set_Matrix_Zeroes {
    
    
    /**
     * 用两个变量分别记录当前行和上一行是否需要置0
     * 算法如下:
     *      1. 每一行如果出现0则将当前行标记设置为true，并将0向上扩散
     *           否则将上一行为0的列扩散到本行
     *      2. 每一行处理完毕后，检查上一行标记，若为true，则将上一行全部设置为0
     *      3. 将当前行表级设置为上一行标记，继续处理下一行。
     * @author rays1
     *
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
        
        int[][] matrix = {
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };
        
        new Solution().setZeroes(matrix);
        
        Out.p(matrix, "%s ");
        
    }

}
