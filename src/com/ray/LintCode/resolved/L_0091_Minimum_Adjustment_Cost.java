package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * Given an integer array, adjust each integers so that the difference of every
 * adjacent integers are not greater than a given number target.
 * 
 * If the array before adjustment is A, the array after adjustment is B, you
 * should minimize the sum of |A[i]-B[i]|
 * 
 * 给一个整数数组，调整每个数的大小，使得相邻的两个数的差不大于一个给定的整数target 调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。
 * 
 * @author rays1
 *
 */
public class L_0091_Minimum_Adjustment_Cost {

    static class Solution {

        /*
         * @param A: An integer array
         * 
         * @param target: An integer
         * 
         * @return: An integer
         */
        public int MinAdjustmentCost(List<Integer> A, int target) {
            int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
            for (Integer i : A) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
            
            int w = A.size();
            int h = max-min+1;
            
            int[][] f = new int[w][h];
            for (int i = 1; i < w; ++i)
                for (int j = 0; j < h; ++j)
                    f[i][j] = Integer.MAX_VALUE;
            
            for (int i = 0; i < h; i++) {
                f[0][i] = Math.abs(A.get(0) - min - i);
            }
            
            for (int i = 1; i < w; ++i) {
                int num = A.get(i) - min;
                for (int j = 0; j < h; j++) {
                    int t = Math.abs(num-j);
                    for (int k = Math.max(0, j-target); k <= Math.min(h-1, j+target); k++)
                        f[i][j] = Math.min(f[i][j], f[i-1][k] + t);
                }
            }

            int rs = Integer.MAX_VALUE;
            for (int i = 0; i < h; ++i)
                rs = Math.min(rs, f[w-1][i]);
            
            return rs;
        }

    }

    public static void main(String[] args) {

        Integer[] A = { 12,3,7,4,5,13,2,8,4,7,6,5,7 };
        
        int target = 2;

        Out.p(new Solution().MinAdjustmentCost(Arrays.asList(A), target));

    }

}
