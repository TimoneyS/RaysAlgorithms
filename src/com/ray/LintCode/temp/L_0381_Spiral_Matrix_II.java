package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer n, generate a square matrix filled with elements from 1 to $n^2$ in spiral order. 
 *      
 *      (The spiral rotates clockwise from the outside to the inside, referring to examples)
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      input: 2
 *      output:
 *      [
 *        [1, 2],
 *        [4, 3]
 *      ]
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      input: 3
 *      output:
 *      [
 *        [ 1, 2, 3 ],
 *        [ 8, 9, 4 ],
 *        [ 7, 6, 5 ]
 *      ]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/spiral-matrix-ii/description
 * @date   2019-07-11 18:32:21
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
        
        Out.p(new Solution());
        
    }

}
