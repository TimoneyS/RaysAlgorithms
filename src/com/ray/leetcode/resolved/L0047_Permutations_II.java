package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Example:
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/permutations-ii/
 * @since   2020-02-27 22:15:01
 */
public class L0047_Permutations_II {
    /**
     * 字典序全排列
     *
     * 字典序是比较序列大小的一种方式: 两个序列的第一对不相等的元素的大小决定序列大小。
     * 例：序列 A = 1234 和 B = 1243 第一对不同元素为 3 < 4，则A < B
     *
     * 字典序全排列算法，寻找最小的序列，然后依次输出第二小的序列...
     *
     * 求取序列的下一个序列：
     *      1. 从右侧寻找满足 a[k] < a[k+1] 第一个 k，如果找不到，则说明当前排列是字典序最大者。
     *      2. 在a[k+1..n]中，寻找 a[l] > a[k] 的最小的 a[l]。
     *      3. 交换a[l]与a[k].
     *      4. 对于a[k+1..n]，反转该区间内元素的顺序。这样就得到了a[1...n]在字典序中的下一个排列。
     * 例 : 对于 a = {1,2,3,4,5,6,7}
     *      1. 寻找 k = 5
     *      2. 寻找a[l] = 7 l = 6
     *      3. 交换 a[6] a[7]
     *      4. 反转 a[7..7],得到新的序列 {1,2,3,4,5,7,6}
     */
    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {

            Arrays.sort(nums);

            List<List<Integer>> rs = new LinkedList<List<Integer>>();

            rs.add(toList(nums));
            while (next(nums) != -1)
                rs.add(toList(nums));
            return rs;
        }

        public List<Integer> toList(int[] nums) {
            List<Integer> list = new LinkedList<Integer>();
            for (int num : nums)
                list.add(num);
            return list;
        }

        public int next(int[] nums) {

            // 1. 寻找 k
            int k = -1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i+1]) {
                    k = i;
                    break;
                }
            }

            if (k == -1) return -1;

            // 2. 寻找 l,从右侧找到第一个大于 nums[l] > nums[k] 的 l
            int l = -1;
            for (int i = nums.length-1; i > k; i--) {
                if (nums[i] > nums[k]) {
                    l = i;
                    break;
                }
            }

            // 2. 寻找 l，从右侧找到大于 nums[k] 的最小的 nums[l]
//            int l = -1;
//
//            for (int i = k+1; i < nums.length; i++) {
//                if (nums[i] > nums[k] && (l == -1 || nums[l] > nums[i]))
//                    l = i;
//            }

            // 3. 交换 nums[k] nums[l]
            swap(nums, k, l);

            // 4. 翻转 nums[k+1..n]
            for (int i = k+1; i <= (k+nums.length)/2; i++) {
                swap(nums, i, (k+nums.length)-i);
            }

            return k;
        }

        // 交换
        public void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
