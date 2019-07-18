package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      There are a row of `n` houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that **no two adjacent houses have the same color,** and you need to cost the least. Return the minimum cost. 
 *      
 *      The cost of painting each house with a certain color is represented by a `n` x `3` cost matrix. For example, `costs[0][0]` is the cost of painting house `0` with color red; `costs[1][2]` is the cost of painting house `1` with color green, and so on... Find the minimum cost to paint all houses.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [[14,2,11],[11,14,5],[14,3,10]]
 *      Output: 10
 *      Explanation: blue green blue, 2 + 5 + 3 = 10
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [[1,2,3],[1,4,6]]
 *      Output: 3
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/paint-house/description
 * @date   2019-07-11 18:33:46
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
