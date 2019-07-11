package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
 *      
 *      This matrix has the following properties:
 *      
 *      * Integers in each row are sorted from left to right.
 *      * Integers in each column are sorted from up to bottom.
 *      * No duplicate integers in each row or column.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      	[[3,4]]
 *      	target=3
 *      Output:1
 *      ```
 *      Example 2:
 *      ```
 *      Input:
 *          [
 *            [1, 3, 5, 7],
 *            [2, 4, 7, 8],
 *            [3, 5, 9, 10]
 *          ]
 *          target = 3
 *      Output:2
 *      ```
 *
 * 挑战：
 *      O(m+n) time and O(1) extra space
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/search-a-2d-matrix-ii/description
 * @date   2019-07-11 17:48:19
 */
public class L_0038_Search_a_2D_Matrix_II {

    /**
     * 每次搜索将矩阵分割为9个区域   其中 2 4 5 6 8 为 中点所在区域。
     *    1 | 2 | 3
     *   ---|---|---
     *    4 | 5 | 6
     *   ---|---|---
     *    7 | 8 | 9
     * 区域 5 即为中点
     * 若 中点大于或小于目标，则可以过滤一些区域
     * 在剩下的区域中继续搜索
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        int m;
        int n;
        
        int[][] matrix;
        int target;
        
        /**
         * @param matrix: A list of lists of integers
         * @param target: An integer you want to search in matrix
         * @return: An integer indicate the total occurrence of target in the given matrix
         */
        public int searchMatrix(int[][] matrix, int target) {
            
            this.matrix = matrix;
            this.target = target;
            
            m = matrix.length;
            if (m == 0) return 0;
            n = matrix[0].length;
            if (n == 0) return 0;
            
            int rows = 0  ,cols = 0;
            int rowt = m-1,colt = n-1;
            if (m == 0 || n == 0) return 0;
            return search(1, rows, cols, rowt, colt);
        }

        private int search(int level, int rows, int cols, int rowt, int colt) {
            int rs = 0;
            int rowm = (rows + rowt)/2, colm = (cols + colt)/2;
            int c = Integer.compare(matrix[rowm][colm], target);
            
            if (rows < 0 || rowt < 0 || cols < 0 || colt < 0) {
                rs = 0;
            } else if (rows == rowt && cols == colt) {
                rs = c == 0 ? 1 : 0;
            } else if (rows <= rowt && cols <= colt) {
                
                rs += search(level+1, rows, colm+1, rowm-1, colt);   // area 3
                rs += search(level+1, rowm+1, cols,   rowt, colm-1); // area 7
                
                if (c >= 0) {
                    // target is smaller search area 1 2 4  
                    rs += search(level+1, rows, cols,   rowm-1, colm-1); // area 1
                    rs += search(level+1, rows, colm,   rowm-1, colm);   // area 2
                    rs += search(level+1, rowm, cols,   rowm, colm-1);   // area 4
                }
                if (c <= 0) {
                    // target is bigger  search area       6 8 9
                    rs += search(level+1, rowm, colm+1, rowm, colt);     // area 6
                    rs += search(level+1, rowm+1, colm,   rowt, colm);   // area 8
                    rs += search(level+1, rowm+1, colm+1, rowt, colt);   // area 9
                }
                if (c == 0) rs += 1;

            }
            
            // Out.pf("%sserch(%s, %s, %s, %s) rs = %s\n", StringUtil.multiString("    ", level), rows, cols, rowt, colt, rs);
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        int[][] matrix = {
                { 1, 2, 2, 3, 3, 5, 7, 8},
                { 1, 2, 2, 3, 3, 6, 8, 9},
                { 2, 2, 3, 3, 3, 8, 9, 9},
                { 2, 3, 3, 3, 3, 8, 9, 9},
                { 3, 3, 4, 4, 4, 8, 9, 9},
                { 3, 4, 4, 4, 4, 8, 9, 9},
                { 3, 4, 4, 4, 4, 8, 9, 9},
                { 5, 6, 7, 7, 7, 8, 9, 9},
                { 7, 6, 7, 7, 7, 8, 9, 9},
                { 9, 9, 9, 9, 9, 9, 9, 9}
            };
        int target = 3;
        
//        int[][] matrix = {
//                {1},
//                {1}
//        };
//        int target = 1;
        
        Out.p(new Solution().searchMatrix(matrix, target));
        
    }

}
