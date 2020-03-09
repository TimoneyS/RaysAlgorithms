package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicate
 * -----------------------------------------------------------------------------
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example:
 *      Example 1
 *      Input: [1,2,3,1]
 *      Output: true
 *      Example 2
 *      Input: [1,2,3,4]
 *      Output: false
 *      Example 3
 *      Input: [1,1,1,3,3,4,3,2,4,2]
 *      Output: true
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/contains-duplicate/
 * @since   2020-03-09 21:21:29
 */
public class L0217_Contains_Duplicate {
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> s = new HashSet();
            for (int i : nums) s.add(i);
            return nums.length != s.size();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
