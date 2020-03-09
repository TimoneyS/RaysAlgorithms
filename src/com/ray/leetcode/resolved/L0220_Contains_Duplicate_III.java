package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.TreeSet;

/**
 * Contains Duplicate III
 * -----------------------------------------------------------------------------
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example:
 *      Example 1
 *      Input: nums = [1,2,3,1], k = 3, t = 0
 *      Output: true
 *      Example 2
 *      Input: nums = [1,0,1,1], k = 1, t = 2
 *      Output: true
 *      Example 3
 *      Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 *      Output: false
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/contains-duplicate-iii/
 * @since   2020-03-09 21:24:31
 */
public class L0220_Contains_Duplicate_III {
    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<int[]> set = new TreeSet<>((o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));

            long tt = t;
            int c = 0;
            for (int i = 0; i < nums.length; i++) {
                int[] p = new int[]{i, nums[i]};
                set.add(p);
                if (i - c > k) {
                    set.remove(new int[]{c, nums[c]});
                    c ++;
                }
                int[] u = set.higher(p);
                int[] l = set.lower(p);
                long du = u == null ? tt + 1 : (long)u[1] - (long)nums[i];
                long dl = l == null ? tt + 1 : (long)nums[i] - (long)l[1];
                if (du <= tt || dl <= tt) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
