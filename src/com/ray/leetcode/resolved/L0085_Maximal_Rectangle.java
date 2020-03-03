package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Stack;

/**
 * Maximal Rectangle
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *      Example 1
 *      Input:
 *      [
 *        [1,0,1,0,0],
 *        [1,0,1,1,1],
 *        [1,1,1,1,1],
 *        [1,0,0,1,0]
 *      ]
 *      Output: 6
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/maximal-rectangle/
 * @since   2020-03-01 23:28:57
 */
public class L0085_Maximal_Rectangle {
    /**
     * 统计每一行为基础的高度，然后基于每一行计算长方形面积
     */
    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            int m = matrix.length;
            int n = m == 0 ? 0 : matrix[0].length;
            int[][] height = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '0') {
                        height[i][j] = 0;
                    } else {
                        height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                    }
                }
            }
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
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
