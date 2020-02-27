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
            Arrays.sort(nums);
            List<List<Integer>> rs = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    twoSum(nums, i, rs);
                }
            }
            return rs;
        }

        private void twoSum(int[] numbers, int start, List<List<Integer>> rs) {
            int l = start + 1, r  = numbers.length - 1;
            while (l < r) {
                int sum = numbers[start] + numbers[l] + numbers[r];
                if (sum == 0) {
                    rs.add(Arrays.asList(numbers[start], numbers[l], numbers[r]));
                    while(l<r && numbers[l]==numbers[l+1]){
                        l++;
                    }
                    while(l<r && numbers[r]==numbers[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0){
                    l ++;
                } else {
                    r --;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Out.p(new Solution().threeSum(nums));
    }
}
