package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Majority Element
 * -----------------------------------------------------------------------------
 * Given an array of size n, find the majority element. The majority element is the element that appears more than &lfloor; n/2 &rfloor; times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example:
 *      Example 1
 *      Input: [3,2,3]
 *      Output: 3
 *      Example 2
 *      Input: [2,2,1,1,1,2,2]
 *      Output: 2
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/majority-element/
 * @since   2020-03-08 17:32:22
 */
public class L0169_Majority_Element {
    /**
     * 如果一个数字出现的次数超过数组大小的一半，那么连续出现的数字中一定有该数字。
     * 否则该数字一定和其他数字交替出现。
     *
     * 设计算法每次读取两个数字，如果这两个数字彼此不同，就将这两个数字都丢弃。
     * 这样当两两不同的数字都丢弃之后，剩下的数字一定是出现次数超过数组一半的那个数字。
     */
    static class Solution {
        public int majorityElement(int[] nums) {
            int num = 0;
            int ct = 0;
            for (Integer i : nums) {
                if (ct == 0) {
                    num = i;
                }
                if (i.equals(num)) {
                    ct ++;
                } else {
                    ct --;
                }
            }
            return num;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
