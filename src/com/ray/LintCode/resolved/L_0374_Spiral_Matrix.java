package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定m×n个元素的矩阵（m行，n列），以螺旋顺序返回矩阵的所有元素。
 * 
 * 
 * 如 ：
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * 返回 1 2 3 6 9 8 7 4 5
 * @author rays1
 *
 */
public class L_0374_Spiral_Matrix {

    /**
     * 用四个方向表示每次循环需要遍历的方向，并且用一个数组表示每个方向应该前进的步数
     * 循环按照四个方向前行，每个方向前进完毕，将该方向可以前进的步数 -2
     * 当某个方向无法再前进则结束循环
     * @author rays1
     *
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
        
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        
        List<Integer> rs = new Solution().spiralOrder(matrix);
        
        Out.p(rs);
        
    }
    
}
