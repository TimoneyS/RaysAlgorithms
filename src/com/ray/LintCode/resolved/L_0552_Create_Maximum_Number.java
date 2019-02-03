package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * 给定两个数组长度为 m 和 n，每个数组中包含 0-9的数字，一个数组就表示一个数字。
 * 从两个数组中创建一个长度为 k 的数字，同时必须保持数组中元素的相对顺序，返回可能构建的最大数字（由长度为k的数组构成）。
 *
 * @author rays1
 *
 */
public class L_0552_Create_Maximum_Number {

    
    /**
     * 核心思想
     *      在数组 1 中获取 0 - k 长度的数字，在数组 2 中获取 k - 0 长度的数字
     *      两种取法依次互补构成长度k的数字，从两个解合并的数字中选取最大结果。
     * 
     * 复杂度
     *      空间复杂度   O(k^2)
     *      时间复杂度   获取长度为 k 的数字复杂度为 O(k*(m+n))，共有 k 次，为 O(k^2*m*n)
     *                 合并比较的复杂度为O(k) 共k次 为  O(k^2)
     *                 因此复杂度为 O(k^2*(m+n)) + O(k^2)
     *                 大致可以认为是 立方级别
     * @author rays1
     *
     */
    static class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            if (k == 0)
                return new int[0];

            int m = nums1.length, n = nums2.length;
            if (m + n < k) return null;
            if (m + n == k) {
                int[] results = merge(nums1, nums2, k);
                return results;
            } else {
                int max = m >= k ? k : m;
                int min = n >= k ? 0 : k - n;

                int[] results = new int[k];
                for(int i=0; i < k; ++i)
                    results[i] = -0x7ffffff;
                for(int i = min; i <= max; ++i) {
                    int[] temp = merge(getMax(nums1, i), getMax(nums2, k - i), k);
                    results = isGreater(results, 0, temp, 0) ? results : temp;
                }
                return results;
            }
        }

        private int[] merge(int[] nums1, int[] nums2, int k) {
            int[] results = new int[k];
            if (k == 0) return results;
            int i = 0, j = 0;
            for(int l = 0; l < k; ++l) {
                results[l] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
            }
            return results;
        }

        private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
            for(; i < nums1.length && j < nums2.length; ++i, ++j) {
                if (nums1[i] > nums2[j])
                    return true;
                if (nums1[i] < nums2[j])
                    return false;
            }
            return i != nums1.length;
        }

        private int[] getMax(int[] nums, int k) {
            if (k == 0)
                return new int[0];
            int[] results = new int[k];
            int i = 0;
            for(int j = 0; j < nums.length; ++j) {
                while(nums.length - j + i > k && i > 0 && results[i-1] < nums[j])
                    i--;
                if (i < k)
                    results[i++] = nums[j];
            }
            return results;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
