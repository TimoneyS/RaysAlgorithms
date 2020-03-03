package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *      Example 1
 *      Input: [1,2,2]
 *      Output:
 *      [
 *        [2],
 *        [1],
 *        [1,2,2],
 *        [2,2],
 *        [1,2],
 *        []
 *      ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/subsets-ii/
 * @since   2020-03-03 22:19:58
 */
public class L0090_Subsets_II {
    /**
     * 同 Subsets 类似，这里一个数字不能直接用出现与否表示，而是应该用出现的次数。
     * 因此，题目可以转换为不同位置有着不同的进位规则的特殊数字表示。
     * 然后找出所有的数字，在根据数字构建子集合即可。
     */
    static class Solution {

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> rs = new LinkedList<List<Integer>>();
            int n = nums.length;
            Arrays.sort(nums);

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]) n --;
            }

            int[] marked  = new int[n];
            int[] count   = new int[n];

            build(nums, count);

            int power = 1;
            for (int i = 0; i < count.length; i++) {
                power *= (count[i] + 1);
            }

            for (int i = 0; i < power; i++) {
                List<Integer> l = new LinkedList<Integer>();
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < marked[j]; k++) {
                        l.add(nums[j]);
                    }
                }
                rs.add(l);
                markedChange(marked, count);
            }

            return rs;
        }

        /**
         * 统计 每个数字出现的次数
         */
        public void build (int[] nums, int[] count) {
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                nums[cursor] = nums[i];
                count[cursor] ++;
                if (i < nums.length - 1 && nums[i+1] != nums[i]) {
                    cursor ++;
                }
            }
        }

        public void markedChange(int[] marked, int[] count) {
            for (int i = 0; i < marked.length; i++) {
                if (marked[i] != count[i]) {
                    marked[i] += 1;
                    return;
                }
                marked[i] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
