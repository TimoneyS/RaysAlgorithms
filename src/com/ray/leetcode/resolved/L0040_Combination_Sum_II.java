package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * Note:
 * 	All numbers (including target) will be positive integers.
 * 	The solution set must not contain duplicate combinations.
 *
 * Example:
 *      Example 1
 *      Input: candidates = [10,1,2,7,6,1,5], target = 8,
 *      A solution set is:
 *      [
 *        [1, 7],
 *        [1, 2, 5],
 *        [2, 6],
 *        [1, 1, 6]
 *      ]
 *      Example 2
 *      Input: candidates = [2,5,2,1,2], target = 5,
 *      A solution set is:
 *      [
 *        [1,2,2],
 *        [5]
 *      ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/combination-sum-ii/
 * @since   2020-02-26 19:32:19
 */
public class L0040_Combination_Sum_II {
    /**
     * 深度优先搜索，
     *
     *  1
     *      1
     *          1
     */
    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> results = new ArrayList<>();
            if (candidates != null && candidates.length > 0) {
                Arrays.sort(candidates);
                List<Integer> base = new ArrayList<>();
                dfs(0, target, candidates, base, results);
            }
            return results;
        }

        private void dfs(int start, int target, int[] nums, List<Integer> base, List<List<Integer>> results) {
            if (target == 0) {
                results.add(new ArrayList<>(base));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i] == nums[i - 1]) { // 跳过重复的物品
                    continue;
                }
                if (target < nums[i]) {
                    break;
                }
                base.add(nums[i]);
                dfs(i + 1, target - nums[i], nums, base, results);
                base.remove(base.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,2,3};
        int target = 6;

        Out.p(new Solution().combinationSum2(nums, target));
    }
}