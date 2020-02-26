package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Combination Sum
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * 	All numbers (including target) will be positive integers.
 * 	The solution set must not contain duplicate combinations.
 *
 * Example:
 *      Example 1
 *      Input: candidates = [2,3,6,7], target = 7,
 *      A solution set is:
 *      [
 *        [7],
 *        [2,2,3]
 *      ]
 *      Example 2
 *      Input: candidates = [2,3,5], target = 8,
 *      A solution set is:
 *      [
 *        [2,2,2,2],
 *        [2,3,3],
 *        [3,5]
 *      ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/combination-sum/
 * @since   2020-02-26 19:30:39
 */
public class L0039_Combination_Sum {
    /**
     * 设 dp[i][j] 表示 到 i 为止总和为 j 的解的个数
     * dp[i][j] = { dp[i][j-nums[i]], nums[i] } + dp[i-1][j]
     *
     * 实际算法中可以将空间节省为一维
     */
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>>[] dp = new List[target+1];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new ArrayList<>();
            }
            dp[0].add(new ArrayList<>());

            for (int candidate : candidates) {
                for (int j = 0; j <= target; j++) {
                    if (j >= candidate) {
                        for (List<Integer> l : dp[j - candidate]) {
                            List<Integer> temp = new ArrayList<>(l);
                            temp.add(candidate);
                            dp[j].add(temp);
                        }
                    }
                }
            }
            return dp[target];
        }
    }

    static class Solution2 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> results = new ArrayList<>();
            dfs(0, target, candidates, new ArrayList<>(), results);
            return results;
        }

        private void dfs(int start, int target, int[] nums, List<Integer> base, List<List<Integer>> rs) {
            if (target == 0) {
                rs.add(new ArrayList<>(base));
            } else if (target > 0) {
                for (int i = start; i < nums.length; i++) {
                    base.add(nums[i]);
                    dfs(i, target-nums[i], nums, base, rs);
                    base.remove(base.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {2,3,2,5};
        int target = 8;
        Out.p(new Solution().combinationSum(candidates, target));
        Out.p(new Solution2().combinationSum(candidates, target));
    }
}
