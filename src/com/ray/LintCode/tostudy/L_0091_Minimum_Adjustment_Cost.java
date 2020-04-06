package com.ray.LintCode.tostudy;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数数组，调整每个数的大小，使得相邻整数的差不能超过一个给定的值 target
 *      如果调整前的数组是A，调整后的数组是B，还需要使得 |A[i]-B[i]| 最小
 *
 * 用例：
 *      Example 1:
 *      	Input:  [1,4,2,3], target=1
 *      	Output:  2
 *
 *      Example 2:
 *      	Input:  [3,5,4,7], target=2
 *      	Output:  1
 *
 * 难度： Medium
 *
 * @author rays1
 * @link   https://www.lintcode.cn/problem/minimum-adjustment-cost/description
 * @since  2019-07-11 18:30:06
 */
public class L_0091_Minimum_Adjustment_Cost {
    /**
     * dp[i][j]
     * 表示 将第 i 位调整为 j 的最小代价
     * dp[i+1][j] = min { dp[i][j-target] ... dp[i][j+target] }
     */
    static class Solution {
        public int MinAdjustmentCost(List<Integer> A, int target) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (Integer i : A) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
            int w = A.size();
            int h = max-min+1;
            int[][] dp = new int[w][h];
            for (int i = 1; i < w; ++i) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            for (int i = 0; i < h; i++) {
                dp[0][i] = Math.abs(A.get(0) - min - i);
            }
            for (int i = 1; i < w; ++i) {
                int num = A.get(i) - min;
                for (int j = 0; j < h; j++) {
                    int t = Math.abs(num-j);
                    for (int k = Math.max(0, j-target); k <= Math.min(h-1, j+target); k++)
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + t);
                }
            }
            int rs = Integer.MAX_VALUE;
            for (int i = 0; i < h; ++i) {
                rs = Math.min(rs, dp[w - 1][i]);
            }
            return rs;
        }
    }

    public static void main(String[] args) {
        Integer[] A = { 1,7,2,6 };
        int target = 2;
        Out.p(new Solution().MinAdjustmentCost(Arrays.asList(A), target));
    }
}