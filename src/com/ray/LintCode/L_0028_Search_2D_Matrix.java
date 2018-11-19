package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * <p>
 * This matrix has the following properties:
 * <p>
 * <li> Integers in each row are sorted from left to right.
 * <li> The first integer of each row is greater than the last integer of the previous row.
 * 
 * @author rays1
 *
 */
public class L_0028_Search_2D_Matrix {
    static class Solution {
        
        /**
         * @param matrix: matrix, a list of lists of integers
         * @param target: An integer
         * @return: a boolean, indicate whether matrix contains target
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            // write your code here
            int row = matrix.length;
            if (row == 0) return false;
            
            int col = matrix[0].length;
            
            int l = 0;
            int r = row * col - 1;
            
            while (l <= r) {
                int mid = (l + r) / 2;
                int c = Integer.compare(target, matrix[mid/col][mid % col]);
                if (c == 0) return true;
                if (c > 0) l = mid + 1;
                else       r = mid - 1;
            }
            
            return false;
        }
        
    }
    
    public static void main(String[] args) {
        
        int target = 11;
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        
        Out.p(new Solution().searchMatrix(matrix, target));
        
    }
    
}
