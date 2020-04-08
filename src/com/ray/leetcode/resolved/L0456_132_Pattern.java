package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Stack;

/**
 * 132 Pattern
 * -----------------------------------------------------------------------------
 * 
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such
 * that i j k and ai k j. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * Note: n will be less than 15,000.
 *
 * Example:
 *      Example 1
 *      Input: [1, 2, 3, 4]
 *      Output: False
 *      Explanation: There is no 132 pattern in the sequence.
 *      Example 2
 *      Input: [3, 1, 4, 2]
 *      Output: True
 *      Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 *      Example 3
 *      Input: [-1, 3, 2, 0]
 *      Output: True
 *      Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/132-pattern/
 * @since   2020-04-07 22:26:20
 */
public class L0456_132_Pattern {
    /**
     * 对于任意的 a3 = nums[i]
     *      a2 可以取 nums[i] 右则的小于 nums[i] 的最大值
     *      a1 可以取 nums[i] 左则的小于 a2 的值即可
     *
     * 在处理到 nums[i] 时，如果已经找到了一对 a3 和 a2 此时有三种情况
     *      nums[i] < a2 找到
     *      nums[i] > a3 则可以更新 a3 和 a2 的值， a3 替换为  nums[i]，a2 可以替换为栈中的小于nums[i] 的最大值
     *      nums[i] 在 a2 和 a3 之间，插入栈中备用
     */
    static class Solution {
        public boolean find132pattern(int[] nums) {
            int a2 = Integer.MIN_VALUE;
            Stack<Integer> s = new Stack<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] < a2) return true;
                while (!s.isEmpty() && nums[i] > s.peek()) {
                    a2 = s.pop();
                }
                s.push(nums[i]);
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
