package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer `n`, return a spiral array of ` n * n ` sizes.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : n = 3
 *      Output : 
 *      [
 *      [1,2,3]
 *      [8,9,4]
 *      [7,6,5]
 *      ]
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : n = 5
 *      Output : 
 *      [
 *       [1,2,3,4,5]
 *       [16,17,18,19,6]
 *       [15,24,25,20,7]
 *       [14,23,22,21,8]
 *       [13,12,11,10,9]
 *      ]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/spiral-array/description
 * @date   2019-07-11 18:36:30
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
        
        Out.p(new Solution());
        
    }

}
