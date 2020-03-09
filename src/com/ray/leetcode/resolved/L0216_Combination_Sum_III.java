package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum III
 * -----------------------------------------------------------------------------
 * 
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Note:
 * 	All numbers will be positive integers.
 * 	The solution set must not contain duplicate combinations.
 *
 * Example:
 *      Example 1
 *      Input: k = 3, n = 7
 *      Output: [[1,2,4]]
 *      Example 2
 *      Input: k = 3, n = 9
 *      Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/combination-sum-iii/
 * @since   2020-03-09 21:20:09
 */
public class L0216_Combination_Sum_III {
    /**
     * dp[i][j][k]
     *
     * 从 i 开始，j 个数， 和为 k 的解
     *
     * dp[i][j][k] = dp[i+1][j][k] +
     *               dp[i+1][j-1][k-i]
     */
    static class Solution {
        public List<List<Integer>> combinationSum3(int m, int n) {
            List<List<Integer>>[][] dp = new List[m+1][n+1];

            dp[0][0] = new ArrayList<>();
            dp[0][0].add(new ArrayList<>());

            for (int i = 9; i > 0; i --) {
                for (int j = m; j > 0; j--) {
                    for (int k = 1; k <= n; k++) {
                        // 包含 i 的解
                        List<List<Integer>> inc = j > 0 && k >= i ? dp[j-1][k-i] : null;
                        if (inc == null) continue;
                        if (dp[j][k] == null) dp[j][k] = new ArrayList<>();
                        for (List<Integer> l : inc) {
                            List newList = new ArrayList<>(l);
                            newList.add(0, i);
                            dp[j][k].add(newList);
                        }
                    }
                }
            }
            return dp[m][n] == null ? new ArrayList<>() : dp[m][n];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
