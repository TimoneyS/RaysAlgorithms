package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Largest Divisible Subset
 * -----------------------------------------------------------------------------
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 *
 * Example:
 *      Example 1
 *      Input: [1,2,3]
 *      Output: [1,2] (of course, [1,3] will also be ok)
 *      Example 2
 *      Input: [1,2,4,8]
 *      Output: [1,2,4,8]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/largest-divisible-subset/
 * @since   2020-03-17 22:48:33
 */
public class L0368_Largest_Divisible_Subset {
    /**
     * 如果a能整除 b，b能整除 c，那么 c 一定能够整除 a
     * 这样每个最长的链，只要记最后一个元素即可
     * dp[i] 表示 nums[i] 结尾的最长的链
     */
    static class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int[] dp = new int[nums.length];
            int[] p  = new int[nums.length];
            Arrays.fill(dp,  1);
            Arrays.fill( p, -1);
            Arrays.sort(nums);
            int end = -1;
            for (int i = 0; i < nums.length; i ++) {
                for (int j = i-1; j >= 0; j --) {
                    if (nums[i] % nums[j] == 0) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            p[i]  = j;
                        }
                    }
                }
                if (end == -1 || dp[end] < dp[i]) {
                    end = i;
                }
            }

            List<Integer> l = new ArrayList<>();
            while (end != -1) {
                l.add(0, nums[end]);
                end = p[end];
            }
            return l;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
