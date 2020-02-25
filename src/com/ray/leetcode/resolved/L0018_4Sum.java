package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * 4Sum
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/4sum/
 * @since   2020-02-25 20:40:34
 */
public class L0018_4Sum {
    /**
    * 和 3Sum 类似
    */
    static class Solution {
        public List<List<Integer>> fourSum(int[] numbers, int target) {
            List<List<Integer>>   rs = new ArrayList<List<Integer>>();
            Arrays.sort(numbers);

            Set<Integer> fourMarked = new HashSet<>();
            for (int i = 0; i < numbers.length; i++) {
                if (fourMarked.contains(numbers[i])) continue;
                threeSum(numbers, i, target-numbers[i], numbers[i], fourMarked, rs);
                fourMarked.add(numbers[i]);
            }
            return rs;
        }

        public List<List<Integer>> threeSum(int[] numbers, int i, int target, int fourBase, Set<Integer> fourMarked,
                                            List<List<Integer>> rs) {

            Set<Integer> threeMarked = new HashSet<>();

            for (int j = i+1; j < numbers.length; j++) {
                if (threeMarked.contains(numbers[j])) continue;
                if (fourMarked.contains(numbers[j])) continue;

                twoSum(numbers, i, j, target-numbers[j], fourMarked, threeMarked, rs);

                threeMarked.add(numbers[j]);
            }

            return rs;
        }

        private List<List<Integer>> twoSum(int[] numbers, int i, int j, int target,
                                           Set<Integer> fourMarked, Set<Integer> threeMarked, List<List<Integer>> rs) {

            Set<Integer> marked = new HashSet<>();
            Map<Integer, Integer> remain = new HashMap<>();

            for (int k = j+1; k < numbers.length; k++) {

                if (marked.contains(numbers[k])) continue;
                if (fourMarked.contains(numbers[k])) continue;
                if (threeMarked.contains(numbers[k])) continue;

                if (remain.containsKey(numbers[k])) {
                    int l = remain.get(numbers[k]);

                    List<Integer> llist = new ArrayList<Integer>(4);
                    llist.add(numbers[i]);
                    llist.add(numbers[j]);
                    llist.add(numbers[l]);
                    llist.add(numbers[k]);

                    marked.add(numbers[k]);
                    marked.add(numbers[l]);

                    rs.add(llist);
                }

                remain.put(target-numbers[k], k);

            }

            return rs;
        }
    }


    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
