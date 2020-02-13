package com.ray.leetcode;

import com.ray.io.Out;

/**
 * `Median of Two Sorted Arrays`
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2&nbsp;cannot be both empty.
 *
 * Example:
 *      Example 1
 *      nums1 = [1, 3]
 *      nums2 = [2]
 *      The median is 2.0
 *      Example 2
 *      nums1 = [1, 2]
 *      nums2 = [3, 4]
 *      The median is (2 + 3)/2 = 2.5
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @since   2020-02-13 20:25:23
 */
public class L0004_Median_of_Two_Sorted_Arrays {
    /**
     * 分析：
     * 两个数组长度 m + n,
     * 如果 m + n 是奇数，则中位数是第 (m+n)/2 + 1 个数字
     * 如果 m + n 是偶数，则中位数是第 (m+n)/2 + 1 和第 (m+n)/2 个数字的平均值
     * <p>
     * 算法：
     * 中位数是寻找第 k 个数字，先在 A, B 中分别寻找第 k/2 大的元素
     * 比较 A[k/2] 和 B[k/2]:
     * 如果 A[k/2] = B[k/2]，说明 A[k/2] 正好是第 k 大的元素
     * 如果 A[k/2] < B[k/2]，说明
     */
    static class Solution {
        public double findMedianSortedArrays(int[] A, int[] B) {
            int n1 = A.length, n2 = B.length;
            int r1 = (n1 + n2 + 1) / 2;
            int r2 = (n1 + n2 + 2) / 2;
            return (findK(A, B, 0, 0, r1) + findK(A, B, 0, 0, r2)) / 2.0;
        }

        int findK(int[] A, int[] B, int i, int j, int k) {
            while (k > 1) {
                int t1 = (i + k / 2 - 1 < A.length) ? A[i + k / 2 - 1] : Integer.MAX_VALUE;
                int t2 = (j + k / 2 - 1 < B.length) ? B[j + k / 2 - 1] : Integer.MAX_VALUE;
                if (t1 < t2) i += k / 2;
                else j += k / 2;
                k -= k / 2;
            }
            if (i == A.length) return B[j];
            if (j == B.length) return A[i];
            return Math.min(A[i], B[j]);
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};
        Out.p(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
