package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.LinkedList;
import java.util.List;

/**
 * Permutations
 *
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/permutations/
 * @since   2020-02-27 22:13:52
 */
public class L0046_Permutations {
    static class Solution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> rs = new LinkedList<List<Integer>>();
            permute(rs, new LinkedList<>(), nums);
            return rs;
        }

        void permute(List<List<Integer>> rs, List<Integer> base, int[] nums) {
            if (nums.length == 0) {
                rs.add(base);
                return;
            }
            for (int num : nums ) {
                int[] newNum = new int[nums.length - 1];
                int index = 0;
                for (int j : nums) {
                    if (j != num) {
                        newNum[index++] = j;
                    }
                }
                List<Integer> newBase = new LinkedList<Integer>(base);
                newBase.add(num);
                permute(rs, newBase, newNum);
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
