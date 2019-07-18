package com.ray.LintCode.temp;

import java.util.Stack;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a 2D `boolean` matrix filled with `False` and `True`, find the largest rectangle containing all `True` and return its area.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      [
 *        [1, 1, 0, 0, 1],
 *        [0, 1, 0, 0, 1],
 *        [0, 0, 1, 1, 1],
 *        [0, 0, 1, 1, 1],
 *        [0, 0, 0, 0, 1]
 *      ]
 *      Output: 6
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      [
 *          [0,0],
 *          [0,0]
 *      ]
 *      Output: 0
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximal-rectangle/description
 * @date   2019-07-11 18:33:41
 */
public class L_0510_Maximal_Rectangle {

    /**
     * 统计每一行为基础的高度，然后基于每一行计算长方形面积
     * 
     * @author rays1
     *
     */
    static class Solution {
        public int maximalRectangle(boolean[][] matrix) {
            // Write your code here
            int m = matrix.length;
            int n = m == 0 ? 0 : matrix[0].length;
            int[][] height = new int[m][n + 1];
     
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (! matrix[i][j]) {
                        height[i][j] = 0;
                    } else {
                        height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                    }
                }
            }
            Out.p(height, "%s ");
     
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, maxAreaInHist(height[i]));
            }
            return max;
        }
     
        int maxAreaInHist(int[] height) {
            Stack<Integer> stack = new Stack<Integer>();
        
            int i = 0, max = 0;
         
            while (i < height.length) {
                if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                    stack.push(i++);
                } else {
                    int t = stack.pop();
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, height[t] * width);
                }
            }
            return max;
        }
    }
    
    /**
     * 复杂度为 立方级别的算法
     * 
     * 对于每个点，统计到该点高度为 h 的矩阵的宽度，计算其中的最大值
     * 因为高度最大为 m 则复杂度为 m * n * m
     * 
     * @author rays1
     *
     */
    static class Solution3 {
    
        int m, n;
        
        public int maximalRectangle(boolean[][] matrix) {
            
            try {
                m = matrix.length;
                n = matrix[0].length;
            } catch (Exception e) {
            }
            
            if (m*n == 0) {
                return 0;
            }
            
            
            int[][] mem = new int[m+1][n];
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, handle(i, j, matrix, mem));
                }
                Out.p(mem, "%s ");
                Out.sep();
            }
            return max;
            
        }

        private int handle(int i, int j, boolean[][] matrix, int[][] mem) {
            int max = 0;
            if (matrix[i][j]) {
                mem[i][j] = j > 0 ? mem[i][j-1] + 1 : 1;
                max = Math.max(max, mem[i][j]);
            }
            for (int k = i-1; k >= 0; k --) {
                int height = i-k+1;
                if (mem[k+1][j] != 0 && mem[k][j] != 0) {
                    mem[k][j] = j > 0 ? mem[k][j-1] + 1 : 1;
                    max = Math.max(max, height * mem[k][j]);
                } else {
                    mem[k][j] = 0;
                }
            }
            return max;
        }
    
    }
    
    public static void main(String[] args) {
        
//        boolean[][] matrix =  {
//                { false, false, false, false, true,  true, false },
//                { false, false,  true,  true, true, false, false },
//                { false, false,  true, false, true,  true, false },
//                { false,  true,  true,  true, true,  true, false },
//                { false, false, false, false, true, false, false },
//                { false, false, false,  true, true, false, false }
//            };
        
        boolean[][] matrix = {
                {false,  false,  true},
                {false,   true,  true},
                {true,    true,  true},
        };
        
        Out.p(new Solution().maximalRectangle(matrix));
        
    }

}
