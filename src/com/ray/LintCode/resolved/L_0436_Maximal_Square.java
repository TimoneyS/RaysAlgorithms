package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定填充 0 和 1 的二位数组，找到包含全 1 的最大正方形并返回其面积。
 *
 * 如：
 *     1 0 1 0 0
 *     1 0 1 1 1
 *     1 1 1 1 1
 *     1 0 0 1 0
 *     
 * 最大的正方形是 [1,2] 到 [2,3] 返回 4
 *
 * @author rays1
 *
 */
public class L_0436_Maximal_Square {

    /**
     * 一个正方形的范围，可以用其对角线的起点和终点坐标来表示。左上角为起点，右下角为终点。
     * 
     * 假设 width[i, j] 表示以 [i, j] 为终点的方块的最大宽度，则可以有以下几种情况：
     *      1. matrix[i][j] == 0 ， width[i][j] 必然为 0
     *      2. matrix[i][j] != 0
     *          width[i][j] = min { width[i][j-1],  width[i-1][j],  width[i-1][j-1]}
     *          matrix[i][j] 若要组成正方形，其宽度不能大于左、上、左上三个点为终点的最大正方形宽度。 
     * 
     * 证明过程比较麻烦，略过
     * 
     * 所以算法可以根据此点，从左上到右下，遍历数组依次更新 width 数组即可。
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int maxSquare(int[][] matrix) {
            
            int m = matrix.length;
            int n = matrix[0].length;
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) continue;
                    int lu = i > 0 && j > 0 ? matrix[i-1][j-1] : 0; // 左上
                    int l  = j > 0          ? matrix[i][j-1]   : 0; // 左
                    int u  = i > 0          ? matrix[i-1][j]   : 0; // 上
                    int min = Math.min(Math.min(l, u), lu);
                    if (min != 0)  matrix[i][j] = min + 1;
                    max = Math.max(max, matrix[i][j]);
                }
            }
            
            return max * max;
        }
    
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 1, 0, 0},
                { 1, 0, 1, 1, 1},
                { 1, 1, 1, 1, 1},
                { 1, 0, 0, 1, 0}
        };
        
        Out.p(new Solution().maxSquare(matrix));
        
    }

}
