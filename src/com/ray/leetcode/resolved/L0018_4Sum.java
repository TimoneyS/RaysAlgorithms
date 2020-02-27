package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * 4Sum
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/4sum/
 * @since   2020-02-25 20:40:34
 */
public class L0018_4Sum {
    /**
    * 和 3Sum 类似
    */
    static class Solution {
        public List<List<Integer>> fourSum(int[] numbers, int target) {
            List<List<Integer>> rs = new ArrayList<>();
            Arrays.sort(numbers);
            for (int i = 0; i < numbers.length; i++) {
                if (i == 0 || numbers[i] != numbers[i-1])
                    threeSum(numbers, i, target, rs);
            }
            return rs;
        }

        private void threeSum(int[] numbers, int s1, int target, List<List<Integer>> rs) {
            for (int j = s1+1; j < numbers.length; j++) {
                if (j == s1+1 || numbers[j] != numbers[j-1]) {
                    twoSum(numbers, s1, j, target, rs);
                }
            }
        }

        private void twoSum(int[] numbers, int s1, int s2, int target, List<List<Integer>> rs) {
            int l = s2 + 1, r  = numbers.length - 1;
            while (l < r) {
                int sum = numbers[s1] + numbers[s2] + numbers[l] + numbers[r];
                if (sum == target) {
                    rs.add(Arrays.asList(numbers[s1], numbers[s2], numbers[l], numbers[r]));
                    while(l<r && numbers[l]==numbers[l+1]){
                        l++;
                    }
                    while(l<r && numbers[r]==numbers[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < target){
                    l ++;
                } else {
                    r --;
                }
            }
        }
    }

    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
