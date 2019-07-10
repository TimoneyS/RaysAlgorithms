package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Write an efficient algorithm that searches for a value in an _m_ x _n_ matrix.
 *      
 *      This matrix has the following properties:
 *      
 *      - Integers in each row are sorted from left to right.
 *      - The first integer of each row is greater than the last integer of the previous row.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  [[5]],2
 *      	Output: false
 *      	
 *      	Explanation: 
 *      	false if not included.
 *      	
 *      Example 2:
 *      	Input:  [
 *          [1, 3, 5, 7],
 *          [10, 11, 16, 20],
 *          [23, 30, 34, 50]
 *      ],3
 *      	Output: true
 *      	
 *      	Explanation: 
 *      	return true if included.
 *      ```
 *
 * 挑战：
 *      O(log(n) + log(m)) time
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/search-a-2d-matrix/description
 * @date   2019-07-10 22:57:58
 */
public class L_0028_Search_a_2D_Matrix {

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
