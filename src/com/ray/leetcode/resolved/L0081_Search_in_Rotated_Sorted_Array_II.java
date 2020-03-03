package com.ray.leetcode.resolved;

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
     * 因为边界的重复会导致无法判断元素在左侧还是右侧，因此先将边界去重后
     * 再二分搜索
     */
    static class Solution {
        public boolean search(int[] A, int target) {
            if (A.length == 0) return false;
            if (A[0] == target) return true;
            int l = 0, r = A.length-1;
            while ( r >= l && A[r] == A[l]) {
                r --;
            }
            while (l <= r && A[l+1] == A[l]) {
                l ++;
            }
            return binSearch(A, target, l, r, A[l]);
        }

        private boolean binSearch(int[] A, int target, int l, int r, int border) {
            while (l <= r) {
                int m = (l + r) / 2;
                if (A[m] == target) {
                    return true;
                }
                if ((target > border) ^ (A[m] >= border) ^ (A[m] > target)) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        int[] A = new int[] { 1};
        int target = 0;
        Out.p(new Solution().search(A, target));
    }
}
