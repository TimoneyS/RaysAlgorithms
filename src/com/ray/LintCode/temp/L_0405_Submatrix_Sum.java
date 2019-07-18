package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code should return the coordinate of the left-up and right-down number.
 *      
 *      If there are multiple answers, you can return any of them.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *      [
 *        [1, 5, 7],
 *        [3, 7, -8],
 *        [4, -8 ,9]
 *      ]
 *      Output: [[1, 1], [2, 2]]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *      [
 *        [0, 1],
 *        [1, 0]
 *      ]
 *      Output: [[0, 0], [0, 0]]
 *      ```
 *
 * 挑战：
 *      O(*n<sup>3</sup>*) time.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/submatrix-sum/description
 * @date   2019-07-11 18:32:36
 */
public class L_0405_Submatrix_Sum {

    static class Solution {
        
        public int[][] submatrixSum(int[][] matrix) {
            
            int[][] result = new int[2][2];
            
            int m = matrix.length;
            if (m == 0) return result;
            int n = matrix[0].length;
            if (n == 0) return result;
            
            // 预先处理，计算 [0, 0] -> [i, j] 的数字之和
            int[][] sum = preSum(matrix, m, n);
            
            // 用 sx 到 tx 的行遍历数组，找到和相同的部分则说明数组该宽度上有一部分和为 0
            for (int sx = 0; sx < m; sx++) {
                for (int tx = sx+1; tx <= m; tx ++) {
                    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                    for (int ty = 0; ty <= n; ty ++) {
                        int diff = sum[tx][ty] - sum[sx][ty];
                        if (map.containsKey(diff)) {
                            int k = map.get(diff);
                            result[0][0] = sx;   result[0][1] = k;
                            result[1][0] = tx-1; result[1][1] = ty-1;
                            return result;
                        } else {
                            map.put(diff, ty);
                        }
                    }
                }
            }
            return result;
        }

        private int[][] preSum(int[][] matrix, int m, int n) {
            int[][] sum = new int[m+1][n+1];
            for (int j=0; j<=n; ++j) sum[0][j] = 0;
            for (int i=1; i<=m; ++i) sum[i][0] = 0;
            for (int i=0; i<m; ++i) {
                for (int j=0; j<n; ++j)
                    sum[i+1][j+1] = matrix[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
            }
            return sum;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
