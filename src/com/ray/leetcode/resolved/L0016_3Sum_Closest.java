package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * 3Sum Closest
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
 * to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/3sum-closest/
 * @since   2020-02-25 20:14:34
 */
public class L0016_3Sum_Closest {
    /**
     * 首先对数组排序，对于数字 S[i]，要在其右侧寻找数字 S[j], S[k] 使得 S[i] + S[j] + S[k] 最接近 target
     * 可以转化为：
     *      寻找 S[j] S[k] 使其和最接近 target - S[i]
     *
     * 可以在 i 右侧从两侧开始 设定 j = i + 1， k = n - 1
     *      如果 S[j] + S[k] > target - S[i]，说明值较大，可以尝试在 k 更小的地方寻找，则 k --
     *      如果 S[j] + S[k] < target - S[i]，说明值较小，可以尝试在 j 更大的地方寻找，则 j ++
     */
    static class Solution {
        public int threeSumClosest(int[] numbers, int target) {
            if (numbers == null || numbers.length < 3) {
                return -1;
            }
            Arrays.sort (numbers);
            int rs = numbers[0] + numbers[1] + numbers[2];
            for (int i = 0; i < numbers.length; i++) {
                int l = i + 1, r = numbers.length - 1;
                while (l < r) {
                    int t = numbers[i] + numbers[l] + numbers[r];
                    if (Math.abs(target - t) < Math.abs(target - rs)) {
                        rs = t;
                    }
                    if (t < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {-1,2,1,-4};
        int target = 1;
        Out.p(new Solution().threeSumClosest(nums, target));
    }
}
