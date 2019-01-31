package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * 一行 n 个屋子，每个房子可以是红蓝绿三个颜色之一。不同房屋不同颜色涂色的时间是不同的，相邻的房子颜色不同。
 * 
 * 矩阵中保存了每个屋子需要涂成的颜色所需消耗的时间。
 *
 * 例如 costs[0][0] 是房屋 0 涂成红色所需的时间 costs[1][2] 是房屋 1 涂成绿色所需的时间 寻找最小的涂色时间
 *
 * @author rays1
 *
 */
public class L_0515_Paint_House {

    /**
     * 
     * 对于每个元素，加上上一行的左侧和右侧所有元素中的最小元素
     * 为了减少寻找最小元素的复杂度。使用 left 和 right 记录从左到右 和 从右到左的 过程中的最小值
     * 
     * 算法复杂度为平方级别
     * 
     * @author rays1
     *
     */
    static class Solution {

        public int minCost(int[][] costs) {

            try {
                int m = costs.length;
                int n = costs[0].length;
                int[] left = new int[n];
                int[] right = new int[n];
                for (int i = 1; i < m; i++) {
                    cover(costs[i - 1], left, right);
                    for (int j = 0; j < n; j++) {
                        costs[i][j] += Math.min(j == 0 ? Integer.MAX_VALUE : left[j - 1],
                                j == n - 1 ? Integer.MAX_VALUE : right[j + 1]);
                    }
                }

                int min = Integer.MAX_VALUE;
                for (int i : costs[m - 1]) {
                    min = Math.min(i, min);
                }
                return min;
            } catch (Exception e) {
                return 0;
            }

        }

        private void cover(int[] is, int[] left, int[] right) {
            int t = is.length - 1;
            left[0] = is[0];
            right[t] = is[t];

            for (int i = 1; i < right.length; i++) {
                left[i] = Math.min(is[i], left[i - 1]);
            }

            for (int i = t - 1; i >= 0; i--) {
                right[i] = Math.min(is[i], right[i + 1]);
            }

        }

    }

    public static void main(String[] args) {

        int[][] costs = { { 14, 2, 11 }, { 11, 14, 5 }, { 14, 3, 10 } };

        Out.p(new Solution().minCost(costs));

    }

}
