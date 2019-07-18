package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a 01 matrix, find the longest line of consecutive `1` in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 
 *        [[0,1,1,0],
 *         [0,1,1,0],
 *         [0,0,0,1]]
 *      Output: 3
 *      Explanation: (0,1) (1,2) (2,3)
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [[0,0],[1,1]]
 *      Output: 2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-line-of-consecutive-one-in-matrix/description
 * @date   2019-07-11 18:38:12
 */
public class L_0875_Longest_Line_of_Consecutive_One_in_Matrix {


    /**
     * 用 n * m * 4 个单元格记录每个点能够向 左、左上、上、右上延申的距离
     * 然后一次遍历
     * 
     * 时间复杂度 o(mn)
     * 空间复杂度 o(4mn)
     * 
     * 因为只需要前一行和本行，空间复杂度可以降为 o(8m)
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int longestLine(int[][] M) {
            int[][] dirs = {
                    { 0, -1},
                    {-1, -1},
                    {-1,  0},
                    {-1,  1},
            };
            
            int rs = 0;
            int n = M == null ? 0 : M.length, m = n == 0? 0:M[0].length;
            if (m * n == 0) return 0;
            
            int[][][] t = new int[n][m][4];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < dirs.length; k++) {
                        if (M[i][j] == 0) {
                            t[i][j][k] = 0;
                        } else {
                            int x = i + dirs[k][0], y = j + dirs[k][1];
                            t[i][j][k] = ((x < 0 || y < 0 || y >= m)  ? 1 : t[x][y][k]+1);
                            rs = Math.max(rs, t[i][j][k]);
                        }
                    }
                }
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
