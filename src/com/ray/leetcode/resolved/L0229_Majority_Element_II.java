package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Majority Element II
 * -----------------------------------------------------------------------------
 * Given an integer array of size n, find all elements that appear more than &lfloor; n/3 &rfloor; times.
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example:
 *      Example 1
 *      Input: [3,2,3]
 *      Output: [3]
 *      Example 2
 *      Input: [1,1,1,3,3,2,2,2]
 *      Output: [1,2]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/majority-element-ii/
 * @since   2020-03-09 21:32:01
 */
public class L0229_Majority_Element_II {
    /**
     * 一次拿取三个数字
     *      如果三个数字彼此不同则全部丢弃。
     *
     * 否则将有重复的数字，计数增加，然后重新获取元素
     */
    static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int num1 = -1, num2 = -1;
            int ct1 = 0, ct2 = 0;
            for (int i : nums) {
                if (i == num1) {
                    ct1 ++;
                } else if (i == num2) {
                    ct2 ++;
                } else if (ct1 == 0) {
                    num1 = i;
                    ct1 = 1;
                } else if (ct2 == 0) {
                    num2 = i;
                    ct2 = 1;
                } else {
                    ct1 --;
                    ct2 --;
                }
            }
            ct1 = ct2 = 0;
            for (Integer i : nums) {
                if (i == num1) ct1 ++;
                if (i == num2) ct2 ++;
            }
            List<Integer> rs = new ArrayList<>();
            if (ct1 > nums.length / 3) rs.add(num1);
            if (ct2 > nums.length / 3) rs.add(num2);
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
