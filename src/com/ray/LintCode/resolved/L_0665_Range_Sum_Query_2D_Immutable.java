package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 
 * 给定一个二维矩阵，给出一个矩形的左上角和右下角的坐标，返回矩形内部的数字之和。
 *
 * @author rays1
 *
 */
public class L_0665_Range_Sum_Query_2D_Immutable {

    /**
     * 比如数组就范围之和，先求出每一段之和 S(n) 则 范围之和就是 S(n1) - S(n2)
     * 二维数组同理，只是需要做一些变换。
     * 
     * @author rays1
     *
     */
    static class NumMatrix {

        int[][] inner;
        int m, n;
        
        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            inner = new int[m][n];
            
            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    int l = j == 0 ? 0 : inner[i][j-1];
                    int u = i == 0 ? 0 : inner[i-1][j];
                    int lu = i == 0 || j == 0 ? 0 : inner[i-1][j-1];
                    inner[i][j] = l + u + matrix[i][j] - lu;
                }
            }
            
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int l = col1 == 0 ? 0 : inner[row2][col1-1]; 
            int u = row1 == 0 ? 0 : inner[row1-1][col2];             
            int lu = col1 == 0 || row1 == 0 ? 0 : inner[row1-1][col1-1];
            return inner[row2][col2] - l - u + lu;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[][] matrix = {
                          {3, 0, 1, 4, 2},
                          {5, 6, 3, 2, 1},
                          {1, 2, 0, 1, 5},
                          {4, 1, 0, 1, 7},
                          {1, 0, 3, 0, 5}};
        int row1 = 2;
        int col1 = 1;
        int row2 = 4;
        int col2 = 3;
        
        NumMatrix nm = new NumMatrix(matrix);
        
        Out.p(nm.inner, "%2s ");
        Out.p(nm.sumRegion(row1, col1, row2, col2));
        
    }

}
