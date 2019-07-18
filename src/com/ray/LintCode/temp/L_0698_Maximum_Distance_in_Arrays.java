package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `m` arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the difference between two integers `a` and `b` to be their absolute difference `|a-b|`. Your task is to find the maximum difference.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: [[1,2,3], [4,5], [1,2,3]]
 *      Output: 4
 *      Explanation:
 *      One way to reach the maximum difference 4 is to pick 1 in the first or third array and pick 5 in the second array.
 *      ```
 *      **Example2**
 *      ```
 *      Input: [[1,2,3,4,5,6,7,8,9],[0,10]]
 *      Output: 9
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-distance-in-arrays/description
 * @date   2019-07-11 18:35:36
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
        
        Out.p(new Solution());
        
    }

}
