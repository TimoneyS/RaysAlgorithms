package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * 	The number of elements initialized in nums1 and nums2 are m and n respectively.
 * 	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 *      Example 1
 *      Input:
 *      nums1 = [1,2,3,0,0,0], m = 3
 *      nums2 = [2,5,6],       n = 3
 *      Output: [1,2,2,3,5,6]
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/merge-sorted-array/
 * @since   2020-03-03 22:15:23
 */
public class L0088_Merge_Sorted_Array {
    /**
     * 因此检查 A 和 B 中的元素，如果A的元素小或者相等，则A前进
     * 如果 B 的元素小，则把所有小于A当前元素的全部插入的A中的元素之前
     */
    static class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            m --;
            n --;
            for (int cursor = A.length-1;  cursor > m; cursor --) {
                if (m < 0 && n < 0) break;
                A[cursor] = (m < 0 || A[m] < B[n]) ? B[n--] : A[m--];
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
