package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Minimum Size Subarray Sum
 * -----------------------------------------------------------------------------
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 *  Example:
 *      Example 1
 *      Input: s = 7, nums = [2,3,1,2,4,3]
 *      Output: 2
 *      Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *      Follow up:
 *      If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @since   2020-03-09 00:18:03
 */
public class L0209_Minimum_Size_Subarray_Sum {
    /**
     * 去尾法
     *
     * 不断的计算数组和，当某个位置求和大于s时，便找到了一个子数组。
     * 去掉当前子数组的尾部，直到其数字之和小于s，在此基础上继续向前寻找下一个符合条件的子数组。
     *
     * 一个优化的点时，当找到了一个子数组后，向前求和时，就算再次找到符合的子数组，其长度可能也是大于先前找到的结果。
     * 因此再向前前进时，可以将尾部也同时向前移动，这样保证找到的子数组一定小于先前找到的结果。
     */
    static class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int sum = 0, m = 0, l = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (m != 0) sum -= nums[l++];
                while (sum >= s) {
                    m = m == 0 ? i-l+1 : Math.min(m, i-l+1);
                    sum -= nums[l++];
                }
            }
            return m;
        }
    }
    
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        Out.p(new Solution().minSubArrayLen(s, nums));
    }
}
