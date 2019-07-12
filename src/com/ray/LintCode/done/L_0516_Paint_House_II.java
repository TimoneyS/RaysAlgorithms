package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      There are a row of `n` houses, each house can be painted with one of the `k` colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 *      
 *      The cost of painting each house with a certain color is represented by a `n` x `k` cost matrix. For example, `costs[0][0]` is the cost of painting house `0` with color `0`; `costs[1][2]` is the cost of painting house `1` with color `2`, and so on... Find the minimum cost to paint all houses.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      costs = [[14,2,11],[11,14,5],[14,3,10]]
 *      Output: 10
 *      Explanation:
 *      The three house use color [1,2,1] for each house. The total cost is 10.
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      costs = [[5]]
 *      Output: 5
 *      Explanation:
 *      There is only one color and one house.
 *      ```
 *
 * 挑战：
 *      Could you solve it in O(nk)?
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/paint-house-ii/description
 * @date   2019-07-11 18:33:47
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
