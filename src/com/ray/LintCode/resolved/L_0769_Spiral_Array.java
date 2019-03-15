package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 螺旋数组
 * 
 * 给定一个整数 n 生成一个 n*n 的螺旋矩阵
 *
 *  1 2 3
 *  8 9 4
 *  7 6 5
 * @author rays1
 *
 */
public class L_0769_Spiral_Array {

    /**
     * 参考 L_0374_Spiral_Matrix
     * 类似贪吃蛇尽可能沿着外圈吃食物一样
     * @author rays1
     *
     */
    static class Solution {
    
        public int[][] spiralArray(int n) {
            int[][] rs = new int[n][n];
            int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
            int dir = 0, count = 0;
            int x = 0, y = -1;
            while (n != 0) {
                int tx = x + dirs[dir][0], ty = y + dirs[dir][1]; 
                if (tx < 0 || tx >= n || ty < 0 || ty >= n || rs[tx][ty] != 0) {
                    dir++;
                    dir = dir% 4;
                } else {
                    x = tx;
                    y = ty;
                    rs[x][y] = ++count;
                    if(count == n*n) break;
                }
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 0;
        for (int[] row : new Solution().spiralArray(n)) {
            Out.p(row);
        }
        
    }

}
