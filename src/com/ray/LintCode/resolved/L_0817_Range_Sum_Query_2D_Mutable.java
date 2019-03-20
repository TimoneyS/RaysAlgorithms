package com.ray.LintCode.resolved;

/**
 * Given a 2D matrix, find the sum of the elements inside the rectangle defined by
 *  its upper left corner (row1, col1) and lower right corner (row2, col2).
 * And the elements of the matrix could be changed.
 * You have to implement three functions:
 * NumMatrix(matrix) The constructor.
 * sumRegion(row1, col1, row2, col2) Return the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * update(row, col, val) Update the element at (row, col) to val.
 *
 *
 * @author rays1
 *
 */
public class L_0817_Range_Sum_Query_2D_Mutable {

    /**
     * 数组阶段和相减 等区域和
     * 
     * @author rays1
     *
     */
    static class NumMatrix {

        int[][] inner;
        int n,m;
        
        public NumMatrix(int[][] matrix) {
            n = matrix.length;
            m = matrix[0].length;
            inner = new int[n][m];
            
            inner[0][0] = matrix[0][0];
            for (int i = 1; i < n; i++) inner[i][0] = inner[i-1][0] + matrix[i][0];
            for (int j = 1; j < m; j++) inner[0][j] = inner[0][j-1] + matrix[0][j];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    inner[i][j] = inner[i-1][j] + inner[i][j-1] - inner[i-1][j-1] + matrix[i][j];
                }
            }
            
        }
        
        public void update(int row, int col, int val) {
            int diff = val - sumRegion(row, col, row, col);
            
            for (int i = row; i < n; i++)
                for (int j = col; j < m; j++)
                    inner[i][j] += diff;
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int l  = row1 > 0 ? inner[row1-1][col2] : 0;
            int u  = col1 > 0 ? inner[row2][col1-1] : 0;
            int lu = row1 > 0 && col1 > 0 ? inner[row1-1][col1-1] : 0;
            
            return inner[row2][col2] - l - u + lu;
        }
    }
    
    public static void main(String[] args) {
        
    }

}
