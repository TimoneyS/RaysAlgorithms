package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * m x n 的数组，以 ZigZag 的顺寻遍历元素
 * 
 * 如：
 * [
 *   [1,  2,  3,  4],
 *   [5,  6,  7,  8],
 *   [9, 10, 11, 12]
 * ]
 * 输出：1 2 5 9 6 3 4 7 10 11 8 12
 * 
 * @author rays1
 *
 */
public class L_0185_Matrix_Zigzag_Traversal {

    static class Solution {
        
        public int[] printZMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[] rs = new int[m*n];
            
            boolean direct = false;
            int i = 0, j = 0, ti, tj, k = 0;
            while (k < m * n) {
                
                rs[k++] = matrix[i][j];
                
                Out.pf("rs[%s] = matrix[%s][%s]\n", k-1, i, j);
                Out.p(rs);
                
                if (direct) {
                    ti = i + 1; tj = j - 1;
                } else {
                    ti = i - 1; tj = j + 1;
                }
                
                if (ti < 0 || ti >= m || tj < 0 || tj >= n) {
                    if (direct) { // 左下移动
                        if(i < m-1) i++; else j++;
                    } else { // 右上移动
                        if(j < n-1) j++; else i++;
                    }
                    direct = !direct;
                } else {
                    i = ti;
                    j = tj;
                }
                
            }
            
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };
        
        Out.p(new Solution().printZMatrix(matrix));
    }

}
