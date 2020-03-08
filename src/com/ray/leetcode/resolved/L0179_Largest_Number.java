package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Largest Number
 * -----------------------------------------------------------------------------
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example:
 *      Example 1
 *      Input: [10,2]
 *      Output: 210
 *      Example 2
 *      Input: [3,30,34,5,9]
 *      Output: 9534330
 *      Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/largest-number/
 * @since   2020-03-08 19:09:09
 */
public class L0179_Largest_Number {
    /**
     * 将数组按照特殊方式排序，比较 s1 + s2 和 s2 + s1
     * 这样能够得出两个数字拼接后，哪个数字更大
     */
    static class Solution {
        public String largestNumber(int[] nums) {
            List<String> list = new ArrayList<>(nums.length);
            for (int n : nums) list.add(String.valueOf(n));
            list.sort((s1, s2) -> (s2 + s1).compareTo(s1+s2));
            StringBuilder sb = new StringBuilder();
            for (String s : list) sb.append(s);
            if (sb.length() == 0) sb.append("0");
            while (sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {824,938,1399,5607,6973,5703,9609,4398,8247};
        Out.p(new Solution().largestNumber(nums));
    }
}
