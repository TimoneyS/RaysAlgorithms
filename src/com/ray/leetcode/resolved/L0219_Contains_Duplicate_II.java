package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains Duplicate II
 * -----------------------------------------------------------------------------
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example:
 *      Example 1
 *      Input: nums = [1,2,3,1], k = 3
 *      Output: true
 *      Example 2
 *      Input: nums = [1,0,1,1], k = 1
 *      Output: true
 *      Example 3
 *      Input: nums = [1,2,3,1,2,3], k = 2
 *      Output: false
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @since   2020-03-09 21:23:28
 */
public class L0219_Contains_Duplicate_II {
    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) return true;
                map.put(nums[i], i);
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
