package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example:
 *      Example 1
 *      Input: nums = [4,5,6,7,0,1,2], target = 0
 *      Output: 4
 *      Example 2
 *      Input: nums = [4,5,6,7,0,1,2], target = 3
 *      Output: -1
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @since   2020-02-26 19:28:29
 */
public class L0033_Search_in_Rotated_Sorted_Array {
    /**
     *              -
     *          -     |
     *     -         |           -
     * -            |      -     |
     * ------------|------------|
     *  l          m           r
     *
     * 旋转数组可以分为两大部分，左侧和右侧，左侧值均大于右侧。
     * 如果对旋转数组进行二分搜索:
     *      首先 target 可能在左侧，也可能在右侧，构成条件：
     *          a = target > arr[0]
     *      然后 m 可能落在左侧，也可能落在右侧，构成条件：
     *          b = arr[m] > arr[0]
     *      然后 arr[m]，可能大于或小于target，构成条件：
     *          c = arr[m] > target
     *
     * 各条件下的情况如下
     * ---------------------------------------------------------
     * | a | b | c |            描述             |下次搜索范围 |
     * ---------------------------------------------------------
     * | T | T | T | 目标在左，中点在左且大于目标 | [l, m]     |
     * | T | T | F | 目标在左，中点在左且小于目标 | [m, r]     |
     * | T | F | T | 目标在左，中点在右且大于目标 | 不可能     |
     * | T | F | F | 目标在左，中点在右且小于目标 | [l, m]     |
     * ---------------------------------------------------------
     * | F | T | T | 目标在右，中点在左且大于目标 | [m, r]     |
     * | F | T | F | 目标在右，中点在左且小于目标 | 不可能     |
     * | F | F | T | 目标在右，中点在右且大于目标 | [l, m]     |
     * | F | F | F | 目标在右，中点在右且小于目标 | [m, r]     |
     * ---------------------------------------------------------
     * 总结可得
     *      a ^ b ^ c 时， 在 [l, m] 中搜索
     */
    static class Solution {
        public int search(int[] A, int target) {
            if (A.length == 0) {
                return -1;
            }
            if (A[0] == target) {
                return 0;
            }
            int l = 0, r = A.length - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (A[m] == target) {
                    return m;
                }
                if ((target > A[0]) ^ (A[m] >= A[0]) ^ (A[m] > target)) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return -1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
