package com.ray.leetcode;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * level : Easy
 *
 * @author ray
 * @link https://leetcode-cn.com/problems/two-sum/
 * @since 2020-02-13 17:46:36
 */
public class L0001_Two_Sum {
    /**
     * 如果 a + b = target
     * 则    a = target - b
     *
     * 如果知道了 a， 那么只要在数组中寻找 target - b 即可。
     * 可以构建一个数组值到坐标的映射，然后对于每个 a 寻找否存在 target - b 到坐标的映射
     */
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> remain = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                if (remain.containsKey(numbers[i])) {
                    return new int[]{remain.get(numbers[i]), i};
                }
                remain.put(target-numbers[i], i);
            }
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
