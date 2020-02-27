package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example:
 *      Example 1
 *      Input:
 *      [
 *       [ 1, 2, 3 ],
 *       [ 4, 5, 6 ],
 *       [ 7, 8, 9 ]
 *      ]
 *      Output: [1,2,3,6,9,8,7,4,5]
 *      Example 2
 *      Input:
 *      [
 *        [1, 2, 3, 4],
 *        [5, 6, 7, 8],
 *        [9,10,11,12]
 *      ]
 *      Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/spiral-matrix/
 * @since   2020-02-27 22:28:38
 */
public class L0054_Spiral_Matrix {
    /**
     * 用四个方向表示每次循环需要遍历的方向，并且用一个数组表示每个方向应该前进的步数
     * 循环按照四个方向前行，每个方向前进完毕，将该方向可以前进的步数 -2
     * 当某个方向无法再前进则结束循环
     */
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            ArrayList<Integer> rs = new ArrayList<>();
            int m = matrix.length;
            if (m == 0) return rs;
            int n = matrix[0].length;

            int[][] dirs = { { 0,  1}, { 1,  0}, { 0, -1}, {-1,  0} };
            int[] steps = {n, m-1, n-1, m-2};

            int idx = 0;
            int x = 0, y = -1;
            while (true) {
                if (steps[idx] <= 0) break;
                for (int i = 0; i < steps[idx]; i++) {
                    x += dirs[idx][0];
                    y += dirs[idx][1];
                    rs.add(matrix[x][y]);
                }
                steps[idx] -= 2;
                idx ++;
                idx = idx % 4;
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
