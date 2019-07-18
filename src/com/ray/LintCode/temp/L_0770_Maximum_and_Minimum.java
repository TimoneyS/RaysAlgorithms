package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a matrix, return the maximum number and the minimum number.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : 
 *      [
 *       [1,2,3],
 *       [4,3,2],
 *       [6,4,4]
 *      ]
 *      Output : [6,1]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-and-minimum/description
 * @date   2019-07-11 18:36:31
 */
public class L_0770_Maximum_and_Minimum {

    static class Solution {
    
        public int[] maxAndMin(int[][] matrix) {
            
            if (matrix.length == 0) return new int[]{};
            int[] rs = {Integer.MIN_VALUE, Integer.MAX_VALUE};
            
            for (int[] row : matrix) {
                for (int n : row) {
                    rs[0] = Math.max(rs[0], n);
                    rs[1] = Math.min(rs[1], n);                    
                }
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
