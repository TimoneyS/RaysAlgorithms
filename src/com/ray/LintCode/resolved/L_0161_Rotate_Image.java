package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * n x n  的图像，顺时针旋转90°
 *
 * @author rays1
 *
 */
public class L_0161_Rotate_Image {
    
    /**
     * 
     * 因为是n x n的图像，因此图像可以从外到内分为若干个环，对每个环进行旋转90°的操作即可。
     * 每个环上轴对称的四个顶点顺时针算为  { r, c} -> { c, n-r} -> { n-r, n-c} -> {n-c, r}，这四个顶点按逆时针依次调换值即可
     * @author rays1
     *
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
        
        int n = 4;
        
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = i*n+j;
            }
        }
        
        Out.p(matrix, "%2s ");
        Out.sep();
        new Solution().rotate(matrix);
        
        Out.p(matrix, "%2s ");
        
    }
    
}
