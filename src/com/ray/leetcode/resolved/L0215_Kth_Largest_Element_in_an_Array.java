package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Kth Largest Element in an Array
 * -----------------------------------------------------------------------------
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *      Example 1
 *      Input: [3,2,1,5,6,4] and k = 2
 *      Output: 5
 *      Example 2
 *      Input: [3,2,3,1,2,4,5,5,6] and k = 4
 *      Output: 4
 *      Note: 
 *      You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @since   2020-03-09 21:17:34
 */
public class L0215_Kth_Largest_Element_in_an_Array {
    /**
     * 快速选择算法，和快速排序原理类似。
     *
     * 任意挑选元素，调整数组使得元素左侧的元素都较小而右侧的元素都较大。
     * 然后判断元素的索引需要从左侧还是右侧继续操作，直到选择的元素正好位于期望位置。
     */
    static class Solution {

        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, nums.length-k, 0, nums.length-1);
        }

        private int quickSelect(int[] nums, int k, int s, int t) {
            int l = s + 1, r = t;
            while (true) {
                while (r > s && nums[s] <= nums[r]) r --;
                while (l < t && nums[l] < nums[s]) l ++;
                if (r <= l) break;
                swap(nums, r, l);
            }
            swap(nums, r, s);
            if (r == k) return nums[r];
            else if (r > k) return quickSelect(nums, k, s, r-1);
            else return quickSelect(nums, k, r+1, t);
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
