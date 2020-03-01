package com.ray.leetcode;

import com.ray.io.Out;

/**
 * Search in Rotated Sorted Array II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * Example:
 *      Example 1
 *      Input: nums = [2,5,6,0,0,1,2], target = 0
 *      Output: true
 *      Example 2
 *      Input: nums = [2,5,6,0,0,1,2], target = 3
 *      Output: false
 *      Follow up:
 *      	This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 *      	Would this affect the run-time complexity? How and why?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * @since   2020-02-29 23:22:00
 */
public class L0081_Search_in_Rotated_Sorted_Array_II {
    /**
     * 偷懒的解法
     *
     * 进行两次二分搜索
     * 判断在左侧还是右侧时，一次使用 A[0]+1 做边界，一次使用 A[0] 做边界
     * 如果 A[0] 是重复元素，第一次就能够搜索到目标，且时间复杂度正常
     * 如果 A[0] 不是重复元素，第一次搜索可能未命中
     * 这样保证是在 A[0] 是重复元素时，也能够正常搜索
     */
    static class Solution {
        public boolean search(int[] A, int target) {
            if (A.length == 0) return false;
            if (A[0] == target) return true;
            int l = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[i] != A[0]) {
                    l = i;
                    break;
                }
            }
            return binSearch(A, target, l, A.length - 1, A[l]);
        }

        private boolean binSearch(int[] A, int target, int l, int r, int border) {
            while (l <= r) {
                int m = (l + r) / 2;
                if (A[m] == target || A[l] == target || A[r] == target) {
                    return true;
                }
                if ((target > border) ^ (A[m] > border) ^ (A[m] > target)) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        int[] A = new int[] { 1, 3, 1, 1, 1};
        int target = 3;
        Out.p(new Solution().search(A, target));
    }
}
