package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 * -----------------------------------------------------------------------------
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *      Example 1
 *      Input: [10,9,2,5,3,7,101,18]
 *      Output: 4 
 *      Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 *      Note: 
 *      	There may be more than one LIS combination, it is only necessary for you to return the length.
 *      	Your algorithm should run in O(n2) complexity.
 *      Follow up: Could you improve it to O(n log n) time complexity?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @since   2020-03-11 00:08:09
 */
public class L0300_Longest_Increasing_Subsequence {
    /**
     * top 记录当前能够生成的各种长度的序列的最小终点元素, top[0] 表示长度为 1 的序列中最小的终点元素
     *
     * 如果一个 num 比 top 中最大的元素top[x]大，那么说明 num 比最长的序列的最大元素还大
     * 那么 num + 序列 x 构成的新序列将更长，那么可以令 top[x+1] = num
     *
     * 如果 num 位于 top 中的 top[i] 和 top[j] 之间，说明 num + 序列 i 构成的新序列比序列 j 更优（长度一样，终点更小）
     * 则更新 top[j] = num
     */
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int len = 0;
            int[] top = new int[nums.length+1];
            for (int num : nums) {
                int idx = Arrays.binarySearch(top, 0, len, num);
                if (idx < 0) idx = - idx - 1;
                top[idx] = num;
                if (idx == len) len ++;
            }
            return len;
        }
    }

    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
