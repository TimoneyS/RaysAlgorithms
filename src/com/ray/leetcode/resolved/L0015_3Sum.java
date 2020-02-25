package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * 3Sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/3sum/
 * @since   2020-02-24 23:32:10
 */
public class L0015_3Sum {
    /**
     * 对于任意数字 S[i] , 若存在 S[j] S[k] 使得
     *      S[i] + S[j] + S[k] = 0
     * 则
     *      S[i] =  - ( S[j] + S[k] )
     * 因此从 i 开始，问题可以转变为在 S[i+1, n-1] 中寻找数字 S[j] + S[k] = -S[i]
     * 问题可以转化为若干个 Two_Sum 问题
     */
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> rs = new ArrayList<>();
            Set<Integer> cache = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!cache.contains(nums[i])) {
                    twoSum(nums, i, -nums[i], cache, rs);
                    cache.add(nums[i]);
                }
            }
            return rs;
        }

        private void twoSum(int[] numbers, int start, int target, Set<Integer> cache, List<List<Integer>> rs) {
            Set<Integer> marked = new HashSet<>();
            Map<Integer, Integer> remain = new HashMap<>();
            for (int j = start+1; j < numbers.length; j++) {
                if (marked.contains(numbers[j]) || cache.contains(numbers[j])) {
                    continue;
                }
                if (remain.containsKey(numbers[j])) {
                    int k = remain.get(numbers[j]);
                    marked.add(numbers[k]);
                    marked.add(numbers[j]);
                    rs.add(Arrays.asList(numbers[start], numbers[k], numbers[j]));
                }
                remain.put(target-numbers[j], j);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Out.p(new Solution().threeSum(nums));
    }
}
