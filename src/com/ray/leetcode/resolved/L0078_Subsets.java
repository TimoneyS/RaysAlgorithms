package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/subsets/
 * @since   2020-02-29 22:48:08
 */
public class L0078_Subsets {
    /**
     * 所有的数字是唯一的，那么在子集中一个数字要么出现，要么不出现。
     * 因此一共的可能有 2^n 种
     *
     * 如果用 1 表示出现，0 表示不出现，那么每个子集合将对应一个二进制的数字。
     * 因此只要找到所有数字，然后构建对应的集合即可。
     */
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> rs = new LinkedList<List<Integer>>();
            for (int i = 0; i < Math.pow(2, n); i++) {
                List<Integer> l = new ArrayList<Integer>();
                int j = 0, mark = i;
                while (mark != 0) {
                    if ((mark & 1) == 1) {
                        l.add(nums[j]);
                    }
                    mark >>= 1;
                    j++;
                }
                rs.add(l);
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
