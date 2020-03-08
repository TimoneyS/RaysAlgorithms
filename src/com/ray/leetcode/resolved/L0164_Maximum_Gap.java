package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Maximum Gap
 * -----------------------------------------------------------------------------
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Return 0 if the array contains less than 2 elements.
 *
 * Example:
 *      Example 1
 *      Input: [3,6,9,1]
 *      Output: 3
 *      Explanation: The sorted form of the array is [1,3,6,9], either
 *                   (3,6) or (6,9) has the maximum difference 3.
 *      Example 2
 *      Input: [10]
 *      Output: 0
 *      Explanation: The array contains less than 2 elements, therefore return 0.
 *      Note:
 *      	You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 *      	Try to solve it in linear time/space.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/maximum-gap/
 * @since   2020-03-07 22:04:34
 */
public class L0164_Maximum_Gap {
    static class Solution {
        public int maximumGap(int[] nums) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            int max = 0;
            for (int i : nums) {
                if (map.get(i) == 1) {
                    map.remove(i);
                } else {
                    map.put(i, map.get(i)-1);
                }
                Integer u = map.higherKey(i);
                Integer l = map.lowerKey(i);
                if (u != null) {
                    max = Math.max(u - i, max);
                }
                if (l != null) {
                    max = Math.max(i-l, max);
                }
            }
            return max;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {100,3,2,1};
        Out.p(new Solution().maximumGap(nums));
    }
}
