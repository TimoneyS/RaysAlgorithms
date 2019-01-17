package com.ray.LintCode.help;

import com.ray.io.Out;

/**
 * 给定整数 n，生成以螺旋顺序填充  1 到 n ^ 2 到元素的二位数组。
 *
 * 如 n = 3
 * 返回
 *  1  2  3
 *  8  9  4
 *  7  6  5
 * @author rays1
 *
 */
public class L_0381_Spiral_Matrix_II {

    /**
     * 参见 L_0374_Spiral_Matrix， 将添加到 List 的过程替换为设置值即可
     * @author rays1
     *
     */
    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int[][] dirs = { { 0,  1}, { 1,  0}, { 0, -1}, {-1,  0} };
            int[] steps = {n, n-1, n-1, n-2};
            
            int idx = 0;
            int num = 1;
            int x = 0, y = -1;
            while (true) {
                if (steps[idx] <= 0) break;
                for (int i = 0; i < steps[idx]; i++) {
                    x += dirs[idx][0];
                    y += dirs[idx][1];
                    matrix[x][y] = num ++;
                }
                steps[idx] -= 2;
                idx ++;
                idx = idx % 4;
            }
            
            return matrix;
        }
    }
    
    public static void main(String[] args) {
        
        int n = 3;
        
        int[][] matrix = new Solution().generateMatrix(n);
        
        Out.p(matrix, "%s ");
    }

}
