package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 给定整数矩阵，找到一个子数矩，其中数字之和为零。
 * 返回左上和右下数字的坐标。
 *
 * 如：
 *  [1 ,5 ,7],
 *  [3 ,7 ,-8],
 *  [4 ,-8 ,9],
 * 返回 [1, 1] , [2, 2]
 *
 * 时间复杂符 O(n^3)
 * @author rays1
 *
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
 