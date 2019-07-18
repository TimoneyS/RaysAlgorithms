package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two arrays of length `m` and `n` with digits `0-9` representing two numbers. Create the maximum number of length `k <= m + n` from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the `k` digits. You should try to optimize your time and space complexity.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：nums1 = [3, 4, 6, 5]， nums2 = [9, 1, 2, 5, 8, 3]，k = 5
 *      Output：[9, 8, 6, 5, 3]
 *      Explanation：
 *      select [9,8,3] from the first array and select[6,5] from the second array
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：nums1 = [6, 7]， nums2 = [6, 0, 4]，k = 5
 *      Output：[6, 7, 6, 0, 4]
 *      Explanation：
 *      select [6,7] from the first array and select[6,0,4] from the second array
 *      ```
 *      
 *      **Example 3:**
 *      ```
 *      Input：nums1 = [3, 9]， nums2 = [8, 9]，k = 3
 *      Output：[9, 8, 9]
 *      Explanation：
 *      select [9] from the first array and select[8, 9] from the second array
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/create-maximum-number/description
 * @date   2019-07-11 18:33:58
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
