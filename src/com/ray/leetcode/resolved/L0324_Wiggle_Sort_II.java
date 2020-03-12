package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * Wiggle Sort II
 * -----------------------------------------------------------------------------
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example:
 *      Example 1
 *      Input: nums = [1, 5, 1, 1, 6, 4]
 *      Output: One possible answer is [1, 4, 1, 5, 1, 6].
 *      Example 2
 *      Input: nums = [1, 3, 2, 2, 3, 1]
 *      Output: One possible answer is [2, 3, 1, 3, 1, 2].
 *      Note:
 *      You may assume all input has valid answer.
 *      Follow Up:
 *      Can you do it in O(n) time and/or in-place with O(1) extra space?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/wiggle-sort-ii/
 * @since   2020-03-12 22:46:12
 */
public class L0324_Wiggle_Sort_II {
    /**
     * 先快速搜索，找到中间数
     *
     * 然后比中间数小的从右侧放入奇数位
     * 比中间数大的从左侧放入偶数位
     * 等于中间数的，放入剩余位置
     */
    static class Solution {

        public void wiggleSort(int[] nums) {
            int[] ans = new int[nums.length];
            int mid = quickSelect(nums, nums.length/2, 0, nums.length-1);
            Arrays.fill(ans, mid);
            int l, r = 1;
            l = nums.length - 2 + (nums.length % 2);
            for (int num : nums) {
                if (num < mid) {
                    ans[l] = num;
                    l -= 2;
                } else if (num > mid) {
                    ans[r] = num;
                    r += 2;
                }
            }
            System.arraycopy(ans, 0, nums, 0, nums.length);
        }

        int quickSelect(int[] nums, int rank, int s, int t) {
            int l = s + 1, r = t;
            while (true) {
                while (r > s && nums[s] <= nums[r]) r --;
                while (l < t && nums[l] < nums[s]) l ++;
                if (r > l) swap(nums, r, l);
                else break;
            }
            swap(nums, r, s);
            if (r == rank)     return nums[r];
            else if (r > rank) return quickSelect(nums, rank, s, r-1);
            else               return quickSelect(nums, rank, r+1, t);
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
