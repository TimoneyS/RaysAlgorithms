package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashSet;
import java.util.Set;

/**
 * Intersection of Two Arrays
 * -----------------------------------------------------------------------------
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 *      Example 1
 *      Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *      Output: [2]
 *      Example 2
 *      Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *      Output: [9,4]
 *      Note:
 *      	Each element in the result must be unique.
 *      	The result can be in any order.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @since   2020-03-12 22:52:09
 */
public class L0349_Intersection_of_Two_Arrays {
    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {

            Set<Integer> s1 =  new HashSet<>();

            for (int i : nums1) s1.add(i);

            Set<Integer> s2 =  new HashSet<>();
            for (int i : nums2) if (s1.contains(i)) s2.add(i);

            int[] rs = new int[s2.size()];
            int i = 0;
            for (int n : s2)
                rs[i++] = n;
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
