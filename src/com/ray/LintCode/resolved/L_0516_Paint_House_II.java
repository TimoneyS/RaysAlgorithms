package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 同之前的，解法一致，只是题目为 任意颜色
 *
 * @author rays1
 *
 */
public class L_0516_Paint_House_II {

    static class Solution {
    
        public int minCostII(int[][] costs) {
            try {
                int n = costs.length;
                int k = costs[0].length;
                int[] left = new int[k];
                int[] right = new int[k];
                for (int i = 1; i < n; i++) {
                    cover(costs[i - 1], left, right);
                    for (int j = 0; j < k; j++) {
                        costs[i][j] += Math.min(j == 0 ? Integer.MAX_VALUE : left[j - 1],
                                j == k - 1 ? Integer.MAX_VALUE : right[j + 1]);
                    }
                }

                int min = Integer.MAX_VALUE;
                for (int i : costs[n - 1]) {
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
        
        Out.p(new Solution());
        
    }

}
