package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定 m 个数组，每个数组都是升序排列。
 * 
 * 从不同的数组中寻找两个数字，他们的差的绝对值最大。
 * 
 * @author rays1
 *
 */
public class L_0698_Maximum_Distance_in_Arrays {

    /**
     * 保存 第一大、第二大、第一小和第二小的数字 max1, max2, min1, min2
     * 如果 max1 和 min1 不在同一行则，结果为
     *      max1 - min1
     * 否则结果为
     *      max {max1 - min2, max2 - min1}    
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int maxDiff(int[][] arrs) {
            int m = arrs == null ? 0 : arrs.length;
            if (m==0) return 0;
            
            // 2个最小值和最大值以及其所在的行
            int[][] min = {
                    {Integer.MAX_VALUE, 0},
                    {Integer.MAX_VALUE, 0}
            };
            int[][] max = {
                    {Integer.MIN_VALUE, 0},
                    {Integer.MIN_VALUE, 0}
            };
            
            for (int i = 0; i < m; i++) {
                int n = arrs[i].length;
                if (n == 0) continue;
                int l = arrs[i][0], r = arrs[i][n-1];
                
                if (l <= min[0][0]) {
                    min[1][0] = min[0][0];
                    min[1][1] = min[0][1];
                    min[0][0] = l;
                    min[0][1] = i;
                } else if (l <= min[1][0]) {
                    min[1][0] = l;
                    min[1][1] = i;
                }
                
                if (r >= max[0][0]) {
                    max[1][0] = max[0][0];
                    max[1][1] = max[0][1];
                    max[0][0] = r;
                    max[0][1] = i;
                } else if (l >= max[1][0]) {
                    max[1][0] = r;
                    max[1][1] = i;
                }
                
            }
            
            if (min[0][1] == max[0][1]) {
                return Integer.max(max[0][0] - min[1][0], max[1][0] - min[0][0]);
            } else {
                return max[0][0] - min[0][0];
            }
            
        }
    
    }
    
    public static void main(String[] args) {
        
        int[][] arrs = {
                {1,2,3,4,5,6,7,8,9}, {0,10}
        };
        
        Out.p(new Solution().maxDiff(arrs));
        
    }

}
